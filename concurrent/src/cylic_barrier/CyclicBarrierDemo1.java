package com.nizouba.Concurrent.src.cylic_barrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by zwxbest on 2018/5/26.
 * 循环倒计时器
 */
public class CyclicBarrierDemo1 {

    public static class Soldier implements Runnable{

        private String soldier;
        private final CyclicBarrier cyclicBarrier;

        Soldier(CyclicBarrier cyclicBarrier, String soldierName)
        {
            this.cyclicBarrier=cyclicBarrier;
            this.soldier=soldierName;
        }

        @Override
        public void run() {
            try {
                //10个全部在外面等待，集齐10个才进行下一步才跳出await
                //如果第一轮中间比如第5个正在await的遇到interrupt，之前await和之后await的都要
                System.out.println("before await round-1 "+soldier);
                cyclicBarrier.await();//通知cyclicBarrier进行countdown操作
                System.out.println("after await round-1 "+soldier);
                doWork();
                cyclicBarrier.await();//一个线程里的第二个await，通知下一轮countdown
            }
            catch (InterruptedException e)
            {
                System.out.println(soldier+" InterruptedException");
//                e.printStackTrace();
            }
            //破损异常，比如10个await
            catch (BrokenBarrierException e)
            {
//                e.printStackTrace();
                System.out.println(soldier+" BrokenBarrierException");
            }
        }
        void  doWork()
        {
            try {

                Thread.sleep(Math.abs(new Random().nextInt()%10000));

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(soldier+":任务完成");
        }
    }

    public static class  BarrierRun implements Runnable
    {
        boolean flag;
        int N;
        public BarrierRun(boolean flag,int N)
        {
            this.flag=flag;
            this.N=N;
        }
        @Override
        public void run() {
            if(flag)
                System.out.println("所有士兵的任务完成");
            else
            {
                System.out.println("所有士兵集合完毕");
                flag=true;
            }

        }
    }

    public static void main(String[] args) throws InterruptedException
    {

//        final int N=50; //如果已经中间已经有interrupt，那这个cyclicBarrier的第一轮不管后面有多少线程加入await，都会报broke异常，
        final int N=10;
        Thread[] allSoldier=new Thread[N];
        //第二个参数表示一轮之后要执行的操作
        CyclicBarrier cyclicBarrier=new CyclicBarrier(N,new BarrierRun(false,N));
        System.out.println("集合队伍");
        for(int i=0;i<N;i++)
        {
            System.out.println("士兵"+i+"报道");
            allSoldier[i]=new Thread(new Soldier(cyclicBarrier,"士兵"+i));
            //如果放在这里，interrupt就不管用了
//            if(i==5)
//            {
//                allSoldier[i].interrupt();
//            }
            allSoldier[i].start();
            //好像是start（）之后interrupt就管用，就等你一下await，然后刷地一下给你断掉
            //如果
            if(i==5)
            {
                System.out.println("**********Solider"+i+ " interrupt********");
                allSoldier[i].interrupt();
            }

        }

    }

}
