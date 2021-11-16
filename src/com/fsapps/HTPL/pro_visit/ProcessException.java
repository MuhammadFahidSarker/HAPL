package com.fsapps.HTPL.pro_visit;


import org.antlr.v4.runtime.ParserRuleContext;

public class ProcessException extends RuntimeException {
    public ProcessException(ParserRuleContext ctx) {
        this("Illegal expression: " + ctx.getText(), ctx);
    }

    public ProcessException(String msg, ParserRuleContext ctx) {
        super(msg + " line:" + ctx.start.getLine());
    }
}