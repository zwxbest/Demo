package common;

/**
 * User:zhangweixiao
 * Description:
 */
public interface ShareResources{
    public  void push(String threadname,String name, String gender);
    public void pop(String name);
}
