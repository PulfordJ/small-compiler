import org.antlr.v4.runtime.*;

/**
 * Created by john on 29/01/14.
 */
//Based off the ANTLR4 reference but with a bunch of bug fixes; for example if EOF reached then underlineError originally led to an IndexOutOfBoundsException.
public class UnderlineListener extends BaseErrorListener {

    public boolean isEndOfFileInMessage(String msg) {
        return msg.matches("(.*)<EOF>(.*)");
    }

    //Reformats the typical error message from an ANTLR4 compiler.
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        //Potentially underline the error message.
        underlineError(recognizer, (Token) offendingSymbol, line, charPositionInLine, msg);

        String formatString = "Line %d at position %s %s\n";
        String formattedString; //to avoid awkward race conditions between err and out.

        //If EOF found then print something more friendly
        if (isEndOfFileInMessage(msg)){
            String friendlyEndOfFileMessage = msg.replaceAll("'<EOF>'", "the end of the source code");
            String friendlyEndOfFileMessage = msg.replaceAll("<EOF>", "the end of the source code");
            formattedString = String.format(formatString, line, charPositionInLine, friendlyEndOfFileMessage);
        }
        //else normal prettier error message.
        else{
            formattedString = String.format(formatString, line, charPositionInLine, msg);
        }
        System.out.println(formattedString);
    }

    /**
     * Potentially underlines error message, doesn't if on last line as this is rarely a useful annotation.
     */
    protected void underlineError(Recognizer recognizer, Token offendingToken, int line, int charPositionInLine, String msg) {
        CommonTokenStream tokens = (CommonTokenStream) recognizer.getInputStream();
        String input = tokens.getTokenSource().getInputStream().toString();
        String[] lines = input.split("\n");

        //reached end of code, more useful to show last line without underlining...
        String errorLine;
        if (isEndOfFileInMessage(msg)) {
            errorLine = lines[lines.length - 1];
            System.err.println(errorLine);
        } else {
            errorLine = lines[line - 1];
            System.err.println(errorLine);
            //Bring cursor to the beginning of where to underline, underneath the source line.
            for (int i = 0; i < charPositionInLine; i++)
                System.err.print(" ");
            int start = offendingToken.getStartIndex();
            int stop = offendingToken.getStopIndex();
            //If valid locations...
            if (start >= 0 && stop >= 0) {
                //Appears to be possible based on order of traversal...
                if (start > stop) {
                    int temp = start;
                    start = stop;
                    stop = temp;
                }
                for (int i = start; i <= stop; i++)
                    System.err.print("^");
            }
        }

        System.err.println();

    }
}
