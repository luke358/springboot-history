package com.zhu.service;

import com.zhu.Mapper.UserDao;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    //利用set进行动态实现值得注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
