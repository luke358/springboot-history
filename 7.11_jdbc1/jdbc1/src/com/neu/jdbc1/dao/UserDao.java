package com.neu.jdbc1.dao;

import com.neu.jdbc1.pojo.User;

public interface UserDao {
	//����¼���û��������롢�Ա𡢰���
	public int addUser(User user);
	//ֻ��¼���û���������
	public int addUser2(User user);
	// �����û���ţ��޸��û�����
	public int updatePwdById(User user);
	//�����û���� ɾ���û���Ϣ
	public int delUserById(int id);
}
