// Generated from src/InfixToPostfix.g4 by ANTLR 4.1
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
	 * Visit a parse tree produced by {@link InfixToPostfixParser#opExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpExpr(@NotNull InfixToPostfixParser.OpExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixToPostfixParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(@NotNull InfixToPostfixParser.StartContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixToPostfixParser#atomExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(@NotNull InfixToPostfixParser.AtomExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link InfixToPostfixParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(@NotNull InfixToPostfixParser.FactorContext ctx);
}