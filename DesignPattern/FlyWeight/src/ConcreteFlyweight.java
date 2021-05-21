public class ConcreteFlyweight extends Flyweight
{
	@Override
	public void Operation(int extrinsicstate)
	{
		System.out.println("具体Flyweight:" + extrinsicstate);
	}
}