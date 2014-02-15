import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;

import java.io.IOException;
import java.lang.*;

/**
 * Created by john on 15/02/14.
 */
public class FileCompiler extends Compiler {
    String sourceFile;

    public FileCompiler(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    @Override
    public CharStream createCharStream() throws IOException{
        return new ANTLRFileStream(sourceFile);
    }
}