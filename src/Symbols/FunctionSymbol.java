package Symbols;

import java.util.ArrayList;
import java.util.List;

public class FunctionSymbol extends Symbol {

    public List<Symbol> arguments;
    public boolean hasIns;
    public boolean hasReturn;


    public FunctionSymbol(String type, String functionName)
    {
        super(type,functionName);
        hasIns = false;
        hasReturn = false;
        this.arguments = new ArrayList<>();
    }

    public String toString()
    {
        return "#F#" + name + ":" + this.type + this.arguments.toString();
    }
}
