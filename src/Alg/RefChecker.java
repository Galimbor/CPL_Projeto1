package Alg;

import Symbols.FunctionSymbol;
import Symbols.Scope;
import Symbols.Symbol;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class RefChecker extends ProjetoBaseListener {
    public Scope globalScope;
    public Scope currentScope;
    private FunctionSymbol currentFunction;
    public int semanticErrors;
    public boolean haveAlg;

    public ParseTreeProperty<Scope> scopes;
    public ParseTreeProperty<FunctionSymbol> functions;
    public ParseTreeProperty<Symbol.PType> exprType;


    public RefChecker(ParseTreeProperty<Scope> scopes, ParseTreeProperty<Symbol.PType> exprType, ParseTreeProperty<FunctionSymbol> functions) {
        this.exprType = exprType;
        this.scopes = scopes;
        this.functions = functions;
    }

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
//                String errorMessage = "Cannot resolve function " + fs.name + "(";
                for (int i = 0; i < ctx.list_expressions().expression().size(); i++) {
//                    errorMessage = errorMessage.concat(fs.arguments.get(i).name);
                    if (!this.exprType.get(ctx.list_expressions().expression().get(i)).equals(fs.arguments.get(i).type)) {
                        System.err.println("Arguments of function " + functionName + " do not match the arguments " +
                                "declared in the function declaration");
                        return;
                    }
                }
            }
        }
    }
}