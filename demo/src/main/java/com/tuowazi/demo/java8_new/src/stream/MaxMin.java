package com.tuowazi.demo.java8_new.src.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by zwxbest on 2018/7/30.
 */
public class MaxMin {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
    }
}
