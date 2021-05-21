//工作经历
public class WorkExperience implements Cloneable
{
	private String workDate;
	public final String getWorkDate()
	{
		return workDate;
	}
	public final void setWorkDate(String value)
	{
		workDate = value;
	}
	private String company;
	public final String getCompany()
	{
		return company;
	}
	public final void setCompany(String value)
	{
		company = value;
	}

	public final Object clone()
	{
		return null;
	}
}