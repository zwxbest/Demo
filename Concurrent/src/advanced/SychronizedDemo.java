package advanced;//1 直接加锁对象，进入同步代码前获取给定对象的锁
//2 直接作用于实例方法，进入同步块之前获取当前实例的锁
// 3 作用于静态方法，获取当前类的锁

public class SychronizedDemo implements Runnable{

    static SychronizedDemo instance=new SychronizedDemo();
    static int i = 0;
    @Override
    public void run() {
        for(int j=0;j<10000000;j++)
        {
            synchronized (instance)
            {
                i++;
            }
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
