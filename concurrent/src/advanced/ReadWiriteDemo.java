package com.nizouba.Concurrent.src.advanced;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by zwxbest on 2018/5/26.
 * 读写锁
 */
public class ReadWiriteDemo{

    private static Lock lock=new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    private static Lock readLock=readWriteLock.readLock();//内部ReadLock
    private static Lock wirteLock=readWriteLock.writeLock();//内部WriteLock类
    private int value;

    /**
     * 模拟读操作
     * @param lock 最好传入读锁
     * @return
     * @throws InterruptedException
     */
    public Object handleRead(Lock lock) throws InterruptedException
    {
        try {
            lock.lock();
            Thread.sleep(1000);//耗时越多，读写锁优势越明显
            return value;
        }
        finally {
            lock.unlock();
        }
    }

    /**
     * 模拟写操作
     * @param lock 最好传入写锁
     * @param index
     * @throws InterruptedException
     */
    public void handleWrite(Lock lock,int index)throws InterruptedException
    {
        try {
            lock.lock();
            Thread.sleep(1000);//耗时越多，读写锁优势越明显
             value=index;
        }
       finally {
            lock.unlock();
        }
    }

    public static void main(String[] args)
    {
        final ReadWiriteDemo demo=new ReadWiriteDemo();

        Runnable readRunnable=new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleRead(readLock);
//                    demo.handleRead(lock);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };

        Runnable writeRunnable=new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleWrite(wirteLock,new Random().nextInt());
//                    demo.handleWrite(lock,new Random().nextInt());
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };

        try {
            Long startTime=System.currentTimeMillis();
            for(int i=0;i<18;i++)
            {
                Thread thread= new Thread(readRunnable);
                thread.start();
            }
            for(int i=18;i<20;i++)
            {
                Thread thread= new Thread(readRunnable);
                thread.start();
            }
            //todo：用线程组测试用时
//            System.out.println("总共用时"+ (System.currentTimeMillis()-startTime)/1000F+"秒");
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

}
