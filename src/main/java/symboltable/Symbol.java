package symboltable;

/**
 * Created by john on 09/03/14.
 */
public class Symbol {
    private String name;
    private int type;

    public Symbol(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }
}
