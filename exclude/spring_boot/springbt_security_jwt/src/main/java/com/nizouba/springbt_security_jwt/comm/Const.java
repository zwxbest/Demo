package com.tuowazi.demo.spring_boot.springbt_security_jwt.src.main.java.com.nizouba.springbt_security_jwt.comm;

/**

 */
public class Const {

    public static final long EXPIRATION_TIME = 432_000_000;     // 5天(以毫秒ms计)
    public static final String SECRET = "zwxbest";      // JWT密码
    public static final String TOKEN_PREFIX = "Bearer";         // Token前缀
    public static final String HEADER_STRING = "Authorization"; // 存放Token的Header Key
}
