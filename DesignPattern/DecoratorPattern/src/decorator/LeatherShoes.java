package decorator;

public class LeatherShoes extends Finery
{
	@Override
	public void Show()
	{
		System.out.print("皮鞋 ");
		super.Show();
	}
}