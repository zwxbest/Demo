package com.tuowazi.demo.concurrent.src.pool;

import java.util.concurrent.*;

/**
 * Created by zwxbest on 2018/6/1.
 *
 * 异常堆栈也不打印
 */
public class DivTask implements Runnable {
    @Override
    public void run() {

        double re=a/b;
        System.out.println(re);
    }

    int a,b;
    public DivTask(int a,int b)
    {
        this.a=a;
        this.b=b;
    }

    public static void main(String[] args) throws InterruptedException,ExecutionException
    {
//        ThreadPoolExecutor pools=new ThreadPoolExecutor(0,Integer.MAX_VALUE,
//            0L, TimeUnit.SECONDS,new SynchronousQueue<>());

        ThreadPoolExecutor pools=new ThreadPoolExecutor(0,Integer.MAX_VALUE,
                0L, TimeUnit.SECONDS,new SynchronousQueue<>());
        for(int i=0;i<5;i++)
        {
//            pools.submit(new DivTask(100,i)); 1 使用这个不会打印堆栈信息
//            Future submit = pools.submit(new DivTask(100, i));2//使用这个抛出异常后不会执行后面的代码
//            submit.get();//2 .
            pools.execute(new DivTask(100,i));//3. 使用这个看不到提交线程的地方
        }
    }

}
