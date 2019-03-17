package com.nizouba.Concurrent.src.base;

/**
 * 新建线程
 */
public class NewThreadRunnable implements Runnable {

    public static void main(String[] args)
    {
        Thread t1=new Thread(new NewThreadRunnable() );
        t1.start();
        
    }

    @Override
    public void run() {
        System.out.println("正在运行");
    }
}
