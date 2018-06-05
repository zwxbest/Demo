package parallel;

import org.omg.CORBA.OMGVMCID;

/**
 * 懒汉
 * 缺点：加锁影响性能
 */
public class LazySingleton {

    private LazySingleton()
    {
        System.out.println("LazySingleton is create");
    }
    private static LazySingleton instance=null;

    public static synchronized LazySingleton getInstace()
    {
        if(instance==null)
        {
            instance=new LazySingleton();
        }
        return instance;
    }
}
