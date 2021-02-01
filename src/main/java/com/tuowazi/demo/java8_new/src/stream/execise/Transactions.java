package com.tuowazi.demo.java8_new.src.stream.execise;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zwxbest on 2018/7/30.
 */
public class Transactions {

    public static Trader raoul = new Trader("Raoul", "Cambridge");
    public static Trader mario = new Trader("Mario","Milan");
    public static Trader alan = new Trader("Alan","Cambridge");
    public static Trader brian = new Trader("Brian","Cambridge");

  public static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );
}
