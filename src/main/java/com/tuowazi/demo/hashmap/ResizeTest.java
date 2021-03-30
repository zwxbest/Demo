package com.tuowazi.demo.hashmap;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import lombok.val;

public class ResizeTest {

    public static void main(String[] args) throws Exception {
        Map map = new HashMap<String, Integer>(2);
        Class clz = map.getClass();
        Method capacity = clz.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        Method size = clz.getDeclaredMethod("size");
        size.setAccessible(true);

        System.out.println(map);
        System.out.println(String.format("capacity=%s", capacity.invoke(map)));
        System.out.println(String.format("size=%s", size.invoke(map)));


        map.put("a",1);
        System.out.println(map);
        System.out.println(String.format("capacity=%s", capacity.invoke(map)));
        System.out.println(String.format("size=%s", size.invoke(map)));

        map.put("b",2);
        System.out.println(map);
        System.out.println(String.format("capacity=%s", capacity.invoke(map)));
        System.out.println(String.format("size=%s", size.invoke(map)));
//
//        map["c"] = 3
//        println("capacity=${capacity.invoke(map)}")
//        println("size=${size.invoke(map)}")
//        println(map)
//
//        map["ab"] = 12
//        println("capacity=${capacity.invoke(map)}")
//        println("size=${size.invoke(map)}")
//        println(map)
//
//        map["bc"] = 23
//        println("capacity=${capacity.invoke(map)}")
//        println("size=${size.invoke(map)}")
//        println(map)
//
//        map["abc"] = 123
//        println("capacity=${capacity.invoke(map)}")
//        println("size=${size.invoke(map)}")
//        println(map)
//
//        map["abcd"] = 1234
//        println("capacity=${capacity.invoke(map)}")
//        println("size=${size.invoke(map)}")
//        println(map)
    }
}
