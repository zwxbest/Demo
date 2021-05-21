package operation;

/**
 专门负责生产"*"的工厂

 */
public class MulFactory implements IFactory
{
    public final Operation CreateOperation()
    {
        return new OperationMul();
    }
}
