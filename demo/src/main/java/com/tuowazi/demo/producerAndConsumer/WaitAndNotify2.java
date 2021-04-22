package com.tuowazi.demo.producerAndConsumer;

/**
 * 处理1中 生产者和消费者不能同时进行的问题
 * bix
 */
public class WaitAndNotify2 {
    private static Integer count = 0;
    private static final int FULL = 10;
    private static final String LOCK = "lock";
    private static final String LOCK_RROVIDER = "lock_provider";
    private static final String LOCK_CONSUMER = "lock_consumer";

    public static void main(String[] args) {
        WaitAndNotify2 test1 = new WaitAndNotify2();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (LOCK_RROVIDER) {
                    System.out.println(Thread.currentThread().getName() + "开始生产√√√√√");
                    while (count == FULL) {
                        try {
//                            System.out.println("生产者满了，wait==========");
                            LOCK.wait();
//                            System.out.println("生产者解锁wait√√√√√√");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "+++++++++++生产者生产，目前总共有" + count);
                    LOCK.notifyAll();
                    System.out.println(Thread.currentThread().getName() + "结束生产×××××××");
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK_CONSUMER) {
                    System.out.println(Thread.currentThread().getName() + "开始消费√√√√√");
                    while (count == 0) {
                        try {
//                            System.out.println("消费者空了，wait=============！");
                            LOCK.wait();
//                            System.out.println("消费者解锁wait√√√√√√√");
                        } catch (Exception e) {
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "--------消费者消费，目前总共有" + count);
                    LOCK.notifyAll();
                    System.out.println(Thread.currentThread().getName() + "结束消费×××××××");
                }
            }
        }
    }
}
