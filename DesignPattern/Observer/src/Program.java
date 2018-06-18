public class Program
{
	public static void main(String[] args)
	{
		ConcreteSubject s = new ConcreteSubject();

		s.Attach(new ConcreteObserver(s, "X"));
		s.Attach(new ConcreteObserver(s, "Y"));
		s.Attach(new ConcreteObserver(s, "Z"));

		s.setSubjectState("ABC");
		s.Notify();

	}
}