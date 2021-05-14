public class Test2 {
    public volatile int inc = 0;

    public void increase() {
        inc++;
//        System.out.println(Thread.currentThread().getName()+"inc "+ inc);
    }

    public static void main(String[] args) {
        final Test2 test = new Test2();

        Thread[] threads = new Thread[3];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        test.increase();
//                        try {
//                            Thread.sleep(1);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    }
                    System.out.println(getName() + " end,inc is " + test.inc);
                }
            };
            threads[i].setName("threads" + i);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        //保证前面的线程都执行完
        System.out.println("main end " + test.inc);
    }
}