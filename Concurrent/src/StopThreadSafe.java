import com.sun.org.apache.xpath.internal.operations.Bool;

import java.lang.invoke.VolatileCallSite;

/**
 * 不安全停止线程
 */
public class StopThreadSafe {

    public static StopThreadUnsafe.User user=new StopThreadUnsafe.User();
    public static class User{
        private int id;
        private String name;
        public  User()
        {
            setId(0);
            setName("0");
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return " id is 0"+id+" name is "+name;
        }
    }

    public static class ChangeObjectThread extends Thread
    {
        volatile boolean stopMe=false;
        public void setStopMe()
        {
            stopMe=true;
        }
        @Override
        public void run() {
            while (true)
            {

                if(stopMe)
                {
                    System.out.println("exit by stop me");
                    break;
                }
                synchronized (user){
                    int v=(int)(System.currentTimeMillis()/1000);
                    user.setId(v);
                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    user.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread{
        @Override
        public void run() {
            while (true)
            {
                synchronized (user)
                {
                    if(user.getId()!=Integer.valueOf(user.getName()))
                    {
                        System.out.println(user.toString());
                    }
                    Thread.yield();
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException
    {
        new StopThreadUnsafe.ReadObjectThread().start();
        while (true)
        {
            ChangeObjectThread thread = new ChangeObjectThread();
            thread.start();
            Thread.sleep(150);
            thread.setStopMe();
        }
    }




}
