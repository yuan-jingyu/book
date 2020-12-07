package com.yuanjingyu.mapper;

import com.yuanjingyu.entity.User;

/**
 * 用户接口持久层
 */
public interface UserMapper {

    /*添加用户*/
    void addUser(User user);

    /*根据用户邮箱查询用户*/
    User getUserEmailByUser(String email);


}
