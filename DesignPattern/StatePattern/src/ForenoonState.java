//上午工作状态
public class ForenoonState extends State
{
	@Override
	public void WriteProgram(Work w)
	{
		if (w.getHour() < 12)
		{
			System.out.println(String.format("当前时间：%s点 上午工作，精神百倍", w.getHour()));
		}
		else
		{
			w.SetState(new NoonState());
			w.WriteProgram();
		}
	}
}