package Java堆栈;

/**
 * 查看堆分配
 * Created by zwxbest on 2018/6/15.
 */
public class HeapAllocl {

    public static void main(String[] args) {
        System.out.println("maxMemory="+Runtime.getRuntime().maxMemory()/1000F/1000);
        System.out.println("freeMemory="+Runtime.getRuntime().freeMemory()/1000F/1000);
        System.out.println("totalMemory="+Runtime.getRuntime().totalMemory()/1000F/1000);
        byte[] b=new byte[1024*1024];
        System.out.println("分配了1M空间给数组");

        System.out.println("maxMemory="+Runtime.getRuntime().maxMemory()/1000F/1000);
        System.out.println("freeMemory="+Runtime.getRuntime().freeMemory()/1000F/1000);
        System.out.println("totalMemory="+Runtime.getRuntime().totalMemory()/1000F/1000);

    }
}
