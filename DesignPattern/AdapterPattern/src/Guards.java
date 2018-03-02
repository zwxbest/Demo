//后卫
public class Guards extends Player
{
	public Guards(String name)
	{
		super(name);
	}

	@Override
	public void Attack()
	{
		System.out.println("后卫 {0} 进攻"+name);
	}

	@Override
	public void Defense()
	{
		System.out.println("后卫 {0} 防守"+ name);
	}
}