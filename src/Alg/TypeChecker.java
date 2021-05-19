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
    public int semanticErrors;
    public boolean haveAlg;

    public ParseTreeProperty<Symbol.PType> exprType = new ParseTreeProperty<>();

    public ParseTreeProperty<Scope> scopes = new ParseTreeProperty<>();
    public ParseTreeProperty<FunctionSymbol> functions = new ParseTreeProperty<>();


    //métodos auxiliar (é usado em 2 regras gramaticais)
    private boolean defineSymbol(ParserRuleContext ctx, Symbol s) {

//        TODO: Em vez de ir buscar o scope através da variável currentScope, devo usar o atributo scopes

//        if (!this.scopes.get(ctx).define(s)) {
//            System.err.println("Redefining previously defined variable " + s.name + " in line " + ctx.start.getLine());
//            this.semanticErrors++;
//            return false;
//        }

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
        System.out.println(this.currentScope.toString());
    }


    public void exitExpression(Projeto.ExpressionContext ctx) {
        exprType.put(ctx,exprType.get(ctx.expression_evaluation()));
    }

    public void exitSimpExp(Projeto.SimpExpContext ctx) {
        exprType.put(ctx,exprType.get(ctx.simple_expression()));
    }


    //expr --> ID;
    public void exitVar(Projeto.VarContext ctx)
    {
        String variableName = ctx.IDENTIFIER().getText();
        Symbol s = this.currentScope.resolve(variableName);
        if(s == null)
        {
            System.err.println("Undefined variable " + variableName + " in line " + ctx.IDENTIFIER().getSymbol().getLine() + " position " + ctx.IDENTIFIER().getSymbol().getCharPositionInLine());
            this.semanticErrors++;
            //this.validated = false;
            exprType.put(ctx,Symbol.PType.ERROR);
            return;
        }

        if(s instanceof FunctionSymbol)
        {
            System.err.println("Using function symbol " + variableName + " as variable in line " + ctx.IDENTIFIER().getSymbol().getLine());
            this.semanticErrors++;
            //this.validated = false;
            exprType.put(ctx,Symbol.PType.ERROR);
            return;
        }
        exprType.put(ctx,s.type);
    }

    //function_arg : type IDENTIFIER;
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
            scopes.put(ctx, f.scope);
        }
    }


    // special_function : INT ALG LPAREN INT N COMMA STRING_POINTER ARGS RPAREN body;
    public void exitSpecial_function(Projeto.Special_functionContext ctx) {
        //imprimir o enquadramento local, só para efeito de debug
        System.out.println("Local scope for function " + this.currentFunction.name + ": " + this.currentScope.toString());
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
            scopes.put(ctx.IDENTIFIER(), currentScope);
        }
    }

    //id_invocation : IDENTIFIER LPAREN list_expressions? RPAREN;
    public void enterId_invocation(Projeto.Id_invocationContext ctx) {
        String functionName = ctx.IDENTIFIER().getText();
        scopes.put(ctx, currentScope);
    }

    // function_normal: function_type IDENTIFIER LPAREN function_args* RPAREN body;
    public void exitFunction_normal(Projeto.Function_normalContext ctx) {
        System.out.println("Local scope for function " + this.currentFunction.name + ": " + this.currentScope.toString());
        this.functions.put(ctx.IDENTIFIER(), this.currentFunction);
        this.currentFunction = null;
        currentScope = currentScope.getParentScope();
    }


    // function_arg: type IDENTIFIER;
    public void enterFunction_arg(Projeto.Function_argContext ctx) {
    }


    //var_declaration_simple: type IDENTIFIER ((COMMA IDENTIFIER)+)* ;
    public void enterVar_declaration_simple(Projeto.Var_declaration_simpleContext ctx) {

    }


    //var_declaration_simple: type IDENTIFIER ((COMMA IDENTIFIER)+)* ;
    public void exitVar_declaration_simple(Projeto.Var_declaration_simpleContext ctx) {
        for (int i = 0; i < ctx.IDENTIFIER().size(); i++) {
            Symbol symbol = new Symbol(ctx.type().start.getText(), ctx.IDENTIFIER().get(i).getText());
            defineSymbol(ctx, symbol);
        }
    }


    //type IDENTIFIER EQUAL expression | type IDENTIFIER EQUAL (LBRACKET expression RBRACKET | NULL)
    public void enterVar_declaration_init(Projeto.Var_declaration_initContext ctx) {
    }

    //type IDENTIFIER EQUAL expression | type IDENTIFIER EQUAL (LBRACKET expression RBRACKET | NULL)
    public void exitVar_declaration_init(Projeto.Var_declaration_initContext ctx) {
        defineSymbol(ctx, new Symbol(ctx.type().start.getText(), ctx.IDENTIFIER().getText()));
    }


    //attribution_instruction: (IDENTIFIER | expression) EQUAL expression;
    public void enterAttribution_instruction(Projeto.Attribution_instructionContext ctx) {
    }


    //attribution_instruction: (IDENTIFIER | expression) EQUAL expression;
    public void exitAttribution_instruction(Projeto.Attribution_instructionContext ctx) {
        String variableName = ctx.IDENTIFIER().getText();
        Symbol s = this.currentScope.resolve(variableName);
        if (s == null) {
            System.err.println("Undefined variable " + variableName + " in line " + ctx.IDENTIFIER().getSymbol().getLine() + " position: " + ctx.IDENTIFIER().getSymbol().getCharPositionInLine());
            this.semanticErrors++;
            exprType.put(ctx, Symbol.PType.ERROR);
            return;
        }
        if (s instanceof FunctionSymbol) {
            System.err.println("Using function symbol " + variableName + " as variable in line " + ctx.IDENTIFIER().getSymbol().getLine() + " position: " + ctx.IDENTIFIER().getSymbol().getCharPositionInLine());
            this.semanticErrors++;
            exprType.put(ctx, Symbol.PType.ERROR);
            return;
        }
        exprType.put(ctx, s.type);
    }


//
//    //id_invocation : IDENTIFIER LPAREN list_expressions? RPAREN;
//    public void exitId_invocation(Projeto.Id_invocationContext ctx) {
//        String functionName = ctx.IDENTIFIER().getText();
//        Symbol s = this.currentScope.resolve(functionName);
//        if (s == null) {
//            System.err.println("Undefined function " + functionName + " in line " + ctx.IDENTIFIER().getSymbol().getLine() + " position: " + ctx.IDENTIFIER().getSymbol().getCharPositionInLine());
//            this.semanticErrors++;
//            exprType.put(ctx, Symbol.PType.ERROR);
//            return;
//        }
//        if (!(s instanceof FunctionSymbol)) {
//            System.err.println("Using var symbol " + functionName + " as function in line " + ctx.IDENTIFIER().getSymbol().getLine() + " position: " + ctx.IDENTIFIER().getSymbol().getCharPositionInLine());
//            this.semanticErrors++;
//            exprType.put(ctx, Symbol.PType.ERROR);
//            return;
//        }
//        exprType.put(ctx, s.type);
//    }
//    //TODO: Adicionar a verificação de que a lista de expressões da invocação bate certo com a lista de parametros da função}


}

