
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by john on 24/01/14.
 * Tests conversion to forth source
 * Mostly self explanatory.
 */
public class InfixVisitorImplShouldError extends CompilerShouldAbstract {

    @AfterMethod
    public void cleanUpStreams() {
        assertEquals("", errContent.toString());
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testFunctionCanNotHaveVariableName() throws Exception {

        runCompiler("def f(int a) {a * 2; } int f f(2);");
        assertEquals("variable 1_a variable 3_f : f { 1_a } 1_a @ 2 * . ; : program 2 f . ; program", visitor.getForthSource());
    }

}
