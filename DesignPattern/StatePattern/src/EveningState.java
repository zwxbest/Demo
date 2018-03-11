//晚间工作状态
public class EveningState extends State
{
	@Override
	public void WriteProgram(Work w)
	{
		if (w.getTaskFinished())
		{
			w.SetState(new RestState());
			w.WriteProgram();
		}
		else
		{
			if (w.getHour() < 21)
			{
				System.out.println(String.format("当前时间：%s点 加班哦，疲累之极", w.getHour()));
			}
			else
			{
				w.SetState(new SleepingState());
				w.WriteProgram();
			}
		}
	}
}