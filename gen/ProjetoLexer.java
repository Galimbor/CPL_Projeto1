// Generated from /home/artur/Documents/Faculdade/Compiladores/Prática/G23_Projeto1/src/com/CPL/ProjetoLexer.g4 by ANTLR 4.9.1
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
		KEYWORD_INT=1, KEYWORD_BOOL=2, KEYWORD_FLOAT=3, KEYWORD_STRING=4, KEYWORD_VOID=5, 
		KEYWORD_SIZEOF=6, KEYWORD_NULL=7, KEYWORD_ALG=8, KEYWORD_TRUE=9, KEYWORD_FALSE=10, 
		KEYWORD_WHILE=11, KEYWORD_DO=12, KEYWORD_FINALLY=13, KEYWORD_LEAVE=14, 
		KEYWORD_RESTART=15, KEYWORD_RETURN=16, KEYWORD_IF=17, KEYWORD_THEN=18, 
		KEYWORD_ELSE=19, KEYWORD_WRITE=20, KEYWORD_WRITELN=21, NEWLINE=22, CARRIAGE_RETURN=23, 
		BLANK=24, TAB=25, EXPLICATIVE=26, OPERATIONAL=27, COMMA=28, SEMI_COLON=29, 
		IDENTIFIER=30, LPAREN=31, RPAREN=32, LBLOCK=33, RBLOCK=34, LBRACKET=35, 
		RBRACKET=36, ADD=37, SUB=38, MUL=39, DIV=40, QUESTION=41, PERCENT=42, 
		GREATER=43, LESSER=44, GREATEQ=45, LESSEQ=46, EQUALS=47, NOTEQUALS=48, 
		TILT=49, AND=50, OR=51, EQUAL=52, INSERT=53, EXTRACT=54, AT=55, INTEGER=56, 
		REAL=57, STRING=58, START_STRING=59;
	public static final int
		STRING_MODE=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "STRING_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"KEYWORD_INT", "KEYWORD_BOOL", "KEYWORD_FLOAT", "KEYWORD_STRING", "KEYWORD_VOID", 
			"KEYWORD_SIZEOF", "KEYWORD_NULL", "KEYWORD_ALG", "KEYWORD_TRUE", "KEYWORD_FALSE", 
			"KEYWORD_WHILE", "KEYWORD_DO", "KEYWORD_FINALLY", "KEYWORD_LEAVE", "KEYWORD_RESTART", 
			"KEYWORD_RETURN", "KEYWORD_IF", "KEYWORD_THEN", "KEYWORD_ELSE", "KEYWORD_WRITE", 
			"KEYWORD_WRITELN", "NEWLINE", "CARRIAGE_RETURN", "BLANK", "TAB", "DOUBLE_CARDINAL", 
			"LOPERATIONAL", "ROPERATIONAL", "EXPLICATIVE", "OPERATIONAL", "COMMA", 
			"SEMI_COLON", "LETTER", "UNDERSCORE", "IDENTIFIER", "LPAREN", "RPAREN", 
			"LBLOCK", "RBLOCK", "LBRACKET", "RBRACKET", "ADD", "SUB", "MUL", "DIV", 
			"QUESTION", "PERCENT", "GREATER", "LESSER", "GREATEQ", "LESSEQ", "EQUALS", 
			"NOTEQUALS", "TILT", "AND", "OR", "EQUAL", "INSERT", "EXTRACT", "AT", 
			"DIGIT", "INTEGER", "REAL", "START_STRING", "STRING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'bool'", "'float'", "'string'", "'void'", "'sizeof'", 
			"'null'", "'alg'", "'true'", "'false'", "'while'", "'do'", "'finally'", 
			"'leave'", "'restart'", "'return'", "'if'", "'then'", "'else'", "'write'", 
			"'writeln'", "'\n'", "'\r'", "' '", "'\t'", null, null, "','", "';'", 
			null, "'('", "')'", "'{'", "'}'", "'['", "']'", "'+'", "'-'", "'*'", 
			"'/'", "'?'", "'%'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'~'", 
			"'&&'", "'||'", "'='", "'<<'", "'>>'", "'@'", null, null, null, "'''"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KEYWORD_INT", "KEYWORD_BOOL", "KEYWORD_FLOAT", "KEYWORD_STRING", 
			"KEYWORD_VOID", "KEYWORD_SIZEOF", "KEYWORD_NULL", "KEYWORD_ALG", "KEYWORD_TRUE", 
			"KEYWORD_FALSE", "KEYWORD_WHILE", "KEYWORD_DO", "KEYWORD_FINALLY", "KEYWORD_LEAVE", 
			"KEYWORD_RESTART", "KEYWORD_RETURN", "KEYWORD_IF", "KEYWORD_THEN", "KEYWORD_ELSE", 
			"KEYWORD_WRITE", "KEYWORD_WRITELN", "NEWLINE", "CARRIAGE_RETURN", "BLANK", 
			"TAB", "EXPLICATIVE", "OPERATIONAL", "COMMA", "SEMI_COLON", "IDENTIFIER", 
			"LPAREN", "RPAREN", "LBLOCK", "RBLOCK", "LBRACKET", "RBRACKET", "ADD", 
			"SUB", "MUL", "DIV", "QUESTION", "PERCENT", "GREATER", "LESSER", "GREATEQ", 
			"LESSEQ", "EQUALS", "NOTEQUALS", "TILT", "AND", "OR", "EQUAL", "INSERT", 
			"EXTRACT", "AT", "INTEGER", "REAL", "STRING", "START_STRING"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2=\u019e\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\7\36\u0115\n\36"+
		"\f\36\16\36\u0118\13\36\3\36\3\36\3\37\3\37\7\37\u011e\n\37\f\37\16\37"+
		"\u0121\13\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3$\7$\u0131"+
		"\n$\f$\16$\u0134\13$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3"+
		",\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\63\3\64"+
		"\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\38\38\38\39\39\39\3"+
		":\3:\3;\3;\3;\3<\3<\3<\3=\3=\3>\3>\3?\3?\3?\7?\u0175\n?\f?\16?\u0178\13"+
		"?\5?\u017a\n?\3@\3@\3@\6@\u017f\n@\r@\16@\u0180\5@\u0183\n@\3@\3@\5@\u0187"+
		"\n@\3@\5@\u018a\n@\3A\3A\3A\3A\3A\3B\7B\u0192\nB\fB\16B\u0195\13B\3B\3"+
		"B\3B\3B\5B\u019b\nB\3B\3B\4\u0116\u011f\2C\4\3\6\4\b\5\n\6\f\7\16\b\20"+
		"\t\22\n\24\13\26\f\30\r\32\16\34\17\36\20 \21\"\22$\23&\24(\25*\26,\27"+
		".\30\60\31\62\32\64\33\66\28\2:\2<\34>\35@\36B\37D\2F\2H J!L\"N#P$R%T"+
		"&V\'X(Z)\\*^+`,b-d.f/h\60j\61l\62n\63p\64r\65t\66v\67x8z9|\2~:\u0080;"+
		"\u0082=\u0084<\4\2\3\b\5\2C\\c|\u0082\u0101\3\2\62;\3\2\63;\4\2--//\5"+
		"\2\2\2))\u0080\u0080\3\2\2\2\2\u01a3\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2"+
		"\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24"+
		"\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2"+
		"\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2"+
		"\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2<\3\2"+
		"\2\2\2>\3\2\2\2\2@\3\2\2\2\2B\3\2\2\2\2H\3\2\2\2\2J\3\2\2\2\2L\3\2\2\2"+
		"\2N\3\2\2\2\2P\3\2\2\2\2R\3\2\2\2\2T\3\2\2\2\2V\3\2\2\2\2X\3\2\2\2\2Z"+
		"\3\2\2\2\2\\\3\2\2\2\2^\3\2\2\2\2`\3\2\2\2\2b\3\2\2\2\2d\3\2\2\2\2f\3"+
		"\2\2\2\2h\3\2\2\2\2j\3\2\2\2\2l\3\2\2\2\2n\3\2\2\2\2p\3\2\2\2\2r\3\2\2"+
		"\2\2t\3\2\2\2\2v\3\2\2\2\2x\3\2\2\2\2z\3\2\2\2\2~\3\2\2\2\2\u0080\3\2"+
		"\2\2\2\u0082\3\2\2\2\3\u0084\3\2\2\2\4\u0086\3\2\2\2\6\u008a\3\2\2\2\b"+
		"\u008f\3\2\2\2\n\u0095\3\2\2\2\f\u009c\3\2\2\2\16\u00a1\3\2\2\2\20\u00a8"+
		"\3\2\2\2\22\u00ad\3\2\2\2\24\u00b1\3\2\2\2\26\u00b6\3\2\2\2\30\u00bc\3"+
		"\2\2\2\32\u00c2\3\2\2\2\34\u00c5\3\2\2\2\36\u00cd\3\2\2\2 \u00d3\3\2\2"+
		"\2\"\u00db\3\2\2\2$\u00e2\3\2\2\2&\u00e5\3\2\2\2(\u00ea\3\2\2\2*\u00ef"+
		"\3\2\2\2,\u00f5\3\2\2\2.\u00fd\3\2\2\2\60\u0101\3\2\2\2\62\u0103\3\2\2"+
		"\2\64\u0107\3\2\2\2\66\u0109\3\2\2\28\u010c\3\2\2\2:\u010f\3\2\2\2<\u0112"+
		"\3\2\2\2>\u011b\3\2\2\2@\u0124\3\2\2\2B\u0126\3\2\2\2D\u0128\3\2\2\2F"+
		"\u012a\3\2\2\2H\u012c\3\2\2\2J\u0135\3\2\2\2L\u0137\3\2\2\2N\u0139\3\2"+
		"\2\2P\u013b\3\2\2\2R\u013d\3\2\2\2T\u013f\3\2\2\2V\u0141\3\2\2\2X\u0143"+
		"\3\2\2\2Z\u0145\3\2\2\2\\\u0147\3\2\2\2^\u0149\3\2\2\2`\u014b\3\2\2\2"+
		"b\u014d\3\2\2\2d\u014f\3\2\2\2f\u0151\3\2\2\2h\u0154\3\2\2\2j\u0157\3"+
		"\2\2\2l\u015a\3\2\2\2n\u015d\3\2\2\2p\u015f\3\2\2\2r\u0162\3\2\2\2t\u0165"+
		"\3\2\2\2v\u0167\3\2\2\2x\u016a\3\2\2\2z\u016d\3\2\2\2|\u016f\3\2\2\2~"+
		"\u0179\3\2\2\2\u0080\u017b\3\2\2\2\u0082\u018b\3\2\2\2\u0084\u0193\3\2"+
		"\2\2\u0086\u0087\7k\2\2\u0087\u0088\7p\2\2\u0088\u0089\7v\2\2\u0089\5"+
		"\3\2\2\2\u008a\u008b\7d\2\2\u008b\u008c\7q\2\2\u008c\u008d\7q\2\2\u008d"+
		"\u008e\7n\2\2\u008e\7\3\2\2\2\u008f\u0090\7h\2\2\u0090\u0091\7n\2\2\u0091"+
		"\u0092\7q\2\2\u0092\u0093\7c\2\2\u0093\u0094\7v\2\2\u0094\t\3\2\2\2\u0095"+
		"\u0096\7u\2\2\u0096\u0097\7v\2\2\u0097\u0098\7t\2\2\u0098\u0099\7k\2\2"+
		"\u0099\u009a\7p\2\2\u009a\u009b\7i\2\2\u009b\13\3\2\2\2\u009c\u009d\7"+
		"x\2\2\u009d\u009e\7q\2\2\u009e\u009f\7k\2\2\u009f\u00a0\7f\2\2\u00a0\r"+
		"\3\2\2\2\u00a1\u00a2\7u\2\2\u00a2\u00a3\7k\2\2\u00a3\u00a4\7|\2\2\u00a4"+
		"\u00a5\7g\2\2\u00a5\u00a6\7q\2\2\u00a6\u00a7\7h\2\2\u00a7\17\3\2\2\2\u00a8"+
		"\u00a9\7p\2\2\u00a9\u00aa\7w\2\2\u00aa\u00ab\7n\2\2\u00ab\u00ac\7n\2\2"+
		"\u00ac\21\3\2\2\2\u00ad\u00ae\7c\2\2\u00ae\u00af\7n\2\2\u00af\u00b0\7"+
		"i\2\2\u00b0\23\3\2\2\2\u00b1\u00b2\7v\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4"+
		"\7w\2\2\u00b4\u00b5\7g\2\2\u00b5\25\3\2\2\2\u00b6\u00b7\7h\2\2\u00b7\u00b8"+
		"\7c\2\2\u00b8\u00b9\7n\2\2\u00b9\u00ba\7u\2\2\u00ba\u00bb\7g\2\2\u00bb"+
		"\27\3\2\2\2\u00bc\u00bd\7y\2\2\u00bd\u00be\7j\2\2\u00be\u00bf\7k\2\2\u00bf"+
		"\u00c0\7n\2\2\u00c0\u00c1\7g\2\2\u00c1\31\3\2\2\2\u00c2\u00c3\7f\2\2\u00c3"+
		"\u00c4\7q\2\2\u00c4\33\3\2\2\2\u00c5\u00c6\7h\2\2\u00c6\u00c7\7k\2\2\u00c7"+
		"\u00c8\7p\2\2\u00c8\u00c9\7c\2\2\u00c9\u00ca\7n\2\2\u00ca\u00cb\7n\2\2"+
		"\u00cb\u00cc\7{\2\2\u00cc\35\3\2\2\2\u00cd\u00ce\7n\2\2\u00ce\u00cf\7"+
		"g\2\2\u00cf\u00d0\7c\2\2\u00d0\u00d1\7x\2\2\u00d1\u00d2\7g\2\2\u00d2\37"+
		"\3\2\2\2\u00d3\u00d4\7t\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6\7u\2\2\u00d6"+
		"\u00d7\7v\2\2\u00d7\u00d8\7c\2\2\u00d8\u00d9\7t\2\2\u00d9\u00da\7v\2\2"+
		"\u00da!\3\2\2\2\u00db\u00dc\7t\2\2\u00dc\u00dd\7g\2\2\u00dd\u00de\7v\2"+
		"\2\u00de\u00df\7w\2\2\u00df\u00e0\7t\2\2\u00e0\u00e1\7p\2\2\u00e1#\3\2"+
		"\2\2\u00e2\u00e3\7k\2\2\u00e3\u00e4\7h\2\2\u00e4%\3\2\2\2\u00e5\u00e6"+
		"\7v\2\2\u00e6\u00e7\7j\2\2\u00e7\u00e8\7g\2\2\u00e8\u00e9\7p\2\2\u00e9"+
		"\'\3\2\2\2\u00ea\u00eb\7g\2\2\u00eb\u00ec\7n\2\2\u00ec\u00ed\7u\2\2\u00ed"+
		"\u00ee\7g\2\2\u00ee)\3\2\2\2\u00ef\u00f0\7y\2\2\u00f0\u00f1\7t\2\2\u00f1"+
		"\u00f2\7k\2\2\u00f2\u00f3\7v\2\2\u00f3\u00f4\7g\2\2\u00f4+\3\2\2\2\u00f5"+
		"\u00f6\7y\2\2\u00f6\u00f7\7t\2\2\u00f7\u00f8\7k\2\2\u00f8\u00f9\7v\2\2"+
		"\u00f9\u00fa\7g\2\2\u00fa\u00fb\7n\2\2\u00fb\u00fc\7p\2\2\u00fc-\3\2\2"+
		"\2\u00fd\u00fe\7\f\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\b\27\2\2\u0100"+
		"/\3\2\2\2\u0101\u0102\7\17\2\2\u0102\61\3\2\2\2\u0103\u0104\7\"\2\2\u0104"+
		"\u0105\3\2\2\2\u0105\u0106\b\31\2\2\u0106\63\3\2\2\2\u0107\u0108\7\13"+
		"\2\2\u0108\65\3\2\2\2\u0109\u010a\7%\2\2\u010a\u010b\7%\2\2\u010b\67\3"+
		"\2\2\2\u010c\u010d\7*\2\2\u010d\u010e\7,\2\2\u010e9\3\2\2\2\u010f\u0110"+
		"\7,\2\2\u0110\u0111\7+\2\2\u0111;\3\2\2\2\u0112\u0116\5\66\33\2\u0113"+
		"\u0115\13\2\2\2\u0114\u0113\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0117\3"+
		"\2\2\2\u0116\u0114\3\2\2\2\u0117\u0119\3\2\2\2\u0118\u0116\3\2\2\2\u0119"+
		"\u011a\5.\27\2\u011a=\3\2\2\2\u011b\u011f\58\34\2\u011c\u011e\13\2\2\2"+
		"\u011d\u011c\3\2\2\2\u011e\u0121\3\2\2\2\u011f\u0120\3\2\2\2\u011f\u011d"+
		"\3\2\2\2\u0120\u0122\3\2\2\2\u0121\u011f\3\2\2\2\u0122\u0123\5:\35\2\u0123"+
		"?\3\2\2\2\u0124\u0125\7.\2\2\u0125A\3\2\2\2\u0126\u0127\7=\2\2\u0127C"+
		"\3\2\2\2\u0128\u0129\t\2\2\2\u0129E\3\2\2\2\u012a\u012b\7a\2\2\u012bG"+
		"\3\2\2\2\u012c\u0132\5D\"\2\u012d\u0131\5D\"\2\u012e\u0131\5|>\2\u012f"+
		"\u0131\5F#\2\u0130\u012d\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u012f\3\2\2"+
		"\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133I"+
		"\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0136\7*\2\2\u0136K\3\2\2\2\u0137\u0138"+
		"\7+\2\2\u0138M\3\2\2\2\u0139\u013a\7}\2\2\u013aO\3\2\2\2\u013b\u013c\7"+
		"\177\2\2\u013cQ\3\2\2\2\u013d\u013e\7]\2\2\u013eS\3\2\2\2\u013f\u0140"+
		"\7_\2\2\u0140U\3\2\2\2\u0141\u0142\7-\2\2\u0142W\3\2\2\2\u0143\u0144\7"+
		"/\2\2\u0144Y\3\2\2\2\u0145\u0146\7,\2\2\u0146[\3\2\2\2\u0147\u0148\7\61"+
		"\2\2\u0148]\3\2\2\2\u0149\u014a\7A\2\2\u014a_\3\2\2\2\u014b\u014c\7\'"+
		"\2\2\u014ca\3\2\2\2\u014d\u014e\7@\2\2\u014ec\3\2\2\2\u014f\u0150\7>\2"+
		"\2\u0150e\3\2\2\2\u0151\u0152\7@\2\2\u0152\u0153\7?\2\2\u0153g\3\2\2\2"+
		"\u0154\u0155\7>\2\2\u0155\u0156\7?\2\2\u0156i\3\2\2\2\u0157\u0158\7?\2"+
		"\2\u0158\u0159\7?\2\2\u0159k\3\2\2\2\u015a\u015b\7#\2\2\u015b\u015c\7"+
		"?\2\2\u015cm\3\2\2\2\u015d\u015e\7\u0080\2\2\u015eo\3\2\2\2\u015f\u0160"+
		"\7(\2\2\u0160\u0161\7(\2\2\u0161q\3\2\2\2\u0162\u0163\7~\2\2\u0163\u0164"+
		"\7~\2\2\u0164s\3\2\2\2\u0165\u0166\7?\2\2\u0166u\3\2\2\2\u0167\u0168\7"+
		">\2\2\u0168\u0169\7>\2\2\u0169w\3\2\2\2\u016a\u016b\7@\2\2\u016b\u016c"+
		"\7@\2\2\u016cy\3\2\2\2\u016d\u016e\7B\2\2\u016e{\3\2\2\2\u016f\u0170\t"+
		"\3\2\2\u0170}\3\2\2\2\u0171\u017a\7\62\2\2\u0172\u0176\t\4\2\2\u0173\u0175"+
		"\5|>\2\u0174\u0173\3\2\2\2\u0175\u0178\3\2\2\2\u0176\u0174\3\2\2\2\u0176"+
		"\u0177\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u0176\3\2\2\2\u0179\u0171\3\2"+
		"\2\2\u0179\u0172\3\2\2\2\u017a\177\3\2\2\2\u017b\u0182\5~?\2\u017c\u017e"+
		"\7\60\2\2\u017d\u017f\5|>\2\u017e\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180"+
		"\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0183\3\2\2\2\u0182\u017c\3\2"+
		"\2\2\u0182\u0183\3\2\2\2\u0183\u0189\3\2\2\2\u0184\u0186\7G\2\2\u0185"+
		"\u0187\t\5\2\2\u0186\u0185\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0188\3\2"+
		"\2\2\u0188\u018a\5~?\2\u0189\u0184\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u0081"+
		"\3\2\2\2\u018b\u018c\7)\2\2\u018c\u018d\3\2\2\2\u018d\u018e\bA\3\2\u018e"+
		"\u018f\bA\4\2\u018f\u0083\3\2\2\2\u0190\u0192\n\6\2\2\u0191\u0190\3\2"+
		"\2\2\u0192\u0195\3\2\2\2\u0193\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194"+
		"\u019a\3\2\2\2\u0195\u0193\3\2\2\2\u0196\u0197\7\u0080\2\2\u0197\u0198"+
		"\n\7\2\2\u0198\u019b\5\u0084B\2\u0199\u019b\7)\2\2\u019a\u0196\3\2\2\2"+
		"\u019a\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019d\bB\5\2\u019d\u0085"+
		"\3\2\2\2\20\2\3\u0116\u011f\u0130\u0132\u0176\u0179\u0180\u0182\u0186"+
		"\u0189\u0193\u019a\6\b\2\2\5\2\2\7\3\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}