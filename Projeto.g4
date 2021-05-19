parser grammar Projeto;
options{tokenVocab=ProjetoLexer;}

program :
        EOF {notifyErrorListeners("Program must have at least one declaration");}
    |   declaration+ EOF;


/*-------DECLARATION-------*/
declaration:
        var_declaration SEMI_COLON  {notifyErrorListeners("Extraneous ';' after declaration");}
    |   var_declaration
    |   function_decl;


/*-------VARIABLE DECLARATION-------*/
var_declaration:
        var_declaration_simple SEMI_COLON
    |   var_declaration_init SEMI_COLON;


/*-------TYPE-------*/
pointer: STRING_POINTER
        |   INT_POINTER
        |   FLOAT_POINTER
        |   BOOL_POINTER;

type :
            INT
         |  FLOAT
         |  STRING
         |  pointer;

function_type:
        type | VOID;


var_declaration_simple:
        type IDENTIFIER ((COMMA IDENTIFIER)+)* ;


var_declaration_init:
        type IDENTIFIER EQUAL expression
    |   type IDENTIFIER EQUAL (LBRACKET expression RBRACKET | NULL)
    ;



/*-------EXPRESSIONS-------*/

expression:
         expression_evaluation;


simple_expression:
        INTEGER                 # Int
    |   REAL                    # Real
    |   STRING                  # String
    |   NULL                    # Null
    |   TRUE                    # True
    |   FALSE                   # False
    |   IDENTIFIER              # Var
    |   function_invocation     # Function_call
;


//WITH ANTLR
expression_evaluation:
        LPAREN expression_evaluation {notifyErrorListeners("Missing ')' to match '('");}    # ParenExpErr1
    |   LPAREN expression_evaluation RPAREN RPAREN {notifyErrorListeners("Extraneous ')'");}    #ParenExpErr2
    |   LPAREN expression_evaluation RPAREN     # ParenExp
    |   expression_evaluation LBRACKET expression_evaluation {notifyErrorListeners("Missing ']' to match '['");}    # PointerExpErr1
    |   expression_evaluation LBRACKET expression_evaluation RBRACKET RBRACKET{notifyErrorListeners("Extraneous ']'");} # PointerExpErr2
    |   expression_evaluation LBRACKET expression_evaluation RBRACKET # PointerExp
    |   unary_operators expression_evaluation   # UnaryExp
    |   expression_evaluation binary_op_MUL_DIV expression_evaluation   # MulDiv
    |   expression_evaluation binary_op_ADD_SUB expression_evaluation   # AddSub
    |   expression_evaluation comparators {notifyErrorListeners("Missing expression after comparator");}        # CompOtherErr1
    |   expression_evaluation comparators expression_evaluation         # CompOther
    |   expression_evaluation comparator_AND expression_evaluation      # CompAnd
    |   expression_evaluation comparator_OR expression_evaluation       # CompOr
    |   simple_expression                                               # SimpExp;


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
        SUB         # Simetric
    |   ADD         # Identity
    |   TILT        # Negation
    |   QUESTION    # PointerExtr
    ;

binary_op_ADD_SUB:
        ADD         # Add
    |   SUB         # Sub
    ;

binary_op_MUL_DIV:
        MUL         # Mul
    |   DIV         # Div
    ;

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
function_decl :
        IDENTIFIER LPAREN function_args* RPAREN body {notifyErrorListeners("Missing type of function");}
    |   function_normal
    |   special_function;


function_normal:
         function_type IDENTIFIER LPAREN function_args? RPAREN body;

special_function:
        INT ALG LPAREN INT N COMMA STRING_POINTER ARGS RPAREN body;

function_args_old:
        function_arg
    |   function_arg COMMA function_args_old; //Without left factoring

//function_args:
//        function_arg function_args_aux;

function_args:
        function_arg (COMMA function_arg)*;

function_arg :
        type IDENTIFIER;

//function_args_aux:
//        COMMA function_args
//    |   ;





/*-------BODY-------*/
body:
        prologue? central epilogue?;

prologue: AT block;
central: block;
epilogue: EXTRACT block;

block :
        LBLOCK (var_declaration*  instruction+)+  {notifyErrorListeners("Missing '}' to match '{'");}
    |   LBLOCK (var_declaration*  instruction+)+ RBLOCK RBLOCK {notifyErrorListeners("Extraneous '}'");}
    |   LBLOCK (var_declaration | instruction)* RBLOCK;


/*---FUNCTION INVOCATION---*/
function_invocation :
        id_invocation
    |   special_invocation;

id_invocation :
        IDENTIFIER LPAREN list_expressions? RPAREN;


list_expressions: expression (COMMA expression)*;

//list_expressions_old : expression | expression COMMA list_expressions_old; //without left factoring
//
//list_expressions :
//        expression list_expressions_aux;
//list_expressions_aux:
//        COMMA list_expressions
//    |   ;

special_invocation:
        at_function
    |   sizeof_function
    |   write_function
    |   writeln_fuction;

at_function:
        AT LPAREN expression RPAREN {notifyErrorListeners("@ must be called without arguments");}
    |   AT LPAREN RPAREN;
sizeof_function :
        SIZEOF LPAREN RPAREN {notifyErrorListeners("sizeof() must have one argument");}
    |   SIZEOF LPAREN expression RPAREN ;
write_function:
        WRITE LPAREN list_expressions? RPAREN;
writeln_fuction :
        WRITELN LPAREN list_expressions? RPAREN;


/*-------INSTRUCTIONS-------*/
instruction :
    expression SEMI_COLON               # Expression_ins
    |   control_instructions SEMI_COLON     # Control_ins
    |   attribution_instruction SEMI_COLON  # Attribution_ins
    |   conditional_instruction SEMI_COLON {notifyErrorListeners("Extraneous ';'");} # Conditional_insErr1
    |   conditional_instruction             # Conditional_ins
    |   cicle_instruction SEMI_COLON {notifyErrorListeners("Extraneous ';'");}    # Cicle_insErr1
    |   cicle_instruction                   # Cicle_ins
    |   subblock_instruction SEMI_COLON {notifyErrorListeners("Extraneous ';'");} # Subblock_insErr1
    |   subblock_instruction                # Subblock_ins
    ;


/*-----CONTROL INSTRUCTIONS------*/
control_instructions:
        LEAVE                   # Leave
    |   RESTART                 # Restart
    |   RETURN expression?      # Return;


/*------ATRIBUTION----------*/
attribution_instruction:
        (IDENTIFIER | expression) EQUAL expression;


/*-------CONDITIONAL ATTRIBUTION-----------*/
conditional_instruction:
        IF expression THEN instruction (ELSE instruction)?;


/*---------CICLE-----------*/
cicle_instruction:
        WHILE expression DO instruction (FINALLY instruction)?;


/*----------SUB-BLOCK---------------*/
subblock_instruction:
        LBLOCK instruction* RBLOCK;
