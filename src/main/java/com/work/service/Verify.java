package com.work.service;

/**
 * Created by yuuto on 3/11/17.
 */
public interface Verify {
    boolean isValidName(String name);
    boolean isValidPhone(String phone);
    boolean isValidLogin(String login);
    boolean isValidPassword(String password);
    boolean isValidEmail(String email);
}
