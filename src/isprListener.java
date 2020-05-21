// Generated from C:/ANTLRCW/src\ispr.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link isprParser}.
 */
public interface isprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link isprParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(isprParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(isprParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(isprParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(isprParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#consts}.
	 * @param ctx the parse tree
	 */
	void enterConsts(isprParser.ConstsContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#consts}.
	 * @param ctx the parse tree
	 */
	void exitConsts(isprParser.ConstsContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#vars}.
	 * @param ctx the parse tree
	 */
	void enterVars(isprParser.VarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#vars}.
	 * @param ctx the parse tree
	 */
	void exitVars(isprParser.VarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#procedure}.
	 * @param ctx the parse tree
	 */
	void enterProcedure(isprParser.ProcedureContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#procedure}.
	 * @param ctx the parse tree
	 */
	void exitProcedure(isprParser.ProcedureContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(isprParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(isprParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#assignstmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignstmt(isprParser.AssignstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#assignstmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignstmt(isprParser.AssignstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#callstmt}.
	 * @param ctx the parse tree
	 */
	void enterCallstmt(isprParser.CallstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#callstmt}.
	 * @param ctx the parse tree
	 */
	void exitCallstmt(isprParser.CallstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#writestmt}.
	 * @param ctx the parse tree
	 */
	void enterWritestmt(isprParser.WritestmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#writestmt}.
	 * @param ctx the parse tree
	 */
	void exitWritestmt(isprParser.WritestmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#bangstmt}.
	 * @param ctx the parse tree
	 */
	void enterBangstmt(isprParser.BangstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#bangstmt}.
	 * @param ctx the parse tree
	 */
	void exitBangstmt(isprParser.BangstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#beginstmt}.
	 * @param ctx the parse tree
	 */
	void enterBeginstmt(isprParser.BeginstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#beginstmt}.
	 * @param ctx the parse tree
	 */
	void exitBeginstmt(isprParser.BeginstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void enterIfstmt(isprParser.IfstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void exitIfstmt(isprParser.IfstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#whilestmt}.
	 * @param ctx the parse tree
	 */
	void enterWhilestmt(isprParser.WhilestmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#whilestmt}.
	 * @param ctx the parse tree
	 */
	void exitWhilestmt(isprParser.WhilestmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#breakstmt}.
	 * @param ctx the parse tree
	 */
	void enterBreakstmt(isprParser.BreakstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#breakstmt}.
	 * @param ctx the parse tree
	 */
	void exitBreakstmt(isprParser.BreakstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#continuestmt}.
	 * @param ctx the parse tree
	 */
	void enterContinuestmt(isprParser.ContinuestmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#continuestmt}.
	 * @param ctx the parse tree
	 */
	void exitContinuestmt(isprParser.ContinuestmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(isprParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(isprParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(isprParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(isprParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(isprParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(isprParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(isprParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(isprParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(isprParser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(isprParser.IdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(isprParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(isprParser.NumberContext ctx);
}