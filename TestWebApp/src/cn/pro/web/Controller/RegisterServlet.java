package cn.pro.web.Controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pro.Domain.User;
import cn.pro.Service.BusinessServiceImpl;
import cn.pro.Utils.WebUtils;
import cn.pro.web.FormBean.RegisterForm;

import com.sun.org.apache.commons.beanutils.BeanUtils;

public class RegisterServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		boolean b = form.validata();
		if(!b)
		{//表单 填写错误
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		
		//注册 用户		
		try {
			User user = new User();
			BeanUtils.copyProperties(user, form);
			BusinessServiceImpl.register(user);
			request.setAttribute("message", "注册成功");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			form.getErrors().put("username", "用户名已存在");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
