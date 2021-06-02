package Symbols;

import java.util.ArrayList;
import java.util.List;

public class FunctionSymbol extends Symbol {

    public List<Symbol> arguments;
    public Scope functionScope;
    public boolean hasIns;
    public boolean hasReturn;

    public FunctionSymbol(Type type, String functionName, Scope functionScope)
    {
        super(type,functionName);
        this.arguments = new ArrayList<Symbol>();
        this.functionScope = functionScope;
        hasIns = false;
        hasReturn = false;
    }

    public String toString()
    {
        return "#F#" + name + ":" + this.type + this.arguments.toString();
    }
}
