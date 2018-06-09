package com.nizouba;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by zwxbest on 2018/5/13.
 */
@Getter @Setter
public class HelloService {

    private String msg;
    public String sayHello()
    {
        return "hello "+msg;
    }

}
