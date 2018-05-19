
public class StopThreadUnsafe {

    public static User user=new User();
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
        @Override
        public void run() {
            while (true)
            {
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
        new ReadObjectThread().start();
        while (true)
        {
            Thread thread = new ChangeObjectThread();
            thread.start();
            Thread.sleep(150);
            thread.stop();
        }
    }


}
