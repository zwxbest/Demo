package com.nizouba.Concurrent.src.advanced;

public class SynchronizedDemo3 implements Runnable{

    static int i= 0;

    //抽出方法
    //想改正，加一个static即可
    public  synchronized void increase()
    {
        i++;
    }

    @Override
    public void run() {

        for(int j=0;j<100000;j++)
        {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        Thread t1=new Thread(new SynchronizedDemo3());
        Thread t2=new Thread(new SynchronizedDemo3());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
