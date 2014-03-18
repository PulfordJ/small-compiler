import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import symboltable.Scope;
import symboltable.FunctionSymbol;
import symboltable.Symbol;
import symboltable.VariableSymbol;

import javax.print.PrintException;
import java.io.IOException;
import java.util.*;

/**
 * Generate the forth source code and parse tree.
 * User: john
 * Date: 1/24/14
 * Time: 12:47 PM
 */
public class SourceGenerationVisitor extends InfixBaseVisitor<String> {

    //List of variables found during initial pass.
    private final List<VariableSymbol> variableSymbols;

    //The generated forthSource.
    private String forthSource = "";

    //The root context, used to generate graphical parse trees.
    private InfixParser.BoilerplateContext rootCtx;

    //Flag for whether we are parsing in float mode.
    private boolean floatMode;

    //The parser the visitor is acting on.
    private final Parser parser;

    //A map that allows accessing the scope for a given context.
    private final ParseTreeProperty<Scope> scopes;

    //The currentScope of a given context, handled by sequence visits.
    private Scope currentScope;

    /**
     * Constructor
     *
     * @param parser          the parser the visitor is acting on
     * @param scopes          a map that allows access the scope for a given context.
     * @param variableSymbols List of variables found during initial pass.
     * @param floatMode       Flag for whether we are parsing in float mode.
     */
    public SourceGenerationVisitor(InfixParser parser, ParseTreeProperty<Scope> scopes, List<VariableSymbol> variableSymbols, boolean floatMode) {
        super();
        this.scopes = scopes;
        this.variableSymbols = variableSymbols;
        this.parser = parser;
        this.floatMode = floatMode;
    }

    /**
     * Prints the postscript parsetree to a .ps file with the given name
     *
     * @param filename used to generate a file of the form <filename>.ps
     */
    public void outputPSGraphToFile(String filename) {
        try {
            rootCtx.save(Arrays.asList(parser.getRuleNames()), filename + ".ps");
        } catch (IOException | PrintException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    /**
     * Returns the compiled forth source.
     *
     * @return the compiled forth source.
     */
    public String getForthSource() {
        return forthSource;
    }

    //The methods below correspond to the labeled grammar specified in src/main/antlr/Infix.g4

    @Override
    public String visitBoilerplate(@NotNull InfixParser.BoilerplateContext ctx) {
        //Declare all functions.
        ListIterator<InfixParser.FuncContext> funcIt = ctx.func().listIterator();

        String funcDefinitions = "";
        while (funcIt.hasNext()) {
            funcDefinitions += visit(funcIt.next());
            funcDefinitions += " ";
        }


        //Declare all variable names.
        String varDeclarations = "";

        for (VariableSymbol variableSymbol : variableSymbols) {
            varDeclarations += "variable ";
            varDeclarations += variableSymbol.getCompiledVariableName();
            varDeclarations += " ";
        }


        //Generate program code.
        String formatString = "%s%s: program %s ; program";
        forthSource = String.format(formatString, varDeclarations, funcDefinitions, visit(ctx.sequence()));

        //This is to allow generation of the postscript parse tree at a later time.
        rootCtx = ctx;

        return forthSource;
    }

    @Override
    public String visitSequence(@NotNull InfixParser.SequenceContext ctx) {

        currentScope = scopes.get(ctx);

        //Build source from statements inside sequence.
        String innerSource = "";
        List<InfixParser.StatementContext> statementContexts = ctx.statement();
        for (InfixParser.StatementContext statementContext : statementContexts) {
            innerSource += visit(statementContext) + " ";
        }

        //If no statements, return empty string.
        if (!innerSource.equals("")) {
            innerSource = innerSource.substring(0, innerSource.length() - 1);
        }

        return innerSource;
    }

    @Override
    public String visitStatementConditional(@NotNull InfixParser.StatementConditionalContext ctx) {
        return visit(ctx.conditional());
    }

    @Override
    public String visitStatementAssign(@NotNull InfixParser.StatementAssignContext ctx) {
        return visit(ctx.assignment());
    }


    @Override
    public String visitIfStatement(@NotNull InfixParser.IfStatementContext ctx) {
        String formatString = "%s if %s endif";
        return String.format(formatString, visit(ctx.bool()), visit(ctx.sequence()));
    }

    @Override
    public String visitIfElseStatement(@NotNull InfixParser.IfElseStatementContext ctx) {
        String formatString = "%s if %s else %s endif";
        return String.format(formatString, visit(ctx.bool()), visit(ctx.trueSequence), visit(ctx.falseSequence));
    }

    @Override
    public String visitWhileLoop(@NotNull InfixParser.WhileLoopContext ctx) {
        String formatString = "begin %s while %s repeat";
        return String.format(formatString, visit(ctx.bool()), visit(ctx.sequence()));
    }

    @Override
    public String visitStatementExpr(@NotNull InfixParser.StatementExprContext ctx) {
        //When we're done pop the result.
        String formatString = "%s .";

        if (floatMode) {
            formatString = "%s f.";
        }

        return String.format(formatString, visit(ctx.expr()));
    }

    @Override
    public String visitFunction(@NotNull InfixParser.FunctionContext ctx) {
        String functionName = ctx.ID().getText();

        //Check if variable exists with same name.
        for (VariableSymbol variableSymbol : variableSymbols) {
            if (variableSymbol.getName().equals(functionName)) {
                new SemanticError(parser, ctx, ctx.ID().getSymbol(), "function name " + ctx.ID().getText() + " cannot be the same as a variables, please change one.");
            }
        }

        String name = ctx.funcName.getText();
        String body = visit(ctx.sequence());

        //Format return string differently depending on whether arguments exist.
        if (ctx.funcArgs() != null) {
            String arguments = visit(ctx.funcArgs());
            return String.format(": %s %s %s ;", name, arguments, body);
        } else {
            return String.format(": %s %s ;", name, body);
        }

    }

    @Override
    public String visitStatementFunction(@NotNull InfixParser.StatementFunctionContext ctx) {
        return visit(ctx.funcCall());
    }

    @Override
    public String visitFuncArgs(@NotNull InfixParser.FuncArgsContext ctx) {
        //Want to populate argument values in reverse order due to stack.
        ListIterator<InfixParser.FuncArgDeclarationContext> it = ctx.funcArgDeclaration().listIterator(ctx.funcArgDeclaration().size());

        String popOperator = "!";
        if (floatMode) {
            popOperator = "f!";
        }

        String args = visit(it.previous());
        args += " ";
        args += popOperator;
        while (it.hasPrevious()) {
            args += " ";
            args += visit(it.previous());
            args += " ";
            args += popOperator;
        }

        return args;
    }

    @Override
    public String visitDeclareFuncArg(@NotNull InfixParser.DeclareFuncArgContext ctx) {
        //Find variable from scoped symbol table and return the compiled name.
        Scope scope = scopes.get(ctx);
        VariableSymbol variableSymbol = (VariableSymbol) scope.resolve(ctx.ID().getText());
        return variableSymbol.getCompiledVariableName();
    }

    @Override
    public String visitFunctionCall(@NotNull InfixParser.FunctionCallContext ctx) {
        String formatString = "%s %s";
        String funcArgs = "";
        String name = ctx.ID().getText();

        //Ensure function being called exists.
        Symbol symbol = currentScope.resolve(name);
        if (!(symbol instanceof FunctionSymbol)) {
            new SemanticError(parser, ctx, ctx.ID().getSymbol(), "No function by the name " + name + ".");
        }

        //Push argument values on forth stack before call.
        for (InfixParser.ExprContext exprContext : ctx.expr()) {
            funcArgs += visit(exprContext);
            funcArgs += " ";
        }

        if (!funcArgs.equals("")) {
            funcArgs = funcArgs.substring(0, funcArgs.length() - 1);
            return String.format(formatString, funcArgs, name);
        } else {
            //Noarguments, change format of string
            formatString = "%s";
            return String.format(formatString, name);
        }
    }

    @Override
    public String visitParens(@NotNull InfixParser.ParensContext ctx) {
        //Ignore the paren terminals, postfix won't need it.
        return visit(ctx.expr());
    }


    @Override
    public String visitBoolParened(@NotNull InfixParser.BoolParenedContext ctx) {
        return super.visit(ctx.bool());
    }

    @Override
    public String visitMulDivAddSub(@NotNull InfixParser.MulDivAddSubContext ctx) {
        //Visit the expressions around the sign
        String left = visit(ctx.expr(0));
        String right = visit(ctx.expr(1));

        String formatString = "%s %s %s";
        if (floatMode) {
            formatString = "%s %s f%s";
        }

        //Generate relevant string for this expression.
        String op = ctx.op.getText();
        return String.format(formatString, left, right, op);
    }

    @Override
    public String visitAssignVariable(@NotNull InfixParser.AssignVariableContext ctx) {
        //Check if variable exists in scope.
        Scope scope = scopes.get(ctx);
        VariableSymbol variableSymbol = (VariableSymbol) scope.resolve(ctx.ID().getText());
        String compiledVariableName;
        if (variableSymbol == null) {
            new SemanticError(parser, ctx, ctx.ID().getSymbol(), "variable name " + ctx.ID().getText() + " not in scope, unresolvable.");
            compiledVariableName = "NO_SUCH_VARIABLE";
        } else {
            compiledVariableName = variableSymbol.getCompiledVariableName();
        }

        String formatString;
        if (floatMode) {
            formatString = "%s %s f!";
        } else {
            formatString = "%s %s !";
        }
        return String.format(formatString, visit(ctx.expr()), compiledVariableName);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public String visitFactorID(@NotNull InfixParser.FactorIDContext ctx) {
        //Check whether variable exists in scope.
        Scope scope = scopes.get(ctx);
        VariableSymbol variableSymbol = (VariableSymbol) scope.resolve(ctx.ID().getText());
        String compiledVariableName;
        if (variableSymbol == null) {
            new SemanticError(parser, ctx, ctx.ID().getSymbol(), "variable name " + ctx.ID().getText() + " not in scope, unresolvable.");
            compiledVariableName = "NO_SUCH_VARIABLE";
        } else {
            compiledVariableName = variableSymbol.getCompiledVariableName();

        }
        if (floatMode) {
            return compiledVariableName + " f@";    //To change body of overridden methods use File | Settings | File Templates.
        } else {
            return compiledVariableName + " @";    //To change body of overridden methods use File | Settings | File Templates.
        }
    }

    @Override
    public String visitFactorFloat(@NotNull InfixParser.FactorFloatContext ctx) {
        return ctx.FLOAT().getText(); // Simply return the float.
    }

    @Override
    public String visitUnarySubExpr(@NotNull InfixParser.UnarySubExprContext ctx) {
        String formatString = "0 %s -";
        if (floatMode) {
            formatString = "0e0 %s f-";
        }
        return String.format(formatString, visit(ctx.factor()));
    }

    @Override
    public String visitFactorInt(@NotNull InfixParser.FactorIntContext ctx) {
        //If prefixed with a plus sign remove it, forth can't deal with those expressions.
        //Note this only runs for what the parser considers terminal, meaning the second integer value for the FLOAT terminal remains unaffected, as intended.
        String textVal = ctx.INT().getText();
        if (textVal.substring(0, 1).equals("+")) {
            textVal = textVal.substring(1, textVal.length());
        }

        //If in float mode then convert to float.
        if (floatMode) {
            return textVal + "e0";
        } else {
            return textVal;
        }
    }

    @Override
    public String visitDeclareVariable(@NotNull InfixParser.DeclareVariableContext ctx) {
        String variableName = ctx.ID().getText();

        //The existence of this variable was handled in the first parse, here we just want to make sure it doesn't conflict.
        Symbol symbol = currentScope.resolve(variableName);
        if (symbol instanceof FunctionSymbol) {
            new SemanticError(parser, ctx, ctx.ID().getSymbol(), "variable name " + variableName + " cannot be the same as a functions, please change one.");
        }
        return "";
    }

    @Override
    public String visitBoolExpr(@NotNull InfixParser.BoolExprContext ctx) {
        //Visit the expressions around the op.
        String formatString = "%s %s %s";
        String left = visit(ctx.expr(0));
        String right = visit(ctx.expr(1));

        if (floatMode) {
            formatString = "%s %s f%s";
        }

        //Generate relevant string for this expression.
        String op = ctx.op.getText();
        return String.format(formatString, left, right, op);
    }

    @Override
    public String visitBoolLogic(@NotNull InfixParser.BoolLogicContext ctx) {
        //Convert infix boolean expression into postfix.
        String formatString = "%s %s %s";
        return String.format(formatString, visit(ctx.leftBool), visit(ctx.rightBool), ctx.op.getText());
    }

    @Override
    public String visitBoolTrue(@NotNull InfixParser.BoolTrueContext ctx) {
        //Return forth value for true.
        return "-1";
    }

    @Override
    public String visitBoolFalse(@NotNull InfixParser.BoolFalseContext ctx) {
        //Return forth value for false.
        return "0";
    }

}
