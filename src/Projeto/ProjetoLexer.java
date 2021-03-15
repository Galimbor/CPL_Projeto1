// Generated from C:\Users\a64592\IdeaProjects\Projeto1\src\com\CPL\ProjetoLexer.g4 by ANTLR 4.9.1
package Projeto;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ProjetoLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LITERAL_INT=1, LITERAL_REAL=2, IDENT=3, COMMENTS=4, WHITE_SPACE=5, DESTROY=6, 
		SAIR_RAIVA=7, INICIA_RAIVA=8;
	public static final int
		RAIVA_MODE=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "RAIVA_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LITERAL_INT", "LITERAL_REAL", "MIN_LETTER", "IDENT", "COMMENTS", "INICIA_RAIVA", 
			"WHITE_SPACE", "DESTROY", "MAI_LETTER", "IDENT_RAIVA", "LITERAL_INT_RAIVA", 
			"SAIR_RAIVA"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "' '", "'destroy'", "'***'", "'!!!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LITERAL_INT", "LITERAL_REAL", "IDENT", "COMMENTS", "WHITE_SPACE", 
			"DESTROY", "SAIR_RAIVA", "INICIA_RAIVA"
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


	public ProjetoLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ProjetoLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\nd\b\1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\6\2\36\n\2\r\2\16\2\37\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\5\6\5)\n\5\r\5\16\5*\3\6\3\6\3\6\3\6\7\6\61\n\6\f\6\16\6\64\13\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\6\13Q\n\13\r\13\16\13R\3\13\3"+
		"\13\3\f\6\fX\n\f\r\f\16\fY\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\2\2\16"+
		"\4\3\6\4\b\2\n\5\f\6\16\n\20\7\22\b\24\2\26\2\30\2\32\t\4\2\3\4\3\2c|"+
		"\3\2C\\\2e\2\4\3\2\2\2\2\6\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2"+
		"\2\2\20\3\2\2\2\3\22\3\2\2\2\3\26\3\2\2\2\3\30\3\2\2\2\3\32\3\2\2\2\4"+
		"\35\3\2\2\2\6!\3\2\2\2\b%\3\2\2\2\n(\3\2\2\2\f,\3\2\2\2\16:\3\2\2\2\20"+
		"A\3\2\2\2\22E\3\2\2\2\24M\3\2\2\2\26P\3\2\2\2\30W\3\2\2\2\32]\3\2\2\2"+
		"\34\36\4\62;\2\35\34\3\2\2\2\36\37\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 "+
		"\5\3\2\2\2!\"\5\4\2\2\"#\7\60\2\2#$\5\4\2\2$\7\3\2\2\2%&\t\2\2\2&\t\3"+
		"\2\2\2\')\5\b\4\2(\'\3\2\2\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\13\3\2\2\2"+
		",-\7\61\2\2-.\7,\2\2.\62\3\2\2\2/\61\13\2\2\2\60/\3\2\2\2\61\64\3\2\2"+
		"\2\62\60\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64\62\3\2\2\2\65\66\7,\2"+
		"\2\66\67\7\61\2\2\678\3\2\2\289\b\6\2\29\r\3\2\2\2:;\7#\2\2;<\7#\2\2<"+
		"=\7#\2\2=>\3\2\2\2>?\b\7\3\2?@\b\7\4\2@\17\3\2\2\2AB\7\"\2\2BC\3\2\2\2"+
		"CD\b\b\2\2D\21\3\2\2\2EF\7f\2\2FG\7g\2\2GH\7u\2\2HI\7v\2\2IJ\7t\2\2JK"+
		"\7q\2\2KL\7{\2\2L\23\3\2\2\2MN\t\3\2\2N\25\3\2\2\2OQ\5\24\n\2PO\3\2\2"+
		"\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\b\13\5\2U\27\3\2\2\2VX\4"+
		"\62;\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\\\b\f\6\2\\"+
		"\31\3\2\2\2]^\7,\2\2^_\7,\2\2_`\7,\2\2`a\3\2\2\2ab\b\r\2\2bc\b\r\7\2c"+
		"\33\3\2\2\2\t\2\3\37*\62RY\b\b\2\2\5\2\2\7\3\2\t\5\2\t\3\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}