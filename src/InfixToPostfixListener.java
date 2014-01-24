// Generated from src/InfixToPostfix.g4 by ANTLR 4.1
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
	 * Enter a parse tree produced by {@link InfixToPostfixParser#int}.
	 * @param ctx the parse tree
	 */
	void enterInt(@NotNull InfixToPostfixParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPostfixParser#int}.
	 * @param ctx the parse tree
	 */
	void exitInt(@NotNull InfixToPostfixParser.IntContext ctx);

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
	 * Enter a parse tree produced by {@link InfixToPostfixParser#float}.
	 * @param ctx the parse tree
	 */
	void enterFloat(@NotNull InfixToPostfixParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPostfixParser#float}.
	 * @param ctx the parse tree
	 */
	void exitFloat(@NotNull InfixToPostfixParser.FloatContext ctx);
}