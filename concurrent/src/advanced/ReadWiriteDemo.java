package advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by zwxbest on 2018/5/26. 读写锁
 */
public class ReadWiriteDemo {

    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();//内部ReadLock
   private int value;

    /**
     * 模拟读操作
     *
     * @param lock 最好传入读锁
     */
    public Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);//耗时越多，读写锁优势越明显
            return value;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWiriteDemo demo = new ReadWiriteDemo();

        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleRead(readLock);
//                    demo.handleRead(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        try {
            Long startTime = System.currentTimeMillis();
            List<Thread> threads = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Thread thread = new Thread(readRunnable);
                thread.start();
                threads.add(thread);
            }
            for (Thread thread : threads) {
                thread.join();
            }
            System.out.println("总共用时"+ (System.currentTimeMillis()-startTime)/1000F+"秒");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
