package strategy.operation.unary;

/**
 平方根类

 */
public class OperationSqrt extends OperationUnary {
    @Override
    public double GetResult()
    {
        double result = 0;
        if (getNumber() < 0)
        {
            throw new RuntimeException("负数不能开平方根。");
        }
        result = Math.sqrt(getNumber());
        return result;
    }
}
