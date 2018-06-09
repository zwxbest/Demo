package advanced;

public class SychronizedDemo2 implements Runnable{

    static SychronizedDemo2 instance=new SychronizedDemo2();
    static int i= 0;

    //抽出方法
    public synchronized void increase()
    {
        i++;
    }

    @Override
    public void run() {

        for(int j=0;j<100000;j++)
        {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

}
