public class FlyweightFactory
{
	private java.util.Hashtable flyweights = new java.util.Hashtable();

	public FlyweightFactory()
	{
		flyweights.put("X", new ConcreteFlyweight());
		flyweights.put("Y", new ConcreteFlyweight());
		flyweights.put("Z", new ConcreteFlyweight());

	}

	public final Flyweight GetFlyweight(String key)
	{
		return ((Flyweight)flyweights.get(key));
	}
}