package Symbols;

import java.util.ArrayList;
import java.util.List;

public class FunctionSymbolOLD extends SymbolOLD {

    public List<SymbolOLD> arguments;
    public boolean hasIns;
    public boolean hasReturn;


    public FunctionSymbolOLD(String type, String functionName)
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
