package com.work.repository;

import com.work.entity.Phone;
import com.work.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by yuuto on 3/10/17.
 */
public interface PhoneRepository extends JpaRepository<Phone, Long> {
    List<Phone> findByUser(User user);
}
