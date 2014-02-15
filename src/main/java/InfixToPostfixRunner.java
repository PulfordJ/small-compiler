import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.print.PrintException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: john
 * Date: 1/24/14
 * Time: 12:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class InfixToPostfixRunner {
    final static String FORTHEXTENSION = "fs";


    public static void main(String[] args) throws Exception {
        try {
            final String filepathWithoutExtention = Utilities.getFilenameWithoutExtention(args[0]);


            InfixToPostfixLexer lexer = new InfixToPostfixLexer(new ANTLRFileStream(args[0]));
            InfixToPostfixVisitorImpl visitor = new InfixToPostfixVisitorImpl();

            String optIntTokenName = lexer.getTokenNames()[8];
            if (Utilities.programContainsToken(new ANTLRFileStream(args[0]), optIntTokenName)) {
                visitor.enableFloatMode();
            }



            CommonTokenStream tokens = new CommonTokenStream(lexer);
            InfixToPostfixParser p = new InfixToPostfixParser(tokens);

            p.removeErrorListeners();
            p.addErrorListener(new UnderlineListener());
            ParseTree tree = p.start();

            visitor.addParser(p);
            visitor.visit(tree);

            visitor.outputPSGraphToFile(filepathWithoutExtention);

            final String destinationSourceFilename = filepathWithoutExtention+"."+FORTHEXTENSION;
            PrintWriter srcOut = new PrintWriter(destinationSourceFilename);
            srcOut.println(visitor.getForthSource());
            srcOut.flush();

        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("No arguments given, please supply input file path.");
        } catch (FileNotFoundException exception) {
            System.out.println("The file " + args[0] + " could not be found, perhaps this is not the correct path?");
        }

    }
}
