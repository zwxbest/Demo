package com.tuowazi.demo.java8_new.src.stream;

import java.util.stream.IntStream;

/**
 * Created by zwxbest on 2018/7/31.
 */
public class IntSteamRange {
    public static void main(String[] args) {

        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);

        System.out.println(evenNumbers.count());
    }
}
