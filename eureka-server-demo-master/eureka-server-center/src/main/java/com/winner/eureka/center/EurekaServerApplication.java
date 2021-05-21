package com.winner.eureka.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author llxiao
 * @version 1.0, 2018/12/11 13:57
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
