//服务员
public class Waiter
{
	private java.util.List<Command> orders = new java.util.ArrayList<Command>();

	//设置订单
	public final void SetOrder(Command command)
	{
		if (command.toString().equals("命令模式.BakeChickenWingCommand"))
		{
			System.out.println("服务员：鸡翅没有了，请点别的烧烤。");
		}
		else
		{
			orders.add(command);
			System.out.println("增加订单：" + command.toString() + "  时间：" + new java.util.Date().toString());
		}
	}

	//取消订单
	public final void CancelOrder(Command command)
	{
		orders.remove(command);
		System.out.println("取消订单：" + command.toString() + "  时间：" + new java.util.Date().toString());
	}

	//通知全部执行
	public final void Notify()
	{
		for (Command cmd : orders)
		{
			cmd.ExcuteCommand();
		}
	}
}