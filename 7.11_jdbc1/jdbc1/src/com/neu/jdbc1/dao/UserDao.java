package com.neu.jdbc1.dao;

import com.neu.jdbc1.pojo.User;

public interface UserDao {
	//可以录入用户名、密码、性别、爱好
	public int addUser(User user);
	//只能录入用户名、密码
	public int addUser2(User user);
	// 根据用户编号，修改用户密码
	public int updatePwdById(User user);
	//根据用户编号 删除用户信息
	public int delUserById(int id);
}
