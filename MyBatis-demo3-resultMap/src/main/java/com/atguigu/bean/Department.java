package com.atguigu.bean;

import java.util.List;


public class Department {
    private  Integer id;
    private  String name;
    private List<User> userList;

    public Department() {
    }

    public Department(Integer id, String name, List<User> userList) {
        this.id = id;
        this.name = name;
        this.userList = userList;
    }

    public Integer  getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
