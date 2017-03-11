package com.work.service.impl;

import com.work.entity.User;
import com.work.repository.UserRepository;
import com.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by yuuto on 3/10/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(String login) {
        return userRepository.findByLogin(login).orElseThrow(()->new UsernameNotFoundException(login));
    }

}