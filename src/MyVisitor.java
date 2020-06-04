import java.util.HashMap;
import java.util.Stack;
import java.lang.Override;


public class MyVisitor extends isprBaseVisitor<Object> {
    HashMap<String, isprParser.BlockContext> function = new HashMap<>();
    Stack<HashMap<String, Object>> currentStack;
    HashMap<String, Object> currentTable;
    String procedure = "";
    boolean global = false;

    private Object getVariable(String ident) throws Exception {
        if (currentTable.containsKey(ident))
            return currentTable.get(ident);
        for (HashMap<String, Object> hm : currentStack) {
            if (hm.containsKey(ident)) {
                return hm.get(ident);
            }
        }

        throw new Exception("No such variable in the table");
    }

    @Override
    public Object visitBreakstmt(isprParser.BreakstmtContext ctx) {
        System.out.println("BREAK");
        LLVM.Break();
        return null;
    }

    @Override
    public Object visitContinuestmt(isprParser.ContinuestmtContext ctx) {
        LLVM.Continue();
        return null;
    }

    @Override
    public Object visitProcedure(isprParser.ProcedureContext ctx) {
        String ident = ctx.ident().getText();
        function.put(ident, ctx.block());
        return null;
    }

    private void callProcedure(String ident) throws Exception{
        if (function.containsKey(ident)) {
            visit(function.get(ident));
        }
        else throw new Exception("PROCEDURE" + ident + " IS NOT IDENTIFIED");
    }

    @Override
    public Object visitCallstmt(isprParser.CallstmtContext ctx) {
        try {
            callProcedure(ctx.ident().getText());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String visitProgram (isprParser.ProgramContext ctx)
    {
        visitChildren(ctx);
        LLVM.generate();
        return null;
    }

    @Override
    public String visitBlock (isprParser.BlockContext ctx){
        HashMap<String, Object> currentBlocktable = new HashMap<>();
        String id = ctx.statement().getText();
        currentTable = currentBlocktable;
        LLVM.function_start(id);
        visitChildren(ctx);
        LLVM.function_end();

        return null;
    }

    @Override
    public String visitStatement (isprParser.StatementContext ctx){

        return (String) visitChildren(ctx);
    }


    @Override
    public String  visitAssignstmt(isprParser.AssignstmtContext ctx) {
        try {
            String varName = ctx.ident().getText();
            Object value = visit(ctx.expression());
            Object left = visit(ctx.expression());
            Object right = visit(ctx.expression());

            if (ctx.children.contains(ctx.expression())) value = visit(ctx.expression());
            currentTable.put(varName, value);
            currentTable.put(varName, value);
            String sub=".";

            if (left.toString().contains(sub) || right.toString().contains(sub)) {
                if (value == null)
                    value = 0;
                LLVM.assign_double(varName,  global,value);
            } else {
                if (value == null)
                    value = 0;
                LLVM.assign_i32(varName, global,value);
            }

        } catch (Exception e) {
            System.out.println("!!!Error!!!");
            System.out.println(e.fillInStackTrace());
        }
        return null;
    }



    @Override
    public String visitFactor (isprParser.FactorContext ctx){
        if (ctx.ident()!= null) return (String) visitChildren(ctx);;
        return ctx.getText();
    }

   @Override
   public Object visitVars (isprParser.VarsContext ctx){
       String varName = ctx.ident().getText();
       String type = ctx.type().getText();
       Object value = visit(ctx.expression());
       currentTable.put(varName, value);
       if (type.equals ("int")) {
           if (value == null)
               value = 0;
           LLVM.declare_i32(varName, global, value);
       } else {
           if (type.equals ("float"))
           {
               if (value == null)
                   value = 0;
               LLVM.declare_double(varName, global, value);
           }

       }
       return null;
   }
    @Override
    public String visitSummExpr(isprParser.SummExprContext ctx) {
        Object left = visit(ctx.expression(0));
        Object right = visit(ctx.expression(1));
        String sub = ".";
        boolean flag;

        if (left.toString().indexOf(sub) != -1 || right.toString().indexOf(sub) != -1) flag = true;
        else flag = false;
        switch (ctx.op.getText()) {

            case "+":
                if (flag == true) return String.valueOf(Float.parseFloat(left.toString())+Float.parseFloat(right.toString()));
                else return String.valueOf(Integer.parseInt(left.toString())+Integer.parseInt(right.toString()));

            case "-":
                if (flag == true) return String.valueOf(Float.parseFloat(left.toString())-Float.parseFloat(right.toString()));
                else return String.valueOf(Integer.parseInt(left.toString())-Integer.parseInt(right.toString()));
        }
        return null;
    }

    @Override
    public String visitMultExpr(isprParser.MultExprContext ctx) {
        Object left = visit(ctx.expression(0));
        Object right = visit(ctx.expression(1));
        String sub = ".";
        boolean flag;

        if (left.toString().indexOf(sub) != -1 || right.toString().indexOf(sub)!=-1) flag = true;
        else flag = false;
        switch (ctx.op.getText()) {

            case "*":
                if(flag==true) return String.valueOf(Float.parseFloat(left.toString()) * Float.parseFloat(right.toString()));
                else return String.valueOf(Integer.parseInt(left.toString()) * Integer.parseInt(right.toString()));

            case "/":
                if (flag == true) return String.valueOf(Float.parseFloat(left.toString()) / Float.parseFloat(right.toString()));
                else return String.valueOf(Integer.parseInt(left.toString()) / Integer.parseInt(right.toString()));
        }
        return null;
    }

    @Override
    public String visitWritestmt(isprParser.WritestmtContext ctx) {
        String toPrint = (String) visit(ctx.expressionunion());
        System.out.println("WRITE: " + toPrint);
        Object left = visit(ctx.expressionunion());
        String sub = ".";
        boolean flag = false;
        boolean type;
        if (left.toString().contains(sub)) type = true;
        else type = false;
        if (left.toString().contains("'")) flag = true;

        if (flag == true) {
            LLVM.printf_string(toPrint, toPrint.length(), global, procedure);
            LLVM.print(toPrint);
            if (type == true) {
                LLVM.printf_double(toPrint, global);
                LLVM.print(toPrint);
            } else {
                LLVM.printf_i32(toPrint, global);
                LLVM.print(toPrint);
            }
        }
        return null;
    }

    @Override
    public String visitExpressionunion(isprParser.ExpressionunionContext ctx) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < ctx.expression().size(); i ++) {
            result.append(visit(ctx.expression(i)));
            result.append(" ");
        }
        return result.toString();
    }

   @Override
    public Object visitIdent (isprParser.IdentContext ctx) {
        try {
            System.out.println("RECEIVE VARS: " + ctx.getText() + " := " + getVariable(ctx.getText()));
            return getVariable(ctx.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String visitIfstmt(isprParser.IfstmtContext ctx) {
        System.out.println("IF: ");
        Object conditionResult = visit(ctx.conditionunion());
        LLVM.if_start((String)conditionResult);
        if (conditionResult.equals("true")) {
            for (int i = 0; i < ctx.statement().size(); i++)
                visit(ctx.statement(i));
        }
        return null;
    }

    @Override
    public String visitWhilestmt(isprParser.WhilestmtContext ctx) {

        System.out.println("WHILE: ");
        LLVM.while_start();
        Object conditionResult = visit(ctx.conditionunion());
        LLVM.while_condition((String)conditionResult);
        while (conditionResult.equals("true")) {
            for (int i = 0; i < ctx.statement().size(); i++)
                visit(ctx.statement(i));
            conditionResult = visit(ctx.conditionunion());
        }
        LLVM.while_end();
        return null;
    }

    @Override
    public String visitConditionunion(isprParser.ConditionunionContext ctx) {
        for (int i = 0; i < ctx.condition().size(); i++) {
            Object result = visitChildren(ctx);
            if (result == null) {
                System.err.println("NULL exception");
                System.exit(1);
            }
            if (result.equals("false")) return "false";
        }
        return "true";
    }

    @Override
    public String visitComparison(isprParser.ComparisonContext ctx) {
        Object left = visit(ctx.expression(0));
        Object right = visit(ctx.expression(1));
        String sub = ".";
        boolean flag;

        if (left.toString().indexOf(sub) != -1 || right.toString().indexOf(sub) != -1)
            flag = true;
        else {
            flag = false;
        }

        switch (ctx.op.getText()) {
            case "=":
                if (flag == true) {
                    if (Float.parseFloat(left.toString()) == Float.parseFloat(right.toString()))
                        return "true";
                    else return "false";
                } else {
                    if (Integer.parseInt(left.toString()) == Integer.parseInt(right.toString()))
                        return "true";
                    else return "false";
                }

            case "!=":
                if (flag == true) {
                    if (Float.parseFloat(left.toString()) != Float.parseFloat(right.toString()))
                        return "true";
                    else return "false";
                } else {
                    if (Integer.parseInt(left.toString()) != Integer.parseInt(right.toString()))
                        return "true";
                    else return "false";
                }

            case "<":
                if (flag == true) {
                    if (Float.parseFloat(left.toString()) < Float.parseFloat(right.toString()))
                        return "true";
                    else return "false";
                } else {
                    if (Integer.parseInt(left.toString()) < Integer.parseInt(right.toString()))
                        return "true";
                    else return "false";
                }

            case "<=":
                if (flag == true) {
                    if (Float.parseFloat(left.toString()) <= Float.parseFloat(right.toString()))
                        return "true";
                    else return "false";
                } else {
                    if (Integer.parseInt(left.toString()) <= Integer.parseInt(right.toString()))
                        return "true";
                    else return "false";
                }

            case ">":
                if (flag == true) {
                    if (Float.parseFloat(left.toString()) > Float.parseFloat(right.toString()))
                        return "true";
                    else return "false";
                } else {
                    if (Integer.parseInt(left.toString()) > Integer.parseInt(right.toString()))
                        return "true";
                    else return "false";
                }

            case ">=":
                if (flag == true) {
                    if (Float.parseFloat(left.toString()) >= Float.parseFloat(right.toString()))
                        return "true";
                    else return "false";
                } else {
                    if (Integer.parseInt(left.toString()) >= Integer.parseInt(right.toString()))
                        return "true";
                    else return "false";
                }
        }
        return null;
    }
}