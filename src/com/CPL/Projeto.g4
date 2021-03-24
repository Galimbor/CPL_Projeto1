parser grammar Projeto;
options{tokenVocab=ProjetoLexer;}

start : expression+ EOF;

expression:
    .;

