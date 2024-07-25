

package com.mahadev.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mahadev.login.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}