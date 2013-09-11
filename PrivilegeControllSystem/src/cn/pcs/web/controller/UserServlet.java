package cn.pcs.web.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pcs.domain.Privilege;
import cn.pcs.domain.Role;
import cn.pcs.domain.User;
import cn.pcs.service.BusinessService;
import cn.pcs.utils.WebUtils;

public class UserServlet extends HttpServlet {

	private BusinessService service = new BusinessService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method = request.getParameter("method");
		
		if("updateUI".equals(method))  
		{
			updateUI(request, response);
		}
		
		if("getAll".equals(method))
		{
			getAll(request, response);
		}
		
		/*if("add".equals(method))
		{
			add(request, response);
		}*/
		
	}


	private void updateUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User u = WebUtils.request2Bean(request, User.class);
		User user = service.findUser(u);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/security/adduser.jsp").forward(request, response);
	}


	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> list = service.getAllUser();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/security/listuser.jsp").forward(request, response);
	}


	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
