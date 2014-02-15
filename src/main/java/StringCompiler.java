import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.*;

public class StringCompiler extends Compiler {
    String source;

    public StringCompiler(String source) {
        this.source = source;
    }

    @Override
    public CharStream createCharStream() throws IOException {
        InputStream is = new ByteArrayInputStream(source.getBytes());
        return new ANTLRInputStream(is);
    }
}