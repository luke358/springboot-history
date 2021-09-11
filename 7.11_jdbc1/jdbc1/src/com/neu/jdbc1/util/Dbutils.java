package com.neu.jdbc1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dbutils {
	//������Ϣ
	private static final String DRIVER = "com.mysql.jdbc.Driver";//������ַ
	private static final String URL = "jdbc:mysql://localhost:3306/user?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai";//���ӵ�ַ
	private static final String NAME = "root";//�û���
	private static final String PWD= "123456";//����
	
	private static Connection con = null;//���Ӷ���   �����������ݿ�
	private static PreparedStatement ps = null;//Ԥ�������   ���ڴ���SQL ���
	private static ResultSet rs = null;//���������   ���ڱ����ѯ���
	
	//1.��������  ��̬�����
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//2.��ȡ���ݿ�����  ʹ��protected ����   ��Dbutils������ �޷�ʹ�ø÷���
	protected static void getConnection() {
		try {
			con = DriverManager.getConnection(URL, NAME, PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//3.�������ӷ���
	protected static void closeAll() {
		//�رս����
		if(null!=rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//�ر�Ԥ�������
		if(null!=ps) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//�ر����Ӷ���
		if(null!=con) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//4.��������
	protected static void beginTransaction() {
		getConnection();//��ȡ���ݿ�����
		//�ر��Զ��ύ������
		try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//5.�ύ����
	protected static void commit() {
		try {
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	//6.�ع�����
	protected static void rollback() {
		try {
			con.rollback();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	//7.������DML  ��������   ���� ʵ�� update��delete��insert
	protected static int excuteUpdate(String sql,Object[] obj) {
		int count = 0;//���ڼ�¼���������ݿ���Ŀ��
		beginTransaction();//��������   �����˽������ݿ����� 		
		try {
			//��sql������Ԥ�������   Ŀ��Ϊ��ʵ��sql���ƴ��
			ps = con.prepareStatement(sql);
			//����obj ����  �ж��Ƿ�Ҫ����sql ���ƴ��
			if(null!=obj) {
				for(int i=0;i<obj.length;i++) {
					ps.setObject(i+1, obj[i]);
				}
			}
			//ִ��sql���
			count = ps.executeUpdate();
		commit();//�����ύ���񷽷�
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rollback();//�ع�����
		}finally {
			closeAll();//�ر�����
		}
		return count;
	}
	//8.������ѯ����
	protected static ResultSet executeQuery(String sql,Object[] obj) {
		getConnection();//��ȡ����    ��ѯ����Ҫ������
		try {
			ps = con.prepareStatement(sql);//����Ԥ�������
			if(null!=obj) {
				for(int i=0;i<obj.length;i++) {
					ps.setObject(i+1, obj[i]);
				}
			}
			rs = ps.executeQuery();//������ResultSet ���в�ѯ
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//ע��  ��Ҫ�ڵ�ǰ���е���  �ر���Դ����   rs ������Ҫ��Dao�н������ݴ���  ���ܹرգ���
		return rs;
	}
}
