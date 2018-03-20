//简历
public class Resume implements Cloneable
{
	private String name;
	private String sex;
	private String age;

	private WorkExperience work;

	public Resume(String name)
	{
		this.name = name;
		work = new WorkExperience();
	}

	private Resume(WorkExperience work)
	{
		this.work = (WorkExperience)work.clone();
	}

	//设置个人信息
	public final void SetPersonalInfo(String sex, String age)
	{
		this.sex = sex;
		this.age = age;
	}
	//设置工作经历
	public final void SetWorkExperience(String workDate, String company)
	{
		work.setWorkDate(workDate);
		work.setCompany(company);
	}

	//显示
	public final void Display()
	{
		System.out.println(String.format("{0} {1} {2}",name, sex, age));
		System.out.println(String.format("工作经历：{0} {1}", work.getWorkDate(), work.getCompany()));
	}

	public final Object clone()
	{
		Resume obj = new Resume(this.work);

		obj.name = this.name;
		obj.sex = this.sex;
		obj.age = this.age;
		return obj;
	}

}