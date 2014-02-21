// Generated from /home/john/Git/small-compiler/src/main/antlr/Infix.g4 by ANTLR 4.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class InfixLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MUL=1, DIV=2, ADD=3, SUB=4, LEFTPAREN=5, RIGHTPAREN=6, FLOATEXPONENT=7, 
		FLOAT=8, INT=9, WS=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'*'", "'/'", "'+'", "'-'", "'('", "')'", "'e'", "FLOAT", "INT", "WS"
	};
	public static final String[] ruleNames = {
		"MUL", "DIV", "ADD", "SUB", "LEFTPAREN", "RIGHTPAREN", "FLOATEXPONENT", 
		"FLOAT", "INT", "WS"
	};


	public InfixLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Infix.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 9: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\f9\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\5\t*\n\t\3\t\3\t\3\n\6\n/\n\n\r\n\16\n\60\3\13\6\13\64\n\13\r\13"+
		"\16\13\65\3\13\3\13\2\f\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21"+
		"\n\1\23\13\1\25\f\2\3\2\4\3\2\62;\5\2\13\f\17\17\"\"<\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2\5\31\3\2\2\2\7\33"+
		"\3\2\2\2\t\35\3\2\2\2\13\37\3\2\2\2\r!\3\2\2\2\17#\3\2\2\2\21%\3\2\2\2"+
		"\23.\3\2\2\2\25\63\3\2\2\2\27\30\7,\2\2\30\4\3\2\2\2\31\32\7\61\2\2\32"+
		"\6\3\2\2\2\33\34\7-\2\2\34\b\3\2\2\2\35\36\7/\2\2\36\n\3\2\2\2\37 \7*"+
		"\2\2 \f\3\2\2\2!\"\7+\2\2\"\16\3\2\2\2#$\7g\2\2$\20\3\2\2\2%&\5\23\n\2"+
		"&)\5\17\b\2\'*\5\7\4\2(*\5\t\5\2)\'\3\2\2\2)(\3\2\2\2)*\3\2\2\2*+\3\2"+
		"\2\2+,\5\23\n\2,\22\3\2\2\2-/\t\2\2\2.-\3\2\2\2/\60\3\2\2\2\60.\3\2\2"+
		"\2\60\61\3\2\2\2\61\24\3\2\2\2\62\64\t\3\2\2\63\62\3\2\2\2\64\65\3\2\2"+
		"\2\65\63\3\2\2\2\65\66\3\2\2\2\66\67\3\2\2\2\678\b\13\2\28\26\3\2\2\2"+
		"\6\2)\60\65";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}