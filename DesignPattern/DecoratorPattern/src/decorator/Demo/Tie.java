package decorator.Demo;

public class Tie extends Finery
{
	@Override
	public void Show()
	{
		System.out.print("领带 ");
		super.Show();
	}
}