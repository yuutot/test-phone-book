package com.work.repository;

import com.work.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yuuto on 3/10/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
