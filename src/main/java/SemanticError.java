import org.antlr.v4.runtime.*;

/**
 * This class is purely to mask the complex process required to throw errors in ANTLR.
 */
public class SemanticError {

    /**
     * Generate an error.
     *
     * @param parser  the parser being used to interpret the source code.
     * @param ctx     the context the error occurred in.
     * @param token   the token at which the error occurred.
     * @param message the message to display tot he user.
     */
    public SemanticError(Parser parser, ParserRuleContext ctx, Token token, String message) {
        parser.getErrorListeners().get(0).syntaxError(parser, token, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), message, new NoSuchThingException(parser));
    }
}
