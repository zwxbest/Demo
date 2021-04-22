package com.tuowazi.demo.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TimeOutTest {
    private static LinkedBlockingQueue keyPoolQueue = new LinkedBlockingQueue<Runnable>(3);


    public static final ExecutorService FRAME_THREAD_POOL = new ThreadPoolExecutor(1, 1, 0,
            TimeUnit.SECONDS, keyPoolQueue, Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        FRAME_THREAD_POOL.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("我卡在这了");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        for (int i = 0; i < 100; i++) {
            try {
                Future<?> submit = FRAME_THREAD_POOL.submit(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("快点啊，我等的花都谢了");
                    }
                });
                submit.get(2, TimeUnit.SECONDS);
            } catch (RejectedExecutionException e) {
                System.out.println("RejectedExecutionException");
            } catch (TimeoutException e) {
                System.out.println("TimeoutException");
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            } catch (ExecutionException e) {
                System.out.println("ExecutionException");
            }
        }


    }

}
