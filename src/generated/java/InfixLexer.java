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
		SEMICOLON=1, ASSIGN=2, EQUALS=3, GREATERTHAN=4, LESSTHAN=5, NOTEQUALS=6, 
		MUL=7, DIV=8, ADD=9, SUB=10, LEFTPAREN=11, RIGHTPAREN=12, FLOATEXPONENT=13, 
		FLOAT=14, INTTYPE=15, INT=16, WS=17, LEFTCURLY=18, RIGHTCURLY=19, IF=20, 
		TRUE=21, FALSE=22, OR=23, AND=24, ELSE=25, WHILE=26, DEF=27, COMMA=28, 
		ID=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"';'", "':='", "'='", "'>'", "'<'", "'!='", "'*'", "'/'", "'+'", "'-'", 
		"'('", "')'", "'e'", "FLOAT", "'int'", "INT", "WS", "'{'", "'}'", "'if'", 
		"'true'", "'false'", "'or'", "'and'", "'else'", "'while'", "'def'", "','", 
		"ID"
	};
	public static final String[] ruleNames = {
		"SEMICOLON", "ASSIGN", "EQUALS", "GREATERTHAN", "LESSTHAN", "NOTEQUALS", 
		"MUL", "DIV", "ADD", "SUB", "LEFTPAREN", "RIGHTPAREN", "FLOATEXPONENT", 
		"FLOAT", "INTTYPE", "INT", "WS", "LEFTCURLY", "RIGHTCURLY", "IF", "TRUE", 
		"FALSE", "OR", "AND", "ELSE", "WHILE", "DEF", "COMMA", "ID"
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
		case 16: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\37\u00a0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\3\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\5\17^\n\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\21\6\21g\n\21\r\21\16\21h\3\22\6\22l\n\22\r"+
		"\22\16\22m\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\35\3\35\3\36\6\36\u009d\n\36\r\36\16\36\u009e\2\37\3\3\1"+
		"\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31"+
		"\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\2%\24\1\'\25\1)\26\1+\27\1-\30"+
		"\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1\3\2\5\3\2\62;\5\2"+
		"\13\f\17\17\"\"\3\2C|\u00a4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3=\3\2\2\2\5?\3\2\2\2\7B\3\2\2\2\tD"+
		"\3\2\2\2\13F\3\2\2\2\rH\3\2\2\2\17K\3\2\2\2\21M\3\2\2\2\23O\3\2\2\2\25"+
		"Q\3\2\2\2\27S\3\2\2\2\31U\3\2\2\2\33W\3\2\2\2\35Y\3\2\2\2\37a\3\2\2\2"+
		"!f\3\2\2\2#k\3\2\2\2%q\3\2\2\2\'s\3\2\2\2)u\3\2\2\2+x\3\2\2\2-}\3\2\2"+
		"\2/\u0083\3\2\2\2\61\u0086\3\2\2\2\63\u008a\3\2\2\2\65\u008f\3\2\2\2\67"+
		"\u0095\3\2\2\29\u0099\3\2\2\2;\u009c\3\2\2\2=>\7=\2\2>\4\3\2\2\2?@\7<"+
		"\2\2@A\7?\2\2A\6\3\2\2\2BC\7?\2\2C\b\3\2\2\2DE\7@\2\2E\n\3\2\2\2FG\7>"+
		"\2\2G\f\3\2\2\2HI\7#\2\2IJ\7?\2\2J\16\3\2\2\2KL\7,\2\2L\20\3\2\2\2MN\7"+
		"\61\2\2N\22\3\2\2\2OP\7-\2\2P\24\3\2\2\2QR\7/\2\2R\26\3\2\2\2ST\7*\2\2"+
		"T\30\3\2\2\2UV\7+\2\2V\32\3\2\2\2WX\7g\2\2X\34\3\2\2\2YZ\5!\21\2Z]\5\33"+
		"\16\2[^\5\23\n\2\\^\5\25\13\2][\3\2\2\2]\\\3\2\2\2]^\3\2\2\2^_\3\2\2\2"+
		"_`\5!\21\2`\36\3\2\2\2ab\7k\2\2bc\7p\2\2cd\7v\2\2d \3\2\2\2eg\t\2\2\2"+
		"fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\"\3\2\2\2jl\t\3\2\2kj\3\2\2"+
		"\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2no\3\2\2\2op\b\22\2\2p$\3\2\2\2qr\7}\2"+
		"\2r&\3\2\2\2st\7\177\2\2t(\3\2\2\2uv\7k\2\2vw\7h\2\2w*\3\2\2\2xy\7v\2"+
		"\2yz\7t\2\2z{\7w\2\2{|\7g\2\2|,\3\2\2\2}~\7h\2\2~\177\7c\2\2\177\u0080"+
		"\7n\2\2\u0080\u0081\7u\2\2\u0081\u0082\7g\2\2\u0082.\3\2\2\2\u0083\u0084"+
		"\7q\2\2\u0084\u0085\7t\2\2\u0085\60\3\2\2\2\u0086\u0087\7c\2\2\u0087\u0088"+
		"\7p\2\2\u0088\u0089\7f\2\2\u0089\62\3\2\2\2\u008a\u008b\7g\2\2\u008b\u008c"+
		"\7n\2\2\u008c\u008d\7u\2\2\u008d\u008e\7g\2\2\u008e\64\3\2\2\2\u008f\u0090"+
		"\7y\2\2\u0090\u0091\7j\2\2\u0091\u0092\7k\2\2\u0092\u0093\7n\2\2\u0093"+
		"\u0094\7g\2\2\u0094\66\3\2\2\2\u0095\u0096\7f\2\2\u0096\u0097\7g\2\2\u0097"+
		"\u0098\7h\2\2\u00988\3\2\2\2\u0099\u009a\7.\2\2\u009a:\3\2\2\2\u009b\u009d"+
		"\t\4\2\2\u009c\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f<\3\2\2\2\7\2]hm\u009e";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}