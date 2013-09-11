package cn.pcs.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pcs.domain.Privilege;
import cn.pcs.domain.Resource;
import cn.pcs.service.BusinessService;
import cn.pcs.utils.WebUtils;

public class ResourceServlet extends HttpServlet {

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


	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Resource resource = WebUtils.request2Bean(request, Resource.class);
			service.addResource(resource);
			request.setAttribute("message", "资源添加成功");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "资源添加失败");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}


	private void addUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Privilege> plist = service.getAllPrivilege();
		request.setAttribute("plist", plist);
		request.getRequestDispatcher("/security/addresource.jsp").forward(request, response);
	}


	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Privilege> list = service.getAllPrivilege();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/security/listresource.jsp").forward(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
