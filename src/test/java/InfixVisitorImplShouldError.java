
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import static org.assertj.core.api.Assertions.*;
import static org.testng.AssertJUnit.assertEquals;

/**
/**
 * Created by john on 24/01/14.
 * Tests conversion to forth source
 * Mostly self explanatory.
 */
public class InfixVisitorImplShouldError extends CompilerShouldAbstract {

    @AfterMethod
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    public void assertErrorContains(String string) {
        assertThat(errContent.toString()).contains(string);

    }

    @Test
    public void whenFunctionUsesTheSameNameAsAVariable() throws Exception {

        runCompiler("def f(int a) {a * 2; } int f f(2);");
        assertEquals("variable 1_a variable 3_f : f 1_a ! 1_a @ 2 * . ; : program 2 f ; program", visitor.getForthSource());
        assertErrorContains("Line 1 at position 0 function name f cannot be the same as a variables, please change one.");
    }

    @Test
    public void whenVariableUsesTheSameNameAsAFunction() throws Exception {

        runCompiler("int f f(2); def f(int a) {a * 2; } ");
        assertEquals("variable 2_f variable 1_a : f 1_a ! 1_a @ 2 * . ; : program 2 f ; program", visitor.getForthSource());
        assertErrorContains("Line 1 at position 12 function name f cannot be the same as a variables");
    }

    @Test
    public void onCallToNonExistentFunction() throws Exception {
        runCompiler("f(2);");
        assertEquals(": program 2 f ; program", visitor.getForthSource());
        assertErrorContains("Line 1 at position 0 No function by the name f.");
    }

    @Test
    public void whenVariableAssignedValueNotInScope() throws Exception {

        runCompiler("int a\n a := 1;\nb := 1;\nif (a = 1) {int b 2;} else {3;}");
        assertEquals("variable 2_a variable 3_b : program 1 2_a ! 1 NO_SUCH_VARIABLE ! 2_a @ 1 = if 2 . else 3 . endif ; program", visitor.getForthSource());
        assertErrorContains("Line 3 at position 0 variable name b not in scope, unresolvable.");
    }

    @Test
    public void whenVariableExprValueNotInScope() throws Exception {

        runCompiler("int a\n a := 1;\nb + 1;\nif (a = 1) {int b 2;} else {3;}");
        assertEquals("variable 2_a variable 3_b : program 1 2_a ! NO_SUCH_VARIABLE @ 1 + . 2_a @ 1 = if 2 . else 3 . endif ; program", visitor.getForthSource());
        assertErrorContains("Line 3 at position 0 variable name b not in scope, unresolvable.");
    }

     @Test
     public void shouldGiveInformativeLackOfParenthesisMessage() throws Exception {

     runCompiler("( 3 * 2");
     assertErrorContains("Line 1 at position 7 mismatched input 'the end of the source code' expecting ')'");
     }

     @Test
     public void shouldGiveInformativeToManyOfParenthesisMessage() throws Exception {

     runCompiler("( 3 * 2 ) )");
     assertErrorContains("Line 1 at position 10 mismatched input ')' expecting {';', '*', '/', '+', '-'}");
     }

     @Test
     public void shouldGiveInformativeToManyOfParenthesisMessage2() throws Exception {

     runCompiler("( 3 * 2 ) ) )");
     assertErrorContains("Line 1 at position 10 mismatched input ')' expecting {';', '*', '/', '+', '-'}");
     }

}
