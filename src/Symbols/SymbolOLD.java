package Symbols;

import java.util.Locale;

//classe apenas com campos
public class SymbolOLD {

    public enum PType {
        INT,
        FLOAT,
        VOID,
        ERROR,
        INT_POINTER,
        FLOAT_POINTER,
        STRING_POINTER,
        BOOL_POINTER,
        NULL_POINTER,
        STRING,
        BOOL
    }

    public PType type;
    public String name;
    public ScopeOLD scopeOLD;

    //usamos um enumerado para guardar o tipo, porque é mais eficiente nas comparações de tipos
    public SymbolOLD(String type, String name) {
        if (type.equals("<int>"))
            this.type = PType.INT_POINTER;
        else if (type.equals("<float>"))
            this.type = PType.FLOAT_POINTER;
        else if (type.equals("<string>"))
            this.type = PType.STRING_POINTER;
        else if (type.equals("<bool>"))
            this.type = PType.BOOL_POINTER;
        else if (type.equals("<void>"))
            this.type = PType.NULL_POINTER;
        else {
            this.type = PType.valueOf(type.toUpperCase(Locale.ROOT));
        }
        this.name = name;
    }
    public String toString() {
        return name + ":" + this.type                 ;
    }


    public static boolean areBothTypesEqual(SymbolOLD.PType type1, SymbolOLD.PType type2)
    {
        return type1 == type2;
    }


    public static boolean isAPointer(SymbolOLD.PType type)
    {
        return isAPrimitivePointer(type) || type == PType.NULL_POINTER;
    }

    public static boolean isAPrimitivePointer(SymbolOLD.PType type)
    {
        return type == PType.BOOL_POINTER || type == PType.FLOAT_POINTER || type == PType.INT_POINTER
                || type == PType.STRING_POINTER ;
    }


    public static boolean isNumeric(SymbolOLD.PType type)
    {
        return type == PType.FLOAT || type == PType.INT;
    }


    public static boolean isPrimitive(SymbolOLD.PType e1)
    {
        return e1 == SymbolOLD.PType.FLOAT ||
                e1 == SymbolOLD.PType.BOOL ||
                e1 == SymbolOLD.PType.STRING ||
                e1 == SymbolOLD.PType.INT;
    }


    public static boolean isCastingPossible(SymbolOLD.PType e1, SymbolOLD.PType e2)
    {   boolean result = false;
        if(e1 == PType.FLOAT && e2 == PType.INT)
            result = true;
        else if(SymbolOLD.isAPointer(e1) && e2 == PType.NULL_POINTER)
            result = true;
        return result;
    }


}
