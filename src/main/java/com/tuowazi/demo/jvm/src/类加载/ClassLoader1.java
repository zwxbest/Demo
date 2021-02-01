package com.tuowazi.demo.jvm.src.类加载;

/**
 * 虽然使用了Child.v,Child没有进入初始化阶段，当Child已经被加载
 * Created by zwxbest on 2018/6/17.
 */
public class ClassLoader1 {

    public static class Parent
    {
        static {
            System.out.println("parent init");
        }
        public static int v=100;
    }

    public static class Child extends  Parent
    {
        static {
            System.out.println("child init");
        }

    }
    public static void main(String[] args) {
        System.out.println(Child.v);
    }


}
