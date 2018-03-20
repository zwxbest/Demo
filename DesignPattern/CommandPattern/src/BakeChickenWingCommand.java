//烤鸡翅命令
public class BakeChickenWingCommand extends Command
{
	public BakeChickenWingCommand(Barbecuer receiver)
	{
		super(receiver);
	}

	@Override
	public void ExcuteCommand()
	{
		receiver.BakeChickenWing();
	}
}