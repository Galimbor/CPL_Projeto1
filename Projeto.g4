parser grammar Projeto;
options{tokenVocab=ProjetoLexer;}

program :
        EOF {notifyErrorListeners("Program must have at least one declaration");}
    |   declaration+ EOF;


/*-------DECLARATION-------*/
declaration:
        var_declaration SEMI_COLON  {notifyErrorListeners("Extraneous ';' after declaration");}
    |   var_declaration
    |   function;


/*-------VARIABLE DECLARATION-------*/
var_declaration:
        var_declaration_simple SEMI_COLON
    |   var_declaration_init SEMI_COLON;


/*-------TYPE-------*/
type :
            INT
         |  FLOAT
         |  STRING
         |  BOOL
         |  POINTER;

function_type:
        type | VOID;


var_declaration_simple:
        type IDENTIFIER ((COMMA IDENTIFIER)+)* ;


var_declaration_init:
        type IDENTIFIER EQUAL expression #DeclAndAtrib
    |   type IDENTIFIER EQUAL (LBRACKET expression RBRACKET | NULL) #MemDecl
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
    |   expression_evaluation binary_op_MUL_DIV_REM expression_evaluation   # MulDivRem
    |   expression_evaluation binary_op_ADD_SUB expression_evaluation   # AddSub
    |   expression_evaluation comparators {notifyErrorListeners("Missing expression after comparator");}        # CompOtherErr1
    |   expression_evaluation comparators expression_evaluation         # CompOther
    |   expression_evaluation comparator_AND expression_evaluation      # CompAnd
    |   expression_evaluation comparator_OR expression_evaluation       # CompOr
    |   simple_expression                                               # SimpExp;


binary_op_MUL_DIV_REM:
    MUL     #Mul
    | DIV   #Div
    | PERCENT #Percent ;



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


comparators:
        LESSER #Lesser
    |   GREATER #Greater
    |   GREATEQ #Greateq
    |   LESSEQ #Lesseq
    |   EQUALS #Equals
    |   NOTEQUALS #Notequals;

comparator_AND:
        AND;

comparator_OR:
        OR;


/*-------FUNCTIONS-------*/


/*-------FUNCTION DECLARATION-------*/
function :
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


function_args:
        function_arg (COMMA function_arg)*;

//function_args:
//        function_arg function_args_aux;
//
//function_args_aux:
//        COMMA function_args
//    |   ;

function_arg :
        type IDENTIFIER;



/*-------BODY-------*/
body :
        prologue? central epilogue?;

prologue: AT block;
central: block;
epilogue: EXTRACT block;

block :
        LBLOCK (var_declaration*  instruction+)*  {notifyErrorListeners("Missing '}' to match '{'");}
    |   LBLOCK (var_declaration*  instruction+)* RBLOCK RBLOCK {notifyErrorListeners("Extraneous '}'");}
    |   LBLOCK var_or_instruction* RBLOCK;


var_or_instruction: var_declaration | instruction;

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
