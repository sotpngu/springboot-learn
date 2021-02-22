package com.example.learn.service.impl;

import com.example.learn.pojo.User;
import com.example.learn.service.UserService1;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService1 {

    @Override
    public void printUser(User user) {
        if (user == null) {
            throw new RuntimeException("用户参数不能为空...");
        }
        System.out.println("id = " + user.getId());
        System.out.println("\tusername = " + user.getUserName());
        System.out.println("\tnote = " + user.getNote());
    }

    @Override
    public void manyAspects() {
        System.out.println("测试多个切面顺序");
    }


}
