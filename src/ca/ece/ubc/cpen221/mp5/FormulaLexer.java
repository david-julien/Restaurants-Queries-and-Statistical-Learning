// Generated from Formula.g4 by ANTLR 4.4

package ca.ece.ubc.cpen221.mp5;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormulaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OR=1, AND=2, LPAREN=3, RPAREN=4, IN_CONST=5, CATEGORY_CONST=6, NAME_CONST=7, 
		RATING_CONST=8, PRICE_CONST=9, STRING=10, RANGE=11, WHITESPACE=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'"
	};
	public static final String[] ruleNames = {
		"OR", "AND", "LPAREN", "RPAREN", "IN_CONST", "CATEGORY_CONST", "NAME_CONST", 
		"RATING_CONST", "PRICE_CONST", "STRING", "RANGE", "WHITESPACE"
	};


	    // This method makes the lexer or parser stop running if it encounters
	    // invalid input and throw a RuntimeException.
	    public void reportErrorsAsExceptions() {
	        //removeErrorListeners();
	        
	        addErrorListener(new ExceptionThrowingErrorListener());
	    }
	    
	    private static class ExceptionThrowingErrorListener extends BaseErrorListener {
	        @Override
	        public void syntaxError(Recognizer<?, ?> recognizer,
	                Object offendingSymbol, int line, int charPositionInLine,
	                String msg, RecognitionException e) {
	            throw new RuntimeException(msg);
	        }
	    }


	public FormulaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Formula.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\16X\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\6\13F\n\13\r\13\16"+
		"\13G\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\6\rS\n\r\r\r\16\rT\3\r\3\r"+
		"\2\2\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\3\2\5"+
		"\6\2\"\"\62;C\\c|\3\2\63\67\5\2\13\f\17\17\"\"Y\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2"+
		"\2\2\5\36\3\2\2\2\7!\3\2\2\2\t#\3\2\2\2\13%\3\2\2\2\r(\3\2\2\2\17\61\3"+
		"\2\2\2\21\66\3\2\2\2\23=\3\2\2\2\25C\3\2\2\2\27K\3\2\2\2\31R\3\2\2\2\33"+
		"\34\7~\2\2\34\35\7~\2\2\35\4\3\2\2\2\36\37\7(\2\2\37 \7(\2\2 \6\3\2\2"+
		"\2!\"\7*\2\2\"\b\3\2\2\2#$\7+\2\2$\n\3\2\2\2%&\7k\2\2&\'\7p\2\2\'\f\3"+
		"\2\2\2()\7e\2\2)*\7c\2\2*+\7v\2\2+,\7g\2\2,-\7i\2\2-.\7q\2\2./\7t\2\2"+
		"/\60\7{\2\2\60\16\3\2\2\2\61\62\7p\2\2\62\63\7c\2\2\63\64\7o\2\2\64\65"+
		"\7g\2\2\65\20\3\2\2\2\66\67\7t\2\2\678\7c\2\289\7v\2\29:\7k\2\2:;\7p\2"+
		"\2;<\7i\2\2<\22\3\2\2\2=>\7r\2\2>?\7t\2\2?@\7k\2\2@A\7e\2\2AB\7g\2\2B"+
		"\24\3\2\2\2CE\7$\2\2DF\t\2\2\2ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2"+
		"HI\3\2\2\2IJ\7$\2\2J\26\3\2\2\2KL\t\3\2\2LM\7\60\2\2MN\7\60\2\2NO\3\2"+
		"\2\2OP\t\3\2\2P\30\3\2\2\2QS\t\4\2\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3"+
		"\2\2\2UV\3\2\2\2VW\b\r\2\2W\32\3\2\2\2\6\2EGT\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}