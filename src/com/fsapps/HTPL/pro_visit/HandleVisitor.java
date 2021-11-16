package com.fsapps.HTPL.pro_visit;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fsapps.HTPL.HTPLBaseVisitor;
import com.fsapps.HTPL.HTPLLexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import com.fsapps.HTPL.HTPLParser.*;

public class HandleVisitor extends HTPLBaseVisitor<HTPL> {
    private static FunctionReturn functionReturn = new FunctionReturn();
    private Scope scope;
    private Map<String, Function> functions;

    public HandleVisitor(Scope scope, Map<String, Function> functions) {
        this.scope = scope;
        this.functions = new HashMap<>(functions);
    }

    // functionDecl
    @Override
    public HTPL visitFunctionDecl(FunctionDeclContext ctx) {
        List<TerminalNode> params = (ctx.functionParam() != null && ctx.functionParam().idList() != null)? ctx.functionParam().idList().Identifier() : new ArrayList<TerminalNode>();
        ParseTree block = ctx.block();
        String id = ctx.Identifier().get(0).getText() + params.size();
        // TODO: throw exception if function is already defined?
        functions.put(id, new Function(scope, params, block));
        return HTPL.VOID;
    }

    // list: '[' exprList? ']'
    @Override
    public HTPL visitList(ListContext ctx) {
        List<HTPL> list = new ArrayList<>();
        if (ctx.exprList() != null) {
            for(ExpressionContext ex: ctx.exprList().expression()) {
                list.add(this.visit(ex));
            }
        }
        return new HTPL(list);
    }


    // '-' expression                           #unaryMinusExpression
    @Override
    public HTPL visitUnaryMinusExpression(UnaryMinusExpressionContext ctx) {
        HTPL v = this.visit(ctx.expression());
        if (!v.isNumber()) {
            throw new ProcessException(ctx);
        }
        return new HTPL(-1 * v.asDouble());
    }

    // '!' expression                           #notExpression
    @Override
    public HTPL visitNotExpression(NotExpressionContext ctx) {
        HTPL v = this.visit(ctx.expression());
        if(!v.isBoolean()) {
            throw new ProcessException(ctx);
        }
        return new HTPL(!v.asBoolean());
    }

    // expression '^' expression                #powerExpression
    @Override
    public HTPL visitPowerExpression(PowerExpressionContext ctx) {
        HTPL lhs = this.visit(ctx.expression(0));
        HTPL rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new HTPL(Math.pow(lhs.asDouble(), rhs.asDouble()));
        }
        throw new ProcessException(ctx);
    }

    // expression op=( '*' | '/' | '%' ) expression         #multExpression
    @Override
    public HTPL visitMultExpression(MultExpressionContext ctx) {
        switch (ctx.op.getType()) {
            case HTPLLexer.Multiply:
                return multiply(ctx);
            case HTPLLexer.Divide:
                return divide(ctx);
            case HTPLLexer.Modulus:
                return modulus(ctx);
            default:
                throw new RuntimeException("unknown operator type: " + ctx.op.getType());
        }
    }

    // expression op=( '+' | '-' ) expression               #addExpression
    @Override
    public HTPL visitAddExpression(AddExpressionContext ctx) {
        switch (ctx.op.getType()) {
            case HTPLLexer.Add:
                return add(ctx);
            case HTPLLexer.Subtract:
                return subtract(ctx);
            default:
                throw new RuntimeException("unknown operator type: " + ctx.op.getType());
        }
    }

    // expression op=( '>=' | '<=' | '>' | '<' ) expression #compExpression
    @Override
    public HTPL visitCompExpression(CompExpressionContext ctx) {
        switch (ctx.op.getType()) {
            case HTPLLexer.LT:
                return lt(ctx);
            case HTPLLexer.LTEquals:
                return ltEq(ctx);
            case HTPLLexer.GT:
                return gt(ctx);
            case HTPLLexer.GTEquals:
                return gtEq(ctx);
            default:
                throw new RuntimeException("unknown operator type: " + ctx.op.getType());
        }
    }

    // expression op=( '==' | '!=' ) expression             #eqExpression
    @Override
    public HTPL visitEqExpression(EqExpressionContext ctx) {
        switch (ctx.op.getType()) {
            case HTPLLexer.Equals:
                return eq(ctx);
            case HTPLLexer.NEquals:
                return nEq(ctx);
            default:
                throw new RuntimeException("unknown operator type: " + ctx.op.getType());
        }
    }

    public HTPL multiply(MultExpressionContext ctx) {
        HTPL lhs = this.visit(ctx.expression(0));
        HTPL rhs = this.visit(ctx.expression(1));
        if(lhs == null || rhs == null) {
            System.err.println("lhs "+ lhs+ " rhs "+rhs);
            throw new ProcessException(ctx);
        }

        // number * number
        if(lhs.isNumber() && rhs.isNumber()) {
            return new HTPL(lhs.asDouble() * rhs.asDouble());
        }

        // string * number
        if(lhs.isString() && rhs.isNumber()) {
            StringBuilder str = new StringBuilder();
            int stop = rhs.asDouble().intValue();
            for(int i = 0; i < stop; i++) {
                str.append(lhs.asString());
            }
            return new HTPL(str.toString());
        }

        // list * number
        if(lhs.isList() && rhs.isNumber()) {
            List<HTPL> total = new ArrayList<>();
            int stop = rhs.asDouble().intValue();
            for(int i = 0; i < stop; i++) {
                total.addAll(lhs.asList());
            }
            return new HTPL(total);
        }

        throw new ProcessException(ctx);
    }

    private HTPL divide(MultExpressionContext ctx) {
        HTPL lhs = this.visit(ctx.expression(0));
        HTPL rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new HTPL(lhs.asDouble() / rhs.asDouble());
        }
        throw new ProcessException(ctx);
    }

    private HTPL modulus(MultExpressionContext ctx) {
        HTPL lhs = this.visit(ctx.expression(0));
        HTPL rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new HTPL(lhs.asDouble() % rhs.asDouble());
        }
        throw new ProcessException(ctx);
    }

    private HTPL add(AddExpressionContext ctx) {
        HTPL lhs = this.visit(ctx.expression(0));
        HTPL rhs = this.visit(ctx.expression(1));

        if(lhs == null || rhs == null) {
            throw new ProcessException(ctx);
        }

        // number + number
        if(lhs.isNumber() && rhs.isNumber()) {
            return new HTPL(lhs.asDouble() + rhs.asDouble());
        }

        // list + any
        if(lhs.isList()) {
            List<HTPL> list = lhs.asList();
            list.add(rhs);
            return new HTPL(list);
        }

        // string + any
        if(lhs.isString()) {
            return new HTPL(lhs.asString() + "" + rhs.toString());
        }

        // any + string
        if(rhs.isString()) {
            return new HTPL(lhs.toString() + "" + rhs.asString());
        }

        return new HTPL(lhs.toString() + rhs.toString());
    }

    private HTPL subtract(AddExpressionContext ctx) {
        HTPL lhs = this.visit(ctx.expression(0));
        HTPL rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new HTPL(lhs.asDouble() - rhs.asDouble());
        }
        if (lhs.isList()) {
            List<HTPL> list = lhs.asList();
            list.remove(rhs);
            return new HTPL(list);
        }
        throw new ProcessException(ctx);
    }

    private HTPL gtEq(CompExpressionContext ctx) {
        HTPL lhs = this.visit(ctx.expression(0));
        HTPL rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new HTPL(lhs.asDouble() >= rhs.asDouble());
        }
        if(lhs.isString() && rhs.isString()) {
            return new HTPL(lhs.asString().compareTo(rhs.asString()) >= 0);
        }
        throw new ProcessException(ctx);
    }

    private HTPL ltEq(CompExpressionContext ctx) {
        HTPL lhs = this.visit(ctx.expression(0));
        HTPL rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new HTPL(lhs.asDouble() <= rhs.asDouble());
        }
        if(lhs.isString() && rhs.isString()) {
            return new HTPL(lhs.asString().compareTo(rhs.asString()) <= 0);
        }
        throw new ProcessException(ctx);
    }

    private HTPL gt(CompExpressionContext ctx) {
        HTPL lhs = this.visit(ctx.expression(0));
        HTPL rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new HTPL(lhs.asDouble() > rhs.asDouble());
        }
        if(lhs.isString() && rhs.isString()) {
            return new HTPL(lhs.asString().compareTo(rhs.asString()) > 0);
        }
        throw new ProcessException(ctx);
    }

    private HTPL lt(CompExpressionContext ctx) {
        HTPL lhs = this.visit(ctx.expression(0));
        HTPL rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new HTPL(lhs.asDouble() < rhs.asDouble());
        }
        if(lhs.isString() && rhs.isString()) {
            return new HTPL(lhs.asString().compareTo(rhs.asString()) < 0);
        }
        throw new ProcessException(ctx);
    }

    private HTPL eq(EqExpressionContext ctx) {
        HTPL lhs = this.visit(ctx.expression(0));
        HTPL rhs = this.visit(ctx.expression(1));
        if (lhs == null) {
            throw new ProcessException(ctx);
        }
        return new HTPL(lhs.equals(rhs));
    }

    private HTPL nEq(EqExpressionContext ctx) {
        HTPL lhs = this.visit(ctx.expression(0));
        HTPL rhs = this.visit(ctx.expression(1));
        return new HTPL(!lhs.equals(rhs));
    }

    // expression '&&' expression               #andExpression
    @Override
    public HTPL visitAndExpression(AndExpressionContext ctx) {
        HTPL lhs = this.visit(ctx.expression(0));
        HTPL rhs = this.visit(ctx.expression(1));

        if(!lhs.isBoolean() || !rhs.isBoolean()) {
            throw new ProcessException(ctx);
        }
        return new HTPL(lhs.asBoolean() && rhs.asBoolean());
    }

    // expression '||' expression               #orExpression
    @Override
    public HTPL visitOrExpression(OrExpressionContext ctx) {
        HTPL lhs = this.visit(ctx.expression(0));
        HTPL rhs = this.visit(ctx.expression(1));

        if(!lhs.isBoolean() || !rhs.isBoolean()) {
            throw new ProcessException(ctx);
        }
        return new HTPL(lhs.asBoolean() || rhs.asBoolean());
    }

    // expression '?' expression ':' expression #ternaryExpression
    @Override
    public HTPL visitTernaryExpression(TernaryExpressionContext ctx) {
        HTPL condition = this.visit(ctx.expression(0));
        if (condition.asBoolean()) {
            return this.visit(ctx.expression(1));
        } else {
            return this.visit(ctx.expression(2));
        }
    }

    // expression In expression                 #inExpression
    @Override
    public HTPL visitInExpression(InExpressionContext ctx) {
        HTPL lhs = this.visit(ctx.expression(0));
        HTPL rhs = this.visit(ctx.expression(1));

        if (rhs.isList()) {
            for(HTPL val: rhs.asList()) {
                if (val.equals(lhs)) {
                    return new HTPL(true);
                }
            }
            return new HTPL(false);
        }
        throw new ProcessException(ctx);
    }

    // Number                                   #numberExpression
    @Override
    public HTPL visitNumberExpression(NumberExpressionContext ctx) {
        return new HTPL(Double.valueOf(ctx.getText()));
    }

    // Bool                                     #boolExpression
    @Override
    public HTPL visitBoolExpression(BoolExpressionContext ctx) {
        return new HTPL(Boolean.valueOf(ctx.getText()));
    }

    // Null                                     #nullExpression
    @Override
    public HTPL visitNullExpression(NullExpressionContext ctx) {
        return HTPL.NULL;
    }

    private HTPL resolveIndexes(HTPL val, List<ExpressionContext> indexes) {
        for (ExpressionContext ec: indexes) {
            HTPL idx = this.visit(ec);
            if (!idx.isNumber() || (!val.isList() && !val.isString()) ) {
                throw new ProcessException("Problem resolving indexes on "+val+" at "+idx, ec);
            }
            int i = idx.asDouble().intValue();
            if (val.isString()) {
                val = new HTPL(val.asString().substring(i, i+1));
            } else {
                val = val.asList().get(i);
            }
        }
        return val;
    }

    private void setAtIndex(ParserRuleContext ctx, List<ExpressionContext> indexes, HTPL val, HTPL newVal) {
        if (!val.isList()) {
            throw new ProcessException(ctx);
        }
        for (int i = 0; i < indexes.size() - 1; i++) {
            HTPL idx = this.visit(indexes.get(i));
            if (!idx.isNumber()) {
                throw new ProcessException(ctx);
            }
            val = val.asList().get(idx.asDouble().intValue());
        }
        HTPL idx = this.visit(indexes.get(indexes.size() - 1));
        if (!idx.isNumber()) {
            throw new ProcessException(ctx);
        }
        val.asList().set(idx.asDouble().intValue(), newVal);
    }

    // functionCall indexes?                    #functionCallExpression
    @Override
    public HTPL visitFunctionCallExpression(FunctionCallExpressionContext ctx) {
        HTPL val = this.visit(ctx.functionCall());
        if (ctx.indexes() != null) {
            List<ExpressionContext> exps = ctx.indexes().expression();
            val = resolveIndexes(val, exps);
        }
        return val;
    }

    // list indexes?                            #listExpression
    @Override
    public HTPL visitListExpression(ListExpressionContext ctx) {
        HTPL val = this.visit(ctx.list());
        if (ctx.indexes() != null) {
            List<ExpressionContext> exps = ctx.indexes().expression();
            val = resolveIndexes(val, exps);
        }
        return val;
    }

    // Identifier indexes?                      #identifierExpression
    @Override
    public HTPL visitIdentifierExpression(IdentifierExpressionContext ctx) {
        String id = ctx.Identifier().getText();
        HTPL val = scope.resolve(id);

        if (ctx.indexes() != null) {
            List<ExpressionContext> exps = ctx.indexes().expression();
            val = resolveIndexes(val, exps);
        }
        return val;
    }

    // String indexes?                          #stringExpression
    @Override
    public HTPL visitStringExpression(StringExpressionContext ctx) {
        String text = ctx.getText();
        text = text.substring(1, text.length() - 1).replaceAll("\\\\(.)", "$1");
        HTPL val = new HTPL(text);
        if (ctx.indexes() != null) {
            List<ExpressionContext> exps = ctx.indexes().expression();
            val = resolveIndexes(val, exps);
        }
        return val;
    }

    // '(' expression ')' indexes?              #expressionExpression
    @Override
    public HTPL visitExpressionExpression(ExpressionExpressionContext ctx) {
        HTPL val = this.visit(ctx.expression());
        if (ctx.indexes() != null) {
            List<ExpressionContext> exps = ctx.indexes().expression();
            val = resolveIndexes(val, exps);
        }
        return val;
    }

    // Input '(' String? ')'                    #inputExpression
//    @Override
//    public HTPL visitInputExpression(InputExpressionContext ctx) {
//        TerminalNode inputString = ctx.String();
//        try {
//            if (inputString != null) {
//                String text = inputString.getText();
//                text = text.substring(1, text.length() - 1).replaceAll("\\\\(.)", "$1");
//                return new HTPL(new String(Files.readAllBytes(Paths.get(text))));
//            } else {
//                BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//                return new HTPL(buffer.readLine());
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }


    // assignment
    // : Identifier indexes? '=' expression
    // ;
    @Override
    public HTPL visitAssignment(AssignmentContext ctx) {
        HTPL newVal = this.visit(ctx.expression());
        if (ctx.indexes() != null) {
            HTPL val = scope.resolve(ctx.Identifier().getText());
            List<ExpressionContext> exps = ctx.indexes().expression();
            setAtIndex(ctx, exps, val, newVal);
        } else {
            String id = ctx.Identifier().getText();
            scope.assign(id, newVal);
        }
        return HTPL.VOID;
    }



    // Identifier '(' exprList? ')' #identifierFunctionCall
    @Override
    public HTPL visitIdentifierFunctionCall(IdentifierFunctionCallContext ctx) {
        List<ExpressionContext> params = ctx.exprList() != null ? ctx.exprList().expression() : new ArrayList<ExpressionContext>();
        String id = ctx.Identifier().getText() + params.size();
        Function function;
        if ((function = functions.get(id)) != null) {
            List<HTPL> args = new ArrayList<>(params.size());
            for (ExpressionContext param: params) {
                args.add(this.visit(param));
            }
            return function.invoke(args, functions);
        }
        throw new ProcessException(ctx);
    }

    // Println '(' expression? ')'  #printlnFunctionCall
//    @Override
//    public HTPL visitPrintlnFunctionCall(PrintlnFunctionCallContext ctx) {
//        if (ctx.expression() != null) {
//            System.out.println(this.visit(ctx.expression()));
//        } else {
//            System.out.println();
//        }
//        return HTPL.VOID;
//    }

    // Print '(' expression ')'     #printFunctionCall
    @Override
    public HTPL visitPrintFunctionCall(PrintFunctionCallContext ctx) {
        System.out.println(this.visit(ctx.expression()));
        return HTPL.VOID;
    }

    // Assert '(' expression ')'    #assertFunctionCall
    @Override
    public HTPL visitAssertFunctionCall(AssertFunctionCallContext ctx) {
        HTPL value = this.visit(ctx.expression());

        if(!value.isBoolean()) {
            throw new ProcessException(ctx);
        }

        if(!value.asBoolean()) {
            throw new AssertionError("Failed Assertion "+ctx.expression().getText()+" line:"+ctx.start.getLine());
        }

        return HTPL.VOID;
    }

    // Size '(' expression ')'      #sizeFunctionCall
    @Override
    public HTPL visitSizeFunctionCall(SizeFunctionCallContext ctx) {
        HTPL value = this.visit(ctx.expression());

        if(value.isString()) {
            return new HTPL(value.asString().length());
        }

        if(value.isList()) {
            return new HTPL(value.asList().size());
        }

        throw new ProcessException(ctx);
    }

    // ifStatement
    //  : ifStat elseIfStat* elseStat? End
    //  ;
    //
    // ifStat
    //  : If expression Do block
    //  ;
    //
    // elseIfStat
    //  : Else If expression Do block
    //  ;
    //
    // elseStat
    //  : Else Do block
    //  ;
    @Override
    public HTPL visitIfStatement(IfStatementContext ctx) {

        // if ...
        if(this.visit(ctx.ifStat().expression()).asBoolean()) {
            return this.visit(ctx.ifStat().block());
        }

        // else if ...
        for(int i = 0; i < ctx.elseIfStat().size(); i++) {
            if(this.visit(ctx.elseIfStat(i).expression()).asBoolean()) {
                return this.visit(ctx.elseIfStat(i).block());
            }
        }

        // else ...
        if(ctx.elseStat() != null) {
            return this.visit(ctx.elseStat().block());
        }

        return HTPL.VOID;
    }

    // block
    // : (statement | functionDecl)* (Return expression)?
    // ;
    @Override
    public HTPL visitBlock(BlockContext ctx) {

        scope = new Scope(scope, false); // create new local scope
        for (FunctionDeclContext fdx: ctx.functionDecl()) {
            this.visit(fdx);
        }
        for (StatementContext sx: ctx.statement()) {
            this.visit(sx);
        }
        ExpressionContext ex;
        if ((ex = ctx.expression()) != null) {
            functionReturn.value = this.visit(ex);
            scope = scope.parent();
            throw functionReturn;
        }
        scope = scope.parent();
        return HTPL.VOID;
    }

    @Override
    public HTPL visitRepeatFixed(RepeatFixedContext ctx) {
        int count = this.visit(ctx.expression()).asDouble().intValue();
        for(int i = 1; i <= count; i++) {
            scope.assign("repeatFor"+count, new HTPL(i));
            HTPL FunctionReturn = this.visit(ctx.block());
            if(FunctionReturn != HTPL.VOID) {
                return FunctionReturn;
            }
        }
        return HTPL.VOID;
    }

    @Override
    public HTPL visitRepeatWithVar(RepeatWithVarContext ctx) {
        int start = this.visit(ctx.repeatFrom()).asDouble().intValue();
        int stop = this.visit(ctx.repeatTo()).asDouble().intValue();
        RepeatStepContext stepProvided = ctx.repeatStep();
        int step = stepProvided == null ? 1 : this.visit(stepProvided).asDouble().intValue();

        for(int i = start; i <= stop; i+= step) {
            scope.assign(ctx.Identifier().getText(), new HTPL(i));
            HTPL FunctionReturn = this.visit(ctx.block());
            if(FunctionReturn != HTPL.VOID) {
                return FunctionReturn;
            }
        }
        return HTPL.VOID;
    }

    @Override
    public HTPL visitRepeatWhile(RepeatWhileContext ctx) {
        while( this.visit(ctx.expression()).asBoolean() ) {
            HTPL FunctionReturn = this.visit(ctx.block());
            if (FunctionReturn != HTPL.VOID) {
                return FunctionReturn;
            }
        }
        return HTPL.VOID;
    }

}