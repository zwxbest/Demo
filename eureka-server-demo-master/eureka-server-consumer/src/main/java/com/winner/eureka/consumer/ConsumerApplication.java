package com.winner.eureka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author llxiao
 * @version 1.0, 2018/12/11 14:01
 * @since JDK 1.8
 */
@SpringBootApplication(scanBasePackages = {"com.winner.eureka.common.aspect","com.winner.eureka.consumer"})
@EnableEurekaClient
//开启fegin
@EnableFeignClients
// 开启熔断功能
@EnableCircuitBreaker
public class ConsumerApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
