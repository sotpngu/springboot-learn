package com.example.learn.validator;

import com.example.learn.pojo.User;

public interface UserValidator {

    // 检测用户对象是否为空
    public boolean validate(User user);

}
