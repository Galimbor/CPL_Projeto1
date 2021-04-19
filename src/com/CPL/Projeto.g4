parser grammar Projeto;
options{tokenVocab=ProjetoLexer;}

start : all+ EOF;

all:
    var_declaration;


// VARIABLE DECLARATIONS

/*
Variable declaration can be either a simple declaration (int j;) or a declaration
with initialization int j = expression;
*/
var_declaration:
(var_declaration_simple | var_declaration_init) SEMI_COLON;

type :
KEYWORD_INT | KEYWORD_FLOAT | KEYWORD_STRING | (LESSER type GREATER);

var_declaration_simple:
    type IDENTIFIER (SEMI_COLON | (COMMA IDENTIFIER)+)* ;

var_declaration_init:
    type IDENTIFIER EQUAL expression
    | type IDENTIFIER EQUAL (LBRACKET expression RBRACKET | KEYWORD_NULL) ;


/*
An expression can be either a simple expression or an expression evaluation.
*/
expression:
         (simple_expression
        | expression_evaluation)+;



//TODO (grammar rule with only terminal symbols)
simple_expression:
     INTEGER
   | REAL
   | STRING
   | KEYWORD_NULL
   | KEYWORD_TRUE
   | KEYWORD_FALSE
   | IDENTIFIER
   | function_invocation;


bracketLinha:
    (LBRACKET expression RBRACKET bracketLinha) | /* epsilon*/;

//TODO
expression_evaluation:

     LPAREN expression+ RPAREN
    | ( LBRACKET expression RBRACKET bracketLinha)
    | unary_operators simple_expression
//    | LBRACKET expression RBRACKET expression?
//    | comparator expression

//
//
//    //TODO Rever recursividade de binarios com expressões, expression->expression_evaluating;  expression_evaluating-> expression;
    |  (MULTI | DIVIDE) expression
    |   (PLUS | MINUS)  expression
    |  comparator expression  ;
//
//
//    expression_evaluation_second:
//     ((PLUS | MINUS) expression_evaluation_second | /*epsilon*/);
//
//    expression_evaluation_first:?a[1]
//    ((MULTI | DIVIDE) expression_evaluation_first | /*epsilon*/);
//
//    expression_evaluation_third:
//       (comparator expression_evaluation_third | /*epsilon*/);

/*

*/
//pointer_indexing:
//    pointer_expr LBRACKET expression RBRACKET;

//TODO same as simple expression
unary_operators:
    MINUS
    | PLUS
    | TILT
    | QUESTION;

/*
Identifiers with binary operators, represents pointer to variable
*/
//pointer_expr:
//        LPAREN pointer_expr RPAREN
//      | pointer_expr (MULTI | DIVIDE) (pointer_expr | int_expr)
//      | pointer_expr (PLUS | MINUS) (pointer_expr | int_expr)
//      | QUESTION pointer_indexing
//      | IDENTIFIER;

//TODO: is this really necessary? used for pointer indexing index
//int_expr:
//      LPAREN int_expr RPAREN
//    | int_expr (MULTI | DIVIDE) int_expr
//    | int_expr (PLUS | MINUS) int_expr
//    | INTEGER
//;

//TODO: same as simple expression
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

//
//        (LPAREN expression RPAREN)
//      | pointer_indexing
//      | int_expr
//      | pointer_expr
//      | pointer_extraction
//      | unary_operators expression
//      | expression comparator expression
//      | simple_expression

//Functions

/*---FUNCTION DECLARATION-------*/

function : general_function | special_function;


special_function : type KEYWORD_ALG LPAREN special_f_args RPAREN body SEMI_COLON;

special_f_args : type ARGUMENT_N COMMA type IDENTIFIER;


general_function : general_function_type IDENTIFIER LPAREN general_function_args* RPAREN  body;

general_function_type: type;

general_function_args: ( ((type) IDENTIFIER) | (COMMA  general_function_args) )  ;

//function_arguments: ((KEYWORD_INT | KEYWORD_BOOL | KEYWORD_FLOAT | KEYWORD_STRING | POINTER) IDENTIFIER) ( (COMMA  (KEYWORD_INT | KEYWORD_FLOAT | KEYWORD_STRING | POINTER) IDENTIFIER)+ )? ;


/* ---BODY---*/
body : (AT block)? block (EXTRACT block)?;

block : LBLOCK  var_declaration*  instructions+  RBLOCK ;

/*---FUNCTION INVOCATION---*/

function_invocation : (id_invocation | special_invocation);

id_invocation : IDENTIFIER LPAREN list_expressions* RPAREN   ;
//list_expressions : expression (COMMA expression)* ;
list_expressions : expression | (COMMA expression) ;



special_invocation: (at_function | sizeof_function | write_function| writeln_fuction);

at_function: AT LPAREN RPAREN SEMI_COLON;
sizeof_function : KEYWORD_SIZEOF LPAREN expression RPAREN SEMI_COLON;
write_function: KEYWORD_WRITE LPAREN list_expressions* RPAREN SEMI_COLON;
writeln_fuction : KEYWORD_WRITELN LPAREN list_expressions* RPAREN SEMI_COLON;


//Instructions


instructions : (expression | control_instructions | attribution_instruction | conditional_instruction | cicle_instruction | subblock_instruction) ;

/*-----CONTROL INSTRUCTIONS------*/

//HAD TO FATORIZE TO THE LEFT - NOT IN THE BEST STATE
control_instructions: KEYWORD_LEAVE | KEYWORD_RESTART | KEYWORD_RETURN expression?;


/*------ATRIBUTION----------*/


// EXPRESSION É INDEXAÇÃO DE PONTEIROS
attribution_instruction: (IDENTIFIER | expression) EQUAL expression;

/*-------CONDITIONAL ATTRIBUTION-----------*/

//INTEGER IS EXPRESSION
conditional_instruction: KEYWORD_IF expression KEYWORD_THEN instructions (KEYWORD_ELSE instructions)?;


/*---------CICLE-----------*/

//integer is expression
cicle_instruction: KEYWORD_WHILE expression KEYWORD_DO instructions (KEYWORD_FINALLY instructions)?;


/*----------SUB-BLOCK---------------*/

subblock_instruction: LBLOCK instructions* RBLOCK;
