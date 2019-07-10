package reorder;

import reorder.InstructionsRearrangement;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author mnmlist@163.com
 * @date 2017/05/21
 * @time 10:59
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int threadCount = 10_0000_0000;
        for(int i=0; i<threadCount; i++) {
            if(Example.reOrdered){
                break;
            }
            System.out.println("current is the "+i+" time");
            Example example = new Example();
            // 内存屏障，当所有的线程都到达该屏障时然后再继续执行屏障后的语句
            CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
            Thread t2 = new Thread(new ReaderDemo(cyclicBarrier, example));
            Thread t1 = new Thread(new WriterDemo(cyclicBarrier, example));
            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class WriterDemo implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private Example example;

    public WriterDemo(CyclicBarrier cyclicBarrier, Example example) {
        this.cyclicBarrier = cyclicBarrier;
        this.example = example;
    }

    public void run() {
        try {

            //阻塞在这里
            cyclicBarrier.await();
            example.writer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}

class ReaderDemo implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private Example example;

    public ReaderDemo(CyclicBarrier cyclicBarrier, Example example) {
        this.cyclicBarrier = cyclicBarrier;
        this.example = example;
    }

    public void run() {
        try {

            //阻塞在这里
            cyclicBarrier.await();
            example.reader();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

