package com.tuowazi.demo.java8_new.src.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by zwxbest on 2018/7/29.
 * 流只能被消费一次
 */
public class StreamOnyOnce {

    public static void main(String[] args) {
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        s.forEach(System.out::println);

    }
}
