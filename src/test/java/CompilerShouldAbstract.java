import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;

/**
 * Created by john on 24/01/14.
 * Tests conversion to forth source
 * Mostly self explanatory.
 */
public class CompilerShouldAbstract {

    protected ByteArrayOutputStream outContent;
    protected ByteArrayOutputStream errContent;
    SourceGenerationVisitor visitor;
    //This was to access error stream, with object abstraction this doesn't appear to work, kept for posterity, 'failing' tests commented out.
    @BeforeMethod
    public void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    public void runCompiler(String source) {
       StringCompiler stringCompiler = new StringCompiler(source);
        try {
            visitor = stringCompiler.compile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
