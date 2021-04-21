// Generated from /home/artur/Documents/Faculdade/Compiladores/Prática/G23_Projeto1/src/com/CPL/ProjetoLexer.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ProjetoLexerParser}.
 */
public interface ProjetoLexerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ProjetoLexerParser#declr}.
	 * @param ctx the parse tree
	 */
	void enterDeclr(ProjetoLexerParser.DeclrContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoLexerParser#declr}.
	 * @param ctx the parse tree
	 */
	void exitDeclr(ProjetoLexerParser.DeclrContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoLexerParser#atr}.
	 * @param ctx the parse tree
	 */
	void enterAtr(ProjetoLexerParser.AtrContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoLexerParser#atr}.
	 * @param ctx the parse tree
	 */
	void exitAtr(ProjetoLexerParser.AtrContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjetoLexerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ProjetoLexerParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjetoLexerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ProjetoLexerParser.ExprContext ctx);
}