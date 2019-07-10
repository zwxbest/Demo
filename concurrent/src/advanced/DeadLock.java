package advanced;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zwxbest on 2018/5/24.
 * 重入锁，有中断机制，可以再进入，
 */
public class DeadLock implements Runnable {
    public static ReentrantLock lock1=new ReentrantLock();
    public static ReentrantLock lock2=new ReentrantLock();
    int  lock;

    public DeadLock(int lock)
    {
        this.lock=lock;
    }

    @Override
    public void run() {
        try {
            if(lock==1)
            {
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {}
                lock2.lockInterruptibly();
            }
            else {
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {}
                lock1.lockInterruptibly();
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally {
            if(lock1.isHeldByCurrentThread())
            {
                lock1.unlock();
            }
            if(lock2.isHeldByCurrentThread())
            {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId()+":线程退出");

        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        DeadLock l1=    new DeadLock(1);
        DeadLock l2=    new DeadLock(2);
        Thread t1=new Thread(l1);
        Thread t2=new Thread(l2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t2.interrupt();
    }
}
