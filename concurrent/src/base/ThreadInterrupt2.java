package base;

public class ThreadInterrupt2 {

    public static void main(String[] args) throws InterruptedException
    {
        Thread t1=new Thread(){
            @Override
            public void run() {
                while (true)
                {
                    if(Thread.currentThread().isInterrupted())
                    {
                        System.out.println("Interrupt");
                        break;
                    }
                    Thread.yield();
                }
            }
        };
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }

}
