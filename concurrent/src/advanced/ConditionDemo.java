package advanced;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zwxbest on 2018/5/26.
 */
public class ConditionDemo implements Runnable{

    public static ReentrantLock lock=new ReentrantLock();
    public static Condition condition=lock.newCondition();


    @Override
    public void run() {
        try {
            lock.lock();
            condition.await();
            System.out.println("Thread is going on");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        ConditionDemo cd=new ConditionDemo();
        Thread t1=new Thread(cd);
        t1.start();
        Thread.sleep(2000);
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
