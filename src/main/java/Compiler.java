import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.List;

abstract class Compiler {
    String FLOATTOKENNAME = "FLOAT";

    //This is used to determine whether a token exists in a program.
    private static boolean programContainsToken(CharStream charStream, String tokenToFind) throws IOException {
        InfixToPostfixLexer lexer = new InfixToPostfixLexer(charStream);
        List<? extends Token> allTokens = lexer.getAllTokens();

        for (Token token : allTokens) {
            if (lexer.getTokenNames()[token.getType()].equals(tokenToFind)) {
                return true;
            }
        }
        return false;
    }

    //Implementations of this allow for the compile method code to only be written once.
    public abstract CharStream createCharStream() throws IOException;


    /**
     * Compiles and returns visitor to extract results from
     *
     * @Charstream the stream of source code to compile.
     */
    public InfixToPostfixVisitorImpl compile() throws IOException {
        InfixToPostfixLexer lexer = new InfixToPostfixLexer(createCharStream());
        InfixToPostfixVisitorImpl visitor = new InfixToPostfixVisitorImpl();

        //Check if floats exist so that visitor knows which version of forth to compile into, essentially deciding start -> expr or start -> floatExpr in my specified forth grammar.
        if (programContainsToken(createCharStream(), FLOATTOKENNAME)) {
            visitor.enableFloatMode();
        }

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        InfixToPostfixParser p = new InfixToPostfixParser(tokens);

        //Added my own error listener so removed the default.
        p.removeErrorListeners();
        p.addErrorListener(new UnderlineListener());

        //Get the initial point of the parse tree.
        ParseTree tree = p.start();

        //Traverse the parser from the initial point with the visitor, the visitor being in charge of language translation.
        visitor.addParser(p);
        visitor.visit(tree);
        return visitor;
    }
}
