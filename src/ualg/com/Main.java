package ualg.com;

//import Alg.CodeGen;
import Alg.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        String sourceFile;
        String outputFile;
        try {
            if(args.length == 0)
            {
                System.err.println("filename required for compilation!");
                System.exit(1);
            }
            if(args.length > 1)
            {
                outputFile = args[1];
            }
            else
            {

                outputFile = args[0].split("\\.")[0] + ".tac";
            }
            sourceFile = args[0];

            ProjetoLexer lexer = new ProjetoLexer(CharStreams.fromFileName("T3_example.alg"));
            Projeto parser = new Projeto(new CommonTokenStream(lexer));
            ParseTree tree = parser.program();
            System.out.println("syntatic parsing finished");

            // create a standard ANTLR parse tree walker
            ParseTreeWalker walker = new ParseTreeWalker();
            // create listener then feed to walker
//            TypeChecker listener = new TypeChecker();
            System.out.println("Type checking...");
            TypeChecker type_listener = new TypeChecker();
            walker.walk(type_listener, tree);
            RefChecker ref_listener = new RefChecker(type_listener.scopes, type_listener.exprType, type_listener.functions, type_listener.validated);
            walker.walk(ref_listener, tree);
            if (!ref_listener.validated) {
                int semanticErrors = type_listener.semanticErrors + ref_listener.semanticErrors;
                System.err.println("There was(were) " + semanticErrors + " semantic error(errors)");
                System.exit(1);
            } else
                System.out.println("No errors found!");


            System.out.println("Generating TAC code");

//            give the scopes created by the typeChecker to the codeGenerator
            CodeGen codeGen = new CodeGen(ref_listener.scopes);
            codeGen.visit(tree);

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            for(String s : codeGen.code)
            {
                if(!s.endsWith(":"))
                {
                    writer.write("\t");
                }
                writer.write(s);
                writer.newLine();
            }
            writer.flush();
            writer.close();

        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
}

