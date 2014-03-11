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
		SEMICOLON=1, ASSIGN=2, EQUALS=3, GREATERTHAN=4, LESSTHAN=5, NOTEQUALS=6, 
		MUL=7, DIV=8, ADD=9, SUB=10, LEFTPAREN=11, RIGHTPAREN=12, FLOATEXPONENT=13, 
		FLOAT=14, INTTYPE=15, INT=16, WS=17, LEFTCURLY=18, RIGHTCURLY=19, IF=20, 
		TRUE=21, FALSE=22, OR=23, AND=24, ELSE=25, WHILE=26, DEF=27, COMMA=28, 
		ID=29;
	public static final String[] tokenNames = {
		"<INVALID>", "';'", "':='", "'='", "'>'", "'<'", "'!='", "'*'", "'/'", 
		"'+'", "'-'", "'('", "')'", "'e'", "FLOAT", "'int'", "INT", "WS", "'{'", 
		"'}'", "'if'", "'true'", "'false'", "'or'", "'and'", "'else'", "'while'", 
		"'def'", "','", "ID"
	};
	public static final int
		RULE_start = 0, RULE_sequence = 1, RULE_statement = 2, RULE_assignment = 3, 
		RULE_bool = 4, RULE_declaration = 5, RULE_valueType = 6, RULE_conditional = 7, 
		RULE_func = 8, RULE_funcArgs = 9, RULE_funcArgDeclaration = 10, RULE_funcCall = 11, 
		RULE_loop = 12, RULE_expr = 13, RULE_parenedexpr = 14;
	public static final String[] ruleNames = {
		"start", "sequence", "statement", "assignment", "bool", "declaration", 
		"valueType", "conditional", "func", "funcArgs", "funcArgDeclaration", 
		"funcCall", "loop", "expr", "parenedexpr"
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
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(30); func();
					}
					} 
				}
				setState(35);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(36); sequence();
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEF) {
				{
				{
				setState(37); func();
				}
				}
				setState(42);
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
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTTYPE) {
				{
				{
				setState(43); declaration();
				setState(45);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(44); match(SEMICOLON);
					}
				}

				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << LEFTPAREN) | (1L << FLOAT) | (1L << INT) | (1L << IF) | (1L << WHILE) | (1L << ID))) != 0)) {
				{
				{
				setState(52); statement();
				}
				}
				setState(57);
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
			setState(66);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new StatementnopContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(58); loop();
				}
				break;

			case 2:
				_localctx = new StatementConditionalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(59); conditional();
				}
				break;

			case 3:
				_localctx = new StatementAssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(60); assignment();
				setState(61); match(SEMICOLON);
				}
				break;

			case 4:
				_localctx = new StatementExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(63); expr(0);
				setState(64); match(SEMICOLON);
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
			setState(68); match(ID);
			setState(69); match(ASSIGN);
			setState(70); expr(0);
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
		public TerminalNode NOTEQUALS() { return getToken(InfixParser.NOTEQUALS, 0); }
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
			setState(83);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new BoolExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(73); expr(0);
				setState(74);
				((BoolExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUALS) | (1L << GREATERTHAN) | (1L << LESSTHAN) | (1L << NOTEQUALS))) != 0)) ) {
					((BoolExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(75); expr(0);
				}
				break;

			case 2:
				{
				_localctx = new BoolTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77); match(TRUE);
				}
				break;

			case 3:
				{
				_localctx = new BoolFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78); match(FALSE);
				}
				break;

			case 4:
				{
				_localctx = new BoolParenedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79); match(LEFTPAREN);
				setState(80); bool(0);
				setState(81); match(RIGHTPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(90);
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
					setState(85);
					if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
					setState(86);
					((BoolLogicContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==OR || _la==AND) ) {
						((BoolLogicContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					consume();
					setState(87); ((BoolLogicContext)_localctx).rightBool = bool(3);
					}
					} 
				}
				setState(92);
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
	public static class DeclareIntVariableContext extends DeclarationContext {
		public TerminalNode ID() { return getToken(InfixParser.ID, 0); }
		public ValueTypeContext valueType() {
			return getRuleContext(ValueTypeContext.class,0);
		}
		public DeclareIntVariableContext(DeclarationContext ctx) { copyFrom(ctx); }
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

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaration);
		try {
			_localctx = new DeclareIntVariableContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(93); valueType();
			setState(94); match(ID);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); match(INTTYPE);
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
			setState(118);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(98); match(IF);
				setState(99); match(LEFTPAREN);
				setState(100); bool(0);
				setState(101); match(RIGHTPAREN);
				setState(102); match(LEFTCURLY);
				setState(103); sequence();
				setState(104); match(RIGHTCURLY);
				}
				break;

			case 2:
				_localctx = new IfElseStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(106); match(IF);
				setState(107); match(LEFTPAREN);
				setState(108); bool(0);
				setState(109); match(RIGHTPAREN);
				setState(110); match(LEFTCURLY);
				setState(111); ((IfElseStatementContext)_localctx).trueSequence = sequence();
				setState(112); match(RIGHTCURLY);
				setState(113); match(ELSE);
				setState(114); match(LEFTCURLY);
				setState(115); ((IfElseStatementContext)_localctx).falseSequence = sequence();
				setState(116); match(RIGHTCURLY);
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
			setState(120); match(DEF);
			setState(121); ((FunctionContext)_localctx).funcName = match(ID);
			setState(122); match(LEFTPAREN);
			setState(124);
			_la = _input.LA(1);
			if (_la==INTTYPE) {
				{
				setState(123); funcArgs();
				}
			}

			setState(126); match(RIGHTPAREN);
			setState(127); match(LEFTCURLY);
			setState(128); sequence();
			setState(129); match(RIGHTCURLY);
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
			setState(131); funcArgDeclaration();
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(132); match(COMMA);
				setState(133); funcArgDeclaration();
				}
				}
				setState(138);
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
			setState(139); valueType();
			setState(140); match(ID);
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
			setState(142); match(ID);
			setState(143); match(LEFTPAREN);
			setState(152);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << LEFTPAREN) | (1L << FLOAT) | (1L << INT) | (1L << ID))) != 0)) {
				{
				setState(144); expr(0);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(145); match(COMMA);
					setState(146); expr(0);
					}
					}
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(154); match(RIGHTPAREN);
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
			setState(156); match(WHILE);
			setState(157); match(LEFTPAREN);
			setState(158); bool(0);
			setState(159); match(RIGHTPAREN);
			setState(160); match(LEFTCURLY);
			setState(161); sequence();
			setState(162); match(RIGHTCURLY);
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
	public static class ExprnopContext extends ExprContext {
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public ExprnopContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterExprnop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitExprnop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitExprnop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubVariableContext extends ExprContext {
		public TerminalNode ID() { return getToken(InfixParser.ID, 0); }
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
		public TerminalNode ID() { return getToken(InfixParser.ID, 0); }
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
		int _startState = 26;
		enterRecursionRule(_localctx, RULE_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(166);
				_la = _input.LA(1);
				if (_la==ADD) {
					{
					setState(165); match(ADD);
					}
				}

				setState(168); match(ID);
				}
				break;

			case 2:
				{
				_localctx = new SubVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169); match(SUB);
				setState(170); match(ID);
				}
				break;

			case 3:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(172);
				_la = _input.LA(1);
				if (_la==ADD) {
					{
					setState(171); match(ADD);
					}
				}

				setState(174); match(FLOAT);
				}
				break;

			case 4:
				{
				_localctx = new SubFloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(175); match(SUB);
				setState(176); match(FLOAT);
				}
				break;

			case 5:
				{
				_localctx = new OptionallySignedIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(178);
				_la = _input.LA(1);
				if (_la==ADD) {
					{
					setState(177); match(ADD);
					}
				}

				setState(180); match(INT);
				}
				break;

			case 6:
				{
				_localctx = new SubOptionallySignedIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181); match(SUB);
				setState(182); match(INT);
				}
				break;

			case 7:
				{
				_localctx = new ParensnopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183); parenedexpr();
				}
				break;

			case 8:
				{
				_localctx = new ParensWithAddContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184); match(ADD);
				setState(185); parenedexpr();
				}
				break;

			case 9:
				{
				_localctx = new ParensWithMinusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(186); match(SUB);
				setState(187); parenedexpr();
				}
				break;

			case 10:
				{
				_localctx = new ExprnopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188); funcCall();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(197);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivAddSubContext(new ExprContext(_parentctx, _parentState, _p));
						((MulDivAddSubContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(191);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(192);
						((MulDivAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(193); ((MulDivAddSubContext)_localctx).right = expr(13);
						}
						break;

					case 2:
						{
						_localctx = new MulDivAddSubContext(new ExprContext(_parentctx, _parentState, _p));
						((MulDivAddSubContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(194);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(195);
						((MulDivAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((MulDivAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(196); ((MulDivAddSubContext)_localctx).right = expr(12);
						}
						break;
					}
					} 
				}
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		enterRule(_localctx, 28, RULE_parenedexpr);
		try {
			_localctx = new ParensContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(202); match(LEFTPAREN);
			setState(203); expr(0);
			setState(204); match(RIGHTPAREN);
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
		case 1: return 12 >= _localctx._p;

		case 2: return 11 >= _localctx._p;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\37\u00d1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\7\2\"\n\2\f\2"+
		"\16\2%\13\2\3\2\3\2\7\2)\n\2\f\2\16\2,\13\2\3\3\3\3\5\3\60\n\3\7\3\62"+
		"\n\3\f\3\16\3\65\13\3\3\3\7\38\n\3\f\3\16\3;\13\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\4E\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\5\6V\n\6\3\6\3\6\3\6\7\6[\n\6\f\6\16\6^\13\6\3\7\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\5\ty\n\t\3\n\3\n\3\n\3\n\5\n\177\n\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\7\13\u0089\n\13\f\13\16\13\u008c\13\13\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\7\r\u0096\n\r\f\r\16\r\u0099\13\r\5\r\u009b\n\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\5\17\u00a9"+
		"\n\17\3\17\3\17\3\17\3\17\5\17\u00af\n\17\3\17\3\17\3\17\3\17\5\17\u00b5"+
		"\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00c0\n\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\7\17\u00c8\n\17\f\17\16\17\u00cb\13\17\3\20"+
		"\3\20\3\20\3\20\3\20\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\6\3"+
		"\2\5\b\3\2\31\32\3\2\t\n\3\2\13\f\u00e0\2#\3\2\2\2\4\63\3\2\2\2\6D\3\2"+
		"\2\2\bF\3\2\2\2\nU\3\2\2\2\f_\3\2\2\2\16b\3\2\2\2\20x\3\2\2\2\22z\3\2"+
		"\2\2\24\u0085\3\2\2\2\26\u008d\3\2\2\2\30\u0090\3\2\2\2\32\u009e\3\2\2"+
		"\2\34\u00bf\3\2\2\2\36\u00cc\3\2\2\2 \"\5\22\n\2! \3\2\2\2\"%\3\2\2\2"+
		"#!\3\2\2\2#$\3\2\2\2$&\3\2\2\2%#\3\2\2\2&*\5\4\3\2\')\5\22\n\2(\'\3\2"+
		"\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\3\3\2\2\2,*\3\2\2\2-/\5\f\7\2.\60"+
		"\7\3\2\2/.\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61-\3\2\2\2\62\65\3\2\2\2"+
		"\63\61\3\2\2\2\63\64\3\2\2\2\649\3\2\2\2\65\63\3\2\2\2\668\5\6\4\2\67"+
		"\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:\5\3\2\2\2;9\3\2\2\2<E\5\32"+
		"\16\2=E\5\20\t\2>?\5\b\5\2?@\7\3\2\2@E\3\2\2\2AB\5\34\17\2BC\7\3\2\2C"+
		"E\3\2\2\2D<\3\2\2\2D=\3\2\2\2D>\3\2\2\2DA\3\2\2\2E\7\3\2\2\2FG\7\37\2"+
		"\2GH\7\4\2\2HI\5\34\17\2I\t\3\2\2\2JK\b\6\1\2KL\5\34\17\2LM\t\2\2\2MN"+
		"\5\34\17\2NV\3\2\2\2OV\7\27\2\2PV\7\30\2\2QR\7\r\2\2RS\5\n\6\2ST\7\16"+
		"\2\2TV\3\2\2\2UJ\3\2\2\2UO\3\2\2\2UP\3\2\2\2UQ\3\2\2\2V\\\3\2\2\2WX\6"+
		"\6\2\3XY\t\3\2\2Y[\5\n\6\2ZW\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]"+
		"\13\3\2\2\2^\\\3\2\2\2_`\5\16\b\2`a\7\37\2\2a\r\3\2\2\2bc\7\21\2\2c\17"+
		"\3\2\2\2de\7\26\2\2ef\7\r\2\2fg\5\n\6\2gh\7\16\2\2hi\7\24\2\2ij\5\4\3"+
		"\2jk\7\25\2\2ky\3\2\2\2lm\7\26\2\2mn\7\r\2\2no\5\n\6\2op\7\16\2\2pq\7"+
		"\24\2\2qr\5\4\3\2rs\7\25\2\2st\7\33\2\2tu\7\24\2\2uv\5\4\3\2vw\7\25\2"+
		"\2wy\3\2\2\2xd\3\2\2\2xl\3\2\2\2y\21\3\2\2\2z{\7\35\2\2{|\7\37\2\2|~\7"+
		"\r\2\2}\177\5\24\13\2~}\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081"+
		"\7\16\2\2\u0081\u0082\7\24\2\2\u0082\u0083\5\4\3\2\u0083\u0084\7\25\2"+
		"\2\u0084\23\3\2\2\2\u0085\u008a\5\26\f\2\u0086\u0087\7\36\2\2\u0087\u0089"+
		"\5\26\f\2\u0088\u0086\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2"+
		"\u008a\u008b\3\2\2\2\u008b\25\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008e"+
		"\5\16\b\2\u008e\u008f\7\37\2\2\u008f\27\3\2\2\2\u0090\u0091\7\37\2\2\u0091"+
		"\u009a\7\r\2\2\u0092\u0097\5\34\17\2\u0093\u0094\7\36\2\2\u0094\u0096"+
		"\5\34\17\2\u0095\u0093\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2"+
		"\u0097\u0098\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u0092"+
		"\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\7\16\2\2"+
		"\u009d\31\3\2\2\2\u009e\u009f\7\34\2\2\u009f\u00a0\7\r\2\2\u00a0\u00a1"+
		"\5\n\6\2\u00a1\u00a2\7\16\2\2\u00a2\u00a3\7\24\2\2\u00a3\u00a4\5\4\3\2"+
		"\u00a4\u00a5\7\25\2\2\u00a5\33\3\2\2\2\u00a6\u00a8\b\17\1\2\u00a7\u00a9"+
		"\7\13\2\2\u00a8\u00a7\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2"+
		"\u00aa\u00c0\7\37\2\2\u00ab\u00ac\7\f\2\2\u00ac\u00c0\7\37\2\2\u00ad\u00af"+
		"\7\13\2\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2"+
		"\u00b0\u00c0\7\20\2\2\u00b1\u00b2\7\f\2\2\u00b2\u00c0\7\20\2\2\u00b3\u00b5"+
		"\7\13\2\2\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2"+
		"\u00b6\u00c0\7\22\2\2\u00b7\u00b8\7\f\2\2\u00b8\u00c0\7\22\2\2\u00b9\u00c0"+
		"\5\36\20\2\u00ba\u00bb\7\13\2\2\u00bb\u00c0\5\36\20\2\u00bc\u00bd\7\f"+
		"\2\2\u00bd\u00c0\5\36\20\2\u00be\u00c0\5\30\r\2\u00bf\u00a6\3\2\2\2\u00bf"+
		"\u00ab\3\2\2\2\u00bf\u00ae\3\2\2\2\u00bf\u00b1\3\2\2\2\u00bf\u00b4\3\2"+
		"\2\2\u00bf\u00b7\3\2\2\2\u00bf\u00b9\3\2\2\2\u00bf\u00ba\3\2\2\2\u00bf"+
		"\u00bc\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c9\3\2\2\2\u00c1\u00c2\6\17"+
		"\3\3\u00c2\u00c3\t\4\2\2\u00c3\u00c8\5\34\17\2\u00c4\u00c5\6\17\4\3\u00c5"+
		"\u00c6\t\5\2\2\u00c6\u00c8\5\34\17\2\u00c7\u00c1\3\2\2\2\u00c7\u00c4\3"+
		"\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\35\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\7\r\2\2\u00cd\u00ce\5\34\17"+
		"\2\u00ce\u00cf\7\16\2\2\u00cf\37\3\2\2\2\25#*/\639DU\\x~\u008a\u0097\u009a"+
		"\u00a8\u00ae\u00b4\u00bf\u00c7\u00c9";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}