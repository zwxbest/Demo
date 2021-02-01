package com.tuowazi.demo.spring_boot.demo.src.main.java.com.nizouba;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.charset.Charset;

/**
 * Created by zwxbest on 2018/5/12.
 */
@Getter @Setter
@ConfigurationProperties(prefix = "com.nizouba.spring.http.encoding")
public class HttpEncodingProperties {

    public static final Charset DEFAULT_CHARSET=Charset.forName("UTF-8");
    private Charset charset=DEFAULT_CHARSET;
    private boolean force=true;

}
