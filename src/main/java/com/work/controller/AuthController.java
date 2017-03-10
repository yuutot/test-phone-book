package com.work.controller;

import com.work.entity.User;
import com.work.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by yuuto on 3/10/17.
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/create/{login}/{password}")
    public String createUser(Map<String, Object> model,
                             @PathVariable String login,
                             @PathVariable String password) {
        User user = new User();
        user.setLogin(login);
        user.setPass(password);
        userRepository.save(user);
        user = userRepository.findOne(user.getId());
        model.put("user", user);
        return "userCreate";
    }

}
