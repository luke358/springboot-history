package com.zhu.dao;

import com.zhu.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> like(String value);


    //获取全部用户
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    User getUserById2(Map<String,Object> map);
    //添加用户
    int addUser(User user);

    //万能map
    int addUser2(Map<String,Object> map);

    //修改用户
    int updateUser(User user);

    //修改用户
    int deleteUser(int id);
}
