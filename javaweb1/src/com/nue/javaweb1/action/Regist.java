package com.nue.javaweb1.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nue.javaweb1.pojo.User;
import com.nue.javaweb1.service.UserService;
import com.nue.javaweb1.service.impl.UserServiceImpl;
/**
 http://localhost:7080/javaweb1/regist
 
 */
@WebServlet("/regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService =new UserServiceImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet fang 方法");
		request.setCharacterEncoding("utf-8");//获取请求时，设置编码
		//设置响应编码（不是必须）
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String name = request.getParameter("name");
		System.out.println("获取到用户输入的用户名："+name);
		String pwd = request.getParameter("pwd");
		System.out.println("获取到用户输入的密码："+pwd);
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birth");
		String[] hobbies = request.getParameterValues ("hobby");
		String hobby = request. getParameter( "hobby"); 
		System.out.println("性别:"+sex+",生日:"+birth+",爱好:"+hobby);
		System.out.println("爱好[]:");
		String strHobby="";
		for(String str:hobbies) {
			System.out.print(str+",");
			strHobby=str+" ";
		}
		//将前台数据放入对象中
		User user=new User(0,name,pwd,sex,strHobby);
		System.out.println(user.toString());
		//刘用户已经存在，模拟页面跳转
/*		if("刘".equals(user.getName())) {
			request.setAttribute("nameErr", "用户名重复");
			request.getRequestDispatcher("regist.jsp").forward(request, response);
		}else {
			request.setAttribute("user", user);
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}*/
		
		//对象方便数据传递，之后会在Service中使用
		//会调用后台service包中的业务逻辑 完成一系列操作，例如用户注册（将数据录入数据库中）
		boolean result =userService.regist(user);
		if(result) {
			//注册成功
			request.setAttribute("user",user);
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else {
			//注册失败
			//request.setAttribute("nameErr", "用户名重复");
			request.getRequestDispatcher("regist.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost fang 方法");
		doGet(request,response);
	}

}
