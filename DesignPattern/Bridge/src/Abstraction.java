public class Abstraction
{
	protected Implementor implementor;

	public final void SetImplementor(Implementor implementor)
	{
		this.implementor = implementor;
	}

	public void Operation()
	{
		implementor.Operation();
	}

}