
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import static org.assertj.core.api.Assertions.*;/**
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
    public void testFunctionCanNotHaveVariableName() throws Exception {

        runCompiler("def f(int a) {a * 2; } int f f(2);");
        assertEquals("variable 1_a variable 3_f : f { 1_a } 1_a @ 2 * . ; : program 2 f . ; program", visitor.getForthSource());
        //TODO change 12 to 1...
        assertErrorContains("Line 12 at position 0 function name f cannot be the same as a variables, please change one.");
    }



}
