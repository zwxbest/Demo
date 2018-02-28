package Strategy;

public class CashContext
{
	private CashSuper cs;

	public final void setBehavior(CashSuper csuper)
	{
		this.cs = csuper;
	}

	public final double GetResult(double money)
	{
		return cs.acceptCash(money);
	}
}