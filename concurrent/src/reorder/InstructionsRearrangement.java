package reorder;

import java.util.concurrent.CountDownLatch;

public class InstructionsRearrangement {

    public static void main(String[] args) {

        int threadCount = 10_0000_0000;
        for(int i=0; i<threadCount; i++) {
            if(Example.reOrdered){
                break;
            }
            System.out.println("current is the "+i+" time");
            final Example example = new Example();

            // 用来控制线程同时执行某些语句同时执行的锁
            CountDownLatch mutexCountDownLatch = new CountDownLatch(1);

            //在此例子中没有明确的作用，类似thread.join()，起阻塞作用
            CountDownLatch threadCountDownLatch = new CountDownLatch(2);
            new Thread(new ReaderThreadDemo(example, mutexCountDownLatch, threadCountDownLatch)).start();
            new Thread(new WriterThreadDemo(example, mutexCountDownLatch, threadCountDownLatch)).start();

            // 触发线程中同时执行mutexCountDownLatch.await()后的语句,用来模拟同时执行
            // 线程中的某些语句
            mutexCountDownLatch.countDown();
            try {
                threadCountDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class WriterThreadDemo implements Runnable {
    private Example example;
    private CountDownLatch mutexCountDownLatch;
    private CountDownLatch threadCountDownLatch;

    public WriterThreadDemo(Example example, CountDownLatch mutexCountDownLatch,
                            CountDownLatch threadCountDownLath) {
        this.example = example;
        this.mutexCountDownLatch = mutexCountDownLatch;
        this.threadCountDownLatch = threadCountDownLath;
    }

    public void run() {
        try {

            // 所有的线程阻塞在此位置,执行mutexCountDownLatch.countDown()后所有的线程
            // 从该语句后的语句开始执行,用来模拟不同的线程同时执行相应的语句
            mutexCountDownLatch.await();
            example.writer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            threadCountDownLatch.countDown();
        }
    }
}

class ReaderThreadDemo implements Runnable {
    private Example example;
    private CountDownLatch mutexCountDownLatch;
    private CountDownLatch threadCountDownLatch;

    public ReaderThreadDemo(Example example, CountDownLatch mutexCountDownLatch,
                            CountDownLatch threadCountDownLath) {
        this.example = example;
        this.mutexCountDownLatch = mutexCountDownLatch;
        this.threadCountDownLatch = threadCountDownLath;
    }

    public void run() {
        try {
            mutexCountDownLatch.await();
            example.reader();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            threadCountDownLatch.countDown();
        }
    }
}

class Example {
    public static volatile boolean reOrdered;
    int a = 0;
    boolean flag = false;
    public void writer() {
        a = 100; //1
        flag = true; //2
    }

    public void reader() {
        // 本来flag的赋值在a=0的后面,通常情况下如果flag==true时a==100,
        // 如果flag已经被赋值且a还是原来的值则表明先执行了flag=true,指令发生了重排序
        //在本例中,发生指令重排序的时候会输出It happends
        if (flag) { //3
            if(0 == a) {
                reOrdered = true;
                System.out.println("It happens");
            }
        }
    }
}
