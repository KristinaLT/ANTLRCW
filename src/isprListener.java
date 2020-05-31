// Generated from C:/Users/Кристина/IdeaProjects/ANTLRCW/src\ispr.g4 by ANTLR 4.8
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
	 * Enter a parse tree produced by {@link isprParser#conditionunion}.
	 * @param ctx the parse tree
	 */
	void enterConditionunion(isprParser.ConditionunionContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#conditionunion}.
	 * @param ctx the parse tree
	 */
	void exitConditionunion(isprParser.ConditionunionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpCond}
	 * labeled alternative in {@link isprParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterExpCond(isprParser.ExpCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpCond}
	 * labeled alternative in {@link isprParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitExpCond(isprParser.ExpCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link isprParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterComparison(isprParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link isprParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitComparison(isprParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultExpr}
	 * labeled alternative in {@link isprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(isprParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultExpr}
	 * labeled alternative in {@link isprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(isprParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorExp}
	 * labeled alternative in {@link isprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFactorExp(isprParser.FactorExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorExp}
	 * labeled alternative in {@link isprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFactorExp(isprParser.FactorExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SummExpr}
	 * labeled alternative in {@link isprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSummExpr(isprParser.SummExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SummExpr}
	 * labeled alternative in {@link isprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSummExpr(isprParser.SummExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#expressionunion}.
	 * @param ctx the parse tree
	 */
	void enterExpressionunion(isprParser.ExpressionunionContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#expressionunion}.
	 * @param ctx the parse tree
	 */
	void exitExpressionunion(isprParser.ExpressionunionContext ctx);
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
	 * Enter a parse tree produced by {@link isprParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(isprParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(isprParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(isprParser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(isprParser.IntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#floatLiteral}.
	 * @param ctx the parse tree
	 */
	void enterFloatLiteral(isprParser.FloatLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#floatLiteral}.
	 * @param ctx the parse tree
	 */
	void exitFloatLiteral(isprParser.FloatLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#charLiteral}.
	 * @param ctx the parse tree
	 */
	void enterCharLiteral(isprParser.CharLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#charLiteral}.
	 * @param ctx the parse tree
	 */
	void exitCharLiteral(isprParser.CharLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link isprParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(isprParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link isprParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(isprParser.TypeContext ctx);
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