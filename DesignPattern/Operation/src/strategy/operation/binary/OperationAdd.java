package strategy.operation.binary;

/**
 加法类

 */
public class OperationAdd extends OperationBinary {
    @Override
    public double GetResult()
    {
        double result = 0;
        result = getNumberA()+ getNumberB();
        return result;
    }
}
