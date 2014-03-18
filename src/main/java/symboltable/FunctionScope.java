package symboltable;

/**
 * An implementation of scope for functions.
 */
public class FunctionScope extends Scope {
    public FunctionScope(Scope parentScope) {
        super(parentScope);
    }
}
