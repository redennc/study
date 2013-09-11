package cn.pcs.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResourceServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method = request.getParameter("method");
		
/*		if("addUI".equals(method))
		{
			request.getRequestDispatcher("/security/addprivilege.jsp").forward(request, response);
		}*/
		
		if("getAll".equals(method))
		{
			getAll(request, response);
		}

	}


	private void getAll(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
