import common.Consumer;
import common.Producer;
import common.ShareResources;
import lock.ShareResourcesWithLock;
import sync.ShareResourcesWithSync;

public class Main {

    public static void main(String[] args) {
        ShareResources shareResources = new ShareResourcesWithSync(3);
        MultiProducerAndMultiConsumer(shareResources);
    }

    /**
     * one producer and one consumer
     *
     * @param shareResources
     */
    public static void oneProducerAndOneConsumer(ShareResources shareResources) {
        new Thread(new Producer("one_producer", shareResources)).start();
        new Thread(new Consumer("one_consumer", shareResources)).start();
    }

    /**
     * multi producer and one consumer
     *
     * @param shareResources
     */
    public static void MultiProducerAndOneConsumer(ShareResources shareResources) {
        new Thread(new Producer("producer1", shareResources)).start();
        new Thread(new Producer("producer2", shareResources)).start();
        new Thread(new Producer("producer3", shareResources)).start();
        new Thread(new Consumer("one_consumer", shareResources)).start();
    }

    /**
     * one producer and multi consumer
     *
     * @param shareResources
     */
    public static void OneProducerAndMultiConsumer(ShareResources shareResources) {
        new Thread(new Producer("producer_only", shareResources)).start();
        new Thread(new Consumer("consumer1", shareResources)).start();
        new Thread(new Consumer("consumer2", shareResources)).start();
        new Thread(new Consumer("consumer3", shareResources)).start();
    }

    /**
     * multi producer and multi consumer
     *
     * @param shareResources
     */
    public static void MultiProducerAndMultiConsumer(ShareResources shareResources) {
        new Thread(new Producer("producer1", shareResources)).start();
        new Thread(new Producer("producer2", shareResources)).start();
        new Thread(new Consumer("consumer1", shareResources)).start();
        new Thread(new Consumer("consumer2", shareResources)).start();
    }

}
