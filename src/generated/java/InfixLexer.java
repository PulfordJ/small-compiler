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
		RIGHTPAREN=14, FLOATEXPONENT=15, FLOAT=16, INTTYPE=17, INT=18, WS=19, 
		LEFTCURLY=20, RIGHTCURLY=21, IF=22, TRUE=23, FALSE=24, OR=25, AND=26, 
		ELSE=27, WHILE=28, DEF=29, COMMA=30, ID=31;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"';'", "':='", "'='", "'>'", "'<'", "'<='", "'>='", "'!='", "'*'", "'/'", 
		"'+'", "'-'", "'('", "')'", "'e'", "FLOAT", "'int'", "INT", "WS", "'{'", 
		"'}'", "'if'", "'true'", "'false'", "'or'", "'and'", "'else'", "'while'", 
		"'def'", "','", "ID"
	};
	public static final String[] ruleNames = {
		"SEMICOLON", "ASSIGN", "EQUALS", "GREATERTHAN", "LESSTHAN", "LESSTHANOREQUALS", 
		"GREATERTHANOREQUALS", "NOTEQUALS", "MUL", "DIV", "ADD", "SUB", "LEFTPAREN", 
		"RIGHTPAREN", "FLOATEXPONENT", "FLOAT", "INTTYPE", "INT", "WS", "LEFTCURLY", 
		"RIGHTCURLY", "IF", "TRUE", "FALSE", "OR", "AND", "ELSE", "WHILE", "DEF", 
		"COMMA", "ID"
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
		case 18: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2!\u00aa\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\5\21h\n\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\6\23"+
		"q\n\23\r\23\16\23r\3\24\6\24v\n\24\r\24\16\24w\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3 \6 \u00a7\n"+
		" \r \16 \u00a8\2!\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23"+
		"\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1"+
		"\'\25\2)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1"+
		";\37\1= \1?!\1\3\2\5\3\2\62;\5\2\13\f\17\17\"\"\3\2C|\u00ae\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\3A\3\2\2\2\5C\3\2\2\2\7F\3\2\2\2\tH\3\2\2\2\13J\3\2"+
		"\2\2\rL\3\2\2\2\17O\3\2\2\2\21R\3\2\2\2\23U\3\2\2\2\25W\3\2\2\2\27Y\3"+
		"\2\2\2\31[\3\2\2\2\33]\3\2\2\2\35_\3\2\2\2\37a\3\2\2\2!c\3\2\2\2#k\3\2"+
		"\2\2%p\3\2\2\2\'u\3\2\2\2){\3\2\2\2+}\3\2\2\2-\177\3\2\2\2/\u0082\3\2"+
		"\2\2\61\u0087\3\2\2\2\63\u008d\3\2\2\2\65\u0090\3\2\2\2\67\u0094\3\2\2"+
		"\29\u0099\3\2\2\2;\u009f\3\2\2\2=\u00a3\3\2\2\2?\u00a6\3\2\2\2AB\7=\2"+
		"\2B\4\3\2\2\2CD\7<\2\2DE\7?\2\2E\6\3\2\2\2FG\7?\2\2G\b\3\2\2\2HI\7@\2"+
		"\2I\n\3\2\2\2JK\7>\2\2K\f\3\2\2\2LM\7>\2\2MN\7?\2\2N\16\3\2\2\2OP\7@\2"+
		"\2PQ\7?\2\2Q\20\3\2\2\2RS\7#\2\2ST\7?\2\2T\22\3\2\2\2UV\7,\2\2V\24\3\2"+
		"\2\2WX\7\61\2\2X\26\3\2\2\2YZ\7-\2\2Z\30\3\2\2\2[\\\7/\2\2\\\32\3\2\2"+
		"\2]^\7*\2\2^\34\3\2\2\2_`\7+\2\2`\36\3\2\2\2ab\7g\2\2b \3\2\2\2cd\5%\23"+
		"\2dg\5\37\20\2eh\5\27\f\2fh\5\31\r\2ge\3\2\2\2gf\3\2\2\2gh\3\2\2\2hi\3"+
		"\2\2\2ij\5%\23\2j\"\3\2\2\2kl\7k\2\2lm\7p\2\2mn\7v\2\2n$\3\2\2\2oq\t\2"+
		"\2\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2s&\3\2\2\2tv\t\3\2\2ut\3\2"+
		"\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\b\24\2\2z(\3\2\2\2{|\7"+
		"}\2\2|*\3\2\2\2}~\7\177\2\2~,\3\2\2\2\177\u0080\7k\2\2\u0080\u0081\7h"+
		"\2\2\u0081.\3\2\2\2\u0082\u0083\7v\2\2\u0083\u0084\7t\2\2\u0084\u0085"+
		"\7w\2\2\u0085\u0086\7g\2\2\u0086\60\3\2\2\2\u0087\u0088\7h\2\2\u0088\u0089"+
		"\7c\2\2\u0089\u008a\7n\2\2\u008a\u008b\7u\2\2\u008b\u008c\7g\2\2\u008c"+
		"\62\3\2\2\2\u008d\u008e\7q\2\2\u008e\u008f\7t\2\2\u008f\64\3\2\2\2\u0090"+
		"\u0091\7c\2\2\u0091\u0092\7p\2\2\u0092\u0093\7f\2\2\u0093\66\3\2\2\2\u0094"+
		"\u0095\7g\2\2\u0095\u0096\7n\2\2\u0096\u0097\7u\2\2\u0097\u0098\7g\2\2"+
		"\u00988\3\2\2\2\u0099\u009a\7y\2\2\u009a\u009b\7j\2\2\u009b\u009c\7k\2"+
		"\2\u009c\u009d\7n\2\2\u009d\u009e\7g\2\2\u009e:\3\2\2\2\u009f\u00a0\7"+
		"f\2\2\u00a0\u00a1\7g\2\2\u00a1\u00a2\7h\2\2\u00a2<\3\2\2\2\u00a3\u00a4"+
		"\7.\2\2\u00a4>\3\2\2\2\u00a5\u00a7\t\4\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00a8"+
		"\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9@\3\2\2\2\7\2gr"+
		"w\u00a8";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}