public class ConcreteHandler2 extends Handler
{
	@Override
	public void HandleRequest(int request)
	{
		if (request >= 10 && request < 20)
		{
			System.out.println(String.format("{0}  处理请求  {1}", this.getClass().getName(), request) );
		}
		else if (successor != null)
		{
			successor.HandleRequest(request);
		}
	}
}