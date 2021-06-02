package Alg;

import Symbols.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.HashSet;
import java.util.Stack;

public class TypeChecker extends ProjetoBaseListener {

    public Scope globalScope;
    public Scope currentScope;
    public int semanticErrors;
    public boolean validated;
    public boolean haveAlg;
    public Stack<Boolean> isInsideWhile = new Stack<>();
    public Stack<Boolean> isInsideSubBlock = new Stack<>();

    public ParseTreeProperty<Type> exprType = new ParseTreeProperty<>();
    public ParseTreeProperty<Scope> scopes = new ParseTreeProperty<>();
    public ParseTreeProperty<FunctionSymbol> functions = new ParseTreeProperty<>();
    private FunctionSymbol currentFunction;
    private HashSet<Integer> leaveAndRestart = new HashSet<>();


//    Just for phase4
    public void exitEveryRule(ParserRuleContext ctx)
    {
        if(this.scopes.get(ctx)==null)
        {
            this.scopes.put(ctx,this.currentScope);
        }
    }



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
            defineSymbol(ctx, new Symbol(new Type(ctx.type().start.getText()), ctx.IDENTIFIER().get(i).getText()));
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
        f = new FunctionSymbol(new Type(type), functionName, this.currentScope);
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
        FunctionSymbol f = new FunctionSymbol(new Type(type), functionName, this.currentScope);
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

        Symbol parameter = new Symbol(new Type(type), name);
        if (defineSymbol(ctx, parameter) && this.currentFunction != null) {
            this.currentFunction.arguments.add(parameter);
        }
    }

    //subblock_instruction: LBLOCK instruction* RBLOCK
    public void exitSubblock_instruction(Projeto.Subblock_instructionContext ctx) {
        this.isInsideSubBlock.pop();
//        int indexOfResult = checkResultIndex(listOfIns);
//
//        if (this.currentFunction.type != Symbol.PType.VOID) {
//            if (indexOfResult != -1 && indexOfResult < numberOfIns - 1) {
//                this.validated = false;
//                this.semanticErrors++;
//                System.err.println("Return on sub block of function " + this.currentFunction.name + " is not the last instruction. Line: " + listOfIns.get(indexOfResult).start.getLine());
//            }
//        } else {
//            if (this.currentFunction.hasReturn) {
//                if (indexOfResult != -1 && indexOfResult < numberOfIns - 1) {
//                    this.validated = false;
//                    this.semanticErrors++;
//                    System.err.println("Return on sub block of function " + this.currentFunction.name + " is not the last instruction. Line: " + listOfIns.get(indexOfResult).start.getLine());
//                }
//            }
//        }
    }

    //subblock_instruction: LBLOCK instruction* RBLOCK
    public void enterSubblock_instruction(Projeto.Subblock_instructionContext ctx) {
        this.isInsideSubBlock.push(true);
    }

    //instruction : cicle_instruction;
    public void enterCicle_instruction(Projeto.Cicle_instructionContext ctx) {
        this.isInsideWhile.push(true);
    }

    //instruction : cicle_instruction;
    public void exitCicle_instruction(Projeto.Cicle_instructionContext ctx) {
        for (Projeto.InstructionContext ins : ctx.instruction()
        ) {
            int lastLine = countSubblockInstructionsLinha(ins, ctx.start.getLine());
            int leaveOrRestartLine = checkLeaveOrRestartSubblockLines(ins, ctx.start.getLine());
//            System.out.println("last line " + lastLine);
//            System.out.println("leaveorrestart line " + leaveOrRestartLine);
//            System.out.println("My line is " + ins.start.getLine());
            if (!this.leaveAndRestart.contains(leaveOrRestartLine)) {
                if (leaveOrRestartLine == -1) {

                } else if (!this.leaveAndRestart.contains(leaveOrRestartLine) && lastLine != -1 && leaveOrRestartLine < lastLine) {
                    this.validated = false;
                    this.semanticErrors++;

                    System.out.println("Last line is " + lastLine + " and leave line is " + leaveOrRestartLine);
                    System.err.println("Leave or restart instruction on function " + this.currentFunction.name + " is not the last instruction of the sub block. Line: " + leaveOrRestartLine);
                    this.leaveAndRestart.add(leaveOrRestartLine);
                }
                else {
                    this.leaveAndRestart.add(leaveOrRestartLine);
                }

            }
        }
        this.isInsideWhile.pop();
    }

    //control_instructions: LEAVE
    public void exitLeave(Projeto.LeaveContext ctx) {
        if ( this.isInsideWhile.empty()  || this.isInsideSubBlock.empty()) {
            this.validated = false;
            this.semanticErrors++;
            System.err.println("The leave instruction declared in line " + ctx.start.getLine() + " needs to be inside the sub block of a cycle.");
        }

    }

    //control_instructions: RESTART
    public void exitRestart(Projeto.RestartContext ctx) {
        if (this.isInsideWhile.empty()  || this.isInsideSubBlock.empty()) {
            this.validated = false;
            this.semanticErrors++;
            System.err.println("The restart instruction declared in line " + ctx.start.getLine() + " needs to be inside the sub block of a cycle.");
        }
    }


    //-------------------------------- HELPER METHODS-----------------------------------------------//


//    //checks index of first 'restart' or 'leave' in list of instructions
//    public int checkLeaveOrRestartIndex(List<Projeto.InstructionContext> listOfIns) {
//        int result = -1;
//        int i = 0;
//        for (Projeto.InstructionContext listOfIn : listOfIns) {
//            if (listOfIn.start.getText().equals("restart") || listOfIn.start.getText().equals("leave")) {
//                result = i;
//                break;
//            }
//            i++;
//        }
//        return result;
//    }


    public int checkLeaveOrRestartSubblockLines(Projeto.InstructionContext ctx, int line) {
        if (ctx.cicle_instruction() != null) {
            for (Projeto.InstructionContext ins : ctx.cicle_instruction().instruction()
            ) {
                if (ins.subblock_instruction() != null || ins.cicle_instruction() != null) {
                    line = checkLeaveOrRestartSubblockLines(ins, line);
                    if (line != -1) {
                        return line;
                    }
                } else if (ins.control_instructions() != null && (ins.control_instructions().start.getText().equals("leave")
                        || ins.control_instructions().start.getText().equals("restart")) && this.isInsideWhile.peek()) {
                    return ins.start.getLine();
                }
            }
        } else if (ctx.subblock_instruction() != null) {
            for (Projeto.InstructionContext ins : ctx.subblock_instruction().instruction()
            ) {
                if (ins.subblock_instruction() != null || ins.cicle_instruction() != null) {
                    line = checkLeaveOrRestartSubblockLines(ins, line);
                    if (line != -1) {
                        return line;
                    }
                } else if (ins.control_instructions() != null && (ins.control_instructions().start.getText().equals("leave")
                        || ins.control_instructions().start.getText().equals("restart"))) {
                    return ins.start.getLine();
                }
            }
        }
        return -1;
    }

    private int countSubblockInstructionsLinha(Projeto.InstructionContext ctx, int linha) {
        if (ctx.cicle_instruction() != null) {
            for (Projeto.InstructionContext ins : ctx.cicle_instruction().instruction()
            ) {
                if (ins.subblock_instruction() != null || ins.cicle_instruction() != null) {
                    linha = ins.start.getLine();
                    linha = countSubblockInstructionsLinha(ins, linha);
                } else {
                    linha = ins.start.getLine();
                }
            }
        } else if (ctx.subblock_instruction() != null) {
            for (Projeto.InstructionContext ins : ctx.subblock_instruction().instruction()
            ) {
                if (ins.subblock_instruction() != null) {
                    linha = ins.start.getLine();
                    linha = countSubblockInstructionsLinha(ins, linha);
                } else {
                    linha = ins.start.getLine();
                }
            }
        }
        return linha;
    }


    //defines symbol in the current scopeOLD
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
