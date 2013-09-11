package cn.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo3 extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	this.getServletContext().getRequestDispatcher("/ServletDemo2").forward(request, response);
		response.setContentType("text/html");
		
//		this.getServletContext()
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print(request.getParameter("nnnnnnnn")+"    This is ");
		out.print(this.getClass());
		out.println(", 3333333using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
	//	out.flush();
		//out.close();
		
	//	String[] s = {};
		/*if (s instanceof String[]) {
			//Array aaa = (Array) s;
			String sss = (String)request.getParameterNames().nextElement();
			request.getParameterValues(arg0)  .getParameter(sss);
		}*/
		Map<String,String[]> m = request.getParameterMap();
		//m.get("like");
		//System.out.println(m.get("like").length+"   "+m.get("like")[0]);
		System.out.println(request.getQueryString());
	//	String sss = "xxxx";
		//request.setCharacterEncoding("utf-8");
		//String sss = (String)request.getParameter("test");
//		new String(sss.getBytes("iso-8859-1"), "utf-8");
		//System.out.println(new String(sss.getBytes("ISO-8859-1"), "gbk"));
		//System.out.println(request.getCharacterEncoding());
		
		String sss = "asd sss,www,ddd";  
		//System.out.println(sss.split("\\s+")[0]);
		System.out.println(sss.split("\\,")[0]);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		
		
	//	request.setCharacterEncoding("gbk");
		//String sss = (String)request.getParameter("test");
	//	sss.getBytes("utf-8")
	//	System.out.println(new String(sss.getBytes("ISO-8859-1"), "gbk"));
	//	System.out.println(sss);
		
		
	}

}
