package com.nue.javaweb1.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nue.javaweb1.pojo.User;

/**
 * Servlet implementation class ResponseDemo1
 */
@WebServlet("/response1")
public class ResponseDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResponseDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		User user=new User(1001,"Nue","123","男","唱跳");
		
		request.setAttribute("str"," 单个字符串");//在request中保存一个名为str，值为单个字符串的信息
		request.setAttribute("user",user);//在request中保存一个名为user，值为user对象的信息
		//请求重定向
		response.sendRedirect("http://Localhost:7080/javaweb1/info.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
