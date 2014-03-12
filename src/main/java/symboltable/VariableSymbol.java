package symboltable;

import symboltable.Symbol;

/**
 * Created by john on 09/03/14.
 */
public class VariableSymbol extends Symbol {
    int ctxId;

    public VariableSymbol(String a, int ctxId) {
        super(a);
        this.ctxId = ctxId;
    }

    public String getCompiledVariableName() {
        return ctxId + "_" + getName();
    }
}
