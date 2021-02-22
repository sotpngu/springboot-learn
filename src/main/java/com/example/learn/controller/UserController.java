package com.example.learn.controller;

import com.example.learn.pojo.User;
import com.example.learn.service.UserService1;
import com.example.learn.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//测试 aspect/MyAspect.class
@RestController
@RequestMapping("/user")
public class UserController {

    // 注入用户服务
    @Autowired
    private UserService1 userService1 = null;

    // 定义请求
    @RequestMapping("print")
    public User printUser(Long id, String userName, String note) {
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setNote(note);
        userService1.printUser(user);
        return user;
    }

    // 测试引入的验证器
    @RequestMapping("/vp")
    public User validateAndPrint(Long id, String userName, String note) {
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setNote(note);
        //  强制转换
        UserValidator userValidator = (UserValidator) userService1;
        // 验证用户是否为空
        if (userValidator.validate(user)) {
            userService1.printUser(user);
        }
        return user;
    }

    // 测试多个切面顺序
    @RequestMapping("/manyAspects")
    public String manyAspects() {
        userService1.manyAspects();
        return "manyAspects";
    }

}
