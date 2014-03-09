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
        assertEquals("", errContent.toString());
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
    public void testFunctionDefAndCallOneArgument() throws Exception {

        runCompiler("def f(int a) { a * 2; } f(2);");
        assertEquals("variable a : f { a } a @ 2 * . ; : program 2 f . ; program", visitor.getForthSource());
    }

    @Test
    public void testWhileLoopCounter() throws Exception {

        runCompiler("while (a < 10) {a := a + 1; a;}");
        assertEquals(": program begin a @ 10 < while a @ 1 + a ! a @ . repeat ; program", visitor.getForthSource());
    }

    @Test
    public void testTrueIfStatement() throws Exception {

        runCompiler("int a\n a := 1;\nif (a = 1) {2;} ");
        assertEquals("variable a : program 1 a ! a @ 1 = if 2 . endif ; program", visitor.getForthSource());
    }


    @Test
    public void testTrueIfStatementWithFloats() throws Exception {

        runCompiler("int a\n a := 1e0;\nif (a = 1e0) {2;}");
        assertEquals("variable a : program 1e0 a f! a f@ 1e0 f= if 2e0 f. endif ; program", visitor.getForthSource());
    }

    @Test
    public void testIfStatementWithTrueVariable() throws Exception {

        runCompiler("if (true) {1;}");
        assertEquals(": program -1 if 1 . endif ; program", visitor.getForthSource());
    }

    @Test
    public void testIfStatementWithFalseVariable() throws Exception {

        runCompiler("if (false) {1;}");
        assertEquals(": program 0 if 1 . endif ; program", visitor.getForthSource());
    }

    @Test
    public void testIfStatementWithOrStatement() throws Exception {

        runCompiler("if (true or false) {1;}");
        assertEquals(": program -1 0 or if 1 . endif ; program", visitor.getForthSource());
    }

    @Test
    public void testIfStatementWithAndStatement() throws Exception {

        runCompiler("if (true and true) {1;}");
        assertEquals(": program -1 -1 and if 1 . endif ; program", visitor.getForthSource());
    }

    @Test
    public void testTrueIfStatementWithNewLinesInside() throws Exception {

        runCompiler("int a\n a := 1;\nif (a = 1) \n {2;}\n ");
        assertEquals("variable a : program 1 a ! a @ 1 = if 2 . endif ; program", visitor.getForthSource());
    }

    @Test
    public void testTrueIfElseStatement() throws Exception {

        runCompiler("int a\n a := 1;\nif (a = 1) {2;} else {3;}");
        assertEquals("variable a : program 1 a ! a @ 1 = if 2 . else 3 . endif ; program", visitor.getForthSource());
    }

    @Test
    public void testTrueIfElseStatementWithNewLinesInside() throws Exception {

        runCompiler("int a\n a := 1;\nif (a = 1) \n {2;}\n else\n {3;}\n");
        assertEquals("variable a : program 1 a ! a @ 1 = if 2 . else 3 . endif ; program", visitor.getForthSource());
    }

    @Test
    public void testVariableDeclaration() throws Exception {

        runCompiler("int a");
        assertEquals("variable a : program  ; program", visitor.getForthSource());
    }

    @Test
    public void testVariableDeclarationAndUse() throws Exception {

        runCompiler("int a a;");
        assertEquals("variable a : program a @ . ; program", visitor.getForthSource());
    }

    @Test
    public void testVariableDeclarationAssignmentAndUse() throws Exception {

        runCompiler("int a a:=3;\n a;");
        assertEquals("variable a : program 3 a ! a @ . ; program", visitor.getForthSource());
    }

    @Test
    public void testVariableDeclarationAssignmentAndUnaryMinusUse() throws Exception {

        runCompiler("int a a:=3;\n -a;");
        assertEquals("variable a : program 3 a ! 0 a @ - . ; program", visitor.getForthSource());
    }

    @Test
    public void testVariableDeclarationAssignmentAndUseInExpression() throws Exception {

        runCompiler("int a a:=3;\n 3+a;");
        assertEquals("variable a : program 3 a ! 3 a @ + . ; program", visitor.getForthSource());
    }

    @Test
    public void testVariableDeclarationAssignmentAndUseInFloatExpression() throws Exception {

        runCompiler("int a a:=3;\n 3e0+a;");
        assertEquals("variable a : program 3e0 a f! 3e0 a f@ f+ f. ; program", visitor.getForthSource());
    }

    @Test
    public void testMultipleVariableDeclaration() throws Exception {

        runCompiler("int a int b");
        assertEquals("variable a variable b : program  ; program", visitor.getForthSource());
    }
    @Test
    public void testVariableDeclarationAndAssignment() throws Exception {

        runCompiler("int a a := 1;");
        assertEquals("variable a : program 1 a ! ; program", visitor.getForthSource());
    }

    @Test
    public void testAdd() throws Exception {

        runCompiler("3e0 + 5;");
        assertEquals(": program 3e0 5e0 f+ f. ; program", visitor.getForthSource());
    }

    @Test
    public void testVisitSub() throws Exception {

        runCompiler("5e0 - 3;");
        assertEquals(": program 5e0 3e0 f- f. ; program", visitor.getForthSource());
    }

    @Test
    public void testVisitMul() throws Exception {

        runCompiler("3e0 * 5e0;");
        assertEquals(": program 3e0 5e0 f* f. ; program", visitor.getForthSource());
    }

    @Test
    public void testVisitDiv() throws Exception {

        runCompiler("50e0 / 100;");
        assertEquals(": program 50e0 100e0 f/ f. ; program", visitor.getForthSource());
    }

    @Test
    public void testVisitMulDivAddSubOrder() throws Exception {

        runCompiler("3 + 2 * 5;");
        assertEquals(": program 3 2 5 * + . ; program", visitor.getForthSource());
    }

    @Test
    public void testVisitMulDivAddSubOrder2() throws Exception {

        runCompiler("3 * 2 + 5;");
        assertEquals(": program 3 2 * 5 + . ; program", visitor.getForthSource());
    }

    @Test
    public void testVisitMulDivAddSubOrder3() throws Exception {

        runCompiler("3 - 2 / 5;");
        assertEquals(": program 3 2 5 / - . ; program", visitor.getForthSource());
    }

    @Test
    public void testVisitMulDivAddSubOrder24() throws Exception {

        runCompiler("3 / 2 - 5;");
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

        runCompiler("+2;");
        assertEquals(": program 2 . ; program", visitor.getForthSource());
    }
    @Test
    public void testPlusSignedNumberInParenedExpr() throws Exception {

        runCompiler("( +2 + 2 );");
        assertEquals(": program 2 2 + . ; program", visitor.getForthSource());
    }

    @Test
    public void testSignedNumberWithSpace() throws Exception {

        runCompiler("+ 2;");
        assertEquals(": program 2 . ; program", visitor.getForthSource());
    }

    @Test
    public void testSignedNumberWithSpace2() throws Exception {

        runCompiler("- 2;");
        assertEquals(": program -2 . ; program", visitor.getForthSource());
    }

    @Test
    public void testSignedNumberWithSpaceInExpr() throws Exception {

        runCompiler("+ 2 - 3;");
        assertEquals(": program 2 3 - . ; program", visitor.getForthSource());
    }

    @Test
    public void testSignedNumberWithSpaceInExpr2() throws Exception {

        runCompiler("+ 2 + 3;");
        assertEquals(": program 2 3 + . ; program", visitor.getForthSource());
    }

    @Test
    public void testSignedNumbersWithSpaceInExpr() throws Exception {

        runCompiler("+ 2 + +3;");
        assertEquals(": program 2 3 + . ; program", visitor.getForthSource());
    }

    @Test
    public void testSignedNumberWithSpaceInExpr3() throws Exception {

        runCompiler("(+ 2 + 3);");
        assertEquals(": program 2 3 + . ; program", visitor.getForthSource());
    }

    @Test
    public void testSignedNumberWithOutSpaceInExpr4() throws Exception {

        runCompiler("(+ 2 + 3);");
        assertEquals(": program 2 3 + . ; program", visitor.getForthSource());
    }

    @Test
    public void testSignedNumberWithSpaceInExpr4() throws Exception {

        runCompiler("(2 + + 3);");
        assertEquals(": program 2 3 + . ; program", visitor.getForthSource());
    }

    @Test
    public void testSignedNumberWithSpaceInExpr5() throws Exception {

        runCompiler("(+3 + + 2);");
        assertEquals(": program 3 2 + . ; program", visitor.getForthSource());
    }

    @Test
    public void testMinusSignedNumber() throws Exception {

        runCompiler("-20;");
        assertEquals(": program -20 . ; program", visitor.getForthSource());
    }

    @Test
    public void testParensNum() throws Exception {

        runCompiler("(-20);");
        assertEquals(": program -20 . ; program", visitor.getForthSource());
    }

    @Test
    public void testParensWithPlus() throws Exception {

        runCompiler("+(-20);");
        assertEquals(": program -20 . ; program", visitor.getForthSource());
    }

    @Test
    public void testParensWithMinus() throws Exception {

        runCompiler("-(-20);");
        assertEquals(": program 0 -20 - . ; program", visitor.getForthSource());
    }

    @Test
    public void testFloatParensWithMinus() throws Exception {

        runCompiler("-(-20e0);");
        assertEquals(": program 0e0 -20e0 f- f. ; program", visitor.getForthSource());
    }

    @Test
    public void testParensPrecedence() throws Exception {
        runCompiler("(-20 + 30) / 2;");
        assertEquals(": program -20 30 + 2 / . ; program", visitor.getForthSource());
    }


    @Test
    public void testFloatWithE() throws Exception {

        runCompiler("3e0;");
        assertEquals(": program 3e0 f. ; program", visitor.getForthSource());
    }

    @Test
    public void testFloatWithExponent() throws Exception {
        runCompiler("2e0;");
        assertEquals(": program 2e0 f. ; program", visitor.getForthSource());

    }
    @Test
    public void testFloatWithMinusExponent() throws Exception {
        runCompiler("2e-10;");
        assertEquals(": program 2e-10 f. ; program", visitor.getForthSource());

    }

    @Test
    public void testParenedInt() throws Exception {
        runCompiler("( 3 + 2 );");
        assertEquals(": program 3 2 + . ; program", visitor.getForthSource());
    }

    public void testInt() throws Exception {
        runCompiler("2;");
        assertEquals(": program 2 . ; program", visitor.getForthSource());
    }

}
