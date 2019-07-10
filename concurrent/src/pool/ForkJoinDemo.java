package pool;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by zwxbest on 2018/6/1.
 */
public class ForkJoinDemo extends RecursiveTask<Long> {


    private static final int THRESHOLD = 10000;
    private long start;
    private long end;

    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute) {
            for (long i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            //分成100个小任务
            long step = (start + end) / 100;
            ArrayList<ForkJoinDemo> subTasks = new ArrayList<>();
            long pos = start;
            for (int i = 0; i < 100; i++) {
                long lastOne = pos + step;
                //注意边界
                if (lastOne > end) {
                    lastOne = end;
                }
                ForkJoinDemo subTask = new ForkJoinDemo(pos, lastOne);
                pos += step + 1;
                subTasks.add(subTask);
                subTask.fork();
            }
            for (ForkJoinDemo task : subTasks) {
                sum += task.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo task=new ForkJoinDemo(0L,2222L);
        ForkJoinTask<Long> result=forkJoinPool.submit(task);
        try {
            long res=result.get();
            System.out.println("sum="+res);

        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }
    }
}
