package cn.pro.web.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pro.Domain.PageBean;
import cn.pro.Domain.User;
import cn.pro.Service.BusinessServiceImpl;

public class ListUsersServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//PageBean pb = new PageBean();
		int startIndex = 1;
		int pageSize = 2;
		if(request.getParameter("startIndex") != null)
			startIndex = Integer.parseInt(request.getParameter("startIndex"));
		if(request.getParameter("pageSize") != null)
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		BusinessServiceImpl bs = new BusinessServiceImpl();
		PageBean pb = new PageBean();
		pb.setStartIndex(startIndex);
		pb.setPageSize(pageSize);
		pb = bs.pageQuery(pb);
		request.setAttribute("pageBean", pb);
		request.getRequestDispatcher("/WEB-INF/jsp/listusers.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}

}
