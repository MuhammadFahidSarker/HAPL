package com.fsapps;


import java.util.Collections;
import java.util.Map;


import com.fsapps.HTPL.HTPLLexer;
import com.fsapps.HTPL.HTPLParser;
import com.fsapps.HTPL.pro_visit.Function;
import com.fsapps.HTPL.pro_visit.HandleVisitor;
import com.fsapps.HTPL.pro_visit.Scope;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    public static void main(String[] args) {
        try {
            HTPLLexer lexer = new HTPLLexer(CharStreams.fromFileName("hello.htpl"));
            HTPLParser parser = new HTPLParser(new CommonTokenStream(lexer));
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