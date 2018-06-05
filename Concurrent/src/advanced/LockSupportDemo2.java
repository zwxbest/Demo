package advanced;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by zwxbest on 2018/5/27.
 */
public class LockSupportDemo2 {

    public static Object u=new Object();
    static ChangeObjectThread t1=new ChangeObjectThread("t1");
    static ChangeObjectThread t2=new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread
    {
        public ChangeObjectThread(String name)
        {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u)
            {
                System.out.println("in "+getName());
                //相当于suspend
                LockSupport.park();
//                LockSupport.park(this);
                if(Thread.interrupted())
                {
                    System.out.println(getName()+"被中断了");
                }
                System.out.println(getName()+"执行结束");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.interrupt();
        //相当于resume
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}
