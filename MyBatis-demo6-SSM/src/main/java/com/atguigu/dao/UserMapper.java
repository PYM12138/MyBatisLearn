package com.atguigu.dao;

import com.atguigu.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper   {
    public User getUser(Integer id);
    public List<User> getAllUser();

}
