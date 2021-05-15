lexer grammar ProjetoLexer;


/* KEYWORDS */
INT : 'int' ;
BOOL : 'bool';
FLOAT : 'float';
STRING: 'string';
VOID: 'void';
SIZEOF: 'sizeof';
NULL: 'null';
ALG: 'alg';
TRUE: 'true';
FALSE: 'false';
WHILE: 'while';
DO: 'do';
FINALLY: 'finally';
LEAVE: 'leave';
RESTART: 'restart';
RETURN: 'return';
IF: 'if';
THEN : 'then';
ELSE: 'else';
WRITE: 'write';
WRITELN : 'writeln';



/* TYPE */


POINTER : '<' (INT | BOOL | FLOAT | STRING) '>';




/* WHITESPACE */
NEWLINE : '\n' -> skip;
CARRIAGE_RETURN: '\r';
BLANK: ' ' ->skip;
TAB: '\t';



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
LBLOCK : '{';
RBLOCK: '}';
LBRACKET : '[';
RBRACKET : ']';
ADD : '+';
SUB : '-';
MUL : '*';
DIV : '/';
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

STRING_ : ~('\'' | '\u0000' | '~')*(('~'~('\u0000')STRING_)|('\'')) -> popMode;

