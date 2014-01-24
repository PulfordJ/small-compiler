import org.antlr.v4.runtime.misc.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: john
 * Date: 1/24/14
 * Time: 12:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class InfixToPostfixBaseImpl extends InfixToPostfixBaseVisitor<String> {

    @Override
    public String visitOpExpr(@NotNull InfixToPostfixParser.OpExprContext ctx) {
        return "WASSSUPPPP.";

    }
}
