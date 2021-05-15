package Symbols;

import java.util.Locale;

//classe apenas com campos
public class Symbol {

    public enum PType {
        INT,
        FLOAT,
        VOID,
        ERROR,
        POINTER,
    }

    public PType type;
    public String name;
    public Scope scope;

    //usamos um enumerado para guardar o tipo, porque é mais eficiente nas comparações de tipos
    public Symbol(String type, String name) {
        if (type.startsWith("<"))
            this.type = PType.valueOf("POINTER");
        else {
            this.type = PType.valueOf(type.toUpperCase(Locale.ROOT));
        }
        this.name = name;
    }

    public String toString() {
        return name + ":" + this.type;
    }
}
