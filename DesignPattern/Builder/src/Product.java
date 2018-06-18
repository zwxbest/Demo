public class Product
{
	private java.util.List<String> parts = new java.util.ArrayList<String>();

	public final void Add(String part)
	{
		parts.add(part);
	}

	public final void Show()
	{
		System.out.println("\n产品 创建 ----");
		for (String part : parts)
		{
			System.out.println(part);
		}
	}
}