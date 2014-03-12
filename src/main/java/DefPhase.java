import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import symboltable.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Used to get variable and function declarations, also to check whether floats are in use within the source code.
 */
public class DefPhase extends InfixBaseListener {
    //Used to associate scopes with contexts for future parses.
    private ParseTreeProperty<Scope> scopes;

    //Used to specify the current scope of a given context
    private Scope currentScope;

    //The parser, used to output errors.
    private final Parser parser;

    //A list of variables found within the whole program.
    private List<VariableSymbol> variableSymbols;

    //Store whether trees visited suggest floats are in use.
    private boolean hasFloat;


    /**
     * Constructor.
     *
     * @param parser The parser the listener is attached too.
     */
    public DefPhase(Parser parser) {
        this.parser = parser;
    }

    /**
     * Getter
     *
     * @return whether trees visited suggest floats are in use.
     */
    public boolean hasFloat() {
        return hasFloat;
    }


    /**
     * Getter.
     *
     * @return te list of variable symbols found in the parse.
     */
    public List<VariableSymbol> getVariableSymbols() {
        return Collections.unmodifiableList(variableSymbols);
    }

    /**
     * Getter
     *
     * @return A map of contexts to scopes.
     */
    public ParseTreeProperty<Scope> getScopes() {
        return scopes;
    }


    // The methods below run upon the entry and exit of rules defined in src/main/antlr/Infix.g4.

    @Override
    public void enterBoilerplate(@NotNull InfixParser.BoilerplateContext ctx) {
        super.enterBoilerplate(ctx);
        //Always reset this for deterministic source code.
        GlobalScope.resetCounter();

        //Initialise object variables.
        variableSymbols = new ArrayList<VariableSymbol>();
        scopes = new ParseTreeProperty<Scope>();
        //Set this block as the current scope
        currentScope = new GlobalScope();
        hasFloat = false;
    }

    @Override
    public void enterSequence(@NotNull InfixParser.SequenceContext ctx) {
        super.enterSequence(ctx);

        //Set this block as the current scope
        LocalScope localScope = new LocalScope(currentScope);
        scopes.put(ctx, localScope);
        currentScope = localScope;
    }

    @Override
    public void exitSequence(@NotNull InfixParser.SequenceContext ctx) {
        //Return to scope before entering this sequence.
        currentScope = currentScope.getParentScope();
    }
    @Override
    public void exitDeclareVariable(@NotNull InfixParser.DeclareVariableContext ctx) {
        VariableSymbol variableSymbol = new VariableSymbol(ctx.ID().getText(), currentScope.getId());
        //Attempt to define variable symbol, if symbol by name already exists inform user of invalid source code.
        try {
            currentScope.define(variableSymbol);
            variableSymbols.add(variableSymbol);
        } catch (Scope.SymbolNameAlreadyInScopeException e) {
            new SemanticError(parser, ctx, ctx.ID().getSymbol(), "symbol with name " + ctx.ID().getText() + " already in scope.");
        }
    }

    @Override
    public void exitAssignVariable(@NotNull InfixParser.AssignVariableContext ctx) {
        super.exitAssignVariable(ctx);
        //Associate current scope with this context, used in second pass.
        scopes.put(ctx, currentScope);
    }

    @Override
    public void exitVariable(@NotNull InfixParser.VariableContext ctx) {
        super.exitVariable(ctx);
        //Associate current scope with this context, used in second pass.
        scopes.put(ctx, currentScope);
    }

    @Override
    public void exitSubVariable(@NotNull InfixParser.SubVariableContext ctx) {
        super.exitSubVariable(ctx);
        //Associate current scope with this context, used in second pass.
        scopes.put(ctx, currentScope);
    }

    @Override
    public void enterFunction(@NotNull InfixParser.FunctionContext ctx) {
        FunctionSymbol functionSymbol = new FunctionSymbol(ctx.ID().getText());
        //Attempt to define function symbol, if symbol by name already exists inform user of invalid source code.
        try {
            currentScope.define(functionSymbol);
        } catch (Scope.SymbolNameAlreadyInScopeException e) {
            new SemanticError(parser, ctx, ctx.ID().getSymbol(), "symbol with name " + ctx.ID().getText() + " already in scope.");
        }
        currentScope = new FunctionScope(currentScope);
        scopes.put(ctx, currentScope);
    }

    @Override
    public void exitFunction(@NotNull InfixParser.FunctionContext ctx) {
        //Existing function, return to enclosing scope.
        currentScope = currentScope.getParentScope();
    }

    @Override
    public void exitDeclareFuncArg(@NotNull InfixParser.DeclareFuncArgContext ctx) {
        VariableSymbol variableSymbol = new VariableSymbol(ctx.ID().getText(), currentScope.getId());
        //Attempt to define variable symbol, if symbol by name already exists inform user of invalid source code.
        try {
            currentScope.define(variableSymbol);
        } catch (Scope.SymbolNameAlreadyInScopeException e) {
            new SemanticError(parser, ctx, ctx.ID().getSymbol(), "symbol with name " + ctx.ID().getText() + " already in scope.");
        }
        variableSymbols.add(variableSymbol);
        scopes.put(ctx, currentScope);
    }

    @Override
    public void enterFloat(@NotNull InfixParser.FloatContext ctx) {
        //Found float in code, set hasFloat to true.
        hasFloat = true;
        super.enterFloat(ctx);
    }

    @Override
    public void enterSubFloat(@NotNull InfixParser.SubFloatContext ctx) {
        //Found float in code, set hasFloat to true.
        hasFloat = true;
        super.enterSubFloat(ctx);
    }

    @Override
    public void enterValueType(@NotNull InfixParser.ValueTypeContext ctx) {
        //If float variable declared, enter float mode.
        if (ctx.getText().equals("float")){
            hasFloat = true;
        }

        super.enterValueType(ctx);
    }
}
