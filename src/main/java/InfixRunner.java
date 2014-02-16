import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: john
 * Date: 1/24/14
 * Time: 12:32 PM
 */
public class InfixRunner {
    final static String FORTHEXTENSION = "fs";

    public static void main(String[] args) throws Exception {
        try {
            final String filepathWithoutExtention = Utilities.getFilenameWithoutExtention(args[0]);

            //Run compiler.
            FileCompiler fileCompiler = new FileCompiler(args[0]);
            InfixVisitorImpl visitor = fileCompiler.compile();

            //Save parse tree.
            visitor.outputPSGraphToFile(filepathWithoutExtention);

            //Save translated output.
            final String destinationSourceFilename = filepathWithoutExtention+"."+FORTHEXTENSION;
            PrintWriter srcOut = new PrintWriter(destinationSourceFilename);
            srcOut.println(visitor.getForthSource());
            srcOut.flush();


        } //Handle various incorrect uses of the runner.
        catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("No arguments given, please supply input file path.");
        }
        catch (FileNotFoundException exception) {
            System.out.println("The file " + args[0] + " could not be found, perhaps this is not the correct path?");
        }

    }
}
