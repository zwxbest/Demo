//外籍中锋
public class ForeignCenter
{
	private String name;
	public final String getName()
	{
		return name;
	}
	public final void setName(String value)
	{
		name = value;
	}

	public final void 进攻()
	{
		System.out.println("外籍中锋 {0} 进攻"+name);
	}

	public final void 防守()
	{
		System.out.println("外籍中锋 {0} 防守"+ name);
	}
}