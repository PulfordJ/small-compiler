/**
 * Created with IntelliJ IDEA.
 * User: john
 * Date: 1/24/14
 * Time: 12:04 PM
 * To change this template use File | Settings | File Templates.
 */
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
public class InfixToPostfixListenerImpl extends InfixToPostfixBaseListener {
    @Override
    public void exitOpExpr(@NotNull InfixToPostfixParser.OpExprContext ctx) {
        super.exitOpExpr(ctx);    //To change body of overridden methods use File | Settings | File Templates.
        //TODO Delete this class...
        System.out.println(ctx.left + " " + ctx.right + " " + ctx.op);


    }
}
