package com.nue.javaweb1.dao.impl;

import com.nue.javaweb1.dao.UserDao;
import com.nue.javaweb1.pojo.User;
import com.nue.javaweb1.util.Dubtils;

public class UserDaoImpl extends Dubtils implements UserDao {

	@Override
		public int addUser(User user) {
			// TODO Auto-generated method stub
			//插入关键信息 主键使用了自增 不插入id了
			String sql ="insert into user(name,pwd,sex,hobby) values(?,?,?,?)";
			//Object对象数组中 数量与？个数要一致，会进行一 一绑定
			Object[] obj= new Object[] {user.getName(),user.getPwd(),user.getSex(),user.getHobby()};
			int i=super.excuteUpdate(sql, obj);
			return i;
		}

}
