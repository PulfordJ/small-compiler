import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created with IntelliJ IDEA.
 * User: john
 * Date: 1/24/14
 * Time: 12:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class InfixToPostfixRunner {
    public static void main(String[] args) throws Exception {
        try {
        InfixToPostfixLexer lexer = new InfixToPostfixLexer(new ANTLRFileStream(args[0])); //TODO handle incorrect file.
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        InfixToPostfixParser p = new InfixToPostfixParser(tokens);

        //ParserRuleContext tree = p.start();

        //p.setBuildParseTree(true);
        //p.addParseListener(new InfixToPostfixListenerImpl());
        ParseTree tree = p.start();
        InfixToPostfixVisitorImpl visitor = new InfixToPostfixVisitorImpl();
        visitor.visit(tree);
        System.out.println(tree.toStringTree(p));
        //ParserRuleContext t = p.start();
        }
        catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("No arguments given, please supply input file path.");
        }

    }
}
