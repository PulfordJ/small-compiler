import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.List;

abstract class Compiler {

    //This is used to determine whether a token exists in a program.
    private static boolean programContainsToken(CharStream charStream, String tokenToFind) {
        InfixLexer lexer = new InfixLexer(charStream);
        List<? extends Token> allTokens = lexer.getAllTokens();

        for (Token token : allTokens) {
            if (lexer.getTokenNames()[token.getType()].equals(tokenToFind)) {
                return true;
            }
        }
        return false;
    }

    //Implementations of this allow for the compile method code to only be written once.
    protected abstract CharStream createCharStream() throws IOException;


    /**
     * Compiles and returns visitor to extract results from
     *
     */
    public SourceGenerationVisitor compile() throws IOException {
        InfixLexer lexer = new InfixLexer(createCharStream());
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        InfixParser parser = new InfixParser(tokens);

        //Added my own error listener so removed the default.
        parser.removeErrorListeners();
        parser.addErrorListener(new UnderlineListener());

        //Get the initial point of the parse tree.
        ParseTree tree = parser.start();

        //Initial walk to get variable and function declarations, also check for float variables or values.
        ParseTreeWalker walker = new ParseTreeWalker();
        DefPhase def = new DefPhase(parser);
        walker.walk(def, tree);

        //Traverse the parser from the initial point with the visitor, the visitor being in charge of language translation.
        SourceGenerationVisitor visitor = new SourceGenerationVisitor(parser, def.getScopes(), def.getVariableSymbols(), def.hasFloat());
        visitor.visit(tree);
        return visitor;
    }
}
