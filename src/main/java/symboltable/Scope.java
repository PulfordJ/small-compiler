package symboltable;


import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import java.util.HashMap;
import java.util.Map;

/**
 * An superclass concept of a scoped symbol table.
 */
public class Scope {
    //Used to create unique identities for scoped variables.
    private static int nextId = 0;

    //Table of symbols within the scope.
    private Map<String, Symbol> symbols;

    //Unique id of this particular scope instance.
    private int id;
    //The scope this scope lays within.
    private Scope parentScope;

    /**
     * Constructor
     *
     * @param parentScope the scope this scope lays within.
     */
    public Scope(Scope parentScope) {
        symbols = new HashMap<String, Symbol>();
        this.parentScope = parentScope;
        id = ++nextId;
    }

    /**
     * Get the unique ID of this scope.
     *
     * @return the id.
     */
    public int getId() {
        return id;
    }

    /**
     * Find a symbol from this scope (the symbol it self could be in the scopes above, this method hides that).
     *
     * @param name name of the variable to search for.
     * @return the symbol, or null if the symbol is not visible from this scope.
     */
    public Symbol resolve(String name) {

        if (symbols.get(name) != null) {
            return symbols.get(name);
            //Search up the scope tree recursively until we reach the top.
        } else if (getParentScope() != null) {
            return getParentScope().resolve(name);
        } else {
            return null;
        }

    }

    /**
     * Define a synbol in this given scope.
     *
     * @param symbol symbol to define.
     */
    public void define(Symbol symbol) throws SymbolNameAlreadyInScopeException  {
        if (symbols.get(symbol.getName()) != null) {
            throw new SymbolNameAlreadyInScopeException();
        } else {
            symbols.put(symbol.getName(), symbol);
        }
    }

    /**
     * Get the scope that this scope is enclosed within.
     *
     * @return the enclosing scope.
     */
    public Scope getParentScope() {
        return parentScope;
    }

    /**
     * Reset the scope counter to 0, used by parsers for deterministic source output.
     */
    public static void resetCounter() {
        nextId = 0;
    }

    public class SymbolNameAlreadyInScopeException extends RuntimeException {
    }
}
