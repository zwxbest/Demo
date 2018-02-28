package operation;

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