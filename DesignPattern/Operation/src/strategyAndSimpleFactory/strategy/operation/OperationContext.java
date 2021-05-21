package strategyAndSimpleFactory.strategy.operation;

import strategyAndSimpleFactory.strategy.operation.binary.OperationAdd;
import strategyAndSimpleFactory.strategy.operation.binary.OperationDiv;
import strategyAndSimpleFactory.strategy.operation.binary.OperationMul;
import strategyAndSimpleFactory.strategy.operation.binary.OperationSub;

/**
 运算类工厂
 */
public class OperationContext
{
    private Operation operation;

    public OperationContext(String operationStr)
    {
        switch (operationStr)
        {
            case "+":
                setOperation(new OperationAdd());break;
            case "-":
                setOperation(new OperationSub());break;
            case "*":
                setOperation(new OperationMul());break;
            default:
                setOperation(new OperationDiv());break;
        }
    }

   public double GetResult()
    {
        return getOperation().GetResult();
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}