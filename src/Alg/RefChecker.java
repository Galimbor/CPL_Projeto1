package Alg;

import Symbols.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.List;

public class RefChecker extends ProjetoBaseListener {
    public Scope currentScope;
    public int semanticErrors;
    public boolean validated;
    public ParseTreeProperty<Scope> scopes;
    public ParseTreeProperty<FunctionSymbol> functions;
    public ParseTreeProperty<Type> exprType;
    ParseTreeProperty<OperatorOLD.PType> opType = new ParseTreeProperty<>();
    private FunctionSymbol currentFunction;

    public ParseTreeProperty<Boolean> pointerExtr = new ParseTreeProperty<>();


    public RefChecker(ParseTreeProperty<Scope> scopes, ParseTreeProperty<Type> exprType, ParseTreeProperty<FunctionSymbol> functions, boolean validated) {
        this.exprType = exprType;
        this.scopes = scopes;
        this.functions = functions;
        this.validated = validated;
    }

    //program :
    //        EOF {notifyErrorListeners("Program must have at least one declaration");}
    //    |   declaration+ EOF;
    public void enterProgram(Projeto.ProgramContext ctx) {
        currentScope = this.scopes.get(ctx);
    }


    //id_invocation : IDENTIFIER LPAREN list_expressions? RPAREN;
    public void exitId_invocation(Projeto.Id_invocationContext ctx) {
        String functionName = ctx.IDENTIFIER().getText();
        Symbol s = scopes.get(ctx).resolve(functionName);
        if (s == null) {
            System.err.println("Undefined function '" + functionName + "' on line " + ctx.IDENTIFIER().getSymbol().getLine() + " position: " + ctx.IDENTIFIER().getSymbol().getCharPositionInLine());
            this.validated = false;
            this.semanticErrors++;
        }
        if (!(s instanceof FunctionSymbol)) {
            System.err.println("Using var symbol '" + functionName + "' as function on line " + ctx.IDENTIFIER().getSymbol().getLine() + " position: " + ctx.IDENTIFIER().getSymbol().getCharPositionInLine());
            this.validated = false;
            this.semanticErrors++;
        } else {
            FunctionSymbol fs = (FunctionSymbol) s;
            if (ctx.list_expressions() != null && fs.arguments.size() == ctx.list_expressions().expression().size()) {
                for (int i = 0; i < ctx.list_expressions().expression().size(); i++) {
                    Type calledArg = this.exprType.get(ctx.list_expressions().expression().get(i));
                    Type declaredArg = fs.arguments.get(i).type;
                    if (Type.isConvertibleTo( calledArg, declaredArg)) continue;
                    if (!calledArg.equals(declaredArg)) {
                        this.validated = false;
                        this.semanticErrors++;
                        this.exprType.put(ctx, new Type(Type.PType.ERROR));
                        System.err.println("Arguments of function '" + functionName + "' do not match the arguments " +
                                "declared in the function declaration on line " + ctx.start.getLine());
                        return;
                    }
                }
            }
            else if (ctx.list_expressions() != null) {
                this.validated = false;
                this.semanticErrors++;
                this.exprType.put(ctx, new Type(Type.PType.ERROR));
                System.err.println("Number of arguments of function '" + functionName + "' do not match the number of arguments " +
                        "declared in the function declaration on line " + ctx.start.getLine());
                return;
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
            System.err.println("Function '" + this.currentFunction.name + "' has to have at least one instruction" + ". Line: " + ctx.start.getLine());
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
            System.err.println("Function '" + this.currentFunction.name + "' has to have at least one instruction" + ". Line: " + ctx.start.getLine());
        }
        this.currentFunction = null;
        this.currentScope = this.currentScope.getParentScope();
    }


    // prologue: AT block;
    public void exitPrologue(Projeto.PrologueContext ctx) {
        List<Projeto.Var_or_instructionContext> listOfVar_or_instructions = ctx.block().var_or_instruction();

        if (!this.currentFunction.type.equals( new Type(Type.PType.VOID))) {
            int lastLine = countInstrutionsLinha(listOfVar_or_instructions);
            int linhaResult = checkResultLine(listOfVar_or_instructions);
            if (linhaResult == -1) {
//                Do nothing

            } else if (this.currentFunction.hasIns && lastLine != -1) {
                if (linhaResult < lastLine) {
                    this.validated = false;
                    this.semanticErrors++;
                    System.err.println("Return on central block of function '" + this.currentFunction.name + "' is not the last instruction. Line: " + linhaResult);
                }
            } else {
                if (this.currentFunction.hasReturn) {
                    if (linhaResult < lastLine) {
                        this.validated = false;
                        this.semanticErrors++;
                        System.err.println("Return on central block is not the last instruction, line: " + linhaResult);
                    }
                }
            }
        }
    }

    //  central: block;
    public void exitCentral(Projeto.CentralContext ctx) {
        List<Projeto.Var_or_instructionContext> listOfVar_or_instructions = ctx.block().var_or_instruction();

        if (!this.currentFunction.type.equals(new Type(Type.PType.VOID))) {
            if (!this.currentFunction.hasReturn) {
                this.validated = false;
                this.semanticErrors++;
                System.err.println("Missing return statement. Line: " + ctx.start.getLine());
                return;
            }
            int lastLine = countInstrutionsLinha(listOfVar_or_instructions);
            int linhaResult = checkResultLine(listOfVar_or_instructions);
            if (linhaResult == -1) {
//                Do nothing

            } else if (this.currentFunction.hasIns && lastLine != -1) {
                if (linhaResult < lastLine) {
                    this.validated = false;
                    this.semanticErrors++;
                    System.err.println("Return on central block of function '" + this.currentFunction.name + "' is not the last instruction. Line: " + linhaResult);
                }
            } else {
                if (this.currentFunction.hasReturn) {
                    if (linhaResult < lastLine) {
                        this.validated = false;
                        this.semanticErrors++;
                        System.err.println("Return on central block is not the last instruction, line: " + linhaResult);
                    }
                }
            }
        }
    }


    // epilogue: EXTRACT block;
    public void exitEpilogue(Projeto.EpilogueContext ctx) {
        List<Projeto.Var_or_instructionContext> listOfVar_or_instructions = ctx.block().var_or_instruction();
        if (!this.currentFunction.type.equals(new Type(Type.PType.VOID))) {
            int lastLine = countInstrutionsLinha(listOfVar_or_instructions);
            int linhaResult = checkResultLine(listOfVar_or_instructions);
            if (linhaResult == -1) {
//          Do nothing

            } else if (this.currentFunction.hasIns && lastLine != -1) {
                if (linhaResult < lastLine) {
                    this.validated = false;
                    this.semanticErrors++;
                    System.err.println("Return on central block of function '" + this.currentFunction.name + "' is not the last instruction. Line: " + linhaResult);
                }
            } else {
                if (this.currentFunction.hasReturn) {
                    if (linhaResult < lastLine) {
                        this.validated = false;
                        this.semanticErrors++;
                        System.err.println("Return on central block is not the last instruction, line: " + linhaResult);
                    }
                }
            }
        }
    }


    //    control_instructions : RETURN expression?
    public void exitReturn(Projeto.ReturnContext ctx) {
        this.currentFunction.hasIns = true;
        this.currentFunction.hasReturn = true;
        Type expr = exprType.get(ctx.expression());
        if (this.currentFunction != null) {
            if (this.currentFunction.type.equals(new Type(Type.PType.VOID))) {
                if (ctx.expression() != null) {
                    this.validated = false;
                    this.semanticErrors++;
                    System.err.println("Unexpected return value on line " + ctx.start.getLine());
                }
            } else {
                if ( Type.isConvertibleTo(expr, this.currentFunction.type)) {
                    //do nothing
                } else if (this.currentFunction.type != expr) {
                    this.validated = false;
                    this.semanticErrors++;
                    System.err.println("Incompatible types: '" + expr + "' cannot be converted to '" + this.currentFunction.type + "' on line: " + ctx.start.getLine());
                }
            }
        }
    }


    //var_declaration_init : type IDENTIFIER EQUAL expression
    public void exitDeclAndAtrib(Projeto.DeclAndAtribContext ctx) {
        String stype = ctx.type().start.getText();
        String name = ctx.IDENTIFIER().getText();


        Symbol symbol = new Symbol(new Type(stype), name);
        Type expression = exprType.get(ctx.expression());
        if (Type.isConvertibleTo(expression, symbol.type)) {
            //do nothing
        } else if (!(symbol.type == expression)) {
            this.validated = false;
            semanticErrors++;
            System.err.println("Invalid variable type " + symbol.type + " of variable " + name + " since the right side value is of type " + expression + ", Line: " + ctx.start.getLine());
        }
        defineSymbol(ctx, new Symbol(new Type(ctx.type().start.getText()), ctx.IDENTIFIER().getText()));
    }

    //alot of expressions!
    public void exitExpression(Projeto.ExpressionContext ctx) {
        Type type = exprType.get(ctx.expression_evaluation());
        exprType.put(ctx, type);
    }


    //expression_evaluation:  expression_evaluation comparator_OTHER expression_evaluation
    public void exitCompOther(Projeto.CompOtherContext ctx) {
        Type e1 = exprType.get(ctx.expression_evaluation(0));
        Type e2 = exprType.get(ctx.expression_evaluation(1));

        OperatorOLD.PType op = opType.get(ctx.comparators());
        if (OperatorOLD.isSimpleOperator(op)) {
            if (Type.isNumeric(e1) && Type.isNumeric(e2)) {
                exprType.put(ctx, new Type(Type.PType.BOOL));
            } else {
                this.validated = false;
                semanticErrors++;
                exprType.put(ctx, new Type(Type.PType.ERROR));
                System.err.println("Operator '" + ctx.comparators().getText() + "' cannot be applied to '" + e1 + "', '" + e2 + "' on line " + ctx.start.getLine());
            }
        } else if (OperatorOLD.isEQualOperator(op)) {
            if (Type.isPrimitive(e1) && Type.isPrimitive(e2)) {
                if (e1.equals(e2)) {
                    exprType.put(ctx, new Type(Type.PType.BOOL));
                } else {
                    this.validated = false;
                    semanticErrors++;
                    exprType.put(ctx, new Type(Type.PType.ERROR));
                    System.err.println("Operator '" + ctx.comparators().getText() + "' cannot be applied to '" + e1 + "', '" + e2 + "' on line " + ctx.start.getLine());
                }
            } else if (e1.isPointer() && e2.isPointer()) {
                if ((e1.isPointer() && e2.isPointer()) && (e1.getPrimitiveType() == Type.PType.VOID && e2.getPrimitiveType() != Type.PType.VOID) || (e1.getPrimitiveType() != Type.PType.VOID && e2.getPrimitiveType() == Type.PType.VOID))
                    exprType.put(ctx, new Type(Type.PType.BOOL));
                else if (e1.equals( e2)) {
                    exprType.put(ctx, new Type(Type.PType.BOOL));
                } else {
                    this.validated = false;
                    semanticErrors++;
                    exprType.put(ctx, new Type(Type.PType.ERROR));
                    System.err.println("Operator '" + ctx.comparators().getText() + "' cannot be applied to '" + e1 + "', '" + e2 + "' on line " + ctx.start.getLine());
                }
            }
        } else {
            this.validated = false;
            semanticErrors++;
            exprType.put(ctx, new Type(Type.PType.ERROR));
            System.err.println("Operator '" + ctx.comparators().getText() + "' cannot be applied to '" + e1 + "' , '" + e2 + "' on line " + ctx.start.getLine());
        }

    }


    //     expression_evaluation:  expression_evaluation comparator_AND expression_evaluation
    public void exitCompAnd(Projeto.CompAndContext ctx) {
        Type e1 = exprType.get(ctx.expression_evaluation(0));
        Type e2 = exprType.get(ctx.expression_evaluation(1));
        if (e1.getPrimitiveType() == Type.PType.BOOL && e2.getPrimitiveType() == Type.PType.BOOL) {
            exprType.put(ctx, new Type(Type.PType.BOOL));
        } else {
            System.err.println("Operator '" + ctx.comparator_AND().getText() + "' cannot be applied to '" + e1 + "' , '" + e2 + "' on line " + ctx.start.getLine());
            this.validated = false;
            semanticErrors++;
            exprType.put(ctx, new Type(Type.PType.ERROR));
        }

    }


    //     expression_evaluation:  expression_evaluation comparator_OR expression_evaluation
    public void exitCompOr(Projeto.CompOrContext ctx) {
        Type e1 = exprType.get(ctx.expression_evaluation(0));
        Type e2 = exprType.get(ctx.expression_evaluation(1));

        if (e1.getPrimitiveType() == Type.PType.BOOL && e2.getPrimitiveType() == Type.PType.BOOL) {
            exprType.put(ctx, new Type(Type.PType.BOOL));
        } else {
            System.err.println("Operator '" + ctx.comparator_OR().getText() + "' cannot be applied to '" + e1 + "', '" + e2 + "' on line " + ctx.start.getLine());
            this.validated = false;
            semanticErrors++;
            exprType.put(ctx, new Type(Type.PType.ERROR));
        }
    }


    //var_declaration_init : type IDENTIFIER EQUAL (LBRACKET expression RBRACKET | NULL)
    public void exitMemDecl(Projeto.MemDeclContext ctx) {
        String stype = ctx.type().start.getText();
        String name = ctx.IDENTIFIER().getText();
        Symbol type = new Symbol(new Type(stype), name);


        Type expression = exprType.get(ctx.expression());
        if (!Type.isAPrimitivePointer(type.type)) {
            this.validated = false;
            semanticErrors++;
            System.err.println("Invalid variable type '" + stype + "' of variable '" + name + "', pointer must be of a primitive type, on line " + ctx.start.getLine());
        }

        if (expression.getPrimitiveType() != Type.PType.INT) {
            this.validated = false;
            semanticErrors++;
            System.err.println("Incompatible type " + type.type + "[" + expression + "]" + " on line " + ctx.start.getLine());
        }

        defineSymbol(ctx, new Symbol(new Type(ctx.type().start.getText()), ctx.IDENTIFIER().getText()));
    }


    // expression_evaluation : expression_evaluation (DIV | MUL | PERCENT) expression_evaluation
    public void exitMulDivRem(Projeto.MulDivRemContext ctx) {
        OperatorOLD.PType op = opType.get(ctx.binary_op_MUL_DIV_REM());

        if (op == OperatorOLD.PType.MUL | op == OperatorOLD.PType.DIV) {
            Type e1 = exprType.get(ctx.expression_evaluation(0));
            Type e2 = exprType.get(ctx.expression_evaluation(1));


            if(!Type.isNumeric(e1) || !Type.isNumeric(e2))
            {
                exprType.put(ctx, new Type(Type.PType.ERROR));
                this.validated = false;
                semanticErrors++;
                System.err.println("Invalid types for '*' or '/' operator '" + e1.toString() + "', '" + e2.toString() + "' on line " + ctx.start.getLine());
            }
            else  {
                exprType.put(ctx, Type.getMaxType(e1, e2));
            }
        }
        else if (op == OperatorOLD.PType.REM) {
            Type e1 = exprType.get(ctx.expression_evaluation(0));
            Type e2 = exprType.get(ctx.expression_evaluation(1));

            if (e1.isError() || e2.isError())
                exprType.put(ctx, new Type(Type.PType.ERROR));

            if (e1.getPrimitiveType() == Type.PType.INT && e2.getPrimitiveType() == Type.PType.INT)
                exprType.put(ctx, new Type(Type.PType.INT));
            else {
                this.validated = false;
                semanticErrors++;
                exprType.put(ctx, new Type(Type.PType.ERROR));
                System.err.println("Invalid types for '%' operator '" + e1.toString() + "' , '" + e2.toString() + ". '%' is only valid for 'INT' types, on line " + ctx.start.getLine());
            }
        } else {
            this.validated = false;
            semanticErrors++;
            exprType.put(ctx, new Type(Type.PType.ERROR));
            System.err.println("Invalid operator '" + op.toString() + "' on line " + ctx.start.getLine());
        }
    }

    // expression_evaluation = unary_operators expression_evaluation
    public void exitUnaryExp(Projeto.UnaryExpContext ctx) {
        String operator = ctx.start.getText();
        Type e1 = exprType.get(ctx.expression_evaluation());

        switch (operator) {
            case "+":
            case "-":
                if (Type.isNumeric(e1) ) exprType.put(ctx, e1);
                else {
                    this.validated = false;
                    semanticErrors++;
                    exprType.put(ctx, new Type(Type.PType.ERROR));
                    System.err.println("Invalid operand type '" + e1.toString() + "' on line " + ctx.start.getLine());
                }
                break;
            case "~":
                if (e1.getPrimitiveType() == Type.PType.BOOL) exprType.put(ctx, e1);
                else {
                    this.validated = false;
                    semanticErrors++;
                    exprType.put(ctx, new Type(Type.PType.ERROR));
                    System.err.println("Invalid operand type '" + e1.toString() + "' on line " + ctx.start.getLine());
                }
                break;
            case "?":
                if (pointerExtr.get(ctx.expression_evaluation()) == null) {
                    this.validated = false;
                    semanticErrors++;
                    exprType.put(ctx, new Type(Type.PType.ERROR));
                    System.err.println("Can only assign '?' to variables or pointer indexing, on line " + ctx.start.getLine());
                }
                if (Type.isPrimitive(e1)) {
                    Type primitivePointer = e1.extractPointerType();
                    exprType.put(ctx, primitivePointer);
                } else {
                    this.validated = false;
                    semanticErrors++;
                    exprType.put(ctx, new Type(Type.PType.ERROR));
                    System.err.println("Invalid type '" + e1 + "' on line " + ctx.start.getLine());
                }
                break;
        }
    }


    // expression_evaluation = expression_evaluation LBRACKET expression_evaluation RBRACKET
    public void exitPointerExp(Projeto.PointerExpContext ctx) {
        Type e1 = exprType.get(ctx.expression_evaluation(0));
        Type e2 = exprType.get(ctx.expression_evaluation(1));

        if (!(e1.isPointer() && (e1.getPrimitiveType() == Type.PType.BOOL || e1.getPrimitiveType() == Type.PType.INT ||
                e1.getPrimitiveType() == Type.PType.FLOAT || e1.getPrimitiveType() == Type.PType.STRING))) {
            this.validated = false;
            semanticErrors++;
            exprType.put(ctx, new Type(Type.PType.ERROR));
            System.err.println("Invalid type for : " + e1 + "[" + e2 + "]" + " on line " + ctx.start.getLine());
        }
        if (e2.getPrimitiveType() != Type.PType.INT) {
            this.validated = false;
            semanticErrors++;
            exprType.put(ctx, new Type(Type.PType.ERROR));
            System.err.println("E2 is not an 'INT' but a '" + e2.toString() + "' on line " + ctx.start.getLine());
        }
        exprType.put(ctx, e1.extractValueType());
        pointerExtr.put(ctx, true);
    }


    //  expression_evaluation : LPAREN expression_evaluation RPAREN
    public void exitParenExp(Projeto.ParenExpContext ctx) {
        Type expressionType = exprType.get(ctx.expression_evaluation());
        exprType.put(ctx, expressionType);
        if (pointerExtr.get(ctx.expression_evaluation()) != null) {
            boolean result = pointerExtr.get(ctx.expression_evaluation());
            pointerExtr.put(ctx, result);
        }
    }


    // expression_evaluation : simple_expression
    public void exitSimpExp(Projeto.SimpExpContext ctx) {
        Type expressionType = exprType.get(ctx.simple_expression());

        exprType.put(ctx, expressionType);
        if (pointerExtr.get(ctx.simple_expression()) != null) {
            boolean result = pointerExtr.get(ctx.simple_expression());
            pointerExtr.put(ctx, result);
        }

    }

    // function_invocation : id_invocation | special_invocation;
    public void exitFunction_call(Projeto.Function_callContext ctx) {
        exprType.put(ctx, exprType.get(ctx.function_invocation()));
    }

    //expression_evaluation : expression_evaluation binary_op_ADD_SUB expression_evaluation
    public void exitAddSub(Projeto.AddSubContext ctx) {
        Type e1 = exprType.get(ctx.expression_evaluation(0));
        Type e2 = exprType.get(ctx.expression_evaluation(1));

        if (e1.isError() || e2.isError())
            exprType.put(ctx, new Type(Type.PType.ERROR));
        else if (Type.isNumeric(e1) && Type.isNumeric(e2)) {
            if (e1.getPrimitiveType() == Type.PType.INT && e2.getPrimitiveType() == Type.PType.INT)
                exprType.put(ctx, new Type(Type.PType.INT));
            else {
                exprType.put(ctx, new Type(Type.PType.FLOAT));
            }
        } else if (e1.isPointer() && Type.isPrimitive(e1)  && e2.getPrimitiveType() == Type.PType.INT) {
            exprType.put(ctx, e1);
        } else {
            this.validated = false;
            semanticErrors++;
            exprType.put(ctx, new Type(Type.PType.ERROR));
            System.err.println("Operator '" + ctx.binary_op_ADD_SUB().getText() + "' cannot be applied to '" + e1 + "', '" + e2 + "' on line " + ctx.start.getLine());
        }

    }

    //simple_expression:    INTEGER
    public void exitInt(Projeto.IntContext ctx) {
        exprType.put(ctx, new Type(Type.PType.INT));
    }

    //simple_expression:    REAL
    public void exitReal(Projeto.RealContext ctx) {
        exprType.put(ctx, new Type(Type.PType.FLOAT));
    }

    //simple_expression:    STRING
    public void exitString(Projeto.StringContext ctx) {
        exprType.put(ctx, new Type(Type.PType.STRING));
    }

    //    binary_op_MUL_DIV_REM: MUL
    public void exitMul(Projeto.MulContext ctx) {
        opType.put(ctx, OperatorOLD.PType.MUL);
    }


    //    binary_op_MUL_DIV_REM: DIV
    public void exitDiv(Projeto.DivContext ctx) {
        opType.put(ctx, OperatorOLD.PType.DIV);
    }


    //    binary_op_MUL_DIV_REM: PERCENT
    public void exitPercent(Projeto.PercentContext ctx) {
        opType.put(ctx, OperatorOLD.PType.REM);
    }

    //    comparators: LESSER
    public void exitLesser(Projeto.LesserContext ctx) {
        opType.put(ctx, OperatorOLD.PType.LESSER);
    }

    //    comparators: LESSEQ
    public void exitLesseq(Projeto.LesseqContext ctx) {
        opType.put(ctx, OperatorOLD.PType.LESSEQ);
    }

    //    comparators: GREATER
    public void exitGreater(Projeto.GreaterContext ctx) {
        opType.put(ctx, OperatorOLD.PType.GREATER);
    }

    //    comparators: GREATEQ
    public void exitGreateq(Projeto.GreateqContext ctx) {
        opType.put(ctx, OperatorOLD.PType.GREATEQ);
    }

    //    comparators: EQUALS
    public void exitEquals(Projeto.EqualsContext ctx) {
        opType.put(ctx, OperatorOLD.PType.EQUALS);
    }

    //    comparators: NOTEQUALS
    public void exitNotequals(Projeto.NotequalsContext ctx) {
        opType.put(ctx, OperatorOLD.PType.NOTEQUALS);
    }

    //    simple_expression: NULL
    public void exitNull(Projeto.NullContext ctx) {
//        System.out.println( new Type("null"));
        exprType.put(ctx, new Type("null"));
//        System.out.println(exprType.get(ctx));
    }

    //    simple_expression: NULL
    public void exitTrue(Projeto.TrueContext ctx) {
        exprType.put(ctx, new Type(Type.PType.BOOL));
    }

    //    simple_expression: NULL
    public void exitFalse(Projeto.FalseContext ctx) {
        exprType.put(ctx, new Type(Type.PType.BOOL));
    }


    //    instruction :
    //    expression SEMI_COLON
    //    |   control_instructions SEMI_COLON
    //    |   attribution_instruction SEMI_COLON
    //    |   conditional_instruction SEMI_COLON {notifyErrorListeners("Extraneous ';'");}
    //    |   conditional_instruction
    //    |   cicle_instruction SEMI_COLON {notifyErrorListeners("Extraneous ';'");}
    //    |   cicle_instruction
    //    |   subblock_instruction SEMI_COLON {notifyErrorListeners("Extraneous ';'");}
    //    |   subblock_instruction
    //    ;
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
        Type leftSide;
        Type rightSide;
        if (ctx.IDENTIFIER() == null) {
            leftSide = this.exprType.get(ctx.expression(0));
            rightSide = this.exprType.get(ctx.expression(1));
        } else if (this.currentScope.resolve(ctx.IDENTIFIER().getText()) == null) {
            this.validated = false;
            this.semanticErrors++;
            System.err.println("Undefined variable '" + ctx.IDENTIFIER().getText() + "' on line " + ctx.IDENTIFIER().getSymbol().getLine() + " position " + ctx.IDENTIFIER().getSymbol().getCharPositionInLine());
            return;
        } else {
            leftSide = this.currentScope.resolve(ctx.IDENTIFIER().getText()).type;
            rightSide = this.exprType.get(ctx.expression(0));
        }
//        System.out.println("Left is " + leftSide + " and right side is " + rightSide);
        if (!Type.isConvertibleTo(rightSide,leftSide)) {
            if (rightSide.getPrimitiveType() == Type.PType.VOID) {

                this.validated = false;
                this.semanticErrors++;
                System.err.println("Incompatible types: '" + rightSide + "' cannot be converted to '" + leftSide + "' on line: " + ctx.start.getLine());
            } else if (!rightSide.equals(leftSide)) {
                this.validated = false;
                this.semanticErrors++;
                System.err.println("Incompatible types: '" + rightSide + "' cannot be converted to '" + leftSide + "' on line: " + ctx.start.getLine());
            }
        }
    }


    //expr --> ID;
    public void exitVar(Projeto.VarContext ctx) {
        String variableName = ctx.IDENTIFIER().getText();
        Symbol s = this.currentScope.resolve(variableName);
        if (s == null) {
            this.validated = false;
            this.semanticErrors++;
            this.exprType.put(ctx, new Type(Type.PType.ERROR));
            System.err.println("Undefined variable '" + variableName + "' on line " + ctx.IDENTIFIER().getSymbol().getLine() + " position " + ctx.IDENTIFIER().getSymbol().getCharPositionInLine());
            return;
        }

        if (s instanceof FunctionSymbol) {
            this.validated = false;
            this.semanticErrors++;
            this.exprType.put(ctx, new Type(Type.PType.ERROR));
            System.err.println("Using function symbol '" + variableName + "' as variable on line " + ctx.IDENTIFIER().getSymbol().getLine());
            return;
        }
        this.exprType.put(ctx, s.type);
        this.pointerExtr.put(ctx, true);
    }

    //write_function: WRITE LPAREN list_expressions? RPAREN;
    public void exitWrite_function(Projeto.Write_functionContext ctx) {
        for (Projeto.ExpressionContext expression :
                ctx.list_expressions().expression()) {
            if (!Type.isPrimitive(exprType.get(expression))) {
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
            if (!Type.isPrimitive(exprType.get(expression))) {
                this.validated = false;
                this.semanticErrors++;
                System.err.println("Writeln function can only receive primitive type arguments. Line : " + ctx.start.getLine());
            }
        }
    }


//------------------------------------------AUXILIAR METHODS-------------------------------------------------//






//    //gets index of first 'result' in list of instructions or variables
//    public int checkResultIndex(List<Projeto.Var_or_instructionContext> listOfVarsOrIns) {
//        int result = -1;
//        int i = 0;
//        for (Projeto.Var_or_instructionContext listOfVarsOrIn : listOfVarsOrIns) {
//            if (listOfVarsOrIn.instruction() != null && listOfVarsOrIn.instruction().subblock_instruction() != null) {
//                result = checkResultSubblock(listOfVarsOrIn.instruction().subblock_instruction(), i);
//                if (result != -1) break;
//            } else if (listOfVarsOrIn.instruction() != null && listOfVarsOrIn.instruction().start.getText().equals("return")) {
//                result = i;
//                break;
//            }
//            i++;
//        }
//        System.out.println("The result is " + result);
//        return result;
//    }


    public int countInstrutions(List<Projeto.Var_or_instructionContext> listOfVarsOrIns) {
        int result = 0;
        for (Projeto.Var_or_instructionContext listOfVarsOrIn : listOfVarsOrIns) {

            if (listOfVarsOrIn.instruction() != null && listOfVarsOrIn.instruction().subblock_instruction() != null) {
                result = countSubblockInstructions(listOfVarsOrIn.instruction().subblock_instruction(), result + 1);
            } else {
                result++;
            }

        }
        return result;
    }

    public int countInstrutionsLinha(List<Projeto.Var_or_instructionContext> listOfVarsOrIns) {
        int lastElementIndex = listOfVarsOrIns.size() - 1;

        int linha = -1;

        if (lastElementIndex >= 0) {
            Projeto.Var_or_instructionContext lastElement = listOfVarsOrIns.get(lastElementIndex);
            if (lastElement.instruction() != null && (lastElement.instruction().subblock_instruction() != null
                    || lastElement.instruction().cicle_instruction() != null)) {
                linha = countSubblockInstructionsLinha(lastElement.instruction(), linha);
            } else {
                linha = lastElement.start.getLine();
            }
        }
        return linha;
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
                if (ins.subblock_instruction() != null || ins.cicle_instruction() != null) {
                    linha = ins.start.getLine();
                    linha = countSubblockInstructionsLinha(ins, linha);
                } else {
                    linha = ins.start.getLine();
                }
            }
        }
        return linha;
    }


    private int countSubblockInstructions(Projeto.Subblock_instructionContext ctx, int result) {
        for (Projeto.InstructionContext ins : ctx.instruction()
        ) {
            if (ins.subblock_instruction() != null) {
                result = countSubblockInstructions(ins.subblock_instruction(), result + 1);
            } else {
                result++;
            }
        }
        return result;
    }


    //gets index of first 'result' in list of instructions or variables
public int checkResultLine(List<Projeto.Var_or_instructionContext> listOfVarsOrIns) {
        int line = -1;
        for (Projeto.Var_or_instructionContext listOfVarsOrIn : listOfVarsOrIns) {
            if (listOfVarsOrIn.instruction() != null && listOfVarsOrIn.instruction().subblock_instruction() != null) {
                line = checkResultSubblockLinhas(listOfVarsOrIn.instruction().subblock_instruction(), line);
                if (line != -1) break;
            } else if (listOfVarsOrIn.instruction() != null && listOfVarsOrIn.instruction().start.getText().equals("return")) {
                line = listOfVarsOrIn.instruction().start.getLine();
                break;
            }

        }
        return line;
    }


    public int checkResultSubblockLinhas(Projeto.Subblock_instructionContext ctx, int line) {
        for (Projeto.InstructionContext ins : ctx.instruction()
        ) {
            if (ins.subblock_instruction() != null) {
                line = checkResultSubblockLinhas(ins.subblock_instruction(), line);
                if (line != -1) {
                    return line;
                }

            } else if (ins.control_instructions() != null && ins.control_instructions().start.getText().equals("return")) {
                return ins.start.getLine();
            }
        }
        return -1;
    }


//    public int checkResultSubblock(Projeto.Subblock_instructionContext ctx, int index) {
//        int result = index;
//        for (Projeto.InstructionContext ins : ctx.instruction()
//        ) {
//            if (ins.subblock_instruction() != null) {
//                result++;
//                index++;
//                result = checkResultSubblock(ins.subblock_instruction(), result);
//                if (result != -1) {
//                    return result;
//                }
//
//                result = index;
//                result += ins.subblock_instruction().instruction().size();
//
//            } else if (ins.control_instructions() != null && ins.control_instructions().start.getText().equals("return")) {
//                return result;
//            }
//            result++;
//            index++;
//        }
//        return -1;
//    }


    //defines symbol in the scope
    private void defineSymbol(ParserRuleContext ctx, Symbol s) {
        if (!this.currentScope.define(s)) {
            this.validated = false;
            this.semanticErrors++;
            System.err.println("Redefining previously defined variable '" + s.name + "' on line " + ctx.start.getLine());
            return;
        }
        this.scopes.put(ctx, currentScope);
    }
}