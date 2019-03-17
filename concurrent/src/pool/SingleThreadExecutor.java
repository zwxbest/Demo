package com.nizouba.Concurrent.src.pool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by zwxbest on 2018/7/13.
 */
public class SingleThreadExecutor {

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
        //返回只有一个线程的线程池，若多于一个任务提交，就放到任务队列中。
        //等于newFixThreadPool(1)
        //因为只有一个线程，所以叫Executor而不是Pool？
        ExecutorService es= Executors.newSingleThreadExecutor();
//        new ThreadPoolExecutor(1, 1,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>()));
        //有5个可以分配任务立即执行，另外5个放在等待队列中。
        for(int i=0;i<10;i++)
        {
            es.submit(task);
        }
    }
}
