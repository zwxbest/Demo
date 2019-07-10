package base;

/**
 * wait和notify
 */
public class WaitAmdNotify {

    final static Object object = new Object();
    public static class T1 extends Thread
    {
        @Override
        public void run() {
            synchronized (object){
                System.out.println(System.currentTimeMillis()+"T1 started");
                try {
                    System.out.println(System.currentTimeMillis()+"T1 wait for object");
                    object.wait();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis()+"T1 end");
            }
        }
    }
    public static class T2 extends  Thread{
        @Override
        public void run() {
            synchronized (object)
            {
                System.out.println(System.currentTimeMillis()+"T2 started,notify one thread");
             object.notify();
                System.out.println(System.currentTimeMillis()+"T2 end");
                try {
                    Thread.sleep(2000);//sleep 并不释放锁，wait释放锁
                }
                catch (Exception e)
                {

                }
            }
        }
    }
    public static void main(String[] args)
    {
        new T1().start();
        new T2().start();
    }
}
