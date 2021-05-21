public class SqlserverUser implements IUser
{
	public final void Insert(User user)
	{
		System.out.println("在Sqlserver中给User表增加一条记录");
	}

	public final User GetUser(int id)
	{
		System.out.println("在Sqlserver中根据ID得到User表一条记录");
		return null;
	}
}