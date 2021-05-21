public class Proxy implements GiveGift //他俩都在做一件事,所以都实现接口
{
	private Pursuit gg;
	public Proxy(SchoolGirl mm)
	{
		gg = new Pursuit(mm);
	}


	public final void GiveDolls()
	{
		gg.GiveDolls();
	}

	public final void GiveFlowers()
	{
		gg.GiveFlowers();
	}

	public final void GiveChocolate()
	{
		gg.GiveChocolate();
	}
}