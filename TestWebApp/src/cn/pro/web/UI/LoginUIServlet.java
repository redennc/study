package cn.pro.web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pro.Domain.User;

public class LoginUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		if(user == null)
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		else{
			request.setAttribute("message", user.getUsername()+"ÒÑµÇÂ¼");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
			
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
