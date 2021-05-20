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
		IF=17, THEN=18, ELSE=19, WRITE=20, WRITELN=21, N=22, ARGS=23, INT_POINTER=24, 
		FLOAT_POINTER=25, STRING_POINTER=26, BOOL_POINTER=27, NULL_POINTER=28, 
		NEWLINE=29, CARRIAGE_RETURN=30, BLANK=31, TAB=32, EXPLICATIVE=33, OPERATIONAL=34, 
		COMMA=35, SEMI_COLON=36, IDENTIFIER=37, LPAREN=38, RPAREN=39, LBLOCK=40, 
		RBLOCK=41, LBRACKET=42, RBRACKET=43, ADD=44, SUB=45, MUL=46, DIV=47, QUESTION=48, 
		PERCENT=49, GREATER=50, LESSER=51, GREATEQ=52, LESSEQ=53, EQUALS=54, NOTEQUALS=55, 
		TILT=56, AND=57, OR=58, EQUAL=59, INSERT=60, EXTRACT=61, AT=62, INTEGER=63, 
		REAL=64, STRING_=65, START_STRING=66;
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
			"THEN", "ELSE", "WRITE", "WRITELN", "N", "ARGS", "INT_POINTER", "FLOAT_POINTER", 
			"STRING_POINTER", "BOOL_POINTER", "NULL_POINTER", "NEWLINE", "CARRIAGE_RETURN", 
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
			"'writeln'", "'n'", "'args'", null, null, null, null, null, "'\n'", "'\r'", 
			"' '", "'\t'", null, null, "','", "';'", null, "'('", "')'", "'{'", "'}'", 
			"'['", "']'", "'+'", "'-'", "'*'", "'/'", "'?'", "'%'", "'>'", "'<'", 
			"'>='", "'<='", "'=='", "'!='", "'~'", "'&&'", "'||'", "'='", "'<<'", 
			"'>>'", "'@'", null, null, null, "'''"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "BOOL", "FLOAT", "STRING", "VOID", "SIZEOF", "NULL", "ALG", 
			"TRUE", "FALSE", "WHILE", "DO", "FINALLY", "LEAVE", "RESTART", "RETURN", 
			"IF", "THEN", "ELSE", "WRITE", "WRITELN", "N", "ARGS", "INT_POINTER", 
			"FLOAT_POINTER", "STRING_POINTER", "BOOL_POINTER", "NULL_POINTER", "NEWLINE", 
			"CARRIAGE_RETURN", "BLANK", "TAB", "EXPLICATIVE", "OPERATIONAL", "COMMA", 
			"SEMI_COLON", "IDENTIFIER", "LPAREN", "RPAREN", "LBLOCK", "RBLOCK", "LBRACKET", 
			"RBRACKET", "ADD", "SUB", "MUL", "DIV", "QUESTION", "PERCENT", "GREATER", 
			"LESSER", "GREATEQ", "LESSEQ", "EQUALS", "NOTEQUALS", "TILT", "AND", 
			"OR", "EQUAL", "INSERT", "EXTRACT", "AT", "INTEGER", "REAL", "STRING_", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2D\u01c7\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37"+
		"\3\37\3 \3 \3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\7%\u013e\n"+
		"%\f%\16%\u0141\13%\3%\3%\3&\3&\7&\u0147\n&\f&\16&\u014a\13&\3&\3&\3\'"+
		"\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3+\3+\7+\u015a\n+\f+\16+\u015d\13+\3,\3,"+
		"\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3"+
		"\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3:\3;\3;\3;\3<\3<\3<\3"+
		"=\3=\3=\3>\3>\3?\3?\3?\3@\3@\3@\3A\3A\3B\3B\3B\3C\3C\3C\3D\3D\3E\3E\3"+
		"F\3F\3F\7F\u019e\nF\fF\16F\u01a1\13F\5F\u01a3\nF\3G\3G\3G\6G\u01a8\nG"+
		"\rG\16G\u01a9\5G\u01ac\nG\3G\3G\5G\u01b0\nG\3G\5G\u01b3\nG\3H\3H\3H\3"+
		"H\3H\3I\7I\u01bb\nI\fI\16I\u01be\13I\3I\3I\3I\3I\5I\u01c4\nI\3I\3I\4\u013f"+
		"\u0148\2J\4\3\6\4\b\5\n\6\f\7\16\b\20\t\22\n\24\13\26\f\30\r\32\16\34"+
		"\17\36\20 \21\"\22$\23&\24(\25*\26,\27.\30\60\31\62\32\64\33\66\348\35"+
		":\36<\37> @!B\"D\2F\2H\2J#L$N%P&R\2T\2V\'X(Z)\\*^+`,b-d.f/h\60j\61l\62"+
		"n\63p\64r\65t\66v\67x8z9|:~;\u0080<\u0082=\u0084>\u0086?\u0088@\u008a"+
		"\2\u008cA\u008eB\u0090D\u0092C\4\2\3\b\5\2C\\c|\u0082\u0101\3\2\62;\3"+
		"\2\63;\4\2--//\5\2\2\2))\u0080\u0080\3\2\2\2\2\u01cc\2\4\3\2\2\2\2\6\3"+
		"\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2"+
		"\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3"+
		"\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3"+
		"\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2\2\2\64"+
		"\3\2\2\2\2\66\3\2\2\2\28\3\2\2\2\2:\3\2\2\2\2<\3\2\2\2\2>\3\2\2\2\2@\3"+
		"\2\2\2\2B\3\2\2\2\2J\3\2\2\2\2L\3\2\2\2\2N\3\2\2\2\2P\3\2\2\2\2V\3\2\2"+
		"\2\2X\3\2\2\2\2Z\3\2\2\2\2\\\3\2\2\2\2^\3\2\2\2\2`\3\2\2\2\2b\3\2\2\2"+
		"\2d\3\2\2\2\2f\3\2\2\2\2h\3\2\2\2\2j\3\2\2\2\2l\3\2\2\2\2n\3\2\2\2\2p"+
		"\3\2\2\2\2r\3\2\2\2\2t\3\2\2\2\2v\3\2\2\2\2x\3\2\2\2\2z\3\2\2\2\2|\3\2"+
		"\2\2\2~\3\2\2\2\2\u0080\3\2\2\2\2\u0082\3\2\2\2\2\u0084\3\2\2\2\2\u0086"+
		"\3\2\2\2\2\u0088\3\2\2\2\2\u008c\3\2\2\2\2\u008e\3\2\2\2\2\u0090\3\2\2"+
		"\2\3\u0092\3\2\2\2\4\u0094\3\2\2\2\6\u0098\3\2\2\2\b\u009d\3\2\2\2\n\u00a3"+
		"\3\2\2\2\f\u00aa\3\2\2\2\16\u00af\3\2\2\2\20\u00b6\3\2\2\2\22\u00bb\3"+
		"\2\2\2\24\u00bf\3\2\2\2\26\u00c4\3\2\2\2\30\u00ca\3\2\2\2\32\u00d0\3\2"+
		"\2\2\34\u00d3\3\2\2\2\36\u00db\3\2\2\2 \u00e1\3\2\2\2\"\u00e9\3\2\2\2"+
		"$\u00f0\3\2\2\2&\u00f3\3\2\2\2(\u00f8\3\2\2\2*\u00fd\3\2\2\2,\u0103\3"+
		"\2\2\2.\u010b\3\2\2\2\60\u010d\3\2\2\2\62\u0112\3\2\2\2\64\u0116\3\2\2"+
		"\2\66\u011a\3\2\2\28\u011e\3\2\2\2:\u0122\3\2\2\2<\u0126\3\2\2\2>\u012a"+
		"\3\2\2\2@\u012c\3\2\2\2B\u0130\3\2\2\2D\u0132\3\2\2\2F\u0135\3\2\2\2H"+
		"\u0138\3\2\2\2J\u013b\3\2\2\2L\u0144\3\2\2\2N\u014d\3\2\2\2P\u014f\3\2"+
		"\2\2R\u0151\3\2\2\2T\u0153\3\2\2\2V\u0155\3\2\2\2X\u015e\3\2\2\2Z\u0160"+
		"\3\2\2\2\\\u0162\3\2\2\2^\u0164\3\2\2\2`\u0166\3\2\2\2b\u0168\3\2\2\2"+
		"d\u016a\3\2\2\2f\u016c\3\2\2\2h\u016e\3\2\2\2j\u0170\3\2\2\2l\u0172\3"+
		"\2\2\2n\u0174\3\2\2\2p\u0176\3\2\2\2r\u0178\3\2\2\2t\u017a\3\2\2\2v\u017d"+
		"\3\2\2\2x\u0180\3\2\2\2z\u0183\3\2\2\2|\u0186\3\2\2\2~\u0188\3\2\2\2\u0080"+
		"\u018b\3\2\2\2\u0082\u018e\3\2\2\2\u0084\u0190\3\2\2\2\u0086\u0193\3\2"+
		"\2\2\u0088\u0196\3\2\2\2\u008a\u0198\3\2\2\2\u008c\u01a2\3\2\2\2\u008e"+
		"\u01a4\3\2\2\2\u0090\u01b4\3\2\2\2\u0092\u01bc\3\2\2\2\u0094\u0095\7k"+
		"\2\2\u0095\u0096\7p\2\2\u0096\u0097\7v\2\2\u0097\5\3\2\2\2\u0098\u0099"+
		"\7d\2\2\u0099\u009a\7q\2\2\u009a\u009b\7q\2\2\u009b\u009c\7n\2\2\u009c"+
		"\7\3\2\2\2\u009d\u009e\7h\2\2\u009e\u009f\7n\2\2\u009f\u00a0\7q\2\2\u00a0"+
		"\u00a1\7c\2\2\u00a1\u00a2\7v\2\2\u00a2\t\3\2\2\2\u00a3\u00a4\7u\2\2\u00a4"+
		"\u00a5\7v\2\2\u00a5\u00a6\7t\2\2\u00a6\u00a7\7k\2\2\u00a7\u00a8\7p\2\2"+
		"\u00a8\u00a9\7i\2\2\u00a9\13\3\2\2\2\u00aa\u00ab\7x\2\2\u00ab\u00ac\7"+
		"q\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7f\2\2\u00ae\r\3\2\2\2\u00af\u00b0"+
		"\7u\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7|\2\2\u00b2\u00b3\7g\2\2\u00b3"+
		"\u00b4\7q\2\2\u00b4\u00b5\7h\2\2\u00b5\17\3\2\2\2\u00b6\u00b7\7p\2\2\u00b7"+
		"\u00b8\7w\2\2\u00b8\u00b9\7n\2\2\u00b9\u00ba\7n\2\2\u00ba\21\3\2\2\2\u00bb"+
		"\u00bc\7c\2\2\u00bc\u00bd\7n\2\2\u00bd\u00be\7i\2\2\u00be\23\3\2\2\2\u00bf"+
		"\u00c0\7v\2\2\u00c0\u00c1\7t\2\2\u00c1\u00c2\7w\2\2\u00c2\u00c3\7g\2\2"+
		"\u00c3\25\3\2\2\2\u00c4\u00c5\7h\2\2\u00c5\u00c6\7c\2\2\u00c6\u00c7\7"+
		"n\2\2\u00c7\u00c8\7u\2\2\u00c8\u00c9\7g\2\2\u00c9\27\3\2\2\2\u00ca\u00cb"+
		"\7y\2\2\u00cb\u00cc\7j\2\2\u00cc\u00cd\7k\2\2\u00cd\u00ce\7n\2\2\u00ce"+
		"\u00cf\7g\2\2\u00cf\31\3\2\2\2\u00d0\u00d1\7f\2\2\u00d1\u00d2\7q\2\2\u00d2"+
		"\33\3\2\2\2\u00d3\u00d4\7h\2\2\u00d4\u00d5\7k\2\2\u00d5\u00d6\7p\2\2\u00d6"+
		"\u00d7\7c\2\2\u00d7\u00d8\7n\2\2\u00d8\u00d9\7n\2\2\u00d9\u00da\7{\2\2"+
		"\u00da\35\3\2\2\2\u00db\u00dc\7n\2\2\u00dc\u00dd\7g\2\2\u00dd\u00de\7"+
		"c\2\2\u00de\u00df\7x\2\2\u00df\u00e0\7g\2\2\u00e0\37\3\2\2\2\u00e1\u00e2"+
		"\7t\2\2\u00e2\u00e3\7g\2\2\u00e3\u00e4\7u\2\2\u00e4\u00e5\7v\2\2\u00e5"+
		"\u00e6\7c\2\2\u00e6\u00e7\7t\2\2\u00e7\u00e8\7v\2\2\u00e8!\3\2\2\2\u00e9"+
		"\u00ea\7t\2\2\u00ea\u00eb\7g\2\2\u00eb\u00ec\7v\2\2\u00ec\u00ed\7w\2\2"+
		"\u00ed\u00ee\7t\2\2\u00ee\u00ef\7p\2\2\u00ef#\3\2\2\2\u00f0\u00f1\7k\2"+
		"\2\u00f1\u00f2\7h\2\2\u00f2%\3\2\2\2\u00f3\u00f4\7v\2\2\u00f4\u00f5\7"+
		"j\2\2\u00f5\u00f6\7g\2\2\u00f6\u00f7\7p\2\2\u00f7\'\3\2\2\2\u00f8\u00f9"+
		"\7g\2\2\u00f9\u00fa\7n\2\2\u00fa\u00fb\7u\2\2\u00fb\u00fc\7g\2\2\u00fc"+
		")\3\2\2\2\u00fd\u00fe\7y\2\2\u00fe\u00ff\7t\2\2\u00ff\u0100\7k\2\2\u0100"+
		"\u0101\7v\2\2\u0101\u0102\7g\2\2\u0102+\3\2\2\2\u0103\u0104\7y\2\2\u0104"+
		"\u0105\7t\2\2\u0105\u0106\7k\2\2\u0106\u0107\7v\2\2\u0107\u0108\7g\2\2"+
		"\u0108\u0109\7n\2\2\u0109\u010a\7p\2\2\u010a-\3\2\2\2\u010b\u010c\7p\2"+
		"\2\u010c/\3\2\2\2\u010d\u010e\7c\2\2\u010e\u010f\7t\2\2\u010f\u0110\7"+
		"i\2\2\u0110\u0111\7u\2\2\u0111\61\3\2\2\2\u0112\u0113\7>\2\2\u0113\u0114"+
		"\5\4\2\2\u0114\u0115\7@\2\2\u0115\63\3\2\2\2\u0116\u0117\7>\2\2\u0117"+
		"\u0118\5\b\4\2\u0118\u0119\7@\2\2\u0119\65\3\2\2\2\u011a\u011b\7>\2\2"+
		"\u011b\u011c\5\n\5\2\u011c\u011d\7@\2\2\u011d\67\3\2\2\2\u011e\u011f\7"+
		">\2\2\u011f\u0120\5\6\3\2\u0120\u0121\7@\2\2\u01219\3\2\2\2\u0122\u0123"+
		"\7>\2\2\u0123\u0124\5\f\6\2\u0124\u0125\7@\2\2\u0125;\3\2\2\2\u0126\u0127"+
		"\7\f\2\2\u0127\u0128\3\2\2\2\u0128\u0129\b\36\2\2\u0129=\3\2\2\2\u012a"+
		"\u012b\7\17\2\2\u012b?\3\2\2\2\u012c\u012d\7\"\2\2\u012d\u012e\3\2\2\2"+
		"\u012e\u012f\b \2\2\u012fA\3\2\2\2\u0130\u0131\7\13\2\2\u0131C\3\2\2\2"+
		"\u0132\u0133\7%\2\2\u0133\u0134\7%\2\2\u0134E\3\2\2\2\u0135\u0136\7*\2"+
		"\2\u0136\u0137\7,\2\2\u0137G\3\2\2\2\u0138\u0139\7,\2\2\u0139\u013a\7"+
		"+\2\2\u013aI\3\2\2\2\u013b\u013f\5D\"\2\u013c\u013e\13\2\2\2\u013d\u013c"+
		"\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u0140\3\2\2\2\u013f\u013d\3\2\2\2\u0140"+
		"\u0142\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0143\5<\36\2\u0143K\3\2\2\2"+
		"\u0144\u0148\5F#\2\u0145\u0147\13\2\2\2\u0146\u0145\3\2\2\2\u0147\u014a"+
		"\3\2\2\2\u0148\u0149\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u014b\3\2\2\2\u014a"+
		"\u0148\3\2\2\2\u014b\u014c\5H$\2\u014cM\3\2\2\2\u014d\u014e\7.\2\2\u014e"+
		"O\3\2\2\2\u014f\u0150\7=\2\2\u0150Q\3\2\2\2\u0151\u0152\t\2\2\2\u0152"+
		"S\3\2\2\2\u0153\u0154\7a\2\2\u0154U\3\2\2\2\u0155\u015b\5R)\2\u0156\u015a"+
		"\5R)\2\u0157\u015a\5\u008aE\2\u0158\u015a\5T*\2\u0159\u0156\3\2\2\2\u0159"+
		"\u0157\3\2\2\2\u0159\u0158\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2"+
		"\2\2\u015b\u015c\3\2\2\2\u015cW\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u015f"+
		"\7*\2\2\u015fY\3\2\2\2\u0160\u0161\7+\2\2\u0161[\3\2\2\2\u0162\u0163\7"+
		"}\2\2\u0163]\3\2\2\2\u0164\u0165\7\177\2\2\u0165_\3\2\2\2\u0166\u0167"+
		"\7]\2\2\u0167a\3\2\2\2\u0168\u0169\7_\2\2\u0169c\3\2\2\2\u016a\u016b\7"+
		"-\2\2\u016be\3\2\2\2\u016c\u016d\7/\2\2\u016dg\3\2\2\2\u016e\u016f\7,"+
		"\2\2\u016fi\3\2\2\2\u0170\u0171\7\61\2\2\u0171k\3\2\2\2\u0172\u0173\7"+
		"A\2\2\u0173m\3\2\2\2\u0174\u0175\7\'\2\2\u0175o\3\2\2\2\u0176\u0177\7"+
		"@\2\2\u0177q\3\2\2\2\u0178\u0179\7>\2\2\u0179s\3\2\2\2\u017a\u017b\7@"+
		"\2\2\u017b\u017c\7?\2\2\u017cu\3\2\2\2\u017d\u017e\7>\2\2\u017e\u017f"+
		"\7?\2\2\u017fw\3\2\2\2\u0180\u0181\7?\2\2\u0181\u0182\7?\2\2\u0182y\3"+
		"\2\2\2\u0183\u0184\7#\2\2\u0184\u0185\7?\2\2\u0185{\3\2\2\2\u0186\u0187"+
		"\7\u0080\2\2\u0187}\3\2\2\2\u0188\u0189\7(\2\2\u0189\u018a\7(\2\2\u018a"+
		"\177\3\2\2\2\u018b\u018c\7~\2\2\u018c\u018d\7~\2\2\u018d\u0081\3\2\2\2"+
		"\u018e\u018f\7?\2\2\u018f\u0083\3\2\2\2\u0190\u0191\7>\2\2\u0191\u0192"+
		"\7>\2\2\u0192\u0085\3\2\2\2\u0193\u0194\7@\2\2\u0194\u0195\7@\2\2\u0195"+
		"\u0087\3\2\2\2\u0196\u0197\7B\2\2\u0197\u0089\3\2\2\2\u0198\u0199\t\3"+
		"\2\2\u0199\u008b\3\2\2\2\u019a\u01a3\7\62\2\2\u019b\u019f\t\4\2\2\u019c"+
		"\u019e\5\u008aE\2\u019d\u019c\3\2\2\2\u019e\u01a1\3\2\2\2\u019f\u019d"+
		"\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a3\3\2\2\2\u01a1\u019f\3\2\2\2\u01a2"+
		"\u019a\3\2\2\2\u01a2\u019b\3\2\2\2\u01a3\u008d\3\2\2\2\u01a4\u01ab\5\u008c"+
		"F\2\u01a5\u01a7\7\60\2\2\u01a6\u01a8\5\u008aE\2\u01a7\u01a6\3\2\2\2\u01a8"+
		"\u01a9\3\2\2\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ac\3\2"+
		"\2\2\u01ab\u01a5\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01b2\3\2\2\2\u01ad"+
		"\u01af\7G\2\2\u01ae\u01b0\t\5\2\2\u01af\u01ae\3\2\2\2\u01af\u01b0\3\2"+
		"\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b3\5\u008cF\2\u01b2\u01ad\3\2\2\2\u01b2"+
		"\u01b3\3\2\2\2\u01b3\u008f\3\2\2\2\u01b4\u01b5\7)\2\2\u01b5\u01b6\3\2"+
		"\2\2\u01b6\u01b7\bH\3\2\u01b7\u01b8\bH\4\2\u01b8\u0091\3\2\2\2\u01b9\u01bb"+
		"\n\6\2\2\u01ba\u01b9\3\2\2\2\u01bb\u01be\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bc"+
		"\u01bd\3\2\2\2\u01bd\u01c3\3\2\2\2\u01be\u01bc\3\2\2\2\u01bf\u01c0\7\u0080"+
		"\2\2\u01c0\u01c1\n\7\2\2\u01c1\u01c4\5\u0092I\2\u01c2\u01c4\7)\2\2\u01c3"+
		"\u01bf\3\2\2\2\u01c3\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c6\bI"+
		"\5\2\u01c6\u0093\3\2\2\2\20\2\3\u013f\u0148\u0159\u015b\u019f\u01a2\u01a9"+
		"\u01ab\u01af\u01b2\u01bc\u01c3\6\b\2\2\5\2\2\7\3\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}