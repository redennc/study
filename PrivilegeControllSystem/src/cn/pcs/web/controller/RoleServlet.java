package cn.pcs.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pcs.domain.Privilege;
import cn.pcs.service.BusinessService;
import cn.pcs.utils.WebUtils;

public class RoleServlet extends HttpServlet {

	private BusinessService service = new BusinessService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method = request.getParameter("method");
		
		if("addUI".equals(method))
		{
			request.getRequestDispatcher("/security/addrole.jsp").forward(request, response);
		}
		
		if("getAll".equals(method))
		{
			getAll(request, response);
		}
		
		if("add".equals(method))
		{
			add(request, response);
		}
		
	}


	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Privilege> list = service.getAllPrivilege();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/security/listrole.jsp").forward(request, response);
	}


	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try{
			Privilege privilege = WebUtils.request2Bean(request, Privilege.class);
			service.addPrivilege(privilege);
			request.setAttribute("message", "角色添加成功");
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "角色添加失败");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
