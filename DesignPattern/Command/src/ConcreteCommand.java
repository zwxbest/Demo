﻿public class ConcreteCommand extends Command
{
	public ConcreteCommand(Receiver receiver)
	{
		super(receiver);
	}

	@Override
	public void Execute()
	{
		receiver.Action();
	}
}