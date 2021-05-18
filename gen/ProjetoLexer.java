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
		FLOAT_POINTER=25, STRING_POINTER=26, BOOL_POINTER=27, NEWLINE=28, CARRIAGE_RETURN=29, 
		BLANK=30, TAB=31, EXPLICATIVE=32, OPERATIONAL=33, COMMA=34, SEMI_COLON=35, 
		IDENTIFIER=36, LPAREN=37, RPAREN=38, LBLOCK=39, RBLOCK=40, LBRACKET=41, 
		RBRACKET=42, ADD=43, SUB=44, MUL=45, DIV=46, QUESTION=47, PERCENT=48, 
		GREATER=49, LESSER=50, GREATEQ=51, LESSEQ=52, EQUALS=53, NOTEQUALS=54, 
		TILT=55, AND=56, OR=57, EQUAL=58, INSERT=59, EXTRACT=60, AT=61, INTEGER=62, 
		REAL=63, STRING_=64, START_STRING=65;
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
			"STRING_POINTER", "BOOL_POINTER", "NEWLINE", "CARRIAGE_RETURN", "BLANK", 
			"TAB", "DOUBLE_CARDINAL", "LOPERATIONAL", "ROPERATIONAL", "EXPLICATIVE", 
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
			"'writeln'", "'n'", "'args'", null, null, null, null, "'\n'", "'\r'", 
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
			"FLOAT_POINTER", "STRING_POINTER", "BOOL_POINTER", "NEWLINE", "CARRIAGE_RETURN", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2C\u01c1\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\7$\u0138\n$\f$\16$\u013b\13"+
		"$\3$\3$\3%\3%\7%\u0141\n%\f%\16%\u0144\13%\3%\3%\3&\3&\3\'\3\'\3(\3(\3"+
		")\3)\3*\3*\3*\3*\7*\u0154\n*\f*\16*\u0157\13*\3+\3+\3,\3,\3-\3-\3.\3."+
		"\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66"+
		"\3\66\3\67\3\67\38\38\39\39\39\3:\3:\3:\3;\3;\3;\3<\3<\3<\3=\3=\3>\3>"+
		"\3>\3?\3?\3?\3@\3@\3A\3A\3A\3B\3B\3B\3C\3C\3D\3D\3E\3E\3E\7E\u0198\nE"+
		"\fE\16E\u019b\13E\5E\u019d\nE\3F\3F\3F\6F\u01a2\nF\rF\16F\u01a3\5F\u01a6"+
		"\nF\3F\3F\5F\u01aa\nF\3F\5F\u01ad\nF\3G\3G\3G\3G\3G\3H\7H\u01b5\nH\fH"+
		"\16H\u01b8\13H\3H\3H\3H\3H\5H\u01be\nH\3H\3H\4\u0139\u0142\2I\4\3\6\4"+
		"\b\5\n\6\f\7\16\b\20\t\22\n\24\13\26\f\30\r\32\16\34\17\36\20 \21\"\22"+
		"$\23&\24(\25*\26,\27.\30\60\31\62\32\64\33\66\348\35:\36<\37> @!B\2D\2"+
		"F\2H\"J#L$N%P\2R\2T&V\'X(Z)\\*^+`,b-d.f/h\60j\61l\62n\63p\64r\65t\66v"+
		"\67x8z9|:~;\u0080<\u0082=\u0084>\u0086?\u0088\2\u008a@\u008cA\u008eC\u0090"+
		"B\4\2\3\b\5\2C\\c|\u0082\u0101\3\2\62;\3\2\63;\4\2--//\5\2\2\2))\u0080"+
		"\u0080\3\2\2\2\2\u01c6\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2"+
		"\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26"+
		"\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2"+
		"\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2"+
		"\2.\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2\28\3\2"+
		"\2\2\2:\3\2\2\2\2<\3\2\2\2\2>\3\2\2\2\2@\3\2\2\2\2H\3\2\2\2\2J\3\2\2\2"+
		"\2L\3\2\2\2\2N\3\2\2\2\2T\3\2\2\2\2V\3\2\2\2\2X\3\2\2\2\2Z\3\2\2\2\2\\"+
		"\3\2\2\2\2^\3\2\2\2\2`\3\2\2\2\2b\3\2\2\2\2d\3\2\2\2\2f\3\2\2\2\2h\3\2"+
		"\2\2\2j\3\2\2\2\2l\3\2\2\2\2n\3\2\2\2\2p\3\2\2\2\2r\3\2\2\2\2t\3\2\2\2"+
		"\2v\3\2\2\2\2x\3\2\2\2\2z\3\2\2\2\2|\3\2\2\2\2~\3\2\2\2\2\u0080\3\2\2"+
		"\2\2\u0082\3\2\2\2\2\u0084\3\2\2\2\2\u0086\3\2\2\2\2\u008a\3\2\2\2\2\u008c"+
		"\3\2\2\2\2\u008e\3\2\2\2\3\u0090\3\2\2\2\4\u0092\3\2\2\2\6\u0096\3\2\2"+
		"\2\b\u009b\3\2\2\2\n\u00a1\3\2\2\2\f\u00a8\3\2\2\2\16\u00ad\3\2\2\2\20"+
		"\u00b4\3\2\2\2\22\u00b9\3\2\2\2\24\u00bd\3\2\2\2\26\u00c2\3\2\2\2\30\u00c8"+
		"\3\2\2\2\32\u00ce\3\2\2\2\34\u00d1\3\2\2\2\36\u00d9\3\2\2\2 \u00df\3\2"+
		"\2\2\"\u00e7\3\2\2\2$\u00ee\3\2\2\2&\u00f1\3\2\2\2(\u00f6\3\2\2\2*\u00fb"+
		"\3\2\2\2,\u0101\3\2\2\2.\u0109\3\2\2\2\60\u010b\3\2\2\2\62\u0110\3\2\2"+
		"\2\64\u0114\3\2\2\2\66\u0118\3\2\2\28\u011c\3\2\2\2:\u0120\3\2\2\2<\u0124"+
		"\3\2\2\2>\u0126\3\2\2\2@\u012a\3\2\2\2B\u012c\3\2\2\2D\u012f\3\2\2\2F"+
		"\u0132\3\2\2\2H\u0135\3\2\2\2J\u013e\3\2\2\2L\u0147\3\2\2\2N\u0149\3\2"+
		"\2\2P\u014b\3\2\2\2R\u014d\3\2\2\2T\u014f\3\2\2\2V\u0158\3\2\2\2X\u015a"+
		"\3\2\2\2Z\u015c\3\2\2\2\\\u015e\3\2\2\2^\u0160\3\2\2\2`\u0162\3\2\2\2"+
		"b\u0164\3\2\2\2d\u0166\3\2\2\2f\u0168\3\2\2\2h\u016a\3\2\2\2j\u016c\3"+
		"\2\2\2l\u016e\3\2\2\2n\u0170\3\2\2\2p\u0172\3\2\2\2r\u0174\3\2\2\2t\u0177"+
		"\3\2\2\2v\u017a\3\2\2\2x\u017d\3\2\2\2z\u0180\3\2\2\2|\u0182\3\2\2\2~"+
		"\u0185\3\2\2\2\u0080\u0188\3\2\2\2\u0082\u018a\3\2\2\2\u0084\u018d\3\2"+
		"\2\2\u0086\u0190\3\2\2\2\u0088\u0192\3\2\2\2\u008a\u019c\3\2\2\2\u008c"+
		"\u019e\3\2\2\2\u008e\u01ae\3\2\2\2\u0090\u01b6\3\2\2\2\u0092\u0093\7k"+
		"\2\2\u0093\u0094\7p\2\2\u0094\u0095\7v\2\2\u0095\5\3\2\2\2\u0096\u0097"+
		"\7d\2\2\u0097\u0098\7q\2\2\u0098\u0099\7q\2\2\u0099\u009a\7n\2\2\u009a"+
		"\7\3\2\2\2\u009b\u009c\7h\2\2\u009c\u009d\7n\2\2\u009d\u009e\7q\2\2\u009e"+
		"\u009f\7c\2\2\u009f\u00a0\7v\2\2\u00a0\t\3\2\2\2\u00a1\u00a2\7u\2\2\u00a2"+
		"\u00a3\7v\2\2\u00a3\u00a4\7t\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7p\2\2"+
		"\u00a6\u00a7\7i\2\2\u00a7\13\3\2\2\2\u00a8\u00a9\7x\2\2\u00a9\u00aa\7"+
		"q\2\2\u00aa\u00ab\7k\2\2\u00ab\u00ac\7f\2\2\u00ac\r\3\2\2\2\u00ad\u00ae"+
		"\7u\2\2\u00ae\u00af\7k\2\2\u00af\u00b0\7|\2\2\u00b0\u00b1\7g\2\2\u00b1"+
		"\u00b2\7q\2\2\u00b2\u00b3\7h\2\2\u00b3\17\3\2\2\2\u00b4\u00b5\7p\2\2\u00b5"+
		"\u00b6\7w\2\2\u00b6\u00b7\7n\2\2\u00b7\u00b8\7n\2\2\u00b8\21\3\2\2\2\u00b9"+
		"\u00ba\7c\2\2\u00ba\u00bb\7n\2\2\u00bb\u00bc\7i\2\2\u00bc\23\3\2\2\2\u00bd"+
		"\u00be\7v\2\2\u00be\u00bf\7t\2\2\u00bf\u00c0\7w\2\2\u00c0\u00c1\7g\2\2"+
		"\u00c1\25\3\2\2\2\u00c2\u00c3\7h\2\2\u00c3\u00c4\7c\2\2\u00c4\u00c5\7"+
		"n\2\2\u00c5\u00c6\7u\2\2\u00c6\u00c7\7g\2\2\u00c7\27\3\2\2\2\u00c8\u00c9"+
		"\7y\2\2\u00c9\u00ca\7j\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc\7n\2\2\u00cc"+
		"\u00cd\7g\2\2\u00cd\31\3\2\2\2\u00ce\u00cf\7f\2\2\u00cf\u00d0\7q\2\2\u00d0"+
		"\33\3\2\2\2\u00d1\u00d2\7h\2\2\u00d2\u00d3\7k\2\2\u00d3\u00d4\7p\2\2\u00d4"+
		"\u00d5\7c\2\2\u00d5\u00d6\7n\2\2\u00d6\u00d7\7n\2\2\u00d7\u00d8\7{\2\2"+
		"\u00d8\35\3\2\2\2\u00d9\u00da\7n\2\2\u00da\u00db\7g\2\2\u00db\u00dc\7"+
		"c\2\2\u00dc\u00dd\7x\2\2\u00dd\u00de\7g\2\2\u00de\37\3\2\2\2\u00df\u00e0"+
		"\7t\2\2\u00e0\u00e1\7g\2\2\u00e1\u00e2\7u\2\2\u00e2\u00e3\7v\2\2\u00e3"+
		"\u00e4\7c\2\2\u00e4\u00e5\7t\2\2\u00e5\u00e6\7v\2\2\u00e6!\3\2\2\2\u00e7"+
		"\u00e8\7t\2\2\u00e8\u00e9\7g\2\2\u00e9\u00ea\7v\2\2\u00ea\u00eb\7w\2\2"+
		"\u00eb\u00ec\7t\2\2\u00ec\u00ed\7p\2\2\u00ed#\3\2\2\2\u00ee\u00ef\7k\2"+
		"\2\u00ef\u00f0\7h\2\2\u00f0%\3\2\2\2\u00f1\u00f2\7v\2\2\u00f2\u00f3\7"+
		"j\2\2\u00f3\u00f4\7g\2\2\u00f4\u00f5\7p\2\2\u00f5\'\3\2\2\2\u00f6\u00f7"+
		"\7g\2\2\u00f7\u00f8\7n\2\2\u00f8\u00f9\7u\2\2\u00f9\u00fa\7g\2\2\u00fa"+
		")\3\2\2\2\u00fb\u00fc\7y\2\2\u00fc\u00fd\7t\2\2\u00fd\u00fe\7k\2\2\u00fe"+
		"\u00ff\7v\2\2\u00ff\u0100\7g\2\2\u0100+\3\2\2\2\u0101\u0102\7y\2\2\u0102"+
		"\u0103\7t\2\2\u0103\u0104\7k\2\2\u0104\u0105\7v\2\2\u0105\u0106\7g\2\2"+
		"\u0106\u0107\7n\2\2\u0107\u0108\7p\2\2\u0108-\3\2\2\2\u0109\u010a\7p\2"+
		"\2\u010a/\3\2\2\2\u010b\u010c\7c\2\2\u010c\u010d\7t\2\2\u010d\u010e\7"+
		"i\2\2\u010e\u010f\7u\2\2\u010f\61\3\2\2\2\u0110\u0111\7>\2\2\u0111\u0112"+
		"\5\4\2\2\u0112\u0113\7@\2\2\u0113\63\3\2\2\2\u0114\u0115\7>\2\2\u0115"+
		"\u0116\5\b\4\2\u0116\u0117\7@\2\2\u0117\65\3\2\2\2\u0118\u0119\7>\2\2"+
		"\u0119\u011a\5\n\5\2\u011a\u011b\7@\2\2\u011b\67\3\2\2\2\u011c\u011d\7"+
		">\2\2\u011d\u011e\5\6\3\2\u011e\u011f\7@\2\2\u011f9\3\2\2\2\u0120\u0121"+
		"\7\f\2\2\u0121\u0122\3\2\2\2\u0122\u0123\b\35\2\2\u0123;\3\2\2\2\u0124"+
		"\u0125\7\17\2\2\u0125=\3\2\2\2\u0126\u0127\7\"\2\2\u0127\u0128\3\2\2\2"+
		"\u0128\u0129\b\37\2\2\u0129?\3\2\2\2\u012a\u012b\7\13\2\2\u012bA\3\2\2"+
		"\2\u012c\u012d\7%\2\2\u012d\u012e\7%\2\2\u012eC\3\2\2\2\u012f\u0130\7"+
		"*\2\2\u0130\u0131\7,\2\2\u0131E\3\2\2\2\u0132\u0133\7,\2\2\u0133\u0134"+
		"\7+\2\2\u0134G\3\2\2\2\u0135\u0139\5B!\2\u0136\u0138\13\2\2\2\u0137\u0136"+
		"\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u013a\3\2\2\2\u0139\u0137\3\2\2\2\u013a"+
		"\u013c\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u013d\5:\35\2\u013dI\3\2\2\2"+
		"\u013e\u0142\5D\"\2\u013f\u0141\13\2\2\2\u0140\u013f\3\2\2\2\u0141\u0144"+
		"\3\2\2\2\u0142\u0143\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0145\3\2\2\2\u0144"+
		"\u0142\3\2\2\2\u0145\u0146\5F#\2\u0146K\3\2\2\2\u0147\u0148\7.\2\2\u0148"+
		"M\3\2\2\2\u0149\u014a\7=\2\2\u014aO\3\2\2\2\u014b\u014c\t\2\2\2\u014c"+
		"Q\3\2\2\2\u014d\u014e\7a\2\2\u014eS\3\2\2\2\u014f\u0155\5P(\2\u0150\u0154"+
		"\5P(\2\u0151\u0154\5\u0088D\2\u0152\u0154\5R)\2\u0153\u0150\3\2\2\2\u0153"+
		"\u0151\3\2\2\2\u0153\u0152\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2"+
		"\2\2\u0155\u0156\3\2\2\2\u0156U\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u0159"+
		"\7*\2\2\u0159W\3\2\2\2\u015a\u015b\7+\2\2\u015bY\3\2\2\2\u015c\u015d\7"+
		"}\2\2\u015d[\3\2\2\2\u015e\u015f\7\177\2\2\u015f]\3\2\2\2\u0160\u0161"+
		"\7]\2\2\u0161_\3\2\2\2\u0162\u0163\7_\2\2\u0163a\3\2\2\2\u0164\u0165\7"+
		"-\2\2\u0165c\3\2\2\2\u0166\u0167\7/\2\2\u0167e\3\2\2\2\u0168\u0169\7,"+
		"\2\2\u0169g\3\2\2\2\u016a\u016b\7\61\2\2\u016bi\3\2\2\2\u016c\u016d\7"+
		"A\2\2\u016dk\3\2\2\2\u016e\u016f\7\'\2\2\u016fm\3\2\2\2\u0170\u0171\7"+
		"@\2\2\u0171o\3\2\2\2\u0172\u0173\7>\2\2\u0173q\3\2\2\2\u0174\u0175\7@"+
		"\2\2\u0175\u0176\7?\2\2\u0176s\3\2\2\2\u0177\u0178\7>\2\2\u0178\u0179"+
		"\7?\2\2\u0179u\3\2\2\2\u017a\u017b\7?\2\2\u017b\u017c\7?\2\2\u017cw\3"+
		"\2\2\2\u017d\u017e\7#\2\2\u017e\u017f\7?\2\2\u017fy\3\2\2\2\u0180\u0181"+
		"\7\u0080\2\2\u0181{\3\2\2\2\u0182\u0183\7(\2\2\u0183\u0184\7(\2\2\u0184"+
		"}\3\2\2\2\u0185\u0186\7~\2\2\u0186\u0187\7~\2\2\u0187\177\3\2\2\2\u0188"+
		"\u0189\7?\2\2\u0189\u0081\3\2\2\2\u018a\u018b\7>\2\2\u018b\u018c\7>\2"+
		"\2\u018c\u0083\3\2\2\2\u018d\u018e\7@\2\2\u018e\u018f\7@\2\2\u018f\u0085"+
		"\3\2\2\2\u0190\u0191\7B\2\2\u0191\u0087\3\2\2\2\u0192\u0193\t\3\2\2\u0193"+
		"\u0089\3\2\2\2\u0194\u019d\7\62\2\2\u0195\u0199\t\4\2\2\u0196\u0198\5"+
		"\u0088D\2\u0197\u0196\3\2\2\2\u0198\u019b\3\2\2\2\u0199\u0197\3\2\2\2"+
		"\u0199\u019a\3\2\2\2\u019a\u019d\3\2\2\2\u019b\u0199\3\2\2\2\u019c\u0194"+
		"\3\2\2\2\u019c\u0195\3\2\2\2\u019d\u008b\3\2\2\2\u019e\u01a5\5\u008aE"+
		"\2\u019f\u01a1\7\60\2\2\u01a0\u01a2\5\u0088D\2\u01a1\u01a0\3\2\2\2\u01a2"+
		"\u01a3\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a6\3\2"+
		"\2\2\u01a5\u019f\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01ac\3\2\2\2\u01a7"+
		"\u01a9\7G\2\2\u01a8\u01aa\t\5\2\2\u01a9\u01a8\3\2\2\2\u01a9\u01aa\3\2"+
		"\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ad\5\u008aE\2\u01ac\u01a7\3\2\2\2\u01ac"+
		"\u01ad\3\2\2\2\u01ad\u008d\3\2\2\2\u01ae\u01af\7)\2\2\u01af\u01b0\3\2"+
		"\2\2\u01b0\u01b1\bG\3\2\u01b1\u01b2\bG\4\2\u01b2\u008f\3\2\2\2\u01b3\u01b5"+
		"\n\6\2\2\u01b4\u01b3\3\2\2\2\u01b5\u01b8\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b6"+
		"\u01b7\3\2\2\2\u01b7\u01bd\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b9\u01ba\7\u0080"+
		"\2\2\u01ba\u01bb\n\7\2\2\u01bb\u01be\5\u0090H\2\u01bc\u01be\7)\2\2\u01bd"+
		"\u01b9\3\2\2\2\u01bd\u01bc\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c0\bH"+
		"\5\2\u01c0\u0091\3\2\2\2\20\2\3\u0139\u0142\u0153\u0155\u0199\u019c\u01a3"+
		"\u01a5\u01a9\u01ac\u01b6\u01bd\6\b\2\2\5\2\2\7\3\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}