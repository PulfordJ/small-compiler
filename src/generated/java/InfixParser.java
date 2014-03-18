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
		SEMICOLON=1, ASSIGN=2, EQUALS=3, GREATERTHAN=4, LESSTHAN=5, LESSTHANOREQUALS=6, 
		GREATERTHANOREQUALS=7, NOTEQUALS=8, MUL=9, DIV=10, ADD=11, SUB=12, LEFTPAREN=13, 
		RIGHTPAREN=14, FLOATEXPONENT=15, FLOAT=16, INTTYPE=17, FLOATTYPE=18, INT=19, 
		WS=20, LEFTCURLY=21, RIGHTCURLY=22, IF=23, TRUE=24, FALSE=25, OR=26, AND=27, 
		ELSE=28, WHILE=29, DEF=30, COMMA=31, ID=32;
	public static final String[] tokenNames = {
		"<INVALID>", "';'", "':='", "'='", "'>'", "'<'", "'<='", "'>='", "'!='", 
		"'*'", "'/'", "'+'", "'-'", "'('", "')'", "'e'", "FLOAT", "'int'", "'float'", 
		"INT", "WS", "'{'", "'}'", "'if'", "'true'", "'false'", "'or'", "'and'", 
		"'else'", "'while'", "'def'", "','", "ID"
	};
	public static final int
		RULE_start = 0, RULE_sequence = 1, RULE_statement = 2, RULE_assignment = 3, 
		RULE_bool = 4, RULE_declaration = 5, RULE_valueType = 6, RULE_conditional = 7, 
		RULE_func = 8, RULE_funcArgs = 9, RULE_funcArgDeclaration = 10, RULE_funcCall = 11, 
		RULE_loop = 12, RULE_expr = 13, RULE_factor = 14, RULE_parenedexpr = 15;
	public static final String[] ruleNames = {
		"start", "sequence", "statement", "assignment", "bool", "declaration", 
		"valueType", "conditional", "func", "funcArgs", "funcArgDeclaration", 
		"funcCall", "loop", "expr", "factor", "parenedexpr"
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
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
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
		int _la;
		try {
			int _alt;
			_localctx = new BoilerplateContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(32); func();
					}
					} 
				}
				setState(37);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(38); sequence();
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEF) {
				{
				{
				setState(39); func();
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class SequenceContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(InfixParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(InfixParser.SEMICOLON, i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTTYPE || _la==FLOATTYPE) {
				{
				{
				setState(45); declaration();
				setState(47);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(46); match(SEMICOLON);
					}
				}

				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << LEFTPAREN) | (1L << FLOAT) | (1L << INT) | (1L << IF) | (1L << WHILE) | (1L << ID))) != 0)) {
				{
				{
				setState(54); statement();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class StatementFunctionContext extends StatementContext {
		public TerminalNode SEMICOLON() { return getToken(InfixParser.SEMICOLON, 0); }
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public StatementFunctionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterStatementFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitStatementFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitStatementFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementConditionalContext extends StatementContext {
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public StatementConditionalContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterStatementConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitStatementConditional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitStatementConditional(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementExprContext extends StatementContext {
		public TerminalNode SEMICOLON() { return getToken(InfixParser.SEMICOLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementExprContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterStatementExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitStatementExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitStatementExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementnopContext extends StatementContext {
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
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
	public static class StatementAssignContext extends StatementContext {
		public TerminalNode SEMICOLON() { return getToken(InfixParser.SEMICOLON, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public StatementAssignContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterStatementAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitStatementAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitStatementAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(71);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new StatementnopContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(60); loop();
				}
				break;

			case 2:
				_localctx = new StatementConditionalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(61); conditional();
				}
				break;

			case 3:
				_localctx = new StatementFunctionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(62); funcCall();
				setState(63); match(SEMICOLON);
				}
				break;

			case 4:
				_localctx = new StatementAssignContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(65); assignment();
				setState(66); match(SEMICOLON);
				}
				break;

			case 5:
				_localctx = new StatementExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(68); expr(0);
				setState(69); match(SEMICOLON);
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

	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignVariableContext extends AssignmentContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(InfixParser.ASSIGN, 0); }
		public TerminalNode ID() { return getToken(InfixParser.ID, 0); }
		public AssignVariableContext(AssignmentContext ctx) { copyFrom(ctx); }
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

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			_localctx = new AssignVariableContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(73); match(ID);
			setState(74); match(ASSIGN);
			setState(75); expr(0);
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
		public int _p;
		public BoolContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public BoolContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_bool; }
	 
		public BoolContext() { }
		public void copyFrom(BoolContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class BoolFalseContext extends BoolContext {
		public TerminalNode FALSE() { return getToken(InfixParser.FALSE, 0); }
		public BoolFalseContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterBoolFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitBoolFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitBoolFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExprContext extends BoolContext {
		public Token op;
		public TerminalNode LESSTHAN() { return getToken(InfixParser.LESSTHAN, 0); }
		public TerminalNode GREATERTHAN() { return getToken(InfixParser.GREATERTHAN, 0); }
		public TerminalNode EQUALS() { return getToken(InfixParser.EQUALS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LESSTHANOREQUALS() { return getToken(InfixParser.LESSTHANOREQUALS, 0); }
		public TerminalNode NOTEQUALS() { return getToken(InfixParser.NOTEQUALS, 0); }
		public TerminalNode GREATERTHANOREQUALS() { return getToken(InfixParser.GREATERTHANOREQUALS, 0); }
		public BoolExprContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolParenedContext extends BoolContext {
		public TerminalNode RIGHTPAREN() { return getToken(InfixParser.RIGHTPAREN, 0); }
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public TerminalNode LEFTPAREN() { return getToken(InfixParser.LEFTPAREN, 0); }
		public BoolParenedContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterBoolParened(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitBoolParened(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitBoolParened(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolTrueContext extends BoolContext {
		public TerminalNode TRUE() { return getToken(InfixParser.TRUE, 0); }
		public BoolTrueContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterBoolTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitBoolTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitBoolTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolLogicContext extends BoolContext {
		public BoolContext leftBool;
		public Token op;
		public BoolContext rightBool;
		public List<BoolContext> bool() {
			return getRuleContexts(BoolContext.class);
		}
		public TerminalNode AND() { return getToken(InfixParser.AND, 0); }
		public TerminalNode OR() { return getToken(InfixParser.OR, 0); }
		public BoolContext bool(int i) {
			return getRuleContext(BoolContext.class,i);
		}
		public BoolLogicContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterBoolLogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitBoolLogic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitBoolLogic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BoolContext _localctx = new BoolContext(_ctx, _parentState, _p);
		BoolContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, RULE_bool);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new BoolExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(78); expr(0);
				setState(79);
				((BoolExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUALS) | (1L << GREATERTHAN) | (1L << LESSTHAN) | (1L << LESSTHANOREQUALS) | (1L << GREATERTHANOREQUALS) | (1L << NOTEQUALS))) != 0)) ) {
					((BoolExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(80); expr(0);
				}
				break;

			case 2:
				{
				_localctx = new BoolTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82); match(TRUE);
				}
				break;

			case 3:
				{
				_localctx = new BoolFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83); match(FALSE);
				}
				break;

			case 4:
				{
				_localctx = new BoolParenedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84); match(LEFTPAREN);
				setState(85); bool(0);
				setState(86); match(RIGHTPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(95);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BoolLogicContext(new BoolContext(_parentctx, _parentState, _p));
					((BoolLogicContext)_localctx).leftBool = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_bool);
					setState(90);
					if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
					setState(91);
					((BoolLogicContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==OR || _la==AND) ) {
						((BoolLogicContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					consume();
					setState(92); ((BoolLogicContext)_localctx).rightBool = bool(3);
					}
					} 
				}
				setState(97);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclareVariableContext extends DeclarationContext {
		public TerminalNode ID() { return getToken(InfixParser.ID, 0); }
		public ValueTypeContext valueType() {
			return getRuleContext(ValueTypeContext.class,0);
		}
		public DeclareVariableContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterDeclareVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitDeclareVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitDeclareVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaration);
		try {
			_localctx = new DeclareVariableContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(98); valueType();
			setState(99); match(ID);
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

	public static class ValueTypeContext extends ParserRuleContext {
		public TerminalNode FLOATTYPE() { return getToken(InfixParser.FLOATTYPE, 0); }
		public TerminalNode INTTYPE() { return getToken(InfixParser.INTTYPE, 0); }
		public ValueTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterValueType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitValueType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitValueType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueTypeContext valueType() throws RecognitionException {
		ValueTypeContext _localctx = new ValueTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_valueType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_la = _input.LA(1);
			if ( !(_la==INTTYPE || _la==FLOATTYPE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class ConditionalContext extends ParserRuleContext {
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
	 
		public ConditionalContext() { }
		public void copyFrom(ConditionalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfElseStatementContext extends ConditionalContext {
		public SequenceContext trueSequence;
		public SequenceContext falseSequence;
		public TerminalNode IF() { return getToken(InfixParser.IF, 0); }
		public TerminalNode RIGHTPAREN() { return getToken(InfixParser.RIGHTPAREN, 0); }
		public TerminalNode LEFTCURLY(int i) {
			return getToken(InfixParser.LEFTCURLY, i);
		}
		public TerminalNode ELSE() { return getToken(InfixParser.ELSE, 0); }
		public TerminalNode RIGHTCURLY(int i) {
			return getToken(InfixParser.RIGHTCURLY, i);
		}
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public List<TerminalNode> LEFTCURLY() { return getTokens(InfixParser.LEFTCURLY); }
		public SequenceContext sequence(int i) {
			return getRuleContext(SequenceContext.class,i);
		}
		public List<SequenceContext> sequence() {
			return getRuleContexts(SequenceContext.class);
		}
		public TerminalNode LEFTPAREN() { return getToken(InfixParser.LEFTPAREN, 0); }
		public List<TerminalNode> RIGHTCURLY() { return getTokens(InfixParser.RIGHTCURLY); }
		public IfElseStatementContext(ConditionalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterIfElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitIfElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitIfElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStatementContext extends ConditionalContext {
		public TerminalNode IF() { return getToken(InfixParser.IF, 0); }
		public TerminalNode RIGHTPAREN() { return getToken(InfixParser.RIGHTPAREN, 0); }
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public TerminalNode LEFTCURLY() { return getToken(InfixParser.LEFTCURLY, 0); }
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public TerminalNode LEFTPAREN() { return getToken(InfixParser.LEFTPAREN, 0); }
		public TerminalNode RIGHTCURLY() { return getToken(InfixParser.RIGHTCURLY, 0); }
		public IfStatementContext(ConditionalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_conditional);
		try {
			setState(123);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(103); match(IF);
				setState(104); match(LEFTPAREN);
				setState(105); bool(0);
				setState(106); match(RIGHTPAREN);
				setState(107); match(LEFTCURLY);
				setState(108); sequence();
				setState(109); match(RIGHTCURLY);
				}
				break;

			case 2:
				_localctx = new IfElseStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(111); match(IF);
				setState(112); match(LEFTPAREN);
				setState(113); bool(0);
				setState(114); match(RIGHTPAREN);
				setState(115); match(LEFTCURLY);
				setState(116); ((IfElseStatementContext)_localctx).trueSequence = sequence();
				setState(117); match(RIGHTCURLY);
				setState(118); match(ELSE);
				setState(119); match(LEFTCURLY);
				setState(120); ((IfElseStatementContext)_localctx).falseSequence = sequence();
				setState(121); match(RIGHTCURLY);
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

	public static class FuncContext extends ParserRuleContext {
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
	 
		public FuncContext() { }
		public void copyFrom(FuncContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunctionContext extends FuncContext {
		public Token funcName;
		public TerminalNode RIGHTPAREN() { return getToken(InfixParser.RIGHTPAREN, 0); }
		public FuncArgsContext funcArgs() {
			return getRuleContext(FuncArgsContext.class,0);
		}
		public TerminalNode DEF() { return getToken(InfixParser.DEF, 0); }
		public TerminalNode ID() { return getToken(InfixParser.ID, 0); }
		public TerminalNode LEFTCURLY() { return getToken(InfixParser.LEFTCURLY, 0); }
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public TerminalNode LEFTPAREN() { return getToken(InfixParser.LEFTPAREN, 0); }
		public TerminalNode RIGHTCURLY() { return getToken(InfixParser.RIGHTCURLY, 0); }
		public FunctionContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_func);
		int _la;
		try {
			_localctx = new FunctionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(125); match(DEF);
			setState(126); ((FunctionContext)_localctx).funcName = match(ID);
			setState(127); match(LEFTPAREN);
			setState(129);
			_la = _input.LA(1);
			if (_la==INTTYPE || _la==FLOATTYPE) {
				{
				setState(128); funcArgs();
				}
			}

			setState(131); match(RIGHTPAREN);
			setState(132); match(LEFTCURLY);
			setState(133); sequence();
			setState(134); match(RIGHTCURLY);
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

	public static class FuncArgsContext extends ParserRuleContext {
		public List<FuncArgDeclarationContext> funcArgDeclaration() {
			return getRuleContexts(FuncArgDeclarationContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(InfixParser.COMMA); }
		public FuncArgDeclarationContext funcArgDeclaration(int i) {
			return getRuleContext(FuncArgDeclarationContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(InfixParser.COMMA, i);
		}
		public FuncArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterFuncArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitFuncArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitFuncArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncArgsContext funcArgs() throws RecognitionException {
		FuncArgsContext _localctx = new FuncArgsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funcArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136); funcArgDeclaration();
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(137); match(COMMA);
				setState(138); funcArgDeclaration();
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class FuncArgDeclarationContext extends ParserRuleContext {
		public FuncArgDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcArgDeclaration; }
	 
		public FuncArgDeclarationContext() { }
		public void copyFrom(FuncArgDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclareFuncArgContext extends FuncArgDeclarationContext {
		public TerminalNode ID() { return getToken(InfixParser.ID, 0); }
		public ValueTypeContext valueType() {
			return getRuleContext(ValueTypeContext.class,0);
		}
		public DeclareFuncArgContext(FuncArgDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterDeclareFuncArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitDeclareFuncArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitDeclareFuncArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncArgDeclarationContext funcArgDeclaration() throws RecognitionException {
		FuncArgDeclarationContext _localctx = new FuncArgDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcArgDeclaration);
		try {
			_localctx = new DeclareFuncArgContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(144); valueType();
			setState(145); match(ID);
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

	public static class FuncCallContext extends ParserRuleContext {
		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall; }
	 
		public FuncCallContext() { }
		public void copyFrom(FuncCallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunctionCallContext extends FuncCallContext {
		public TerminalNode RIGHTPAREN() { return getToken(InfixParser.RIGHTPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(InfixParser.COMMA); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ID() { return getToken(InfixParser.ID, 0); }
		public TerminalNode LEFTPAREN() { return getToken(InfixParser.LEFTPAREN, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(InfixParser.COMMA, i);
		}
		public FunctionCallContext(FuncCallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_funcCall);
		int _la;
		try {
			_localctx = new FunctionCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(147); match(ID);
			setState(148); match(LEFTPAREN);
			setState(157);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << LEFTPAREN) | (1L << FLOAT) | (1L << INT) | (1L << ID))) != 0)) {
				{
				setState(149); expr(0);
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(150); match(COMMA);
					setState(151); expr(0);
					}
					}
					setState(156);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(159); match(RIGHTPAREN);
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

	public static class LoopContext extends ParserRuleContext {
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
	 
		public LoopContext() { }
		public void copyFrom(LoopContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WhileLoopContext extends LoopContext {
		public TerminalNode WHILE() { return getToken(InfixParser.WHILE, 0); }
		public TerminalNode RIGHTPAREN() { return getToken(InfixParser.RIGHTPAREN, 0); }
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public TerminalNode LEFTCURLY() { return getToken(InfixParser.LEFTCURLY, 0); }
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public TerminalNode LEFTPAREN() { return getToken(InfixParser.LEFTPAREN, 0); }
		public TerminalNode RIGHTCURLY() { return getToken(InfixParser.RIGHTCURLY, 0); }
		public WhileLoopContext(LoopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitWhileLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_loop);
		try {
			_localctx = new WhileLoopContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(161); match(WHILE);
			setState(162); match(LEFTPAREN);
			setState(163); bool(0);
			setState(164); match(RIGHTPAREN);
			setState(165); match(LEFTCURLY);
			setState(166); sequence();
			setState(167); match(RIGHTCURLY);
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
	public static class UnarySubExprContext extends ExprContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode SUB() { return getToken(InfixParser.SUB, 0); }
		public UnarySubExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterUnarySubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitUnarySubExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitUnarySubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryAddExprContext extends ExprContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode ADD() { return getToken(InfixParser.ADD, 0); }
		public UnaryAddExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterUnaryAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitUnaryAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitUnaryAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState, _p);
		ExprContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, RULE_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			switch (_input.LA(1)) {
			case SUB:
				{
				_localctx = new UnarySubExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(170); match(SUB);
				setState(171); factor();
				}
				break;
			case ADD:
			case LEFTPAREN:
			case FLOAT:
			case INT:
			case ID:
				{
				_localctx = new UnaryAddExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(173);
				_la = _input.LA(1);
				if (_la==ADD) {
					{
					setState(172); match(ADD);
					}
				}

				setState(175); factor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(184);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivAddSubContext(new ExprContext(_parentctx, _parentState, _p));
						((MulDivAddSubContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(178);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(179);
						((MulDivAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(180); ((MulDivAddSubContext)_localctx).right = expr(5);
						}
						break;

					case 2:
						{
						_localctx = new MulDivAddSubContext(new ExprContext(_parentctx, _parentState, _p));
						((MulDivAddSubContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(181);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(182);
						((MulDivAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((MulDivAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(183); ((MulDivAddSubContext)_localctx).right = expr(4);
						}
						break;
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public static class FactorContext extends ParserRuleContext {
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FactorIntContext extends FactorContext {
		public TerminalNode INT() { return getToken(InfixParser.INT, 0); }
		public FactorIntContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterFactorInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitFactorInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitFactorInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactorIDContext extends FactorContext {
		public TerminalNode ID() { return getToken(InfixParser.ID, 0); }
		public FactorIDContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterFactorID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitFactorID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitFactorID(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactorFloatContext extends FactorContext {
		public TerminalNode FLOAT() { return getToken(InfixParser.FLOAT, 0); }
		public FactorFloatContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterFactorFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitFactorFloat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitFactorFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactorParenedExprContext extends FactorContext {
		public ParenedexprContext parenedexpr() {
			return getRuleContext(ParenedexprContext.class,0);
		}
		public FactorParenedExprContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterFactorParenedExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitFactorParenedExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitFactorParenedExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_factor);
		try {
			setState(193);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new FactorIDContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(189); match(ID);
				}
				break;
			case FLOAT:
				_localctx = new FactorFloatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(190); match(FLOAT);
				}
				break;
			case INT:
				_localctx = new FactorIntContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(191); match(INT);
				}
				break;
			case LEFTPAREN:
				_localctx = new FactorParenedExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(192); parenedexpr();
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
		enterRule(_localctx, 30, RULE_parenedexpr);
		try {
			_localctx = new ParensContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(195); match(LEFTPAREN);
			setState(196); expr(0);
			setState(197); match(RIGHTPAREN);
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
		case 4: return bool_sempred((BoolContext)_localctx, predIndex);

		case 13: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return 4 >= _localctx._p;

		case 2: return 3 >= _localctx._p;
		}
		return true;
	}
	private boolean bool_sempred(BoolContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 2 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\"\u00ca\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\7\2$\n"+
		"\2\f\2\16\2\'\13\2\3\2\3\2\7\2+\n\2\f\2\16\2.\13\2\3\3\3\3\5\3\62\n\3"+
		"\7\3\64\n\3\f\3\16\3\67\13\3\3\3\7\3:\n\3\f\3\16\3=\13\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4J\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6[\n\6\3\6\3\6\3\6\7\6`\n\6\f\6\16\6"+
		"c\13\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t~\n\t\3\n\3\n\3\n\3\n\5\n\u0084"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\7\13\u008e\n\13\f\13\16\13\u0091"+
		"\13\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\7\r\u009b\n\r\f\r\16\r\u009e\13"+
		"\r\5\r\u00a0\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\5\17\u00b0\n\17\3\17\5\17\u00b3\n\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\7\17\u00bb\n\17\f\17\16\17\u00be\13\17\3\20\3\20\3\20\3"+
		"\20\5\20\u00c4\n\20\3\21\3\21\3\21\3\21\3\21\2\22\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \2\7\3\2\5\n\3\2\34\35\3\2\23\24\3\2\13\f\3\2\r\16"+
		"\u00d2\2%\3\2\2\2\4\65\3\2\2\2\6I\3\2\2\2\bK\3\2\2\2\nZ\3\2\2\2\fd\3\2"+
		"\2\2\16g\3\2\2\2\20}\3\2\2\2\22\177\3\2\2\2\24\u008a\3\2\2\2\26\u0092"+
		"\3\2\2\2\30\u0095\3\2\2\2\32\u00a3\3\2\2\2\34\u00b2\3\2\2\2\36\u00c3\3"+
		"\2\2\2 \u00c5\3\2\2\2\"$\5\22\n\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3"+
		"\2\2\2&(\3\2\2\2\'%\3\2\2\2(,\5\4\3\2)+\5\22\n\2*)\3\2\2\2+.\3\2\2\2,"+
		"*\3\2\2\2,-\3\2\2\2-\3\3\2\2\2.,\3\2\2\2/\61\5\f\7\2\60\62\7\3\2\2\61"+
		"\60\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2\63/\3\2\2\2\64\67\3\2\2\2\65\63"+
		"\3\2\2\2\65\66\3\2\2\2\66;\3\2\2\2\67\65\3\2\2\28:\5\6\4\298\3\2\2\2:"+
		"=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\5\3\2\2\2=;\3\2\2\2>J\5\32\16\2?J\5\20"+
		"\t\2@A\5\30\r\2AB\7\3\2\2BJ\3\2\2\2CD\5\b\5\2DE\7\3\2\2EJ\3\2\2\2FG\5"+
		"\34\17\2GH\7\3\2\2HJ\3\2\2\2I>\3\2\2\2I?\3\2\2\2I@\3\2\2\2IC\3\2\2\2I"+
		"F\3\2\2\2J\7\3\2\2\2KL\7\"\2\2LM\7\4\2\2MN\5\34\17\2N\t\3\2\2\2OP\b\6"+
		"\1\2PQ\5\34\17\2QR\t\2\2\2RS\5\34\17\2S[\3\2\2\2T[\7\32\2\2U[\7\33\2\2"+
		"VW\7\17\2\2WX\5\n\6\2XY\7\20\2\2Y[\3\2\2\2ZO\3\2\2\2ZT\3\2\2\2ZU\3\2\2"+
		"\2ZV\3\2\2\2[a\3\2\2\2\\]\6\6\2\3]^\t\3\2\2^`\5\n\6\2_\\\3\2\2\2`c\3\2"+
		"\2\2a_\3\2\2\2ab\3\2\2\2b\13\3\2\2\2ca\3\2\2\2de\5\16\b\2ef\7\"\2\2f\r"+
		"\3\2\2\2gh\t\4\2\2h\17\3\2\2\2ij\7\31\2\2jk\7\17\2\2kl\5\n\6\2lm\7\20"+
		"\2\2mn\7\27\2\2no\5\4\3\2op\7\30\2\2p~\3\2\2\2qr\7\31\2\2rs\7\17\2\2s"+
		"t\5\n\6\2tu\7\20\2\2uv\7\27\2\2vw\5\4\3\2wx\7\30\2\2xy\7\36\2\2yz\7\27"+
		"\2\2z{\5\4\3\2{|\7\30\2\2|~\3\2\2\2}i\3\2\2\2}q\3\2\2\2~\21\3\2\2\2\177"+
		"\u0080\7 \2\2\u0080\u0081\7\"\2\2\u0081\u0083\7\17\2\2\u0082\u0084\5\24"+
		"\13\2\u0083\u0082\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0086\7\20\2\2\u0086\u0087\7\27\2\2\u0087\u0088\5\4\3\2\u0088\u0089\7"+
		"\30\2\2\u0089\23\3\2\2\2\u008a\u008f\5\26\f\2\u008b\u008c\7!\2\2\u008c"+
		"\u008e\5\26\f\2\u008d\u008b\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3"+
		"\2\2\2\u008f\u0090\3\2\2\2\u0090\25\3\2\2\2\u0091\u008f\3\2\2\2\u0092"+
		"\u0093\5\16\b\2\u0093\u0094\7\"\2\2\u0094\27\3\2\2\2\u0095\u0096\7\"\2"+
		"\2\u0096\u009f\7\17\2\2\u0097\u009c\5\34\17\2\u0098\u0099\7!\2\2\u0099"+
		"\u009b\5\34\17\2\u009a\u0098\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3"+
		"\2\2\2\u009c\u009d\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u0097\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\7\20"+
		"\2\2\u00a2\31\3\2\2\2\u00a3\u00a4\7\37\2\2\u00a4\u00a5\7\17\2\2\u00a5"+
		"\u00a6\5\n\6\2\u00a6\u00a7\7\20\2\2\u00a7\u00a8\7\27\2\2\u00a8\u00a9\5"+
		"\4\3\2\u00a9\u00aa\7\30\2\2\u00aa\33\3\2\2\2\u00ab\u00ac\b\17\1\2\u00ac"+
		"\u00ad\7\16\2\2\u00ad\u00b3\5\36\20\2\u00ae\u00b0\7\r\2\2\u00af\u00ae"+
		"\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\5\36\20\2"+
		"\u00b2\u00ab\3\2\2\2\u00b2\u00af\3\2\2\2\u00b3\u00bc\3\2\2\2\u00b4\u00b5"+
		"\6\17\3\3\u00b5\u00b6\t\5\2\2\u00b6\u00bb\5\34\17\2\u00b7\u00b8\6\17\4"+
		"\3\u00b8\u00b9\t\6\2\2\u00b9\u00bb\5\34\17\2\u00ba\u00b4\3\2\2\2\u00ba"+
		"\u00b7\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2"+
		"\2\2\u00bd\35\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c4\7\"\2\2\u00c0\u00c4"+
		"\7\22\2\2\u00c1\u00c4\7\25\2\2\u00c2\u00c4\5 \21\2\u00c3\u00bf\3\2\2\2"+
		"\u00c3\u00c0\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c2\3\2\2\2\u00c4\37"+
		"\3\2\2\2\u00c5\u00c6\7\17\2\2\u00c6\u00c7\5\34\17\2\u00c7\u00c8\7\20\2"+
		"\2\u00c8!\3\2\2\2\24%,\61\65;IZa}\u0083\u008f\u009c\u009f\u00af\u00b2"+
		"\u00ba\u00bc\u00c3";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}