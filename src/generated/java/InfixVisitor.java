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
	 * Visit a parse tree produced by {@link InfixParser#printExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExpr(@NotNull InfixParser.PrintExprContext ctx);

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
	 * Visit a parse tree produced by {@link InfixParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(@NotNull InfixParser.BoolContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(@NotNull InfixParser.VariableContext ctx);
}