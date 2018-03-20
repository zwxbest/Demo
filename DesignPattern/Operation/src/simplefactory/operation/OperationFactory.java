package simplefactory.operation;

import simplefactory.operation.binary.OperationAdd;
import simplefactory.operation.binary.OperationDiv;
import simplefactory.operation.binary.OperationMul;
import simplefactory.operation.binary.OperationSub;

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
        return oper;
    }
}