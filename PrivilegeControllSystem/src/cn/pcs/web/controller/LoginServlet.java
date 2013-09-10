package cn.pcs.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pcs.domain.User;
import cn.pcs.service.BusinessService;
import cn.pcs.utils.WebUtils;

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = WebUtils.request2Bean(request, User.class);
		
		BusinessService service = new BusinessService();
		
		
		if(service.findUser(user.getUsername(), user.getPassword()) == null)
		{
			request.setAttribute("message", "用户或密码不正确");
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
