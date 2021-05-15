// Generated from /Users/bidinho/Library/Mobile Documents/com~apple~CloudDocs/Work/UAlg/3_ano/6_sem/COMP/Projeto/CPL_Projeto1/ProjetoLexer.g4 by ANTLR 4.9.1
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
		INT=1, BOOL=2, FLOAT=3, STRING=4, VOID=5, SIZEOF=6, NULL=7, ALG=8, TRUE=9, 
		FALSE=10, WHILE=11, DO=12, FINALLY=13, LEAVE=14, RESTART=15, RETURN=16, 
		IF=17, THEN=18, ELSE=19, WRITE=20, WRITELN=21, POINTER=22, NEWLINE=23, 
		CARRIAGE_RETURN=24, BLANK=25, TAB=26, EXPLICATIVE=27, OPERATIONAL=28, 
		COMMA=29, SEMI_COLON=30, IDENTIFIER=31, LPAREN=32, RPAREN=33, LBLOCK=34, 
		RBLOCK=35, LBRACKET=36, RBRACKET=37, ADD=38, SUB=39, MUL=40, DIV=41, QUESTION=42, 
		PERCENT=43, GREATER=44, LESSER=45, GREATEQ=46, LESSEQ=47, EQUALS=48, NOTEQUALS=49, 
		TILT=50, AND=51, OR=52, EQUAL=53, INSERT=54, EXTRACT=55, AT=56, INTEGER=57, 
		REAL=58, STRING_=59, START_STRING=60;
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
			"INT", "BOOL", "FLOAT", "STRING", "VOID", "SIZEOF", "NULL", "ALG", "TRUE", 
			"FALSE", "WHILE", "DO", "FINALLY", "LEAVE", "RESTART", "RETURN", "IF", 
			"THEN", "ELSE", "WRITE", "WRITELN", "POINTER", "NEWLINE", "CARRIAGE_RETURN", 
			"BLANK", "TAB", "DOUBLE_CARDINAL", "LOPERATIONAL", "ROPERATIONAL", "EXPLICATIVE", 
			"OPERATIONAL", "COMMA", "SEMI_COLON", "LETTER", "UNDERSCORE", "IDENTIFIER", 
			"LPAREN", "RPAREN", "LBLOCK", "RBLOCK", "LBRACKET", "RBRACKET", "ADD", 
			"SUB", "MUL", "DIV", "QUESTION", "PERCENT", "GREATER", "LESSER", "GREATEQ", 
			"LESSEQ", "EQUALS", "NOTEQUALS", "TILT", "AND", "OR", "EQUAL", "INSERT", 
			"EXTRACT", "AT", "DIGIT", "INTEGER", "REAL", "START_STRING", "STRING_"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'bool'", "'float'", "'string'", "'void'", "'sizeof'", 
			"'null'", "'alg'", "'true'", "'false'", "'while'", "'do'", "'finally'", 
			"'leave'", "'restart'", "'return'", "'if'", "'then'", "'else'", "'write'", 
			"'writeln'", null, "'\n'", "'\r'", "' '", "'\t'", null, null, "','", 
			"';'", null, "'('", "')'", "'{'", "'}'", "'['", "']'", "'+'", "'-'", 
			"'*'", "'/'", "'?'", "'%'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", 
			"'~'", "'&&'", "'||'", "'='", "'<<'", "'>>'", "'@'", null, null, null, 
			"'''"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "BOOL", "FLOAT", "STRING", "VOID", "SIZEOF", "NULL", "ALG", 
			"TRUE", "FALSE", "WHILE", "DO", "FINALLY", "LEAVE", "RESTART", "RETURN", 
			"IF", "THEN", "ELSE", "WRITE", "WRITELN", "POINTER", "NEWLINE", "CARRIAGE_RETURN", 
			"BLANK", "TAB", "EXPLICATIVE", "OPERATIONAL", "COMMA", "SEMI_COLON", 
			"IDENTIFIER", "LPAREN", "RPAREN", "LBLOCK", "RBLOCK", "LBRACKET", "RBRACKET", 
			"ADD", "SUB", "MUL", "DIV", "QUESTION", "PERCENT", "GREATER", "LESSER", 
			"GREATEQ", "LESSEQ", "EQUALS", "NOTEQUALS", "TILT", "AND", "OR", "EQUAL", 
			"INSERT", "EXTRACT", "AT", "INTEGER", "REAL", "STRING_", "START_STRING"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2>\u01a9\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\5\27\u0105\n\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\7\37\u0120\n\37\f\37\16\37\u0123"+
		"\13\37\3\37\3\37\3 \3 \7 \u0129\n \f \16 \u012c\13 \3 \3 \3!\3!\3\"\3"+
		"\"\3#\3#\3$\3$\3%\3%\3%\3%\7%\u013c\n%\f%\16%\u013f\13%\3&\3&\3\'\3\'"+
		"\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3"+
		"\62\3\62\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3"+
		"\67\3\67\38\38\39\39\39\3:\3:\3:\3;\3;\3<\3<\3<\3=\3=\3=\3>\3>\3?\3?\3"+
		"@\3@\3@\7@\u0180\n@\f@\16@\u0183\13@\5@\u0185\n@\3A\3A\3A\6A\u018a\nA"+
		"\rA\16A\u018b\5A\u018e\nA\3A\3A\5A\u0192\nA\3A\5A\u0195\nA\3B\3B\3B\3"+
		"B\3B\3C\7C\u019d\nC\fC\16C\u01a0\13C\3C\3C\3C\3C\5C\u01a6\nC\3C\3C\4\u0121"+
		"\u012a\2D\4\3\6\4\b\5\n\6\f\7\16\b\20\t\22\n\24\13\26\f\30\r\32\16\34"+
		"\17\36\20 \21\"\22$\23&\24(\25*\26,\27.\30\60\31\62\32\64\33\66\348\2"+
		":\2<\2>\35@\36B\37D F\2H\2J!L\"N#P$R%T&V\'X(Z)\\*^+`,b-d.f/h\60j\61l\62"+
		"n\63p\64r\65t\66v\67x8z9|:~\2\u0080;\u0082<\u0084>\u0086=\4\2\3\b\5\2"+
		"C\\c|\u0082\u0101\3\2\62;\3\2\63;\4\2--//\5\2\2\2))\u0080\u0080\3\2\2"+
		"\2\2\u01b1\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2"+
		"\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30"+
		"\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2"+
		"\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60"+
		"\3\2\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2\2>\3\2\2\2\2@\3\2\2\2"+
		"\2B\3\2\2\2\2D\3\2\2\2\2J\3\2\2\2\2L\3\2\2\2\2N\3\2\2\2\2P\3\2\2\2\2R"+
		"\3\2\2\2\2T\3\2\2\2\2V\3\2\2\2\2X\3\2\2\2\2Z\3\2\2\2\2\\\3\2\2\2\2^\3"+
		"\2\2\2\2`\3\2\2\2\2b\3\2\2\2\2d\3\2\2\2\2f\3\2\2\2\2h\3\2\2\2\2j\3\2\2"+
		"\2\2l\3\2\2\2\2n\3\2\2\2\2p\3\2\2\2\2r\3\2\2\2\2t\3\2\2\2\2v\3\2\2\2\2"+
		"x\3\2\2\2\2z\3\2\2\2\2|\3\2\2\2\2\u0080\3\2\2\2\2\u0082\3\2\2\2\2\u0084"+
		"\3\2\2\2\3\u0086\3\2\2\2\4\u0088\3\2\2\2\6\u008c\3\2\2\2\b\u0091\3\2\2"+
		"\2\n\u0097\3\2\2\2\f\u009e\3\2\2\2\16\u00a3\3\2\2\2\20\u00aa\3\2\2\2\22"+
		"\u00af\3\2\2\2\24\u00b3\3\2\2\2\26\u00b8\3\2\2\2\30\u00be\3\2\2\2\32\u00c4"+
		"\3\2\2\2\34\u00c7\3\2\2\2\36\u00cf\3\2\2\2 \u00d5\3\2\2\2\"\u00dd\3\2"+
		"\2\2$\u00e4\3\2\2\2&\u00e7\3\2\2\2(\u00ec\3\2\2\2*\u00f1\3\2\2\2,\u00f7"+
		"\3\2\2\2.\u00ff\3\2\2\2\60\u0108\3\2\2\2\62\u010c\3\2\2\2\64\u010e\3\2"+
		"\2\2\66\u0112\3\2\2\28\u0114\3\2\2\2:\u0117\3\2\2\2<\u011a\3\2\2\2>\u011d"+
		"\3\2\2\2@\u0126\3\2\2\2B\u012f\3\2\2\2D\u0131\3\2\2\2F\u0133\3\2\2\2H"+
		"\u0135\3\2\2\2J\u0137\3\2\2\2L\u0140\3\2\2\2N\u0142\3\2\2\2P\u0144\3\2"+
		"\2\2R\u0146\3\2\2\2T\u0148\3\2\2\2V\u014a\3\2\2\2X\u014c\3\2\2\2Z\u014e"+
		"\3\2\2\2\\\u0150\3\2\2\2^\u0152\3\2\2\2`\u0154\3\2\2\2b\u0156\3\2\2\2"+
		"d\u0158\3\2\2\2f\u015a\3\2\2\2h\u015c\3\2\2\2j\u015f\3\2\2\2l\u0162\3"+
		"\2\2\2n\u0165\3\2\2\2p\u0168\3\2\2\2r\u016a\3\2\2\2t\u016d\3\2\2\2v\u0170"+
		"\3\2\2\2x\u0172\3\2\2\2z\u0175\3\2\2\2|\u0178\3\2\2\2~\u017a\3\2\2\2\u0080"+
		"\u0184\3\2\2\2\u0082\u0186\3\2\2\2\u0084\u0196\3\2\2\2\u0086\u019e\3\2"+
		"\2\2\u0088\u0089\7k\2\2\u0089\u008a\7p\2\2\u008a\u008b\7v\2\2\u008b\5"+
		"\3\2\2\2\u008c\u008d\7d\2\2\u008d\u008e\7q\2\2\u008e\u008f\7q\2\2\u008f"+
		"\u0090\7n\2\2\u0090\7\3\2\2\2\u0091\u0092\7h\2\2\u0092\u0093\7n\2\2\u0093"+
		"\u0094\7q\2\2\u0094\u0095\7c\2\2\u0095\u0096\7v\2\2\u0096\t\3\2\2\2\u0097"+
		"\u0098\7u\2\2\u0098\u0099\7v\2\2\u0099\u009a\7t\2\2\u009a\u009b\7k\2\2"+
		"\u009b\u009c\7p\2\2\u009c\u009d\7i\2\2\u009d\13\3\2\2\2\u009e\u009f\7"+
		"x\2\2\u009f\u00a0\7q\2\2\u00a0\u00a1\7k\2\2\u00a1\u00a2\7f\2\2\u00a2\r"+
		"\3\2\2\2\u00a3\u00a4\7u\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7|\2\2\u00a6"+
		"\u00a7\7g\2\2\u00a7\u00a8\7q\2\2\u00a8\u00a9\7h\2\2\u00a9\17\3\2\2\2\u00aa"+
		"\u00ab\7p\2\2\u00ab\u00ac\7w\2\2\u00ac\u00ad\7n\2\2\u00ad\u00ae\7n\2\2"+
		"\u00ae\21\3\2\2\2\u00af\u00b0\7c\2\2\u00b0\u00b1\7n\2\2\u00b1\u00b2\7"+
		"i\2\2\u00b2\23\3\2\2\2\u00b3\u00b4\7v\2\2\u00b4\u00b5\7t\2\2\u00b5\u00b6"+
		"\7w\2\2\u00b6\u00b7\7g\2\2\u00b7\25\3\2\2\2\u00b8\u00b9\7h\2\2\u00b9\u00ba"+
		"\7c\2\2\u00ba\u00bb\7n\2\2\u00bb\u00bc\7u\2\2\u00bc\u00bd\7g\2\2\u00bd"+
		"\27\3\2\2\2\u00be\u00bf\7y\2\2\u00bf\u00c0\7j\2\2\u00c0\u00c1\7k\2\2\u00c1"+
		"\u00c2\7n\2\2\u00c2\u00c3\7g\2\2\u00c3\31\3\2\2\2\u00c4\u00c5\7f\2\2\u00c5"+
		"\u00c6\7q\2\2\u00c6\33\3\2\2\2\u00c7\u00c8\7h\2\2\u00c8\u00c9\7k\2\2\u00c9"+
		"\u00ca\7p\2\2\u00ca\u00cb\7c\2\2\u00cb\u00cc\7n\2\2\u00cc\u00cd\7n\2\2"+
		"\u00cd\u00ce\7{\2\2\u00ce\35\3\2\2\2\u00cf\u00d0\7n\2\2\u00d0\u00d1\7"+
		"g\2\2\u00d1\u00d2\7c\2\2\u00d2\u00d3\7x\2\2\u00d3\u00d4\7g\2\2\u00d4\37"+
		"\3\2\2\2\u00d5\u00d6\7t\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8\7u\2\2\u00d8"+
		"\u00d9\7v\2\2\u00d9\u00da\7c\2\2\u00da\u00db\7t\2\2\u00db\u00dc\7v\2\2"+
		"\u00dc!\3\2\2\2\u00dd\u00de\7t\2\2\u00de\u00df\7g\2\2\u00df\u00e0\7v\2"+
		"\2\u00e0\u00e1\7w\2\2\u00e1\u00e2\7t\2\2\u00e2\u00e3\7p\2\2\u00e3#\3\2"+
		"\2\2\u00e4\u00e5\7k\2\2\u00e5\u00e6\7h\2\2\u00e6%\3\2\2\2\u00e7\u00e8"+
		"\7v\2\2\u00e8\u00e9\7j\2\2\u00e9\u00ea\7g\2\2\u00ea\u00eb\7p\2\2\u00eb"+
		"\'\3\2\2\2\u00ec\u00ed\7g\2\2\u00ed\u00ee\7n\2\2\u00ee\u00ef\7u\2\2\u00ef"+
		"\u00f0\7g\2\2\u00f0)\3\2\2\2\u00f1\u00f2\7y\2\2\u00f2\u00f3\7t\2\2\u00f3"+
		"\u00f4\7k\2\2\u00f4\u00f5\7v\2\2\u00f5\u00f6\7g\2\2\u00f6+\3\2\2\2\u00f7"+
		"\u00f8\7y\2\2\u00f8\u00f9\7t\2\2\u00f9\u00fa\7k\2\2\u00fa\u00fb\7v\2\2"+
		"\u00fb\u00fc\7g\2\2\u00fc\u00fd\7n\2\2\u00fd\u00fe\7p\2\2\u00fe-\3\2\2"+
		"\2\u00ff\u0104\7>\2\2\u0100\u0105\5\4\2\2\u0101\u0105\5\6\3\2\u0102\u0105"+
		"\5\b\4\2\u0103\u0105\5\n\5\2\u0104\u0100\3\2\2\2\u0104\u0101\3\2\2\2\u0104"+
		"\u0102\3\2\2\2\u0104\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\7@"+
		"\2\2\u0107/\3\2\2\2\u0108\u0109\7\f\2\2\u0109\u010a\3\2\2\2\u010a\u010b"+
		"\b\30\2\2\u010b\61\3\2\2\2\u010c\u010d\7\17\2\2\u010d\63\3\2\2\2\u010e"+
		"\u010f\7\"\2\2\u010f\u0110\3\2\2\2\u0110\u0111\b\32\2\2\u0111\65\3\2\2"+
		"\2\u0112\u0113\7\13\2\2\u0113\67\3\2\2\2\u0114\u0115\7%\2\2\u0115\u0116"+
		"\7%\2\2\u01169\3\2\2\2\u0117\u0118\7*\2\2\u0118\u0119\7,\2\2\u0119;\3"+
		"\2\2\2\u011a\u011b\7,\2\2\u011b\u011c\7+\2\2\u011c=\3\2\2\2\u011d\u0121"+
		"\58\34\2\u011e\u0120\13\2\2\2\u011f\u011e\3\2\2\2\u0120\u0123\3\2\2\2"+
		"\u0121\u0122\3\2\2\2\u0121\u011f\3\2\2\2\u0122\u0124\3\2\2\2\u0123\u0121"+
		"\3\2\2\2\u0124\u0125\5\60\30\2\u0125?\3\2\2\2\u0126\u012a\5:\35\2\u0127"+
		"\u0129\13\2\2\2\u0128\u0127\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u012b\3"+
		"\2\2\2\u012a\u0128\3\2\2\2\u012b\u012d\3\2\2\2\u012c\u012a\3\2\2\2\u012d"+
		"\u012e\5<\36\2\u012eA\3\2\2\2\u012f\u0130\7.\2\2\u0130C\3\2\2\2\u0131"+
		"\u0132\7=\2\2\u0132E\3\2\2\2\u0133\u0134\t\2\2\2\u0134G\3\2\2\2\u0135"+
		"\u0136\7a\2\2\u0136I\3\2\2\2\u0137\u013d\5F#\2\u0138\u013c\5F#\2\u0139"+
		"\u013c\5~?\2\u013a\u013c\5H$\2\u013b\u0138\3\2\2\2\u013b\u0139\3\2\2\2"+
		"\u013b\u013a\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e"+
		"\3\2\2\2\u013eK\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0141\7*\2\2\u0141M"+
		"\3\2\2\2\u0142\u0143\7+\2\2\u0143O\3\2\2\2\u0144\u0145\7}\2\2\u0145Q\3"+
		"\2\2\2\u0146\u0147\7\177\2\2\u0147S\3\2\2\2\u0148\u0149\7]\2\2\u0149U"+
		"\3\2\2\2\u014a\u014b\7_\2\2\u014bW\3\2\2\2\u014c\u014d\7-\2\2\u014dY\3"+
		"\2\2\2\u014e\u014f\7/\2\2\u014f[\3\2\2\2\u0150\u0151\7,\2\2\u0151]\3\2"+
		"\2\2\u0152\u0153\7\61\2\2\u0153_\3\2\2\2\u0154\u0155\7A\2\2\u0155a\3\2"+
		"\2\2\u0156\u0157\7\'\2\2\u0157c\3\2\2\2\u0158\u0159\7@\2\2\u0159e\3\2"+
		"\2\2\u015a\u015b\7>\2\2\u015bg\3\2\2\2\u015c\u015d\7@\2\2\u015d\u015e"+
		"\7?\2\2\u015ei\3\2\2\2\u015f\u0160\7>\2\2\u0160\u0161\7?\2\2\u0161k\3"+
		"\2\2\2\u0162\u0163\7?\2\2\u0163\u0164\7?\2\2\u0164m\3\2\2\2\u0165\u0166"+
		"\7#\2\2\u0166\u0167\7?\2\2\u0167o\3\2\2\2\u0168\u0169\7\u0080\2\2\u0169"+
		"q\3\2\2\2\u016a\u016b\7(\2\2\u016b\u016c\7(\2\2\u016cs\3\2\2\2\u016d\u016e"+
		"\7~\2\2\u016e\u016f\7~\2\2\u016fu\3\2\2\2\u0170\u0171\7?\2\2\u0171w\3"+
		"\2\2\2\u0172\u0173\7>\2\2\u0173\u0174\7>\2\2\u0174y\3\2\2\2\u0175\u0176"+
		"\7@\2\2\u0176\u0177\7@\2\2\u0177{\3\2\2\2\u0178\u0179\7B\2\2\u0179}\3"+
		"\2\2\2\u017a\u017b\t\3\2\2\u017b\177\3\2\2\2\u017c\u0185\7\62\2\2\u017d"+
		"\u0181\t\4\2\2\u017e\u0180\5~?\2\u017f\u017e\3\2\2\2\u0180\u0183\3\2\2"+
		"\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0181"+
		"\3\2\2\2\u0184\u017c\3\2\2\2\u0184\u017d\3\2\2\2\u0185\u0081\3\2\2\2\u0186"+
		"\u018d\5\u0080@\2\u0187\u0189\7\60\2\2\u0188\u018a\5~?\2\u0189\u0188\3"+
		"\2\2\2\u018a\u018b\3\2\2\2\u018b\u0189\3\2\2\2\u018b\u018c\3\2\2\2\u018c"+
		"\u018e\3\2\2\2\u018d\u0187\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u0194\3\2"+
		"\2\2\u018f\u0191\7G\2\2\u0190\u0192\t\5\2\2\u0191\u0190\3\2\2\2\u0191"+
		"\u0192\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0195\5\u0080@\2\u0194\u018f"+
		"\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0083\3\2\2\2\u0196\u0197\7)\2\2\u0197"+
		"\u0198\3\2\2\2\u0198\u0199\bB\3\2\u0199\u019a\bB\4\2\u019a\u0085\3\2\2"+
		"\2\u019b\u019d\n\6\2\2\u019c\u019b\3\2\2\2\u019d\u01a0\3\2\2\2\u019e\u019c"+
		"\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a5\3\2\2\2\u01a0\u019e\3\2\2\2\u01a1"+
		"\u01a2\7\u0080\2\2\u01a2\u01a3\n\7\2\2\u01a3\u01a6\5\u0086C\2\u01a4\u01a6"+
		"\7)\2\2\u01a5\u01a1\3\2\2\2\u01a5\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7"+
		"\u01a8\bC\5\2\u01a8\u0087\3\2\2\2\21\2\3\u0104\u0121\u012a\u013b\u013d"+
		"\u0181\u0184\u018b\u018d\u0191\u0194\u019e\u01a5\6\b\2\2\5\2\2\7\3\2\6"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}