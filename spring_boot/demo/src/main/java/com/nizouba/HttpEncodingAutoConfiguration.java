package com.nizouba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * Created by zwxbest on 2018/5/12.
 */
@Configuration
@EnableConfigurationProperties(HttpEncodingProperties.class)
@ConditionalOnClass(CharacterEncodingFilter.class)
@ConditionalOnProperty(prefix = "spring.http.encoding",value = "enabled",matchIfMissing = true)
public class HttpEncodingAutoConfiguration {

    @Autowired
    private HttpEncodingProperties httpEncodingProperties;

    @Bean
    @ConditionalOnMissingBean(CharacterEncodingFilter.class)
    public CharacterEncodingFilter characterEncodingFilter()
    {
        CharacterEncodingFilter filter=new OrderedCharacterEncodingFilter();
        filter.setEncoding(this.httpEncodingProperties.getCharset().name());
        filter.setForceEncoding(this.httpEncodingProperties.isForce());
        return filter;
    }

}
