// Generated from /home/john/Git/small-compiler/src/main/antlr/Infix.g4 by ANTLR 4.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class InfixParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ASSIGN=1, EQUALS=2, GREATERTHAN=3, LESSTHAN=4, NOTEQUALS=5, MUL=6, DIV=7, 
		ADD=8, SUB=9, LEFTPAREN=10, RIGHTPAREN=11, FLOATEXPONENT=12, FLOAT=13, 
		VARIABLE=14, INT=15, WS=16;
	public static final String[] tokenNames = {
		"<INVALID>", "':='", "'='", "'>'", "'<'", "'!='", "'*'", "'/'", "'+'", 
		"'-'", "'('", "')'", "'e'", "FLOAT", "VARIABLE", "INT", "WS"
	};
	public static final int
		RULE_start = 0, RULE_sequence = 1, RULE_bool = 2, RULE_expr = 3, RULE_parenedexpr = 4;
	public static final String[] ruleNames = {
		"start", "sequence", "bool", "expr", "parenedexpr"
	};

	@Override
	public String getGrammarFileName() { return "Infix.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public InfixParser(TokenStream input) {
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
	public static class BoilerplateContext extends StartContext {
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public BoilerplateContext(StartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterBoilerplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitBoilerplate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitBoilerplate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			_localctx = new BoilerplateContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(10); sequence();
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

	public static class SequenceContext extends ParserRuleContext {
		public SequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence; }
	 
		public SequenceContext() { }
		public void copyFrom(SequenceContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintExprContext extends SequenceContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public PrintExprContext(SequenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterPrintExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitPrintExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitPrintExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sequence);
		int _la;
		try {
			_localctx = new PrintExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(12); expr(0);
			}
			setState(14);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << LEFTPAREN) | (1L << FLOAT) | (1L << VARIABLE) | (1L << INT))) != 0)) {
				{
				setState(13); sequence();
				}
			}

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

	public static class BoolContext extends ParserRuleContext {
		public TerminalNode LESSTHAN() { return getToken(InfixParser.LESSTHAN, 0); }
		public TerminalNode GREATERTHAN() { return getToken(InfixParser.GREATERTHAN, 0); }
		public TerminalNode EQUALS() { return getToken(InfixParser.EQUALS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NOTEQUALS() { return getToken(InfixParser.NOTEQUALS, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bool);
		try {
			setState(32);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(16); expr(0);
				setState(17); match(EQUALS);
				setState(18); expr(0);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(20); expr(0);
				setState(21); match(GREATERTHAN);
				setState(22); expr(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(24); expr(0);
				setState(25); match(LESSTHAN);
				setState(26); expr(0);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(28); expr(0);
				setState(29); match(NOTEQUALS);
				setState(30); expr(0);
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
		public TerminalNode SUB() { return getToken(InfixParser.SUB, 0); }
		public TerminalNode ADD() { return getToken(InfixParser.ADD, 0); }
		public MulDivAddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterMulDivAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitMulDivAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitMulDivAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignVariableContext extends ExprContext {
		public TerminalNode VARIABLE() { return getToken(InfixParser.VARIABLE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(InfixParser.ASSIGN, 0); }
		public AssignVariableContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterAssignVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitAssignVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitAssignVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubFloatContext extends ExprContext {
		public TerminalNode FLOAT() { return getToken(InfixParser.FLOAT, 0); }
		public TerminalNode SUB() { return getToken(InfixParser.SUB, 0); }
		public SubFloatContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterSubFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitSubFloat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitSubFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensWithMinusContext extends ExprContext {
		public ParenedexprContext parenedexpr() {
			return getRuleContext(ParenedexprContext.class,0);
		}
		public TerminalNode SUB() { return getToken(InfixParser.SUB, 0); }
		public ParensWithMinusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterParensWithMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitParensWithMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitParensWithMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatContext extends ExprContext {
		public TerminalNode FLOAT() { return getToken(InfixParser.FLOAT, 0); }
		public TerminalNode ADD() { return getToken(InfixParser.ADD, 0); }
		public FloatContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitFloat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitFloat(this);
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
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterNop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitNop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitNop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubOptionallySignedIntContext extends ExprContext {
		public TerminalNode INT() { return getToken(InfixParser.INT, 0); }
		public TerminalNode SUB() { return getToken(InfixParser.SUB, 0); }
		public SubOptionallySignedIntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterSubOptionallySignedInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitSubOptionallySignedInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitSubOptionallySignedInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OptionallySignedIntContext extends ExprContext {
		public TerminalNode INT() { return getToken(InfixParser.INT, 0); }
		public TerminalNode ADD() { return getToken(InfixParser.ADD, 0); }
		public OptionallySignedIntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterOptionallySignedInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitOptionallySignedInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitOptionallySignedInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensWithAddContext extends ExprContext {
		public ParenedexprContext parenedexpr() {
			return getRuleContext(ParenedexprContext.class,0);
		}
		public TerminalNode ADD() { return getToken(InfixParser.ADD, 0); }
		public ParensWithAddContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterParensWithAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitParensWithAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitParensWithAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState, _p);
		ExprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, RULE_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new AssignVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(35); match(VARIABLE);
				setState(36); match(ASSIGN);
				setState(37); expr(8);
				}
				break;

			case 2:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(39);
				_la = _input.LA(1);
				if (_la==ADD) {
					{
					setState(38); match(ADD);
					}
				}

				setState(41); match(FLOAT);
				}
				break;

			case 3:
				{
				_localctx = new SubFloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(42); match(SUB);
				setState(43); match(FLOAT);
				}
				break;

			case 4:
				{
				_localctx = new OptionallySignedIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(45);
				_la = _input.LA(1);
				if (_la==ADD) {
					{
					setState(44); match(ADD);
					}
				}

				setState(47); match(INT);
				}
				break;

			case 5:
				{
				_localctx = new SubOptionallySignedIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(48); match(SUB);
				setState(49); match(INT);
				}
				break;

			case 6:
				{
				_localctx = new NopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(50); parenedexpr();
				}
				break;

			case 7:
				{
				_localctx = new ParensWithAddContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(51); match(ADD);
				setState(52); parenedexpr();
				}
				break;

			case 8:
				{
				_localctx = new ParensWithMinusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(53); match(SUB);
				setState(54); parenedexpr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(63);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivAddSubContext(new ExprContext(_parentctx, _parentState, _p));
						((MulDivAddSubContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(57);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(58);
						((MulDivAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(59); ((MulDivAddSubContext)_localctx).right = expr(11);
						}
						break;

					case 2:
						{
						_localctx = new MulDivAddSubContext(new ExprContext(_parentctx, _parentState, _p));
						((MulDivAddSubContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(60);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(61);
						((MulDivAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((MulDivAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(62); ((MulDivAddSubContext)_localctx).right = expr(10);
						}
						break;
					}
					} 
				}
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		public TerminalNode RIGHTPAREN() { return getToken(InfixParser.RIGHTPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LEFTPAREN() { return getToken(InfixParser.LEFTPAREN, 0); }
		public ParensContext(ParenedexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitParens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenedexprContext parenedexpr() throws RecognitionException {
		ParenedexprContext _localctx = new ParenedexprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parenedexpr);
		try {
			_localctx = new ParensContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(68); match(LEFTPAREN);
			setState(69); expr(0);
			setState(70); match(RIGHTPAREN);
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
		case 3: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 10 >= _localctx._p;

		case 1: return 9 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\22K\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\3\3\3\5\3\21\n\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4#\n\4\3\5\3\5\3\5"+
		"\3\5\3\5\5\5*\n\5\3\5\3\5\3\5\3\5\5\5\60\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\5:\n\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5B\n\5\f\5\16\5E\13\5\3\6\3"+
		"\6\3\6\3\6\3\6\2\7\2\4\6\b\n\2\4\3\2\b\t\3\2\n\13T\2\f\3\2\2\2\4\16\3"+
		"\2\2\2\6\"\3\2\2\2\b9\3\2\2\2\nF\3\2\2\2\f\r\5\4\3\2\r\3\3\2\2\2\16\20"+
		"\5\b\5\2\17\21\5\4\3\2\20\17\3\2\2\2\20\21\3\2\2\2\21\5\3\2\2\2\22\23"+
		"\5\b\5\2\23\24\7\4\2\2\24\25\5\b\5\2\25#\3\2\2\2\26\27\5\b\5\2\27\30\7"+
		"\5\2\2\30\31\5\b\5\2\31#\3\2\2\2\32\33\5\b\5\2\33\34\7\6\2\2\34\35\5\b"+
		"\5\2\35#\3\2\2\2\36\37\5\b\5\2\37 \7\7\2\2 !\5\b\5\2!#\3\2\2\2\"\22\3"+
		"\2\2\2\"\26\3\2\2\2\"\32\3\2\2\2\"\36\3\2\2\2#\7\3\2\2\2$%\b\5\1\2%&\7"+
		"\20\2\2&\'\7\3\2\2\':\5\b\5\2(*\7\n\2\2)(\3\2\2\2)*\3\2\2\2*+\3\2\2\2"+
		"+:\7\17\2\2,-\7\13\2\2-:\7\17\2\2.\60\7\n\2\2/.\3\2\2\2/\60\3\2\2\2\60"+
		"\61\3\2\2\2\61:\7\21\2\2\62\63\7\13\2\2\63:\7\21\2\2\64:\5\n\6\2\65\66"+
		"\7\n\2\2\66:\5\n\6\2\678\7\13\2\28:\5\n\6\29$\3\2\2\29)\3\2\2\29,\3\2"+
		"\2\29/\3\2\2\29\62\3\2\2\29\64\3\2\2\29\65\3\2\2\29\67\3\2\2\2:C\3\2\2"+
		"\2;<\6\5\2\3<=\t\2\2\2=B\5\b\5\2>?\6\5\3\3?@\t\3\2\2@B\5\b\5\2A;\3\2\2"+
		"\2A>\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\t\3\2\2\2EC\3\2\2\2FG\7\f"+
		"\2\2GH\5\b\5\2HI\7\r\2\2I\13\3\2\2\2\t\20\")/9AC";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}