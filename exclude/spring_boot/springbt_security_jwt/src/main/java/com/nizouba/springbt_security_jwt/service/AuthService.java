package com.tuowazi.demo.spring_boot.springbt_security_jwt.src.main.java.com.nizouba.springbt_security_jwt.service;

import com.nizouba.springbt_security_jwt.model.entity.User;

/**

 */
public interface AuthService {

    User register(User userToAdd );
    String login( String username, String password );
}
