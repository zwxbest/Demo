package com.tuowazi.demo.spring_boot.springbt_security_jwt.src.test.java.com.nizouba.springbt_security_jwt;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by zwxbest on 2019/3/17.
 */
public class CalculatePwd {

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Test
    public void test(){
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);
    }
}
