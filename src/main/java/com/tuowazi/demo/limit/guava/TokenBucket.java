package com.tuowazi.demo.limit.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 令牌桶
 */
public class TokenBucket {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    /**
     * permitsPerSecond为每秒生成的令牌
     *
     */
    /** 平衡稳定
     * * 创建一个稳定输出令牌的RateLimiter，保证了平均每秒不超过permitsPerSecond个请求
     * * 当请求到来的速度超过了permitsPerSecond，保证每秒只处理permitsPerSecond个请求
     * * 当这个RateLimiter使用不足()，会即请求到来速度小于permitsPerSecond囤积最多permitsPerSecond个请求
     */
    /**
     * 平衡预热
     * 创建一个稳定输出令牌的RateLimiter，保证了平均每秒不超过permitsPerSecond个请求
     * 还包含一个热身期(warmup period),热身期内，RateLimiter会平滑的将其释放令牌的速率加大，直到起达到最大速率
     * 同样，如果RateLimiter在热身期没有足够的请求(unused),则起速率会逐渐降低到冷却状态
     * 设计这个的意图是为了满足那种资源提供方需要热身时间，而不是每次访问都能提供稳定速率的服务的情况(比如带缓存服务，需要定期刷新缓存的)
     * 参数warmupPeriod和unit决定了其从冷却状态到达最大速率的时间
     */
    private static final RateLimiter rateLimiter = RateLimiter.create(10, 2L, TimeUnit.SECONDS);
    //private static final RateLimiter rateLimiter = RateLimiter.create(10);

    /**
     * tryAcquire尝试获取permit，默认超时时间是0，意思是拿不到就立即返回false
     *
     * @return
     */
    public String sayHello() {
        if (rateLimiter.tryAcquire()) {    //一次拿一个
            System.out.println(sdf.format(new Date()));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            return "no";
        }
        return "hello";
    }

    /**
     * acquire拿不到就等待,拿到为止
     *
     * @return
     */
    public String sayHi() {
        rateLimiter.acquire(1);  //一次拿5个  意思就是生成10个令牌才去全部拿去给一个请求
        System.out.println(sdf.format(new Date()));
        return "hi";
    }

    public static void main(String[] args) {
        TokenBucket tokenBucket = new TokenBucket();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override public void run() {
                    System.out.println(tokenBucket.sayHi());
                }
            }).start();
        }
        System.out.println("总花费:" + (System.currentTimeMillis() - start));
        System.out.println("线程执行完毕");
    }
}