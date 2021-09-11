package com.nue.javaweb1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dubtils {
	private static final String DRIVER="com.mysql.jdbc.Driver";//驱动地址
	private static final String URL="jdbc:mysql://localhost:3306/user?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai";//连接地址
	private static final String NAME="root";
	private static final String PWD="newpassword";
	
	private static Connection con =null;
	private static PreparedStatement ps =null;
	private static ResultSet rs=null;
	
	//1.加载驱动 静态代码块
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//2.获取数据库连接 使用protected 修饰 非Dbutils的子类 无法使用该方法
	protected static void getConnection() {
		try {
			con = DriverManager.getConnection(URL,NAME,PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//3.关闭连接方法
	protected static void closeAll() {
		//关闭结果集
		if(null!=rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//关闭预编译对象
		if(null!=ps) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//关闭连接对象
		if(null!=con) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	//4.开启事务
	protected static void beginTransaction() {
		getConnection();//获取数据库连接
		//关闭自动提交事务功能
		try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//5.提交事务
	protected static void commit() {
		try {
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//6.回滚事务
	protected static void rollback() {
		try {
			con.rollback();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//7.公共的DML 操作方法 可以实现update、delete、insert
	protected static int excuteUpdate(String sql,Object[] obj) {
		int count =0;//用于记录操作的数据库条目
		beginTransaction();//开启事务 包含了进行数据库连接
		
		try {
			//将sql语句放入预编译对象 目的为了实现sql拼接
			ps=con.prepareStatement(sql);
			//根据obj数组 判断是否要进行sql语句拼接
			if(null!=obj) {
				for(int i=0;i<obj.length;i++) {
					ps.setObject(i+1, obj[i]);
				}
			}
			//执行SQl语句
			count=ps.executeUpdate();
		commit();//调用提交事务方法
		}catch(SQLException e) {
			e.printStackTrace();
			rollback();//回滚事务
		}finally {
			closeAll();//关闭连接
		}
		return count;
	}
	//8.公共查询方法
	protected static ResultSet executeQuery(String sql,Object[] obj) {
		getConnection();//获取连接，查询不需要的事务处理
		try {
			ps=con.prepareStatement(sql);
			if(null!=obj) {
				for(int i=0;i<obj.length;i++) {
					ps.setObject(i+1, obj[i]);
				}
			}
			rs=ps.executeQuery();//借助于ResultSet 进行查询
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//注意 不要在当前类中调用 关闭资源方法 rs 对象需要在Dao中进行数据处理 不能关闭
		return rs;			
	}	
}
