package com.zhu.dao;

import com.zhu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {



    //获取id用户
    User queryUsersById(@Param("id") int id);


    int updateUser(User user);
}
