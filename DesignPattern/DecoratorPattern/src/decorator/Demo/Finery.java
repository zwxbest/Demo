package decorator.Demo;

public class Finery extends Person
{
	protected Finery component;

	//打扮
	public final void Decorate(Finery component)
	{
		this.component = component;
	}

	@Override
	public void Show()
	{
		if (component != null)
		{
			component.Show();
		}
	}
}