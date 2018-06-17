package Java堆栈;

/**
 * 栈上分配，本来即使局部对象，new出来的应该是在堆上的
 * Created by zwxbest on 2018/6/15.
 */
public class AllocateObjectOnStack {

    public static User user;
    public static class User
    {
        public int id=0;
        public String name="";
    }

    public static void alloc()
    {
//        user=new User();
        User u=new User();
        u.id=5;
        u.name="geym";
    }

    public static void main(String[] args) throws Exception {

        long b=System.currentTimeMillis();
        for(int i=0;i<10;i++)
        {
            alloc();
        }
        long e=System.currentTimeMillis();
        System.out.println(e-b);
    }


}
