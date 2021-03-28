package com.tuowazi.demo.limit.simple;

/**
 * 令牌桶算法
 * 令牌桶是恒定的存token
 * 而漏桶是恒定的漏token
 *
 *两者面对大流量，令牌桶把token取完就拒绝了
 * 漏桶把漏斗塞满就拒绝了。
 */
public class TokenLimit {

    long timeStamp = getNowTime();
    int capacity; // 桶的容量
    int rate;//令牌放入速度
    int tokens;//当前水量

    public boolean control() {
        //先执行添加令牌的操作
        long now = getNowTime();
        tokens = (int)Math.max(capacity, tokens + (now - timeStamp) * rate);
        timeStamp = now;   //令牌已用完，拒绝访问

        if (tokens < 1) {
            return false;
        } else {//还有令牌，领取令牌
            tokens--;
            return true;
        }
    }

    public static int getNowTime() {
        long time = System.currentTimeMillis();
        return (int)(time / 1000);
    }
}
