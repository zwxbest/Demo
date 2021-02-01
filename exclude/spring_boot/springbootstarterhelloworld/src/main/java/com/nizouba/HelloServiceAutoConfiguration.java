package com.tuowazi.demo.spring_boot.springbootstarterhelloworld.src.main.java.com.nizouba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zwxbest on 2018/5/13.
 */
@Configuration
@EnableConfigurationProperties(HelloServiceProperties.class)
@ConditionalOnClass(HelloService.class)//当类路径下有指定的类
@ConditionalOnProperty(prefix = "hello",value = "enabled",matchIfMissing = true)//如果不存在也匹配，自动配置这个bean
public class HelloServiceAutoConfiguration {

    @Autowired
    private HelloServiceProperties helloServiceProperties;
    @Bean
    @ConditionalOnMissingBean(HelloService.class)
    public HelloService helloService()
    {
        HelloService helloService=new HelloService();
        helloService.setMsg(helloServiceProperties.getMsg());
        return helloService;
    }
}
