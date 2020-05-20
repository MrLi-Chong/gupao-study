package com.test.service.serviceImpl;

import com.test.entity.User;
import com.test.mapper.UserMapper;
import com.test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2020/5/18 22:24
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public int insertUser(User user) {
        return mapper.insertUser(user);
    }

    @Override
    public List<User> queryUser(User user) {
        return mapper.queryUser(user);
    }
}
