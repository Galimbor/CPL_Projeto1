package ualg.com;

import Alg.Projeto;
import Alg.ProjetoLexer;
import Alg.RefChecker;
import Alg.TypeChecker;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            ProjetoLexer simpleLexer = new ProjetoLexer(CharStreams.fromFileName("gamer.sim"));
            Projeto simpleParser = new Projeto(new CommonTokenStream(simpleLexer));
            ParseTree tree = simpleParser.program();
            System.out.println("syntatic parsing finished");
            // create a standard ANTLR parse tree walker
            ParseTreeWalker walker = new ParseTreeWalker();
            // create listener then feed to walker
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}