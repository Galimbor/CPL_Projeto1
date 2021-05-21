package Symbols;

import java.util.Locale;

//classe apenas com campos
public class Symbol {

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
    public Scope scope;

    //usamos um enumerado para guardar o tipo, porque é mais eficiente nas comparações de tipos
    public Symbol(String type, String name) {
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


    public static boolean areBothTypesEqual(Symbol.PType type1, Symbol.PType type2)
    {
        return type1 == type2;
    }


    public static boolean isAPointer(Symbol.PType type)
    {
        return isAPrimitivePointer(type) || type == PType.NULL_POINTER;
    }

    public static boolean isAPrimitivePointer(Symbol.PType type)
    {
        return type == PType.BOOL_POINTER || type == PType.FLOAT_POINTER || type == PType.INT_POINTER
                || type == PType.STRING_POINTER;
    }


    public static boolean isNumeric(Symbol.PType type)
    {
        return type == PType.FLOAT || type == PType.INT;
    }


    public static boolean isPrimitive(Symbol.PType e1)
    {
        return e1 == Symbol.PType.FLOAT ||
                e1 == Symbol.PType.BOOL ||
                e1 == Symbol.PType.STRING ||
                e1 == Symbol.PType.INT;
    }

}
