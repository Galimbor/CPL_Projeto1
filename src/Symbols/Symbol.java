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
        BOOL_POINTER
    }

    public PType type;
    public String name;
    public Scope scope;

    //usamos um enumerado para guardar o tipo, porque é mais eficiente nas comparações de tipos
    public Symbol(String type, String name) {
        if (type.equals("<int>"))
            this.type = PType.valueOf("INT_POINTER");
        else if (type.equals("<float>"))
            this.type = PType.valueOf("FLOAT_POINTER");
        else if (type.equals("<string>"))
            this.type = PType.valueOf("STRING_POINTER");
        else if (type.equals("<bool>"))
            this.type = PType.valueOf("BOOL_POINTER");
        else {
            this.type = PType.valueOf(type.toUpperCase(Locale.ROOT));
        }
        this.name = name;
    }

    public String toString() {
        return name + ":" + this.type;
    }
}
