// Generated from /home/john/Git/small-compiler/src/main/antlr/Infix.g4 by ANTLR 4.1
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InfixParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InfixVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InfixParser#statementConditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementConditional(@NotNull InfixParser.StatementConditionalContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#MulDivAddSub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivAddSub(@NotNull InfixParser.MulDivAddSubContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#assignVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignVariable(@NotNull InfixParser.AssignVariableContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#boolFalse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolFalse(@NotNull InfixParser.BoolFalseContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#subVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubVariable(@NotNull InfixParser.SubVariableContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#parensWithMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensWithMinus(@NotNull InfixParser.ParensWithMinusContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#parens}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(@NotNull InfixParser.ParensContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#boolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(@NotNull InfixParser.BoolExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#boolParened}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolParened(@NotNull InfixParser.BoolParenedContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#declareIntVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareIntVariable(@NotNull InfixParser.DeclareIntVariableContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#float}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat(@NotNull InfixParser.FloatContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#statementAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementAssign(@NotNull InfixParser.StatementAssignContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#boolTrue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolTrue(@NotNull InfixParser.BoolTrueContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#subOptionallySignedInt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubOptionallySignedInt(@NotNull InfixParser.SubOptionallySignedIntContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#parensWithAdd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensWithAdd(@NotNull InfixParser.ParensWithAddContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#optionallySignedInt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionallySignedInt(@NotNull InfixParser.OptionallySignedIntContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(@NotNull InfixParser.IfStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#statementExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpr(@NotNull InfixParser.StatementExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#subFloat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubFloat(@NotNull InfixParser.SubFloatContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequence(@NotNull InfixParser.SequenceContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#parensnop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensnop(@NotNull InfixParser.ParensnopContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#boilerplate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoilerplate(@NotNull InfixParser.BoilerplateContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#statementnop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementnop(@NotNull InfixParser.StatementnopContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(@NotNull InfixParser.WhileLoopContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#ifElseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseStatement(@NotNull InfixParser.IfElseStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(@NotNull InfixParser.VariableContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#boolLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLogic(@NotNull InfixParser.BoolLogicContext ctx);
}