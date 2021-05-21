package decorator.Demo;

public class Sneakers extends Finery
{
	@Override
	public void Show()
	{
		System.out.print("破球鞋 ");
		super.Show();
	}
}