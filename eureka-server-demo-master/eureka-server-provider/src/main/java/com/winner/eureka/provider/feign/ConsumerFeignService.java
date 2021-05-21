package com.winner.eureka.provider.feign;

import com.winner.eureka.common.Constans;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author llxiao
 * @version 1.0, 2018/12/11 14:18
 * @since JDK 1.8
 */
@FeignClient(value = Constans.CONSUMER_SERVICE)
public interface ConsumerFeignService
{
    @RequestMapping("/consumer/consumer")
    String consumer();
}
