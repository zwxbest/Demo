package parallel.simpleProducerAndConsumer;

public final class PCData {
    private final  int intData;
    public PCData(int d)
    {
        intData=d;
    }
    public PCData(String d)
    {
        intData=Integer.valueOf(d);
    }
    public int getIntData()
    {
        return intData;
    }
    @Override
    public String toString() {
        return "data:"+intData;
    }
}
