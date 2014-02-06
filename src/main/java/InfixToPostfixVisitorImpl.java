import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.misc.NotNull;

import javax.print.PrintException;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: john
 * Date: 1/24/14
 * Time: 12:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class InfixToPostfixVisitorImpl extends InfixToPostfixBaseVisitor<String> {
    String forthSource = "";
    InfixToPostfixParser.PrintExprContext rootCtx;

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


    public void addParser(Parser p) {
        parser = p;
    }

    Parser parser;


    public void outputPSGraphToFile(String filename) {
        try {
            rootCtx.save(Arrays.asList(parser.getRuleNames()), filename + ".ps");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (PrintException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }


    /* Fully built string, printout. */
    @Override
    public String visitPrintExpr(@NotNull InfixToPostfixParser.PrintExprContext ctx) {
        forthSource = visit(ctx.expr())+ " f.";
        //This allows graph generation at a later date.
        rootCtx = ctx;
        return forthSource;
    }

    @Override
    public String visitFloat(@NotNull InfixToPostfixParser.FloatContext ctx) {
        return ctx.FLOAT().getText();
    }

    @Override
    public String visitOptionallySignedInt(@NotNull InfixToPostfixParser.OptionallySignedIntContext ctx) {
        return ctx.OPTIONALLYSIGNEDINT().getText()+'e';
    }

    @Override
    public String visitParens(@NotNull InfixToPostfixParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

	@Override 
    public String visitParensWithMinus(@NotNull InfixToPostfixParser.ParensWithMinusContext ctx) 
    {
        return "0e "+visit(ctx.parenedexpr())+" f-";
    }

    public String getForthSource() {
        return forthSource;
    }

}
