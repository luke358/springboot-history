package com.nue.javaweb1.service.impl;

import com.nue.javaweb1.dao.UserDao;
import com.nue.javaweb1.dao.impl.UserDaoImpl;
import com.nue.javaweb1.pojo.User;
import com.nue.javaweb1.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao =new UserDaoImpl();
	@Override
	public boolean regist(User user) {
		// 1.如果用户名重复 那么页面中需要显示出用户名存在
		
		//2。执行注册方法
		int result = userDao.addUser(user);
		//注册结果 返回值0以上 认为注册成功 返回true
		if(result>0) {
			return true;
		}
		return false;
	}

}
