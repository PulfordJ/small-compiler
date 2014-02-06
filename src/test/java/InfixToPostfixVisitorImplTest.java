import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by john on 24/01/14.
 */
public class InfixToPostfixVisitorImplTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    InfixToPostfixVisitorImpl visitor;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    public void runCompiler(String source)  {
        InputStream is = new ByteArrayInputStream( source.getBytes() );
        InfixToPostfixLexer lexer = null; //TODO handle incorrect file.
        try {
            lexer = new InfixToPostfixLexer(new ANTLRInputStream(is));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        InfixToPostfixParser p = new InfixToPostfixParser(tokens);



        ParseTree tree = p.start();
        visitor = new InfixToPostfixVisitorImpl();
        visitor.visit(tree);
    }

    @Test
    public void testAdd() throws Exception {

        runCompiler("3e + 5");
        assertEquals("3e 5e f+ f.", visitor.getForthSource());
    }

    @Test
    public void testVisitSub() throws Exception {

        runCompiler("5e - 3");
        assertEquals("5e 3e f- f.", visitor.getForthSource());
    }
    @Test
    public void testVisitMul() throws Exception {

        runCompiler("3e * 5e");
        assertEquals("3e 5e f* f.", visitor.getForthSource());
    }
    @Test
    public void testVisitDiv() throws Exception {

        runCompiler("50e / 100");
        assertEquals("50e 100e f/ f.", visitor.getForthSource());
    }

    @Test
    public void testVisitMulDivAddSubOrder() throws Exception {

        runCompiler("3 + 2 * 5");
        assertEquals("3e 2e 5e f* f+ f.", visitor.getForthSource());
    }

    @Test
    public void testVisitMulDivAddSubOrder2() throws Exception {

        runCompiler("3 * 2 + 5");
        assertEquals("3e 2e f* 5e f+ f.", visitor.getForthSource());
    }

    @Test
    public void testVisitMulDivAddSubOrder3() throws Exception {

        runCompiler("3 - 2 / 5");
        assertEquals("3e 2e 5e f/ f- f.", visitor.getForthSource());
    }

    @Test
    public void testVisitMulDivAddSubOrder24() throws Exception {

        runCompiler("3 / 2 - 5");
        assertEquals("3e 2e f/ 5e f- f.", visitor.getForthSource());
    }

    @Test
    public void shouldGiveInformativeLackOfParenthesisMessage() throws Exception {

        runCompiler("( 3 * 2");
        assertEquals("line 1:7 Missing closing ')'\n", errContent.toString());
    }

    @Test
    public void shouldGiveInformativeToManyOfParenthesisMessage() throws Exception {

        runCompiler("( 3 * 2 ) )");
        assertEquals("line 1:11 Too many parentheses\n", errContent.toString());
    }

    @Test
    public void shouldGiveInformativeToManyOfParenthesisMessage2() throws Exception {

        runCompiler("( 3 * 2 ) ) )");
        assertEquals("line 1:13 Too many parentheses\n", errContent.toString());
    }

    @Test
    public void testPlusSignedNumber() throws Exception {

        runCompiler("+2");
        assertEquals("+2e f.", visitor.getForthSource());
    }

    @Test
    public void testMinusSignedNumber() throws Exception {

        runCompiler("-20");
        assertEquals("-20e f.", visitor.getForthSource());
    }

    @Test
    public void testParensNum() throws Exception {

        runCompiler("(-20)");
        assertEquals("-20e f.", visitor.getForthSource());
    }

    @Test
    public void testParensWithPlus() throws Exception {

        runCompiler("+(-20)");
        assertEquals("-20e f.", visitor.getForthSource());
    }

    @Test
    public void testParensWithMinus() throws Exception {

        runCompiler("-(-20)");
        assertEquals("0e -20e f- f.", visitor.getForthSource());
    }

    @Test
    public void testParensPrecedence() throws Exception {
        runCompiler("(-20 + 30) / 2");
        assertEquals("-20e 30e f+ 2e f/ f.", visitor.getForthSource());
    }


    @Test
    public void testFloatWithE() throws Exception {

        runCompiler("3e");
        assertEquals("3e f.", visitor.getForthSource());
    }

    @Test
    public void testFloatWithExponent() throws Exception {
        runCompiler("2e0");
        assertEquals("2e0 f.", visitor.getForthSource());

    }

    @Test
    public void testInt() throws Exception {
        runCompiler("2");
        assertEquals("2e f.", visitor.getForthSource());
    }

    /* Don't need exponent operator, one already exists, maybe one day.
    
    @Test
    public void shouldHandlePositiveExponents () throws Exception {

        runCompiler("2^2");
        assertEquals("1e 2e f* 2e f* f.\n", outContent.toString());

    }

    @Test
    public void shouldHandlePowersOfOne () throws Exception {
        runCompiler("2^0");
        assertEquals("1e f.\n", outContent.toString());

    }

    @Test
    public void shouldHandleNegativeExponents () throws Exception {
        runCompiler("2^-1");
        assertEquals("1e 1e 2e f* f/ f.\n", outContent.toString());

    }
    */


}
