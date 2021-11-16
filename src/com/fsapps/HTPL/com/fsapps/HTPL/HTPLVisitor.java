// Generated from D:/BUILDS/htpl/src/com/fsapps/HTPL\HTPL.g4 by ANTLR 4.9.2
package com.fsapps.HTPL;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HTPLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HTPLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HTPLParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(HTPLParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTPLParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(HTPLParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTPLParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(HTPLParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTPLParser#functionParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParam(HTPLParser.FunctionParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTPLParser#idList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdList(HTPLParser.IdListContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTPLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(HTPLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTPLParser#repeatStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatStatement(HTPLParser.RepeatStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTPLParser#repeatWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatWhile(HTPLParser.RepeatWhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTPLParser#repeatWithVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatWithVar(HTPLParser.RepeatWithVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTPLParser#repeatFrom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatFrom(HTPLParser.RepeatFromContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTPLParser#repeatTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatTo(HTPLParser.RepeatToContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTPLParser#repeatStep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatStep(HTPLParser.RepeatStepContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTPLParser#repeatFixed}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatFixed(HTPLParser.RepeatFixedContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTPLParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(HTPLParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTPLParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(HTPLParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTPLParser#ifStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(HTPLParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTPLParser#elseIfStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfStat(HTPLParser.ElseIfStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTPLParser#elseStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStat(HTPLParser.ElseStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link HTPLParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierFunctionCall(HTPLParser.IdentifierFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printFunctionCall}
	 * labeled alternative in {@link HTPLParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintFunctionCall(HTPLParser.PrintFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assertFunctionCall}
	 * labeled alternative in {@link HTPLParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertFunctionCall(HTPLParser.AssertFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sizeFunctionCall}
	 * labeled alternative in {@link HTPLParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizeFunctionCall(HTPLParser.SizeFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code takeInputFunctionCall}
	 * labeled alternative in {@link HTPLParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTakeInputFunctionCall(HTPLParser.TakeInputFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link HTPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpression(HTPLParser.BoolExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link HTPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpression(HTPLParser.NumberExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link HTPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpression(HTPLParser.IdentifierExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link HTPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(HTPLParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link HTPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(HTPLParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryMinusExpression}
	 * labeled alternative in {@link HTPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinusExpression(HTPLParser.UnaryMinusExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powerExpression}
	 * labeled alternative in {@link HTPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowerExpression(HTPLParser.PowerExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link HTPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpression(HTPLParser.EqExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link HTPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(HTPLParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link HTPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpression(HTPLParser.InExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link HTPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpression(HTPLParser.StringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link HTPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionExpression(HTPLParser.ExpressionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link HTPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpression(HTPLParser.AddExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compExpression}
	 * labeled alternative in {@link HTPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpression(HTPLParser.CompExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link HTPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullExpression(HTPLParser.NullExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link HTPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpression(HTPLParser.FunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multExpression}
	 * labeled alternative in {@link HTPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpression(HTPLParser.MultExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link HTPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpression(HTPLParser.ListExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link HTPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpression(HTPLParser.TernaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTPLParser#indexes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexes(HTPLParser.IndexesContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTPLParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(HTPLParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTPLParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(HTPLParser.ExprListContext ctx);
}