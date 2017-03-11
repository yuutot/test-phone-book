package com.work.controller;

import com.work.entity.Phone;
import com.work.entity.User;
import com.work.repository.PhoneRepository;
import com.work.repository.UserRepository;
import com.work.service.Verify;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by yuuto on 3/10/17.
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PhoneController {

    @Autowired
    private Verify verify;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String homePage(Model model, Authentication authentication){
        if(authentication == null){
            return "index";
        }
        String userLogin = authentication.getName();
        User user = userRepository.findByLogin(userLogin).get();
        List<Phone> phones = phoneRepository.findByUser(user);
        model.addAttribute("phones",phones);
        return "index";
    }

    @RequestMapping(value = "/createPhone", method = RequestMethod.GET)
    public String createPhone(Model model){
        return "phone";
    }

    @RequestMapping(value = "/createPhoneHandler", method = RequestMethod.POST)
    public String createPhoneHandler(@RequestParam(value = "name") String name,
                                  @RequestParam(value = "surname") String surname,
                                  @RequestParam(value = "patronymic") String patronymic,
                                  @RequestParam(value = "mobile") String mobile,
                                  @RequestParam(value = "home",required = false) String phone,
                                  @RequestParam(value = "address", required = false) String address,
                                  @RequestParam(value = "email", required = false) String email,
                                  Authentication authentication,
                                  Model model){

        if(!verify.isValidName(name)){
            return "error";
        }
        if(!verify.isValidName(surname)){
            return "error";
        }
        if(!verify.isValidName(patronymic)){
            return "error";
        }
        if(!verify.isValidPhone(mobile)){
            return "error";
        }
        if(!phone.isEmpty() && !verify.isValidPhone(phone)){
            return "error";
        }
        if(!email.isEmpty() && !verify.isValidEmail(email)){
            return "error";
        }

        Phone entityPhone = new Phone();
        entityPhone.setName(name);
        entityPhone.setSurname(surname);
        entityPhone.setPatronymic(patronymic);
        entityPhone.setMobilePhone(mobile);
        entityPhone.setHomePhone(phone);
        entityPhone.setAddress(address);
        entityPhone.setEmail(email);
        String userLogin = authentication.getName();
        User user = userRepository.findByLogin(userLogin).get();
        entityPhone.setUser(user);
        phoneRepository.save(entityPhone);
        return "index";
    }
}
