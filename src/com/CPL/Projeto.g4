parser grammar Projeto;
options{tokenVocab=ProjetoLexer;}

start : all+ EOF;

all:
    var_declaration;


// VARIABLE DECLARATIONS

var_declaration:

var_declaration_without | var_declaration_with;

var_declaration_without:
    (KEYWORD_INT | KEYWORD_FLOAT | KEYWORD_STRING | POINTER) IDENTIFIER (SEMI_COLON | (COMMA IDENTIFIER)+ SEMI_COLON) ;

var_declaration_with:
    (KEYWORD_INT | KEYWORD_FLOAT | KEYWORD_STRING) IDENTIFIER EQUAL expression SEMI_COLON
    | POINTER IDENTIFIER EQUAL (LBRACKET expression RBRACKET | KEYWORD_NULL) SEMI_COLON;



simple_expression:
     INTEGER
   | REAL
   | STRING
   | KEYWORD_NULL
   | KEYWORD_TRUE
   | KEYWORD_FALSE;

pointer_indexing:
      LPAREN pointer_indexing RPAREN
    | pointer_expr LBRACKET int_expr RBRACKET
    | pointer_extraction LBRACKET int_expr RBRACKET;

pointer_extraction:
      LPAREN pointer_extraction RPAREN
    | QUESTION pointer_indexing
    | QUESTION IDENTIFIER ;

unary_operators:
    pointer_extraction
    | MINUS
    | PLUS
    | TILT;

pointer_expr:
      LPAREN pointer_expr RPAREN
    | IDENTIFIER;

int_expr:
      LPAREN int_expr RPAREN
    | int_expr (MULTI | DIVIDE) int_expr
    | int_expr (PLUS | MINUS) int_expr
    | INTEGER
;

comparator:
    LESSER
    |GREATER
    |GREATEQ
    |LESSEQ
    |EQUALS
    |NOTEQUALS
    |AND
    |OR
;


// EXPRESSSION
expression:
        (LPAREN expression RPAREN)
      | pointer_indexing
      | int_expr
      | pointer_expr
      | pointer_extraction
      | unary_operators expression
      | expression comparator expression
      | simple_expression
      ;

//Functions

/*---FUNCTION DECLARATION-------*/

function : general_function | special_function;

special_function : KEYWORD_INT KEYWORD_ALG LPAREN special_f_arguments RPAREN body SEMI_COLON;

special_f_arguments : KEYWORD_INT ARGUMENT_N COMMA LESSER KEYWORD_STRING GREATER IDENTIFIER;

general_function : function_type IDENTIFIER LPAREN function_arguments? RPAREN  body SEMI_COLON;

function_type: KEYWORD_INT | KEYWORD_BOOL | KEYWORD_FLOAT | KEYWORD_STRING | POINTER | KEYWORD_VOID;

function_arguments: ((KEYWORD_INT | KEYWORD_BOOL | KEYWORD_FLOAT | KEYWORD_STRING | POINTER) IDENTIFIER) ( (COMMA  (KEYWORD_INT | KEYWORD_FLOAT | KEYWORD_STRING | POINTER) IDENTIFIER)+ )? ;


/* ---BODY---*/
body : AT? block EXTRACT?;

block : LBLOCK  var_declaration*  instructions+  RBLOCK ;

/*---FUNCTION INVOCATION---*/


id_invocation : IDENTIFIER LPAREN list_expressions? RPAREN  SEMI_COLON ;
list_expressions : expression (COMMA expression)* ;

special_invocation: (at_function | sizeof_function | write_function| writeln_fuction)*;

at_function: AT LPAREN RPAREN SEMI_COLON;
sizeof_function : KEYWORD_SIZEOF LPAREN expression RPAREN SEMI_COLON;
write_function: KEYWORD_WRITE LPAREN list_expressions SEMI_COLON;
writeln_fuction : KEYWORD_WRITELN LPAREN list_expressions SEMI_COLON;


//Instructions


instructions : expression | control_instructions | attribution_instruction | conditional_instruction | cicle_instruction | subblock_instruction;

/*-----CONTROL INSTRUCTIONS------*/

//HAD TO FATORIZE TO THE LEFT - NOT IN THE BEST STATE
control_instructions: KEYWORD_LEAVE | KEYWORD_RESTART | KEYWORD_RETURN control_instructions_2;
control_instructions_2 : expression? ;


/*------ATRIBUTION----------*/


//INTEGER HAS TO BE A INDEXACAO PONTEIROS
//AND OTHER INT HAS TO BE EXPRESSION
attribution_instruction: (IDENTIFIER | pointer_indexing) EQUAL expression SEMI_COLON;

/*-------CONDITIONAL ATTRIBUTION-----------*/

//INTEGER IS EXPRESSION
conditional_instruction: KEYWORD_IF expression KEYWORD_THEN instructions (KEYWORD_ELSE instructions)?;


/*---------CICLE-----------*/

//integer is expression
cicle_instruction: KEYWORD_WHILE expression KEYWORD_DO instructions (KEYWORD_FINALLY instructions)?;


/*----------SUB-BLOCK---------------*/

subblock_instruction: LBLOCK instructions* RBLOCK;
