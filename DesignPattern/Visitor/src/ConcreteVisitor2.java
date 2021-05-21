public class ConcreteVisitor2 extends Visitor
{
	@Override
	public void VisitConcreteElementA(ConcreteElementA concreteElementA)
	{
		System.out.println("{0}被{1}访问", concreteElementA.getClass().getName(), this.getClass().getName());
	}

	@Override
	public void VisitConcreteElementB(ConcreteElementB concreteElementB)
	{
		System.out.println("{0}被{1}访问", concreteElementB.getClass().getName(), this.getClass().getName());
	}
}