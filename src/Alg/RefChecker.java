package Alg;

import Symbols.FunctionSymbol;
import Symbols.Operator;
import Symbols.Scope;
import Symbols.Symbol;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.List;

public class RefChecker extends ProjetoBaseListener {
    public Scope currentScope;
    public int semanticErrors;
    public boolean validated;
    public ParseTreeProperty<Scope> scopes;
    public ParseTreeProperty<FunctionSymbol> functions;
    public ParseTreeProperty<Symbol.PType> exprType;
    ParseTreeProperty<Operator.PType> opType = new ParseTreeProperty<>();
    private FunctionSymbol currentFunction;


    public RefChecker(ParseTreeProperty<Scope> scopes, ParseTreeProperty<Symbol.PType> exprType, ParseTreeProperty<FunctionSymbol> functions, boolean validated) {
        this.exprType = exprType;
        this.scopes = scopes;
        this.functions = functions;
        this.validated = validated;
    }


    public void enterProgram(Projeto.ProgramContext ctx) {
        currentScope = this.scopes.get(ctx);
    }


    //id_invocation : IDENTIFIER LPAREN list_expressions? RPAREN;
    public void exitId_invocation(Projeto.Id_invocationContext ctx) {
        String functionName = ctx.IDENTIFIER().getText();
        Symbol s = scopes.get(ctx).resolve(functionName);
        if (s == null) {
            System.err.println("Undefined function " + functionName + " in line " + ctx.IDENTIFIER().getSymbol().getLine() + " position: " + ctx.IDENTIFIER().getSymbol().getCharPositionInLine());
            this.validated = false;
            this.semanticErrors++;
        }
        if (!(s instanceof FunctionSymbol)) {
            System.err.println("Using var symbol " + functionName + " as function in line " + ctx.IDENTIFIER().getSymbol().getLine() + " position: " + ctx.IDENTIFIER().getSymbol().getCharPositionInLine());
            this.validated = false;
            this.semanticErrors++;
        } else {
            FunctionSymbol fs = (FunctionSymbol) s;
            if (ctx.list_expressions() != null && fs.arguments.size() == ctx.list_expressions().expression().size()) {
                for (int i = 0; i < ctx.list_expressions().expression().size(); i++) {
                    Symbol.PType calledArg = this.exprType.get(ctx.list_expressions().expression().get(i));
                    Symbol.PType declaredArg = fs.arguments.get(i).type;
                    if (Symbol.isCastingPossible(declaredArg, calledArg)) continue;
                    if (!calledArg.equals(declaredArg)) {
                        this.validated = false;
                        this.semanticErrors++;
                        System.err.println("Arguments of function " + functionName + " do not match the arguments " +
                                "declared in the function declaration in line " + ctx.start.getLine());
                        return;
                    }
                }
            }
            this.exprType.put(ctx, s.type);
        }
    }

    // special_function : INT ALG LPAREN INT N COMMA STRING_POINTER ARGS RPAREN body;
    public void enterSpecial_function(Projeto.Special_functionContext ctx) {
        this.currentFunction = (FunctionSymbol) this.scopes.get(ctx).resolve(ctx.ALG().getText());
        this.currentScope = this.scopes.get(ctx);
    }


    // special_function : INT ALG LPAREN INT N COMMA STRING_POINTER ARGS RPAREN body;
    public void exitSpecial_function(Projeto.Special_functionContext ctx) {
        if (!this.currentFunction.hasIns) {
            System.err.println("Function " + this.currentFunction.name + " has to have at least one instruction" + ". Line: " + ctx.start.getLine());
            this.validated = false;
            this.semanticErrors++;
        }
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
        if (!this.currentFunction.hasIns) {
            this.validated = false;
            this.semanticErrors++;
            System.err.println("Function " + this.currentFunction.name + " has to have at least one instruction" + ". Line: " + ctx.start.getLine());
        }
        this.currentFunction = null;
        this.currentScope = this.currentScope.getParentScope();
    }


    public void exitPrologue(Projeto.PrologueContext ctx) {
        List<Projeto.Var_or_instructionContext> listOfVar_or_instructions = ctx.block().var_or_instruction();
        if (this.currentFunction.type != Symbol.PType.VOID) {
            int numberOfInsOrVar = listOfVar_or_instructions.size();
            if (this.currentFunction.hasIns) {
                int indexOfResult = checkResultIndex(listOfVar_or_instructions);
                if (indexOfResult < numberOfInsOrVar - 1) {
                    this.validated = false;
                    this.semanticErrors++;
                    System.err.println("Return on prologue block of function " + this.currentFunction.name + " is not the last instruction. Line: " + listOfVar_or_instructions.get(indexOfResult).start.getLine());
                }
            }

        } else {
            if (this.currentFunction.hasReturn) {
                int numberOfInsOrVar = listOfVar_or_instructions.size();
                int indexOfResult = checkResultIndex(listOfVar_or_instructions);
                if (indexOfResult < numberOfInsOrVar - 1) {
                    System.out.println(indexOfResult);
                    this.validated = false;
                    this.semanticErrors++;
                    System.err.println("Return on prologue block is not the last instruction, line: " + listOfVar_or_instructions.get(indexOfResult).start.getLine());
                }
            }
        }
    }


    public void exitCentral(Projeto.CentralContext ctx) {
        List<Projeto.Var_or_instructionContext> listOfVar_or_instructions = ctx.block().var_or_instruction();
        if (this.currentFunction.type != Symbol.PType.VOID) {
            if (!this.currentFunction.hasReturn) {
                this.validated = false;
                this.semanticErrors++;
                System.err.println("The central block of function " + this.currentFunction.name + " needs to have one return. Line: " + ctx.start.getLine());
                return;
            }
            int numberOfInsOrVar = listOfVar_or_instructions.size();
            if (this.currentFunction.hasIns) {
                int indexOfResult = checkResultIndex(listOfVar_or_instructions);
                if (indexOfResult < numberOfInsOrVar - 1) {
                    this.validated = false;
                    this.semanticErrors++;
                    System.err.println("Return on central block of function " + this.currentFunction.name + " is not the last instruction. Line: " + listOfVar_or_instructions.get(indexOfResult).start.getLine());
                }
            }

        } else {
            if (this.currentFunction.hasReturn) {
                int numberOfInsOrVar = listOfVar_or_instructions.size();
                int indexOfResult = checkResultIndex(listOfVar_or_instructions);
                if (indexOfResult < numberOfInsOrVar - 1) {
                    this.validated = false;
                    this.semanticErrors++;
                    System.err.println("Return on central block is not the last instruction, line: " + listOfVar_or_instructions.get(indexOfResult).start.getLine());
                }
            }
        }
    }


    public void exitEpilogue(Projeto.EpilogueContext ctx) {
        List<Projeto.Var_or_instructionContext> listOfVar_or_instructions = ctx.block().var_or_instruction();
        if (this.currentFunction.type != Symbol.PType.VOID) {
            int numberOfInsOrVar = listOfVar_or_instructions.size();
            if (this.currentFunction.hasIns) {
                int indexOfResult = checkResultIndex(listOfVar_or_instructions);
                if (indexOfResult < numberOfInsOrVar - 1) {
                    this.validated = false;
                    this.semanticErrors++;
                    System.err.println("Return on epilogue block of function " + this.currentFunction.name + " is not the last instruction. Line: " + listOfVar_or_instructions.get(indexOfResult).start.getLine());
                }
            }

        } else {
            if (this.currentFunction.hasReturn) {
                int numberOfInsOrVar = listOfVar_or_instructions.size();
                int indexOfResult = checkResultIndex(listOfVar_or_instructions);
                if (indexOfResult < numberOfInsOrVar - 1) {
                    this.validated = false;
                    this.semanticErrors++;
                    System.err.println("Return on epilogue block is not the last instruction, line: " + listOfVar_or_instructions.get(indexOfResult).start.getLine());
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
            if (this.currentFunction.type == Symbol.PType.VOID) {
                if (ctx.expression() != null) {
                    this.validated = false;
                    this.semanticErrors++;
                    System.err.println("Function type is void but the return is of type " + expr + " on line " + ctx.start.getLine());
                }
            } else {
                if (Symbol.isCastingPossible(this.currentFunction.type, expr)) {
                    //do nothing
                } else if (this.currentFunction.type != expr) {
                    this.validated = false;
                    this.semanticErrors++;
                    System.err.println("Function is of type " + this.currentFunction.type + " and the return type is " + expr + " on line " + ctx.start.getLine());
                }
            }
        }
    }


    //var_declaration_init : type IDENTIFIER EQUAL expression
    public void exitDeclAndAtrib(Projeto.DeclAndAtribContext ctx) {
        String stype = ctx.type().start.getText();
        String name = ctx.IDENTIFIER().getText();


        Symbol symbol = new Symbol(stype, name);
        Symbol.PType expression = exprType.get(ctx.expression());
        if (Symbol.isCastingPossible(symbol.type, expression)) {
            //do nothing
        } else if (!(symbol.type == expression)) {
            this.validated = false;
            semanticErrors++;
            System.err.println("Invalid variable type " + symbol.type + " of variable " + name + " since the right side value is of type " + expression + ", Line: " + ctx.start.getLine());
        }
        defineSymbol(ctx, new Symbol(ctx.type().start.getText(), ctx.IDENTIFIER().getText()));
    }

    //alot of expressions!
    public void exitExpression(Projeto.ExpressionContext ctx) {
        Symbol.PType type = exprType.get(ctx.expression_evaluation());
        exprType.put(ctx, type);
    }


    //expression_evaluation:  expression_evaluation comparator_OTHER expression_evaluation
    public void exitCompOther(Projeto.CompOtherContext ctx) {
        Symbol.PType e1 = exprType.get(ctx.expression_evaluation(0));
        Symbol.PType e2 = exprType.get(ctx.expression_evaluation(1));

        Operator.PType op = opType.get(ctx.comparators());

        if (Operator.isSimpleOperator(op)) {
            if (Symbol.isNumeric(e1) && Symbol.isNumeric(e2)) {
                exprType.put(ctx, Symbol.PType.BOOL);
            } else {
                this.validated = false;
                semanticErrors++;
                exprType.put(ctx, Symbol.PType.ERROR);
                System.err.println("Something is wrong on line " + ctx.start.getLine());
            }
        } else if (Operator.isEQualOperator(op)) {
            if (Symbol.isPrimitive(e1) && Symbol.isPrimitive(e2)) {
                if (e1 == e2) {
                    exprType.put(ctx, Symbol.PType.BOOL);
                } else {
                    this.validated = false;
                    semanticErrors++;
                    exprType.put(ctx, Symbol.PType.ERROR);
                    System.err.println("They should be of the same type" + ctx.start.getLine());
                }
            } else if (Symbol.isAPointer(e1) && Symbol.isAPointer(e2)) {
                if ((e1 == Symbol.PType.NULL_POINTER && e2 != Symbol.PType.NULL_POINTER) || (e1 != Symbol.PType.NULL_POINTER && e2 == Symbol.PType.NULL_POINTER))
                    exprType.put(ctx, Symbol.PType.BOOL);
                else if (Symbol.areBothTypesEqual(e1, e2)) {
                    exprType.put(ctx, Symbol.PType.BOOL);
                } else {
                    this.validated = false;
                    semanticErrors++;
                    exprType.put(ctx, Symbol.PType.ERROR);
                    System.err.println("They should be of the same type" + ctx.start.getLine());
                }
            }
        } else {
            this.validated = false;
            semanticErrors++;
            exprType.put(ctx, Symbol.PType.ERROR);
            System.err.println("Something is wrong on line " + ctx.start.getLine());
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
            semanticErrors++;
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
            semanticErrors++;
            exprType.put(ctx, Symbol.PType.ERROR);
        }

    }


    //var_declaration_init : type IDENTIFIER EQUAL (LBRACKET expression RBRACKET | NULL)
    public void exitMemDecl(Projeto.MemDeclContext ctx) {
        String stype = ctx.type().start.getText();
        String name = ctx.IDENTIFIER().getText();
        Symbol type = new Symbol(stype, name);

        if (Symbol.isAPrimitivePointer(type.type)) {
            Symbol.PType expression = exprType.get(ctx.expression());
            if (expression != Symbol.PType.INT) {
                this.validated = false;
                semanticErrors++;
                System.err.println("Expression should be of type int but is of type" + expression + " on line " + ctx.start.getLine());
            }
        } else {
            this.validated = false;
            semanticErrors++;
            System.err.println("Invalid variable type  " + stype + " of variable " + name + " on line " + ctx.start.getLine());
        }
        defineSymbol(ctx, new Symbol(ctx.type().start.getText(), ctx.IDENTIFIER().getText()));
    }


    // expression_evaluation : expression_evaluation (DIV | MUL | PERCENT) expression_evaluation
    public void exitMulDivRem(Projeto.MulDivRemContext ctx) {
        Operator.PType op = opType.get(ctx.binary_op_MUL_DIV_REM());

        if (op == Operator.PType.MUL | op == Operator.PType.DIV) {
            Symbol.PType e1 = exprType.get(ctx.expression_evaluation(0));
            Symbol.PType e2 = exprType.get(ctx.expression_evaluation(1));

            if (e1 == Symbol.PType.ERROR || e2 == Symbol.PType.ERROR)
                exprType.put(ctx, Symbol.PType.ERROR);
            else if (e1 == Symbol.PType.INT && e2 == Symbol.PType.INT)
                exprType.put(ctx, Symbol.PType.INT);
            else if (e1 == Symbol.PType.FLOAT && e2 == Symbol.PType.FLOAT)
                exprType.put(ctx, Symbol.PType.FLOAT);
            else if (e1 == Symbol.PType.FLOAT && e2 == Symbol.PType.INT)
                exprType.put(ctx, Symbol.PType.FLOAT);
            else if (e1 == Symbol.PType.INT && e2 == Symbol.PType.FLOAT)
                exprType.put(ctx, Symbol.PType.FLOAT);
            else {
                this.validated = false;
                semanticErrors++;
                exprType.put(ctx, Symbol.PType.ERROR);
                System.err.println("Invalid types for * or / operator " + e1.toString() + " " + e2.toString() + " on line " + ctx.start.getLine());
            }
        } else if (op == Operator.PType.REM) {
            Symbol.PType e1 = exprType.get(ctx.expression_evaluation(0));
            Symbol.PType e2 = exprType.get(ctx.expression_evaluation(1));

            if (e1 == Symbol.PType.ERROR || e2 == Symbol.PType.ERROR)
                exprType.put(ctx, Symbol.PType.ERROR);

            if (e1 == Symbol.PType.INT && e2 == Symbol.PType.INT)
                exprType.put(ctx, Symbol.PType.INT);
            else {
                this.validated = false;
                semanticErrors++;
                exprType.put(ctx, Symbol.PType.ERROR);
                System.err.println("Invalid types for % operator " + e1.toString() + " " + e2.toString() + " on line " + ctx.start.getLine());
            }
        } else {
            this.validated = false;
            semanticErrors++;
            exprType.put(ctx, Symbol.PType.ERROR);
            System.err.println("Invalid operator " + op.toString() + " on line " + ctx.start.getLine());
        }
    }

    // expression_evaluation = unary_operators expression_evaluation
    public void exitUnaryExp(Projeto.UnaryExpContext ctx) {
        String operator = ctx.start.getText();
        Symbol.PType e1 = exprType.get(ctx.expression_evaluation());

        switch (operator) {
            case "+":
            case "-":
                if (e1 == Symbol.PType.INT || e1 == Symbol.PType.FLOAT) exprType.put(ctx, e1);
                else {
                    this.validated = false;
                    semanticErrors++;
                    exprType.put(ctx, Symbol.PType.ERROR);
                    System.err.println("Invalid operand type " + e1.toString() + " on line " + ctx.start.getLine());
                }
                break;
            case "~":
                if (e1 == Symbol.PType.BOOL) exprType.put(ctx, e1);
                else {
                    this.validated = false;
                    semanticErrors++;
                    exprType.put(ctx, Symbol.PType.ERROR);
                    System.err.println("Invalid operand type " + e1.toString() + " on line " + ctx.start.getLine());
                }
                break;
            case "?":
                if (Symbol.isPrimitive(e1)) {
                    Symbol.PType primitivePointer = primitiveToPointer(e1);
                    exprType.put(ctx, primitivePointer);
                } else {
                    this.validated = false;
                    semanticErrors++;
                    exprType.put(ctx, Symbol.PType.ERROR);
                    System.err.println("Invalid type" + e1.toString() + " on line " + ctx.start.getLine());
                }
                break;
        }
    }


    // expression_evaluation = expression_evaluation LBRACKET expression_evaluation RBRACKET
    public void exitPointerExp(Projeto.PointerExpContext ctx) {
        Symbol.PType e1 = exprType.get(ctx.expression_evaluation(0));
        Symbol.PType e2 = exprType.get(ctx.expression_evaluation(1));

        if (!(e1 == Symbol.PType.BOOL_POINTER || e1 == Symbol.PType.INT_POINTER || e1 == Symbol.PType.FLOAT_POINTER || e1 == Symbol.PType.STRING_POINTER)) {
            this.validated = false;
            semanticErrors++;
            exprType.put(ctx, Symbol.PType.ERROR);
            System.err.println("Invalid type for " + e1 + "[" + e2 + "]" + " on line " + ctx.start.getLine());
        }
        if (e2 != Symbol.PType.INT) {
            this.validated = false;
            semanticErrors++;
            exprType.put(ctx, Symbol.PType.ERROR);
            System.err.println("E2 is not an integer but a  " + e2.toString() + " on line " + ctx.start.getLine());
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

    // function_invocation : id_invocation | special_invocation;
    public void exitFunction_call(Projeto.Function_callContext ctx) {
        exprType.put(ctx, exprType.get(ctx.function_invocation()));
    }

    //expression_evaluation : expression_evaluation binary_op_ADD_SUB expression_evaluation
    public void exitAddSub(Projeto.AddSubContext ctx) {
        Symbol.PType e1 = exprType.get(ctx.expression_evaluation(0));
        Symbol.PType e2 = exprType.get(ctx.expression_evaluation(1));

        if (e1 == Symbol.PType.ERROR || e2 == Symbol.PType.ERROR)
            exprType.put(ctx, Symbol.PType.ERROR);
        else if ((e1 == Symbol.PType.INT || e1 == Symbol.PType.FLOAT) && (e2 == Symbol.PType.FLOAT || e2 == Symbol.PType.INT)) {
            if (e1 == Symbol.PType.INT && e2 == Symbol.PType.INT)
                exprType.put(ctx, Symbol.PType.INT);
            else {
                exprType.put(ctx, Symbol.PType.FLOAT);
            }
        } else if (Symbol.isAPrimitivePointer(e1) && e2 == Symbol.PType.INT) {
            exprType.put(ctx, e1);
        } else {
            this.validated = false;
            semanticErrors++;
            exprType.put(ctx, Symbol.PType.ERROR);
            System.err.println("Something is wrong on line " + ctx.start.getLine());
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

    //function_invocation : id_invocation | special_invocation;
    public void exitFunction_invocation(Projeto.Function_invocationContext ctx) {
        exprType.put(ctx, exprType.get(ctx.id_invocation()));
    }


    // (IDENTIFIER | expression) EQUAL expression;
    public void exitAttribution_instruction(Projeto.Attribution_instructionContext ctx) {
        this.currentFunction.hasIns = true;
        Symbol.PType leftSide;
        Symbol.PType rightSide;
        if (this.currentScope.resolve(ctx.IDENTIFIER().getText()) == null) {
            this.validated = false;
            this.semanticErrors++;
            System.err.println("Undefined variable " + ctx.IDENTIFIER().getText() + " in line " + ctx.IDENTIFIER().getSymbol().getLine() + " position " + ctx.IDENTIFIER().getSymbol().getCharPositionInLine());
            return;
        } else {
            leftSide = this.currentScope.resolve(ctx.IDENTIFIER().getText()).type;
            rightSide = this.exprType.get(ctx.expression(0));
        }
        if (!Symbol.isCastingPossible(leftSide, rightSide))
            if (rightSide == Symbol.PType.VOID) {
                this.validated = false;
                this.semanticErrors++;
                System.err.println("Invalid type of attribution (" + leftSide + " = " + rightSide + ") on line: " + ctx.start.getLine());
            } else if (rightSide != leftSide) {
                this.validated = false;
                this.semanticErrors++;
                System.err.println("Invalid type of attribution (" + leftSide + " = " + rightSide + ") on line: " + ctx.start.getLine());
            }
    }


    //expr --> ID;
    public void exitVar(Projeto.VarContext ctx) {
        String variableName = ctx.IDENTIFIER().getText();
        Symbol s = this.currentScope.resolve(variableName);
        if (s == null) {
            this.validated = false;
            this.semanticErrors++;
            this.exprType.put(ctx, Symbol.PType.ERROR);
            System.err.println("Undefined variable " + variableName + " in line " + ctx.IDENTIFIER().getSymbol().getLine() + " position " + ctx.IDENTIFIER().getSymbol().getCharPositionInLine());
            return;
        }

        if (s instanceof FunctionSymbol) {
            this.validated = false;
            this.semanticErrors++;
            this.exprType.put(ctx, Symbol.PType.ERROR);
            System.err.println("Using function symbol " + variableName + " as variable in line " + ctx.IDENTIFIER().getSymbol().getLine());
            return;
        }
        this.exprType.put(ctx, s.type);
    }

    //write_function: WRITE LPAREN list_expressions? RPAREN;
    public void exitWrite_function(Projeto.Write_functionContext ctx) {
        for (Projeto.ExpressionContext expression :
                ctx.list_expressions().expression()) {
            if (!Symbol.isPrimitive(exprType.get(expression))) {
                this.validated = false;
                this.semanticErrors++;
                System.err.println("Write function can only receive primitive type arguments. Line : " + ctx.start.getLine());
            }
        }
    }


    //    write_function: WRITELN LPAREN list_expressions? RPAREN;
    public void exitWriteln_fuction(Projeto.Writeln_fuctionContext ctx) {
        for (Projeto.ExpressionContext expression :
                ctx.list_expressions().expression()) {
            if (!Symbol.isPrimitive(exprType.get(expression))) {
                this.validated = false;
                this.semanticErrors++;
                System.err.println("Writeln function can only receive primitive type arguments. Line : " + ctx.start.getLine());
            }
        }
    }


//------------------------------------------AUXILIAR METHODS-------------------------------------------------//


    //converts primitive type to a pointer type
    private Symbol.PType primitiveToPointer(Symbol.PType e1) {
        if (e1 == Symbol.PType.BOOL)
            return Symbol.PType.BOOL_POINTER;
        else if (e1 == Symbol.PType.FLOAT)
            return Symbol.PType.FLOAT_POINTER;
        else if (e1 == Symbol.PType.STRING)
            return Symbol.PType.STRING_POINTER;
        else
            return Symbol.PType.ERROR;
    }

    //gets index of first 'result' in list of instructions or variables
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

    //defines symbol in the scope
    private void defineSymbol(ParserRuleContext ctx, Symbol s) {
        if (!this.currentScope.define(s)) {
            this.validated = false;
            this.semanticErrors++;
            System.err.println("Redefining previously defined variable " + s.name + " in line " + ctx.start.getLine());
            return;
        }
        this.scopes.put(ctx, currentScope);
    }
}