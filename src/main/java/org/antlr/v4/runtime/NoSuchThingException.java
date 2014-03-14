package org.antlr.v4.runtime;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Nullable;

import java.util.Locale;

/**
 * Implementation of a RecognitionException derived from ANTLR4 source code, never used for error message generation but is a required parameter...
 * Accesses variables with package visibility, like other recognitionexceptions, and thus is stored under org.antlr.v4.runtime.
 */
public class NoSuchThingException extends RecognitionException {

	public NoSuchThingException(@NotNull Parser recognizer) {
        super("", recognizer, recognizer.getInputStream(), recognizer._ctx);
	}

}
