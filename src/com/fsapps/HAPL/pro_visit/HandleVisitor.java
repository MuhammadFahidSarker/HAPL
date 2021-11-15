package com.fsapps.HAPL.pro_visit;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fsapps.HAPL.HAPLBaseVisitor;
import com.fsapps.HAPL.HAPLLexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import com.fsapps.HAPL.HAPLParser.*;

public class HandleVisitor extends HAPLBaseVisitor<HAPL> {
    private static FunctionReturn functionReturn = new FunctionReturn();
    private Scope scope;
    private Map<String, Function> functions;

    public HandleVisitor(Scope scope, Map<String, Function> functions) {
        this.scope = scope;
        this.functions = new HashMap<>(functions);
    }

    // functionDecl
    @Override
    public HAPL visitFunctionDecl(FunctionDeclContext ctx) {
        List<TerminalNode> params = (ctx.functionParam() != null && ctx.functionParam().idList() != null)? ctx.functionParam().idList().Identifier() : new ArrayList<TerminalNode>();
        ParseTree block = ctx.block();
        String id = ctx.Identifier().get(0).getText() + params.size();
        // TODO: throw exception if function is already defined?
        functions.put(id, new Function(scope, params, block));
        return HAPL.VOID;
    }

    // list: '[' exprList? ']'
    @Override
    public HAPL visitList(ListContext ctx) {
        List<HAPL> list = new ArrayList<>();
        if (ctx.exprList() != null) {
            for(ExpressionContext ex: ctx.exprList().expression()) {
                list.add(this.visit(ex));
            }
        }
        return new HAPL(list);
    }


    // '-' expression                           #unaryMinusExpression
    @Override
    public HAPL visitUnaryMinusExpression(UnaryMinusExpressionContext ctx) {
        HAPL v = this.visit(ctx.expression());
        if (!v.isNumber()) {
            throw new ProcessException(ctx);
        }
        return new HAPL(-1 * v.asDouble());
    }

    // '!' expression                           #notExpression
    @Override
    public HAPL visitNotExpression(NotExpressionContext ctx) {
        HAPL v = this.visit(ctx.expression());
        if(!v.isBoolean()) {
            throw new ProcessException(ctx);
        }
        return new HAPL(!v.asBoolean());
    }

    // expression '^' expression                #powerExpression
    @Override
    public HAPL visitPowerExpression(PowerExpressionContext ctx) {
        HAPL lhs = this.visit(ctx.expression(0));
        HAPL rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new HAPL(Math.pow(lhs.asDouble(), rhs.asDouble()));
        }
        throw new ProcessException(ctx);
    }

    // expression op=( '*' | '/' | '%' ) expression         #multExpression
    @Override
    public HAPL visitMultExpression(MultExpressionContext ctx) {
        switch (ctx.op.getType()) {
            case HAPLLexer.Multiply:
                return multiply(ctx);
            case HAPLLexer.Divide:
                return divide(ctx);
            case HAPLLexer.Modulus:
                return modulus(ctx);
            default:
                throw new RuntimeException("unknown operator type: " + ctx.op.getType());
        }
    }

    // expression op=( '+' | '-' ) expression               #addExpression
    @Override
    public HAPL visitAddExpression(AddExpressionContext ctx) {
        switch (ctx.op.getType()) {
            case HAPLLexer.Add:
                return add(ctx);
            case HAPLLexer.Subtract:
                return subtract(ctx);
            default:
                throw new RuntimeException("unknown operator type: " + ctx.op.getType());
        }
    }

    // expression op=( '>=' | '<=' | '>' | '<' ) expression #compExpression
    @Override
    public HAPL visitCompExpression(CompExpressionContext ctx) {
        switch (ctx.op.getType()) {
            case HAPLLexer.LT:
                return lt(ctx);
            case HAPLLexer.LTEquals:
                return ltEq(ctx);
            case HAPLLexer.GT:
                return gt(ctx);
            case HAPLLexer.GTEquals:
                return gtEq(ctx);
            default:
                throw new RuntimeException("unknown operator type: " + ctx.op.getType());
        }
    }

    // expression op=( '==' | '!=' ) expression             #eqExpression
    @Override
    public HAPL visitEqExpression(EqExpressionContext ctx) {
        switch (ctx.op.getType()) {
            case HAPLLexer.Equals:
                return eq(ctx);
            case HAPLLexer.NEquals:
                return nEq(ctx);
            default:
                throw new RuntimeException("unknown operator type: " + ctx.op.getType());
        }
    }

    public HAPL multiply(MultExpressionContext ctx) {
        HAPL lhs = this.visit(ctx.expression(0));
        HAPL rhs = this.visit(ctx.expression(1));
        if(lhs == null || rhs == null) {
            System.err.println("lhs "+ lhs+ " rhs "+rhs);
            throw new ProcessException(ctx);
        }

        // number * number
        if(lhs.isNumber() && rhs.isNumber()) {
            return new HAPL(lhs.asDouble() * rhs.asDouble());
        }

        // string * number
        if(lhs.isString() && rhs.isNumber()) {
            StringBuilder str = new StringBuilder();
            int stop = rhs.asDouble().intValue();
            for(int i = 0; i < stop; i++) {
                str.append(lhs.asString());
            }
            return new HAPL(str.toString());
        }

        // list * number
        if(lhs.isList() && rhs.isNumber()) {
            List<HAPL> total = new ArrayList<>();
            int stop = rhs.asDouble().intValue();
            for(int i = 0; i < stop; i++) {
                total.addAll(lhs.asList());
            }
            return new HAPL(total);
        }

        throw new ProcessException(ctx);
    }

    private HAPL divide(MultExpressionContext ctx) {
        HAPL lhs = this.visit(ctx.expression(0));
        HAPL rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new HAPL(lhs.asDouble() / rhs.asDouble());
        }
        throw new ProcessException(ctx);
    }

    private HAPL modulus(MultExpressionContext ctx) {
        HAPL lhs = this.visit(ctx.expression(0));
        HAPL rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new HAPL(lhs.asDouble() % rhs.asDouble());
        }
        throw new ProcessException(ctx);
    }

    private HAPL add(AddExpressionContext ctx) {
        HAPL lhs = this.visit(ctx.expression(0));
        HAPL rhs = this.visit(ctx.expression(1));

        if(lhs == null || rhs == null) {
            throw new ProcessException(ctx);
        }

        // number + number
        if(lhs.isNumber() && rhs.isNumber()) {
            return new HAPL(lhs.asDouble() + rhs.asDouble());
        }

        // list + any
        if(lhs.isList()) {
            List<HAPL> list = lhs.asList();
            list.add(rhs);
            return new HAPL(list);
        }

        // string + any
        if(lhs.isString()) {
            return new HAPL(lhs.asString() + "" + rhs.toString());
        }

        // any + string
        if(rhs.isString()) {
            return new HAPL(lhs.toString() + "" + rhs.asString());
        }

        return new HAPL(lhs.toString() + rhs.toString());
    }

    private HAPL subtract(AddExpressionContext ctx) {
        HAPL lhs = this.visit(ctx.expression(0));
        HAPL rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new HAPL(lhs.asDouble() - rhs.asDouble());
        }
        if (lhs.isList()) {
            List<HAPL> list = lhs.asList();
            list.remove(rhs);
            return new HAPL(list);
        }
        throw new ProcessException(ctx);
    }

    private HAPL gtEq(CompExpressionContext ctx) {
        HAPL lhs = this.visit(ctx.expression(0));
        HAPL rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new HAPL(lhs.asDouble() >= rhs.asDouble());
        }
        if(lhs.isString() && rhs.isString()) {
            return new HAPL(lhs.asString().compareTo(rhs.asString()) >= 0);
        }
        throw new ProcessException(ctx);
    }

    private HAPL ltEq(CompExpressionContext ctx) {
        HAPL lhs = this.visit(ctx.expression(0));
        HAPL rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new HAPL(lhs.asDouble() <= rhs.asDouble());
        }
        if(lhs.isString() && rhs.isString()) {
            return new HAPL(lhs.asString().compareTo(rhs.asString()) <= 0);
        }
        throw new ProcessException(ctx);
    }

    private HAPL gt(CompExpressionContext ctx) {
        HAPL lhs = this.visit(ctx.expression(0));
        HAPL rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new HAPL(lhs.asDouble() > rhs.asDouble());
        }
        if(lhs.isString() && rhs.isString()) {
            return new HAPL(lhs.asString().compareTo(rhs.asString()) > 0);
        }
        throw new ProcessException(ctx);
    }

    private HAPL lt(CompExpressionContext ctx) {
        HAPL lhs = this.visit(ctx.expression(0));
        HAPL rhs = this.visit(ctx.expression(1));
        if (lhs.isNumber() && rhs.isNumber()) {
            return new HAPL(lhs.asDouble() < rhs.asDouble());
        }
        if(lhs.isString() && rhs.isString()) {
            return new HAPL(lhs.asString().compareTo(rhs.asString()) < 0);
        }
        throw new ProcessException(ctx);
    }

    private HAPL eq(EqExpressionContext ctx) {
        HAPL lhs = this.visit(ctx.expression(0));
        HAPL rhs = this.visit(ctx.expression(1));
        if (lhs == null) {
            throw new ProcessException(ctx);
        }
        return new HAPL(lhs.equals(rhs));
    }

    private HAPL nEq(EqExpressionContext ctx) {
        HAPL lhs = this.visit(ctx.expression(0));
        HAPL rhs = this.visit(ctx.expression(1));
        return new HAPL(!lhs.equals(rhs));
    }

    // expression '&&' expression               #andExpression
    @Override
    public HAPL visitAndExpression(AndExpressionContext ctx) {
        HAPL lhs = this.visit(ctx.expression(0));
        HAPL rhs = this.visit(ctx.expression(1));

        if(!lhs.isBoolean() || !rhs.isBoolean()) {
            throw new ProcessException(ctx);
        }
        return new HAPL(lhs.asBoolean() && rhs.asBoolean());
    }

    // expression '||' expression               #orExpression
    @Override
    public HAPL visitOrExpression(OrExpressionContext ctx) {
        HAPL lhs = this.visit(ctx.expression(0));
        HAPL rhs = this.visit(ctx.expression(1));

        if(!lhs.isBoolean() || !rhs.isBoolean()) {
            throw new ProcessException(ctx);
        }
        return new HAPL(lhs.asBoolean() || rhs.asBoolean());
    }

    // expression '?' expression ':' expression #ternaryExpression
    @Override
    public HAPL visitTernaryExpression(TernaryExpressionContext ctx) {
        HAPL condition = this.visit(ctx.expression(0));
        if (condition.asBoolean()) {
            return this.visit(ctx.expression(1));
        } else {
            return this.visit(ctx.expression(2));
        }
    }

    // expression In expression                 #inExpression
    @Override
    public HAPL visitInExpression(InExpressionContext ctx) {
        HAPL lhs = this.visit(ctx.expression(0));
        HAPL rhs = this.visit(ctx.expression(1));

        if (rhs.isList()) {
            for(HAPL val: rhs.asList()) {
                if (val.equals(lhs)) {
                    return new HAPL(true);
                }
            }
            return new HAPL(false);
        }
        throw new ProcessException(ctx);
    }

    // Number                                   #numberExpression
    @Override
    public HAPL visitNumberExpression(NumberExpressionContext ctx) {
        return new HAPL(Double.valueOf(ctx.getText()));
    }

    // Bool                                     #boolExpression
    @Override
    public HAPL visitBoolExpression(BoolExpressionContext ctx) {
        return new HAPL(Boolean.valueOf(ctx.getText()));
    }

    // Null                                     #nullExpression
    @Override
    public HAPL visitNullExpression(NullExpressionContext ctx) {
        return HAPL.NULL;
    }

    private HAPL resolveIndexes(HAPL val, List<ExpressionContext> indexes) {
        for (ExpressionContext ec: indexes) {
            HAPL idx = this.visit(ec);
            if (!idx.isNumber() || (!val.isList() && !val.isString()) ) {
                throw new ProcessException("Problem resolving indexes on "+val+" at "+idx, ec);
            }
            int i = idx.asDouble().intValue();
            if (val.isString()) {
                val = new HAPL(val.asString().substring(i, i+1));
            } else {
                val = val.asList().get(i);
            }
        }
        return val;
    }

    private void setAtIndex(ParserRuleContext ctx, List<ExpressionContext> indexes, HAPL val, HAPL newVal) {
        if (!val.isList()) {
            throw new ProcessException(ctx);
        }
        for (int i = 0; i < indexes.size() - 1; i++) {
            HAPL idx = this.visit(indexes.get(i));
            if (!idx.isNumber()) {
                throw new ProcessException(ctx);
            }
            val = val.asList().get(idx.asDouble().intValue());
        }
        HAPL idx = this.visit(indexes.get(indexes.size() - 1));
        if (!idx.isNumber()) {
            throw new ProcessException(ctx);
        }
        val.asList().set(idx.asDouble().intValue(), newVal);
    }

    // functionCall indexes?                    #functionCallExpression
    @Override
    public HAPL visitFunctionCallExpression(FunctionCallExpressionContext ctx) {
        HAPL val = this.visit(ctx.functionCall());
        if (ctx.indexes() != null) {
            List<ExpressionContext> exps = ctx.indexes().expression();
            val = resolveIndexes(val, exps);
        }
        return val;
    }

    // list indexes?                            #listExpression
    @Override
    public HAPL visitListExpression(ListExpressionContext ctx) {
        HAPL val = this.visit(ctx.list());
        if (ctx.indexes() != null) {
            List<ExpressionContext> exps = ctx.indexes().expression();
            val = resolveIndexes(val, exps);
        }
        return val;
    }

    // Identifier indexes?                      #identifierExpression
    @Override
    public HAPL visitIdentifierExpression(IdentifierExpressionContext ctx) {
        String id = ctx.Identifier().getText();
        HAPL val = scope.resolve(id);

        if (ctx.indexes() != null) {
            List<ExpressionContext> exps = ctx.indexes().expression();
            val = resolveIndexes(val, exps);
        }
        return val;
    }

    // String indexes?                          #stringExpression
    @Override
    public HAPL visitStringExpression(StringExpressionContext ctx) {
        String text = ctx.getText();
        text = text.substring(1, text.length() - 1).replaceAll("\\\\(.)", "$1");
        HAPL val = new HAPL(text);
        if (ctx.indexes() != null) {
            List<ExpressionContext> exps = ctx.indexes().expression();
            val = resolveIndexes(val, exps);
        }
        return val;
    }

    // '(' expression ')' indexes?              #expressionExpression
    @Override
    public HAPL visitExpressionExpression(ExpressionExpressionContext ctx) {
        HAPL val = this.visit(ctx.expression());
        if (ctx.indexes() != null) {
            List<ExpressionContext> exps = ctx.indexes().expression();
            val = resolveIndexes(val, exps);
        }
        return val;
    }

    // Input '(' String? ')'                    #inputExpression
//    @Override
//    public HAPL visitInputExpression(InputExpressionContext ctx) {
//        TerminalNode inputString = ctx.String();
//        try {
//            if (inputString != null) {
//                String text = inputString.getText();
//                text = text.substring(1, text.length() - 1).replaceAll("\\\\(.)", "$1");
//                return new HAPL(new String(Files.readAllBytes(Paths.get(text))));
//            } else {
//                BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//                return new HAPL(buffer.readLine());
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }


    // assignment
    // : Identifier indexes? '=' expression
    // ;
    @Override
    public HAPL visitAssignment(AssignmentContext ctx) {
        HAPL newVal = this.visit(ctx.expression());
        if (ctx.indexes() != null) {
            HAPL val = scope.resolve(ctx.Identifier().getText());
            List<ExpressionContext> exps = ctx.indexes().expression();
            setAtIndex(ctx, exps, val, newVal);
        } else {
            String id = ctx.Identifier().getText();
            scope.assign(id, newVal);
        }
        return HAPL.VOID;
    }



    // Identifier '(' exprList? ')' #identifierFunctionCall
    @Override
    public HAPL visitIdentifierFunctionCall(IdentifierFunctionCallContext ctx) {
        List<ExpressionContext> params = ctx.exprList() != null ? ctx.exprList().expression() : new ArrayList<ExpressionContext>();
        String id = ctx.Identifier().getText() + params.size();
        Function function;
        if ((function = functions.get(id)) != null) {
            List<HAPL> args = new ArrayList<>(params.size());
            for (ExpressionContext param: params) {
                args.add(this.visit(param));
            }
            return function.invoke(args, functions);
        }
        throw new ProcessException(ctx);
    }

    // Println '(' expression? ')'  #printlnFunctionCall
//    @Override
//    public HAPL visitPrintlnFunctionCall(PrintlnFunctionCallContext ctx) {
//        if (ctx.expression() != null) {
//            System.out.println(this.visit(ctx.expression()));
//        } else {
//            System.out.println();
//        }
//        return HAPL.VOID;
//    }

    // Print '(' expression ')'     #printFunctionCall
    @Override
    public HAPL visitPrintFunctionCall(PrintFunctionCallContext ctx) {
        System.out.print(this.visit(ctx.expression()));
        return HAPL.VOID;
    }

    // Assert '(' expression ')'    #assertFunctionCall
    @Override
    public HAPL visitAssertFunctionCall(AssertFunctionCallContext ctx) {
        HAPL value = this.visit(ctx.expression());

        if(!value.isBoolean()) {
            throw new ProcessException(ctx);
        }

        if(!value.asBoolean()) {
            throw new AssertionError("Failed Assertion "+ctx.expression().getText()+" line:"+ctx.start.getLine());
        }

        return HAPL.VOID;
    }

    // Size '(' expression ')'      #sizeFunctionCall
    @Override
    public HAPL visitSizeFunctionCall(SizeFunctionCallContext ctx) {
        HAPL value = this.visit(ctx.expression());

        if(value.isString()) {
            return new HAPL(value.asString().length());
        }

        if(value.isList()) {
            return new HAPL(value.asList().size());
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
//    @Override
//    public HAPL visitIfStatement(IfStatementContext ctx) {
//
//        // if ...
//        if(this.visit(ctx.ifStat().expression()).asBoolean()) {
//            return this.visit(ctx.ifStat().block());
//        }
//
//        // else if ...
//        for(int i = 0; i < ctx.elseIfStat().size(); i++) {
//            if(this.visit(ctx.elseIfStat(i).expression()).asBoolean()) {
//                return this.visit(ctx.elseIfStat(i).block());
//            }
//        }
//
//        // else ...
//        if(ctx.elseStat() != null) {
//            return this.visit(ctx.elseStat().block());
//        }
//
//        return HAPL.VOID;
//    }

    // block
    // : (statement | functionDecl)* (Return expression)?
    // ;
    @Override
    public HAPL visitBlock(BlockContext ctx) {

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
        return HAPL.VOID;
    }

    // forStatement
    // : For Identifier '=' expression To expression OBrace block CBrace
    // ;
//    @Override
//    public HAPL visitForStatement(ForStatementContext ctx) {
//        int start = this.visit(ctx.expression(0)).asDouble().intValue();
//        int stop = this.visit(ctx.expression(1)).asDouble().intValue();
//        for(int i = start; i <= stop; i++) {
//            scope.assign(ctx.Identifier().getText(), new HAPL(i));
//            HAPL FunctionReturn = this.visit(ctx.block());
//            if(FunctionReturn != HAPL.VOID) {
//                return FunctionReturn;
//            }
//        }
//        return HAPL.VOID;
//    }
//
//    // whileStatement
//    // : While expression OBrace block CBrace
//    // ;
//    @Override
//    public HAPL visitWhileStatement(WhileStatementContext ctx) {
//        while( this.visit(ctx.expression()).asBoolean() ) {
//            HAPL FunctionReturn = this.visit(ctx.block());
//            if (FunctionReturn != HAPL.VOID) {
//                return FunctionReturn;
//            }
//        }
//        return HAPL.VOID;
//    }

}