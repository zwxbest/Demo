package com.nizouba.java8_new.src.stream;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

/**
 * Created by zwxbest on 2018/7/31.
 */
public class GroupByDemo3 {
    public static void main(String[] args) {
        Map<Dish.Type, Dish> mostCaloricByType =
                Dish.menu.stream()
                        .collect(groupingBy(Dish::getType,
                                collectingAndThen(
                                        maxBy(Comparator.comparingInt(Dish::getCalories)),
                                        Optional::get)));
    }
}
