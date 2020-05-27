import java.util.HashMap;
import java.util.Stack;
import java.lang.Override;


public class MyVisitor extends isprBaseVisitor<Object> {
    HashMap<String, Object> consts = new HashMap<>();
    HashMap<String, isprParser.BlockContext> function = new HashMap<>();
    Stack<HashMap<String, Object>> tables = new Stack<>();
    Stack<HashMap<String, Object>> currentStack;
    HashMap<String, Object> currentTable;

    private Object getVariable(String ident) throws Exception {
        if (currentTable.containsKey(ident))
            return currentTable.get(ident);
        for (HashMap<String, Object> hm : currentStack) {
            if (hm.containsKey(ident)) {
                return hm.get(ident);
            }
        }
        if (consts.containsKey(ident)) {
            return consts.get(ident);
        }

        throw new Exception("No such variable in the table");
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
        else throw new Exception("Procedure" + ident + " is not identified");
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
    public String  visitConsts(isprParser.ConstsContext ctx) {
        currentTable = consts;
        visitChildren(ctx);
        return null;
    }

    @Override
    public String visitProgram (isprParser.ProgramContext ctx)
    {
        visitChildren(ctx);
        return null;
    }

    @Override
    public String visitBlock (isprParser.BlockContext ctx){
        HashMap<String, Object> currentBlocktable = new HashMap<>();
        currentTable = currentBlocktable;
        visitChildren(ctx);
        //tables.add(currentBlocktable);

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
            Object exp = visit(ctx.expression());

            currentTable.put(varName, exp);
            System.out.println("Assigment " + varName + ": " + exp);
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

   /* @Override
    public Object visitVars(isprParser.VarsContext ctx) {
        visitChildren(ctx);
        return null;
    }*/
   @Override
   public Object visitVars (isprParser.VarsContext ctx){
       String varName = ctx.ident().getText();
       String type = ctx.type().getText();
       Object value = visit(ctx.expression());
       if (ctx.children.contains(ctx.expression()))
           value = visit(ctx.expression());
       currentTable.put(varName, value);
       if (value != null)
           System.out.println("Vars: " + type + " " + varName + " " + value.toString());
       else
           System.out.println("VarDeclaration (no value): " + type + " " + varName + " as NULL");

       currentTable.put(varName, value);

       return null;
   }
    @Override
    public String visitMultExpr(isprParser.MultExprContext ctx) {
        Object left = visit(ctx.expression(0));
        String sub = ".";
        Object right;
        float delf = 0;
        float multf = 0;
        int deli = 0;
        int multi = 0;
        boolean flag = false;
        if (ctx.expression(1) != null) {
            right = visit(ctx.expression(1));
        } else {
            right = new String("0");
        }
        String sl = left.toString();
        String sr = right.toString();

        if (sl.indexOf(sub) != -1 || sr.indexOf(sub)!=-1)
        {
            flag = true;
            float leftfloat = Float.parseFloat(left.toString());
            float  rightfloat = Float.parseFloat(right.toString());
            delf = leftfloat / rightfloat;
            multf = leftfloat * rightfloat;
        }
        else {

            flag = false;
            int lefti = Integer.parseInt(left.toString());
            int righti = Integer.parseInt(right.toString());
            deli = lefti / righti;
            multi = lefti * righti;
        }

        switch (ctx.op.getText()) {
            case "*":
                if(flag == true)
                    return String.valueOf(multf);
                else
                    return String.valueOf(multi);
            case "/": {
                if(flag == true)
                    return String.valueOf(delf);
                else
                    return String.valueOf(deli);
            }
        }
        return null;
    }

    @Override
    public String visitSummExpr(isprParser.SummExprContext ctx) {
        Object left = visit(ctx.expression(0));
        String sub = ".";
        Object right;
        float summf = 0;
        float differf = 0;
        int summi = 0;
        int differi = 0;
        boolean flag = false;
        if (ctx.expression(1) != null) {
            right = visit(ctx.expression(1));
        } else {
            right = new String("0");
        }
        String sl = left.toString();
        String sr = right.toString();
        if (sl.indexOf(sub) != -1 || sr.indexOf(sub) != -1) {
            flag = true;
            float leftf = Float.parseFloat(left.toString());
            float rightf = Float.parseFloat(right.toString());
            summf = leftf + rightf;
            differf = leftf - rightf;
        } else {
            flag = false;
            int lefti = Integer.parseInt(left.toString());
            int righti = Integer.parseInt(right.toString());
            summi = lefti + righti;
            differi = lefti - righti;
        }

        switch (ctx.op.getText()) {
            case "+":
                if (flag == true)
                    return String.valueOf(summf);
                else
                    return String.valueOf(summi);
            case "-": {
                if (flag == true)
                    return String.valueOf(differf);
                else
                    return String.valueOf(differi);
            }
        }
        return null;
    }

    @Override
    public String visitWritestmt(isprParser.WritestmtContext ctx) {
        String toPrint = (String) visit(ctx.expressionunion());
      //  toPrint +=(String)visit(ctx.ident());

        System.out.println("write( " + toPrint + ")");
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
            System.out.println("GetVariable:" + ctx.getText() + " is: " + getVariable(ctx.getText()));
            return getVariable(ctx.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
 @Override
    public String visitLiteral (isprParser.LiteralContext ctx){
        if (ctx.charLiteral()!= null) return ctx.charLiteral().STRING().getText();
        return ctx.getText();
    }

 @Override
    public Object visitFloatLiteral (isprParser.FloatLiteralContext ctx){
        System.out.println("Float: " + ctx.getText());
        return Float.parseFloat(ctx.getText());
    }

    @Override
    public Object visitIntegerLiteral (isprParser.IntegerLiteralContext ctx){
        System.out.println("Integer: " + ctx.getText());
        return Integer.parseInt(ctx.getText());
    }






}