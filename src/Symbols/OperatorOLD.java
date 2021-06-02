package Symbols;

public class OperatorOLD {


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




    public static boolean isSimpleOperator(OperatorOLD.PType type){
        return type == PType.LESSER || type == PType.GREATER || type == PType.GREATEQ || type == PType.LESSEQ;
    }

    public static boolean isEQualOperator(OperatorOLD.PType type)
    {
        return type == PType.EQUALS || type == PType.NOTEQUALS;
    }


}
