import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.List;

abstract class Compiler {
    String FLOATTOKENNAME = "FLOAT";

    //This is used to determine whether a token exists in a program.
    private static boolean programContainsToken(CharStream charStream, String tokenToFind) throws IOException {
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
    public abstract CharStream createCharStream() throws IOException;


    /**
     * Compiles and returns visitor to extract results from
     *
     * @Charstream the stream of source code to compile.
     */
    public InfixVisitorImpl compile() throws IOException {
        /*

        //Check if floats exist so that visitor knows which version of forth to compile into, essentially deciding start -> expr or start -> floatExpr in my specified forth grammar.
        if (programContainsToken(createCharStream(), FLOATTOKENNAME)) {
            visitor.enableFloatMode();
        }
        */

        InfixLexer lexer = new InfixLexer(createCharStream());

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        InfixParser p = new InfixParser(tokens);

        //Added my own error listener so removed the default.
        p.removeErrorListeners();
        p.addErrorListener(new UnderlineListener());

        //Get the initial point of the parse tree.
        ParseTree tree = p.start();

        //Initial walk to get declarations and check for float variables.
        ParseTreeWalker walker = new ParseTreeWalker();
        DefPhase def = new DefPhase();
        walker.walk(def, tree);

        InfixVisitorImpl visitor = new InfixVisitorImpl(def.getScopes(), def.getVariableSymbols(), def.getFunctionSymbols());

        if (def.hasFloat()) {
            visitor.enableFloatMode();
        }

        //Traverse the parser from the initial point with the visitor, the visitor being in charge of language translation.
        visitor.addParser(p);
        visitor.visit(tree);
        return visitor;
    }
}
