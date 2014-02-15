// Generated from /home/john/Git/small-compiler/src/main/antlr/InfixToPostfix.g4 by ANTLR 4.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class InfixToPostfixParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MUL=1, DIV=2, ADD=3, SUB=4, LEFTPAREN=5, RIGHTPAREN=6, FLOATEXPONENT=7, 
		FLOAT=8, OPTIONALLYSIGNEDINT=9, INT=10, WS=11;
	public static final String[] tokenNames = {
		"<INVALID>", "'*'", "'/'", "'+'", "'-'", "'('", "')'", "'e'", "FLOAT", 
		"OPTIONALLYSIGNEDINT", "INT", "WS"
	};
	public static final int
		RULE_start = 0, RULE_expr = 1, RULE_parenedexpr = 2;
	public static final String[] ruleNames = {
		"start", "expr", "parenedexpr"
	};

	@Override
	public String getGrammarFileName() { return "InfixToPostfix.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public InfixToPostfixParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	 
		public StartContext() { }
		public void copyFrom(StartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintExprContext extends StartContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintExprContext(StartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixToPostfixListener ) ((InfixToPostfixListener)listener).enterPrintExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixToPostfixListener ) ((InfixToPostfixListener)listener).exitPrintExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixToPostfixVisitor ) return ((InfixToPostfixVisitor<? extends T>)visitor).visitPrintExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			_localctx = new PrintExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(6); expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public int _p;
		public ExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class MulDivAddSubContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SUB() { return getToken(InfixToPostfixParser.SUB, 0); }
		public TerminalNode ADD() { return getToken(InfixToPostfixParser.ADD, 0); }
		public MulDivAddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixToPostfixListener ) ((InfixToPostfixListener)listener).enterMulDivAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixToPostfixListener ) ((InfixToPostfixListener)listener).exitMulDivAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixToPostfixVisitor ) return ((InfixToPostfixVisitor<? extends T>)visitor).visitMulDivAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensWithMinusContext extends ExprContext {
		public ParenedexprContext parenedexpr() {
			return getRuleContext(ParenedexprContext.class,0);
		}
		public TerminalNode SUB() { return getToken(InfixToPostfixParser.SUB, 0); }
		public ParensWithMinusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixToPostfixListener ) ((InfixToPostfixListener)listener).enterParensWithMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixToPostfixListener ) ((InfixToPostfixListener)listener).exitParensWithMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixToPostfixVisitor ) return ((InfixToPostfixVisitor<? extends T>)visitor).visitParensWithMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatContext extends ExprContext {
		public TerminalNode FLOAT() { return getToken(InfixToPostfixParser.FLOAT, 0); }
		public FloatContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixToPostfixListener ) ((InfixToPostfixListener)listener).enterFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixToPostfixListener ) ((InfixToPostfixListener)listener).exitFloat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixToPostfixVisitor ) return ((InfixToPostfixVisitor<? extends T>)visitor).visitFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NopContext extends ExprContext {
		public ParenedexprContext parenedexpr() {
			return getRuleContext(ParenedexprContext.class,0);
		}
		public NopContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixToPostfixListener ) ((InfixToPostfixListener)listener).enterNop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixToPostfixListener ) ((InfixToPostfixListener)listener).exitNop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixToPostfixVisitor ) return ((InfixToPostfixVisitor<? extends T>)visitor).visitNop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OptionallySignedIntContext extends ExprContext {
		public TerminalNode OPTIONALLYSIGNEDINT() { return getToken(InfixToPostfixParser.OPTIONALLYSIGNEDINT, 0); }
		public OptionallySignedIntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixToPostfixListener ) ((InfixToPostfixListener)listener).enterOptionallySignedInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixToPostfixListener ) ((InfixToPostfixListener)listener).exitOptionallySignedInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixToPostfixVisitor ) return ((InfixToPostfixVisitor<? extends T>)visitor).visitOptionallySignedInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensWithAddContext extends ExprContext {
		public ParenedexprContext parenedexpr() {
			return getRuleContext(ParenedexprContext.class,0);
		}
		public TerminalNode ADD() { return getToken(InfixToPostfixParser.ADD, 0); }
		public ParensWithAddContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixToPostfixListener ) ((InfixToPostfixListener)listener).enterParensWithAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixToPostfixListener ) ((InfixToPostfixListener)listener).exitParensWithAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixToPostfixVisitor ) return ((InfixToPostfixVisitor<? extends T>)visitor).visitParensWithAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState, _p);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, RULE_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			switch (_input.LA(1)) {
			case FLOAT:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(9); match(FLOAT);
				}
				break;
			case OPTIONALLYSIGNEDINT:
				{
				_localctx = new OptionallySignedIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(10); match(OPTIONALLYSIGNEDINT);
				}
				break;
			case LEFTPAREN:
				{
				_localctx = new NopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(11); parenedexpr();
				}
				break;
			case ADD:
				{
				_localctx = new ParensWithAddContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(12); match(ADD);
				setState(13); parenedexpr();
				}
				break;
			case SUB:
				{
				_localctx = new ParensWithMinusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(14); match(SUB);
				setState(15); parenedexpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(26);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(24);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivAddSubContext(new ExprContext(_parentctx, _parentState, _p));
						((MulDivAddSubContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(18);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(19);
						((MulDivAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(20); ((MulDivAddSubContext)_localctx).right = expr(8);
						}
						break;

					case 2:
						{
						_localctx = new MulDivAddSubContext(new ExprContext(_parentctx, _parentState, _p));
						((MulDivAddSubContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(21);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(22);
						((MulDivAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((MulDivAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(23); ((MulDivAddSubContext)_localctx).right = expr(7);
						}
						break;
					}
					} 
				}
				setState(28);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ParenedexprContext extends ParserRuleContext {
		public ParenedexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenedexpr; }
	 
		public ParenedexprContext() { }
		public void copyFrom(ParenedexprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParensContext extends ParenedexprContext {
		public TerminalNode RIGHTPAREN() { return getToken(InfixToPostfixParser.RIGHTPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LEFTPAREN() { return getToken(InfixToPostfixParser.LEFTPAREN, 0); }
		public ParensContext(ParenedexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixToPostfixListener ) ((InfixToPostfixListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixToPostfixListener ) ((InfixToPostfixListener)listener).exitParens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixToPostfixVisitor ) return ((InfixToPostfixVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensnopContext extends ParenedexprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LEFTPAREN() { return getToken(InfixToPostfixParser.LEFTPAREN, 0); }
		public ParensnopContext(ParenedexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixToPostfixListener ) ((InfixToPostfixListener)listener).enterParensnop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixToPostfixListener ) ((InfixToPostfixListener)listener).exitParensnop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixToPostfixVisitor ) return ((InfixToPostfixVisitor<? extends T>)visitor).visitParensnop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenedexprContext parenedexpr() throws RecognitionException {
		ParenedexprContext _localctx = new ParenedexprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_parenedexpr);
		try {
			int _alt;
			setState(47);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new ParensContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(29); match(LEFTPAREN);
				setState(30); expr(0);
				setState(31); match(RIGHTPAREN);
				}
				break;

			case 2:
				_localctx = new ParensnopContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(33); match(LEFTPAREN);
				setState(34); expr(0);
				setState(35); match(RIGHTPAREN);
				setState(37); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(36); match(RIGHTPAREN);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(39); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				notifyErrorListeners("Too many parentheses");
				}
				break;

			case 3:
				_localctx = new ParensnopContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(43); match(LEFTPAREN);
				setState(44); expr(0);
				notifyErrorListeners("Missing closing ')'");
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 7 >= _localctx._p;

		case 1: return 6 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\r\64\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\23\n\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\7\3\33\n\3\f\3\16\3\36\13\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\6\4(\n\4\r\4\16\4)\3\4\3\4\3\4\3\4\3\4\3\4\5\4\62\n\4\3\4\2\5"+
		"\2\4\6\2\4\3\2\3\4\3\2\5\69\2\b\3\2\2\2\4\22\3\2\2\2\6\61\3\2\2\2\b\t"+
		"\5\4\3\2\t\3\3\2\2\2\n\13\b\3\1\2\13\23\7\n\2\2\f\23\7\13\2\2\r\23\5\6"+
		"\4\2\16\17\7\5\2\2\17\23\5\6\4\2\20\21\7\6\2\2\21\23\5\6\4\2\22\n\3\2"+
		"\2\2\22\f\3\2\2\2\22\r\3\2\2\2\22\16\3\2\2\2\22\20\3\2\2\2\23\34\3\2\2"+
		"\2\24\25\6\3\2\3\25\26\t\2\2\2\26\33\5\4\3\2\27\30\6\3\3\3\30\31\t\3\2"+
		"\2\31\33\5\4\3\2\32\24\3\2\2\2\32\27\3\2\2\2\33\36\3\2\2\2\34\32\3\2\2"+
		"\2\34\35\3\2\2\2\35\5\3\2\2\2\36\34\3\2\2\2\37 \7\7\2\2 !\5\4\3\2!\"\7"+
		"\b\2\2\"\62\3\2\2\2#$\7\7\2\2$%\5\4\3\2%\'\7\b\2\2&(\7\b\2\2\'&\3\2\2"+
		"\2()\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*+\3\2\2\2+,\b\4\1\2,\62\3\2\2\2-.\7"+
		"\7\2\2./\5\4\3\2/\60\b\4\1\2\60\62\3\2\2\2\61\37\3\2\2\2\61#\3\2\2\2\61"+
		"-\3\2\2\2\62\7\3\2\2\2\7\22\32\34)\61";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}