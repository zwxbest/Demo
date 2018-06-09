package parallel;

/**
 * 温和单例模式
 * 不饿不懒
 */
public class WarmSingleton {

    private WarmSingleton()
    {
        System.out.println("WarmSingleton is create");
    }

    /**
     * 内部类不会在外部类被调用的时候实例化
     */
    private static class  SingletonHolder
    {
        private static WarmSingleton instance=new WarmSingleton();
    }

    public static WarmSingleton getInstance()
    {
        return SingletonHolder.instance;
    }

}
