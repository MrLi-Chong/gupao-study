package com.test.service;

import com.test.entity.User;

import java.util.List;

public interface IUserService {
    int insertUser(User user);

    List<User> queryUser(User user);
}
