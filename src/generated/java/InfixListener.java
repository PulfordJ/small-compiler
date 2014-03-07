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
	 * Enter a parse tree produced by {@link InfixParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(@NotNull InfixParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(@NotNull InfixParser.BoolContext ctx);

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