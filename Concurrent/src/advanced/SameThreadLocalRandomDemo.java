package advanced;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by zwxbest on 2018/6/9.
 */
public class SameThreadLocalRandomDemo implements Runnable {
    //因为这个是static，类拥有的，种子相同，每个线程的第n个随机都相同
    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public void run() {
        System.out.println(random+"     "+random.nextInt(1,100));
        System.out.println(ThreadLocalRandom.current().nextInt(1,100));
    }

    public static void main(String[] args) {
        ExecutorService taskPool = Executors.newCachedThreadPool();
        for(int n = 1; n < 10; n++) {
            taskPool.submit(new SameThreadLocalRandomDemo());
        }
        taskPool.shutdown();
    }

}
