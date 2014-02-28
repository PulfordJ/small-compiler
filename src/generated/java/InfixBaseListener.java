// Generated from /home/john/Git/small-compiler/src/main/antlr/Infix.g4 by ANTLR 4.1

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link InfixListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class InfixBaseListener implements InfixListener {
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void enterMulDivAddSub(@NotNull InfixParser.MulDivAddSubContext ctx) { }
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void exitMulDivAddSub(@NotNull InfixParser.MulDivAddSubContext ctx) { }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void enterPrintExpr(@NotNull InfixParser.PrintExprContext ctx) { }
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void exitPrintExpr(@NotNull InfixParser.PrintExprContext ctx) { }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void enterSequence(@NotNull InfixParser.SequenceContext ctx) { }
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void exitSequence(@NotNull InfixParser.SequenceContext ctx) { }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void enterParensWithMinus(@NotNull InfixParser.ParensWithMinusContext ctx) { }
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void exitParensWithMinus(@NotNull InfixParser.ParensWithMinusContext ctx) { }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void enterParens(@NotNull InfixParser.ParensContext ctx) { }
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void exitParens(@NotNull InfixParser.ParensContext ctx) { }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void enterNop(@NotNull InfixParser.NopContext ctx) { }
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void exitNop(@NotNull InfixParser.NopContext ctx) { }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void enterFloat(@NotNull InfixParser.FloatContext ctx) { }
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void exitFloat(@NotNull InfixParser.FloatContext ctx) { }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void enterParensWithAdd(@NotNull InfixParser.ParensWithAddContext ctx) { }
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void exitParensWithAdd(@NotNull InfixParser.ParensWithAddContext ctx) { }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void enterOptionallySignedInt(@NotNull InfixParser.OptionallySignedIntContext ctx) { }
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void exitOptionallySignedInt(@NotNull InfixParser.OptionallySignedIntContext ctx) { }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void enterEveryRule(@NotNull ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void exitEveryRule(@NotNull ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void visitTerminal(@NotNull TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void visitErrorNode(@NotNull ErrorNode node) { }
}