package com.atguigu.dao;

import com.atguigu.bean.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //增删改查

//    public User getUserById(Integer id);
//    public Boolean addUser(User user);
//    public Boolean updateUser(User user);
//    public Boolean deleteUser(Integer id);


    //当有多个参数的时候，使用命名参数
    //不使用命名参数，#{默认是索引或者是param1 ...paramN}
    //当查询条件符合javaBean的时候也可以直接传入javaBean去查询
    /*
    * 1.使用@param
    * 2.在形参写一个map集合，然后在使用的时候创建一个map集合，写好键值对传入即可
    * 3.pojo
    * 4.抽象一个TO (Transfer Object)数据传输对象
    * */
    //    public User getUserByIdAndName(@Param("id")Integer id,@Param("name")String name);
//    public User getUserByUser(User user);
    /*
    * 如果形参位置是list集合或者collection集合或者数组
    * 在#{list[]\collection[]\array[]} []里面写索引就可以取值了
    * */
    //模糊查询，返回多条数据-->list集合
//    public List<User> getUsersLikeName(String name);

    //查询一条数据，封装成map集合 String为当前的列名，Object是当前的列值
//    public Map<String,Object> getUserByIdMap(Integer id);

    //查询多条数据，封装成map集合，Integer为当前的id ,User是value类型
//    @MapKey("id")//指定当前的key是User.id属性
//    public Map<Integer,User> getUserByNameMap(String name);

   public User getUserById1(Integer id);
   public User getUserAndDeptById(Integer id);
   //查询员工和他的部门信息
   public User getUserAndDeptByStepOne(Integer id);





}
