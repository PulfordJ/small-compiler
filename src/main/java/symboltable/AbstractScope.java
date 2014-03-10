package symboltable;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by john on 09/03/14.
 */
public class AbstractScope {
    private static int nextId = 0;

    private Map<String, Symbol> symbols;
    private int id;
    AbstractScope parentScope;

    public AbstractScope(AbstractScope parentScope) {
        symbols = new HashMap<String, Symbol>();
        this.parentScope = parentScope;
        id = ++nextId;
    }

    public int getId() {
        return id;
    }

    public Symbol resolve(String name) {
        //Throw errors if symbol not found.
        if (symbols.get(name) != null) {
            return symbols.get(name);
        } else if (getParentScope() != null) {
            return getParentScope().resolve(name);
        } else {
            return null;
        }

    }

    public void define(Symbol symbol) {
        symbols.put(symbol.getName(), symbol);
    }

    public AbstractScope getParentScope() {
        return parentScope;
    }

    public List<Symbol> getSymbols() {
        return new ArrayList<Symbol>(symbols.values());
    }

    public static void resetCounter() {
        nextId = 0;
    }
}
