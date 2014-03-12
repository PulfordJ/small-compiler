import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import symboltable.Scope;
import symboltable.FunctionSymbol;
import symboltable.VariableSymbol;

import javax.print.PrintException;
import java.io.IOException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: john
 * Date: 1/24/14
 * Time: 12:47 PM
 */
public class InfixVisitorImpl extends InfixBaseVisitor<String> {
    private final List<VariableSymbol> variableSymbols;
    private final List<FunctionSymbol> functionSymbols;
    String forthSource = "";
    InfixParser.BoilerplateContext rootCtx;
    private boolean floatMode;
    Parser parser;


    private final ParseTreeProperty<Scope> scopes;
    Scope currentScope;

    public InfixVisitorImpl(InfixParser parser, ParseTreeProperty<Scope> scopes, List<VariableSymbol> variableSymbols, ArrayList<FunctionSymbol> functionSymbols) {
        super();
        this.scopes = scopes;
        this.variableSymbols = variableSymbols;
        this.functionSymbols = functionSymbols;
        this.parser = parser;
    }


    @Override
    public String visitDeclareIntVariable(@NotNull InfixParser.DeclareIntVariableContext ctx) {
        String variableName = ctx.ID().getText();

        for (FunctionSymbol functionSymbol : functionSymbols) {
            if (functionSymbol.getName().equals(variableName)) {
                new SemanticError(parser, ctx, ctx.ID().getSymbol(), "variable name "+ variableName +" cannot be the same as a functions, please change one.");
            }

        }

        //String formatString = "0 { %s }";

        //This is to force a blank return value, it's already been handled by the symbol table..
        return "";
    }

    @Override
    public String visitFunction(@NotNull InfixParser.FunctionContext ctx) {
        String functionName = ctx.ID().getText();

        for (VariableSymbol variableSymbol : variableSymbols) {
            if (variableSymbol.getName().equals(functionName)) {
                new SemanticError(parser, ctx, ctx.ID().getSymbol(), "function name "+ ctx.ID().getText() +" cannot be the same as a variables, please change one.");
            }
        }


        String formatString = ": %s %s %s ;";
        String name = ctx.funcName.getText();
        String arguments;
        String body = visit(ctx.sequence());

        if (ctx.funcArgs() != null) {
            arguments = visit(ctx.funcArgs());
            return String.format(": %s %s %s ;", name, arguments, body);
        }
        else {
            return String.format(": %s %s ;", name, body);
        }

    }

    @Override
    public String visitStatementFunction(@NotNull InfixParser.StatementFunctionContext ctx) {
        return visit(ctx.funcCall());
    }

    @Override
    public String visitFunctionCall(@NotNull InfixParser.FunctionCallContext ctx) {
        String formatString = "%s %s";
        String funcArgs = "";
        String name = ctx.ID().getText();
        boolean found = false;

        for (FunctionSymbol functionSymbol : functionSymbols) {
            if (functionSymbol.getName().equals(name)) {
                found = true;
            }
        }

        if (!found) {
            new SemanticError(parser, ctx, ctx.ID().getSymbol(), "No function by the name "+ name +".");
        }

        Iterator<InfixParser.ExprContext> it =  ctx.expr().iterator();
        while (it.hasNext()) {
            funcArgs += visit(it.next());
            funcArgs += " ";
        }
        if (!funcArgs.equals("")) {
        funcArgs = funcArgs.substring(0, funcArgs.length()-1);
            return String.format(formatString, funcArgs, name);
        }
        else {
            //Noarguments, change format of string
            formatString = "%s";
            return String.format(formatString, name);
        }


    }

    @Override
    public String visitFuncArgs(@NotNull InfixParser.FuncArgsContext ctx) {
        //Want to traverse in reverse order...
        ListIterator<InfixParser.FuncArgDeclarationContext> it = ctx.funcArgDeclaration().listIterator(ctx.funcArgDeclaration().size());

        String args = visit(it.previous());
        args += " !";
        while (it.hasPrevious()) {
            args += " ";
            args += visit(it.previous());
            args += " !";
        }

        return args;
    }

    @Override
    public String visitDeclareFuncArg(@NotNull InfixParser.DeclareFuncArgContext ctx) {
        Scope scope = scopes.get(ctx);
        VariableSymbol variableSymbol = (VariableSymbol) scope.resolve(ctx.ID().getText());
        return variableSymbol.getCompiledVariableName();
    }
    /*
    @Override
    public String visitAssignVariable(@NotNull InfixParser.AssignVariableContext ctx) {
    }
    */

    @Override
    public String visitBoolParened(@NotNull InfixParser.BoolParenedContext ctx) {
        return super.visit(ctx.bool());
    }

    @Override
    public String visitSequence(@NotNull InfixParser.SequenceContext ctx) {
        currentScope = scopes.get(ctx);
        currentScope = currentScope.getParentScope();


        String innerSource = "";
        List<InfixParser.StatementContext> statementContexts = ctx.statement();
        for (InfixParser.StatementContext statementContext : statementContexts) {
            innerSource += visit(statementContext) + " ";
        }

        if (!innerSource.equals("")) {
            innerSource = innerSource.substring(0, innerSource.length() - 1);
        }
        return innerSource;

    }


    @Override
    public String visitBoilerplate(@NotNull InfixParser.BoilerplateContext ctx) {


        //Declare all functions.
        ListIterator<InfixParser.FuncContext> funcIt = ctx.func().listIterator();

        String funcDefinitions = "";
        while(funcIt.hasNext()) {
            funcDefinitions += visit(funcIt.next());
            funcDefinitions += " ";
        }


        //Declare all variable names.
        String varDeclarations = "";
        Iterator<VariableSymbol> it = variableSymbols.iterator();

        while (it.hasNext()) {
            VariableSymbol variableSymbol = it.next();
            varDeclarations += "variable ";
            varDeclarations += variableSymbol.getCompiledVariableName();
            varDeclarations += " ";
        }


        currentScope = scopes.get(ctx);

        String formatString = "%s%s: program %s ; program";

        //Iterate through all sequences.
        //int count = ctx.sequence().getChildCount();
        /*
        String innerSource = visit(ctx.sequence().getChild(0));
        for (int i = 1; i < count; i++) {
            innerSource += " "+ visit(ctx.sequence().getChild(i));
        }
        */
        forthSource = String.format(formatString, varDeclarations, funcDefinitions, visit(ctx.sequence()));
        rootCtx = ctx; //This is to allow generation of the postscript parse tree at a later time.
        return forthSource;
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
    public String visitMulDivAddSub(@NotNull InfixParser.MulDivAddSubContext ctx) {
        //Visit the expressions around the sign
        String left = visit(ctx.expr(0));
        String right = visit(ctx.expr(1));

        String formatString = "%s %s %s";
        if (floatMode) {
            formatString = "%s %s f%s";
        }

        //Generate relevant string for this expression.
        switch (ctx.op.getType()) {
            case InfixParser.MUL:
                return String.format(formatString, left, right, "*");
            case InfixParser.ADD:
                return String.format(formatString, left, right, "+");
            case InfixParser.SUB:
                return String.format(formatString, left, right, "-");
            case InfixParser.DIV:
                return String.format(formatString, left, right, "/");


        }
        //Never reached.
        return super.visitMulDivAddSub(ctx);
    }

    @Override
    public String visitBoolExpr(@NotNull InfixParser.BoolExprContext ctx) {
        String formatString = "%s %s %s";

        if (floatMode) {
            formatString = "%s %s f%s";
        }

        String op = "";

        //Visit the expressions around the op
        String left = visit(ctx.expr(0));
        String right = visit(ctx.expr(1));

        op = ctx.op.getText();
       return String.format(formatString, left, right, op);
    }

    @Override
    public String visitBoolLogic(@NotNull InfixParser.BoolLogicContext ctx) {
        String formatString = "%s %s %s";
        return String.format(formatString, visit(ctx.leftBool), visit(ctx.rightBool), ctx.op.getText());
    }

    @Override
    public String visitBoolTrue(@NotNull InfixParser.BoolTrueContext ctx) {
        return "-1";
    }

    @Override
    public String visitBoolFalse(@NotNull InfixParser.BoolFalseContext ctx) {
        return "0";
    }

    /**
     * Prints the postscript parsetree to a .ps file with the given name
     *
     * @param filename used to generate a file of the form <filename>.ps
     */
    public void outputPSGraphToFile(String filename) {
        try {
            rootCtx.save(Arrays.asList(parser.getRuleNames()), filename + ".ps");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (PrintException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    @Override
    public String visitAssignVariable(@NotNull InfixParser.AssignVariableContext ctx) {
        Scope scope = scopes.get(ctx);
        VariableSymbol variableSymbol = (VariableSymbol) scope.resolve(ctx.ID().getText());

        String compiledVariableName;
        //TODO CHECK IF VARIABLE EXISTS.
        if (variableSymbol == null) {
            new SemanticError(parser, ctx, ctx.ID().getSymbol(), "variable name "+ ctx.ID().getText() +" not in scope, unresolvable.");
            compiledVariableName = "NO_SUCH_VARIABLE";
        }
        else {
            compiledVariableName =  variableSymbol.getCompiledVariableName();

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
    public String visitStatementConditional(@NotNull InfixParser.StatementConditionalContext ctx) {
        return visit(ctx.conditional());
    }

    @Override
    public String visitWhileLoop(@NotNull InfixParser.WhileLoopContext ctx) {
        String formatString = "begin %s while %s repeat";
        return String.format(formatString, visit(ctx.bool()), visit(ctx.sequence()));
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
    public String visitSubVariable(@NotNull InfixParser.SubVariableContext ctx) {
        Scope scope = scopes.get(ctx);
        VariableSymbol variableSymbol = (VariableSymbol) scope.resolve(ctx.ID().getText());
        String compiledVariableName;

        if (variableSymbol == null) {
            new SemanticError(parser, ctx, ctx.ID().getSymbol(), "variable name "+ ctx.ID().getText() +" not in scope, unresolvable.");
            compiledVariableName = "NO_SUCH_VARIABLE";
        }
        else {
            compiledVariableName =  variableSymbol.getCompiledVariableName();
        }

        if (floatMode) {
            return "0e0 " + compiledVariableName + " @ -";    //To change body of overridden methods use File | Settings | File Templates.
        } else {
            return "0 " + compiledVariableName + " @ -";    //To change body of overridden methods use File | Settings | File Templates.
        }
    }

    @Override
    public String visitVariable(@NotNull InfixParser.VariableContext ctx) {
        Scope scope = scopes.get(ctx);
        VariableSymbol variableSymbol = (VariableSymbol) scope.resolve(ctx.ID().getText());
        String compiledVariableName;

        if (variableSymbol == null) {
            new SemanticError(parser, ctx, ctx.ID().getSymbol(), "variable name "+ ctx.ID().getText() +" not in scope, unresolvable.");
            compiledVariableName = "NO_SUCH_VARIABLE";
        }
        else {
            compiledVariableName =  variableSymbol.getCompiledVariableName();

        }
        if (floatMode) {
            return compiledVariableName + " f@";    //To change body of overridden methods use File | Settings | File Templates.
        } else {
            return compiledVariableName + " @";    //To change body of overridden methods use File | Settings | File Templates.
        }
    }

    @Override
    public String visitSubFloat(@NotNull InfixParser.SubFloatContext ctx) {
        return "-" + ctx.FLOAT().getText();
    }

    @Override
    public String visitFloat(@NotNull InfixParser.FloatContext ctx) {
        return ctx.FLOAT().getText(); // Simply return the float.
    }

    @Override
    public String visitSubOptionallySignedInt(@NotNull InfixParser.SubOptionallySignedIntContext ctx) {
        return "-" + ctx.INT().getText();
    }

    @Override
    public String visitOptionallySignedInt(@NotNull InfixParser.OptionallySignedIntContext ctx) {
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
    public String visitParens(@NotNull InfixParser.ParensContext ctx) {
        //Ignore the paren terminals, postfix won't need it.
        return visit(ctx.expr());
    }

    @Override
    public String visitParensWithAdd(@NotNull InfixParser.ParensWithAddContext ctx) {
        return super.visitParensWithAdd(ctx);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public String visitParensWithMinus(@NotNull InfixParser.ParensWithMinusContext ctx) {
        //Convert signed parens into forms forth will understand.
        String formatString = "0 %s -";
        if (floatMode) {
            formatString = "0e0 %s f-";
        }
        return String.format(formatString, visit(ctx.parenedexpr()));
    }

    /**
     * Returns the compiled forth source.
     *
     * @return the compiled forth source.
     */
    public String getForthSource() {
        return forthSource;
    }

    /**
     * Enables float mode, needed to process float terminal numbers.
     */
    public void enableFloatMode() {
        floatMode = true;
    }
}
