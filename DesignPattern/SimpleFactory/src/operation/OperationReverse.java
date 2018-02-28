package operation;

/**
 相反数类

 */
public class OperationReverse extends Operation
{
    @Override
    public double GetResult()
    {
        double result = 0;
        result = -getNumberB();
        return result;
    }
}
