public class Program
{
	private static void main(String[] args)
	{
		Context context = new Context();
		java.util.List<AbstractExpression> list = new java.util.ArrayList<AbstractExpression>();
		list.add(new TerminalExpression());
		list.add(new NonterminalExpression());
		list.add(new TerminalExpression());
		list.add(new TerminalExpression());

		for (AbstractExpression exp : list)
		{
			exp.Interpret(context);
		}

	}
}