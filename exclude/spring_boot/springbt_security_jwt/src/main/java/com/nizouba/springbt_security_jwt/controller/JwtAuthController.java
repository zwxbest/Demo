package com.tuowazi.demo.spring_boot.springbt_security_jwt.src.main.java.com.nizouba.springbt_security_jwt.controller;

import com.nizouba.springbt_security_jwt.model.entity.User;
import com.nizouba.springbt_security_jwt.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**

 */
@RestController
public class JwtAuthController {

    @Autowired
    private AuthService authService;

    // 登录
    @RequestMapping(value = "/authentication/login", method = RequestMethod.POST)
    public String createToken( String username,String password ) throws AuthenticationException {
        return authService.login( username, password );
    }

    // 注册
    @RequestMapping(value = "/authentication/register", method = RequestMethod.POST)
    public User register(@RequestBody User addedUser ) throws AuthenticationException {
        return authService.register(addedUser);
    }

}
