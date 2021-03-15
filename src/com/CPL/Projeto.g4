parser grammar Projeto;
options{tokenVocab=ProjetoLexer;}

start : expression+ EOF;

expression:
    IDENT
  | LITERAL_REAL
  | LITERAL_INT
  | COMMENTS
//  | IDENT_RAIVA
  | DESTROY
  | WHITE_SPACE;
