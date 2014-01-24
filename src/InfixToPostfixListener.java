// Generated from src/InfixToPostfix.g4 by ANTLR 4.1
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InfixToPostfixParser}.
 */
public interface InfixToPostfixListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InfixToPostfixParser#opExpr}.
	 * @param ctx the parse tree
	 */
	void enterOpExpr(@NotNull InfixToPostfixParser.OpExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPostfixParser#opExpr}.
	 * @param ctx the parse tree
	 */
	void exitOpExpr(@NotNull InfixToPostfixParser.OpExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixToPostfixParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull InfixToPostfixParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPostfixParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull InfixToPostfixParser.StartContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixToPostfixParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(@NotNull InfixToPostfixParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPostfixParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(@NotNull InfixToPostfixParser.AtomExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link InfixToPostfixParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(@NotNull InfixToPostfixParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixToPostfixParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(@NotNull InfixToPostfixParser.FactorContext ctx);
}