package com.nizouba.java8_new.src.stream;

/**
 * Created by zwxbest on 2018/7/30.
 */
public class findAnyStream {

    public static void main(String[] args) {

                Dish.menu.stream()
                        .filter(Dish::isVegetarian)
                        .findAny()
                        .ifPresent(d -> System.out.println(d.getName()));
    }
}
