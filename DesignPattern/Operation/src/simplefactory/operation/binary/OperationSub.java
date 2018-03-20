package simplefactory.operation.binary;

/**
 减法类

 */
public class OperationSub extends OperationBinary {
    @Override
    public double GetResult()
    {
        double result = 0;
        result = getNumberA() - getNumberB();
        return result;
    }
}
