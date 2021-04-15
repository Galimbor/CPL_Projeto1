parser grammar Projeto;
options{tokenVocab=ProjetoLexer;}

start : all+ EOF;

all:
    var_declaration;


// Variable Declarations



var_declaration:
var_declaration_without | var_declaration_with;


var_declaration_without:
    VARIABLE_TYPE BLANK IDENTIFIER BLANK*? (SEMI_COLON | (COMMA BLANK*? IDENTIFIER BLANK*?)+  SEMI_COLON) ;

var_declaration_with:
    VARIABLE_TYPE BLANK IDENTIFIER BLANK*? EQUAL BLANK*? expression;


expression:
;