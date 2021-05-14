package com.tuowazi.zookeeper.lock;

import com.tuowazi.zookeeper.lock.ConcurrentTest;

public class ZkTest {
    public static void main(String[] args) {
        Runnable task1 = new Runnable() {
            public void run() {
                com.concurrent.DistributedLock lock = null;
                try {
                    lock = new com.concurrent.DistributedLock("127.0.0.1:2181", "test1");
                    //lock = new DistributedLock("127.0.0.1:2182","test2");
                    lock.lock();
                    Thread.sleep(3000);
                    System.out.println("===Thread " + Thread.currentThread().getId() + " running");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (lock != null)
                        lock.unlock();
                }

            }

        };
        new Thread(task1).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        ConcurrentTest.ConcurrentTask[] tasks = new ConcurrentTest.ConcurrentTask[60];
        for (int i = 0; i < tasks.length; i++) {
            ConcurrentTest.ConcurrentTask task3 = new ConcurrentTest.ConcurrentTask() {
                public void run() {
                    com.concurrent.DistributedLock lock = null;
                    try {
                        lock = new com.concurrent.DistributedLock("127.0.0.1:2183", "test2");
                        lock.lock();
                        System.out.println("Thread " + Thread.currentThread().getId() + " running");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                }
            };
            tasks[i] = task3;
        }
        new ConcurrentTest(tasks);
    }
}