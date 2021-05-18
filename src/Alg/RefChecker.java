package Alg;

import Symbols.FunctionSymbol;
import Symbols.Scope;
import Symbols.Symbol;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class RefChecker extends ProjetoBaseListener {
    public Scope globalScope;
    public Scope currentScope;
    private FunctionSymbol currentFunction;
    public int semanticErrors;
    public boolean haveAlg;

    public ParseTreeProperty<Scope> scopes;


    public RefChecker( ParseTreeProperty<Scope> scopes) {
        this.scopes = scopes;
    }

//    public void enterProgram(Projeto.ProgramContext ctx) {
//        currentScope = scopes.get(ctx);
//    }
//
//    public void exitProgram(Projeto.ProgramContext ctx) {
//        System.out.println(scopes.get(ctx));
//    }


    //id_invocation : IDENTIFIER LPAREN list_expressions? RPAREN;
    public void exitId_invocation(Projeto.Id_invocationContext ctx) {
        String functionName = ctx.IDENTIFIER().getText();
        System.out.println(scopes.get(ctx));
        Symbol s = scopes.get(ctx).resolve(functionName);
        if (s == null) {
            System.err.println("Undefined function " + functionName + " in line " + ctx.IDENTIFIER().getSymbol().getLine() + " position: " + ctx.IDENTIFIER().getSymbol().getCharPositionInLine());
            this.semanticErrors++;
            return;
        }
        if (!(s instanceof FunctionSymbol)) {
            System.err.println("Using var symbol " + functionName + " as function in line " + ctx.IDENTIFIER().getSymbol().getLine() + " position: " + ctx.IDENTIFIER().getSymbol().getCharPositionInLine());
            this.semanticErrors++;
            return;
        }
    }
    //TODO: Adicionar a verificação de que a lista de expressões da invocação bate certo com a lista de parametros da função}



}