package com.neu.jdbc1.test;



import com.neu.jdbc1.dao.UserDao;
import com.neu.jdbc1.dao.impl.UserDaoImpl;
import com.neu.jdbc1.pojo.User;
import org.junit.jupiter.api.Test;

class UserDaoImplTest {

	@Test
	void testAddUser() {
		User user = new User(1001,"小刘","123","男","唱、跳");
		UserDao userDao = new UserDaoImpl();
		int result = userDao.addUser(user);
		System.out.println("操作了:"+result+"条数据");
	}

	
	@Test
	void testAddUser2() {
		User user = new User(1001,"Neu","123","女","唱、跳、玩");
		UserDao userDao = new UserDaoImpl();
		int result = userDao.addUser2(user);
		System.out.println("操作了:"+result+"条数据");
	}
	
	@Test
	void updatePwdById() {
		User user = new User();
		user.setId(2);//修改的编号
		user.setPwd("123456");//将原始密码修改成123456
		UserDao userDao = new UserDaoImpl();
		int result = userDao.updatePwdById(user);
		System.out.println("操作了:"+result+"条数据");
	}
	@Test
	void delUserById() {
		int id = 2;//指定要删除的用户编号
		UserDao userDao = new UserDaoImpl();
		int result = userDao.delUserById(id);
		System.out.println("操作了:"+result+"条数据");
	}
}
