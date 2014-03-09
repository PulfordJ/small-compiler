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
    private Map<String, Symbol> symbols;
    AbstractScope parentScope;

    public AbstractScope(AbstractScope parentScope) {
        symbols = new HashMap<String, Symbol>();
        this.parentScope = parentScope;
    }

    public Symbol resolve(String name) {
        //Throw errors if symbol not found.
        return symbols.get(name);
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
}
