package Alg;

import Symbols.FunctionSymbol;
import Symbols.Scope;
import Symbols.Symbol;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.List;

public class TypeChecker extends ProjetoBaseListener {

    public Scope globalScope;
    public Scope currentScope;
    public int semanticErrors;
    public boolean validated;
    public boolean haveAlg;
    public boolean isInsideWhile;
    public boolean isInsideSubBlock;
    public ParseTreeProperty<Symbol.PType> exprType = new ParseTreeProperty<>();
    public ParseTreeProperty<Scope> scopes = new ParseTreeProperty<>();
    public ParseTreeProperty<FunctionSymbol> functions = new ParseTreeProperty<>();
    private FunctionSymbol currentFunction;

    //program :
    //        EOF {notifyErrorListeners("Program must have at least one declaration");}
    //    |   declaration+ EOF;
    public void enterProgram(Projeto.ProgramContext ctx) {
        globalScope = new Scope(null);
        currentScope = globalScope;
        scopes.put(ctx, currentScope);
        this.semanticErrors = 0;
        this.validated = true;
        haveAlg = false;
    }

    //program :
    //        EOF {notifyErrorListeners("Program must have at least one declaration");}
    //    |   declaration+ EOF;
    public void exitProgram(Projeto.ProgramContext ctx) {
        if (!haveAlg)
            System.err.println("Must declare alg(int n, <string> args) function");
    }

    //var_declaration_simple:type IDENTIFIER ((COMMA IDENTIFIER)+)* ;
    public void exitVar_declaration_simple(Projeto.Var_declaration_simpleContext ctx) {
        for (int i = 0; i < ctx.IDENTIFIER().size(); i++) {
            defineSymbol(ctx, new Symbol(ctx.type().start.getText(), ctx.IDENTIFIER().get(i).getText()));
        }
    }


    //id_invocation : IDENTIFIER LPAREN list_expressions? RPAREN;
    public void enterId_invocation(Projeto.Id_invocationContext ctx) {
        this.scopes.put(ctx, this.currentScope);
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
        this.functions.put(ctx.IDENTIFIER(), this.currentFunction);
        this.currentFunction = null;
        currentScope = currentScope.getParentScope();
    }

    //function_arg: function_arg IDENTIFIER
    public void exitFunction_arg(Projeto.Function_argContext ctx) {
        String type = ctx.type().start.getText();
        String name = ctx.IDENTIFIER().getText();

        Symbol parameter = new Symbol(type, name);
        if (defineSymbol(ctx, parameter) && this.currentFunction != null) {
            this.currentFunction.arguments.add(parameter);
        }
    }

    //subblock_instruction: LBLOCK instruction* RBLOCK
    public void exitSubblock_instruction(Projeto.Subblock_instructionContext ctx) {
        this.isInsideSubBlock = false;
        List<Projeto.InstructionContext> listOfIns = ctx.instruction();
        int numberOfIns = listOfIns.size();
        if (this.isInsideWhile) {
            int indexOfRestartOrLeave = checkLeaveOrRestartIndex(listOfIns);
            if (indexOfRestartOrLeave != -1 && indexOfRestartOrLeave < numberOfIns - 1) {
                this.validated = false;
                this.semanticErrors++;
                System.err.println("Leave or restart instruction on function " + this.currentFunction.name + " is not the last instruction of the sub block. Line: " + listOfIns.get(indexOfRestartOrLeave).start.getLine());
                return;
            }
        }
        int indexOfResult = checkResultIndex(listOfIns);

        if (this.currentFunction.type != Symbol.PType.VOID) {
            if (indexOfResult != -1 && indexOfResult < numberOfIns - 1) {
                this.validated = false;
                this.semanticErrors++;
                System.err.println("Return on sub block of function " + this.currentFunction.name + " is not the last instruction. Line: " + listOfIns.get(indexOfResult).start.getLine());
            }
        } else {
            if (this.currentFunction.hasReturn) {
                if (indexOfResult != -1 && indexOfResult < numberOfIns - 1) {
                    this.validated = false;
                    this.semanticErrors++;
                    System.err.println("Return on sub block of function " + this.currentFunction.name + " is not the last instruction. Line: " + listOfIns.get(indexOfResult).start.getLine());
                }
            }
        }
    }

    //subblock_instruction: LBLOCK instruction* RBLOCK
    public void enterSubblock_instruction(Projeto.Subblock_instructionContext ctx) {
        this.isInsideSubBlock = true;
    }

    //instruction : cicle_instruction;
    public void enterCicle_instruction(Projeto.Cicle_instructionContext ctx) {
        this.isInsideWhile = true;
    }

    //instruction : cicle_instruction;
    public void exitCicle_instruction(Projeto.Cicle_instructionContext ctx) {
        this.isInsideWhile = false;
    }

    //control_instructions: LEAVE
    public void exitLeave(Projeto.LeaveContext ctx) {
        if (!this.isInsideWhile && !this.isInsideSubBlock) {
            this.validated = false;
            this.semanticErrors++;
            System.err.println("The leave instruction declared in line " + ctx.start.getLine() + " needs to be inside the sub block of a cycle.");
        }

    }

    //control_instructions: RESTART
    public void exitRestart(Projeto.RestartContext ctx) {
        if (!this.isInsideWhile && !this.isInsideSubBlock) {
            this.validated = false;
            this.semanticErrors++;
            System.err.println("The restart instruction declared in line " + ctx.start.getLine() + " needs to be inside the sub block of a cycle.");
        }
    }


    //-------------------------------- HELPER METHODS-----------------------------------------------//

    //checks index of first 'result' in list of instructions
    public int checkResultIndex(List<Projeto.InstructionContext> listOfIns) {
        int result = -1;
        int i = 0;
        for (Projeto.InstructionContext listOfVarsOrIn : listOfIns) {
            if (listOfVarsOrIn.start.getText().equals("return")) {
                result = i;
                break;
            }
            i++;
        }
        return result;
    }

    //checks index of first 'restart' or 'leave' in list of instructions
    public int checkLeaveOrRestartIndex(List<Projeto.InstructionContext> listOfIns) {
        int result = -1;
        int i = 0;
        for (Projeto.InstructionContext listOfIn : listOfIns) {
            if (listOfIn.start.getText().equals("restart") || listOfIn.start.getText().equals("leave")) {
                result = i;
                break;
            }
            i++;
        }
        return result;
    }

    //defines symbol in the current scope
    private boolean defineSymbol(ParserRuleContext ctx, Symbol s) {
        if (!this.currentScope.define(s)) {
            this.semanticErrors++;
            this.validated = false;
            System.err.println("Redefining previously defined variable '" + s.name + "' in line " + ctx.start.getLine());
            return false;
        }
        this.scopes.put(ctx, currentScope);
        return true;
    }
}
