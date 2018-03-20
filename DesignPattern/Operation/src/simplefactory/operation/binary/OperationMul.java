package simplefactory.operation.binary;

/**
 乘法类

 */
public class OperationMul extends OperationBinary {
    @Override
    public double GetResult()
    {
        double result = 0;
        result = getNumberA() * getNumberB();
        return result;
    }
}
