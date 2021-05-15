package Alg;

import Symbols.FunctionSymbol;
import Symbols.Scope;
import Symbols.Symbol;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class TypeChecker extends ProjetoBaseListener {

    public Scope globalScope;
    public Scope currentScope;
    private FunctionSymbol currentFunction;
    public boolean validated;

    ParseTreeProperty<Symbol.PType> exprType = new ParseTreeProperty<>();


    //métodos auxiliar (é usado em 2 regras gramaticais)
    private boolean defineSymbol(ParserRuleContext ctx, Symbol s) {
        if (!this.currentScope.define(s)) {
            //estejam à vontade para mudar as mensagens de erro!
            //ou adicionar mais informação, como por exemplo qual a posição da linha onde começa a variável com erro
            //ou até mesmo onde é que está definida a variável original...
            System.err.println("Redefining previously defined variable " + s.name + " in line " + ctx.start.getLine());
            validated = false;
            return false;
        }
        return true;
    }

    //ao entrarmos na regra inicial, criamos e inicializamos os scopes
    public void enterProgram(Projeto.ProgramContext ctx) {
        globalScope = new Scope(null);
        this.currentScope = globalScope;
        validated = true;
    }

    //estamos a imprimir só para ver todos os símbolos que foram criados no scope global
    //está aqui para informação de debug
    public void exitProgram(Projeto.ProgramContext ctx) {
        System.out.println(this.currentScope.toString());
    }


    public void enterFunction(Projeto.FunctionContext ctx) {
        FunctionSymbol f;
        String functionName = ctx.IDENTIFIER().getText();
        String type = ctx.function_type().start.getText();
        f = new FunctionSymbol(type, functionName);
        if (defineSymbol(ctx, f)) {
            this.currentFunction = f;
            this.currentScope = new Scope(this.currentScope);
        }
    }

    //this method is called after the block ends
    //functionDecl : type ID '(' formalParameters? ')' block;
    public void exitFunction(Projeto.FunctionContext ctx) {
        //imprimir o enquadramento local, só para efeito de debug
        System.out.println("Local scope for function " + this.currentFunction.name + ": " + this.currentScope.toString());
        this.currentFunction = null;

        //temos de sair do contexto local da função
        currentScope = currentScope.getParentScope();
    }

    //function_arg: function_arg IDENTIFIER
    public void exitFunction_arg(Projeto.Function_argContext ctx) {
        //temos de fazer 2 coisas, adicionar o parametro formal ao enquadramento local atual, e adicionar à lista
        //de argumentos
        String type = ctx.type().start.getText();
        String name = ctx.IDENTIFIER().getText();

        Symbol parameter = new Symbol(type, name);
        if (defineSymbol(ctx, parameter) && this.currentFunction != null) {
            this.currentFunction.arguments.add(parameter);
        }
    }

    
}
