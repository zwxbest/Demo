public class AccessDepartment implements IDepartment
{
	public final void Insert(Department department)
	{
		System.out.println("在Access中给Department表增加一条记录");
	}

	public final Department GetDepartment(int id)
	{
		System.out.println("在Access中根据ID得到Department表一条记录");
		return null;
	}
}