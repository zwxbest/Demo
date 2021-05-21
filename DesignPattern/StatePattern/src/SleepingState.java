//睡眠状态
public class SleepingState extends State
{
	@Override
	public void WriteProgram(Work w)
	{
		System.out.println(String.format("当前时间：%s点 不行了，睡着了。", w.getHour()));
	}
}