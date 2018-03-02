//前锋
public class Forwards extends Player
{
	public Forwards(String name)
	{
		super(name);
	}

	@Override
	public void Attack()
	{
		System.out.println("前锋 {0} 进攻"+name);
	}

	@Override
	public void Defense()
	{
		System.out.println("前锋 {0} 防守"+name);
	}
}