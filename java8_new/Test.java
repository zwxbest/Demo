package com.nizouba;

/**
 * Created by zwxbest on 2018/12/30.
 */
public class Test {

    private Integer i = 3;
    private static int a = 90;

    public void add(int a,int b){
        Test test = this;
        int z = a + b;
        int x = 3;
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.add(2,3);
    }
}
