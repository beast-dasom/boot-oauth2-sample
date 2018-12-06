package com.web.repository;

import com.web.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : taeyoung
 * @since : 2018-12
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
