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
		ASSIGN=1, EQUALS=2, GREATERTHAN=3, LESSTHAN=4, NOTEQUALS=5, MUL=6, DIV=7, 
		ADD=8, SUB=9, LEFTPAREN=10, RIGHTPAREN=11, FLOATEXPONENT=12, FLOAT=13, 
		VARIABLE=14, INT=15, WS=16;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"':='", "'='", "'>'", "'<'", "'!='", "'*'", "'/'", "'+'", "'-'", "'('", 
		"')'", "'e'", "FLOAT", "VARIABLE", "INT", "WS"
	};
	public static final String[] ruleNames = {
		"ASSIGN", "EQUALS", "GREATERTHAN", "LESSTHAN", "NOTEQUALS", "MUL", "DIV", 
		"ADD", "SUB", "LEFTPAREN", "RIGHTPAREN", "FLOATEXPONENT", "FLOAT", "VARIABLE", 
		"INT", "WS"
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
		case 15: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\22V\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\5\16B\n\16\3\16\3\16\3"+
		"\17\6\17G\n\17\r\17\16\17H\3\20\6\20L\n\20\r\20\16\20M\3\21\6\21Q\n\21"+
		"\r\21\16\21R\3\21\3\21\2\22\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t"+
		"\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\2"+
		"\3\2\5\3\2C|\3\2\62;\5\2\13\f\17\17\"\"Z\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5&\3\2\2\2\7(\3\2\2\2\t*\3"+
		"\2\2\2\13,\3\2\2\2\r/\3\2\2\2\17\61\3\2\2\2\21\63\3\2\2\2\23\65\3\2\2"+
		"\2\25\67\3\2\2\2\279\3\2\2\2\31;\3\2\2\2\33=\3\2\2\2\35F\3\2\2\2\37K\3"+
		"\2\2\2!P\3\2\2\2#$\7<\2\2$%\7?\2\2%\4\3\2\2\2&\'\7?\2\2\'\6\3\2\2\2()"+
		"\7@\2\2)\b\3\2\2\2*+\7>\2\2+\n\3\2\2\2,-\7#\2\2-.\7?\2\2.\f\3\2\2\2/\60"+
		"\7,\2\2\60\16\3\2\2\2\61\62\7\61\2\2\62\20\3\2\2\2\63\64\7-\2\2\64\22"+
		"\3\2\2\2\65\66\7/\2\2\66\24\3\2\2\2\678\7*\2\28\26\3\2\2\29:\7+\2\2:\30"+
		"\3\2\2\2;<\7g\2\2<\32\3\2\2\2=>\5\37\20\2>A\5\31\r\2?B\5\21\t\2@B\5\23"+
		"\n\2A?\3\2\2\2A@\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\5\37\20\2D\34\3\2\2\2E"+
		"G\t\2\2\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\36\3\2\2\2JL\t\3\2"+
		"\2KJ\3\2\2\2LM\3\2\2\2MK\3\2\2\2MN\3\2\2\2N \3\2\2\2OQ\t\4\2\2PO\3\2\2"+
		"\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\b\21\2\2U\"\3\2\2\2\7\2A"+
		"HMR";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}