package com.nizouba.java8_new.src.stream;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by zwxbest on 2018/7/31.
 */
public class partitionDemo {

    public static void main(String[] args) {
        List<Dish> vegetarianDishes =
                Dish.menu.stream().filter(Dish::isVegetarian).collect(toList());
    }
}
