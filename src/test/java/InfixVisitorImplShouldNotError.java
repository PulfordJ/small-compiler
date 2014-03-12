
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.*;


import static org.assertj.core.api.Assertions.*;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by john on 24/01/14.
 * Tests conversion to forth source
 * Mostly self explanatory.
 */
public class InfixVisitorImplShouldNotError extends CompilerShouldAbstract {

    @AfterMethod
    public void cleanUpStreams() {
        assertEquals("", errContent.toString());
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testTwoWhileLoops() throws Exception {

        runCompiler("int a while (a < 10) {a := a + 1; a;} a := 1; while (a < 10) {a := a + 1; a;}");
        assertEquals("variable 2_a : program begin 2_a @ 10 < while 2_a @ 1 + 2_a ! 2_a @ . repeat 1 2_a ! begin 2_a @ 10 < while 2_a @ 1 + 2_a ! 2_a @ . repeat ; program", visitor.getForthSource());
    }

    @Test
    public void testFunctionDefAndCallOneArgument() throws Exception {
        runCompiler("def f(int a) { a * 2; } f(2);");
        assertEquals("variable 2_a : f 2_a ! 2_a @ 2 * . ; : program 2 f ; program", visitor.getForthSource());
    }

    @Test
    public void testFunctionDefAndCallOneVariableArgument() throws Exception {
        runCompiler("def f(int a) { a * 2; } int a; f(a);");
        assertEquals("variable 2_a variable 4_a : f 2_a ! 2_a @ 2 * . ; : program 4_a @ f ; program", visitor.getForthSource());
    }

    @Test
    public void testFunctionDefAndCallOneExpressionArgument() throws Exception {
        runCompiler("def f(int a) { a * 2; } f(1+2);");
        assertEquals("variable 2_a : f 2_a ! 2_a @ 2 * . ; : program 1 2 + f ; program", visitor.getForthSource());
    }

    @Test
    public void testFunctionDefAndCallZeroArgument() throws Exception {

        runCompiler("def f() { 2; } f();");
        assertEquals(": f 2 . ; : program f ; program", visitor.getForthSource());
    }

    @Test
    public void testFunctionDefAndCallTwoArgument() throws Exception {

        runCompiler("def f(int a, int b) { a * b * 2; } f(2, 3);");
        assertThat(visitor.getForthSource()).isEqualTo("variable 2_a variable 2_b : f 2_b ! 2_a ! 2_a @ 2_b @ * 2 * . ; : program 2 3 f ; program");
    }

    @Test
    public void testWhileLoopCounter() throws Exception {

        runCompiler("int a while (a < 10) {a := a + 1; a;}");
        assertEquals("variable 2_a : program begin 2_a @ 10 < while 2_a @ 1 + 2_a ! 2_a @ . repeat ; program", visitor.getForthSource());
    }

    @Test
    public void testTrueIfStatement() throws Exception {

        runCompiler("int a\n a := 1;\nif (a = 1) {2;} ");
        assertEquals("variable 2_a : program 1 2_a ! 2_a @ 1 = if 2 . endif ; program", visitor.getForthSource());
    }

    @Test
    public void testTrueIfStatementWithFloats() throws Exception {

        runCompiler("int a\n a := 1e0;\nif (a = 1e0) {2;}");
        assertEquals("variable 2_a : program 1e0 2_a f! 2_a f@ 1e0 f= if 2e0 f. endif ; program", visitor.getForthSource());
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
        assertEquals("variable 2_a : program 1 2_a ! 2_a @ 1 = if 2 . endif ; program", visitor.getForthSource());
    }

    @Test
    public void testTrueIfElseStatement() throws Exception {

        runCompiler("int a\n a := 1;\nif (a = 1) {2;} else {3;}");
        assertEquals("variable 2_a : program 1 2_a ! 2_a @ 1 = if 2 . else 3 . endif ; program", visitor.getForthSource());
    }

    @Test
    public void testTrueIfElseStatementWithScopedVariables() throws Exception {

        runCompiler("int a\n a := 1;\nif (a = 1) {int a; a:= 1; a; 2;} else {int a; a := 2; a; 3;}");
        assertEquals("variable 2_a variable 3_a variable 4_a : program 1 2_a ! 2_a @ 1 = if 1 3_a ! 3_a @ . 2 . else 2 4_a ! 4_a @ . 3 . endif ; program", visitor.getForthSource());
    }

    @Test
    public void testTrueIfElseStatementWithNewLinesInside() throws Exception {

        runCompiler("int a\n a := 1;\nif (a = 1) \n {2;}\n else\n {3;}\n");
        assertEquals("variable 2_a : program 1 2_a ! 2_a @ 1 = if 2 . else 3 . endif ; program", visitor.getForthSource());
    }

    @Test
    public void testVariableDeclaration() throws Exception {

        runCompiler("int a");
        assertEquals("variable 2_a : program  ; program", visitor.getForthSource());
    }

    @Test
    public void testVariableDeclarationAndUse() throws Exception {

        runCompiler("int a a;");
        assertEquals("variable 2_a : program 2_a @ . ; program", visitor.getForthSource());
    }

    @Test
    public void testVariableDeclarationAssignmentAndUse() throws Exception {

        runCompiler("int a a:=3;\n a;");
        assertEquals("variable 2_a : program 3 2_a ! 2_a @ . ; program", visitor.getForthSource());
    }

    @Test
    public void testVariableDeclarationAssignmentAndUnaryMinusUse() throws Exception {

        runCompiler("int a a:=3;\n -a;");
        assertEquals("variable 2_a : program 3 2_a ! 0 2_a @ - . ; program", visitor.getForthSource());
    }

    @Test
    public void testVariableDeclarationAssignmentAndUseInExpression() throws Exception {

        runCompiler("int a a:=3;\n 3+a;");
        assertEquals("variable 2_a : program 3 2_a ! 3 2_a @ + . ; program", visitor.getForthSource());
    }

    @Test
    public void testVariableDeclarationAssignmentAndUseInFloatExpression() throws Exception {

        runCompiler("int a a:=3;\n 3e0+a;");
        assertEquals("variable 2_a : program 3e0 2_a f! 3e0 2_a f@ f+ f. ; program", visitor.getForthSource());
    }

    @Test
    public void testMultipleVariableDeclaration() throws Exception {

        runCompiler("int a int b");
        assertEquals("variable 2_a variable 2_b : program  ; program", visitor.getForthSource());
    }
    @Test
    public void testVariableDeclarationAndAssignment() throws Exception {

        runCompiler("int a a := 1;");
        assertEquals("variable 2_a : program 1 2_a ! ; program", visitor.getForthSource());
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

    @Test
    public void testInt() throws Exception {
        runCompiler("2;");
        assertEquals(": program 2 . ; program", visitor.getForthSource());
    }

}
