package Alg;

import Symbols.FunctionSymbol;
import Symbols.Operator;
import Symbols.Scope;
import Symbols.Symbol;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.List;

public class TypeChecker extends ProjetoBaseListener {

    public Scope globalScope;
    public Scope currentScope;
    private FunctionSymbol currentFunction;
    public int semanticErrors;
    public boolean validated;
    public boolean haveAlg;


    public ParseTreeProperty<Symbol.PType> exprType = new ParseTreeProperty<>();
    public ParseTreeProperty<Scope> scopes = new ParseTreeProperty<>();
    public ParseTreeProperty<FunctionSymbol> functions = new ParseTreeProperty<>();


    //métodos auxiliar (é usado em 2 regras gramaticais)
    private boolean defineSymbol(ParserRuleContext ctx, Symbol s) {
        if (!this.currentScope.define(s)) {
            System.err.println("Redefining previously defined variable " + s.name + " in line " + ctx.start.getLine());
            this.semanticErrors++;
            return false;
        }
        this.scopes.put(ctx, currentScope);
        return true;
    }



    //ao entrarmos na regra inicial, criamos e inicializamos os scopes
    public void enterProgram(Projeto.ProgramContext ctx) {
        globalScope = new Scope(null);
        currentScope = globalScope;
        scopes.put(ctx, currentScope);
        this.semanticErrors = 0;
        haveAlg = false;
    }


    public void exitProgram(Projeto.ProgramContext ctx) {
        if (!haveAlg)   //alg function not declared
            System.err.println("Must declare alg(int n, <string> args) function");
//        System.out.println(this.currentScope.toString());
    }


    //id_invocation : IDENTIFIER LPAREN list_expressions? RPAREN;
    public void enterId_invocation(Projeto.Id_invocationContext ctx) {
        this.scopes.put(ctx, this.currentScope);
        //TODO check id_invocations type, must be checked in 2nd run
    }



    // special_function : INT ALG LPAREN INT N COMMA STRING_POINTER ARGS RPAREN body;
    public void enterSpecial_function(Projeto.Special_functionContext ctx) {
        haveAlg = true;
        FunctionSymbol f;
        String functionName = ctx.ALG().getText();
        String type = "int";
        f = new FunctionSymbol(type, functionName);
        if (defineSymbol(ctx, f)) {
            this.currentFunction = f;
            this.currentScope = new Scope(f.scope);
            scopes.put(ctx, this.currentScope);
        }
    }


    // special_function : INT ALG LPAREN INT N COMMA STRING_POINTER ARGS RPAREN body;
    public void exitSpecial_function(Projeto.Special_functionContext ctx) {
        //imprimir o enquadramento local, só para efeito de debug
//        System.out.println("Local scope for function " + this.currentFunction.name + ": " + this.currentScope.toString());
//        if (!this.currentFunction.hasIns)
//            System.err.println("Function: " + this.currentFunction.name + " has to have at least one instruction");
        this.functions.put(ctx.ALG(), this.currentFunction);
        this.currentFunction = null;
        currentScope = currentScope.getParentScope();
    }


    // function_normal: function_type IDENTIFIER LPAREN function_args* RPAREN body;
    public void enterFunction_normal(Projeto.Function_normalContext ctx) {
        String functionName = ctx.IDENTIFIER().getText();
        String type = ctx.function_type().start.getText();
        FunctionSymbol f = new FunctionSymbol(type, functionName);
        if (defineSymbol(ctx, f)) {
            this.currentFunction = f;
            this.currentScope = new Scope(f.scope);
            scopes.put(ctx, currentScope);
        }
    }

    // function_normal: function_type IDENTIFIER LPAREN function_args* RPAREN body;
    public void exitFunction_normal(Projeto.Function_normalContext ctx) {
//        System.out.println("Local scope for function " + this.currentFunction.name + ": " + this.currentScope.toString());
        this.functions.put(ctx.IDENTIFIER(), this.currentFunction);
//        System.out.println("scope of " + this.currentFunction.name + " " + currentScope);
        this.currentFunction = null;
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



    public void exitSubblock_instruction(Projeto.Subblock_instructionContext ctx) {
        if (this.currentFunction.type != Symbol.PType.VOID) {

            int numberOfInsOrVar = ctx.instruction().size() - 1;

            Projeto.InstructionContext lastIns = ctx.instruction(numberOfInsOrVar);
            if (lastIns != null) {
                if (!lastIns.getStart().getText().equals("return")) {
                    this.validated = false;
                    System.err.println("The return needs to be the last instruction in the sub block.");
                }
            } else {
                this.validated = false;
                System.err.println("The return needs to be the last instruction in the sub block.");
            }
        } else {
            if (this.currentFunction.hasReturn) {
                int numberOfInsOrVar = ctx.instruction().size() - 1;

                Projeto.InstructionContext lastIns = ctx.instruction(numberOfInsOrVar);
                if (lastIns != null) {
                    if (!lastIns.getStart().getText().equals("return")) {
                        this.validated = false;
                        System.err.println("The return needs to be the last instruction in the sub block.");
                    }
                } else {
                    this.validated = false;
                    System.err.println("The return needs to be the last instruction in the sub block.");
                }
            }
        }
    }


    public void exitVar_declaration_simple(Projeto.Var_declaration_simpleContext ctx) {
        for (int i = 0; i < ctx.IDENTIFIER().size(); i++) {
            defineSymbol(ctx, new Symbol(ctx.type().start.getText(), ctx.IDENTIFIER().get(i).getText()));
        }
    }





}
