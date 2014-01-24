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
        InfixToPostfixVisitorImpl visitor = new InfixToPostfixVisitorImpl();
        visitor.visit(tree);
    }

    @org.junit.Test
    public void testAdd() throws Exception {

        runCompiler("3e + 5");
        assertEquals("3e 5e f+ f.\n", outContent.toString());
    }

    @org.junit.Test
    public void testVisitSub() throws Exception {

        runCompiler("5e - 3");
        assertEquals("5e 3e f- f.\n", outContent.toString());
    }
    @org.junit.Test
    public void testVisitMul() throws Exception {

        runCompiler("3e * 5e");
        assertEquals("3e 5e f* f.\n", outContent.toString());
    }
    @org.junit.Test
    public void testVisitDiv() throws Exception {

        runCompiler("50e / 100");
        assertEquals("50e 100e f/ f.\n", outContent.toString());
    }

    @org.junit.Test
    public void testVisitMulDivAddSubOrder() throws Exception {

        runCompiler("3 + 2 * 5");
        assertEquals("3e 2e 5e f* f+ f.\n", outContent.toString());
    }

    @org.junit.Test
    public void testPlusSignedNumber() throws Exception {

        runCompiler("+2");
        assertEquals("+2e f.\n", outContent.toString());
    }

    @org.junit.Test
    public void testMinusSignedNumber() throws Exception {

        runCompiler("-20");
        assertEquals("-20e f.\n", outContent.toString());
    }

    @Test
    public void testParensNum() throws Exception {

        runCompiler("(-20)");
        assertEquals("-20e f.\n", outContent.toString());
    }

    @Test
    public void testParensPrecedence() throws Exception {
        runCompiler("(-20 + 30) / 2");
        assertEquals("-20e 30e f+ 2e f/ f.\n", outContent.toString());
    }


    @org.junit.Test
    public void testFloatWithE() throws Exception {

        runCompiler("3e");
        assertEquals("3e f.\n", outContent.toString());
    }

    @org.junit.Test
    public void testFloatWithExponent() throws Exception {
        runCompiler("2e0");
        assertEquals("2e0 f.\n", outContent.toString());

    }

    @org.junit.Test
    public void testInt() throws Exception {
        runCompiler("2");
        assertEquals("2e f.\n", outContent.toString());
    }

}
