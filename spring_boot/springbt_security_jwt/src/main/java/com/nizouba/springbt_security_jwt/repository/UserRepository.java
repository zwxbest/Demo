package com.nizouba.springbt_security_jwt.repository;

import com.nizouba.springbt_security_jwt.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**

 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername( String username );
}
