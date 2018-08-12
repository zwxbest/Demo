package stream.execise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zwxbest on 2018/7/30.
 * 找出2011年的所有交易并按交易额排序（从低到高）
 */
public class execise1 {


    public static void main(String[] args) {
        Transactions.transactions.stream().filter(x -> x.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).forEach(System.out::println);
    }
}
