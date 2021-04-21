// Generated from /home/artur/Documents/Faculdade/Compiladores/Prática/G23_Projeto1/src/com/CPL/ProjetoLexer.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ProjetoLexerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ProjetoLexerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ProjetoLexerParser#declr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclr(ProjetoLexerParser.DeclrContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjetoLexerParser#atr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtr(ProjetoLexerParser.AtrContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjetoLexerParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ProjetoLexerParser.ExprContext ctx);
}