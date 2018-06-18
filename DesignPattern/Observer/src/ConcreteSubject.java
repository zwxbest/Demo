//具体通知者
public class ConcreteSubject extends Subject
{
	private String subjectState;

	//具体通知者状态
	public final String getSubjectState()
	{
		return subjectState;
	}
	public final void setSubjectState(String value)
	{
		subjectState = value;
	}
}