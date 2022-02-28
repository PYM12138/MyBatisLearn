package com.atguigu.dao;

import com.atguigu.bean.Department;

public interface DepartmentMapper {
    public Department getDeptByID(Integer id);
    //查询一个部门下的所有员工
    public Department getDeptByIdReturnUsers(Integer id);
    //查询一个部门下的所有员工(分步查询)
    public Department getDeptByIdWithUser(Integer id);
}
