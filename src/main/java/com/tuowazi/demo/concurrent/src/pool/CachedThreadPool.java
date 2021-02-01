package com.tuowazi.demo.concurrent.src.pool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by zwxbest on 2018/7/13.
 */
public class CachedThreadPool {

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
        //初始化线程池的线程容量为0
        //线程不够用就创建，用完了放到线程池中，60s之后销毁。
        ExecutorService es= Executors.newCachedThreadPool();
//        new ThreadPoolExecutor(0, Integer.MAX_VALUE,
//                60L, TimeUnit.SECONDS,
//                new SynchronousQueue<Runnable>());

        //有5个可以分配任务立即执行，另外5个放在等待队列中。
        for(int i=0;i<10;i++)
        {
            es.submit(task);
        }
    }
}
