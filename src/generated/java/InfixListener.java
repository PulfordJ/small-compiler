// Generated from /home/john/Git/small-compiler/src/main/antlr/Infix.g4 by ANTLR 4.1
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InfixParser}.
 */
public interface InfixListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InfixParser#exprnop}.
	 * @param ctx the parse tree
	 */
	void enterExprnop(@NotNull InfixParser.ExprnopContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#exprnop}.
	 * @param ctx the parse tree
	 */
	void exitExprnop(@NotNull InfixParser.ExprnopContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#subVariable}.
	 * @param ctx the parse tree
	 */
	void enterSubVariable(@NotNull InfixParser.SubVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#subVariable}.
	 * @param ctx the parse tree
	 */
	void exitSubVariable(@NotNull InfixParser.SubVariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#parensWithMinus}.
	 * @param ctx the parse tree
	 */
	void enterParensWithMinus(@NotNull InfixParser.ParensWithMinusContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#parensWithMinus}.
	 * @param ctx the parse tree
	 */
	void exitParensWithMinus(@NotNull InfixParser.ParensWithMinusContext ctx);

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
	 * Enter a parse tree produced by {@link InfixParser#declareIntVariable}.
	 * @param ctx the parse tree
	 */
	void enterDeclareIntVariable(@NotNull InfixParser.DeclareIntVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#declareIntVariable}.
	 * @param ctx the parse tree
	 */
	void exitDeclareIntVariable(@NotNull InfixParser.DeclareIntVariableContext ctx);

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
	 * Enter a parse tree produced by {@link InfixParser#float}.
	 * @param ctx the parse tree
	 */
	void enterFloat(@NotNull InfixParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#float}.
	 * @param ctx the parse tree
	 */
	void exitFloat(@NotNull InfixParser.FloatContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#optionallySignedInt}.
	 * @param ctx the parse tree
	 */
	void enterOptionallySignedInt(@NotNull InfixParser.OptionallySignedIntContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#optionallySignedInt}.
	 * @param ctx the parse tree
	 */
	void exitOptionallySignedInt(@NotNull InfixParser.OptionallySignedIntContext ctx);

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
	 * Enter a parse tree produced by {@link InfixParser#parensnop}.
	 * @param ctx the parse tree
	 */
	void enterParensnop(@NotNull InfixParser.ParensnopContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#parensnop}.
	 * @param ctx the parse tree
	 */
	void exitParensnop(@NotNull InfixParser.ParensnopContext ctx);

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
	 * Enter a parse tree produced by {@link InfixParser#subOptionallySignedInt}.
	 * @param ctx the parse tree
	 */
	void enterSubOptionallySignedInt(@NotNull InfixParser.SubOptionallySignedIntContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#subOptionallySignedInt}.
	 * @param ctx the parse tree
	 */
	void exitSubOptionallySignedInt(@NotNull InfixParser.SubOptionallySignedIntContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixParser#parensWithAdd}.
	 * @param ctx the parse tree
	 */
	void enterParensWithAdd(@NotNull InfixParser.ParensWithAddContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#parensWithAdd}.
	 * @param ctx the parse tree
	 */
	void exitParensWithAdd(@NotNull InfixParser.ParensWithAddContext ctx);

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
	 * Enter a parse tree produced by {@link InfixParser#subFloat}.
	 * @param ctx the parse tree
	 */
	void enterSubFloat(@NotNull InfixParser.SubFloatContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#subFloat}.
	 * @param ctx the parse tree
	 */
	void exitSubFloat(@NotNull InfixParser.SubFloatContext ctx);

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
	 * Enter a parse tree produced by {@link InfixParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull InfixParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull InfixParser.VariableContext ctx);
}