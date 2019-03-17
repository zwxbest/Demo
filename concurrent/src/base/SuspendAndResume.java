package com.nizouba.Concurrent.src.base;

/**
 * suspendAndResume 已废弃
 */
public class SuspendAndResume {
    public static Object object=new Object();
    public static ChangeObjectThread t1=new ChangeObjectThread("t1");
    public static ChangeObjectThread t2=new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends  Thread{
        public ChangeObjectThread(String name)
        {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (object)
            {
                System.out.println("in"+getName());
                Thread.currentThread().suspend();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException
    {
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.resume();//t1的resume在suspend之后发生，可以结束
        t2.resume();//t2的resume在suspend之前发生，无法结束
        t1.join();//等待t1结束
        System.out.println("t1结束");//t1的resume在suspend之后发生，可以结束
        t2.join();
        System.out.println("t2结束");//t2的resume在suspend之前发生，无法结束

    }
}
