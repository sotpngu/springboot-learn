package com.example.learn.validator.impl;

import com.example.learn.pojo.User;
import com.example.learn.validator.UserValidator;

public class UserValidatorImpl implements UserValidator {

    @Override
    public boolean validate(User user) {
        System.out.println("引入新的接口：" + UserValidator.class.getSimpleName());
        return user != null;
    }

}
