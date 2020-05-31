// Generated from C:/Users/Кристина/IdeaProjects/ANTLRCW/src\ispr.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class isprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, VAR=24, BEGIN=25, 
		END=26, IF=27, THEN=28, WHILE=29, DO=30, PROCEDURE=31, CALL=32, BREAK=33, 
		CONTINUE=34, WRITE=35, STRING=36, NUMBER=37, BlockComment=38, LineComment=39, 
		WS=40;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "VAR", "BEGIN", 
			"END", "IF", "THEN", "WHILE", "DO", "PROCEDURE", "CALL", "BREAK", "CONTINUE", 
			"WRITE", "STRING", "NUMBER", "BlockComment", "LineComment", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'='", "';'", "':='", "'('", "')'", "'!'", "'AND'", "'OR'", 
			"'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'/'", "','", 
			"'''", "'char'", "'int'", "'float'", "'VAR'", "'BEGIN'", "'END'", "'IF'", 
			"'THEN'", "'WHILE'", "'DO'", "'PROCEDURE'", "'CALL'", "'BREAK'", "'CONTINUE'", 
			"'WRITE'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"VAR", "BEGIN", "END", "IF", "THEN", "WHILE", "DO", "PROCEDURE", "CALL", 
			"BREAK", "CONTINUE", "WRITE", "STRING", "NUMBER", "BlockComment", "LineComment", 
			"WS"
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


	public isprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ispr.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2*\u00fd\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\7%\u00d7\n%\f"+
		"%\16%\u00da\13%\3&\6&\u00dd\n&\r&\16&\u00de\3\'\3\'\3\'\3\'\7\'\u00e5"+
		"\n\'\f\'\16\'\u00e8\13\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\7(\u00f3\n(\f"+
		"(\16(\u00f6\13(\3(\3(\3)\3)\3)\3)\3\u00e6\2*\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*\3"+
		"\2\6\4\2C\\c|\3\2\62;\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u0100\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\3S\3\2\2\2\5U\3\2\2"+
		"\2\7W\3\2\2\2\tY\3\2\2\2\13\\\3\2\2\2\r^\3\2\2\2\17`\3\2\2\2\21b\3\2\2"+
		"\2\23f\3\2\2\2\25i\3\2\2\2\27l\3\2\2\2\31n\3\2\2\2\33q\3\2\2\2\35s\3\2"+
		"\2\2\37v\3\2\2\2!x\3\2\2\2#z\3\2\2\2%|\3\2\2\2\'~\3\2\2\2)\u0080\3\2\2"+
		"\2+\u0082\3\2\2\2-\u0087\3\2\2\2/\u008b\3\2\2\2\61\u0091\3\2\2\2\63\u0095"+
		"\3\2\2\2\65\u009b\3\2\2\2\67\u009f\3\2\2\29\u00a2\3\2\2\2;\u00a7\3\2\2"+
		"\2=\u00ad\3\2\2\2?\u00b0\3\2\2\2A\u00ba\3\2\2\2C\u00bf\3\2\2\2E\u00c5"+
		"\3\2\2\2G\u00ce\3\2\2\2I\u00d4\3\2\2\2K\u00dc\3\2\2\2M\u00e0\3\2\2\2O"+
		"\u00ee\3\2\2\2Q\u00f9\3\2\2\2ST\7\60\2\2T\4\3\2\2\2UV\7?\2\2V\6\3\2\2"+
		"\2WX\7=\2\2X\b\3\2\2\2YZ\7<\2\2Z[\7?\2\2[\n\3\2\2\2\\]\7*\2\2]\f\3\2\2"+
		"\2^_\7+\2\2_\16\3\2\2\2`a\7#\2\2a\20\3\2\2\2bc\7C\2\2cd\7P\2\2de\7F\2"+
		"\2e\22\3\2\2\2fg\7Q\2\2gh\7T\2\2h\24\3\2\2\2ij\7#\2\2jk\7?\2\2k\26\3\2"+
		"\2\2lm\7>\2\2m\30\3\2\2\2no\7>\2\2op\7?\2\2p\32\3\2\2\2qr\7@\2\2r\34\3"+
		"\2\2\2st\7@\2\2tu\7?\2\2u\36\3\2\2\2vw\7-\2\2w \3\2\2\2xy\7/\2\2y\"\3"+
		"\2\2\2z{\7,\2\2{$\3\2\2\2|}\7\61\2\2}&\3\2\2\2~\177\7.\2\2\177(\3\2\2"+
		"\2\u0080\u0081\7)\2\2\u0081*\3\2\2\2\u0082\u0083\7e\2\2\u0083\u0084\7"+
		"j\2\2\u0084\u0085\7c\2\2\u0085\u0086\7t\2\2\u0086,\3\2\2\2\u0087\u0088"+
		"\7k\2\2\u0088\u0089\7p\2\2\u0089\u008a\7v\2\2\u008a.\3\2\2\2\u008b\u008c"+
		"\7h\2\2\u008c\u008d\7n\2\2\u008d\u008e\7q\2\2\u008e\u008f\7c\2\2\u008f"+
		"\u0090\7v\2\2\u0090\60\3\2\2\2\u0091\u0092\7X\2\2\u0092\u0093\7C\2\2\u0093"+
		"\u0094\7T\2\2\u0094\62\3\2\2\2\u0095\u0096\7D\2\2\u0096\u0097\7G\2\2\u0097"+
		"\u0098\7I\2\2\u0098\u0099\7K\2\2\u0099\u009a\7P\2\2\u009a\64\3\2\2\2\u009b"+
		"\u009c\7G\2\2\u009c\u009d\7P\2\2\u009d\u009e\7F\2\2\u009e\66\3\2\2\2\u009f"+
		"\u00a0\7K\2\2\u00a0\u00a1\7H\2\2\u00a18\3\2\2\2\u00a2\u00a3\7V\2\2\u00a3"+
		"\u00a4\7J\2\2\u00a4\u00a5\7G\2\2\u00a5\u00a6\7P\2\2\u00a6:\3\2\2\2\u00a7"+
		"\u00a8\7Y\2\2\u00a8\u00a9\7J\2\2\u00a9\u00aa\7K\2\2\u00aa\u00ab\7N\2\2"+
		"\u00ab\u00ac\7G\2\2\u00ac<\3\2\2\2\u00ad\u00ae\7F\2\2\u00ae\u00af\7Q\2"+
		"\2\u00af>\3\2\2\2\u00b0\u00b1\7R\2\2\u00b1\u00b2\7T\2\2\u00b2\u00b3\7"+
		"Q\2\2\u00b3\u00b4\7E\2\2\u00b4\u00b5\7G\2\2\u00b5\u00b6\7F\2\2\u00b6\u00b7"+
		"\7W\2\2\u00b7\u00b8\7T\2\2\u00b8\u00b9\7G\2\2\u00b9@\3\2\2\2\u00ba\u00bb"+
		"\7E\2\2\u00bb\u00bc\7C\2\2\u00bc\u00bd\7N\2\2\u00bd\u00be\7N\2\2\u00be"+
		"B\3\2\2\2\u00bf\u00c0\7D\2\2\u00c0\u00c1\7T\2\2\u00c1\u00c2\7G\2\2\u00c2"+
		"\u00c3\7C\2\2\u00c3\u00c4\7M\2\2\u00c4D\3\2\2\2\u00c5\u00c6\7E\2\2\u00c6"+
		"\u00c7\7Q\2\2\u00c7\u00c8\7P\2\2\u00c8\u00c9\7V\2\2\u00c9\u00ca\7K\2\2"+
		"\u00ca\u00cb\7P\2\2\u00cb\u00cc\7W\2\2\u00cc\u00cd\7G\2\2\u00cdF\3\2\2"+
		"\2\u00ce\u00cf\7Y\2\2\u00cf\u00d0\7T\2\2\u00d0\u00d1\7K\2\2\u00d1\u00d2"+
		"\7V\2\2\u00d2\u00d3\7G\2\2\u00d3H\3\2\2\2\u00d4\u00d8\t\2\2\2\u00d5\u00d7"+
		"\t\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8"+
		"\u00d9\3\2\2\2\u00d9J\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dd\t\3\2\2"+
		"\u00dc\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df"+
		"\3\2\2\2\u00dfL\3\2\2\2\u00e0\u00e1\7\61\2\2\u00e1\u00e2\7,\2\2\u00e2"+
		"\u00e6\3\2\2\2\u00e3\u00e5\13\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e8\3"+
		"\2\2\2\u00e6\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e9\u00ea\7,\2\2\u00ea\u00eb\7\61\2\2\u00eb\u00ec\3\2"+
		"\2\2\u00ec\u00ed\b\'\2\2\u00edN\3\2\2\2\u00ee\u00ef\7\61\2\2\u00ef\u00f0"+
		"\7\61\2\2\u00f0\u00f4\3\2\2\2\u00f1\u00f3\n\4\2\2\u00f2\u00f1\3\2\2\2"+
		"\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f7"+
		"\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f8\b(\2\2\u00f8P\3\2\2\2\u00f9\u00fa"+
		"\t\5\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\b)\2\2\u00fcR\3\2\2\2\7\2\u00d8"+
		"\u00de\u00e6\u00f4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}