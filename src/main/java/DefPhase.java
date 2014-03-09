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
    private ParseTreeProperty<AbstractScope> scopes = new ParseTreeProperty<AbstractScope>();
    private GlobalScope globalScope;
    private AbstractScope currentScope;

    private List<VariableSymbol> variableSymbols = new ArrayList<VariableSymbol>();

    boolean floatMode;

    public boolean hasFloat() {
        return floatMode;
    }

    public ParseTreeProperty<AbstractScope> getScopes() {
        return scopes;
    }

    @Override
    public void enterBoilerplate(@NotNull InfixParser.BoilerplateContext ctx) {
        super.enterBoilerplate(ctx);
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
        VariableSymbol variableSymbol = new VariableSymbol(ctx.VARIABLE().getText(), InfixLexer.INTTYPE);
        currentScope.define(variableSymbol);
        variableSymbols.add(variableSymbol);
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
}
