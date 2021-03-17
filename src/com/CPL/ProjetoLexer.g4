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

KEYWORDS : KEYWORD_INT | KEYWORD_BOOL | KEYWORD_FLOAT | KEYWORD_STRING |
           KEYWORD_VOID | KEYWORD_SIZEOF | KEYWORD_NULL | KEYWORD_ALG | KEYWORD_TRUE |
           KEYWORD_FALSE | KEYWORD_WHILE | KEYWORD_DO | KEYWORD_FINALLY | KEYWORD_LEAVE |
           KEYWORD_RESTART | KEYWORD_RETURN | KEYWORD_IF | KEYWORD_THEN | KEYWORD_ELSE |
           KEYWORD_WRITE | KEYWORD_WRITELN;

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

EXPLICATIVE : DOUBLE_CARDINAL.*?~('\n')NEWLINE;
OPERATIONAL : LOPERATIONAL.*ROPERATIONAL;


/* TERMINATORS */

COMMA : ',';
SEMI_COLON : ';';
EXPRESSION_DELIMITERS: '('.*~(')')')';

/* INDENTIFIERS */
fragment LETTER : [a-zA-Z\u0080-\u00FF];
fragment LETTERS: LETTER+;
fragment UNDERSCORE : '_';

IDENTIFIER : LETTER(LETTER| DIGIT | UNDERSCORE)*;
/* LITERALS */

//INTEGERS
fragment DIGIT : [0-9];
INTEGER : ('0' | [1-9]DIGIT*);

//REALS
REAL : INTEGER(.DIGIT+)?('E'[+-]?DIGIT+)?;



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

OTHERS : LPAREN | RPAREN | LBRACKET | RBRACKET | PLUS | MINUS | QUESTION | PERCENT | GREATER | LESSER | GREATEQ |
LESSEQ | EQUALS | NOTEQUALS | TILT | AND | OR | EQUAL | INSERT | EXTRACT | AT;



COMMENTS: '/*'.*'*/' -> skip; //podemos utilizaro  ? após o * para escolher apenas a menor string q corresponde





START_STRING : '\'' -> more,pushMode(STRING_MODE);

mode STRING_MODE;

//STRING_NEWLINE : '~n' ->type(NEWLINE);
//STRING_TAB : '~t' ->type(TAB);
//STRING_CARRIAGE_RETURN : '~r' ->type(CARRIAGE_RETURN);

STRING : .*?~'\''*('\'') -> popMode;

/*

af
/*
afsdfs */

