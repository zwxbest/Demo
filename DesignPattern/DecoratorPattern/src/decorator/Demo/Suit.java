package decorator.Demo;

public class Suit extends Finery
{
	@Override
	public void Show()
	{
		System.out.print("西装 ");
		super.Show();
	}
}