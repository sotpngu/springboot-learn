package com.example.learn.controller;

import com.example.learn.dao.JpaUserRepository;
import com.example.learn.pojo.JpaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import java.util.List;

@RestController
@RequestMapping("/jpa")
public class JpaUserController {

    @Autowired
    private JpaUserRepository jpaUserRepository = null;

    @RequestMapping("/getUser")
    public JpaUser getUser(Long id) {
        JpaUser user = jpaUserRepository.findById(id).get();
        return user;
    }

    @RequestMapping("/findUsers")
    public List<JpaUser> findUsers(String userName, String note) {
        return jpaUserRepository.findUsers(userName, note);
    }

    @RequestMapping("/findByUserNameLike")
    public List<JpaUser> findByUserNameLike(String userName) {
        return jpaUserRepository.findByUserNameLike("%" + userName + "%");
    }

    @RequestMapping("/getUserById")
    public JpaUser getUserById(Long id) {
        return jpaUserRepository.getUserById(id);
    }

    @RequestMapping("/findByUserNameLikeOrNoteLike")
    public List<JpaUser> findByUserNameLikeOrNoteLike(String userName, String note) {
        return jpaUserRepository.findByUserNameLikeOrNoteLike("%" + userName + "%", "%" + note + "%");
    }

}
