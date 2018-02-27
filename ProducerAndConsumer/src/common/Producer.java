package common;

import lock.ShareResourcesWithLock;

/**
 * User:zhangweixiao
 * Description:
 */
public class Producer implements Runnable {

    private ShareResources shareResources;
    private String name;
    private int count=0;
    private int producer_count=200;//the number of production

    public Producer(String name, ShareResources shareResources) {
        this.shareResources = shareResources;
        this.name=name;
    }


    @Override
    public void run() {
        while (count<producer_count){
            if (count % 3 == 0)
                shareResources.push( name,"dog", "man");
            else if(count%3==1)
                shareResources.push(name,"cat", "girl");
            else
            shareResources.push(name,"datg", "bisex");
            count++;
        }
    }
}