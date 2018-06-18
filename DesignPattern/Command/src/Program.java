public class Program
{
	private static void main(String[] args)
	{
		Receiver r = new Receiver();
		Command c = new ConcreteCommand(r);
		Invoker i = new Invoker();

		// Set and execute command 
		i.SetCommand(c);
		i.ExecuteCommand();


	}
}