public class ConcreteObserver extends Observer
{
	private String name;
	private String observerState;
	private ConcreteSubject subject;

	public ConcreteObserver(ConcreteSubject subject, String name)
	{
		this.subject = subject;
		this.name = name;
	}
	//更新
	@Override
	public void Update()
	{
		observerState = subject.getSubjectState();
		System.out.println("观察者{0}的新状态是{1}"+ name+observerState);
	}

	public final ConcreteSubject getSubject()
	{
		return subject;
	}
	public final void setSubject(ConcreteSubject value)
	{
		subject = value;
	}
}