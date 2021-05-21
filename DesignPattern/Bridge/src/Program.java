public class Program
{
	private static void main(String[] args)
	{
		Abstraction ab = new RefinedAbstraction();

		ab.SetImplementor(new ConcreteImplementorA());
		ab.Operation();

		ab.SetImplementor(new ConcreteImplementorB());
		ab.Operation();

	}
}