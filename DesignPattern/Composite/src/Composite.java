public class Composite extends Component
{
	private java.util.ArrayList<Component> children = new java.util.ArrayList<Component>();

	public Composite(String name)
	{
		super(name);
	}

	@Override
	public void Add(Component c)
	{
		children.add(c);
	}

	@Override
	public void Remove(Component c)
	{
		children.remove(c);
	}

	@Override
	public void Display(int depth)
	{
		System.out.println(new String(depth+"-") + name);

		for (Component component : children)
		{
			component.Display(depth + 2);
		}
	}
}