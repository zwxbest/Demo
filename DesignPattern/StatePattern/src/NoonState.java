//中午工作状态
public class NoonState extends State
{
	@Override
	public void WriteProgram(Work w)
	{
		if (w.getHour() < 13)
		{
			System.out.println(String.format("当前时间：%s点 饿了，午饭；犯困，午休。", w.getHour()));
		}
		else
		{
			w.SetState(new AfternoonState());
			w.WriteProgram();
		}
	}
}