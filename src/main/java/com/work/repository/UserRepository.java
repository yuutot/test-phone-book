package com.work.repository;

import com.work.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by yuuto on 3/10/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
