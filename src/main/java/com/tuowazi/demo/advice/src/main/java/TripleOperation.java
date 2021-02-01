package com.tuowazi.demo.advice.src.main.java;

/**
 * Created by zwxbest on 2018/5/24.
 */
public class TripleOperation {

    /**
     * 90转换为浮点数了
     * @param args
     */
    public static void main(String[] args)
    {
        int i=0;
        String s=String.valueOf(i<100?90:100);
        String s1=String.valueOf(i<100?90:100.0);
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s1.equals(s));
    }
}
