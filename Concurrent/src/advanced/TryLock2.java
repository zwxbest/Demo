package advanced;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zwxbest on 2018/5/24.
 */
public class TryLock2 implements Runnable{

    public static ReentrantLock lock1=new ReentrantLock();
    public static ReentrantLock lock2=new ReentrantLock();

    int lock;

    public TryLock2(int lock)
    {
        this.lock=lock;
    }

    @Override
    public void run() {
        if(lock==1)
        {
            while (true)
            {
                if(lock1.tryLock())
                {
                    try {
                        try {
                            Thread.sleep(500);
                        }
                        catch (InterruptedException e){}
                        if(lock2.tryLock()){
                            try {
                                System.out.println(Thread.currentThread().getId()+":My Job done");
                                return;
                            }
                            finally {
                                lock2.unlock();
                            }
                        }
                    }
                    finally {
                        lock1.unlock();
                    }

                }

            }
        }
        else {
            while (true)
            {
                if(lock2.tryLock())
                {
                    try {
                        try {
                            Thread.sleep(500);
                        }
                        catch (InterruptedException e)
                        {

                        }
                        if(lock1.tryLock())
                        {
                            try {
                                System.out.println(Thread.currentThread().getId()+":My Job done");
                                return;
                            }
                            finally {
                                lock1.unlock();
                            }
                        }
                    }
                    finally {
                        lock2.unlock();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws  InterruptedException
    {
        TryLock2 r1=new TryLock2(1);
        TryLock2 r2=new TryLock2(2);
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        t1.start();
        t2.start();
    }
}
