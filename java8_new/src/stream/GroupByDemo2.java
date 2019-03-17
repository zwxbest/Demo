package com.nizouba.java8_new.src.stream;

import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by zwxbest on 2018/7/31.
 */
public class GroupByDemo2 {

    public static void main(String[] args) {
        Map<Dish.Type, Long> typesCount = Dish.menu.stream().collect(
                groupingBy(Dish::getType, counting()));
    }
}
