package com.nue.javaweb1.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 当前Servlet 访问的地址是http://Localhost:7080/javaweb1/request1
 * 请求转发request 与请求重定向response
 * request 可以访问到WEB-INF下的内容但是response不可以
 * request站内访问速度相对于response更快
 * response是站外访问，例如，你想要从你的网站访问百度等其他网站
 * request可以在2个页面之前传递request携带的数据，但是response不想，
 */
@WebServlet("/request1")
public class RequestDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RequestDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 相对地址会将http://Localhost:7080/javaweb1/引入
		//web－INF下文件访问路径http://Localhost:7080/javaweb1/WEB-INF/index.html
		request.getRequestDispatcher("WEB-INF/index.html").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
