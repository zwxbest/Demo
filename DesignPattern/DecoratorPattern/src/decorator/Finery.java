package decorator;

public class Finery extends Person
{
	protected Person component;

	//打扮
	public final void Decorate(Person component)
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