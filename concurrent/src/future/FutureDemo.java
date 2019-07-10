package future;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureDemo  {

    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask=new FutureTask<String>(new RealData("a"));
        ExecutorService executorService= Executors.newFixedThreadPool(1);
        executorService.submit(futureTask);
        System.out.println("请求完毕");
        try {
            System.out.println("在做其他的操作");
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {

        }
        System.out.println("我要拿数据了"+ new SimpleDateFormat("mm:ss").format(new Date()));
        //        依然会等待
        System.out.println("数据="+futureTask.get()+" "+new SimpleDateFormat("mm:ss").format(new Date()));
        System.out.println("结束了"+" "+new SimpleDateFormat("mm:ss").format(new Date()));

    }

}
