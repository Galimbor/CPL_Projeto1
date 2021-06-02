package Alg;

import Symbols.Scope;
import Symbols.Symbol;
import Symbols.Type;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CodeGen extends ProjetoBaseVisitor<Symbol>{

    private int tmpCounter = 0;
    private int labelCounter = 0;
    private BufferedWriter out;
    private Scope globalScope;
    public List<String> code;
    private Stack<String> whileAfterLabels;
    private Stack<String> whileBeforeLabels;

    public ParseTreeProperty<Scope> scopes;

    public  CodeGen(ParseTreeProperty<Scope> scopes)
    {
        this.scopes = scopes;
        code = new ArrayList<String>();
        this.whileAfterLabels = new Stack<>();
        this.whileBeforeLabels = new Stack<>();
    }

    private Symbol widen(ParserRuleContext ctx, Symbol addr, Type down, Type up)
    {
        //se são do mesmo tipo não há cast a fazer
        if(down.equals(up)) return addr;
        else if(Type.isConvertibleTo(down,up))
        {
            Symbol t = temp(ctx,up);
            emit(t.name + " = (" + up + ") " + addr.name );
            return t;
        }
        return null;
    }

    private int emit(String s)
    {
        this.code.add(s);
        return this.code.size()-1;
    }

    private void replace(int line, String s)
    {
        this.code.set(line,s);
    }

    private Symbol temp(ParserRuleContext ctx, Type t)
    {
        return this.scopes.get(ctx).defineTemp(t);
    }

    private String label()
    {
        return "_L" + this.labelCounter++;
    }

    private String label(String name)
    {
        return "_L" + name + this.labelCounter++;
    }

    //start : decl+ EOF;
    public Symbol visitProgram(Projeto.ProgramContext ctx)
    {
        //initialize the Global scope
        this.globalScope = this.scopes.get(ctx);
        visitChildren(ctx);
        //only expressions need to return a proper symbol
        return null;
    }

    //variable declarations and initialization
    //v_decl --> type IDENT EQUAL (exp | LRECT exp RRECT) #VarDeclInit;
    //we don't need to do anything for the variable declaration, but we do have to do for initialization
    //Task T1
//    public Symbol visitDeclAndAtrib(Projeto.DeclAndAtribContext ctx)
//    {
//        //TOD
//    }

    //simple expressions
    //simple_exp --> LINT;
    public Symbol visitInt(Projeto.IntContext ctx)
    {
        Symbol s = new Symbol(new Type(Type.PType.INT),ctx.getText(), ctx.getText());
        //literal constants can be stored as constants in the global scope, indexed by their value
        this.globalScope.define(s);
        //we need to resolve, because it might be the case that the same constant was already declared, and in this case
        //we return the previously created symbol instead of a new one
        return globalScope.resolve(s.name);
    }

    //simple_exp --> LITERAL_R
    public Symbol visitReal(Projeto.RealContext ctx)
    {
        Symbol s = new Symbol(new Type(Type.PType.FLOAT),ctx.getText(),ctx.getText());
        //literal constants can be stored as constants in the global scope, indexed by their value
        this.globalScope.define(s);
        //we need to resolve, because it might be the case that the same constant was already declared, and in this case
        //we return the previously created symbol instead of a new one
        return globalScope.resolve(s.name);
    }

    //simple_exp --> LITERAL_STRING
    public Symbol visitString(Projeto.StringContext ctx)
    {
        String strText = ctx.getText();
        //we need to remove the trailing "" and add the null character
        strText = strText.substring(1,strText.length()-1) + "\u0000";
        //Strings are special because they are a dynamic multi-byte type
        //however, the size of a string literal is well-known in compile-time, so in this particular case
        // we can properly calculate its size
        Symbol s = new Symbol(new Type(Type.PType.STRING),strText,strText);
        s.width = s.type.getWidth() * strText.length(); //we need one extra space for the end of string character \u0000
        //literal constants can be stored as constants in the global scope, indexed by their value
        s.isWidthKnown = true;
        this.globalScope.define(s);
        //we need to resolve, because it might be the case that the same constant was already declared, and in this case
        //we return the previously created symbol instead of a new one
        return globalScope.resolve(s.name);
    }

    //simple_exp --> Null
    public Symbol visitNull(Projeto.NullContext ctx)
    {
        //returns the special symbol null. This one doesn't even need to be stored in the symbol table
        return new Symbol(new Type(true, Type.PType.VOID),"null","null");
    }

    //simple_exp --> (TRUE|FALSE)
    public Symbol visitFalse(Projeto.FalseContext ctx)
    {
        Symbol s = new Symbol(new Type(Type.PType.BOOL),ctx.getText(),ctx.getText());
        //literal constants can be stored as constants in the global scope, indexed by their value
        this.globalScope.define(s);
        //we need to resolve, because it might be the case that the same constant was already declared, and in this case
        //we return the previously created symbol instead of a new one
        return globalScope.resolve(s.name);
    }

    //simple_exp --> (TRUE|FALSE)
    public Symbol visitTrue(Projeto.TrueContext ctx)
    {
        Symbol s = new Symbol(new Type(Type.PType.BOOL),ctx.getText(),ctx.getText());
        //literal constants can be stored as constants in the global scope, indexed by their value
        this.globalScope.define(s);
        //we need to resolve, because it might be the case that the same constant was already declared, and in this case
        //we return the previously created symbol instead of a new one
        return globalScope.resolve(s.name);
    }

    //simple_exp --> IDENT
    public Symbol visitVar(Projeto.VarContext ctx)
    {
        return this.scopes.get(ctx).resolve(ctx.IDENTIFIER().getText());
    }

    public Symbol visitSimpExp(Projeto.SimpExpContext ctx)
    {
        return visit(ctx.simple_expression());
    }

    public Symbol visitParenExp(Projeto.ParenExpContext ctx)
    {
        return visit(ctx.expression_evaluation());
    }

//    //Task T2
//    //exp --> QMark left_side #PointerExtract
//    public Symbol visitPointerExtract(Projeto.PointerExtractContext ctx)
//    {
//        //TODO
//    }

    //Task T3
    //exp --> exp LRECT exp RRECT #PointerAccess
    //usado no lado direito de uma atribuição, ou como uma expressão sózinha.
    public Symbol visitPointerExp(Projeto.PointerExpContext ctx)
    {
//        Retirar o simbolo resultante da primeira expressao
        Symbol t1 = visit(ctx.expression_evaluation(0));
//        Retirar o simbolo resultante da segunda expressao
        Symbol t2 = visit(ctx.expression_evaluation(1));

//        Comecar por "calcular" o numero de posicoes a avancar na memoria
        Symbol displacement = this.temp(ctx,t2.type);
        emit(displacement.name + " = " + t2.value + " * " +  t1.width);

//        Indexar em t1 utilizando o displacement
        Symbol value = this.temp(ctx,t1.type);
        emit(value.name + " = " + t1.name + "[" +  displacement.name + "]");

        return value;

    }

    public Symbol visitUnaryExp(Projeto.UnaryExpContext ctx)
    {
        String op = "";
        int opType = ctx.unary_operators().start.getType();
        Symbol s1 = visit(ctx.expression_evaluation());
        //if it is a + we don't need to do anything
        if(opType==ProjetoLexer.ADD) return s1;
        if(opType==ProjetoLexer.SUB)
        {
            op = "-";
        }
        else if(opType == ProjetoLexer.TILT)
        {
            op = "not";
        }

        Symbol t = this.temp(ctx,s1.type);
        emit(t.name + " = " + op + " " +  s1.name);
        return t;
    }

    public Symbol visitMulDivRem(Projeto.MulDivRemContext ctx)
    {
        Symbol t1 = visit(ctx.expression_evaluation(0));
        Symbol t2 = visit(ctx.expression_evaluation(1));
        Type maxType = Type.getMaxType(t1.type,t2.type);
        t1 = widen(ctx,t1,t1.type,maxType);
        t2 = widen(ctx,t2,t2.type,maxType);
        String op = ctx.binary_op_MUL_DIV_REM().getText();

        Symbol t = this.temp(ctx,maxType);
        emit(t.name + " = " + t1.name + " " + op + " " + t2.name);
        return t;
    }

    public Symbol visitAddSub(Projeto.AddSubContext ctx) {

        Symbol t1 = visit(ctx.expression_evaluation(0));
        Symbol t2 = visit(ctx.expression_evaluation(1));
        Type maxType = Type.getMaxType(t1.type,t2.type);
        t1 = widen(ctx,t1,t1.type,maxType);
        t2 = widen(ctx,t2,t2.type,maxType);
        String op = ctx.binary_op_ADD_SUB().getText();

        Symbol t = this.temp(ctx,maxType);
        emit(t.name + " = " + t1.name + " " + op + " " + t2.name);
        return t;
    }

    public Symbol visitCompOther(Projeto.CompOtherContext ctx) {

        Symbol t1 = visit(ctx.expression_evaluation(0));
        Symbol t2 = visit(ctx.expression_evaluation(1));
        Type maxType = Type.getMaxType(t1.type,t2.type);
        t1 = widen(ctx,t1,t1.type,maxType);
        t2 = widen(ctx,t2,t2.type,maxType);
        String op = ctx.comparators().getText();
        Symbol t = this.temp(ctx,new Type(Type.PType.BOOL));
        emit(t.name + " = " + t1.name + " " + op + " " + t2.name);
        return t;
    }

    public Symbol visitCompAnd(Projeto.CompAndContext ctx)
    {
        Symbol t1 = visit(ctx.expression_evaluation(0));
        Symbol t2 = visit(ctx.expression_evaluation(1));
        Symbol t = this.temp(ctx,new Type(Type.PType.BOOL));

        emit(t.name + "=" + t1.name + " and " + t2.name);
        return t;
    }

    public Symbol visitCompOr(Projeto.CompOrContext ctx)
    {
        Symbol t1 = visit(ctx.expression_evaluation(0));
        Symbol t2 = visit(ctx.expression_evaluation(1));
        Symbol t = this.temp(ctx,new Type(Type.PType.BOOL));

        emit(t.name + "=" + t1.name + " or " + t2.name);
        return t;
    }



//    //function declarations
//    //f_decl --> (type|VOID) IDENT LPAR formalParameters? RPAR body #FunctionDecl
//    //Task T4
//    public Symbol visitFunctionDecl(Projeto.FunctionDeclContext ctx)
//    {
//        //TODO
//    }



//    //f_decl --> INT Projeto LPAR INT IDENT VIR LTHAN STRING GTHAN IDENT RPAR body #MainDecl;
//    //Task T4
//    public Symbol visitMainDecl(Projeto.MainDeclContext ctx)
//    {
//        //TODO
//    }
//
//    //function invocations
//    //f_inv --> IDENT LPAR (exp (VIR exp)*)? RPAR     #FCall
//    //Task T5
//    public Symbol visitFCall(Projeto.FCallContext ctx)
//    {
//        //TODO
//    }

    //instructions
    //inst --> exp PVIR #ExpInst
    public Symbol visitInstruction(Projeto.InstructionContext ctx)
    {
        //this is very easy, just visit the expression
//        Bela martelada que dei aqui..
        if(ctx.expression() != null)
            visit(ctx.expression());
        //It is not mandatory to return any symbol in an instruction
        return null;
    }

    //Task T6
//    //inst --> left_side EQUAL exp PVIR;
//    public Symbol visitAssign(Projeto.AssignContext ctx)
//    {
//        //TODO
//    }
//
//    //T6
//    //left_side --> IDENT
//    public Symbol visitLeftVar(Projeto.LeftVarContext ctx)
//    {
//        //TODO
//    }


    //inst --> IF exp THEN inst (ELSE inst)?   #If
    public Symbol visitConditional_instruction(Projeto.Conditional_instructionContext ctx)
    {
        Symbol condition = visit(ctx.expression());
        String falseLabel = label("false");
        emit("ifFalse " + condition.name + " goto " + falseLabel);
        visit(ctx.instruction(0));

        if(ctx.ELSE() == null)
        {
            //Single if
            emit(falseLabel + ":");
        }
        else
        {
            String nextLabel = label("next");
            emit("goto " + nextLabel);
            emit(falseLabel + ":");
            visit(ctx.instruction(1));
            emit(nextLabel + ":");
        }

        return null;
    }

//    //inst --> WHILE exp DO inst (FINALLY inst)? #While
//    //Task T8
//    public Symbol visitWhile(Projeto.WhileContext ctx)
//    {
//        //TODO
//    }
//
//    //Task T8
//    //ctrl_inst --> LEAVE #Leave
//    public Symbol visitLeave(Projeto.LeaveContext ctx)
//    {
//        //TODO
//    }
//
//    //Task T8
//    //ctrl_inst --> RESTART #Restart
//    public Symbol visitRestart(Projeto.RestartContext ctx)
//    {
//        //TODO
//    }

    public Symbol visitReturn(Projeto.ReturnContext ctx)
    {

        if(ctx.expression() != null)
        {
            Symbol returnValue = visit(ctx.expression());
            emit("return " + returnValue.name);
        }
        else
        {
            emit("return");
        }

        return null;
    }




}
