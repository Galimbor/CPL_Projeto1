package Symbols;

//classe apenas com campos
public class Symbol {

    public final Type type;
    public final String name;
    public int width;
    public int offset;
    public Scope scope;
    public boolean isValueKnown;
    public boolean isWidthKnown;
    public Object value;

    //usamos um enumerado para guardar o tipo, porque é mais eficiente nas comparações de tipos
    public Symbol(Type type, String name)
    {
        this.type = type;
        this.name = name;
        this.width = type.getWidth();

        isValueKnown = false;
        //by default, we know the size needed to store all pointers, and all primitive types
        //except for strings, which need to be dynamically allocated
        if(!type.isPointer() && type.getPrimitiveType() == Type.PType.STRING)
        {
            this.isWidthKnown = false;
        }
        else this.isWidthKnown = true;

        //this.offset = offset;
    }

    public Symbol(Type type, String name, Object value)
    {
        this.type = type;
        this.name = name;
        this.width = type.getWidth();
        this.isValueKnown = true;
        this.isWidthKnown = true;
        this.value = value;

        //this.offset = offset;
    }

    /*public Symbol(Type type, String name, int offset)
    {
        this.type = type;
        this.name = name;
        this.width = type.getWidth();
        this.offset = offset;
    }*/

    public String toString()
    {
        return name + ":" + this.type;
    }
}
