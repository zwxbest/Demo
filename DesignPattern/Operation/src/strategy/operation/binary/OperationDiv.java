package strategy.operation.binary;

/**
 除法类

 */
public class OperationDiv extends OperationBinary {
    @Override
    public double GetResult()
    {
        double result = 0;
        if (getNumberB() == 0)
        {
            throw new RuntimeException("除数不能为0。");
        }
        result = getNumberA() / getNumberB();
        return result;
    }
}