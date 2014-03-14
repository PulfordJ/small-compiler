package symboltable;

import symboltable.Symbol;

/**
 * Symbol subclass for a variable.
 */
public class VariableSymbol extends Symbol {
    //Id of the scope this variable is within, used to generate unique names.
    private final int ctxId;

    /**
     * Constructor
     * @param name name of the variable
     * @param ctxId id of the scope this variable is declared within.
     */
    public VariableSymbol(String name, int ctxId) {
        super(name);
        this.ctxId = ctxId;
    }

    /**
     * The unique target code name for the symbol.
     * @return the target code name.
     */
    public String getCompiledVariableName() {
        return ctxId + "_" + getName();
    }
}
