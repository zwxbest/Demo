package com.tuowazi.demo.hash;

import lombok.AllArgsConstructor;

/**
 * 该方法是最为简单常用的一种方法。它是以表长m来除关键字，取其余数作为散列地址，即 h(key)=key％m
 *    　该方法的关键是选取m。选取的m应使得散列函数值尽可能与关键字的各位相关。m最好为素数。
 */
public class Hash4 {

    @AllArgsConstructor
    public static class Student {
        private int key;
        private String name;


        public int hash() {
            key *= key;
            key /= 100;       //先求平方值，后去掉末尾的两位数
            return key % 1000; //取中间三位数作为散列地址返回
        }
    }

    public static void main(String[] args) {
        System.out.println(new Student(0100, "haha").hash());
        System.out.println(new Student(0110, "haha").hash());
        System.out.println(new Student(1010, "haha").hash());
    }

}
