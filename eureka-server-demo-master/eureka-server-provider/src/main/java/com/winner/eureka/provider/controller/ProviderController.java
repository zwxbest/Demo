package com.winner.eureka.provider.controller;

import com.winner.eureka.provider.feign.ConsumerFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author llxiao
 * @version 1.0, 2018/12/11 14:17
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/provider")
public class ProviderController
{
    @Autowired
    private ConsumerFeignService consumerFeginService;

    @RequestMapping("/provider")
    public String provider(){
        return "Hello provider!!!!";
    }

    @RequestMapping("/consumer")
    public String consumer(){
        return consumerFeginService.consumer();
    }
}
