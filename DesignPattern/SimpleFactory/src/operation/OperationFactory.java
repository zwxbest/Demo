package operation;

import operation.binary.OperationAdd;
import operation.binary.OperationDiv;
import operation.binary.OperationMul;
import operation.binary.OperationSub;
import operation.unary.OperationReverse;
import operation.unary.OperationSqr;
import operation.unary.OperationSqrt;

/**
 运算类工厂

 */
public class OperationFactory
{
    public static Operation createOperate(String operate)
    {
        Operation oper = null;
//C# TO JAVA CONVERTER NOTE: The following 'switch' operated on a string member and was converted to Java 'if-else' logic:
//	switch (operate)
//ORIGINAL LINE: case "+":
        if (operate.equals("+"))
        {
            oper = new OperationAdd();
        }
//ORIGINAL LINE: case "-":
        else if (operate.equals("-"))
        {
            oper = new OperationSub();
        }
//ORIGINAL LINE: case "*":
        else if (operate.equals("*"))
        {
            oper = new OperationMul();
        }
//ORIGINAL LINE: case "/":
        else if (operate.equals("/"))
        {
            oper = new OperationDiv();
        }
//ORIGINAL LINE: case "sqr":
        else if (operate.equals("sqr"))
        {
            oper = new OperationSqr();
        }
//ORIGINAL LINE: case "sqrt":
        else if (operate.equals("sqrt"))
        {
            oper = new OperationSqrt();
        }
//ORIGINAL LINE: case "+/-":
        else if (operate.equals("+/-"))
        {
            oper = new OperationReverse();
        }

        return oper;
    }
}