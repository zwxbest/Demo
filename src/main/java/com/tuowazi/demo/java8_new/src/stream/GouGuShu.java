package com.tuowazi.demo.java8_new.src.stream;

import java.util.List;
import java.util.stream.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Created by zwxbest on 2018/7/31.
 */
public class GouGuShu {

    public static void main(String[] args) {
        int a=3;
        //错的
//        java.util.stream.IntStream.rangeClosed(1, 100)
//        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
//                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)});


        List<int[]> collect = IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed()
                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}).collect(toList());

        //和上面一样，不过简洁一点
        List<int[]> collect1 = IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}).collect(toList());

        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(aa ->
                                IntStream.rangeClosed(aa, 100)
                                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                                        .mapToObj(b ->
                                                new int[]{a, b, (int)Math.sqrt(aa * a + b * b)}));

        pythagoreanTriples.limit(5)
                .forEach(t ->
                        System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        long howManyDishes = Dish.menu.stream().count();
    }
}
