package com.work.service.impl;

import com.work.service.Verify;

import java.util.regex.Pattern;

/**
 * Created by yuuto on 3/11/17.
 */
public class VerifyImpl implements Verify {
    @Override
    public boolean isValidName(String name) {
        return (name.length() >= 4 && Pattern.compile("^[a-zA-Z\\s\\-]+$").matcher(name).matches());
    }

    @Override
    public boolean isValidPhone(String phone) {
        return (phone.length() == 15 && Pattern.compile("^\\+380\\([\\d]{2}\\)[\\d]{7}$").matcher(phone).matches());
    }

    @Override
    public boolean isValidLogin(String login) {
        return (login.length() >= 3 && Pattern.compile("^[a-zA-Z]+$").matcher(login).matches());
    }

    @Override
    public boolean isValidPassword(String password) {
        return password.length() >= 5;
    }

    @Override
    public boolean isValidEmail(String email) {
        return Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matcher(email).matches();
    }
}
