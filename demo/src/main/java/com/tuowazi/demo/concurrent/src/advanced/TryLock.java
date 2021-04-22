package com.tuowazi.demo.concurrent.src.advanced;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zwxbest on 2018/5/24.
 */
public class TryLock implements Runnable {

    public static ReentrantLock lock=new ReentrantLock();

    @Override
    public void run() {
        try {
            if(lock.tryLock(5, TimeUnit.SECONDS))
            {
                Thread.sleep(6000);
            }
            else {
                System.out.println("get lock failed");
            }
        }
        catch (InterruptedException e)
        {
         e.printStackTrace();
        }
        finally {
            if(lock.isHeldByCurrentThread())
            {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args)
    {
        TryLock tl1=new TryLock();
        Thread t1=new Thread(tl1);
        Thread t2=new Thread(t1);
        t1.start();
        t2.start();
    }

}
