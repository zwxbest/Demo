package sync;
import common.Resource;
import common.ShareResources;

import java.util.ArrayList;
import java.util.List;

public class ShareResourcesWithSync implements ShareResources {


    private int count= 0;
    private int capacity;
    private List<Resource> resources=new ArrayList<Resource>();
    private int number=0;

    public ShareResourcesWithSync(int capacity)
    {
        this.capacity=capacity;
    }

    synchronized public void push(String threadname,String name, String gender) {

        if (count==capacity) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        resources.add(new Resource(threadname,name,gender));
        count++;
        System.out.println("execute push *************threadname "+threadname+" name "+name+" gender "+gender+" count "+count);
        this.notifyAll();
    }

    synchronized public void pop(String name) {
        if(count==0)
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Resource resource=resources.remove(0);
        System.out.println("execute pop////////////"+number+++" && "+name+" ## "+resource.getThreadname()+" && "+resource.getName() +  " && " + resource.getGender()+" count "+count);
        count--;
        this.notifyAll();
    }
}

