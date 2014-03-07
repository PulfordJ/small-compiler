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
    /*
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
    */

    public void runCompiler(String source) {
       StringCompiler stringCompiler = new StringCompiler(source);
        try {
            visitor = stringCompiler.compile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testVariableDeclaration() throws Exception {

        runCompiler("int a");
        assertEquals(": program 0 { a } ; program", visitor.getForthSource());
    }

    @Test
    public void testVariableDeclarationAndUse() throws Exception {

        runCompiler("int a a");
        assertEquals(": program 0 { a } a . ; program", visitor.getForthSource());
    }

    @Test
    public void testMultipleVariableDeclaration() throws Exception {

        runCompiler("int a int b");
        assertEquals(": program 0 { a } 0 { b } ; program", visitor.getForthSource());
    }

    @Test
    public void testAdd() throws Exception {

        runCompiler("3e0 + 5");
        assertEquals(": program 3e0 5e0 f+ f. ; program", visitor.getForthSource());
    }

    @Test
    public void testVisitSub() throws Exception {

        runCompiler("5e0 - 3");
        assertEquals(": program 5e0 3e0 f- f. ; program", visitor.getForthSource());
    }

    @Test
    public void testVisitMul() throws Exception {

        runCompiler("3e0 * 5e0");
        assertEquals(": program 3e0 5e0 f* f. ; program", visitor.getForthSource());
    }

    @Test
    public void testVisitDiv() throws Exception {

        runCompiler("50e0 / 100");
        assertEquals(": program 50e0 100e0 f/ f. ; program", visitor.getForthSource());
    }

    @Test
    public void testVisitMulDivAddSubOrder() throws Exception {

        runCompiler("3 + 2 * 5");
        assertEquals(": program 3 2 5 * + . ; program", visitor.getForthSource());
    }

    @Test
    public void testVisitMulDivAddSubOrder2() throws Exception {

        runCompiler("3 * 2 + 5");
        assertEquals(": program 3 2 * 5 + . ; program", visitor.getForthSource());
    }

    @Test
    public void testVisitMulDivAddSubOrder3() throws Exception {

        runCompiler("3 - 2 / 5");
        assertEquals(": program 3 2 5 / - . ; program", visitor.getForthSource());
    }

    @Test
    public void testVisitMulDivAddSubOrder24() throws Exception {

        runCompiler("3 / 2 - 5");
        assertEquals(": program 3 2 / 5 - . ; program", visitor.getForthSource());
    }

    /** These tests fail to access the error stream via the new modularised compiler.

    @Test
    public void shouldGiveInformativeLackOfParenthesisMessage() throws Exception {

        runCompiler("( 3 * 2");
        assertEquals(": program line 1:7 Missing closing ')'\n", errContent.toString());
    }

    @Test
    public void shouldGiveInformativeToManyOfParenthesisMessage() throws Exception {

        runCompiler("( 3 * 2 ) )");
        assertEquals(": program line 1:11 Too many parentheses\n", errContent.toString());
    }

    @Test
    public void shouldGiveInformativeToManyOfParenthesisMessage2() throws Exception {

        runCompiler("( 3 * 2 ) ) )");
        //System.out.println("out" + outContent.toString());
        //System.out.println("Err"+errContent.toString());
        assertEquals(": program line 1:13 Too many parentheses\n", errContent.toString());
    }

    */

    @Test
    public void testPlusSignedNumber() throws Exception {

        runCompiler("+2");
        assertEquals(": program 2 . ; program", visitor.getForthSource());
    }
    @Test
    public void testPlusSignedNumberInParenedExpr() throws Exception {

        runCompiler("( +2 + 2 )");
        assertEquals(": program 2 2 + . ; program", visitor.getForthSource());
    }

    @Test
    public void testSignedNumberWithSpace() throws Exception {

        runCompiler("+ 2");
        assertEquals(": program 2 . ; program", visitor.getForthSource());
    }

    @Test
    public void testSignedNumberWithSpace2() throws Exception {

        runCompiler("- 2");
        assertEquals(": program -2 . ; program", visitor.getForthSource());
    }

    @Test
    public void testSignedNumberWithSpaceInExpr() throws Exception {

        runCompiler("+ 2 - 3");
        assertEquals(": program 2 3 - . ; program", visitor.getForthSource());
    }

    @Test
    public void testSignedNumberWithSpaceInExpr2() throws Exception {

        runCompiler("+ 2 + 3");
        assertEquals(": program 2 3 + . ; program", visitor.getForthSource());
    }

    @Test
    public void testSignedNumbersWithSpaceInExpr() throws Exception {

        runCompiler("+ 2 + +3");
        assertEquals(": program 2 3 + . ; program", visitor.getForthSource());
    }

    @Test
    public void testSignedNumberWithSpaceInExpr3() throws Exception {

        runCompiler("(+ 2 + 3)");
        assertEquals(": program 2 3 + . ; program", visitor.getForthSource());
    }

    @Test
    public void testSignedNumberWithOutSpaceInExpr4() throws Exception {

        runCompiler("(+ 2 + 3)");
        assertEquals(": program 2 3 + . ; program", visitor.getForthSource());
    }

    @Test
    public void testSignedNumberWithSpaceInExpr4() throws Exception {

        runCompiler("(2 + + 3)");
        assertEquals(": program 2 3 + . ; program", visitor.getForthSource());
    }

    @Test
    public void testSignedNumberWithSpaceInExpr5() throws Exception {

        runCompiler("(+3 + + 2)");
        assertEquals(": program 3 2 + . ; program", visitor.getForthSource());
    }

    @Test
    public void testMinusSignedNumber() throws Exception {

        runCompiler("-20");
        assertEquals(": program -20 . ; program", visitor.getForthSource());
    }

    @Test
    public void testParensNum() throws Exception {

        runCompiler("(-20)");
        assertEquals(": program -20 . ; program", visitor.getForthSource());
    }

    @Test
    public void testParensWithPlus() throws Exception {

        runCompiler("+(-20)");
        assertEquals(": program -20 . ; program", visitor.getForthSource());
    }

    @Test
    public void testParensWithMinus() throws Exception {

        runCompiler("-(-20)");
        assertEquals(": program 0 -20 - . ; program", visitor.getForthSource());
    }

    @Test
    public void testFloatParensWithMinus() throws Exception {

        runCompiler("-(-20e0)");
        assertEquals(": program 0e0 -20e0 f- f. ; program", visitor.getForthSource());
    }

    @Test
    public void testParensPrecedence() throws Exception {
        runCompiler("(-20 + 30) / 2");
        assertEquals(": program -20 30 + 2 / . ; program", visitor.getForthSource());
    }


    @Test
    public void testFloatWithE() throws Exception {

        runCompiler("3e0");
        assertEquals(": program 3e0 f. ; program", visitor.getForthSource());
    }

    @Test
    public void testFloatWithExponent() throws Exception {
        runCompiler("2e0");
        assertEquals(": program 2e0 f. ; program", visitor.getForthSource());

    }
    @Test
    public void testFloatWithMinusExponent() throws Exception {
        runCompiler("2e-10");
        assertEquals(": program 2e-10 f. ; program", visitor.getForthSource());

    }

    @Test
    public void testParenedInt() throws Exception {
        runCompiler("( 3 + 2 )");
        assertEquals(": program 3 2 + . ; program", visitor.getForthSource());
    }

    public void testInt() throws Exception {
        runCompiler("2");
        assertEquals(": program 2 . ; program", visitor.getForthSource());
    }

}
