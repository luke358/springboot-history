package com.neu.jdbc1.test;

import com.neu.jdbc1.dao.UserDao;
import com.neu.jdbc1.dao.impl.UserDaoImpl;
import com.neu.jdbc1.pojo.User;

public class TestFun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User(1001,"С��","123","��","������");
		UserDao userDao = new UserDaoImpl();
		int result = userDao.addUser(user);
		System.out.println("������:"+result+"������");
	}

}
