import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import symboltable.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 09/03/14.
 */
public class DefPhase extends InfixBaseListener {
    //Used to associate scopes with contexts for future parses.
    private ParseTreeProperty<Scope> scopes;
    private GlobalScope globalScope;
    private Scope currentScope;
    private Parser parser;

    public DefPhase(Parser parser) {
        this.parser = parser;
    }

    private List<VariableSymbol> variableSymbols;

    boolean floatMode;
    private ArrayList<FunctionSymbol> functionSymbols;

    public boolean hasFloat() {
        return floatMode;
    }

    public ParseTreeProperty<Scope> getScopes() {
        return scopes;
    }

    @Override
    public void enterBoilerplate(@NotNull InfixParser.BoilerplateContext ctx) {
        super.enterBoilerplate(ctx);
        variableSymbols = new ArrayList<VariableSymbol>();
        functionSymbols = new ArrayList<FunctionSymbol>();
        scopes = new ParseTreeProperty<Scope>();
        GlobalScope.resetCounter();
        globalScope = new GlobalScope();
        currentScope = globalScope;
        scopes.put(ctx, globalScope);
        floatMode = false;
    }

    @Override
    public void enterSequence(@NotNull InfixParser.SequenceContext ctx) {
        super.enterSequence(ctx);
        LocalScope localScope = new LocalScope(currentScope);
        //If this was a function we'd also need to define it in current scope...
        scopes.put(ctx, localScope);
        currentScope = localScope;
    }

    @Override
    public void exitSequence(@NotNull InfixParser.SequenceContext ctx) {
        currentScope = currentScope.getParentScope();
    }

    @Override
    public void exitDeclareIntVariable(@NotNull InfixParser.DeclareIntVariableContext ctx) {
        VariableSymbol variableSymbol = new VariableSymbol(ctx.ID().getText(), currentScope.getId());
        try {
            currentScope.define(variableSymbol);
            variableSymbols.add(variableSymbol);
        } catch (Scope.SymbolNameAlreadyInScopeException e) {
            new SemanticError(parser, ctx, ctx.ID().getSymbol(), "symbol with name " + ctx.ID().getText() + " already in scope.");
        }
    }

    @Override
    public void exitAssignVariable(@NotNull InfixParser.AssignVariableContext ctx) {
        super.exitAssignVariable(ctx);    //To change body of overridden methods use File | Settings | File Templates.
        scopes.put(ctx, currentScope);
    }

    @Override
    public void exitVariable(@NotNull InfixParser.VariableContext ctx) {
        super.exitVariable(ctx);    //To change body of overridden methods use File | Settings | File Templates.
        scopes.put(ctx, currentScope);
    }

    @Override
    public void exitSubVariable(@NotNull InfixParser.SubVariableContext ctx) {
        super.exitSubVariable(ctx);    //To change body of overridden methods use File | Settings | File Templates.
        scopes.put(ctx, currentScope);
    }

    @Override
    public void enterFunction(@NotNull InfixParser.FunctionContext ctx) {
        FunctionSymbol functionSymbol = new FunctionSymbol(ctx.ID().getText());
        try {
            currentScope.define(functionSymbol);
        } catch (Scope.SymbolNameAlreadyInScopeException e) {
            new SemanticError(parser, ctx, ctx.ID().getSymbol(), "symbol with name " + ctx.ID().getText() + " already in scope.");
        }
        currentScope = new FunctionScope(currentScope);
        functionSymbols.add(functionSymbol);
        scopes.put(ctx, currentScope);
    }

    @Override
    public void exitFunction(@NotNull InfixParser.FunctionContext ctx) {
        currentScope = currentScope.getParentScope();
    }

    @Override
    public void exitDeclareFuncArg(@NotNull InfixParser.DeclareFuncArgContext ctx) {
        //TODO change type to something more dynamic...
        VariableSymbol variableSymbol = new VariableSymbol(ctx.ID().getText(), currentScope.getId());
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
        floatMode = true;
        super.enterFloat(ctx);
    }

    @Override
    public void enterSubFloat(@NotNull InfixParser.SubFloatContext ctx) {
        floatMode = true;
        super.enterSubFloat(ctx);
    }

    @Override
    public void enterOptionallySignedInt(@NotNull InfixParser.OptionallySignedIntContext ctx) {
        super.enterOptionallySignedInt(ctx);
    }

    public List<VariableSymbol> getVariableSymbols() {
        return variableSymbols;
    }

    public ArrayList<FunctionSymbol> getFunctionSymbols() {
        return functionSymbols;
    }
}
