package symboltable;

/**
 * Scope subclass for a generic block of code.
 */
public class LocalScope extends Scope {

    public LocalScope(Scope parentScope) {
        super(parentScope);
    }
}
