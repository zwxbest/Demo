public class ConcreteElementA extends Element
{
	@Override
	public void Accept(Visitor visitor)
	{
		visitor.VisitConcreteElementA(this);
	}

	public final void OperationA()
	{
	}
}