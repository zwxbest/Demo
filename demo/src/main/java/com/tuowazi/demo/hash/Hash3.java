package com.tuowazi.demo.hash;

import lombok.AllArgsConstructor;

/**
 * 具体方法：先通过求关键字的平方值扩大相近数的差别，然后根据表长度取中间的几位数作为散列函数值。又因为一个乘积的中间几位数和乘数的每一位都相关，所以由此产生的散列地址较为均匀。
 */
public class Hash3 {

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
