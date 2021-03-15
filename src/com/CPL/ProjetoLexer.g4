lexer grammar ProjetoLexer;




//attribute types
LITERAL_INT :  '0'..'9'+;
LITERAL_REAL : LITERAL_INT'.'LITERAL_INT;
fragment MIN_LETTER: [a-z];
IDENT : MIN_LETTER+;


COMMENTS: '/*'.*'*/' -> skip; //podemos utilizaro  ? após o * para escolher apenas a menor string q corresponde


INICIA_RAIVA: '!!!' -> more,pushMode(RAIVA_MODE); //MORE: IGNORA O TOKEN!!! MAS CONCATENTA O !!! COM O QUE VIER ASSEGUIR

WHITE_SPACE: ' ' -> skip;

mode RAIVA_MODE;


DESTROY : 'destroy';

fragment MAI_LETTER: [A-Z];
IDENT_RAIVA : MAI_LETTER+ -> type(IDENT);

LITERAL_INT_RAIVA : '0'..'9'+ -> type(LITERAL_INT);

SAIR_RAIVA: '***' -> skip,popMode;