package com.yuanjingyu.service;

import com.yuanjingyu.base.BaseTest;
import com.yuanjingyu.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceTest extends BaseTest {
    @Autowired
    private UserService userService;
    @Test
    public void addUser() {
        User user = new User();
        user.setEmail("11@11.com");
        user.setPassword("111");
        userService.addUser(user);
    }

    @Test
    public void getUserEmailByUser() {
    }
}