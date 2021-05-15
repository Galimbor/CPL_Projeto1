package ualg.com;

import Alg.Projeto;
import Alg.ProjetoLexer;
import Alg.TypeChecker;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            ProjetoLexer simpleLexer = new ProjetoLexer(CharStreams.fromFileName("example.sim"));
            Projeto simpleParser = new Projeto(new CommonTokenStream(simpleLexer));
            ParseTree tree = simpleParser.program();
            System.out.println("syntatic parsing finished");

            // create a standard ANTLR parse tree walker
            ParseTreeWalker walker = new ParseTreeWalker();
            // create listener then feed to walker
            System.out.println("Type checking...");
            TypeChecker listener = new TypeChecker();
            walker.walk(listener, tree);

            if (!listener.validated) System.exit(1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}