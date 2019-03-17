package com.nizouba.Concurrent.src.advanced;

public class TheadPriority {

    public static class HightPriority extends Thread{

        static  int count=0;
        public void run()
        {
            while (true)
            {
                synchronized (TheadPriority.class)
                {
                    count++;
                    if(count>100000000)
                    {
                        System.out.println("HighPriority Complete");
                        break;
                    }
                }
            }
        }
    }

    public static class LowPriority extends Thread{
        static  int count=0;
        public void run()
        {
            while (true)
            {
                synchronized (LowPriority.class)
                {
                    count++;
                    if(count>100000000)
                    {
                        System.out.println("LowPriority Complete");
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        Thread high=new HightPriority();
        Thread low = new LowPriority();
        high.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);
        low.start();
        high.start();
    }
}
