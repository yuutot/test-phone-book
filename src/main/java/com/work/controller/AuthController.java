package com.work.controller;

import com.work.entity.User;
import com.work.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * Created by yuuto on 3/10/17.
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/create/{login}/{password}", method = RequestMethod.GET)
    public String createUser(Map<String, Object> model,
                             @PathVariable String login,
                             @PathVariable String password) {
        User user = new User();
        user.setLogin(login);
        MessageDigest crypt = null;
        try {
            crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
            String pass = new BigInteger(1, crypt.digest()).toString(16);
            user.setPass(pass);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        userRepository.save(user);
        user = userRepository.findOne(user.getId());
        model.put("user", user);
        return "userCreate";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model){
        return "welcome";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String homePage(Model model){
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public String loginPage(Model model){
        return "login";
    }



}
