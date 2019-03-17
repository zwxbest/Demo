package com.nizouba.java8_new.src.stream;

/**
 * Created by zwxbest on 2018/7/30.
 */
public class allMatchStream {
    public static void main(String[] args) {
        boolean isHealthy = Dish.menu.stream()
                .allMatch(d -> d.getCalories() < 1000);
    }
}
