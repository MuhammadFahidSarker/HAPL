package com.fsapps;


import java.util.Collections;
import java.util.Map;

import com.fsapps.HAPL.HAPLLexer;
import com.fsapps.HAPL.HAPLParser;
import com.fsapps.HAPL.pro_visit.Function;
import com.fsapps.HAPL.pro_visit.HandleVisitor;
import com.fsapps.HAPL.pro_visit.Scope;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    public static void main(String[] args) {
        try {
            HAPLLexer lexer = new HAPLLexer(CharStreams.fromFileName("hello.hpl"));
            HAPLParser parser = new HAPLParser(new CommonTokenStream(lexer));
            parser.setBuildParseTree(true);
            ParseTree tree = parser.parse();

            Scope scope = new Scope();
            Map<String, Function> functions = Collections.emptyMap();
            HandleVisitor visitor = new HandleVisitor(scope, functions);
            visitor.visit(tree);
        } catch (Exception e) {
            if (e.getMessage() != null) {
                System.err.println(e.getMessage());
            } else {
                e.printStackTrace();
            }
        }
    }
}