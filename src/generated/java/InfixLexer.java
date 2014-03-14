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
		SEMICOLON=1, ASSIGN=2, EQUALS=3, GREATERTHAN=4, LESSTHAN=5, LESSTHANOREQUALS=6, 
		GREATERTHANOREQUALS=7, NOTEQUALS=8, MUL=9, DIV=10, ADD=11, SUB=12, LEFTPAREN=13, 
		RIGHTPAREN=14, FLOATEXPONENT=15, FLOAT=16, INTTYPE=17, FLOATTYPE=18, INT=19, 
		WS=20, LEFTCURLY=21, RIGHTCURLY=22, IF=23, TRUE=24, FALSE=25, OR=26, AND=27, 
		ELSE=28, WHILE=29, DEF=30, COMMA=31, ID=32;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"';'", "':='", "'='", "'>'", "'<'", "'<='", "'>='", "'!='", "'*'", "'/'", 
		"'+'", "'-'", "'('", "')'", "'e'", "FLOAT", "'int'", "'float'", "INT", 
		"WS", "'{'", "'}'", "'if'", "'true'", "'false'", "'or'", "'and'", "'else'", 
		"'while'", "'def'", "','", "ID"
	};
	public static final String[] ruleNames = {
		"SEMICOLON", "ASSIGN", "EQUALS", "GREATERTHAN", "LESSTHAN", "LESSTHANOREQUALS", 
		"GREATERTHANOREQUALS", "NOTEQUALS", "MUL", "DIV", "ADD", "SUB", "LEFTPAREN", 
		"RIGHTPAREN", "FLOATEXPONENT", "FLOAT", "INTTYPE", "FLOATTYPE", "INT", 
		"WS", "LEFTCURLY", "RIGHTCURLY", "IF", "TRUE", "FALSE", "OR", "AND", "ELSE", 
		"WHILE", "DEF", "COMMA", "ID"
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
		case 19: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\"\u00b2\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\5\21j\n\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\24\6\24y\n\24\r\24\16\24z\3\25\6\25~"+
		"\n\25\r\25\16\25\177\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3 \3 \3!\6!\u00af\n!\r!\16!\u00b0\2\"\3\3\1\5\4\1"+
		"\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1"+
		"\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\2+\27\1-\30\1/\31"+
		"\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1\3\2\5\3\2"+
		"\62;\5\2\13\f\17\17\"\"\3\2C|\u00b6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\3C\3\2\2\2\5E\3\2\2\2\7H\3\2\2\2\tJ\3\2\2\2\13L\3\2\2\2\rN\3\2\2"+
		"\2\17Q\3\2\2\2\21T\3\2\2\2\23W\3\2\2\2\25Y\3\2\2\2\27[\3\2\2\2\31]\3\2"+
		"\2\2\33_\3\2\2\2\35a\3\2\2\2\37c\3\2\2\2!e\3\2\2\2#m\3\2\2\2%q\3\2\2\2"+
		"\'x\3\2\2\2)}\3\2\2\2+\u0083\3\2\2\2-\u0085\3\2\2\2/\u0087\3\2\2\2\61"+
		"\u008a\3\2\2\2\63\u008f\3\2\2\2\65\u0095\3\2\2\2\67\u0098\3\2\2\29\u009c"+
		"\3\2\2\2;\u00a1\3\2\2\2=\u00a7\3\2\2\2?\u00ab\3\2\2\2A\u00ae\3\2\2\2C"+
		"D\7=\2\2D\4\3\2\2\2EF\7<\2\2FG\7?\2\2G\6\3\2\2\2HI\7?\2\2I\b\3\2\2\2J"+
		"K\7@\2\2K\n\3\2\2\2LM\7>\2\2M\f\3\2\2\2NO\7>\2\2OP\7?\2\2P\16\3\2\2\2"+
		"QR\7@\2\2RS\7?\2\2S\20\3\2\2\2TU\7#\2\2UV\7?\2\2V\22\3\2\2\2WX\7,\2\2"+
		"X\24\3\2\2\2YZ\7\61\2\2Z\26\3\2\2\2[\\\7-\2\2\\\30\3\2\2\2]^\7/\2\2^\32"+
		"\3\2\2\2_`\7*\2\2`\34\3\2\2\2ab\7+\2\2b\36\3\2\2\2cd\7g\2\2d \3\2\2\2"+
		"ef\5\'\24\2fi\5\37\20\2gj\5\27\f\2hj\5\31\r\2ig\3\2\2\2ih\3\2\2\2ij\3"+
		"\2\2\2jk\3\2\2\2kl\5\'\24\2l\"\3\2\2\2mn\7k\2\2no\7p\2\2op\7v\2\2p$\3"+
		"\2\2\2qr\7h\2\2rs\7n\2\2st\7q\2\2tu\7c\2\2uv\7v\2\2v&\3\2\2\2wy\t\2\2"+
		"\2xw\3\2\2\2yz\3\2\2\2zx\3\2\2\2z{\3\2\2\2{(\3\2\2\2|~\t\3\2\2}|\3\2\2"+
		"\2~\177\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\u0082\b\25\2\2\u0082*\3\2\2\2\u0083\u0084\7}\2\2\u0084,\3\2\2\2\u0085"+
		"\u0086\7\177\2\2\u0086.\3\2\2\2\u0087\u0088\7k\2\2\u0088\u0089\7h\2\2"+
		"\u0089\60\3\2\2\2\u008a\u008b\7v\2\2\u008b\u008c\7t\2\2\u008c\u008d\7"+
		"w\2\2\u008d\u008e\7g\2\2\u008e\62\3\2\2\2\u008f\u0090\7h\2\2\u0090\u0091"+
		"\7c\2\2\u0091\u0092\7n\2\2\u0092\u0093\7u\2\2\u0093\u0094\7g\2\2\u0094"+
		"\64\3\2\2\2\u0095\u0096\7q\2\2\u0096\u0097\7t\2\2\u0097\66\3\2\2\2\u0098"+
		"\u0099\7c\2\2\u0099\u009a\7p\2\2\u009a\u009b\7f\2\2\u009b8\3\2\2\2\u009c"+
		"\u009d\7g\2\2\u009d\u009e\7n\2\2\u009e\u009f\7u\2\2\u009f\u00a0\7g\2\2"+
		"\u00a0:\3\2\2\2\u00a1\u00a2\7y\2\2\u00a2\u00a3\7j\2\2\u00a3\u00a4\7k\2"+
		"\2\u00a4\u00a5\7n\2\2\u00a5\u00a6\7g\2\2\u00a6<\3\2\2\2\u00a7\u00a8\7"+
		"f\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7h\2\2\u00aa>\3\2\2\2\u00ab\u00ac"+
		"\7.\2\2\u00ac@\3\2\2\2\u00ad\u00af\t\4\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b0"+
		"\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1B\3\2\2\2\7\2iz"+
		"\177\u00b0";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}