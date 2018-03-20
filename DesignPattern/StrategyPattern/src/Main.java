import Strategy.CashContext;
import Strategy.CashRebate;

public class Main {

    public static void main(String[] args) {
        double beforeCash=100;
        CashContext context=new CashContext();
        context.setBehavior(new CashRebate("9.9"));
        context.GetResult(beforeCash);
    }
}
