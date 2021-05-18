package Symbols;

public class Operator {


    public enum PType {
        MUL,
        DIV,
        REM,
        ADD,
        SUB,
        LESSER,
        GREATER,
        GREATEQ,
        LESSEQ,
        EQUALS,
        NOTEQUALS,

    }




    public static boolean isSimpleOperator(Operator.PType type){
        return type == PType.LESSER || type == PType.GREATER || type == PType.GREATEQ || type == PType.LESSEQ;
    }

    public static boolean isEQualOperator(Operator.PType type)
    {
        return type == PType.EQUALS || type == PType.NOTEQUALS;
    }


}
