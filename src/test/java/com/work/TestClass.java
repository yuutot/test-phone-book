package com.work;

import com.work.config.DataConfigTest;
import com.work.entity.Phone;
import com.work.entity.User;
import com.work.repository.PhoneRepository;
import com.work.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Optional;

/**
 * Created by yuuto on 3/12/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfigTest.class)
@WebAppConfiguration
public class TestClass {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Test
    public void testInsertionUser(){
        User user = new User();
        user.setName("Ivan");
        user.setSurname("Ivanov");
        userRepository.save(user);
        User testUser = userRepository.findOne(user.getId());
        Assert.assertEquals(user,testUser);
    }
    @Test
    public void testInsertionPhone(){
        User user = new User();
        user.setName("Ivan");
        user.setSurname("Ivanov");
        userRepository.save(user);
        Phone phone = new Phone();
        phone.setUser(user);
        phone.setName("Test");
        phoneRepository.save(phone);
        Phone phoneTest = phoneRepository.findOne(phone.getId());
        Assert.assertEquals(phone,phoneTest);
    }
    @Test
    public void testFindByUser(){
        User user = new User();
        user.setName("Petr");
        user.setSurname("Petrov");
        userRepository.save(user);
        Phone phone = new Phone();
        phone.setUser(user);
        Phone phone1 = new Phone();
        phone1.setUser(user);
        Phone phone2 = new Phone();
        phone2.setUser(user);
        phoneRepository.save(phone);
        phoneRepository.save(phone1);
        phoneRepository.save(phone2);
        List<Phone> phones = phoneRepository.findByUser(user);
        Assert.assertEquals(phones.size(),3);
    }

    @Test
    public void testFindByLogin(){
        User user = new User();
        user.setLogin("Test");
        user.setName("Ivan");
        userRepository.save(user);
        Optional<User> testUser = userRepository.findByLogin(user.getLogin());
        Assert.assertEquals(testUser.orElse(new User()),user);
    }

    @Test
    public void testUpdatePhone(){
        User user = new User();
        user.setName("Ivan");
        user.setSurname("Ivanov");
        userRepository.save(user);
        Phone phone = new Phone();
        phone.setUser(user);
        phone.setName("Test");
        phoneRepository.save(phone);
        phone.setName("Update");
        phoneRepository.save(phone);
        Phone phoneTest = phoneRepository.findOne(phone.getId());
        Assert.assertEquals(phone,phoneTest);
    }
}
