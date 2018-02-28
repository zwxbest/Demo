package operation;
/**
 运算类
 */
public abstract class Operation
{
    private double _numberA = 0;
    private double _numberB = 0;

    public final double getNumberA()
    {
        return _numberA;
    }
    public final void setNumberA(double value)
    {
        _numberA = value;
    }

    public final double getNumberB()
    {
        return _numberB;
    }
    public final void setNumberB(double value)
    {
        _numberB = value;
    }


    public abstract double GetResult();
}

