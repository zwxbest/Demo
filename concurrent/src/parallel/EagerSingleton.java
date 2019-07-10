package parallel;

/**
 * 饿汉单例模式
 * 缺点：无法控制单例初始化时机
 */
public class EagerSingleton {

    //第一点-必须是private
    private EagerSingleton()
    {
        System.out.println("EagerSingleton is create");
    }
    //第二点-必须是private
    private static EagerSingleton instance=new EagerSingleton();


    public static EagerSingleton getInstance()
    {
        return instance;
    }

}
