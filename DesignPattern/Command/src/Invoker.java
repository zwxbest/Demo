public class Invoker
{
	private Command command;

	public final void SetCommand(Command command)
	{
		this.command = command;
	}

	public final void ExecuteCommand()
	{
		command.Execute();
	}
}