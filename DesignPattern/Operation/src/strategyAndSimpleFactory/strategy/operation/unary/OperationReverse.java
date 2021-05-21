package strategyAndSimpleFactory.strategy.operation.unary;

/**
 相反数类

 */
public class OperationReverse extends OperationUnary {
    @Override
    public double GetResult()
    {
        double result = 0;
        result = -getNumber();
        return result;
    }
}
