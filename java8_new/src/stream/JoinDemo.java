package com.nizouba.java8_new.src.stream;

import static java.util.stream.Collectors.joining;

/**
 * Created by zwxbest on 2018/7/31.
 */
public class JoinDemo {

    public static void main(String[] args) {
        String shortMenu = Dish.menu.stream().map(Dish::getName).collect(joining(", "));
    }
}
