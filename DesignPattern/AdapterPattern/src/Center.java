//中锋
public class Center extends Player
{
	public Center(String name)
	{
		super(name);
	}

	@Override
	public void Attack()
	{
		System.out.println("中锋 {0} 进攻"+name);
	}

	@Override
	public void Defense()
	{
		System.out.println("中锋 {0} 防守"+ name);
	}
}