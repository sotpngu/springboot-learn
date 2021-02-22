package com.example.learn.controller;

import com.example.learn.enumeration.SexEnum;
import com.example.learn.pojo.User;
import com.example.learn.service.impl.JdbcTmplUserServiceImpl;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JdbcUserController {

    @Autowired
    JdbcTmplUserServiceImpl jdbcTmplUserService;

    @RequestMapping("jdbcGetUser")
    public Map<String, Object> jdbcGetUser(Long id) {
        User user = jdbcTmplUserService.getUser(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", user.getId());
        map.put("userName", user.getUserName());
        map.put("sex", user.getSex().getName());
        map.put("note", user.getNote());
        return map;
    }

    @RequestMapping("jdbcFindUsers")
    public List<Object> jdbcFindUsers(String userName, String note) {
        List<User> userList = jdbcTmplUserService.findUsers(userName, note);
        List<Object> resultList = new ArrayList<>();
        for (User user : userList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", user.getId());
            map.put("userName", user.getUserName());
            map.put("sex", user.getSex().getName());
            map.put("note", user.getNote());
            resultList.add(map);
        }
        return resultList;
    }

    @RequestMapping("jdbcInsertUser")
    public Map<String, Object> jdbcInsertUser(String userName, Integer sex, String note) {
        User user = new User();
        user.setUserName(userName);
        user.setSex(SexEnum.getEnumById(sex));
        user.setNote(note);
        int result =  jdbcTmplUserService.insertUser(user);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("success", result == 1);
        return resultMap;
    }

    @RequestMapping("jdbcUpdatetUser")
    public Map<String, Object> jdbcUpdatetUser(Long id, String userName, Integer sex, String note) {
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setSex(SexEnum.getEnumById(sex));
        user.setNote(note);
        int result = jdbcTmplUserService.updateUser(user);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("success", result == 1);
        return resultMap;
    }

    @RequestMapping("jdbcDeleteUser")
    public Map<String, Object> jdbcDeleteUser(Long id) {
        int result = jdbcTmplUserService.deleteUser(id);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("success", result == 1);
        return resultMap;
    }

    @RequestMapping("jdbcGetUser2")
    public Map<String, Object> jdbcGetUser2(Long id) {
        User user = jdbcTmplUserService.getUser2(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", user.getId());
        map.put("userName", user.getUserName());
        map.put("sex", user.getSex().getName());
        map.put("note", user.getNote());
        return map;
    }

    @RequestMapping("jdbcGetUser3")
    public Map<String, Object> jdbcGetUser3(Long id) {
        User user = jdbcTmplUserService.getUser3(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", user.getId());
        map.put("userName", user.getUserName());
        map.put("sex", user.getSex().getName());
        map.put("note", user.getNote());
        return map;
    }

}
