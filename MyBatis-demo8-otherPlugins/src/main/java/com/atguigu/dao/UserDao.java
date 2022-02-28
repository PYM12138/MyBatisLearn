package com.atguigu.dao;

import com.atguigu.bean.User;

import java.util.List;

public interface UserDao {
    public User getUserById(Integer id);
    public List<User> getAllUser();
}
