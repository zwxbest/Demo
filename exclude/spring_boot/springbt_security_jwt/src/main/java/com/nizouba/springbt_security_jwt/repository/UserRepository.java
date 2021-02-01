package com.tuowazi.demo.spring_boot.springbt_security_jwt.src.main.java.com.nizouba.springbt_security_jwt.repository;

import com.nizouba.springbt_security_jwt.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**

 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername( String username );
}
