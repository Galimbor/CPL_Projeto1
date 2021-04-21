parser grammar Projeto;
options{tokenVocab=ProjetoLexer;}

start : all+ EOF;

all:
    var_declaration | function;


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
         expression_evaluation;



//TODO (grammar rule with only terminal symbols)
simple_expression:
     INTEGER
   | REAL
   | STRING
   | KEYWORD_NULL
   | KEYWORD_TRUE
   | KEYWORD_FALSE
   | IDENTIFIER
   | function_invocation
;


binary_op2: ADD | SUB;
binary_op3: MUL | DIV;

exp_comp_or : exp_comp_and exp_comp_or_linha;
exp_comp_or_linha : comparator2 exp_comp_and exp_comp_or_linha |;

exp_comp_and : exp_comp exp_comp_and_linha;
exp_comp_and_linha : comparator3 exp_comp exp_comp_and_linha |;

exp_comp : exp_add_sub exp_comp_linha;
exp_comp_linha : comparator4 exp_add_sub exp_comp_linha |;

exp_add_sub : exp_mul_div exp_add_sub_linha;
exp_add_sub_linha : binary_op2 exp_mul_div exp_add_sub_linha |;

exp_mul_div : exp_unary_op exp_mul_div_linha;
exp_mul_div_linha : binary_op3 exp_unary_op exp_mul_div_linha |;

exp_unary_op : (unary_operators exp_comp_or)| exp_pointer_indx;
exp_unary_op_linha : exp_pointer_indx exp_unary_op_linha |;

exp_pointer_indx:  exp_paren  exp_pointer_indx_linha ;
exp_pointer_indx_linha: LBRACKET exp_comp_or RBRACKET exp_pointer_indx_linha |;

exp_paren :  LPAREN exp_comp_or RPAREN |  simple_expression;


//TODO
expression_evaluation:
    exp_comp_or;

//TODO same as simple expression
unary_operators:
    SUB
    | ADD
    | TILT
    | QUESTION;




comparator4:
    LESSER
    |GREATER
    |GREATEQ
    |LESSEQ
    |EQUALS
    |NOTEQUALS
;
comparator3:
    AND;

comparator2:
    OR;


//Functions

/*---FUNCTION DECLARATION-------*/

function : general_function
//| special_function
;


//special_function : type KEYWORD_ALG LPAREN special_f_args RPAREN body SEMI_COLON;
//
//special_f_args : type IDENTIFIER COMMA type IDENTIFIER;


general_function : (type | KEYWORD_VOID) IDENTIFIER LPAREN general_function_args RPAREN  body;

general_function_args:  function_arg | function_arg COMMA general_function_args   ;

function_arg : type IDENTIFIER;



/* ---BODY---*/
body : (AT block)? block (EXTRACT block)?;

block : LBLOCK  var_declaration*  instructions+  RBLOCK ;

/*---FUNCTION INVOCATION---*/

function_invocation : (id_invocation | special_invocation);

id_invocation : IDENTIFIER LPAREN list_expressions RPAREN;
list_expressions : expression | (COMMA list_expressions) |  ;



special_invocation: (at_function | sizeof_function | write_function| writeln_fuction);

at_function: AT LPAREN RPAREN;
sizeof_function : KEYWORD_SIZEOF LPAREN expression RPAREN ;
write_function: KEYWORD_WRITE LPAREN list_expressions RPAREN;
writeln_fuction : KEYWORD_WRITELN LPAREN list_expressions RPAREN;


//Instructions


instructions : (expression | control_instructions | attribution_instruction | conditional_instruction | cicle_instruction | subblock_instruction) ;

/*-----CONTROL INSTRUCTIONS------*/

//HAD TO FATORIZE TO THE LEFT - NOT IN THE BEST STATE
control_instructions: KEYWORD_LEAVE | KEYWORD_RESTART | KEYWORD_RETURN expression?;


/*------ATRIBUTION----------*/


// EXPRESSION É INDEXAÇÃO DE PONTEIROS
//TODO pointer expression
attribution_instruction: (IDENTIFIER | expression) EQUAL expression;

/*-------CONDITIONAL ATTRIBUTION-----------*/

//INTEGER IS EXPRESSION
conditional_instruction: KEYWORD_IF expression KEYWORD_THEN instructions (KEYWORD_ELSE instructions)?;


/*---------CICLE-----------*/

//integer is expression
cicle_instruction: KEYWORD_WHILE expression KEYWORD_DO instructions (KEYWORD_FINALLY instructions)?;


/*----------SUB-BLOCK---------------*/

subblock_instruction: LBLOCK instructions+ RBLOCK;
