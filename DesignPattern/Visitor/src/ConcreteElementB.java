public class ConcreteElementB extends Element
{
	@Override
	public void Accept(Visitor visitor)
	{
		visitor.VisitConcreteElementB(this);
	}

	public final void OperationB()
	{
	}
}