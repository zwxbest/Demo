package com.nizouba.Concurrent.src.base;

//继承thread和实现runnable创建线程
public class NewThread {

    static class MyThread extends Thread {
        int count=0;
        @Override
        public void run() {
            System.out.println("Thread  run()"+count++);
        }
    }

    static class MyRunnable implements Runnable {
        int count=0;
        @Override
        public void run() {
            System.out.println("Runnable run()"+count++);
        }
    }


    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread1.start();
        myThread2.start();

        MyRunnable myRunnable=new MyRunnable();
        //共享了count变量
        Thread myRunnable1=new Thread(myRunnable);
        Thread myRunnable2=new Thread(myRunnable);
        myRunnable1.start();
        myRunnable2.start();

    }
}
