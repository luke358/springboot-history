package com.neu.javaweb1.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.javaweb1.pojo.User;

/**
 * http://localhost:7080/javaweb1/regist
 *  注意 get  与  post 区别    一般 表单提交数据 我们习惯使用 post 方式
 * post  更为安全    get方式 会将表单数据在地址栏显示
 * get 传输速度更快
 */
@WebServlet("/regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 方法");
		request.setCharacterEncoding("utf-8");//获取请求时，设置编码
		//设置响应编码（不是必须）
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		System.out.println("获取到用户输入的用户名:"+name);
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birth");
		String[] hobbies = request.getParameterValues("hobby");//获取多个值
		String hobby = request.getParameter("hobby");//获取单个值
		System.out.println("性别:"+sex+",生日:"+birth+"，爱好:"+hobby);
		System.out.println("爱好[]:");
		String strHobby = "";//用于将String[]数组类型的  爱好  保存到 String 中
		for(String str:hobbies) {
			System.out.print(str+",");
			strHobby= strHobby+" "+str;
		}
		//将前台数据  放入  对象中
		User user = new User(0, name, pwd, sex, strHobby);
		System.out.println(user.toString());
		//刘  用户 已经存在   模拟页面跳转 
		if("刘".equals(user.getName())) {
			//注册成功
			request.getRequestDispatcher("regist.html").forward(request, response);
		}else {
			//注册失败
			request.getRequestDispatcher("success.html").forward(request, response);
		}
		
		//对象方便数据传递，之后会在Service中使用
		//会调用后台 service包中的业务逻辑  完成一系列操作  例如，用户注册（将数据录入到数据库中）
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost 方法");
		doGet(request, response);

	}

}
