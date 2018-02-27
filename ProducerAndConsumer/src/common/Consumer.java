package common;

/**
 * User:zhangweixiao
 * Description:
 */
public  class Consumer implements Runnable {

    private ShareResources shareResources;
    private String name;

    public Consumer(String consumername, ShareResources shareResources) {
        this.shareResources = shareResources;
        this.name=consumername;
    }

    @Override
    public void run() {
        while (true){
            shareResources.pop( name);
        }
    }
}