public abstract class Handler
{
	protected Handler successor;

	public final void SetSuccessor(Handler successor)
	{
		this.successor = successor;
	}

	public abstract void HandleRequest(int request);
}