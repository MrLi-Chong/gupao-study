package com.test.controller;

import com.test.entity.User;
import com.test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Administrator
 * @Date 2020/5/18 22:23
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/add")
    public void saveUser(@RequestBody User user){
        userService.insertUser(user);
    }

    @PostMapping("/query")
    public String querUser(){
        User user = new User();
        user.setUserid("1");
        return "";
    }
}
