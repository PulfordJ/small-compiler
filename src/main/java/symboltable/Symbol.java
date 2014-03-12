package symboltable;

/**
 * A symbol, stored inside a scope.
 */
public class Symbol {
    //Name of the symbol.
    private final String name;

    /**
     * Constructor.
     * @param name name of the symbol.
     */
    public Symbol(String name) {
        this.name = name;
    }

    /**
     * Getter
     * @return name of the symbol.
     */
    public String getName() {
        return name;
    }
}
