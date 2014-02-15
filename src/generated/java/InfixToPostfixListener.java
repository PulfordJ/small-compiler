// Generated from /home/john/Git/small-compiler/src/main/antlr/InfixToPostfix.g4 by ANTLR 4.1
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InfixToPostfixParser}.
 */
public interface InfixToPostfixListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InfixToPostfixParser#MulDivAddSub}.
	 * @param ctx the parse tree
	 */
	void enterMulDivAddSub(@NotNull InfixToPostfixParser.MulDivAddSubContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPostfixParser#MulDivAddSub}.
	 * @param ctx the parse tree
	 */
	void exitMulDivAddSub(@NotNull InfixToPostfixParser.MulDivAddSubContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixToPostfixParser#printExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(@NotNull InfixToPostfixParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPostfixParser#printExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(@NotNull InfixToPostfixParser.PrintExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixToPostfixParser#parensWithMinus}.
	 * @param ctx the parse tree
	 */
	void enterParensWithMinus(@NotNull InfixToPostfixParser.ParensWithMinusContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPostfixParser#parensWithMinus}.
	 * @param ctx the parse tree
	 */
	void exitParensWithMinus(@NotNull InfixToPostfixParser.ParensWithMinusContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixToPostfixParser#parensnop}.
	 * @param ctx the parse tree
	 */
	void enterParensnop(@NotNull InfixToPostfixParser.ParensnopContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPostfixParser#parensnop}.
	 * @param ctx the parse tree
	 */
	void exitParensnop(@NotNull InfixToPostfixParser.ParensnopContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixToPostfixParser#parens}.
	 * @param ctx the parse tree
	 */
	void enterParens(@NotNull InfixToPostfixParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPostfixParser#parens}.
	 * @param ctx the parse tree
	 */
	void exitParens(@NotNull InfixToPostfixParser.ParensContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixToPostfixParser#nop}.
	 * @param ctx the parse tree
	 */
	void enterNop(@NotNull InfixToPostfixParser.NopContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPostfixParser#nop}.
	 * @param ctx the parse tree
	 */
	void exitNop(@NotNull InfixToPostfixParser.NopContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixToPostfixParser#float}.
	 * @param ctx the parse tree
	 */
	void enterFloat(@NotNull InfixToPostfixParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPostfixParser#float}.
	 * @param ctx the parse tree
	 */
	void exitFloat(@NotNull InfixToPostfixParser.FloatContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixToPostfixParser#parensWithAdd}.
	 * @param ctx the parse tree
	 */
	void enterParensWithAdd(@NotNull InfixToPostfixParser.ParensWithAddContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPostfixParser#parensWithAdd}.
	 * @param ctx the parse tree
	 */
	void exitParensWithAdd(@NotNull InfixToPostfixParser.ParensWithAddContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixToPostfixParser#optionallySignedInt}.
	 * @param ctx the parse tree
	 */
	void enterOptionallySignedInt(@NotNull InfixToPostfixParser.OptionallySignedIntContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPostfixParser#optionallySignedInt}.
	 * @param ctx the parse tree
	 */
	void exitOptionallySignedInt(@NotNull InfixToPostfixParser.OptionallySignedIntContext ctx);
}