public abstract class Subject
{
	private java.util.List<Observer> observers = new java.util.ArrayList<Observer>();

	//增加观察者
	public final void Attach(Observer observer)
	{
		observers.add(observer);
	}
	//移除观察者
	public final void Detach(Observer observer)
	{
		observers.remove(observer);
	}
	//通知
	public final void Notify()
	{
		for (Observer o : observers)
		{
			o.Update();
		}
	}
}