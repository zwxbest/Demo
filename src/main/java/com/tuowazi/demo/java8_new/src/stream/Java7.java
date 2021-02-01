package com.tuowazi.demo.java8_new.src.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zwxbest on 2018/7/29.
 */
public class Java7 {

    public static void main(String[] args) {

        //垃圾变量
        List<Dish> lowCaloricDishes = new ArrayList<>();
        //卡路里小于400的
        for(Dish d: Dish.menu){
            if(d.getCalories() < 400){
                lowCaloricDishes.add(d);
            }
        }
        //按照卡路里排序
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2){
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        //排序后的名字放到数组中
        List<String> lowCaloricDishesName = new ArrayList<>();
        for(Dish d: lowCaloricDishes){
            lowCaloricDishesName.add(d.getName());
        }
    }
}
