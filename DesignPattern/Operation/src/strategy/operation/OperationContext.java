package strategy.operation;

import strategy.operation.binary.OperationAdd;
import strategy.operation.binary.OperationDiv;
import strategy.operation.binary.OperationMul;
import strategy.operation.binary.OperationSub;

import java.util.Optional;

/**
 运算类工厂
 */
public class OperationContext
{
    private Operation operation;

    public OperationContext(Operation operation)
    {
        this.operation= operation;
    }

   public double GetResult()
    {
        return operation.GetResult();
    }

}