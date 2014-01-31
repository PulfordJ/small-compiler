import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Utils;

import javax.print.PrintException;
import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: john
 * Date: 1/24/14
 * Time: 12:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class InfixToPostfixVisitorImpl extends InfixToPostfixBaseVisitor<String> {

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


    /* Fully built string, printout. */
    @Override
    public String visitPrintExpr(@NotNull InfixToPostfixParser.PrintExprContext ctx) {
        String value = visit(ctx.expr());
        System.out.println(value+" f.");
        /*
        Future<JDialog> futureDialog = ctx.inspect(Arrays.asList(parser.getRuleNames()));
        try {
            try {
                ctx.save(Arrays.asList(parser.getRuleNames()), "graphh.ps");
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (PrintException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            Utils.waitForClose(futureDialog.get());
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ExecutionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        */
        return value+" f.";
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

}
