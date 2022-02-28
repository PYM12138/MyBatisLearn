package com.atguigu.service;

import com.atguigu.bean.User;
import com.atguigu.dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    //批量执行
    @Autowired
    private SqlSession session;

    public List<User> getUsers(){
       /* UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.getUser()*/
        return userMapper.getAllUser();
    }



}
