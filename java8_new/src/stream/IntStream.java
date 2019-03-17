package com.nizouba.java8_new.src.stream;

/**
 * Created by zwxbest on 2018/7/30.
 */
public class IntStream {

    public static void main(String[] args) {
        int calories = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        int calories1 = Dish.menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
//        int calories2 = Dish.menu.stream()
//                .map(Dish::getCalories)
//                .sum();


    }
}
