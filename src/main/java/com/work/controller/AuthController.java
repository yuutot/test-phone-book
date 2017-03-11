package com.work.controller;

import com.work.entity.User;
import com.work.repository.UserRepository;
import com.work.service.Verify;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yuuto on 3/10/17.
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Verify verify;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model){
        return "register";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String registerHandler(@RequestParam(value = "username") String username,
                                  @RequestParam(value = "password") String password,
                                  @RequestParam(value = "name") String name,
                                  @RequestParam(value = "surname") String surname,
                                  @RequestParam(value = "patronymic") String patronymic,
                                  Model model){

        if(!verify.isValidLogin(username)){
            return "error";
        }
        if(!verify.isValidPassword(password)){
            return "error";
        }
        if(!verify.isValidName(name)){
            return "error";
        }
        if(!verify.isValidName(surname)){
            return "error";
        }
        if(!verify.isValidName(patronymic)){
            return "error";
        }
        User user = userRepository.findByLogin(username).orElse(new User());
        if(!user.equals(new User())){
            return "error";
        }
        user.setLogin(username);
        MessageDigest crypt;
        try {
            crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
            String pass = new BigInteger(1, crypt.digest()).toString(16);
            user.setPass(pass);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        user.setName(name);
        user.setSurname(surname);
        user.setPatronymic(patronymic);
        userRepository.save(user);
        user = userRepository.findOne(user.getId());
        model.addAttribute("user", user);
        return "userCreate";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public String loginPage(Model model){
        return "login";
    }



}
