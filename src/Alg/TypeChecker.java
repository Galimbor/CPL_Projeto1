package Alg;

import Symbols.FunctionSymbol;
import Symbols.Operator;
import Symbols.Scope;
import Symbols.Symbol;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class TypeChecker extends ProjetoBaseListener {


//    TODO - Take care of the variables for expressions.. I need to look in the table of symbols for the variable and retrieve its type..

    public Scope globalScope;
    public Scope currentScope;
    private FunctionSymbol currentFunction;
    public boolean validated;

    ParseTreeProperty<Symbol.PType> exprType = new ParseTreeProperty<>();
    ParseTreeProperty<Operator.PType> opType = new ParseTreeProperty<>();

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


    public void exitVar_declaration_simple(Projeto.Var_declaration_simpleContext ctx) {
        for (int i = 0; i < ctx.IDENTIFIER().size(); i++) {
            defineSymbol(ctx, new Symbol(ctx.type().start.getText(), ctx.IDENTIFIER().get(i).getText()));
        }
    }

//    type IDENTIFIER EQUAL expression
//    |   type IDENTIFIER EQUAL (LBRACKET expression RBRACKET | NULL)
    public void exitVar_declaration_init(Projeto.Var_declaration_initContext ctx) {

        String type = ctx.type().start.getText();
        if(!isAValidPointerType(type))
        {
            //TODO - adicionar na exprType table quando a implementarmos
            this.validated = false;
        }
//        TODO - VERIFICAR SE A EXPRESSAO E INTEIRA


        defineSymbol(ctx, new Symbol(ctx.type().start.getText(), ctx.IDENTIFIER().getText()));
    }





// expression_evaluation : expression_evaluation (DIV | MUL | PERCENT) expression_evaluation
        public void exitMulDivRem(Projeto.MulDivRemContext ctx)
        {

        Operator.PType op = opType.get(ctx.binary_op_MUL_DIV_REM());

        if(op == Operator.PType.MUL | op == Operator.PType.DIV)
        {
            Symbol.PType e1 = exprType.get(ctx.expression_evaluation(0));
            Symbol.PType e2 = exprType.get(ctx.expression_evaluation(1));

            if(e1 == Symbol.PType.ERROR || e2 == Symbol.PType.ERROR) exprType.put(ctx, Symbol.PType.ERROR);

            if(e1 == Symbol.PType.INT && e2 == Symbol.PType.INT) exprType.put(ctx, Symbol.PType.INT);
            else if( e1 == Symbol.PType.FLOAT && e2 == Symbol.PType.FLOAT) exprType.put(ctx, Symbol.PType.FLOAT);
            else if(e1 == Symbol.PType.FLOAT && e2 == Symbol.PType.INT) exprType.put(ctx, Symbol.PType.FLOAT);
            else if(e1 == Symbol.PType.INT && e2 == Symbol.PType.FLOAT) exprType.put(ctx, Symbol.PType.FLOAT);
            else{
                System.err.println("Invalid types for * or / operator " + e1.toString() + " " + e2.toString() + " on line " + ctx.start.getLine());
                this.validated = false;
                exprType.put(ctx, Symbol.PType.ERROR);
            }
        }
        else if(op == Operator.PType.REM)
        {
            Symbol.PType e1 = exprType.get(ctx.expression_evaluation(0));
            Symbol.PType e2 = exprType.get(ctx.expression_evaluation(1));

            if(e1 == Symbol.PType.ERROR || e2 == Symbol.PType.ERROR) exprType.put(ctx, Symbol.PType.ERROR);

            if(e1 == Symbol.PType.INT && e2 == Symbol.PType.INT) exprType.put(ctx, Symbol.PType.INT);
            else{
                System.err.println("Invalid types for % operator " + e1.toString() + " " + e2.toString() + " on line " + ctx.start.getLine());
                this.validated = false;
                exprType.put(ctx, Symbol.PType.ERROR);
            }
        }
        else{
            System.err.println("Invalid operator " + op.toString() + " on line " + ctx.start.getLine());
            this.validated = false;
            exprType.put(ctx, Symbol.PType.ERROR);
        }


    }

// expression_evaluation = unary_operators expression_evaluation
   public void exitUnaryExp(Projeto.UnaryExpContext ctx)
    {
        String operator = ctx.start.getText();

        Symbol.PType e1 = exprType.get(ctx.expression_evaluation());

        if(operator.equals("+") || operator.equals("-"))
        {
            if(e1 == Symbol.PType.INT || e1 == Symbol.PType.FLOAT) exprType.put(ctx, e1);
            else{
                System.err.println("Invalid operand type " + e1.toString() + " on line " + ctx.start.getLine());
                this.validated = false;
                exprType.put(ctx, Symbol.PType.ERROR);
            }
        }
        else if(operator.equals("~"))
        {
            if(e1 == Symbol.PType.BOOLEAN) exprType.put(ctx, e1);
            else{
                System.err.println("Invalid operand type " + e1.toString() + " on line " + ctx.start.getLine());
                this.validated = false;
                exprType.put(ctx, Symbol.PType.ERROR);
            }
        }
        else if(operator.equals("?") )
        {
            if(Symbol.isPrimitive(e1))
            {
                Symbol.PType primitivePointer = primitiveToPointer(e1);
                exprType.put(ctx, primitivePointer);
            }
            else{
                System.err.println("Invalid type" + e1.toString() + " on line " + ctx.start.getLine());
                this.validated = false;
                exprType.put(ctx, Symbol.PType.ERROR);
            }
        }
    }



// expression_evaluation = expression_evaluation LBRACKET expression_evaluation RBRACKET
    public void exitPointerExp(Projeto.PointerExpContext ctx)
    {
        Symbol.PType e1 = exprType.get(ctx.expression_evaluation(0));
        Symbol.PType e2 = exprType.get(ctx.expression_evaluation(1));


        if(!(e1 == Symbol.PType.BOOL_POINTER || e1 == Symbol.PType.INT_POINTER || e1 == Symbol.PType.FLOAT_POINTER || e1 == Symbol.PType.STRING_POINTER))
        {
            System.err.println("Invalid type for E1[E2] operator " + e1.toString() + " " + e2.toString() + " on line " + ctx.start.getLine());
            this.validated = false;
            exprType.put(ctx, Symbol.PType.ERROR);
        }
        if(e2 != Symbol.PType.INT)
        {
            System.err.println("E2 is not an integer but a  " + e2.toString() + " on line " + ctx.start.getLine());
            this.validated = false;
            exprType.put(ctx, Symbol.PType.ERROR);
        }
        exprType.put(ctx, e1);
    }


//  expression_evaluation : LPAREN expression_evaluation RPAREN
    public void exitParenExp(Projeto.ParenExpContext ctx)
    {
        Symbol.PType expressionType = exprType.get(ctx.expression_evaluation());
        exprType.put(ctx, expressionType);
    }





// expression_evaluation : simple_expression
    public void exitSimpExp(Projeto.SimpExpContext ctx)
    {
        Symbol.PType expressionType = exprType.get(ctx.simple_expression());
        exprType.put(ctx, expressionType);

    }

    //expression_evaluation : expression_evaluation binary_op_ADD_SUB expression_evaluation
    public void exitAddSub(Projeto.AddSubContext ctx)
    {
        Symbol.PType e1 = exprType.get(ctx.expression_evaluation(0));
        Symbol.PType e2 = exprType.get(ctx.expression_evaluation(1));
        if(e1 == Symbol.PType.ERROR || e2 == Symbol.PType.ERROR) exprType.put(ctx, Symbol.PType.ERROR);
        else if( (e1 == Symbol.PType.INT || e1 == Symbol.PType.FLOAT) && (e2 == Symbol.PType.FLOAT || e2 == Symbol.PType.INT) )
        {

            if(e1 == Symbol.PType.INT && e2 == Symbol.PType.INT) exprType.put(ctx, Symbol.PType.INT);
            else{
                exprType.put(ctx, Symbol.PType.FLOAT);
            }
        }
        else if(Symbol.isAPrimitivePointer(e1) && e2 == Symbol.PType.INT)
        {
            exprType.put(ctx, e1);

        }
        else{
            System.out.println(e1 + " " + e2);
            System.err.println("Something is wrong on line " + ctx.start.getLine());
            this.validated = false;
            exprType.put(ctx, Symbol.PType.ERROR);
        }

    }



    public void exitInt(Projeto.IntContext ctx)
    {
        exprType.put(ctx, Symbol.PType.INT);
    }

    public void exitReal(Projeto.RealContext ctx)
    {
        exprType.put(ctx, Symbol.PType.FLOAT);
    }


    public void exitString(Projeto.StringContext ctx)
    {
        exprType.put(ctx, Symbol.PType.STRING);
    }

    public void exitNull(Projeto.StringContext ctx)
    {
        exprType.put(ctx, Symbol.PType.NULL);
    }

    public void exitTrue(Projeto.StringContext ctx)
    {
        exprType.put(ctx, Symbol.PType.BOOLEAN);
    }

    public void exitFalse(Projeto.StringContext ctx)
    {
        exprType.put(ctx, Symbol.PType.BOOLEAN);
    }

    public  void exitMul(Projeto.MulContext ctx)
    {
        opType.put(ctx, Operator.PType.MUL);
    }


    public  void exitDiv(Projeto.DivContext ctx)
    {
        opType.put(ctx, Operator.PType.DIV);
    }


    public  void exitPercent(Projeto.PercentContext ctx)
    {
        opType.put(ctx, Operator.PType.REM);
    }

    public void exitLesser(Projeto.LesserContext ctx){opType.put(ctx,Operator.PType.LESSER);}

    public void exitLesseq(Projeto.LesseqContext ctx){opType.put(ctx,Operator.PType.LESSEQ);}

    public void exitGreater(Projeto.GreaterContext ctx){opType.put(ctx,Operator.PType.GREATER);}

    public void exitGreateq(Projeto.GreateqContext ctx){opType.put(ctx,Operator.PType.GREATEQ);}

    public void exitEquals(Projeto.EqualsContext ctx){opType.put(ctx,Operator.PType.EQUALS);}

    public void exitNotequals(Projeto.NotequalsContext ctx){opType.put(ctx,Operator.PType.NOTEQUALS);}

    public void exitVar(Projeto.VarContext ctx){
        String variableName = ctx.IDENTIFIER().getText();
        Symbol s = this.currentScope.resolve(variableName);

        if(s == null)
        {
            System.err.println("Undefined variable  " + variableName + " in line " +  ctx.IDENTIFIER().getSymbol().getLine() + " position " +  ctx.IDENTIFIER().getSymbol().getCharPositionInLine());
            exprType.put(ctx,Symbol.PType.ERROR);
            this.validated = false;
            return;
        }
        if(s instanceof  FunctionSymbol)
        {
            System.err.println("Using function symbol " + variableName + " as variable in line " + ctx.IDENTIFIER().getSymbol().getLine());
            exprType.put(ctx,Symbol.PType.ERROR);
            this.validated = false;
            return;

        }
        exprType.put(ctx, s.type);
    }


    public void exitCompOther(Projeto.CompOtherContext ctx){
        Symbol.PType e1 = exprType.get(ctx.expression_evaluation(0));
        Symbol.PType e2 = exprType.get(ctx.expression_evaluation(1));

        Operator.PType op = opType.get(ctx.comparators());

        if(Operator.isSimpleOperator(op))
        {
            if(Symbol.isNumeric(e1) && Symbol.isNumeric(e2))
            {
                exprType.put(ctx, Symbol.PType.BOOLEAN);
            }
            else
            {
                System.err.println("Something is wrong on line " + ctx.start.getLine());
                this.validated = false;
                exprType.put(ctx, Symbol.PType.ERROR);
            }
        }
        else if(Operator.isEQualOperator(op))
        {
             if(Symbol.isPrimitive(e1) && Symbol.isPrimitive(e2))
             {
                 if(e1 == e2)
                 {
                     exprType.put(ctx, Symbol.PType.BOOLEAN);
                 }
                 else{
                     System.err.println("They should be of the same type" + ctx.start.getLine());
                     this.validated = false;
                     exprType.put(ctx, Symbol.PType.ERROR);
                 }
             }
             else if(Symbol.isAPointer(e1) && Symbol.isAPointer(e2))
             {
                 if(e1 == Symbol.PType.VOID_POINTER || e2 == Symbol.PType.VOID_POINTER) exprType.put(ctx, Symbol.PType.BOOLEAN);
                 else if(Symbol.areBothTypesEqual(e1,e2))
                 {
                     exprType.put(ctx, Symbol.PType.BOOLEAN);
                 }
                 else
                 {
                     System.err.println("They should be of the same type" + ctx.start.getLine());
                     this.validated = false;
                     exprType.put(ctx, Symbol.PType.ERROR);
                 }
             }
        }
        else{
            System.err.println("Something is wrong on line " + ctx.start.getLine());
            this.validated = false;
            exprType.put(ctx, Symbol.PType.ERROR);
        }

    }

    public void exitCompAnd(Projeto.CompAndContext ctx)
    {
        Symbol.PType e1 = exprType.get(ctx.expression_evaluation(0));
        Symbol.PType e2 = exprType.get(ctx.expression_evaluation(1));

        if(e1 == Symbol.PType.BOOLEAN && e2 == Symbol.PType.BOOLEAN)
        {
            exprType.put(ctx, Symbol.PType.BOOLEAN);
        }
        else
        {
            System.err.println("Something is wrong on line " + ctx.start.getLine());
            this.validated = false;
            exprType.put(ctx, Symbol.PType.ERROR);
        }

    }

    public void exitCompOr(Projeto.CompOrContext ctx)
    {
        Symbol.PType e1 = exprType.get(ctx.expression_evaluation(0));
        Symbol.PType e2 = exprType.get(ctx.expression_evaluation(1));

        if(e1 == Symbol.PType.BOOLEAN && e2 == Symbol.PType.BOOLEAN)
        {
            exprType.put(ctx, Symbol.PType.BOOLEAN);
        }
        else
        {
            System.err.println("Something is wrong on line " + ctx.start.getLine());
            this.validated = false;
            exprType.put(ctx, Symbol.PType.ERROR);
        }

    }





//    AUXILIAR FUNCTIONS

    private boolean isAValidPointerType(String type)
    {
        boolean result = false;
        if (type.equals("<int>"))
            result = true;
        else if (type.equals("<float>"))
            result = true;
        else if (type.equals("<string>"))
            result = true;
        else if (type.equals("<bool>"))
            result = true;
        return result;
    }

//    private String retrieveMulDivRemOperator (Projeto.MulDivRemContext ctx)
//    {
//        String operator = "";
//        if(ctx.DIV() != null) operator = ctx.DIV().getText();
//        else if(ctx.MUL() != null) operator = ctx.MUL().getText();
//        else if(ctx.PERCENT() != null) operator = ctx.PERCENT().getText();
//        return operator;
//    }





    private Symbol.PType primitiveToPointer(Symbol.PType e1)
    {
        if (e1 == Symbol.PType.BOOLEAN) return Symbol.PType.BOOL_POINTER;
        else if(e1 == Symbol.PType.FLOAT) return Symbol.PType.FLOAT_POINTER;
        else if(e1 == Symbol.PType.STRING) return Symbol.PType.STRING_POINTER;
        else{
            return Symbol.PType.ERROR;
        }
    }




}
