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
 */
public class InfixVisitorImpl extends InfixBaseVisitor<String> {
    String forthSource = "";
    InfixParser.PrintExprContext rootCtx;
    private boolean floatMode;
    Parser parser;

    /* Fully built string, printout. */
    @Override
    public String visitPrintExpr(@NotNull InfixParser.PrintExprContext ctx) {
        //When we're done pop the result.
        String formatString = "%s .";

        if (floatMode) {
            formatString = "%s f.";
        }

        forthSource = String.format(formatString, visit(ctx.expr()));
        rootCtx = ctx; //This is to allow generation of the postscript parse tree at a later time.
        return forthSource;
    }
    @Override
    public String visitMulDivAddSub(@NotNull InfixParser.MulDivAddSubContext ctx) {
        //Visit the expressions around the sign
        String left = visit(ctx.expr(0));
        String right = visit(ctx.expr(1));

        String formatString = "%s %s %s";
        if (floatMode) {
            formatString = "%s %s f%s";
        }

        //Generate relevant string for this expression.
        switch (ctx.op.getType()) {
            case InfixParser.MUL:
                return String.format(formatString, left, right, "*");
            case InfixParser.ADD:
                return String.format(formatString, left, right, "+");
            case InfixParser.SUB:
                return String.format(formatString, left, right, "-");
            case InfixParser.DIV:
                return String.format(formatString, left, right, "/");


        }
        //Never reached.
        return super.visitMulDivAddSub(ctx);
    }


    //This is to allow generation of the postscript parse tree at a later date.
    public void addParser(Parser p) {
        parser = p;
    }


    /**
     * Prints the postscript parsetree to a .ps file with the given name
     * @param filename used to generate a file of the form <filename>.ps
     */
    public void outputPSGraphToFile(String filename) {
        try {
            rootCtx.save(Arrays.asList(parser.getRuleNames()), filename + ".ps");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (PrintException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    @Override
    public String visitSubFloat(@NotNull InfixParser.SubFloatContext ctx) {
        return "-"+ctx.FLOAT().getText();
    }

    @Override
    public String visitFloat(@NotNull InfixParser.FloatContext ctx) {
        return ctx.FLOAT().getText(); // Simply return the float.
    }

    @Override
    public String visitSubOptionallySignedInt(@NotNull InfixParser.SubOptionallySignedIntContext ctx) {
        return "-"+ctx.INT().getText();
    }

    @Override
    public String visitOptionallySignedInt(@NotNull InfixParser.OptionallySignedIntContext ctx) {
        //If prefixed with a plus sign remove it, forth can't deal with those expressions.
        //Note this only runs for what the parser considers terminal, meaning the second integer value for the FLOAT terminal remains unaffected, as intended.
        String textVal = ctx.INT().getText();
        if (textVal.substring(0, 1).equals("+"))
        {
            textVal = textVal.substring(1, textVal.length());
        }

        //If in float mode then convert to float.
        if (floatMode) {
            return textVal + "e0";
        } else {
            return textVal;
        }
    }

    @Override
    public String visitParens(@NotNull InfixParser.ParensContext ctx) {
        //Ignore the paren terminals, postfix won't need it.
        return visit(ctx.expr());
    }

    @Override
    public String visitParensWithMinus(@NotNull InfixParser.ParensWithMinusContext ctx) {
        //Convert signed parens into forms forth will understand.
        String formatString = "0 %s -";
        if (floatMode) {
             formatString = "0e0 %s f-";
        }
        return String.format(formatString, visit(ctx.parenedexpr()));
    }

    /**
     * Returns the compiled forth source.
     * @return the compiled forth source.
     */
    public String getForthSource() {
        return forthSource;
    }

    /**
     * Enables float mode, needed to process float terminal numbers.
     */
    public void enableFloatMode() {
        floatMode = true;
    }
}
