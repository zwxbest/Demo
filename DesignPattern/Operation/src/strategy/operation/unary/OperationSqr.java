package strategy.operation.unary;

/**
 平方类

 */
public class OperationSqr extends OperationUnary {
    @Override
    public double GetResult()
    {
        double result = 0;
        result = getNumber() * getNumber();
        return result;
    }
}
