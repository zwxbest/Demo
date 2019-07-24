package advanced;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zwxbest on 2018/5/26.
 * 倒计时器
 */
public class CountDownLatchDemo implements Runnable {

    static final CountDownLatch end=new CountDownLatch(10);
    static final CountDownLatchDemo demo=new CountDownLatchDemo();
    int count  = 10;

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println(--count);
            end.countDown();//countDown代表计数减1
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        for(int i=0;i<demo.count;i++)
        {
            executorService.submit(demo);
        }
        end.await();//主线程等待所有10个检查任务完成
        System.out.println("Fire");
        executorService.shutdown();
    }
}
