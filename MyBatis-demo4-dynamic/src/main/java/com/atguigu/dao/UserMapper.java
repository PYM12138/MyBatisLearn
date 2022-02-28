package com.atguigu.dao;

import com.atguigu.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper  {
    public List<User> getUserIf(User user);
    public  List<User> getUserChoose(User user);
    public  void updateUser(User user);
    public List<User> getUserCollection(List<Integer> id);
//    public Boolean insertUserMap(@Param("mss") Map<String,String> mss);
    public boolean insertUsersList( List<User> userList);
    public List<User> getUserBind(User user);
}
