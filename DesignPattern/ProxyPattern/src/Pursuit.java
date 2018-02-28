//他俩都在做一件事,所以都实现接口
public class Pursuit implements GiveGift
{
	private SchoolGirl mm;
	public Pursuit(SchoolGirl mm)
	{
		this.mm = mm;
	}
	public final void GiveDolls()
	{
		System.out.println(mm.getName() + " 送你洋娃娃");
	}

	public final void GiveFlowers()
	{
		System.out.println(mm.getName() + " 送你鲜花");
	}

	public final void GiveChocolate()
	{
		System.out.println(mm.getName() + " 送你巧克力");
	}
}