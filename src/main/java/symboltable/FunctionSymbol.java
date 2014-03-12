package symboltable;

/**
 * Created by john on 09/03/14.
 */
public class FunctionSymbol extends Symbol {
    int ctxId;

    public FunctionSymbol(String a, int ctxId) {
        super(a);
        this.ctxId = ctxId;
    }
}
