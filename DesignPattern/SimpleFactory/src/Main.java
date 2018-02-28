import operation.Operation;
import operation.OperationFactory;

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

            Operation oper;
            oper = OperationFactory.createOperate(strOperate);
            oper.setNumberA(Double.parseDouble(strNumberA));
            oper.setNumberB(Double.parseDouble(strNumberB));
            strResult = oper.GetResult();

            System.out.println("结果是：" + strResult);
            in.readLine();

        } catch (RuntimeException ex) {
            System.out.println("您的输入有错：" + ex.getMessage());
        }
    }
}
