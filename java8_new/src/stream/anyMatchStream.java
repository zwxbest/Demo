package com.nizouba.java8_new.src.stream;

/**
 * Created by zwxbest on 2018/7/30.
 */
public class anyMatchStream {
    public static void main(String[] args) {
        if(Dish.menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }
    }
}
