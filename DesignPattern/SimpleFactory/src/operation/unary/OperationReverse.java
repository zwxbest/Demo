package operation.unary;

import operation.binary.OperationBinary;
import operation.unary.OperationUnary;

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
