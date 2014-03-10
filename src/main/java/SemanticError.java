import org.antlr.v4.runtime.*;

/**
 * Created by john on 10/03/14.
 */
public class SemanticError {
    public SemanticError(Parser parser, ParserRuleContext ctx, Token symbol, String message) {
        parser.getErrorListeners().get(0).syntaxError(parser, symbol, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), message, new NoSuchThingException(parser));
    }
}
