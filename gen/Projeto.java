// Generated from /home/artur/Documents/Faculdade/Compiladores/Prática/G23_Projeto1/src/com/CPL/Projeto.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Projeto extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KEYWORD_INT=1, KEYWORD_BOOL=2, KEYWORD_FLOAT=3, KEYWORD_STRING=4, KEYWORD_VOID=5, 
		KEYWORD_SIZEOF=6, KEYWORD_NULL=7, KEYWORD_ALG=8, KEYWORD_TRUE=9, KEYWORD_FALSE=10, 
		KEYWORD_WHILE=11, KEYWORD_DO=12, KEYWORD_FINALLY=13, KEYWORD_LEAVE=14, 
		KEYWORD_RESTART=15, KEYWORD_RETURN=16, KEYWORD_IF=17, KEYWORD_THEN=18, 
		KEYWORD_ELSE=19, KEYWORD_WRITE=20, KEYWORD_WRITELN=21, ARGUMENT_N=22, 
		NEWLINE=23, CARRIAGE_RETURN=24, BLANK=25, TAB=26, EXPLICATIVE=27, OPERATIONAL=28, 
		COMMA=29, SEMI_COLON=30, IDENTIFIER=31, LPAREN=32, RPAREN=33, LBLOCK=34, 
		RBLOCK=35, LBRACKET=36, RBRACKET=37, PLUS=38, MINUS=39, MULTI=40, DIVIDE=41, 
		QUESTION=42, PERCENT=43, GREATER=44, LESSER=45, GREATEQ=46, LESSEQ=47, 
		EQUALS=48, NOTEQUALS=49, TILT=50, AND=51, OR=52, EQUAL=53, INSERT=54, 
		EXTRACT=55, AT=56, INTEGER=57, REAL=58, STRING=59, START_STRING=60;
	public static final int
		RULE_program = 0, RULE_ex1_2 = 1, RULE_seq_literal = 2, RULE_ex1_3 = 3, 
		RULE_par_sequence = 4, RULE_par = 5, RULE_ex2 = 6, RULE_expression = 7, 
		RULE_exp_plica = 8, RULE_expression2 = 9, RULE_exp2_plica = 10, RULE_expression3 = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "ex1_2", "seq_literal", "ex1_3", "par_sequence", "par", "ex2", 
			"expression", "exp_plica", "expression2", "exp2_plica", "expression3"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'bool'", "'float'", "'string'", "'void'", "'sizeof'", 
			"'null'", "'alg'", "'true'", "'false'", "'while'", "'do'", "'finally'", 
			"'leave'", "'restart'", "'return'", "'if'", "'then'", "'else'", "'write'", 
			"'writeln'", "'n'", "'\n'", "'\r'", "' '", "'\t'", null, null, "','", 
			"';'", null, "'('", "')'", "'{'", "'}'", "'['", "']'", "'+'", "'-'", 
			"'*'", "'/'", "'?'", "'%'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", 
			"'~'", "'&&'", "'||'", "'='", "'<<'", "'>>'", "'@'", null, null, null, 
			"'''"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KEYWORD_INT", "KEYWORD_BOOL", "KEYWORD_FLOAT", "KEYWORD_STRING", 
			"KEYWORD_VOID", "KEYWORD_SIZEOF", "KEYWORD_NULL", "KEYWORD_ALG", "KEYWORD_TRUE", 
			"KEYWORD_FALSE", "KEYWORD_WHILE", "KEYWORD_DO", "KEYWORD_FINALLY", "KEYWORD_LEAVE", 
			"KEYWORD_RESTART", "KEYWORD_RETURN", "KEYWORD_IF", "KEYWORD_THEN", "KEYWORD_ELSE", 
			"KEYWORD_WRITE", "KEYWORD_WRITELN", "ARGUMENT_N", "NEWLINE", "CARRIAGE_RETURN", 
			"BLANK", "TAB", "EXPLICATIVE", "OPERATIONAL", "COMMA", "SEMI_COLON", 
			"IDENTIFIER", "LPAREN", "RPAREN", "LBLOCK", "RBLOCK", "LBRACKET", "RBRACKET", 
			"PLUS", "MINUS", "MULTI", "DIVIDE", "QUESTION", "PERCENT", "GREATER", 
			"LESSER", "GREATEQ", "LESSEQ", "EQUALS", "NOTEQUALS", "TILT", "AND", 
			"OR", "EQUAL", "INSERT", "EXTRACT", "AT", "INTEGER", "REAL", "STRING", 
			"START_STRING"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Projeto.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Projeto(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public Ex1_3Context ex1_3() {
			return getRuleContext(Ex1_3Context.class,0);
		}
		public TerminalNode EOF() { return getToken(Projeto.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjetoVisitor ) return ((ProjetoVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			ex1_3();
			setState(25);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ex1_2Context extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(Projeto.LBRACKET, 0); }
		public Seq_literalContext seq_literal() {
			return getRuleContext(Seq_literalContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(Projeto.RBRACKET, 0); }
		public Ex1_2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ex1_2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).enterEx1_2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).exitEx1_2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjetoVisitor ) return ((ProjetoVisitor<? extends T>)visitor).visitEx1_2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ex1_2Context ex1_2() throws RecognitionException {
		Ex1_2Context _localctx = new Ex1_2Context(_ctx, getState());
		enterRule(_localctx, 2, RULE_ex1_2);
		try {
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACKET:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(27);
				match(LBRACKET);
				setState(28);
				seq_literal();
				setState(29);
				match(RBRACKET);
				}
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(31);
				seq_literal();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Seq_literalContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(Projeto.INTEGER, 0); }
		public Seq_literalContext seq_literal() {
			return getRuleContext(Seq_literalContext.class,0);
		}
		public Seq_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seq_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).enterSeq_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).exitSeq_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjetoVisitor ) return ((ProjetoVisitor<? extends T>)visitor).visitSeq_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Seq_literalContext seq_literal() throws RecognitionException {
		Seq_literalContext _localctx = new Seq_literalContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_seq_literal);
		try {
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				match(INTEGER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				match(INTEGER);
				setState(36);
				seq_literal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ex1_3Context extends ParserRuleContext {
		public Par_sequenceContext par_sequence() {
			return getRuleContext(Par_sequenceContext.class,0);
		}
		public Ex1_3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ex1_3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).enterEx1_3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).exitEx1_3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjetoVisitor ) return ((ProjetoVisitor<? extends T>)visitor).visitEx1_3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ex1_3Context ex1_3() throws RecognitionException {
		Ex1_3Context _localctx = new Ex1_3Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_ex1_3);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			par_sequence();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Par_sequenceContext extends ParserRuleContext {
		public ParContext par() {
			return getRuleContext(ParContext.class,0);
		}
		public Par_sequenceContext par_sequence() {
			return getRuleContext(Par_sequenceContext.class,0);
		}
		public Par_sequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_par_sequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).enterPar_sequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).exitPar_sequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjetoVisitor ) return ((ProjetoVisitor<? extends T>)visitor).visitPar_sequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Par_sequenceContext par_sequence() throws RecognitionException {
		Par_sequenceContext _localctx = new Par_sequenceContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_par_sequence);
		try {
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				par();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				par();
				setState(43);
				par_sequence();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParContext extends ParserRuleContext {
		public List<TerminalNode> INTEGER() { return getTokens(Projeto.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(Projeto.INTEGER, i);
		}
		public TerminalNode COMMA() { return getToken(Projeto.COMMA, 0); }
		public TerminalNode SEMI_COLON() { return getToken(Projeto.SEMI_COLON, 0); }
		public TerminalNode QUESTION() { return getToken(Projeto.QUESTION, 0); }
		public ParContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_par; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).enterPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).exitPar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjetoVisitor ) return ((ProjetoVisitor<? extends T>)visitor).visitPar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParContext par() throws RecognitionException {
		ParContext _localctx = new ParContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_par);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(INTEGER);
			setState(49);
			match(COMMA);
			setState(50);
			match(INTEGER);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(51);
				match(QUESTION);
				}
			}

			setState(54);
			match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ex2Context extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Ex2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ex2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).enterEx2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).exitEx2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjetoVisitor ) return ((ProjetoVisitor<? extends T>)visitor).visitEx2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ex2Context ex2() throws RecognitionException {
		Ex2Context _localctx = new Ex2Context(_ctx, getState());
		enterRule(_localctx, 12, RULE_ex2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression2Context expression2() {
			return getRuleContext(Expression2Context.class,0);
		}
		public Exp_plicaContext exp_plica() {
			return getRuleContext(Exp_plicaContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjetoVisitor ) return ((ProjetoVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			expression2();
			setState(59);
			exp_plica();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exp_plicaContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(Projeto.PLUS, 0); }
		public Expression2Context expression2() {
			return getRuleContext(Expression2Context.class,0);
		}
		public Exp_plicaContext exp_plica() {
			return getRuleContext(Exp_plicaContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(Projeto.MINUS, 0); }
		public Exp_plicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_plica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).enterExp_plica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).exitExp_plica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjetoVisitor ) return ((ProjetoVisitor<? extends T>)visitor).visitExp_plica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_plicaContext exp_plica() throws RecognitionException {
		Exp_plicaContext _localctx = new Exp_plicaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_exp_plica);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(PLUS);
				setState(62);
				expression2();
				setState(63);
				exp_plica();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				match(MINUS);
				setState(66);
				expression2();
				setState(67);
				exp_plica();
				}
				break;
			case EOF:
			case RPAREN:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expression2Context extends ParserRuleContext {
		public Expression3Context expression3() {
			return getRuleContext(Expression3Context.class,0);
		}
		public Exp2_plicaContext exp2_plica() {
			return getRuleContext(Exp2_plicaContext.class,0);
		}
		public Expression2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).enterExpression2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).exitExpression2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjetoVisitor ) return ((ProjetoVisitor<? extends T>)visitor).visitExpression2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression2Context expression2() throws RecognitionException {
		Expression2Context _localctx = new Expression2Context(_ctx, getState());
		enterRule(_localctx, 18, RULE_expression2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			expression3();
			setState(73);
			exp2_plica();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exp2_plicaContext extends ParserRuleContext {
		public TerminalNode MULTI() { return getToken(Projeto.MULTI, 0); }
		public Expression3Context expression3() {
			return getRuleContext(Expression3Context.class,0);
		}
		public Exp2_plicaContext exp2_plica() {
			return getRuleContext(Exp2_plicaContext.class,0);
		}
		public TerminalNode DIVIDE() { return getToken(Projeto.DIVIDE, 0); }
		public Exp2_plicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp2_plica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).enterExp2_plica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).exitExp2_plica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjetoVisitor ) return ((ProjetoVisitor<? extends T>)visitor).visitExp2_plica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp2_plicaContext exp2_plica() throws RecognitionException {
		Exp2_plicaContext _localctx = new Exp2_plicaContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_exp2_plica);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MULTI:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				match(MULTI);
				setState(76);
				expression3();
				setState(77);
				exp2_plica();
				}
				break;
			case DIVIDE:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				match(DIVIDE);
				setState(80);
				expression3();
				setState(81);
				exp2_plica();
				}
				break;
			case EOF:
			case RPAREN:
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expression3Context extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Projeto.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Projeto.RPAREN, 0); }
		public TerminalNode INTEGER() { return getToken(Projeto.INTEGER, 0); }
		public Expression3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).enterExpression3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjetoListener ) ((ProjetoListener)listener).exitExpression3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjetoVisitor ) return ((ProjetoVisitor<? extends T>)visitor).visitExpression3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression3Context expression3() throws RecognitionException {
		Expression3Context _localctx = new Expression3Context(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression3);
		try {
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				match(LPAREN);
				setState(87);
				expression();
				setState(88);
				match(RPAREN);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				match(INTEGER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3>`\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f"+
		"\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3#\n\3\3\4\3\4\3\4\5\4"+
		"(\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6\61\n\6\3\7\3\7\3\7\3\7\5\7\67\n"+
		"\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n"+
		"I\n\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\fW\n\f\3\r"+
		"\3\r\3\r\3\r\3\r\5\r^\n\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\2"+
		"\2]\2\32\3\2\2\2\4\"\3\2\2\2\6\'\3\2\2\2\b)\3\2\2\2\n\60\3\2\2\2\f\62"+
		"\3\2\2\2\16:\3\2\2\2\20<\3\2\2\2\22H\3\2\2\2\24J\3\2\2\2\26V\3\2\2\2\30"+
		"]\3\2\2\2\32\33\5\b\5\2\33\34\7\2\2\3\34\3\3\2\2\2\35\36\7&\2\2\36\37"+
		"\5\6\4\2\37 \7\'\2\2 #\3\2\2\2!#\5\6\4\2\"\35\3\2\2\2\"!\3\2\2\2#\5\3"+
		"\2\2\2$(\7;\2\2%&\7;\2\2&(\5\6\4\2\'$\3\2\2\2\'%\3\2\2\2(\7\3\2\2\2)*"+
		"\5\n\6\2*\t\3\2\2\2+\61\5\f\7\2,-\5\f\7\2-.\5\n\6\2.\61\3\2\2\2/\61\3"+
		"\2\2\2\60+\3\2\2\2\60,\3\2\2\2\60/\3\2\2\2\61\13\3\2\2\2\62\63\7;\2\2"+
		"\63\64\7\37\2\2\64\66\7;\2\2\65\67\7,\2\2\66\65\3\2\2\2\66\67\3\2\2\2"+
		"\678\3\2\2\289\7 \2\29\r\3\2\2\2:;\5\20\t\2;\17\3\2\2\2<=\5\24\13\2=>"+
		"\5\22\n\2>\21\3\2\2\2?@\7(\2\2@A\5\24\13\2AB\5\22\n\2BI\3\2\2\2CD\7)\2"+
		"\2DE\5\24\13\2EF\5\22\n\2FI\3\2\2\2GI\3\2\2\2H?\3\2\2\2HC\3\2\2\2HG\3"+
		"\2\2\2I\23\3\2\2\2JK\5\30\r\2KL\5\26\f\2L\25\3\2\2\2MN\7*\2\2NO\5\30\r"+
		"\2OP\5\26\f\2PW\3\2\2\2QR\7+\2\2RS\5\30\r\2ST\5\26\f\2TW\3\2\2\2UW\3\2"+
		"\2\2VM\3\2\2\2VQ\3\2\2\2VU\3\2\2\2W\27\3\2\2\2XY\7\"\2\2YZ\5\20\t\2Z["+
		"\7#\2\2[^\3\2\2\2\\^\7;\2\2]X\3\2\2\2]\\\3\2\2\2^\31\3\2\2\2\t\"\'\60"+
		"\66HV]";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}