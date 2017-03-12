package com.work.repository;

import com.work.entity.Phone;
import com.work.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by yuuto on 3/10/17.
 */
public interface PhoneRepository extends JpaRepository<Phone, Long> {
    List<Phone> findByUser(User user);

    @Query(value = "select u from Phone u where u.user = ?1 and (u.name like CONCAT('%',?2, '%') " +
            "or u.surname like CONCAT('%',?2, '%') or u.patronymic like CONCAT('%',?2, '%') " +
            "or u.mobilePhone like CONCAT('%',?2, '%') or u.homePhone like CONCAT('%',?2, '%') " +
            "or u.address like CONCAT('%',?2, '%') or u.email like CONCAT('%',?2, '%'))")
    List<Phone> searchByExpr(User user, String expr);
}
