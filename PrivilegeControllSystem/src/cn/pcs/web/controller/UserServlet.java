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
		
		if("addUI".equals(method))
		{
			addUI(request, response);
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


	private void addUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Privilege> list = service.getAllPrivilege();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/security/addrole.jsp").forward(request, response);
	}


	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> list = service.getAllUser();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/security/listuser.jsp").forward(request, response);
	}


	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try{
			Role role = WebUtils.request2Bean(request, Role.class);
			
			String[] pids = request.getParameterValues("pid");
			Set<Privilege> set = new HashSet<Privilege>();
			for(String pid : pids)
			{
				Privilege p = new Privilege();
				p.setId(Integer.parseInt(pid));
				set.add(p);
			}
			role.setPrivilege(set);
			
			service.addRole(role);
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
