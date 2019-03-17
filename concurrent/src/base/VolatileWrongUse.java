package com.nizouba.Concurrent.src.base;

/**
 * Created by zwxbest on 2018/5/20.
 */
public class VolatileWrongUse  {
    //不能代替锁，无法保证复合原子操作，比如i++，先读取i，再++
    static volatile  int i=0;
    public static class RunTask implements Runnable{
        @Override
        public void run() {
            for(int k=0;k<10000;k++)
                i++;
        }
    }
    public static void main(String[] args) throws InterruptedException
    {
        Thread[] threads=new Thread[10];
        for(int i=0;i<10;i++)
        {
            threads[i]=new Thread(new RunTask());
            threads[i].start();
        }
        for(int i=0;i<10;i++)
        {
            threads[i].join();
        }
        System.out.println(i);
    }

}
