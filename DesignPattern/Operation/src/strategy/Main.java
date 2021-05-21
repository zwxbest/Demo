package strategy;

import strategy.operation.Operation;
import strategy.operation.OperationContext;
import strategy.operation.binary.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        try {
            System.out.print("请输入数字A：");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String strNumberA = in.readLine();
            System.out.print("请选择运算符号(+、-、*、/)：");
            String strOperate = in.readLine();
            System.out.print("请输入数字B：");
            String strNumberB = in.readLine();
            double strResult;

            Operation operation=null;
            switch (strOperate)
            {
                case "+":operation=new OperationAdd();break;
                case "-":operation=new OperationSub();break;
                case "*":operation=new OperationMul();break;
                default:operation=new OperationDiv();break;
            }
            ((OperationBinary)operation).setNumberA(Double.parseDouble(strNumberA));
            ((OperationBinary)operation).setNumberB(Double.parseDouble(strNumberB));

            OperationContext context=new OperationContext(operation);
            strResult = context.GetResult();
            System.out.println("结果是：" + strResult);
        } catch (RuntimeException ex) {
            System.out.println("您的输入有错：" + ex.getMessage());
        }
    }
}
