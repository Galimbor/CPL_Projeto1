lexer grammar ProjetoLexer;


/* KEYWORDS*/
KEYWORD_INT : 'int' ;
KEYWORD_BOOL : 'bool';
KEYWORD_FLOAT : 'float';
KEYWORD_STRING: 'string';
KEYWORD_VOID: 'void';
KEYWORD_SIZEOF: 'sizeof';
KEYWORD_NULL: 'null';
KEYWORD_ALG: 'alg';
KEYWORD_TRUE: 'true';
KEYWORD_FALSE: 'false';
KEYWORD_WHILE: 'while';
KEYWORD_DO: 'do';
KEYWORD_FINALLY: 'finally';
KEYWORD_LEAVE: 'leave';
KEYWORD_RESTART: 'restart';
KEYWORD_RETURN: 'return';
KEYWORD_IF: 'if';
KEYWORD_THEN : 'then';
KEYWORD_ELSE: 'else';
KEYWORD_WRITE: 'write';
KEYWORD_WRITELN : 'writeln';



/* WHITESPACE */
fragment NEWLINE : '\n';
fragment CARRIAGE_RETURN: '\r';
fragment BLANK: ' ';
fragment TAB: '\t';

WHITESPACE: (NEWLINE | CARRIAGE_RETURN | BLANK | TAB) -> skip;

/* COMMENTS */

fragment DOUBLE_CARDINAL : '##';
fragment LOPERATIONAL : '(*';
fragment ROPERATIONAL : '*)';

EXPLICATIVE : DOUBLE_CARDINAL.*?NEWLINE;
OPERATIONAL : LOPERATIONAL.*?ROPERATIONAL;


/* TERMINATORS */

COMMA : ',';
SEMI_COLON : ';';


/* INDENTIFIERS */
fragment LETTER : [a-zA-Z\u0080-\u00FF];
fragment UNDERSCORE : '_';

IDENTIFIER : LETTER(LETTER| DIGIT | UNDERSCORE)*;


/* OTHERS */
LPAREN : '(';
RPAREN : ')';
LBRACKET : '[';
RBRACKET : ']';
PLUS : '+';
MINUS : '-';
QUESTION : '?';
PERCENT : '%';
GREATER : '>';
LESSER : '<';
GREATEQ : '>=';
LESSEQ : '<=';
EQUALS : '==';
NOTEQUALS: '!=';
TILT : '~';
AND : '&&';
OR : '||';
EQUAL : '=';
INSERT : '<<';
EXTRACT: '>>';
AT : '@';

/* LITERALS */

//INTEGERS
fragment DIGIT : [0-9];
INTEGER : ('0' | [1-9]DIGIT*);

//REALS
REAL : INTEGER('.'DIGIT+)?('E'[+-]?INTEGER)?;

// STRINGS

START_STRING : '\'' -> more,pushMode(STRING_MODE);

mode STRING_MODE;

STRING : ~('\'' | '\u0000' | '~')*(('~'~('\u0000')STRING)|('\'')) -> popMode;


