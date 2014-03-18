// Generated from /home/john/Git/small-compiler/src/main/antlr/Infix.g4 by ANTLR 4.1
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InfixParser}.
 */
public interface InfixListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InfixParser#statementFunction}.
	 * @param ctx the parse tree
	 */
	void enterStatementFunction(@NotNull InfixParser.StatementFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#statementFunction}.
	 * @param ctx the parse tree
	 */
	void exitStatementFunction(@NotNull InfixParser.StatementFunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#unarySubExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnarySubExpr(@NotNull InfixParser.UnarySubExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#unarySubExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnarySubExpr(@NotNull InfixParser.UnarySubExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#unaryAddExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryAddExpr(@NotNull InfixParser.UnaryAddExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#unaryAddExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryAddExpr(@NotNull InfixParser.UnaryAddExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#factorFloat}.
	 * @param ctx the parse tree
	 */
	void enterFactorFloat(@NotNull InfixParser.FactorFloatContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#factorFloat}.
	 * @param ctx the parse tree
	 */
	void exitFactorFloat(@NotNull InfixParser.FactorFloatContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(@NotNull InfixParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(@NotNull InfixParser.BoolExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#boolTrue}.
	 * @param ctx the parse tree
	 */
	void enterBoolTrue(@NotNull InfixParser.BoolTrueContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#boolTrue}.
	 * @param ctx the parse tree
	 */
	void exitBoolTrue(@NotNull InfixParser.BoolTrueContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#statementAssign}.
	 * @param ctx the parse tree
	 */
	void enterStatementAssign(@NotNull InfixParser.StatementAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#statementAssign}.
	 * @param ctx the parse tree
	 */
	void exitStatementAssign(@NotNull InfixParser.StatementAssignContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(@NotNull InfixParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(@NotNull InfixParser.FunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(@NotNull InfixParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(@NotNull InfixParser.FunctionCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#funcArgs}.
	 * @param ctx the parse tree
	 */
	void enterFuncArgs(@NotNull InfixParser.FuncArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#funcArgs}.
	 * @param ctx the parse tree
	 */
	void exitFuncArgs(@NotNull InfixParser.FuncArgsContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#valueType}.
	 * @param ctx the parse tree
	 */
	void enterValueType(@NotNull InfixParser.ValueTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#valueType}.
	 * @param ctx the parse tree
	 */
	void exitValueType(@NotNull InfixParser.ValueTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#statementnop}.
	 * @param ctx the parse tree
	 */
	void enterStatementnop(@NotNull InfixParser.StatementnopContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#statementnop}.
	 * @param ctx the parse tree
	 */
	void exitStatementnop(@NotNull InfixParser.StatementnopContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#declareVariable}.
	 * @param ctx the parse tree
	 */
	void enterDeclareVariable(@NotNull InfixParser.DeclareVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#declareVariable}.
	 * @param ctx the parse tree
	 */
	void exitDeclareVariable(@NotNull InfixParser.DeclareVariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStatement(@NotNull InfixParser.IfElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStatement(@NotNull InfixParser.IfElseStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#boolLogic}.
	 * @param ctx the parse tree
	 */
	void enterBoolLogic(@NotNull InfixParser.BoolLogicContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#boolLogic}.
	 * @param ctx the parse tree
	 */
	void exitBoolLogic(@NotNull InfixParser.BoolLogicContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#statementConditional}.
	 * @param ctx the parse tree
	 */
	void enterStatementConditional(@NotNull InfixParser.StatementConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#statementConditional}.
	 * @param ctx the parse tree
	 */
	void exitStatementConditional(@NotNull InfixParser.StatementConditionalContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#MulDivAddSub}.
	 * @param ctx the parse tree
	 */
	void enterMulDivAddSub(@NotNull InfixParser.MulDivAddSubContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#MulDivAddSub}.
	 * @param ctx the parse tree
	 */
	void exitMulDivAddSub(@NotNull InfixParser.MulDivAddSubContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#boolFalse}.
	 * @param ctx the parse tree
	 */
	void enterBoolFalse(@NotNull InfixParser.BoolFalseContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#boolFalse}.
	 * @param ctx the parse tree
	 */
	void exitBoolFalse(@NotNull InfixParser.BoolFalseContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#assignVariable}.
	 * @param ctx the parse tree
	 */
	void enterAssignVariable(@NotNull InfixParser.AssignVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#assignVariable}.
	 * @param ctx the parse tree
	 */
	void exitAssignVariable(@NotNull InfixParser.AssignVariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#declareFuncArg}.
	 * @param ctx the parse tree
	 */
	void enterDeclareFuncArg(@NotNull InfixParser.DeclareFuncArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#declareFuncArg}.
	 * @param ctx the parse tree
	 */
	void exitDeclareFuncArg(@NotNull InfixParser.DeclareFuncArgContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#parens}.
	 * @param ctx the parse tree
	 */
	void enterParens(@NotNull InfixParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#parens}.
	 * @param ctx the parse tree
	 */
	void exitParens(@NotNull InfixParser.ParensContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#boolParened}.
	 * @param ctx the parse tree
	 */
	void enterBoolParened(@NotNull InfixParser.BoolParenedContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#boolParened}.
	 * @param ctx the parse tree
	 */
	void exitBoolParened(@NotNull InfixParser.BoolParenedContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(@NotNull InfixParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(@NotNull InfixParser.IfStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#factorInt}.
	 * @param ctx the parse tree
	 */
	void enterFactorInt(@NotNull InfixParser.FactorIntContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#factorInt}.
	 * @param ctx the parse tree
	 */
	void exitFactorInt(@NotNull InfixParser.FactorIntContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#statementExpr}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpr(@NotNull InfixParser.StatementExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#statementExpr}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpr(@NotNull InfixParser.StatementExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#factorID}.
	 * @param ctx the parse tree
	 */
	void enterFactorID(@NotNull InfixParser.FactorIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#factorID}.
	 * @param ctx the parse tree
	 */
	void exitFactorID(@NotNull InfixParser.FactorIDContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterSequence(@NotNull InfixParser.SequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitSequence(@NotNull InfixParser.SequenceContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#boilerplate}.
	 * @param ctx the parse tree
	 */
	void enterBoilerplate(@NotNull InfixParser.BoilerplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#boilerplate}.
	 * @param ctx the parse tree
	 */
	void exitBoilerplate(@NotNull InfixParser.BoilerplateContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(@NotNull InfixParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(@NotNull InfixParser.WhileLoopContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#factorParenedExpr}.
	 * @param ctx the parse tree
	 */
	void enterFactorParenedExpr(@NotNull InfixParser.FactorParenedExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#factorParenedExpr}.
	 * @param ctx the parse tree
	 */
	void exitFactorParenedExpr(@NotNull InfixParser.FactorParenedExprContext ctx);
}