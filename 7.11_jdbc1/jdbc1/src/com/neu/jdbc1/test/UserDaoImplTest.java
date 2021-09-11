package com.neu.jdbc1.test;



import com.neu.jdbc1.dao.UserDao;
import com.neu.jdbc1.dao.impl.UserDaoImpl;
import com.neu.jdbc1.pojo.User;
import org.junit.jupiter.api.Test;

class UserDaoImplTest {

	@Test
	void testAddUser() {
		User user = new User(1001,"С��","123","��","������");
		UserDao userDao = new UserDaoImpl();
		int result = userDao.addUser(user);
		System.out.println("������:"+result+"������");
	}

	
	@Test
	void testAddUser2() {
		User user = new User(1001,"Neu","123","Ů","����������");
		UserDao userDao = new UserDaoImpl();
		int result = userDao.addUser2(user);
		System.out.println("������:"+result+"������");
	}
	
	@Test
	void updatePwdById() {
		User user = new User();
		user.setId(2);//�޸ĵı��
		user.setPwd("123456");//��ԭʼ�����޸ĳ�123456
		UserDao userDao = new UserDaoImpl();
		int result = userDao.updatePwdById(user);
		System.out.println("������:"+result+"������");
	}
	@Test
	void delUserById() {
		int id = 2;//ָ��Ҫɾ�����û����
		UserDao userDao = new UserDaoImpl();
		int result = userDao.delUserById(id);
		System.out.println("������:"+result+"������");
	}
}
