//工作
public class Work
{
	private State current;
	public Work()
	{
		current = new ForenoonState();
	}

	private double hour;
	public final double getHour()
	{
		return hour;
	}
	public final void setHour(double value)
	{
		hour = value;
	}

	private boolean finish = false;
	public final boolean getTaskFinished()
	{
		return finish;
	}
	public final void setTaskFinished(boolean value)
	{
		finish = value;
	}


	public final void SetState(State s)
	{
		current = s;
	}

	public final void WriteProgram()
	{
		current.WriteProgram(this);
	}
}