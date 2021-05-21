public class ObjectStructure
{
	private java.util.List<Element> elements = new java.util.ArrayList<Element>();

	public final void Attach(Element element)
	{
		elements.add(element);
	}

	public final void Detach(Element element)
	{
		elements.remove(element);
	}

	public final void Accept(Visitor visitor)
	{
		for (Element e : elements)
		{
			e.Accept(visitor);
		}
	}
}