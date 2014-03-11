package symboltable;

/**
 * Created by john on 09/03/14.
 */
public class FunctionSymbol extends Symbol {
    int ctxId;

    public FunctionSymbol(String a, int inttype, int ctxId) {
        super(a, inttype);
        this.ctxId = ctxId;
    }
}
