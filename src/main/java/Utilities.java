import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.util.List;

/**
 * Created by john on 06/02/14.
 */
public class Utilities {
    public static String getFilenameWithoutExtention(String filename) {
        return filename.split("\\.[^\\.]+$")[0];
    }

    public static boolean programContainsToken(CharStream charStream, String tokenToFind) throws IOException {
        InfixToPostfixLexer lexer = new InfixToPostfixLexer(charStream);
        List<? extends Token> allTokens = lexer.getAllTokens();

        for (Token token : allTokens) {
            if (lexer.getTokenNames()[token.getType()].equals(tokenToFind))
            {
                return true;
            }
        }
        return false;
    }
}
