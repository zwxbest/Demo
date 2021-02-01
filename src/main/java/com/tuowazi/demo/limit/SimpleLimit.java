package com.tuowazi.demo.limit;

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
        return (int) (time / 1000);
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
