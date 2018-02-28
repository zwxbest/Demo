package operation;

/**
 平方类

 */
public class OperationSqr extends Operation
{
    @Override
    public double GetResult()
    {
        double result = 0;
        result = getNumberB() * getNumberB();
        return result;
    }
}
