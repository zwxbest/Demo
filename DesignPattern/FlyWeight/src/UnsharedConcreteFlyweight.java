public class UnsharedConcreteFlyweight extends Flyweight
{
	@Override
	public void Operation(int extrinsicstate)
	{
		System.out.println("不共享的具体Flyweight:" + extrinsicstate);
	}
}