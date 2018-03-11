//下午工作状态
public class AfternoonState extends State
{
	@Override
	public void WriteProgram(Work w)
	{
		if (w.getHour() < 17)
		{
			System.out.println(String.format("当前时间：%s点 下午状态还不错，继续努力", w.getHour()));
		}
		else
		{
			w.SetState(new EveningState());
			w.WriteProgram();
		}
	}
}