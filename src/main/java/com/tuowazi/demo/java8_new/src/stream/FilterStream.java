package com.tuowazi.demo.java8_new.src.stream;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by zwxbest on 2018/7/29.
 */
public class FilterStream {

    public static void main(String[] args) {
        List<Dish> vegetarianMenu = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());
    }
}
