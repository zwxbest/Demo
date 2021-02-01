package com.tuowazi.demo.java8_new.src.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by zwxbest on 2018/7/30.
 * 何时使用findFirst和findAny
 你可能会想，为什么会同时有 findFirst 和 findAny 呢？答案是并行。找到第一个元素
 在并行上限制更多。如果你不关心返回的元素是哪个，请使用 findAny ，因为它在使用并行流
 时限制较少
 */
public class findFirst {

    public static void main(String[] args) {

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0)
                        .findFirst(); // 9
    }
}
