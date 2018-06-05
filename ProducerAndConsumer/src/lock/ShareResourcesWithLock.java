package lock;

import common.ShareResources;
import common.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShareResourcesWithLock implements ShareResources {


    private int count= 0;
    private int capacity;//the size of shared resources
    private List<Resource> resources=new ArrayList<Resource>();
    private int number=0;//number to statistics
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();

    public ShareResourcesWithLock(int capacity)
    {
        this.capacity=capacity;
    }

    public void push(String threadname,String name, String gender) {
        lock.lock();
        try {
            if (count==capacity) {
                condition.await();
            }
            resources.add(new Resource(threadname,name,gender));
            count++;
            System.out.println("execute push*************");
            condition.signalAll();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }


    }

    public void pop(String name) {
        lock.lock();
        try {
            if(count==0)
            {
                condition.await();
            }
            Resource resource=resources.remove(0);
            System.out.println(number+++" && "+name+" ## "+resource.getThreadname()+" && "+resource.getName() +  " && " + resource.getGender());
            count--;
            condition.signalAll();
            System.out.println("execute pop////////////");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }

    }
}



