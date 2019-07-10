package base;

/**
 * 有序性和可见性
 * Created by zwxbest on 2018/5/20.
 */
//目前在java8加了-server参数也可以识别ready的改变
    //我的java -version是server

public class VisibilityAndOrdering {

//    private static boolean ready;
    private volatile static boolean ready;
//    private static int number;
    private volatile static int number;
    private static class ReadThread extends Thread{
        @Override
        public void run() {
            while (!ready)
            {
                System.out.println(number);
            }
            if(ready)
            {
                System.out.println("end ReadThread");
            }
        }
    }
    public static void  main(String[] args) throws InterruptedException
    {
        new ReadThread().start();
        Thread.sleep(1000);
        number=42;
        Thread.sleep(1000);
        ready=true;
        Thread.sleep(100000);

    }

}
