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
    public String visitMulDivAddSub(@NotNull InfixToPostfixParser.MulDivAddSubContext ctx) {
        String left = visit (ctx.expr(0));
        String right = visit (ctx.expr(1));

        String formatString = "%s %s f%s";
        switch (ctx.op.getType()) {
            case InfixToPostfixParser.MUL:
                return String.format(formatString, left, right, "*");
            case InfixToPostfixParser.ADD:
                return String.format(formatString, left, right, "+");
            case InfixToPostfixParser.SUB:
                return String.format(formatString, left, right, "-");
            case InfixToPostfixParser.DIV:
                return String.format(formatString, left, right, "/");


        }
        return super.visitMulDivAddSub(ctx);
    }

    /* Fully built string, printout. */
    @Override
    public String visitPrintExpr(@NotNull InfixToPostfixParser.PrintExprContext ctx) {
        String value = visit(ctx.expr());
        System.out.println(value+" f.");
        return "";
    }

    @Override
    public String visitFloat(@NotNull InfixToPostfixParser.FloatContext ctx) {
        return ctx.FLOAT().getText();
    }

    @Override
    public String visitInt(@NotNull InfixToPostfixParser.IntContext ctx) {
        //System.out.println();
        return ctx.INT().getText()+'e';
    }

    @Override
    public String visitParens(@NotNull InfixToPostfixParser.ParensContext ctx) {
        return visit(ctx.expr());
    }
}
