package com.neu.jdbc1.dao.impl;

import com.neu.jdbc1.dao.UserDao;
import com.neu.jdbc1.pojo.User;
import com.neu.jdbc1.util.Dbutils;

public class UserDaoImpl extends Dbutils implements UserDao {

	@Override
	public int addUser(User user) {
		//����ؼ���Ϣ  ����ʹ��������  ������id��
		String sql = "insert into user (name,pwd,sex,hobby) values (?,?,?,?)";
		//Object����������  ������?����Ҫһ��  �����һһ��
		Object[] obj = new Object[]{user.getName(),user.getPwd(),user.getSex(),user.getHobby()};
		int i = super.excuteUpdate(sql, obj);
		return i;
	}

	@Override
	public int addUser2(User user) {
		String sql = "insert into user (name,pwd) values (?,?)";
		//Object����������  ������?����Ҫһ��  �����һһ��
		Object[] obj = new Object[]{user.getName(),user.getPwd()};
		int i = super.excuteUpdate(sql, obj);
		return i;
	}

	@Override
	public int updatePwdById(User user) {
		String sql = "update user set pwd=? where id=?";
		Object[] obj = new Object[]{user.getPwd(),user.getId()};
		int i = super.excuteUpdate(sql, obj);
		return i;
	}

	@Override
	public int delUserById(int id) {
		String sql = "delete from user where id=?";
		Object[] obj = new Object[]{id};
		int i = super.excuteUpdate(sql, obj);
		return i;
	}

}
