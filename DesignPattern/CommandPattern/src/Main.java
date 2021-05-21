public class Main
{
	private static void main(String[] args)
	{
		//开店前的准备
		Barbecuer boy = new Barbecuer();
		Command bakeMuttonCommand1 = new BakeMuttonCommand(boy);
		Command bakeMuttonCommand2 = new BakeMuttonCommand(boy);
		Command bakeChickenWingCommand1 = new BakeChickenWingCommand(boy);
		Waiter girl = new Waiter();

		//开门营业 顾客点菜
		girl.SetOrder(bakeMuttonCommand1);
		girl.SetOrder(bakeMuttonCommand2);
		girl.SetOrder(bakeChickenWingCommand1);

		//点菜完闭，通知厨房
		girl.Notify();


	}
}