package com.yuanjingyu.mapper;

import com.yuanjingyu.base.BaseTest;
import com.yuanjingyu.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserMapperTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void addUser() {
        User user = new User();
        user.setEmail("aa@1.com");
        user.setPassword("aa");
        userMapper.addUser(user);
        System.out.println(user);
    }


    @Test
    public void getUserEmailByUser() {
        User user = userMapper.getUserEmailByUser("111@111.com");
        System.out.println(user);

    }


}