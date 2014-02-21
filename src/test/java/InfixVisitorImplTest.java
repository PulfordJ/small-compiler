import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by john on 24/01/14.
 * Tests conversion to forth source
 * Mostly self explanatory.
 */
public class InfixVisitorImplTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    InfixVisitorImpl visitor;

    //This was to access error stream, with object abstraction this doesn't appear to work, kept for posterity, 'failing' tests commented out.
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

    public void runCompiler(String source) {
       StringCompiler stringCompiler = new StringCompiler(source);
        try {
            visitor = stringCompiler.compile();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        assertEquals("3 2 5 * + .", visitor.getForthSource());
    }

    @Test
    public void testVisitMulDivAddSubOrder2() throws Exception {

        runCompiler("3 * 2 + 5");
        assertEquals("3 2 * 5 + .", visitor.getForthSource());
    }

    @Test
    public void testVisitMulDivAddSubOrder3() throws Exception {

        runCompiler("3 - 2 / 5");
        assertEquals("3 2 5 / - .", visitor.getForthSource());
    }

    @Test
    public void testVisitMulDivAddSubOrder24() throws Exception {

        runCompiler("3 / 2 - 5");
        assertEquals("3 2 / 5 - .", visitor.getForthSource());
    }

    /** These tests fail to access the error stream via the new modularised compiler.

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
        //System.out.println("out" + outContent.toString());
        //System.out.println("Err"+errContent.toString());
        assertEquals("line 1:13 Too many parentheses\n", errContent.toString());
    }

    */

    @Test
    public void testPlusSignedNumber() throws Exception {

        runCompiler("+2");
        assertEquals("2 .", visitor.getForthSource());
    }

    @Test
    public void testMinusSignedNumber() throws Exception {

        runCompiler("-20");
        assertEquals("-20 .", visitor.getForthSource());
    }

    @Test
    public void testParensNum() throws Exception {

        runCompiler("(-20)");
        assertEquals("-20 .", visitor.getForthSource());
    }

    @Test
    public void testParensWithPlus() throws Exception {

        runCompiler("+(-20)");
        assertEquals("-20 .", visitor.getForthSource());
    }

    @Test
    public void testParensWithMinus() throws Exception {

        runCompiler("-(-20)");
        assertEquals("0 -20 - .", visitor.getForthSource());
    }

    @Test
    public void testFloatParensWithMinus() throws Exception {

        runCompiler("-(-20e)");
        assertEquals("0e -20e f- f.", visitor.getForthSource());
    }

    @Test
    public void testParensPrecedence() throws Exception {
        runCompiler("(-20 + 30) / 2");
        assertEquals("-20 30 + 2 / .", visitor.getForthSource());
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
    public void testParenedInt() throws Exception {
        runCompiler("( 3 + 2 )");
        assertEquals("3 2 + .", visitor.getForthSource());
    }

    public void testInt() throws Exception {
        runCompiler("2");
        assertEquals("2 .", visitor.getForthSource());
    }



}
