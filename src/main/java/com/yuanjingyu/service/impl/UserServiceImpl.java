package com.yuanjingyu.service.impl;

import com.yuanjingyu.entity.User;
import com.yuanjingyu.mapper.UserMapper;
import com.yuanjingyu.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 员工登录实习类
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        String salt =Math.random()+"";
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), salt ,1024);
        user.setSalt(salt);
        String newPassword=md5Hash.toHex();
        user.setPassword(newPassword);
        userMapper.addUser(user);
    }

    @Override
    public User getUserEmailByUser(String email) {
        return userMapper.getUserEmailByUser(email);
    }
}
