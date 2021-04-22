package com.tuowazi.demo.java8_new.src.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zwxbest on 2018/7/29.
 */
public class FilterAndDistinct {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }
}
