package com.tuowazi.demo.limit.simple;

/**
 * 漏桶限流
 */
public class LeakyBucketLimit {

    long timeStamp = System.currentTimeMillis();
    float capacity = 10;// 桶的容量，0。
    int rate = 1;//水漏出的速度,1秒漏水 10L
    float water = 8;//当前水量

    /**
     * 正常情况下是1s 1个请求。
     * 最高速度是1s 10个请求，正好等于桶的容量。
     *
     * @return
     */
    public boolean receiveRequest() {
        //先执行漏水，因为rate是固定的，所以可以认为“时间间隔*rate”即为漏出的水量
        long now = System.currentTimeMillis();
        water = Math.max(0, water - (now - timeStamp) / 1000f * rate);
        timeStamp = now;

        System.out.println("water is " + water);
        if (water <= capacity - 1) { // 水还未满，加水
            water++;
            return true;
        } else {
            return false;//水满，拒绝加水
        }
    }

    public static void main(String[] args) throws InterruptedException {

        LeakyBucketLimit limit = new LeakyBucketLimit();
        //        for (int i = 0; i < 10; i++) {
        //            System.out.println("test 1 ,request access " + i + " " + limit.receiveRequest());
        //            Thread.sleep(1000);
        //        }
        limit = new LeakyBucketLimit();
        for (int i = 0; i < 10; i++) {
            System.out.println("test 2 ,request access " + i + " " + limit.receiveRequest());
            Thread.sleep(500);
        }
    }
}
