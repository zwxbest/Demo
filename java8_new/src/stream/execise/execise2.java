package stream.execise;

import static java.util.stream.Collectors.toSet;

/**
 * Created by zwxbest on 2018/7/30.
 *  交易员都在哪些不同的城市工作过
 */
public class execise2 {

    public static void main(String[] args) {
        Transactions.transactions.stream().map(x->x.getTrader().getCity()).distinct().forEach(System.out::println);
        Transactions.transactions.stream().map(x->x.getTrader().getCity()).collect(toSet());
    }
}
