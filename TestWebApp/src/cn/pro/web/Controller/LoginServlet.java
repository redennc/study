package cn.pro.web.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pro.Domain.User;
import cn.pro.Service.BusinessServiceImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = BusinessServiceImpl.login(username, password);
		if(user == null)
		{
			request.setAttribute("message", "用户名或密码错误");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		return;
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
