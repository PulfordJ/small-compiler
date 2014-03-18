import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by john on 24/01/14.
 * Tests conversion to forth source
 * Mostly self explanatory.
 */
public class CompilerShouldCompileWithoutError extends CompilerShouldAbstract {

    @AfterMethod
    public void cleanUpStreams() {
        assertEquals("", errContent.toString());
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void withTwoWhileLoops() throws Exception {
        runCompiler("int a while (a < 10) {a := a + 1; a;} a := 1; while (a < 10) {a := a + 1; a;}");
        assertEquals("variable 2_a : program begin 2_a @ 10 < while 2_a @ 1 + 2_a ! 2_a @ . repeat 1 2_a ! begin 2_a @ 10 < while 2_a @ 1 + 2_a ! 2_a @ . repeat ; program", visitor.getForthSource());
    }

    @Test
    public void withFunctionDefAndCallOneArgument() throws Exception {
        runCompiler("def f(int a) { a * 2; } f(2);");
        assertEquals("variable 2_a : f 2_a ! 2_a @ 2 * . ; : program 2 f ; program", visitor.getForthSource());
    }

    @Test
    public void withFunctionDefAndCallOneArgumentWithFloats() throws Exception {
        runCompiler("def f(float a) { a * 2; } f(2);");
        assertEquals("variable 2_a : f 2_a f! 2_a f@ 2e0 f* f. ; : program 2e0 f ; program", visitor.getForthSource());
    }

    @Test
    public void withFunctionDefAndCallOneVariableArgument() throws Exception {
        runCompiler("def f(int a) { a * 2; } int a; f(a);");
        assertEquals("variable 2_a variable 4_a : f 2_a ! 2_a @ 2 * . ; : program 4_a @ f ; program", visitor.getForthSource());
    }

    @Test
    public void withFunctionDefAndCallOneExpressionArgument() throws Exception {
        runCompiler("def f(int a) { a * 2; } f(1+2);");
        assertEquals("variable 2_a : f 2_a ! 2_a @ 2 * . ; : program 1 2 + f ; program", visitor.getForthSource());
    }

    @Test
    public void withFunctionDefAndCallZeroArgument() throws Exception {
        runCompiler("def f() { 2; } f();");
        assertEquals(": f 2 . ; : program f ; program", visitor.getForthSource());
    }

    @Test
    public void whenFunctionDefAndCallTwoArgument() throws Exception {
        runCompiler("def f(int a, int b) { a * b * 2; } f(2, 3);");
        assertThat(visitor.getForthSource()).isEqualTo("variable 2_a variable 2_b : f 2_b ! 2_a ! 2_a @ 2_b @ * 2 * . ; : program 2 3 f ; program");
    }

    @Test
    public void whenWhileLoopCounter() throws Exception {
        runCompiler("int a while (a < 10) {a := a + 1; a;}");
        assertEquals("variable 2_a : program begin 2_a @ 10 < while 2_a @ 1 + 2_a ! 2_a @ . repeat ; program", visitor.getForthSource());
    }

    @Test
    public void whenTrueIfStatement() throws Exception {
        runCompiler("int a\n a := 1;\nif (a = 1) {2;} ");
        assertEquals("variable 2_a : program 1 2_a ! 2_a @ 1 = if 2 . endif ; program", visitor.getForthSource());
    }

    @Test
    public void whenTrueIfStatementWithFloats() throws Exception {
        runCompiler("int a\n a := 1e0;\nif (a = 1e0) {2;}");
        assertEquals("variable 2_a : program 1e0 2_a f! 2_a f@ 1e0 f= if 2e0 f. endif ; program", visitor.getForthSource());
    }

    @Test
    public void whenIfStatementWithTrueVariable() throws Exception {
        runCompiler("if (true) {1;}");
        assertEquals(": program -1 if 1 . endif ; program", visitor.getForthSource());
    }

    @Test
    public void whenIfStatementWithFalseVariable() throws Exception {
        runCompiler("if (false) {1;}");
        assertEquals(": program 0 if 1 . endif ; program", visitor.getForthSource());
    }

    @Test
    public void whenIfStatementWithOrStatement() throws Exception {
        runCompiler("if (true or false) {1;}");
        assertEquals(": program -1 0 or if 1 . endif ; program", visitor.getForthSource());
    }

    @Test
    public void whenIfStatementWithAndStatement() throws Exception {
        runCompiler("if (true and true) {1;}");
        assertEquals(": program -1 -1 and if 1 . endif ; program", visitor.getForthSource());
    }

    @Test
    public void whenTrueIfStatementWithNewLinesInside() throws Exception {
        runCompiler("int a\n a := 1;\nif (a = 1) \n {2;}\n ");
        assertEquals("variable 2_a : program 1 2_a ! 2_a @ 1 = if 2 . endif ; program", visitor.getForthSource());
    }

    @Test
    public void whenTrueIfElseStatement() throws Exception {
        runCompiler("int a\n a := 1;\nif (a = 1) {2;} else {3;}");
        assertEquals("variable 2_a : program 1 2_a ! 2_a @ 1 = if 2 . else 3 . endif ; program", visitor.getForthSource());
    }

    @Test
    public void whenTrueIfElseStatementWithScopedVariables() throws Exception {
        runCompiler("int a\n a := 1;\nif (a = 1) {int a; a:= 1; a; 2;} else {int a; a := 2; a; 3;}");
        assertEquals("variable 2_a variable 3_a variable 4_a : program 1 2_a ! 2_a @ 1 = if 1 3_a ! 3_a @ . 2 . else 2 4_a ! 4_a @ . 3 . endif ; program", visitor.getForthSource());
    }

    @Test
    public void whenTrueIfElseStatementWithNewLinesInside() throws Exception {
        runCompiler("int a\n a := 1;\nif (a = 1) \n {2;}\n else\n {3;}\n");
        assertEquals("variable 2_a : program 1 2_a ! 2_a @ 1 = if 2 . else 3 . endif ; program", visitor.getForthSource());
    }

    @Test
    public void whenVariableDeclaration() throws Exception {
        runCompiler("int a");
        assertEquals("variable 2_a : program  ; program", visitor.getForthSource());
    }

    @Test
    public void whenVariableDeclarationAndUse() throws Exception {
        runCompiler("int a a;");
        assertEquals("variable 2_a : program 2_a @ . ; program", visitor.getForthSource());
    }

    @Test
    public void whenVariableDeclarationAssignmentAndUse() throws Exception {
        runCompiler("int a a:=3;\n a;");
        assertEquals("variable 2_a : program 3 2_a ! 2_a @ . ; program", visitor.getForthSource());
    }

    @Test
    public void whenVariableDeclarationAssignmentAndUseWithFloats() throws Exception {
        runCompiler("float a a:=3;\n a;");
        assertEquals("variable 2_a : program 3e0 2_a f! 2_a f@ f. ; program", visitor.getForthSource());
    }

    @Test
    public void whenVariableDeclarationAssignmentAndUnaryMinusUse() throws Exception {
        runCompiler("int a a:=3;\n -a;");
        assertEquals("variable 2_a : program 3 2_a ! 0 2_a @ - . ; program", visitor.getForthSource());
    }

    @Test
    public void whenVariableDeclarationAssignmentAndUseInExpression() throws Exception {
        runCompiler("int a a:=3;\n 3+a;");
        assertEquals("variable 2_a : program 3 2_a ! 3 2_a @ + . ; program", visitor.getForthSource());
    }

    @Test
    public void whenVariableDeclarationAssignmentAndUseInFloatExpression() throws Exception {
        runCompiler("int a a:=3;\n 3e0+a;");
        assertEquals("variable 2_a : program 3e0 2_a f! 3e0 2_a f@ f+ f. ; program", visitor.getForthSource());
    }

    @Test
    public void whenMultipleVariableDeclaration() throws Exception {
        runCompiler("int a int b");
        assertEquals("variable 2_a variable 2_b : program  ; program", visitor.getForthSource());
    }
    @Test
    public void whenVariableDeclarationAndAssignment() throws Exception {
        runCompiler("int a a := 1;");
        assertEquals("variable 2_a : program 1 2_a ! ; program", visitor.getForthSource());
    }

    @Test
    public void whenAdd() throws Exception {
        runCompiler("3e0 + 5;");
        assertEquals(": program 3e0 5e0 f+ f. ; program", visitor.getForthSource());
    }

    @Test
    public void whenVisitSub() throws Exception {
        runCompiler("5e0 - 3;");
        assertEquals(": program 5e0 3e0 f- f. ; program", visitor.getForthSource());
    }

    @Test
    public void whenVisitMul() throws Exception {
        runCompiler("3e0 * 5e0;");
        assertEquals(": program 3e0 5e0 f* f. ; program", visitor.getForthSource());
    }

    @Test
    public void whenVisitDiv() throws Exception {
        runCompiler("50e0 / 100;");
        assertEquals(": program 50e0 100e0 f/ f. ; program", visitor.getForthSource());
    }

    @Test
    public void whenVisitMulDivAddSubOrder() throws Exception {
        runCompiler("3 + 2 * 5;");
        assertEquals(": program 3 2 5 * + . ; program", visitor.getForthSource());
    }

    @Test
    public void whenVisitMulDivAddSubOrder2() throws Exception {
        runCompiler("3 * 2 + 5;");
        assertEquals(": program 3 2 * 5 + . ; program", visitor.getForthSource());
    }

    @Test
    public void whenVisitMulDivAddSubOrder3() throws Exception {
        runCompiler("3 - 2 / 5;");
        assertEquals(": program 3 2 5 / - . ; program", visitor.getForthSource());
    }

    @Test
    public void whenVisitMulDivAddSubOrder24() throws Exception {
        runCompiler("3 / 2 - 5;");
        assertEquals(": program 3 2 / 5 - . ; program", visitor.getForthSource());
    }

    @Test
    public void whenPlusSignedNumber() throws Exception {
        runCompiler("+2;");
        assertEquals(": program 2 . ; program", visitor.getForthSource());
    }

    @Test
    public void whenPlusSignedNumberInParenedExpr() throws Exception {
        runCompiler("( +2 + 2 );");
        assertEquals(": program 2 2 + . ; program", visitor.getForthSource());
    }

    @Test
    public void whenSignedNumberWithSpace() throws Exception {
        runCompiler("+ 2;");
        assertEquals(": program 2 . ; program", visitor.getForthSource());
    }

    @Test
    public void whenSignedNumberWithSpace2() throws Exception {
        runCompiler("- 2;");
        assertEquals(": program 0 2 - . ; program", visitor.getForthSource());
    }

    @Test
    public void whenSignedNumberWithSpaceInExpr() throws Exception {
        runCompiler("+ 2 - 3;");
        assertEquals(": program 2 3 - . ; program", visitor.getForthSource());
    }

    @Test
    public void whenSignedNumberWithSpaceInExpr2() throws Exception {
        runCompiler("+ 2 + 3;");
        assertEquals(": program 2 3 + . ; program", visitor.getForthSource());
    }

    @Test
    public void whenSignedNumbersWithSpaceInExpr() throws Exception {
        runCompiler("+ 2 + +3;");
        assertEquals(": program 2 3 + . ; program", visitor.getForthSource());
    }

    @Test
    public void whenSignedNumberWithSpaceInExpr3() throws Exception {
        runCompiler("(+ 2 + 3);");
        assertEquals(": program 2 3 + . ; program", visitor.getForthSource());
    }

    @Test
    public void whenSignedNumberWithOutSpaceInExpr4() throws Exception {
        runCompiler("(+ 2 + 3);");
        assertEquals(": program 2 3 + . ; program", visitor.getForthSource());
    }

    @Test
    public void whenSignedNumberWithSpaceInExpr4() throws Exception {
        runCompiler("(2 + + 3);");
        assertEquals(": program 2 3 + . ; program", visitor.getForthSource());
    }

    @Test
    public void whenSignedNumberWithSpaceInExpr5() throws Exception {
        runCompiler("(+3 + + 2);");
        assertEquals(": program 3 2 + . ; program", visitor.getForthSource());
    }

    @Test
    public void whenMinusSignedNumber() throws Exception {
        runCompiler("-20;");
        assertEquals(": program 0 20 - . ; program", visitor.getForthSource());
    }

    @Test
    public void whenParensNum() throws Exception {
        runCompiler("(20);");
        assertEquals(": program 20 . ; program", visitor.getForthSource());
    }

    @Test
    public void whenParensMinusNum() throws Exception {
        runCompiler("(-20);");
        assertEquals(": program 0 20 - . ; program", visitor.getForthSource());
    }

    @Test
    public void whenParensWithPlus() throws Exception {
        runCompiler("+(-20);");
        assertEquals(": program 0 20 - . ; program", visitor.getForthSource());
    }

    @Test
    public void whenParensWithMinus() throws Exception {
        runCompiler("-(-20);");
        assertEquals(": program 0 0 20 - - . ; program", visitor.getForthSource());
    }

    @Test
    public void whenFloatParensWithMinus() throws Exception {
        runCompiler("-(-20e0);");
        assertEquals(": program 0e0 0e0 20e0 f- f- f. ; program", visitor.getForthSource());
    }

    @Test
    public void whenParensPrecedence() throws Exception {
        runCompiler("(-20 + 30) / 2;");
        assertEquals(": program 0 20 - 30 + 2 / . ; program", visitor.getForthSource());
    }


    @Test
    public void whenFloatWithE() throws Exception {
        runCompiler("3e0;");
        assertEquals(": program 3e0 f. ; program", visitor.getForthSource());
    }

    @Test
    public void whenFloatWithExponent() throws Exception {
        runCompiler("2e0;");
        assertEquals(": program 2e0 f. ; program", visitor.getForthSource());
    }

    @Test
    public void whenFloatWithMinusExponent() throws Exception {
        runCompiler("2e-10;");
        assertEquals(": program 2e-10 f. ; program", visitor.getForthSource());
    }

    @Test
    public void whenParenedInt() throws Exception {
        runCompiler("( 3 + 2 );");
        assertEquals(": program 3 2 + . ; program", visitor.getForthSource());
    }

    @Test
    public void whenInt() throws Exception {
        runCompiler("2;");
        assertEquals(": program 2 . ; program", visitor.getForthSource());
    }

}
