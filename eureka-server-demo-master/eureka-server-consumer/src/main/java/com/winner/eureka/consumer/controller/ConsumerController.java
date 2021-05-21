package com.winner.eureka.consumer.controller;

import com.winner.eureka.consumer.feign.ProviderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author llxiao
 * @version 1.0, 2018/12/11 14:19
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController
{
    @Autowired
    private ProviderFeignService providerFeginService;

    @RequestMapping("/provider")
    public String provider(){
        return providerFeginService.provider();
    }

    @RequestMapping("/consumer")
    public String consumer(){
        return "Hello consumer!!";
    }
}
