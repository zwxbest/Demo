package com.tuowazi.demo.java8_new.src.stream;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by zwxbest on 2018/7/29.
 */
public class FilterAndLImit {
    public static void main(String[] args) {
        List<Dish> dishes = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(toList());
    }
}
