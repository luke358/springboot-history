package com.neu.jdbc1.dao.impl;

import com.neu.jdbc1.dao.UserDao;
import com.neu.jdbc1.pojo.User;
import com.neu.jdbc1.util.Dbutils;

public class UserDaoImpl extends Dbutils implements UserDao {

	@Override
	public int addUser(User user) {
		//插入关键信息  主键使用了自增  不插入id了
		String sql = "insert into user (name,pwd,sex,hobby) values (?,?,?,?)";
		//Object对象数组中  数量与?个数要一致  会进行一一绑定
		Object[] obj = new Object[]{user.getName(),user.getPwd(),user.getSex(),user.getHobby()};
		int i = super.excuteUpdate(sql, obj);
		return i;
	}

	@Override
	public int addUser2(User user) {
		String sql = "insert into user (name,pwd) values (?,?)";
		//Object对象数组中  数量与?个数要一致  会进行一一绑定
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
