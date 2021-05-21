public class ConcreteColleague1 extends Colleague
{
	public ConcreteColleague1(Mediator mediator)
	{
		super(mediator);

	}

	public final void Send(String message)
	{
		mediator.Send(message, this);
	}

	public final void Notify(String message)
	{
		System.out.println("同事1得到信息:" + message);
	}
}