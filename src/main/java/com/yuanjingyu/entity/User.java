package com.yuanjingyu.entity;

/**
 * 用户表
 */
public class User {

    private Integer userId;     //用户id;
    private String email;       //用户邮箱
    private String password;    //用户密码
    private String salt;        //盐值

    public User() {
    }

    public User(Integer userId, String email, String password, String salt) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.salt = salt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "user{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
