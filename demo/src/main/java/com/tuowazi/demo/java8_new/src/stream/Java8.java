package com.tuowazi.demo.java8_new.src.stream;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Created by zwxbest on 2018/7/29.
 */
public class Java8 {
    public static void main(String[] args) {
        List<String> lowCaloricDishesName =
                Dish.menu.parallelStream()
                        .filter(d -> d.getCalories() < 400)
                        .sorted(comparing(Dish::getCalories))
                        .map(Dish::getName)
                        .collect(toList());
    }
}
