// Generated from C:/ANTLRCW/src\ispr.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link isprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface isprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link isprParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(isprParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link isprParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(isprParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link isprParser#consts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConsts(isprParser.ConstsContext ctx);
	/**
	 * Visit a parse tree produced by {@link isprParser#vars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVars(isprParser.VarsContext ctx);
	/**
	 * Visit a parse tree produced by {@link isprParser#procedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure(isprParser.ProcedureContext ctx);
	/**
	 * Visit a parse tree produced by {@link isprParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(isprParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link isprParser#assignstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignstmt(isprParser.AssignstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link isprParser#callstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallstmt(isprParser.CallstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link isprParser#writestmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWritestmt(isprParser.WritestmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link isprParser#bangstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBangstmt(isprParser.BangstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link isprParser#beginstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeginstmt(isprParser.BeginstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link isprParser#ifstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstmt(isprParser.IfstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link isprParser#whilestmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestmt(isprParser.WhilestmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link isprParser#breakstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakstmt(isprParser.BreakstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link isprParser#continuestmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinuestmt(isprParser.ContinuestmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link isprParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(isprParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link isprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(isprParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link isprParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(isprParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link isprParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(isprParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link isprParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(isprParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link isprParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(isprParser.NumberContext ctx);
}