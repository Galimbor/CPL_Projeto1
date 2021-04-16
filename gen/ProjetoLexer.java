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
		KEYWORD_VOID=1, KEYWORD_SIZEOF=2, KEYWORD_NULL=3, KEYWORD_ALG=4, KEYWORD_TRUE=5, 
		KEYWORD_FALSE=6, KEYWORD_WHILE=7, KEYWORD_DO=8, KEYWORD_FINALLY=9, KEYWORD_LEAVE=10, 
		KEYWORD_RESTART=11, KEYWORD_RETURN=12, KEYWORD_IF=13, KEYWORD_THEN=14, 
		KEYWORD_ELSE=15, KEYWORD_WRITE=16, KEYWORD_WRITELN=17, POINTER=18, VARIABLE_TYPE=19, 
		NEWLINE=20, CARRIAGE_RETURN=21, BLANK=22, TAB=23, EXPLICATIVE=24, OPERATIONAL=25, 
		COMMA=26, SEMI_COLON=27, IDENTIFIER=28, LPAREN=29, RPAREN=30, LBLOCK=31, 
		RBLOCK=32, LBRACKET=33, RBRACKET=34, PLUS=35, MINUS=36, QUESTION=37, PERCENT=38, 
		GREATER=39, LESSER=40, GREATEQ=41, LESSEQ=42, EQUALS=43, NOTEQUALS=44, 
		TILT=45, AND=46, OR=47, EQUAL=48, INSERT=49, EXTRACT=50, AT=51, INTEGER=52, 
		REAL=53, STRING=54, START_STRING=55;
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
			"KEYWORD_WRITELN", "POINTER", "VARIABLE_TYPE", "NEWLINE", "CARRIAGE_RETURN", 
			"BLANK", "TAB", "DOUBLE_CARDINAL", "LOPERATIONAL", "ROPERATIONAL", "EXPLICATIVE", 
			"OPERATIONAL", "COMMA", "SEMI_COLON", "LETTER", "UNDERSCORE", "IDENTIFIER", 
			"LPAREN", "RPAREN", "LBLOCK", "RBLOCK", "LBRACKET", "RBRACKET", "PLUS", 
			"MINUS", "QUESTION", "PERCENT", "GREATER", "LESSER", "GREATEQ", "LESSEQ", 
			"EQUALS", "NOTEQUALS", "TILT", "AND", "OR", "EQUAL", "INSERT", "EXTRACT", 
			"AT", "DIGIT", "INTEGER", "REAL", "START_STRING", "STRING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'void'", "'sizeof'", "'null'", "'alg'", "'true'", "'false'", "'while'", 
			"'do'", "'finally'", "'leave'", "'restart'", "'return'", "'if'", "'then'", 
			"'else'", "'write'", "'writeln'", null, null, "'\n'", "'\r'", "' '", 
			"'\t'", null, null, "','", "';'", null, "'('", "')'", "'{'", "'}'", "'['", 
			"']'", "'+'", "'-'", "'?'", "'%'", "'>'", "'<'", "'>='", "'<='", "'=='", 
			"'!='", "'~'", "'&&'", "'||'", "'='", "'<<'", "'>>'", "'@'", null, null, 
			null, "'''"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KEYWORD_VOID", "KEYWORD_SIZEOF", "KEYWORD_NULL", "KEYWORD_ALG", 
			"KEYWORD_TRUE", "KEYWORD_FALSE", "KEYWORD_WHILE", "KEYWORD_DO", "KEYWORD_FINALLY", 
			"KEYWORD_LEAVE", "KEYWORD_RESTART", "KEYWORD_RETURN", "KEYWORD_IF", "KEYWORD_THEN", 
			"KEYWORD_ELSE", "KEYWORD_WRITE", "KEYWORD_WRITELN", "POINTER", "VARIABLE_TYPE", 
			"NEWLINE", "CARRIAGE_RETURN", "BLANK", "TAB", "EXPLICATIVE", "OPERATIONAL", 
			"COMMA", "SEMI_COLON", "IDENTIFIER", "LPAREN", "RPAREN", "LBLOCK", "RBLOCK", 
			"LBRACKET", "RBRACKET", "PLUS", "MINUS", "QUESTION", "PERCENT", "GREATER", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\29\u01a6\b\1\b\1\4"+
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
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\5\27\u0103\n\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\5\30\u010c\n\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \7 \u0121\n \f \16"+
		" \u0124\13 \3 \3 \3!\3!\7!\u012a\n!\f!\16!\u012d\13!\3!\3!\3\"\3\"\3#"+
		"\3#\3$\3$\3%\3%\3&\3&\3&\3&\7&\u013d\n&\f&\16&\u0140\13&\3\'\3\'\3(\3"+
		"(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3"+
		"\62\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3"+
		"\67\38\38\38\39\39\39\3:\3:\3;\3;\3;\3<\3<\3<\3=\3=\3>\3>\3?\3?\3?\7?"+
		"\u017d\n?\f?\16?\u0180\13?\5?\u0182\n?\3@\3@\3@\6@\u0187\n@\r@\16@\u0188"+
		"\5@\u018b\n@\3@\3@\5@\u018f\n@\3@\5@\u0192\n@\3A\3A\3A\3A\3A\3B\7B\u019a"+
		"\nB\fB\16B\u019d\13B\3B\3B\3B\3B\5B\u01a3\nB\3B\3B\4\u0122\u012b\2C\4"+
		"\2\6\2\b\2\n\2\f\3\16\4\20\5\22\6\24\7\26\b\30\t\32\n\34\13\36\f \r\""+
		"\16$\17&\20(\21*\22,\23.\24\60\25\62\26\64\27\66\308\31:\2<\2>\2@\32B"+
		"\33D\34F\35H\2J\2L\36N\37P R!T\"V#X$Z%\\&^\'`(b)d*f+h,j-l.n/p\60r\61t"+
		"\62v\63x\64z\65|\2~\66\u0080\67\u00829\u00848\4\2\3\b\5\2C\\c|\u0082\u0101"+
		"\3\2\62;\3\2\63;\4\2--//\5\2\2\2))\u0080\u0080\3\2\2\2\2\u01ae\2\f\3\2"+
		"\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2"+
		"\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3"+
		"\2\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2"+
		"\2\2\60\3\2\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2\28\3\2\2\2\2@\3"+
		"\2\2\2\2B\3\2\2\2\2D\3\2\2\2\2F\3\2\2\2\2L\3\2\2\2\2N\3\2\2\2\2P\3\2\2"+
		"\2\2R\3\2\2\2\2T\3\2\2\2\2V\3\2\2\2\2X\3\2\2\2\2Z\3\2\2\2\2\\\3\2\2\2"+
		"\2^\3\2\2\2\2`\3\2\2\2\2b\3\2\2\2\2d\3\2\2\2\2f\3\2\2\2\2h\3\2\2\2\2j"+
		"\3\2\2\2\2l\3\2\2\2\2n\3\2\2\2\2p\3\2\2\2\2r\3\2\2\2\2t\3\2\2\2\2v\3\2"+
		"\2\2\2x\3\2\2\2\2z\3\2\2\2\2~\3\2\2\2\2\u0080\3\2\2\2\2\u0082\3\2\2\2"+
		"\3\u0084\3\2\2\2\4\u0086\3\2\2\2\6\u008a\3\2\2\2\b\u008f\3\2\2\2\n\u0095"+
		"\3\2\2\2\f\u009c\3\2\2\2\16\u00a1\3\2\2\2\20\u00a8\3\2\2\2\22\u00ad\3"+
		"\2\2\2\24\u00b1\3\2\2\2\26\u00b6\3\2\2\2\30\u00bc\3\2\2\2\32\u00c2\3\2"+
		"\2\2\34\u00c5\3\2\2\2\36\u00cd\3\2\2\2 \u00d3\3\2\2\2\"\u00db\3\2\2\2"+
		"$\u00e2\3\2\2\2&\u00e5\3\2\2\2(\u00ea\3\2\2\2*\u00ef\3\2\2\2,\u00f5\3"+
		"\2\2\2.\u00fd\3\2\2\2\60\u010b\3\2\2\2\62\u010d\3\2\2\2\64\u010f\3\2\2"+
		"\2\66\u0111\3\2\2\28\u0113\3\2\2\2:\u0115\3\2\2\2<\u0118\3\2\2\2>\u011b"+
		"\3\2\2\2@\u011e\3\2\2\2B\u0127\3\2\2\2D\u0130\3\2\2\2F\u0132\3\2\2\2H"+
		"\u0134\3\2\2\2J\u0136\3\2\2\2L\u0138\3\2\2\2N\u0141\3\2\2\2P\u0143\3\2"+
		"\2\2R\u0145\3\2\2\2T\u0147\3\2\2\2V\u0149\3\2\2\2X\u014b\3\2\2\2Z\u014d"+
		"\3\2\2\2\\\u014f\3\2\2\2^\u0151\3\2\2\2`\u0153\3\2\2\2b\u0155\3\2\2\2"+
		"d\u0157\3\2\2\2f\u0159\3\2\2\2h\u015c\3\2\2\2j\u015f\3\2\2\2l\u0162\3"+
		"\2\2\2n\u0165\3\2\2\2p\u0167\3\2\2\2r\u016a\3\2\2\2t\u016d\3\2\2\2v\u016f"+
		"\3\2\2\2x\u0172\3\2\2\2z\u0175\3\2\2\2|\u0177\3\2\2\2~\u0181\3\2\2\2\u0080"+
		"\u0183\3\2\2\2\u0082\u0193\3\2\2\2\u0084\u019b\3\2\2\2\u0086\u0087\7k"+
		"\2\2\u0087\u0088\7p\2\2\u0088\u0089\7v\2\2\u0089\5\3\2\2\2\u008a\u008b"+
		"\7d\2\2\u008b\u008c\7q\2\2\u008c\u008d\7q\2\2\u008d\u008e\7n\2\2\u008e"+
		"\7\3\2\2\2\u008f\u0090\7h\2\2\u0090\u0091\7n\2\2\u0091\u0092\7q\2\2\u0092"+
		"\u0093\7c\2\2\u0093\u0094\7v\2\2\u0094\t\3\2\2\2\u0095\u0096\7u\2\2\u0096"+
		"\u0097\7v\2\2\u0097\u0098\7t\2\2\u0098\u0099\7k\2\2\u0099\u009a\7p\2\2"+
		"\u009a\u009b\7i\2\2\u009b\13\3\2\2\2\u009c\u009d\7x\2\2\u009d\u009e\7"+
		"q\2\2\u009e\u009f\7k\2\2\u009f\u00a0\7f\2\2\u00a0\r\3\2\2\2\u00a1\u00a2"+
		"\7u\2\2\u00a2\u00a3\7k\2\2\u00a3\u00a4\7|\2\2\u00a4\u00a5\7g\2\2\u00a5"+
		"\u00a6\7q\2\2\u00a6\u00a7\7h\2\2\u00a7\17\3\2\2\2\u00a8\u00a9\7p\2\2\u00a9"+
		"\u00aa\7w\2\2\u00aa\u00ab\7n\2\2\u00ab\u00ac\7n\2\2\u00ac\21\3\2\2\2\u00ad"+
		"\u00ae\7c\2\2\u00ae\u00af\7n\2\2\u00af\u00b0\7i\2\2\u00b0\23\3\2\2\2\u00b1"+
		"\u00b2\7v\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4\7w\2\2\u00b4\u00b5\7g\2\2"+
		"\u00b5\25\3\2\2\2\u00b6\u00b7\7h\2\2\u00b7\u00b8\7c\2\2\u00b8\u00b9\7"+
		"n\2\2\u00b9\u00ba\7u\2\2\u00ba\u00bb\7g\2\2\u00bb\27\3\2\2\2\u00bc\u00bd"+
		"\7y\2\2\u00bd\u00be\7j\2\2\u00be\u00bf\7k\2\2\u00bf\u00c0\7n\2\2\u00c0"+
		"\u00c1\7g\2\2\u00c1\31\3\2\2\2\u00c2\u00c3\7f\2\2\u00c3\u00c4\7q\2\2\u00c4"+
		"\33\3\2\2\2\u00c5\u00c6\7h\2\2\u00c6\u00c7\7k\2\2\u00c7\u00c8\7p\2\2\u00c8"+
		"\u00c9\7c\2\2\u00c9\u00ca\7n\2\2\u00ca\u00cb\7n\2\2\u00cb\u00cc\7{\2\2"+
		"\u00cc\35\3\2\2\2\u00cd\u00ce\7n\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0\7"+
		"c\2\2\u00d0\u00d1\7x\2\2\u00d1\u00d2\7g\2\2\u00d2\37\3\2\2\2\u00d3\u00d4"+
		"\7t\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6\7u\2\2\u00d6\u00d7\7v\2\2\u00d7"+
		"\u00d8\7c\2\2\u00d8\u00d9\7t\2\2\u00d9\u00da\7v\2\2\u00da!\3\2\2\2\u00db"+
		"\u00dc\7t\2\2\u00dc\u00dd\7g\2\2\u00dd\u00de\7v\2\2\u00de\u00df\7w\2\2"+
		"\u00df\u00e0\7t\2\2\u00e0\u00e1\7p\2\2\u00e1#\3\2\2\2\u00e2\u00e3\7k\2"+
		"\2\u00e3\u00e4\7h\2\2\u00e4%\3\2\2\2\u00e5\u00e6\7v\2\2\u00e6\u00e7\7"+
		"j\2\2\u00e7\u00e8\7g\2\2\u00e8\u00e9\7p\2\2\u00e9\'\3\2\2\2\u00ea\u00eb"+
		"\7g\2\2\u00eb\u00ec\7n\2\2\u00ec\u00ed\7u\2\2\u00ed\u00ee\7g\2\2\u00ee"+
		")\3\2\2\2\u00ef\u00f0\7y\2\2\u00f0\u00f1\7t\2\2\u00f1\u00f2\7k\2\2\u00f2"+
		"\u00f3\7v\2\2\u00f3\u00f4\7g\2\2\u00f4+\3\2\2\2\u00f5\u00f6\7y\2\2\u00f6"+
		"\u00f7\7t\2\2\u00f7\u00f8\7k\2\2\u00f8\u00f9\7v\2\2\u00f9\u00fa\7g\2\2"+
		"\u00fa\u00fb\7n\2\2\u00fb\u00fc\7p\2\2\u00fc-\3\2\2\2\u00fd\u0102\7>\2"+
		"\2\u00fe\u0103\5\4\2\2\u00ff\u0103\5\6\3\2\u0100\u0103\5\b\4\2\u0101\u0103"+
		"\5\n\5\2\u0102\u00fe\3\2\2\2\u0102\u00ff\3\2\2\2\u0102\u0100\3\2\2\2\u0102"+
		"\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\7@\2\2\u0105/\3\2\2\2\u0106"+
		"\u010c\5\4\2\2\u0107\u010c\5\6\3\2\u0108\u010c\5\b\4\2\u0109\u010c\5\n"+
		"\5\2\u010a\u010c\5.\27\2\u010b\u0106\3\2\2\2\u010b\u0107\3\2\2\2\u010b"+
		"\u0108\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010a\3\2\2\2\u010c\61\3\2\2"+
		"\2\u010d\u010e\7\f\2\2\u010e\63\3\2\2\2\u010f\u0110\7\17\2\2\u0110\65"+
		"\3\2\2\2\u0111\u0112\7\"\2\2\u0112\67\3\2\2\2\u0113\u0114\7\13\2\2\u0114"+
		"9\3\2\2\2\u0115\u0116\7%\2\2\u0116\u0117\7%\2\2\u0117;\3\2\2\2\u0118\u0119"+
		"\7*\2\2\u0119\u011a\7,\2\2\u011a=\3\2\2\2\u011b\u011c\7,\2\2\u011c\u011d"+
		"\7+\2\2\u011d?\3\2\2\2\u011e\u0122\5:\35\2\u011f\u0121\13\2\2\2\u0120"+
		"\u011f\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0123\3\2\2\2\u0122\u0120\3\2"+
		"\2\2\u0123\u0125\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u0126\5\62\31\2\u0126"+
		"A\3\2\2\2\u0127\u012b\5<\36\2\u0128\u012a\13\2\2\2\u0129\u0128\3\2\2\2"+
		"\u012a\u012d\3\2\2\2\u012b\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012e"+
		"\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u012f\5>\37\2\u012fC\3\2\2\2\u0130"+
		"\u0131\7.\2\2\u0131E\3\2\2\2\u0132\u0133\7=\2\2\u0133G\3\2\2\2\u0134\u0135"+
		"\t\2\2\2\u0135I\3\2\2\2\u0136\u0137\7a\2\2\u0137K\3\2\2\2\u0138\u013e"+
		"\5H$\2\u0139\u013d\5H$\2\u013a\u013d\5|>\2\u013b\u013d\5J%\2\u013c\u0139"+
		"\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013b\3\2\2\2\u013d\u0140\3\2\2\2\u013e"+
		"\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013fM\3\2\2\2\u0140\u013e\3\2\2\2"+
		"\u0141\u0142\7*\2\2\u0142O\3\2\2\2\u0143\u0144\7+\2\2\u0144Q\3\2\2\2\u0145"+
		"\u0146\7}\2\2\u0146S\3\2\2\2\u0147\u0148\7\177\2\2\u0148U\3\2\2\2\u0149"+
		"\u014a\7]\2\2\u014aW\3\2\2\2\u014b\u014c\7_\2\2\u014cY\3\2\2\2\u014d\u014e"+
		"\7-\2\2\u014e[\3\2\2\2\u014f\u0150\7/\2\2\u0150]\3\2\2\2\u0151\u0152\7"+
		"A\2\2\u0152_\3\2\2\2\u0153\u0154\7\'\2\2\u0154a\3\2\2\2\u0155\u0156\7"+
		"@\2\2\u0156c\3\2\2\2\u0157\u0158\7>\2\2\u0158e\3\2\2\2\u0159\u015a\7@"+
		"\2\2\u015a\u015b\7?\2\2\u015bg\3\2\2\2\u015c\u015d\7>\2\2\u015d\u015e"+
		"\7?\2\2\u015ei\3\2\2\2\u015f\u0160\7?\2\2\u0160\u0161\7?\2\2\u0161k\3"+
		"\2\2\2\u0162\u0163\7#\2\2\u0163\u0164\7?\2\2\u0164m\3\2\2\2\u0165\u0166"+
		"\7\u0080\2\2\u0166o\3\2\2\2\u0167\u0168\7(\2\2\u0168\u0169\7(\2\2\u0169"+
		"q\3\2\2\2\u016a\u016b\7~\2\2\u016b\u016c\7~\2\2\u016cs\3\2\2\2\u016d\u016e"+
		"\7?\2\2\u016eu\3\2\2\2\u016f\u0170\7>\2\2\u0170\u0171\7>\2\2\u0171w\3"+
		"\2\2\2\u0172\u0173\7@\2\2\u0173\u0174\7@\2\2\u0174y\3\2\2\2\u0175\u0176"+
		"\7B\2\2\u0176{\3\2\2\2\u0177\u0178\t\3\2\2\u0178}\3\2\2\2\u0179\u0182"+
		"\7\62\2\2\u017a\u017e\t\4\2\2\u017b\u017d\5|>\2\u017c\u017b\3\2\2\2\u017d"+
		"\u0180\3\2\2\2\u017e\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0182\3\2"+
		"\2\2\u0180\u017e\3\2\2\2\u0181\u0179\3\2\2\2\u0181\u017a\3\2\2\2\u0182"+
		"\177\3\2\2\2\u0183\u018a\5~?\2\u0184\u0186\7\60\2\2\u0185\u0187\5|>\2"+
		"\u0186\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0186\3\2\2\2\u0188\u0189"+
		"\3\2\2\2\u0189\u018b\3\2\2\2\u018a\u0184\3\2\2\2\u018a\u018b\3\2\2\2\u018b"+
		"\u0191\3\2\2\2\u018c\u018e\7G\2\2\u018d\u018f\t\5\2\2\u018e\u018d\3\2"+
		"\2\2\u018e\u018f\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0192\5~?\2\u0191\u018c"+
		"\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0081\3\2\2\2\u0193\u0194\7)\2\2\u0194"+
		"\u0195\3\2\2\2\u0195\u0196\bA\2\2\u0196\u0197\bA\3\2\u0197\u0083\3\2\2"+
		"\2\u0198\u019a\n\6\2\2\u0199\u0198\3\2\2\2\u019a\u019d\3\2\2\2\u019b\u0199"+
		"\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u01a2\3\2\2\2\u019d\u019b\3\2\2\2\u019e"+
		"\u019f\7\u0080\2\2\u019f\u01a0\n\7\2\2\u01a0\u01a3\5\u0084B\2\u01a1\u01a3"+
		"\7)\2\2\u01a2\u019e\3\2\2\2\u01a2\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4"+
		"\u01a5\bB\4\2\u01a5\u0085\3\2\2\2\22\2\3\u0102\u010b\u0122\u012b\u013c"+
		"\u013e\u017e\u0181\u0188\u018a\u018e\u0191\u019b\u01a2\5\5\2\2\7\3\2\6"+
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