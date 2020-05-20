package com.test.mapper;

import com.test.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insertUser(User user);

    List<User> queryUser(User user);
}
