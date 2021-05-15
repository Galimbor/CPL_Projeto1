grammar Projeto;
options{tokenVocab=ProjetoLexer;}

program :
        EOF {notifyErrorListeners("Program must have at least one declaration");}
    |   declaration+ EOF;



/*-------DECLARATION-------*/
declaration:
        var_declaration {notifyErrorListeners("Missing the ';' after declaration");}
    |   var_declaration SEMI_COLON SEMI_COLON {notifyErrorListeners("Extraneous ';' after declaration");}
    |   var_declaration SEMI_COLON
    |   function;


/*-------VARIABLE DECLARATION-------*/
var_declaration:
        var_declaration_simple
    |   var_declaration_init;


/*-------TYPE-------*/
type :
        KEYWORD_INT | KEYWORD_FLOAT | KEYWORD_STRING | (LESSER type GREATER);

var_declaration_simple:
        type IDENTIFIER (SEMI_COLON | (COMMA IDENTIFIER)+)* ;


var_declaration_init:
        type IDENTIFIER EQUAL expression
    |   type IDENTIFIER EQUAL (LBRACKET expression RBRACKET | KEYWORD_NULL) ;



/*-------EXPRESSIONS-------*/

expression:
         expression_evaluation;


simple_expression:
        INTEGER
    |   REAL
    |   STRING
    |   KEYWORD_NULL
    |   KEYWORD_TRUE
    |   KEYWORD_FALSE
    |   IDENTIFIER
    |   function_invocation
;


//WITH ANTLR
expression_evaluation:
        LPAREN expression_evaluation {notifyErrorListeners("Missing ')' to match '('");}
    |   LPAREN expression_evaluation RPAREN RPAREN {notifyErrorListeners("Extraneous ')'");}
    |   LPAREN expression_evaluation RPAREN
    |   expression_evaluation LBRACKET expression_evaluation {notifyErrorListeners("Missing ']' to match '['");}
    |   expression_evaluation LBRACKET expression_evaluation RBRACKET RBRACKET{notifyErrorListeners("Extraneous ']'");}
    |   expression_evaluation LBRACKET expression_evaluation RBRACKET
//    |    LBRACKET expression RBRACKET
    |   unary_operators expression_evaluation
    |   expression_evaluation binary_op_MUL_DIV expression_evaluation
    |   expression_evaluation binary_op_ADD_SUB expression_evaluation
    |   expression_evaluation comparators {notifyErrorListeners("Missing expression after comparator");}
    |   expression_evaluation comparators expression_evaluation
    |   expression_evaluation comparator_AND expression_evaluation
    |   expression_evaluation comparator_OR expression_evaluation
    |   simple_expression;


//WITHOUT ANTLR
exp_comp_or :
        exp_comp_and exp_comp_or_linha;
exp_comp_or_linha :
        comparator_OR exp_comp_and exp_comp_or_linha
    | ;

exp_comp_and :
        exp_comp exp_comp_and_linha;
exp_comp_and_linha :
        comparator_AND exp_comp exp_comp_and_linha
    |;

exp_comp :
        exp_add_sub exp_comp_linha;
exp_comp_linha :
        comparators exp_add_sub exp_comp_linha
    |;

exp_add_sub :
        exp_mul_div exp_add_sub_linha;
exp_add_sub_linha :
        binary_op_ADD_SUB exp_mul_div exp_add_sub_linha
    |;

exp_mul_div :
        exp_unary_op exp_mul_div_linha;
exp_mul_div_linha :
        binary_op_MUL_DIV exp_unary_op exp_mul_div_linha
    |;

exp_unary_op :
        (unary_operators exp_pointer_indx)
    |   exp_pointer_indx;
exp_unary_op_linha :
        exp_pointer_indx exp_unary_op_linha
    |;

exp_pointer_indx:
        exp_paren exp_pointer_indx_linha;
exp_pointer_indx_linha:
        LBRACKET exp_comp_or RBRACKET exp_pointer_indx_linha
    |;

exp_paren :
        LPAREN exp_comp_or RPAREN
    |   simple_expression;


//expression_evaluation:
//    exp_comp_or;



/*-------OPERATORS-------*/
unary_operators:
        SUB
    |   ADD
    |   TILT
    |   QUESTION;

binary_op_ADD_SUB:
        ADD
    |   SUB;

binary_op_MUL_DIV:
        MUL
    |   DIV;

comparators:
        LESSER
    |   GREATER
    |   GREATEQ
    |   LESSEQ
    |   EQUALS
    |   NOTEQUALS;

comparator_AND:
        AND;

comparator_OR:
        OR;


/*-------FUNCTIONS-------*/


/*-------FUNCTION DECLARATION-------*/
function :
        IDENTIFIER LPAREN function_args RPAREN body {notifyErrorListeners("Missing type of function");}
    |   (type | KEYWORD_VOID) IDENTIFIER LPAREN function_args RPAREN body;

function_args_old:
        function_arg
    |   function_arg COMMA function_args_old; //Without left factoring

function_args:
        function_arg function_args_aux;

function_args_aux:
        COMMA function_args
    |   ;

function_arg :
        type IDENTIFIER;



/*-------BODY-------*/
body :
        (AT block)? block (EXTRACT block)?;

block :
        LBLOCK var_declaration*  instruction+  {notifyErrorListeners("Missing '}' to match '{'");}
    |   LBLOCK var_declaration*  instruction+ RBLOCK RBLOCK {notifyErrorListeners("Extraneous '}'");}
    |   LBLOCK var_declaration*  instruction+  RBLOCK ;


/*---FUNCTION INVOCATION---*/
function_invocation :
        id_invocation
    |   special_invocation;

id_invocation :
        IDENTIFIER LPAREN list_expressions? RPAREN;

list_expressions_old : expression | expression COMMA list_expressions_old; //without left factoring

list_expressions :
        expression list_expressions_aux;
list_expressions_aux:
        COMMA list_expressions
    |   ;

special_invocation:
        at_function
    |   sizeof_function
    |   write_function
    |   writeln_fuction;

at_function:
        AT LPAREN expression RPAREN {notifyErrorListeners("@ must be called without arguments");}
    |   AT LPAREN RPAREN;
sizeof_function :
        KEYWORD_SIZEOF LPAREN RPAREN {notifyErrorListeners("sizeof() must have one argument");}
    |   KEYWORD_SIZEOF LPAREN expression RPAREN ;
write_function:
        KEYWORD_WRITE LPAREN list_expressions? RPAREN;
writeln_fuction :
        KEYWORD_WRITELN LPAREN list_expressions? RPAREN;


/*-------INSTRUCTIONS-------*/
instruction :
        expression {notifyErrorListeners("Missing ';'");}
    |   expression SEMI_COLON
    |   control_instructions SEMI_COLON
    |   attribution_instruction SEMI_COLON
    |   conditional_instruction SEMI_COLON {notifyErrorListeners("Extraneous ';'");}
    |   conditional_instruction
    |   cicle_instruction SEMI_COLON {notifyErrorListeners("Extraneous ';'");}
    |   cicle_instruction
    |   subblock_instruction SEMI_COLON {notifyErrorListeners("Extraneous ';'");}
    |   subblock_instruction;


/*-----CONTROL INSTRUCTIONS------*/
control_instructions:
        KEYWORD_LEAVE
    |   KEYWORD_RESTART
    |   KEYWORD_RETURN expression?;


/*------ATRIBUTION----------*/
attribution_instruction:
        (IDENTIFIER | expression) EQUAL expression;


/*-------CONDITIONAL ATTRIBUTION-----------*/
conditional_instruction:
        KEYWORD_IF expression KEYWORD_THEN instruction (KEYWORD_ELSE instruction)?;


/*---------CICLE-----------*/
cicle_instruction:
        KEYWORD_WHILE expression KEYWORD_DO instruction (KEYWORD_FINALLY instruction)?;


/*----------SUB-BLOCK---------------*/
subblock_instruction:
        LBLOCK instruction* RBLOCK;
