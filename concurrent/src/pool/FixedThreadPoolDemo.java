package com.nizouba.Concurrent.src.pool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zwxbest on 2018/5/27.
 * newFixedThreadPool返回了corePoolsize和maxnpoolsize大小相同的，用LinkedBlockingQueue
 */
public class FixedThreadPoolDemo {

    public static class MyTask implements Runnable
    {
        @Override
        public void run() {
            System.out.println(new SimpleDateFormat("mm:ss").format(new Date())+" Thread ID: "+Thread.currentThread().getId());
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        MyTask task=new MyTask();
        //返回一个固定线程数量的线程池，corePoolSize和maxSize的大小一样。
        //超过size就放到队列中等待
        ExecutorService es= Executors.newFixedThreadPool(5);
//     return new ThreadPoolExecutor(nThreads, nThreads,
//                                      0L,TimeUnit.MILLISECONDS,
//                                      new LinkedBlockingQueue<Runnable>());
        //有5个可以分配任务立即执行，另外5个放在等待队列中。
        for(int i=0;i<10;i++)
        {
            es.submit(task);
        }
    }
}
