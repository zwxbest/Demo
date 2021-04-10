package com.tuowazi.demo.hash;

import lombok.AllArgsConstructor;

/**
 * 直接寻址，取关键字或关键字的某个线性函数值为散列地址。 比如说取某个对象的id
 */
public class Hash1 {

    @AllArgsConstructor
    public static class Student {
        private int id;
        private String name;


        public int hash() {
            return id;
//            return id*2+1;
        }
    }

    public static void main(String[] args) {
        Student haha = new Student(1, "haha");
        System.out.println(haha.hash());
    }

}
