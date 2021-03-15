// Generated from C:/Users/a64592/IdeaProjects/Projeto1/src/com/CPL\Projeto.g4 by ANTLR 4.9.1
package Projeto;
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
	 * Visit a parse tree produced by {@link Projeto#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(Projeto.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link Projeto#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(Projeto.ExpressionContext ctx);
}