package advanced;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by zwxbest on 2018/5/26.
 * 信号量
 */
public class SemaphoreDemo implements Runnable{

    final Semaphore semp=new Semaphore(5);

    @Override
    public void run() {
        try {
            semp.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId()+"done!");
            semp.release();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        ExecutorService exec= Executors.newFixedThreadPool(20);
        final SemaphoreDemo demo=new SemaphoreDemo();
        for(int i=0;i<20;i++)
        {
            exec.submit(demo);
        }
    }
}
