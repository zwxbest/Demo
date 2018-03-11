//下班休息状态
public class RestState extends State
{
	@Override
	public void WriteProgram(Work w)
	{
		System.out.println(String.format("当前时间：%s点 下班回家了", w.getHour()));
	}
}