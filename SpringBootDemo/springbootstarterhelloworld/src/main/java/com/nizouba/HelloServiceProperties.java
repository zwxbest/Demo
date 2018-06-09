package com.nizouba;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by zwxbest on 2018/5/13.
 */
@ConfigurationProperties(prefix = "hello")
@Getter @Setter
public class HelloServiceProperties {

    private static final String MSG="world";

    //若不设置msg，默认msg=MSG
    private String msg=MSG;

}
