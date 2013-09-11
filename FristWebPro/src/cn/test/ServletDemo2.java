package cn.test;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo2 extends HttpServlet {
	private ServletConfig config;
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
	/*public void init(ServletConfig config)
	{
		this.config = config;
	}*/
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//request.getRequestDispatcher("xxx").include(request, response)
		//RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/MyJsp.jsp");  //获得转发对象 (跟重定向的区别)
		//rd.forward(request, response); //转发 请求  由 jsp 回应数据 给浏览器
	//	response.setStatus(404);
		//response.setContentType("text/html");
		response.setContentType("text/html; charset=gbk");
		//response.setCharacterEncoding("utf-8"); // 设置 response 所使用的码表
		//response.setHeader("content-type", "text/html; charset=utf-8");
	//	request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
//		request.getr
//		response.g
		int arr[]={2,4,6};
		//Integer aa[]=arr;
		//Array.g
		Object o = (Object)arr;
		//int b = (int)o
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(1);
		out.println(",11111 显示using the GET methodxxxxxxxxxxxxxxxxxx");
		out.println("  </BODY>");
		out.println("</HTML>");
		//out.flush();
		//out.close();
		/*
		String value = this.getInitParameter("var");//config.getInitParameter("var");
		System.out.println(value);
	//	this.getServletContext().getRealPath("/WEB-INF/classes/test.txt")
		InputStream is = ServletDemo2.class.getClassLoader().getResourceAsStream("/test.txt");  //在 src 目录下  类装载器  在这目录在要有该 .java 文件 还有它被装载入内存了
		String ttt = ServletDemo2.class.getClassLoader().getResource("/test.txt").getPath();
		BufferedReader isr = new BufferedReader(new InputStreamReader(is));
		System.out.println(URLEncoder.encode("想","utf-8"));
		
		BufferedImage bi = new BufferedImage(100, 300, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/MyJsp.jsp");  //获得转发对象 (跟重定向的区别)
		rd.forward(request, response); //转发 请求  由 jsp 回应数据 给浏览器
		
		*/
	//	this.getServletContext().getRequestDispatcher("/MyJsp.jsp").forward(request, response);
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
	}

}
