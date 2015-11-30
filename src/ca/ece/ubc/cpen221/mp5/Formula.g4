grammar Formula;

// This puts "package formula;" at the top of the output Java files.
@header {
package ca.ece.ubc.cpen221.mp5;
}

// This adds code to the generated lexer and parser. Do not change these lines.
@members {
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
}

/*
 * These are the lexical rules. They define the tokens used by the lexer.
 *   *** Antlr requires tokens to be CAPITALIZED, like START_ITALIC, END_ITALIC, and TEXT.
 */
 
OR : '||';
AND : '&&';
LPAREN : '(';
RPAREN : ')';
IN_CONST : 'in';
CATEGORY_CONST : 'category';
NAME_CONST : 'name';
RATING_CONST : 'rating';
PRICE_CONST : 'price';
STRING : '"' ( [a-z] | [A-Z] | [0-9] | [ ] )+ '"';
RANGE : [1-5] '..' [1-5];
WHITESPACE : [ \t\r\n]+ -> skip ;

/*
 * These are the parser rules. They define the structures used by the parser.
 *    *** Antlr requires grammar nonterminals to be lowercase, like html, normal, and italic.
 */

root : orexpr | andexpr | atom EOF;
orexpr : andexpr ( OR andexpr )*;
andexpr : atom ( AND atom )*;
atom : in | category | rating | price | name | LPAREN orexpr RPAREN;
in : IN_CONST LPAREN STRING RPAREN;
category : CATEGORY_CONST LPAREN STRING RPAREN;
name : NAME_CONST LPAREN STRING RPAREN;
rating : RATING_CONST LPAREN RANGE RPAREN;
price : PRICE_CONST LPAREN RANGE RPAREN;
