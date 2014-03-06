// Generated from /home/john/Git/small-compiler/src/main/antlr/Infix.g4 by ANTLR 4.1
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InfixParser}.
 */
public interface InfixListener extends ParseTreeListener {
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
	 * Enter a parse tree produced by {@link InfixParser#printExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(@NotNull InfixParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#printExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(@NotNull InfixParser.PrintExprContext ctx);

	/**
<<<<<<< HEAD
	 * Enter a parse tree produced by {@link InfixParser#subFloat}.
	 * @param ctx the parse tree
	 */
	void enterSubFloat(@NotNull InfixParser.SubFloatContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#subFloat}.
	 * @param ctx the parse tree
	 */
	void exitSubFloat(@NotNull InfixParser.SubFloatContext ctx);
=======
	 * Enter a parse tree produced by {@link InfixParser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterSequence(@NotNull InfixParser.SequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitSequence(@NotNull InfixParser.SequenceContext ctx);
>>>>>>> feature/assignment_2

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
	 * Enter a parse tree produced by {@link InfixParser#nop}.
	 * @param ctx the parse tree
	 */
	void enterNop(@NotNull InfixParser.NopContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#nop}.
	 * @param ctx the parse tree
	 */
	void exitNop(@NotNull InfixParser.NopContext ctx);

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
	 * Enter a parse tree produced by {@link InfixParser#optionallySignedInt}.
	 * @param ctx the parse tree
	 */
	void enterOptionallySignedInt(@NotNull InfixParser.OptionallySignedIntContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#optionallySignedInt}.
	 * @param ctx the parse tree
	 */
	void exitOptionallySignedInt(@NotNull InfixParser.OptionallySignedIntContext ctx);
}