package com.tuowazi.demo.concurrent.src.advanced;



import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by zwxbest on 2018/6/9.
 */
public class ThreadLocalRandomDemo implements Runnable{

    public  void run() {
        //ThreadLocalRandom.current()是返回当前线程的 ThreadLocalRandom ，是内部使用的
        //当所有用法都是这种形式时，绝对不可能跨多个线程共享一个ThreadLocalRandom
        System.out.println( ThreadLocalRandom.current().nextInt(4,77));
    }

    public static void main(String[] args) {
        ThreadLocalRandomDemo threadLocalRandomDemo=new ThreadLocalRandomDemo();
        for(int n = 1; n < 10; n++) {
            new Thread(()->threadLocalRandomDemo.run()).start();
        }
    }
}
