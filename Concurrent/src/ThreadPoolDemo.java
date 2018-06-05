import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 */
public class ThreadPoolDemo {
    public static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis()/1000 + "-ID: " + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
    {
        MyTask task = new MyTask();
        //每5个线程作为一组执行
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=0;i<10;i++)
        {
            executorService.submit(task);
        }

    }
}
