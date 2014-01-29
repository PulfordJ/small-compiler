import org.antlr.v4.runtime.*;

/**
 * Created by john on 29/01/14.
 */
public class UnderlineListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        //super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
        System.out.println("Line " + line + " at position " + charPositionInLine + " " + msg);
        underlineError(recognizer, (Token) offendingSymbol, line, charPositionInLine);
    }

    protected void underlineError(Recognizer recognizer, Token offendingToken, int line, int charPositionInLine) {
        CommonTokenStream tokens = (CommonTokenStream) recognizer.getInputStream();
        String input = tokens.getTokenSource().getInputStream().toString();
        String[] lines = input.split("\n"); // We ignore these but keeping them for error handling is handy.

        //reached end of code, more useful to show last line...
        String errorLine;
        if (lines.length < line) {
            errorLine = lines[lines.length - 1];
            System.out.println(errorLine);
        } else {
            errorLine = lines[line - 1];
            System.out.println(errorLine);
            //Bring crusor to the beginning of where to underline, underneath the source line.
            for (int i = 0; i < charPositionInLine; i++)
                System.out.println(" ");
            int start = offendingToken.getStartIndex();
            int stop = offendingToken.getStopIndex();
            //If valid locations...
            if (start >= 0 && stop >= 0) {
                //appears to be possible based on order of traversal...
                if (start > stop) {
                    int temp = start;
                    start = stop;
                    stop = temp;
                }
                for (int i = start; i <= stop; i++)
                    System.out.print("^");
            }
        }

        System.out.println();

    }
}
