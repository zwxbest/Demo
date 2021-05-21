public class ConcreteMediator extends Mediator
{
	private ConcreteColleague1 colleague1;
	private ConcreteColleague2 colleague2;

	public final void setColleague1(ConcreteColleague1 value)
	{
		colleague1 = value;
	}

	public final void setColleague2(ConcreteColleague2 value)
	{
		colleague2 = value;
	}

	@Override
	public void Send(String message, Colleague colleague)
	{
		if (colleague == colleague1)
		{
			colleague2.Notify(message);
		}
		else
		{
			colleague1.Notify(message);
		}
	}
}