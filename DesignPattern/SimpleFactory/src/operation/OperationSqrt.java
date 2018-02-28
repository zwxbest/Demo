package operation;

/**
 平方根类

 */
public class OperationSqrt extends Operation
{
    @Override
    public double GetResult()
    {
        double result = 0;
        if (getNumberB() < 0)
        {
            throw new RuntimeException("负数不能开平方根。");
        }
        result = Math.sqrt(getNumberB());
        return result;
    }
}
