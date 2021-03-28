package com.tuowazi.demo.limit.simple;

/**
 * 该算法实现看似确实完美的实现了“单位时间内最大访问量控制”，
 * 但它在两个单位时间的临界值上的处理是有缺陷的。
 * 如：设需要控制的最大请求数为1w, 在第一个单位时间（0-10s）的最后一秒（即第9s）里达到的请求数为1w,接下来第二个单位时间（10-20s）的第一秒（即第10s）里达到请求数也是1w,
 * 由于超时重置发生在两个单位时间之间，所以这2w个请求都将通过控制，也就是说在2s里处理2w个请求，与我们设置的10s里1w个请求的设想是相违背。
 */
public class SimpleLimit {
    long timeStamp = getNowTime();
    int reqCount = 0;

    int maxReqCount = 10;//时间周期内最大请求数

    long effectiveDuration = 1;//时间控制周期

    public boolean receiveRequest() {
        long now = getNowTime();
        if (now < timeStamp + effectiveDuration) {//在时间控制范围内
            reqCount++;
            return reqCount <= maxReqCount;//当前时间范围内超过最大请求控制数
        } else {
            timeStamp = now;//超时后重置
            reqCount = 0;

            return true;
        }

    }

    public static int getNowTime() {
        long time = System.currentTimeMillis();
        return (int)(time / 1000);
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleLimit limit = new SimpleLimit();
        //前10个可以成功
        //第11-13或者14应该是被限流了
        //之后周期被重启，可以成功
        for (int i = 0; i < 20; i++) {
            System.out.println("the request " + i + "is accept?" + limit.receiveRequest());
            Thread.sleep(70);
        }
    }

}
