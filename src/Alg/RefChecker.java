package Alg;

import Symbols.FunctionSymbol;
import Symbols.Operator;
import Symbols.Scope;
import Symbols.Symbol;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.List;

public class RefChecker extends ProjetoBaseListener {
    public Scope globalScope;
    public Scope currentScope;
    private FunctionSymbol currentFunction;
    public int semanticErrors;
    public boolean haveAlg;
    public boolean validated;

    public ParseTreeProperty<Scope> scopes;
    public ParseTreeProperty<FunctionSymbol> functions;
    public ParseTreeProperty<Symbol.PType> exprType;
    ParseTreeProperty<Operator.PType> opType = new ParseTreeProperty<>();


    public RefChecker(ParseTreeProperty<Scope> scopes, ParseTreeProperty<Symbol.PType> exprType, ParseTreeProperty<FunctionSymbol> functions) {
        this.exprType = exprType;
        this.scopes = scopes;
        this.functions = functions;
    }


    //ao entrarmos na regra inicial, criamos e inicializamos os scopes
    public void enterProgram(Projeto.ProgramContext ctx) {
        currentScope = this.scopes.get(ctx);
    }


//    public void exitProgram(Projeto.ProgramContext ctx) {
//        if (!haveAlg)   //alg function not declared
//            System.err.println("Must declare alg(int n, <string> args) function");
////        System.out.println(this.currentScope.toString());
//    }

    //id_invocation : IDENTIFIER LPAREN list_expressions? RPAREN;
    public void exitId_invocation(Projeto.Id_invocationContext ctx) {
        String functionName = ctx.IDENTIFIER().getText();
        Symbol s = scopes.get(ctx).resolve(functionName);
        if (s == null) {
            System.err.println("Undefined function " + functionName + " in line " + ctx.IDENTIFIER().getSymbol().getLine() + " position: " + ctx.IDENTIFIER().getSymbol().getCharPositionInLine());
            this.semanticErrors++;
        }
        if (!(s instanceof FunctionSymbol)) {
            System.err.println("Using var symbol " + functionName + " as function in line " + ctx.IDENTIFIER().getSymbol().getLine() + " position: " + ctx.IDENTIFIER().getSymbol().getCharPositionInLine());
            this.semanticErrors++;
        } else {
            FunctionSymbol fs = (FunctionSymbol) s;
            if (fs.arguments.size() == ctx.list_expressions().expression().size()) {
                for (int i = 0; i < ctx.list_expressions().expression().size(); i++) {
                    Symbol.PType calledArg = this.exprType.get(ctx.list_expressions().expression().get(i));
                    Symbol.PType declaredArg = fs.arguments.get(i).type;
//                    System.out.println("declared: " + declaredArg);
//                    System.out.println("called: " + calledArg);
                    if (calledArg.equals(Symbol.PType.FLOAT) && declaredArg.equals(Symbol.PType.INT))
                        continue;
                    else if (calledArg.equals(Symbol.PType.NULL_POINTER) && declaredArg.equals(Symbol.PType.BOOL_POINTER))
                        continue;
                    else if (calledArg.equals(Symbol.PType.NULL_POINTER) && declaredArg.equals(Symbol.PType.STRING_POINTER))
                        continue;
                    else if (calledArg.equals(Symbol.PType.NULL_POINTER) && declaredArg.equals(Symbol.PType.FLOAT_POINTER))
                        continue;
                    else if (calledArg.equals(Symbol.PType.NULL_POINTER) && declaredArg.equals(Symbol.PType.INT_POINTER))
                        continue;
                    if (!calledArg.equals(declaredArg)) {
                        System.err.println("Arguments of function " + functionName + " do not match the arguments " +
                                "declared in the function declaration in line " + ctx.start.getLine());
                        return;
                    }
                }
            }
            this.exprType.put(ctx, s.type);
        }

        //TODO check type of function
    }

    // special_function : INT ALG LPAREN INT N COMMA STRING_POINTER ARGS RPAREN body;
    public void enterSpecial_function(Projeto.Special_functionContext ctx) {
        this.currentFunction = (FunctionSymbol) this.scopes.get(ctx).resolve(ctx.ALG().getText());
        this.currentScope = this.scopes.get(ctx);
    }


    // special_function : INT ALG LPAREN INT N COMMA STRING_POINTER ARGS RPAREN body;
    public void exitSpecial_function(Projeto.Special_functionContext ctx) {
        if (!this.currentFunction.hasIns)
            System.err.println("Function " + this.currentFunction.name + " has to have at least one instruction" + ". Line: " + ctx.start.getLine());
        this.currentFunction = null;
        this.currentScope = this.currentScope.getParentScope();
    }


    // function_normal: function_type IDENTIFIER LPAREN function_args* RPAREN body;
    public void enterFunction_normal(Projeto.Function_normalContext ctx) {
        this.currentFunction = (FunctionSymbol) this.scopes.get(ctx).resolve(ctx.IDENTIFIER().getText());
        this.currentScope = this.scopes.get(ctx);
    }

    // function_normal: function_type IDENTIFIER LPAREN function_args* RPAREN body;
    public void exitFunction_normal(Projeto.Function_normalContext ctx) {
        if (!this.currentFunction.hasIns)
            System.err.println("Function " + this.currentFunction.name + " has to have at least one instruction" + ". Line: " + ctx.start.getLine());
        this.currentFunction = null;
//        System.out.println("scope " + ctx.IDENTIFIER() + " " + this.currentScope);
        this.currentScope = this.currentScope.getParentScope();
//        System.out.println("scope after leaving " + ctx.IDENTIFIER() + " " + this.currentScope);
    }


    public void exitCentral(Projeto.CentralContext ctx) {
        List<Projeto.Var_or_instructionContext> listOfVar_or_instructions = ctx.block().var_or_instruction();
        if (this.currentFunction.type != Symbol.PType.VOID) {
            if (!this.currentFunction.hasReturn) {
//                this.validated = false;
                System.err.println("The central block of function " + this.currentFunction.name + " needs to have one return. Line: " + ctx.start.getLine());
                return;
            }
            int numberOfInsOrVar = listOfVar_or_instructions.size();
            if (this.currentFunction.hasIns) {
                int indexOfResult = checkResultIndex(listOfVar_or_instructions);
                if (indexOfResult < numberOfInsOrVar - 1) {
                    System.err.println("Return on central block of function " + this.currentFunction.name + " is not the last instruction. Line: " + listOfVar_or_instructions.get(indexOfResult).start.getLine());
                    return;
                }
            }

        } else {
            if (this.currentFunction.hasReturn) {
                int numberOfInsOrVar = listOfVar_or_instructions.size();
                int indexOfResult = checkResultIndex(listOfVar_or_instructions);
                if (indexOfResult < numberOfInsOrVar - 1) {
                    System.out.println(indexOfResult);
                    System.err.println("Return on central block is not the last instruction, line: " + listOfVar_or_instructions.get(indexOfResult).start.getLine());
                    return;
                }
            }
        }
    }

    public void exitPrologue(Projeto.PrologueContext ctx) {
        if (this.currentFunction.type != Symbol.PType.VOID) {
            int numberOfInsOrVar = ctx.block().var_or_instruction().size();

            if (!this.currentFunction.hasIns)
                checkInstruction(ctx.block().var_or_instruction());

            Projeto.InstructionContext lastInsOrVar = ctx.block().var_or_instruction(numberOfInsOrVar - 1).instruction();
            if (lastInsOrVar != null) {
                if (!lastInsOrVar.getStart().getText().equals("return")) {
//                    this.validated = false;
                    System.err.println("The return needs to be the last instruction in the prologue block.");
                }
            } else {
//                this.validated = false;
                System.err.println("The return needs to be the last instruction in the prologue block.");
            }
        } else {
            if (this.currentFunction.hasReturn) {
                int numberOfInsOrVar = ctx.block().var_or_instruction().size();

                Projeto.InstructionContext lastInsOrVar = ctx.block().var_or_instruction(numberOfInsOrVar - 1).instruction();
                if (lastInsOrVar != null) {
                    if (!lastInsOrVar.getStart().getText().equals("return")) {
//                        this.validated = false;
                        System.err.println("The return needs to be the last instruction in the prologue block.");
                    }
                } else {
//                    this.validated = false;
                    System.err.println("The return needs to be the last instruction in the prologue block.");
                }
            }
        }
    }

    public void exitEpilogue(Projeto.EpilogueContext ctx) {
        if (this.currentFunction.type != Symbol.PType.VOID) {

            int numberOfInsOrVar = ctx.block().var_or_instruction().size();

            if (!this.currentFunction.hasIns)
                checkInstruction(ctx.block().var_or_instruction());
            Projeto.InstructionContext lastInsOrVar = ctx.block().var_or_instruction(numberOfInsOrVar - 1).instruction();
            if (lastInsOrVar != null) {
                if (!lastInsOrVar.getStart().getText().equals("return")) {
//                    this.validated = false;
                    System.err.println("The return needs to be the last instruction in the epilogue block.");
                }
            } else {
//                this.validated = false;
                System.err.println("The return needs to be the last instruction in the epilogue block.");
            }
        } else {
            if (this.currentFunction.hasReturn) {
                int numberOfInsOrVar = ctx.block().var_or_instruction().size();

                Projeto.InstructionContext lastInsOrVar = ctx.block().var_or_instruction(numberOfInsOrVar - 1).instruction();
                if (lastInsOrVar != null) {
                    if (!lastInsOrVar.getStart().getText().equals("return")) {
//                        this.validated = false;
                        System.err.println("The return needs to be the last instruction in the epilogue block.");
                    }
                } else {
//                    this.validated = false;
                    System.err.println("The return needs to be the last instruction in the epilogue block.");
                }
            }
        }
    }


    //    control_instructions : RETURN expression?
    public void exitReturn(Projeto.ReturnContext ctx) {
        this.currentFunction.hasIns = true;
        this.currentFunction.hasReturn = true;
        Symbol.PType expr = exprType.get(ctx.expression());
        if (this.currentFunction != null) {
            //TODO - Tratar das conversoes implicitas
            if (this.currentFunction.type == Symbol.PType.VOID) {
                if (ctx.expression() != null) {
//                    this.validated = false;
                    System.err.println("Function type is void but the return is of type " + expr + " on line " + ctx.start.getLine());
                }
            }
//            if (this.currentFunction.type.equals(Symbol.PType.FLOAT) && declaredArg.equals(Symbol.PType.INT))
//                continue;
//            else if (this.currentFunction.type.equals(Symbol.PType.NULL_POINTER) && declaredArg.equals(Symbol.PType.BOOL_POINTER))
//                continue;
//            else if (this.currentFunction.type.equals(Symbol.PType.NULL_POINTER) && declaredArg.equals(Symbol.PType.STRING_POINTER))
//                continue;
//            else if (this.currentFunction.type.equals(Symbol.PType.NULL_POINTER) && declaredArg.equals(Symbol.PType.FLOAT_POINTER))
//                continue;
//            else if (this.currentFunction.type.equals(Symbol.PType.NULL_POINTER) && declaredArg.equals(Symbol.PType.INT_POINTER))
//                continue;
            else if (this.currentFunction.type != expr) {
//                this.validated = false;
                System.err.println("Function is of type " + this.currentFunction.type + " and the return type is " + expr + " on line " + ctx.start.getLine());
            }
        }
    }


    public void checkInstruction(List<Projeto.Var_or_instructionContext> listOfVarsOrIns) {
        for (Projeto.Var_or_instructionContext listOfVarsOrIn : listOfVarsOrIns) {
            if (listOfVarsOrIn.instruction() != null) {
                this.currentFunction.hasIns = true;
                break;
            }
        }
    }

    public int checkResultIndex(List<Projeto.Var_or_instructionContext> listOfVarsOrIns) {
        int result = -1;
        int i = 0;
        for (Projeto.Var_or_instructionContext listOfVarsOrIn : listOfVarsOrIns) {
            if (listOfVarsOrIn.instruction() != null && listOfVarsOrIn.instruction().start.getText().equals("return")) {
                result = i;
                break;
            }
            i++;
        }
        return result;
    }

    //var_declaration_init : type IDENTIFIER EQUAL expression
    public void exitDeclAndAtrib(Projeto.DeclAndAtribContext ctx) {
        String stype = ctx.type().start.getText();
        String name = ctx.IDENTIFIER().getText();

        //TODO - Catch an exception and return appropriate erro if the type doesn't exist

        Symbol type = new Symbol(stype, name);
        Symbol.PType expression = exprType.get(ctx.expression());
        if (expression == Symbol.PType.NULL_POINTER)        //TODO make it prettier
        {
        }
        //TODO type identifier = id_invocation
        else if (!(type.type == expression)) {
            System.err.println("Invalid variable type  " + stype + " of variable " + name + " since the right side value is of type " + expression + ", Line: " + ctx.start.getLine());
//            this.validated = false;
        }
        defineSymbol(ctx, new Symbol(ctx.type().start.getText(), ctx.IDENTIFIER().getText()));
    }

    public void exitExpression(Projeto.ExpressionContext ctx) {
        Symbol.PType type = exprType.get(ctx.expression_evaluation());
        exprType.put(ctx, type);
    }


    //     expression_evaluation:  expression_evaluation comparator_OTHER expression_evaluation
    public void exitCompOther(Projeto.CompOtherContext ctx) {
        Symbol.PType e1 = exprType.get(ctx.expression_evaluation(0));
        Symbol.PType e2 = exprType.get(ctx.expression_evaluation(1));

        Operator.PType op = opType.get(ctx.comparators());

        if (Operator.isSimpleOperator(op)) {
            if (Symbol.isNumeric(e1) && Symbol.isNumeric(e2)) {
                exprType.put(ctx, Symbol.PType.BOOL);
            } else {
                System.err.println("Something is wrong on line " + ctx.start.getLine());
                this.validated = false;
                exprType.put(ctx, Symbol.PType.ERROR);
            }
        } else if (Operator.isEQualOperator(op)) {
            if (Symbol.isPrimitive(e1) && Symbol.isPrimitive(e2)) {
                if (e1 == e2) {
                    exprType.put(ctx, Symbol.PType.BOOL);
                } else {
                    System.err.println("They should be of the same type" + ctx.start.getLine());
                    this.validated = false;
                    exprType.put(ctx, Symbol.PType.ERROR);
                }
            } else if (Symbol.isAPointer(e1) && Symbol.isAPointer(e2)) {
                if (e1 == Symbol.PType.NULL_POINTER || e2 == Symbol.PType.NULL_POINTER)
                    exprType.put(ctx, Symbol.PType.BOOL);
                else if (Symbol.areBothTypesEqual(e1, e2)) {
                    exprType.put(ctx, Symbol.PType.BOOL);
                } else {
                    System.err.println("They should be of the same type" + ctx.start.getLine());
                    this.validated = false;
                    exprType.put(ctx, Symbol.PType.ERROR);
                }
            }
        } else {
            System.err.println("Something is wrong on line " + ctx.start.getLine());
            this.validated = false;
            exprType.put(ctx, Symbol.PType.ERROR);
        }

    }


    //     expression_evaluation:  expression_evaluation comparator_AND expression_evaluation
    public void exitCompAnd(Projeto.CompAndContext ctx) {
        Symbol.PType e1 = exprType.get(ctx.expression_evaluation(0));
        Symbol.PType e2 = exprType.get(ctx.expression_evaluation(1));

        if (e1 == Symbol.PType.BOOL && e2 == Symbol.PType.BOOL) {
            exprType.put(ctx, Symbol.PType.BOOL);
        } else {
            System.err.println("Something is wrong on line " + ctx.start.getLine());
            this.validated = false;
            exprType.put(ctx, Symbol.PType.ERROR);
        }

    }


    //     expression_evaluation:  expression_evaluation comparator_OR expression_evaluation
    public void exitCompOr(Projeto.CompOrContext ctx) {
        Symbol.PType e1 = exprType.get(ctx.expression_evaluation(0));
        Symbol.PType e2 = exprType.get(ctx.expression_evaluation(1));

        if (e1 == Symbol.PType.BOOL && e2 == Symbol.PType.BOOL) {
            exprType.put(ctx, Symbol.PType.BOOL);
        } else {
            System.err.println("Something is wrong on line " + ctx.start.getLine());
            this.validated = false;
            exprType.put(ctx, Symbol.PType.ERROR);
        }

    }


    //var_declaration_init : type IDENTIFIER EQUAL (LBRACKET expression RBRACKET | NULL)
    public void exitMemDecl(Projeto.MemDeclContext ctx) {
        String stype = ctx.type().start.getText();
        String name = ctx.IDENTIFIER().getText();
        //TODO - Catch an exception and return appropriate erro if the type doesn't exist
        Symbol type = new Symbol(stype, name);


        if (Symbol.isAPrimitivePointer(type.type)) {
            Symbol.PType expression = exprType.get(ctx.expression());
            if (expression == Symbol.PType.INT) {
                System.out.println("The variable " + name + " is declared properly.");
            } else {
                System.err.println("Expression should be of type int but is of type" + expression + " on line " + ctx.start.getLine());
                this.validated = false;
            }

        } else {
            System.err.println("Invalid variable type  " + stype + " of variable " + name + " on line " + ctx.start.getLine());
            this.validated = false;
        }

        defineSymbol(ctx, new Symbol(ctx.type().start.getText(), ctx.IDENTIFIER().getText()));
    }


    // expression_evaluation : expression_evaluation (DIV | MUL | PERCENT) expression_evaluation
    public void exitMulDivRem(Projeto.MulDivRemContext ctx) {

        Operator.PType op = opType.get(ctx.binary_op_MUL_DIV_REM());

        if (op == Operator.PType.MUL | op == Operator.PType.DIV) {
            Symbol.PType e1 = exprType.get(ctx.expression_evaluation(0));
            Symbol.PType e2 = exprType.get(ctx.expression_evaluation(1));

            if (e1 == Symbol.PType.ERROR || e2 == Symbol.PType.ERROR) exprType.put(ctx, Symbol.PType.ERROR);

            if (e1 == Symbol.PType.INT && e2 == Symbol.PType.INT) exprType.put(ctx, Symbol.PType.INT);
            else if (e1 == Symbol.PType.FLOAT && e2 == Symbol.PType.FLOAT) exprType.put(ctx, Symbol.PType.FLOAT);
            else if (e1 == Symbol.PType.FLOAT && e2 == Symbol.PType.INT) exprType.put(ctx, Symbol.PType.FLOAT);
            else if (e1 == Symbol.PType.INT && e2 == Symbol.PType.FLOAT) exprType.put(ctx, Symbol.PType.FLOAT);
            else {
                System.err.println("Invalid types for * or / operator " + e1.toString() + " " + e2.toString() + " on line " + ctx.start.getLine());
                this.validated = false;
                exprType.put(ctx, Symbol.PType.ERROR);
            }
        } else if (op == Operator.PType.REM) {
            Symbol.PType e1 = exprType.get(ctx.expression_evaluation(0));
            Symbol.PType e2 = exprType.get(ctx.expression_evaluation(1));

            if (e1 == Symbol.PType.ERROR || e2 == Symbol.PType.ERROR) exprType.put(ctx, Symbol.PType.ERROR);

            if (e1 == Symbol.PType.INT && e2 == Symbol.PType.INT) exprType.put(ctx, Symbol.PType.INT);
            else {
                System.err.println("Invalid types for % operator " + e1.toString() + " " + e2.toString() + " on line " + ctx.start.getLine());
                this.validated = false;
                exprType.put(ctx, Symbol.PType.ERROR);
            }
        } else {
            System.err.println("Invalid operator " + op.toString() + " on line " + ctx.start.getLine());
            this.validated = false;
            exprType.put(ctx, Symbol.PType.ERROR);
        }
    }

    // expression_evaluation = unary_operators expression_evaluation
    public void exitUnaryExp(Projeto.UnaryExpContext ctx) {
        String operator = ctx.start.getText();

        Symbol.PType e1 = exprType.get(ctx.expression_evaluation());

        if (operator.equals("+") || operator.equals("-")) {
            if (e1 == Symbol.PType.INT || e1 == Symbol.PType.FLOAT) exprType.put(ctx, e1);
            else {
                System.err.println("Invalid operand type " + e1.toString() + " on line " + ctx.start.getLine());
                this.validated = false;
                exprType.put(ctx, Symbol.PType.ERROR);
            }
        } else if (operator.equals("~")) {
            if (e1 == Symbol.PType.BOOL) exprType.put(ctx, e1);
            else {
                System.err.println("Invalid operand type " + e1.toString() + " on line " + ctx.start.getLine());
                this.validated = false;
                exprType.put(ctx, Symbol.PType.ERROR);
            }
        } else if (operator.equals("?")) {
            if (Symbol.isPrimitive(e1)) {
                Symbol.PType primitivePointer = primitiveToPointer(e1);
                exprType.put(ctx, primitivePointer);
            } else {
                System.err.println("Invalid type" + e1.toString() + " on line " + ctx.start.getLine());
                this.validated = false;
                exprType.put(ctx, Symbol.PType.ERROR);
            }
        }
    }


    // expression_evaluation = expression_evaluation LBRACKET expression_evaluation RBRACKET
    public void exitPointerExp(Projeto.PointerExpContext ctx) {
        Symbol.PType e1 = exprType.get(ctx.expression_evaluation(0));
        Symbol.PType e2 = exprType.get(ctx.expression_evaluation(1));


        if (!(e1 == Symbol.PType.BOOL_POINTER || e1 == Symbol.PType.INT_POINTER || e1 == Symbol.PType.FLOAT_POINTER || e1 == Symbol.PType.STRING_POINTER)) {
            System.err.println("Invalid type for E1[E2] operator " + e1.toString() + " " + e2.toString() + " on line " + ctx.start.getLine());
            this.validated = false;
            exprType.put(ctx, Symbol.PType.ERROR);
        }
        if (e2 != Symbol.PType.INT) {
            System.err.println("E2 is not an integer but a  " + e2.toString() + " on line " + ctx.start.getLine());
            this.validated = false;
            exprType.put(ctx, Symbol.PType.ERROR);
        }
        exprType.put(ctx, e1);
    }


    //  expression_evaluation : LPAREN expression_evaluation RPAREN
    public void exitParenExp(Projeto.ParenExpContext ctx) {
        Symbol.PType expressionType = exprType.get(ctx.expression_evaluation());
        exprType.put(ctx, expressionType);
    }


    // expression_evaluation : simple_expression
    public void exitSimpExp(Projeto.SimpExpContext ctx) {
        Symbol.PType expressionType = exprType.get(ctx.simple_expression());
        exprType.put(ctx, expressionType);

    }

    public void exitFunction_call(Projeto.Function_callContext ctx) {
        exprType.put(ctx, exprType.get(ctx.function_invocation()));
    }

    //expression_evaluation : expression_evaluation binary_op_ADD_SUB expression_evaluation
    public void exitAddSub(Projeto.AddSubContext ctx) {
        Symbol.PType e1 = exprType.get(ctx.expression_evaluation(0));
        Symbol.PType e2 = exprType.get(ctx.expression_evaluation(1));
        if (e1 == Symbol.PType.ERROR || e2 == Symbol.PType.ERROR) exprType.put(ctx, Symbol.PType.ERROR);
        else if ((e1 == Symbol.PType.INT || e1 == Symbol.PType.FLOAT) && (e2 == Symbol.PType.FLOAT || e2 == Symbol.PType.INT)) {

            if (e1 == Symbol.PType.INT && e2 == Symbol.PType.INT) exprType.put(ctx, Symbol.PType.INT);
            else {
                exprType.put(ctx, Symbol.PType.FLOAT);
            }
        } else if (Symbol.isAPrimitivePointer(e1) && e2 == Symbol.PType.INT) {
            exprType.put(ctx, e1);

        } else {
//            System.err.println(e1 + " " + e2);
            System.err.println("Something is wrong on line " + ctx.start.getLine());
//            this.validated = false;
            exprType.put(ctx, Symbol.PType.ERROR);
        }

    }


    public void exitInt(Projeto.IntContext ctx) {
        exprType.put(ctx, Symbol.PType.INT);
    }

    public void exitReal(Projeto.RealContext ctx) {
        exprType.put(ctx, Symbol.PType.FLOAT);
    }


    public void exitString(Projeto.StringContext ctx) {
        exprType.put(ctx, Symbol.PType.STRING);
    }


    public void exitMul(Projeto.MulContext ctx) {
        opType.put(ctx, Operator.PType.MUL);
    }


    public void exitDiv(Projeto.DivContext ctx) {
        opType.put(ctx, Operator.PType.DIV);
    }


    public void exitPercent(Projeto.PercentContext ctx) {
        opType.put(ctx, Operator.PType.REM);
    }

    public void exitLesser(Projeto.LesserContext ctx) {
        opType.put(ctx, Operator.PType.LESSER);
    }

    public void exitLesseq(Projeto.LesseqContext ctx) {
        opType.put(ctx, Operator.PType.LESSEQ);
    }

    public void exitGreater(Projeto.GreaterContext ctx) {
        opType.put(ctx, Operator.PType.GREATER);
    }

    public void exitGreateq(Projeto.GreateqContext ctx) {
        opType.put(ctx, Operator.PType.GREATEQ);
    }

    public void exitEquals(Projeto.EqualsContext ctx) {
        opType.put(ctx, Operator.PType.EQUALS);
    }

    public void exitNotequals(Projeto.NotequalsContext ctx) {
        opType.put(ctx, Operator.PType.NOTEQUALS);
    }

    public void exitNull(Projeto.NullContext ctx) {
        exprType.put(ctx, Symbol.PType.NULL_POINTER);
    }

    public void exitInstruction(Projeto.InstructionContext ctx) {
        this.currentFunction.hasIns = true;
    }


    public void exitFunction_invocation(Projeto.Function_invocationContext ctx) {
        exprType.put(ctx, exprType.get(ctx.id_invocation()));
    }


    // (IDENTIFIER | expression) EQUAL expression;
    public void exitAttribution_instruction(Projeto.Attribution_instructionContext ctx) {
        this.currentFunction.hasIns = true;
        Symbol.PType leftSide;
        Symbol.PType rightSide;
        if (ctx.IDENTIFIER() == null) {
            leftSide = this.exprType.get(ctx.expression(0));
            if (!Symbol.isAPointer(leftSide)) {
                System.err.println("Invalid type of attribution on line: " + ctx.start.getLine());
                return;
            }
            rightSide = this.exprType.get(ctx.expression(1));
        } else {
            leftSide = this.currentScope.resolve(ctx.IDENTIFIER().getText()).type;
            rightSide = this.exprType.get(ctx.expression(0));
        }

        if (leftSide == Symbol.PType.FLOAT && rightSide == Symbol.PType.INT) {

        } else if (Symbol.isAPointer(leftSide) && rightSide == Symbol.PType.NULL_POINTER) {

        } else if (rightSide == Symbol.PType.VOID)
            System.err.println("Invalid type of attribution on line: " + ctx.start.getLine());
        else if (rightSide != leftSide)
            System.err.println("Invalid type of attribution on line: " + ctx.start.getLine());
    }


    //expr --> ID;
    public void exitVar(Projeto.VarContext ctx) {
        String variableName = ctx.IDENTIFIER().getText();
        Symbol s = this.currentScope.resolve(variableName);
        if (s == null) {
            System.err.println("Undefined variable " + variableName + " in line " + ctx.IDENTIFIER().getSymbol().getLine() + " position " + ctx.IDENTIFIER().getSymbol().getCharPositionInLine());
            this.semanticErrors++;
            this.validated = false;
            exprType.put(ctx, Symbol.PType.ERROR);
            return;
        }

        if (s instanceof FunctionSymbol) {
            System.err.println("Using function symbol " + variableName + " as variable in line " + ctx.IDENTIFIER().getSymbol().getLine());
            this.semanticErrors++;
            this.validated = false;
            exprType.put(ctx, Symbol.PType.ERROR);
            return;
        }
        exprType.put(ctx, s.type);
    }


//    AUXILIAR FUNCTIONS


    private Symbol.PType primitiveToPointer(Symbol.PType e1) {
        if (e1 == Symbol.PType.BOOL) return Symbol.PType.BOOL_POINTER;
        else if (e1 == Symbol.PType.FLOAT) return Symbol.PType.FLOAT_POINTER;
        else if (e1 == Symbol.PType.STRING) return Symbol.PType.STRING_POINTER;
        else {
            return Symbol.PType.ERROR;
        }
    }


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
}