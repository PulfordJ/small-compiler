// Generated from /home/john/Git/small-compiler/src/main/antlr/InfixToPostfix.g4 by ANTLR 4.1
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InfixToPostfixParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InfixToPostfixVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InfixToPostfixParser#MulDivAddSub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivAddSub(@NotNull InfixToPostfixParser.MulDivAddSubContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixToPostfixParser#printExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExpr(@NotNull InfixToPostfixParser.PrintExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixToPostfixParser#parensWithMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensWithMinus(@NotNull InfixToPostfixParser.ParensWithMinusContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixToPostfixParser#parens}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(@NotNull InfixToPostfixParser.ParensContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixToPostfixParser#nop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNop(@NotNull InfixToPostfixParser.NopContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixToPostfixParser#float}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat(@NotNull InfixToPostfixParser.FloatContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixToPostfixParser#parensWithAdd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensWithAdd(@NotNull InfixToPostfixParser.ParensWithAddContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixToPostfixParser#optionallySignedInt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionallySignedInt(@NotNull InfixToPostfixParser.OptionallySignedIntContext ctx);
}