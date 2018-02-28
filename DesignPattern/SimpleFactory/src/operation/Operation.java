package operation;

/**
 运算类

 */
public abstract class Operation
{
    private double _numberA = 0;
    private double _numberB = 0;

    /**
     数字A

     */
    public final double getNumberA()
    {
        return _numberA;
    }
    public final void setNumberA(double value)
    {
        _numberA = value;
    }

    /**
     数字B

     */
    public final double getNumberB()
    {
        return _numberB;
    }
    public final void setNumberB(double value)
    {
        _numberB = value;
    }

    /**
     得到运算结果

     @return
     */
    public abstract double GetResult();




}


