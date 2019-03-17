package com.nizouba.Concurrent.src.reorder;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zwxbest on 2018/12/23.
 */
public class SingletonMain {
    private static volatile boolean flag = false;

    static class SingletonDemo implements Runnable {
        private CountDownLatch countDownLatch;

        public SingletonDemo(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            if (flag) {
                return;
            }
            Singleton instance = Singleton.getInstance();
            if (instance.getData() == null) {
                flag = true;
                System.out.println("success !");
            } else {
                System.out.println(Thread.currentThread().getName());
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }
    }
    public static void main(String[] args) {

        for (int j = 0; j < 100; j++) {
            CountDownLatch countDownLatch = new CountDownLatch(100);
            for (int i = 0; i < 100; i++) {
                new Thread(new SingletonDemo(countDownLatch)).start();
            }
        }

    }
}
