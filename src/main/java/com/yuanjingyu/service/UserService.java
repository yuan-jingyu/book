package com.yuanjingyu.service;

import com.yuanjingyu.entity.User;

/**
 * 用户接口
 */
public interface UserService {
    /*添加用户*/
    void addUser(User user);
    /*根据用户邮箱查询用户*/
    User getUserEmailByUser(String email);

}
