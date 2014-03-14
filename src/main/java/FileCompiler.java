import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;

import java.io.*;
import java.lang.*;

/**
 * Created by john on 15/02/14.
 * An implementation of Compiler that creates CharStreams from opening a file.
 */
public class FileCompiler extends Compiler {
    private final String sourceFile;

    public FileCompiler(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    @Override
    public CharStream createCharStream() throws IOException {
        return new ANTLRFileStream(sourceFile);
    }
}
