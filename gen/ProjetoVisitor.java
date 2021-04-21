// Generated from /home/artur/Documents/Faculdade/Compiladores/Prática/G23_Projeto1/src/com/CPL/Projeto.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Projeto}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ProjetoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Projeto#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(Projeto.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link Projeto#ex1_2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx1_2(Projeto.Ex1_2Context ctx);
	/**
	 * Visit a parse tree produced by {@link Projeto#seq_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeq_literal(Projeto.Seq_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link Projeto#ex1_3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx1_3(Projeto.Ex1_3Context ctx);
	/**
	 * Visit a parse tree produced by {@link Projeto#par_sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPar_sequence(Projeto.Par_sequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link Projeto#par}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPar(Projeto.ParContext ctx);
	/**
	 * Visit a parse tree produced by {@link Projeto#ex2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx2(Projeto.Ex2Context ctx);
	/**
	 * Visit a parse tree produced by {@link Projeto#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(Projeto.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Projeto#exp_plica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_plica(Projeto.Exp_plicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link Projeto#expression2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression2(Projeto.Expression2Context ctx);
	/**
	 * Visit a parse tree produced by {@link Projeto#exp2_plica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp2_plica(Projeto.Exp2_plicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link Projeto#expression3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression3(Projeto.Expression3Context ctx);
}