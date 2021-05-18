// Generated from /home/artur/Documents/Faculdade/Compiladores/Prática/G23_Projeto1/ProjetoLexer.g4 by ANTLR 4.9.1
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
		BOOL_POINTER=1, INT_POINTER=2, FLOAT_POINTER=3, STRING_POINTER=4, INT=5, 
		BOOL=6, FLOAT=7, STRING=8, VOID=9, SIZEOF=10, NULL=11, ALG=12, TRUE=13, 
		FALSE=14, WHILE=15, DO=16, FINALLY=17, LEAVE=18, RESTART=19, RETURN=20, 
		IF=21, THEN=22, ELSE=23, WRITE=24, WRITELN=25, NEWLINE=26, CARRIAGE_RETURN=27, 
		BLANK=28, TAB=29, EXPLICATIVE=30, OPERATIONAL=31, COMMA=32, SEMI_COLON=33, 
		IDENTIFIER=34, LPAREN=35, RPAREN=36, LBLOCK=37, RBLOCK=38, LBRACKET=39, 
		RBRACKET=40, ADD=41, SUB=42, MUL=43, DIV=44, QUESTION=45, PERCENT=46, 
		GREATER=47, LESSER=48, GREATEQ=49, LESSEQ=50, EQUALS=51, NOTEQUALS=52, 
		TILT=53, AND=54, OR=55, EQUAL=56, INSERT=57, EXTRACT=58, AT=59, INTEGER=60, 
		REAL=61, STRING_=62, START_STRING=63;
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
			"BOOL_POINTER", "INT_POINTER", "FLOAT_POINTER", "STRING_POINTER", "INT", 
			"BOOL", "FLOAT", "STRING", "VOID", "SIZEOF", "NULL", "ALG", "TRUE", "FALSE", 
			"WHILE", "DO", "FINALLY", "LEAVE", "RESTART", "RETURN", "IF", "THEN", 
			"ELSE", "WRITE", "WRITELN", "NEWLINE", "CARRIAGE_RETURN", "BLANK", "TAB", 
			"DOUBLE_CARDINAL", "LOPERATIONAL", "ROPERATIONAL", "EXPLICATIVE", "OPERATIONAL", 
			"COMMA", "SEMI_COLON", "LETTER", "UNDERSCORE", "IDENTIFIER", "LPAREN", 
			"RPAREN", "LBLOCK", "RBLOCK", "LBRACKET", "RBRACKET", "ADD", "SUB", "MUL", 
			"DIV", "QUESTION", "PERCENT", "GREATER", "LESSER", "GREATEQ", "LESSEQ", 
			"EQUALS", "NOTEQUALS", "TILT", "AND", "OR", "EQUAL", "INSERT", "EXTRACT", 
			"AT", "DIGIT", "INTEGER", "REAL", "START_STRING", "STRING_"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'int'", "'bool'", "'float'", "'string'", 
			"'void'", "'sizeof'", "'null'", "'alg'", "'true'", "'false'", "'while'", 
			"'do'", "'finally'", "'leave'", "'restart'", "'return'", "'if'", "'then'", 
			"'else'", "'write'", "'writeln'", "'\n'", "'\r'", "' '", "'\t'", null, 
			null, "','", "';'", null, "'('", "')'", "'{'", "'}'", "'['", "']'", "'+'", 
			"'-'", "'*'", "'/'", "'?'", "'%'", "'>'", "'<'", "'>='", "'<='", "'=='", 
			"'!='", "'~'", "'&&'", "'||'", "'='", "'<<'", "'>>'", "'@'", null, null, 
			null, "'''"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BOOL_POINTER", "INT_POINTER", "FLOAT_POINTER", "STRING_POINTER", 
			"INT", "BOOL", "FLOAT", "STRING", "VOID", "SIZEOF", "NULL", "ALG", "TRUE", 
			"FALSE", "WHILE", "DO", "FINALLY", "LEAVE", "RESTART", "RETURN", "IF", 
			"THEN", "ELSE", "WRITE", "WRITELN", "NEWLINE", "CARRIAGE_RETURN", "BLANK", 
			"TAB", "EXPLICATIVE", "OPERATIONAL", "COMMA", "SEMI_COLON", "IDENTIFIER", 
			"LPAREN", "RPAREN", "LBLOCK", "RBLOCK", "LBRACKET", "RBRACKET", "ADD", 
			"SUB", "MUL", "DIV", "QUESTION", "PERCENT", "GREATER", "LESSER", "GREATEQ", 
			"LESSEQ", "EQUALS", "NOTEQUALS", "TILT", "AND", "OR", "EQUAL", "INSERT", 
			"EXTRACT", "AT", "INTEGER", "REAL", "STRING_", "START_STRING"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2A\u01b6\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3"+
		"!\3!\3\"\3\"\7\"\u012d\n\"\f\"\16\"\u0130\13\"\3\"\3\"\3#\3#\7#\u0136"+
		"\n#\f#\16#\u0139\13#\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3(\7(\u0149"+
		"\n(\f(\16(\u014c\13(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3"+
		"\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3"+
		"\67\3\67\38\38\38\39\39\39\3:\3:\3:\3;\3;\3<\3<\3<\3=\3=\3=\3>\3>\3?\3"+
		"?\3?\3@\3@\3@\3A\3A\3B\3B\3C\3C\3C\7C\u018d\nC\fC\16C\u0190\13C\5C\u0192"+
		"\nC\3D\3D\3D\6D\u0197\nD\rD\16D\u0198\5D\u019b\nD\3D\3D\5D\u019f\nD\3"+
		"D\5D\u01a2\nD\3E\3E\3E\3E\3E\3F\7F\u01aa\nF\fF\16F\u01ad\13F\3F\3F\3F"+
		"\3F\5F\u01b3\nF\3F\3F\4\u012e\u0137\2G\4\3\6\4\b\5\n\6\f\7\16\b\20\t\22"+
		"\n\24\13\26\f\30\r\32\16\34\17\36\20 \21\"\22$\23&\24(\25*\26,\27.\30"+
		"\60\31\62\32\64\33\66\348\35:\36<\37>\2@\2B\2D F!H\"J#L\2N\2P$R%T&V\'"+
		"X(Z)\\*^+`,b-d.f/h\60j\61l\62n\63p\64r\65t\66v\67x8z9|:~;\u0080<\u0082"+
		"=\u0084\2\u0086>\u0088?\u008aA\u008c@\4\2\3\b\5\2C\\c|\u0082\u0101\3\2"+
		"\62;\3\2\63;\4\2--//\5\2\2\2))\u0080\u0080\3\2\2\2\2\u01bb\2\4\3\2\2\2"+
		"\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2"+
		"\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2"+
		"\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2"+
		"\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2"+
		"\2\2\64\3\2\2\2\2\66\3\2\2\2\28\3\2\2\2\2:\3\2\2\2\2<\3\2\2\2\2D\3\2\2"+
		"\2\2F\3\2\2\2\2H\3\2\2\2\2J\3\2\2\2\2P\3\2\2\2\2R\3\2\2\2\2T\3\2\2\2\2"+
		"V\3\2\2\2\2X\3\2\2\2\2Z\3\2\2\2\2\\\3\2\2\2\2^\3\2\2\2\2`\3\2\2\2\2b\3"+
		"\2\2\2\2d\3\2\2\2\2f\3\2\2\2\2h\3\2\2\2\2j\3\2\2\2\2l\3\2\2\2\2n\3\2\2"+
		"\2\2p\3\2\2\2\2r\3\2\2\2\2t\3\2\2\2\2v\3\2\2\2\2x\3\2\2\2\2z\3\2\2\2\2"+
		"|\3\2\2\2\2~\3\2\2\2\2\u0080\3\2\2\2\2\u0082\3\2\2\2\2\u0086\3\2\2\2\2"+
		"\u0088\3\2\2\2\2\u008a\3\2\2\2\3\u008c\3\2\2\2\4\u008e\3\2\2\2\6\u0092"+
		"\3\2\2\2\b\u0096\3\2\2\2\n\u009a\3\2\2\2\f\u009e\3\2\2\2\16\u00a2\3\2"+
		"\2\2\20\u00a7\3\2\2\2\22\u00ad\3\2\2\2\24\u00b4\3\2\2\2\26\u00b9\3\2\2"+
		"\2\30\u00c0\3\2\2\2\32\u00c5\3\2\2\2\34\u00c9\3\2\2\2\36\u00ce\3\2\2\2"+
		" \u00d4\3\2\2\2\"\u00da\3\2\2\2$\u00dd\3\2\2\2&\u00e5\3\2\2\2(\u00eb\3"+
		"\2\2\2*\u00f3\3\2\2\2,\u00fa\3\2\2\2.\u00fd\3\2\2\2\60\u0102\3\2\2\2\62"+
		"\u0107\3\2\2\2\64\u010d\3\2\2\2\66\u0115\3\2\2\28\u0119\3\2\2\2:\u011b"+
		"\3\2\2\2<\u011f\3\2\2\2>\u0121\3\2\2\2@\u0124\3\2\2\2B\u0127\3\2\2\2D"+
		"\u012a\3\2\2\2F\u0133\3\2\2\2H\u013c\3\2\2\2J\u013e\3\2\2\2L\u0140\3\2"+
		"\2\2N\u0142\3\2\2\2P\u0144\3\2\2\2R\u014d\3\2\2\2T\u014f\3\2\2\2V\u0151"+
		"\3\2\2\2X\u0153\3\2\2\2Z\u0155\3\2\2\2\\\u0157\3\2\2\2^\u0159\3\2\2\2"+
		"`\u015b\3\2\2\2b\u015d\3\2\2\2d\u015f\3\2\2\2f\u0161\3\2\2\2h\u0163\3"+
		"\2\2\2j\u0165\3\2\2\2l\u0167\3\2\2\2n\u0169\3\2\2\2p\u016c\3\2\2\2r\u016f"+
		"\3\2\2\2t\u0172\3\2\2\2v\u0175\3\2\2\2x\u0177\3\2\2\2z\u017a\3\2\2\2|"+
		"\u017d\3\2\2\2~\u017f\3\2\2\2\u0080\u0182\3\2\2\2\u0082\u0185\3\2\2\2"+
		"\u0084\u0187\3\2\2\2\u0086\u0191\3\2\2\2\u0088\u0193\3\2\2\2\u008a\u01a3"+
		"\3\2\2\2\u008c\u01ab\3\2\2\2\u008e\u008f\7>\2\2\u008f\u0090\5\16\7\2\u0090"+
		"\u0091\7@\2\2\u0091\5\3\2\2\2\u0092\u0093\7>\2\2\u0093\u0094\5\f\6\2\u0094"+
		"\u0095\7@\2\2\u0095\7\3\2\2\2\u0096\u0097\7>\2\2\u0097\u0098\5\20\b\2"+
		"\u0098\u0099\7@\2\2\u0099\t\3\2\2\2\u009a\u009b\7>\2\2\u009b\u009c\5\22"+
		"\t\2\u009c\u009d\7@\2\2\u009d\13\3\2\2\2\u009e\u009f\7k\2\2\u009f\u00a0"+
		"\7p\2\2\u00a0\u00a1\7v\2\2\u00a1\r\3\2\2\2\u00a2\u00a3\7d\2\2\u00a3\u00a4"+
		"\7q\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7n\2\2\u00a6\17\3\2\2\2\u00a7\u00a8"+
		"\7h\2\2\u00a8\u00a9\7n\2\2\u00a9\u00aa\7q\2\2\u00aa\u00ab\7c\2\2\u00ab"+
		"\u00ac\7v\2\2\u00ac\21\3\2\2\2\u00ad\u00ae\7u\2\2\u00ae\u00af\7v\2\2\u00af"+
		"\u00b0\7t\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7p\2\2\u00b2\u00b3\7i\2\2"+
		"\u00b3\23\3\2\2\2\u00b4\u00b5\7x\2\2\u00b5\u00b6\7q\2\2\u00b6\u00b7\7"+
		"k\2\2\u00b7\u00b8\7f\2\2\u00b8\25\3\2\2\2\u00b9\u00ba\7u\2\2\u00ba\u00bb"+
		"\7k\2\2\u00bb\u00bc\7|\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be\7q\2\2\u00be"+
		"\u00bf\7h\2\2\u00bf\27\3\2\2\2\u00c0\u00c1\7p\2\2\u00c1\u00c2\7w\2\2\u00c2"+
		"\u00c3\7n\2\2\u00c3\u00c4\7n\2\2\u00c4\31\3\2\2\2\u00c5\u00c6\7c\2\2\u00c6"+
		"\u00c7\7n\2\2\u00c7\u00c8\7i\2\2\u00c8\33\3\2\2\2\u00c9\u00ca\7v\2\2\u00ca"+
		"\u00cb\7t\2\2\u00cb\u00cc\7w\2\2\u00cc\u00cd\7g\2\2\u00cd\35\3\2\2\2\u00ce"+
		"\u00cf\7h\2\2\u00cf\u00d0\7c\2\2\u00d0\u00d1\7n\2\2\u00d1\u00d2\7u\2\2"+
		"\u00d2\u00d3\7g\2\2\u00d3\37\3\2\2\2\u00d4\u00d5\7y\2\2\u00d5\u00d6\7"+
		"j\2\2\u00d6\u00d7\7k\2\2\u00d7\u00d8\7n\2\2\u00d8\u00d9\7g\2\2\u00d9!"+
		"\3\2\2\2\u00da\u00db\7f\2\2\u00db\u00dc\7q\2\2\u00dc#\3\2\2\2\u00dd\u00de"+
		"\7h\2\2\u00de\u00df\7k\2\2\u00df\u00e0\7p\2\2\u00e0\u00e1\7c\2\2\u00e1"+
		"\u00e2\7n\2\2\u00e2\u00e3\7n\2\2\u00e3\u00e4\7{\2\2\u00e4%\3\2\2\2\u00e5"+
		"\u00e6\7n\2\2\u00e6\u00e7\7g\2\2\u00e7\u00e8\7c\2\2\u00e8\u00e9\7x\2\2"+
		"\u00e9\u00ea\7g\2\2\u00ea\'\3\2\2\2\u00eb\u00ec\7t\2\2\u00ec\u00ed\7g"+
		"\2\2\u00ed\u00ee\7u\2\2\u00ee\u00ef\7v\2\2\u00ef\u00f0\7c\2\2\u00f0\u00f1"+
		"\7t\2\2\u00f1\u00f2\7v\2\2\u00f2)\3\2\2\2\u00f3\u00f4\7t\2\2\u00f4\u00f5"+
		"\7g\2\2\u00f5\u00f6\7v\2\2\u00f6\u00f7\7w\2\2\u00f7\u00f8\7t\2\2\u00f8"+
		"\u00f9\7p\2\2\u00f9+\3\2\2\2\u00fa\u00fb\7k\2\2\u00fb\u00fc\7h\2\2\u00fc"+
		"-\3\2\2\2\u00fd\u00fe\7v\2\2\u00fe\u00ff\7j\2\2\u00ff\u0100\7g\2\2\u0100"+
		"\u0101\7p\2\2\u0101/\3\2\2\2\u0102\u0103\7g\2\2\u0103\u0104\7n\2\2\u0104"+
		"\u0105\7u\2\2\u0105\u0106\7g\2\2\u0106\61\3\2\2\2\u0107\u0108\7y\2\2\u0108"+
		"\u0109\7t\2\2\u0109\u010a\7k\2\2\u010a\u010b\7v\2\2\u010b\u010c\7g\2\2"+
		"\u010c\63\3\2\2\2\u010d\u010e\7y\2\2\u010e\u010f\7t\2\2\u010f\u0110\7"+
		"k\2\2\u0110\u0111\7v\2\2\u0111\u0112\7g\2\2\u0112\u0113\7n\2\2\u0113\u0114"+
		"\7p\2\2\u0114\65\3\2\2\2\u0115\u0116\7\f\2\2\u0116\u0117\3\2\2\2\u0117"+
		"\u0118\b\33\2\2\u0118\67\3\2\2\2\u0119\u011a\7\17\2\2\u011a9\3\2\2\2\u011b"+
		"\u011c\7\"\2\2\u011c\u011d\3\2\2\2\u011d\u011e\b\35\2\2\u011e;\3\2\2\2"+
		"\u011f\u0120\7\13\2\2\u0120=\3\2\2\2\u0121\u0122\7%\2\2\u0122\u0123\7"+
		"%\2\2\u0123?\3\2\2\2\u0124\u0125\7*\2\2\u0125\u0126\7,\2\2\u0126A\3\2"+
		"\2\2\u0127\u0128\7,\2\2\u0128\u0129\7+\2\2\u0129C\3\2\2\2\u012a\u012e"+
		"\5>\37\2\u012b\u012d\13\2\2\2\u012c\u012b\3\2\2\2\u012d\u0130\3\2\2\2"+
		"\u012e\u012f\3\2\2\2\u012e\u012c\3\2\2\2\u012f\u0131\3\2\2\2\u0130\u012e"+
		"\3\2\2\2\u0131\u0132\5\66\33\2\u0132E\3\2\2\2\u0133\u0137\5@ \2\u0134"+
		"\u0136\13\2\2\2\u0135\u0134\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0138\3"+
		"\2\2\2\u0137\u0135\3\2\2\2\u0138\u013a\3\2\2\2\u0139\u0137\3\2\2\2\u013a"+
		"\u013b\5B!\2\u013bG\3\2\2\2\u013c\u013d\7.\2\2\u013dI\3\2\2\2\u013e\u013f"+
		"\7=\2\2\u013fK\3\2\2\2\u0140\u0141\t\2\2\2\u0141M\3\2\2\2\u0142\u0143"+
		"\7a\2\2\u0143O\3\2\2\2\u0144\u014a\5L&\2\u0145\u0149\5L&\2\u0146\u0149"+
		"\5\u0084B\2\u0147\u0149\5N\'\2\u0148\u0145\3\2\2\2\u0148\u0146\3\2\2\2"+
		"\u0148\u0147\3\2\2\2\u0149\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b"+
		"\3\2\2\2\u014bQ\3\2\2\2\u014c\u014a\3\2\2\2\u014d\u014e\7*\2\2\u014eS"+
		"\3\2\2\2\u014f\u0150\7+\2\2\u0150U\3\2\2\2\u0151\u0152\7}\2\2\u0152W\3"+
		"\2\2\2\u0153\u0154\7\177\2\2\u0154Y\3\2\2\2\u0155\u0156\7]\2\2\u0156["+
		"\3\2\2\2\u0157\u0158\7_\2\2\u0158]\3\2\2\2\u0159\u015a\7-\2\2\u015a_\3"+
		"\2\2\2\u015b\u015c\7/\2\2\u015ca\3\2\2\2\u015d\u015e\7,\2\2\u015ec\3\2"+
		"\2\2\u015f\u0160\7\61\2\2\u0160e\3\2\2\2\u0161\u0162\7A\2\2\u0162g\3\2"+
		"\2\2\u0163\u0164\7\'\2\2\u0164i\3\2\2\2\u0165\u0166\7@\2\2\u0166k\3\2"+
		"\2\2\u0167\u0168\7>\2\2\u0168m\3\2\2\2\u0169\u016a\7@\2\2\u016a\u016b"+
		"\7?\2\2\u016bo\3\2\2\2\u016c\u016d\7>\2\2\u016d\u016e\7?\2\2\u016eq\3"+
		"\2\2\2\u016f\u0170\7?\2\2\u0170\u0171\7?\2\2\u0171s\3\2\2\2\u0172\u0173"+
		"\7#\2\2\u0173\u0174\7?\2\2\u0174u\3\2\2\2\u0175\u0176\7\u0080\2\2\u0176"+
		"w\3\2\2\2\u0177\u0178\7(\2\2\u0178\u0179\7(\2\2\u0179y\3\2\2\2\u017a\u017b"+
		"\7~\2\2\u017b\u017c\7~\2\2\u017c{\3\2\2\2\u017d\u017e\7?\2\2\u017e}\3"+
		"\2\2\2\u017f\u0180\7>\2\2\u0180\u0181\7>\2\2\u0181\177\3\2\2\2\u0182\u0183"+
		"\7@\2\2\u0183\u0184\7@\2\2\u0184\u0081\3\2\2\2\u0185\u0186\7B\2\2\u0186"+
		"\u0083\3\2\2\2\u0187\u0188\t\3\2\2\u0188\u0085\3\2\2\2\u0189\u0192\7\62"+
		"\2\2\u018a\u018e\t\4\2\2\u018b\u018d\5\u0084B\2\u018c\u018b\3\2\2\2\u018d"+
		"\u0190\3\2\2\2\u018e\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0192\3\2"+
		"\2\2\u0190\u018e\3\2\2\2\u0191\u0189\3\2\2\2\u0191\u018a\3\2\2\2\u0192"+
		"\u0087\3\2\2\2\u0193\u019a\5\u0086C\2\u0194\u0196\7\60\2\2\u0195\u0197"+
		"\5\u0084B\2\u0196\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u0196\3\2\2"+
		"\2\u0198\u0199\3\2\2\2\u0199\u019b\3\2\2\2\u019a\u0194\3\2\2\2\u019a\u019b"+
		"\3\2\2\2\u019b\u01a1\3\2\2\2\u019c\u019e\7G\2\2\u019d\u019f\t\5\2\2\u019e"+
		"\u019d\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a2\5\u0086"+
		"C\2\u01a1\u019c\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u0089\3\2\2\2\u01a3"+
		"\u01a4\7)\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\bE\3\2\u01a6\u01a7\bE\4"+
		"\2\u01a7\u008b\3\2\2\2\u01a8\u01aa\n\6\2\2\u01a9\u01a8\3\2\2\2\u01aa\u01ad"+
		"\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01b2\3\2\2\2\u01ad"+
		"\u01ab\3\2\2\2\u01ae\u01af\7\u0080\2\2\u01af\u01b0\n\7\2\2\u01b0\u01b3"+
		"\5\u008cF\2\u01b1\u01b3\7)\2\2\u01b2\u01ae\3\2\2\2\u01b2\u01b1\3\2\2\2"+
		"\u01b3\u01b4\3\2\2\2\u01b4\u01b5\bF\5\2\u01b5\u008d\3\2\2\2\20\2\3\u012e"+
		"\u0137\u0148\u014a\u018e\u0191\u0198\u019a\u019e\u01a1\u01ab\u01b2\6\b"+
		"\2\2\5\2\2\7\3\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}