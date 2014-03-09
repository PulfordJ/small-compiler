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
		INTTYPE=14, VARIABLE=15, INT=16, WS=17;
	public static final String[] tokenNames = {
		"<INVALID>", "':='", "'='", "'>'", "'<'", "'!='", "'*'", "'/'", "'+'", 
		"'-'", "'('", "')'", "'e'", "FLOAT", "'int'", "VARIABLE", "INT", "WS"
	};
	public static final int
		RULE_start = 0, RULE_sequence = 1, RULE_statement = 2, RULE_bool = 3, 
		RULE_declarations = 4, RULE_expr = 5, RULE_parenedexpr = 6;
	public static final String[] ruleNames = {
		"start", "sequence", "statement", "bool", "declarations", "expr", "parenedexpr"
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
			setState(14); sequence();
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
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public SequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16); statement();
			setState(18);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << LEFTPAREN) | (1L << FLOAT) | (1L << INTTYPE) | (1L << VARIABLE) | (1L << INT))) != 0)) {
				{
				setState(17); sequence();
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintExprContext extends StatementContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintExprContext(StatementContext ctx) { copyFrom(ctx); }
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
	public static class StatementnopContext extends StatementContext {
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public StatementnopContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterStatementnop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitStatementnop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitStatementnop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(22);
			switch (_input.LA(1)) {
			case ADD:
			case SUB:
			case LEFTPAREN:
			case FLOAT:
			case VARIABLE:
			case INT:
				_localctx = new PrintExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(20); expr(0);
				}
				break;
			case INTTYPE:
				_localctx = new StatementnopContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(21); declarations();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		enterRule(_localctx, 6, RULE_bool);
		try {
			setState(40);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(24); expr(0);
				setState(25); match(EQUALS);
				setState(26); expr(0);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(28); expr(0);
				setState(29); match(GREATERTHAN);
				setState(30); expr(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(32); expr(0);
				setState(33); match(LESSTHAN);
				setState(34); expr(0);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(36); expr(0);
				setState(37); match(NOTEQUALS);
				setState(38); expr(0);
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

	public static class DeclarationsContext extends ParserRuleContext {
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
	 
		public DeclarationsContext() { }
		public void copyFrom(DeclarationsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclareIntVariableContext extends DeclarationsContext {
		public TerminalNode VARIABLE() { return getToken(InfixParser.VARIABLE, 0); }
		public TerminalNode INTTYPE() { return getToken(InfixParser.INTTYPE, 0); }
		public DeclareIntVariableContext(DeclarationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterDeclareIntVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitDeclareIntVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitDeclareIntVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declarations);
		try {
			_localctx = new DeclareIntVariableContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(42); match(INTTYPE);
			setState(43); match(VARIABLE);
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
	public static class SubVariableContext extends ExprContext {
		public TerminalNode VARIABLE() { return getToken(InfixParser.VARIABLE, 0); }
		public TerminalNode SUB() { return getToken(InfixParser.SUB, 0); }
		public SubVariableContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterSubVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitSubVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitSubVariable(this);
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
	public static class ParensnopContext extends ExprContext {
		public ParenedexprContext parenedexpr() {
			return getRuleContext(ParenedexprContext.class,0);
		}
		public ParensnopContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterParensnop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitParensnop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitParensnop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableContext extends ExprContext {
		public TerminalNode VARIABLE() { return getToken(InfixParser.VARIABLE, 0); }
		public TerminalNode ADD() { return getToken(InfixParser.ADD, 0); }
		public VariableContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitVariable(this);
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
		int _startState = 10;
		enterRecursionRule(_localctx, RULE_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new AssignVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(46); match(VARIABLE);
				setState(47); match(ASSIGN);
				setState(48); expr(10);
				}
				break;

			case 2:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(50);
				_la = _input.LA(1);
				if (_la==ADD) {
					{
					setState(49); match(ADD);
					}
				}

				setState(52); match(VARIABLE);
				}
				break;

			case 3:
				{
				_localctx = new SubVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(53); match(SUB);
				setState(54); match(VARIABLE);
				}
				break;

			case 4:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				_la = _input.LA(1);
				if (_la==ADD) {
					{
					setState(55); match(ADD);
					}
				}

				setState(58); match(FLOAT);
				}
				break;

			case 5:
				{
				_localctx = new SubFloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(59); match(SUB);
				setState(60); match(FLOAT);
				}
				break;

			case 6:
				{
				_localctx = new OptionallySignedIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(62);
				_la = _input.LA(1);
				if (_la==ADD) {
					{
					setState(61); match(ADD);
					}
				}

				setState(64); match(INT);
				}
				break;

			case 7:
				{
				_localctx = new SubOptionallySignedIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65); match(SUB);
				setState(66); match(INT);
				}
				break;

			case 8:
				{
				_localctx = new ParensnopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(67); parenedexpr();
				}
				break;

			case 9:
				{
				_localctx = new ParensWithAddContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68); match(ADD);
				setState(69); parenedexpr();
				}
				break;

			case 10:
				{
				_localctx = new ParensWithMinusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(70); match(SUB);
				setState(71); parenedexpr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(82);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(80);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivAddSubContext(new ExprContext(_parentctx, _parentState, _p));
						((MulDivAddSubContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(74);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(75);
						((MulDivAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(76); ((MulDivAddSubContext)_localctx).right = expr(13);
						}
						break;

					case 2:
						{
						_localctx = new MulDivAddSubContext(new ExprContext(_parentctx, _parentState, _p));
						((MulDivAddSubContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(77);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(78);
						((MulDivAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((MulDivAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(79); ((MulDivAddSubContext)_localctx).right = expr(12);
						}
						break;
					}
					} 
				}
				setState(84);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		enterRule(_localctx, 12, RULE_parenedexpr);
		try {
			_localctx = new ParensContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(85); match(LEFTPAREN);
			setState(86); expr(0);
			setState(87); match(RIGHTPAREN);
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
		case 5: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 12 >= _localctx._p;

		case 1: return 11 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\23\\\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\3\3\3\5\3\25\n"+
		"\3\3\4\3\4\5\4\31\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\5\5+\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7\65\n\7\3"+
		"\7\3\7\3\7\3\7\5\7;\n\7\3\7\3\7\3\7\3\7\5\7A\n\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\5\7K\n\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7S\n\7\f\7\16\7V\13\7\3"+
		"\b\3\b\3\b\3\b\3\b\2\t\2\4\6\b\n\f\16\2\4\3\2\b\t\3\2\n\13g\2\20\3\2\2"+
		"\2\4\22\3\2\2\2\6\30\3\2\2\2\b*\3\2\2\2\n,\3\2\2\2\fJ\3\2\2\2\16W\3\2"+
		"\2\2\20\21\5\4\3\2\21\3\3\2\2\2\22\24\5\6\4\2\23\25\5\4\3\2\24\23\3\2"+
		"\2\2\24\25\3\2\2\2\25\5\3\2\2\2\26\31\5\f\7\2\27\31\5\n\6\2\30\26\3\2"+
		"\2\2\30\27\3\2\2\2\31\7\3\2\2\2\32\33\5\f\7\2\33\34\7\4\2\2\34\35\5\f"+
		"\7\2\35+\3\2\2\2\36\37\5\f\7\2\37 \7\5\2\2 !\5\f\7\2!+\3\2\2\2\"#\5\f"+
		"\7\2#$\7\6\2\2$%\5\f\7\2%+\3\2\2\2&\'\5\f\7\2\'(\7\7\2\2()\5\f\7\2)+\3"+
		"\2\2\2*\32\3\2\2\2*\36\3\2\2\2*\"\3\2\2\2*&\3\2\2\2+\t\3\2\2\2,-\7\20"+
		"\2\2-.\7\21\2\2.\13\3\2\2\2/\60\b\7\1\2\60\61\7\21\2\2\61\62\7\3\2\2\62"+
		"K\5\f\7\2\63\65\7\n\2\2\64\63\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\66K"+
		"\7\21\2\2\678\7\13\2\28K\7\21\2\29;\7\n\2\2:9\3\2\2\2:;\3\2\2\2;<\3\2"+
		"\2\2<K\7\17\2\2=>\7\13\2\2>K\7\17\2\2?A\7\n\2\2@?\3\2\2\2@A\3\2\2\2AB"+
		"\3\2\2\2BK\7\22\2\2CD\7\13\2\2DK\7\22\2\2EK\5\16\b\2FG\7\n\2\2GK\5\16"+
		"\b\2HI\7\13\2\2IK\5\16\b\2J/\3\2\2\2J\64\3\2\2\2J\67\3\2\2\2J:\3\2\2\2"+
		"J=\3\2\2\2J@\3\2\2\2JC\3\2\2\2JE\3\2\2\2JF\3\2\2\2JH\3\2\2\2KT\3\2\2\2"+
		"LM\6\7\2\3MN\t\2\2\2NS\5\f\7\2OP\6\7\3\3PQ\t\3\2\2QS\5\f\7\2RL\3\2\2\2"+
		"RO\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2U\r\3\2\2\2VT\3\2\2\2WX\7\f\2"+
		"\2XY\5\f\7\2YZ\7\r\2\2Z\17\3\2\2\2\13\24\30*\64:@JRT";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}