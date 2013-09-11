package cn.test;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletOutputStream sos = res.getOutputStream();
		//sos.print("servlet ..........");
		sos.write("xxxxxxxxxxxxxxx".getBytes());
	}

}
