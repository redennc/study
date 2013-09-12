package cn.ceetop.gongji;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Gongji extends HttpServlet {

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
		 String times;
		 times = (String) this.getServletContext().getAttribute("times");
		 if(times==null)
		 {
			 times = "0"; 
			 this.getServletContext().setAttribute("times", times);
		 }
		 
		 times = (Integer.parseInt(times) + 1) + ""; 
		 this.getServletContext().setAttribute("times", times);
		 response.setContentType("text/html;charset=utf-8");
		 
		 PrintWriter out = response.getWriter();
		for(int i=0;i<10;i++)
		{
		String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n";
		html += 
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"+
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"+
				"<head>\n"+
				        "<base href=\"http://192.168.1.227:8080/ceetop_v1/\">\n"+
					"<meta http-equiv=\"pragma\" content=\"no-cache\"/>\n"+
					"<meta http-equiv=\"cache-control\" content=\"no-cache\"/>\n"+
					"<meta http-equiv=\"expires\" content=\"0\"/>  \n"+
					"<title>用户注册</title>\n"+
					"<script type=\"text/javascript\" src=\"/ceetop_v1/js/jquery-1.9.1.js\"></script>\n"+
					"<script type=\"text/javascript\" src=\"/ceetop_v1/js/comman.js\"></script>\n"+
					"<script type=\"text/javascript\" src=\"/ceetop_v1/js/register.js\"></script> \n"+ 
					"<script type=\"text/javascript\">\n"+
					
					  "//设置基本的URL\n"+
					  "$(function(){\n"+
					    "setBaseUrl(\"/ceetop_v1\");\n"+
					     "register();\n"+
					     "alert(\"register\");\n"+
					  "});\n"+
					    
					  "function show22()\n"+
		               "{\n"+
			               "alert(\"aa\");\n"+
		               "}\n"+
					"</script>\n"+
				"</head>\n"+
				"<body>\n"+
					"<form id=\"form1\" name=\"form1\"  method=\"post\" target=\"_blank\">\n"+
					         "<table id=\"register\">\n"+
								"<tr id=\"username\">\n"+
									"<td>用 户 名：</td>\n"+
									"<td>\n"+
									    "<input type=\"text\" name=\"user.username\" value=\"name"+times+i+"\"/>\n"+
									"</td>\n"+
									"<td>*</td>\n"+
								"</tr>\n"+
								"<tr id=\"password\">\n"+
									"<td>密 码：</td>\n"+
									"<td>\n"+
									"<input type=\"password\" name=\"user.password\" value=\"password"+i+"\"/>\n"+
									"</td>\n"+
									"<td>*</td>\n"+
								"</tr>\n"+
								"<tr id=\"cpassword\">\n"+
									"<td>确认密码：</td>\n"+
									"<td>\n"+
									  "<input type=\"password\" name=\"user.cpassword\" value=\"password"+i+"\"/>\n"+
									"</td>\n"+
									"<td>*</td>\n"+
								"</tr>\n"+
								"<tr id=\"realName\">\n"+
									"<td>真实名称：</td>\n"+
									"<td>\n"+
									   "<input type=\"text\" name=\"user.realName\" value=\"realName"+times+i+"\"/>\n"+
									"</td>\n"+
									"<td>*</td>\n"+
								"</tr>\n"+
								"<tr >\n"+
									"<td>性 别：</td>\n"+
									"<td>\n"+
									   "<input type=\"radio\" name=\"user.sex\" value=\"male\" checked=\"checked\"/>男&nbsp;&nbsp;&nbsp;\n"+
									   "<input type=\"radio\" name=\"user.sex\" value=\"female\"/>女&nbsp;&nbsp;&nbsp;\n"+ 
									"</td>\n"+
									"<td></td>\n"+
								"</tr>\n"+
								"<tr id=\"email\">\n"+
									"<td>电子邮箱：</td>\n"+
									"<td>\n"+
									  "<input type=\"text\" name=\"user.email\" value=\"email"+times+i+"@qq.com\"/>\n"+
									"</td>\n"+
									"<td>*</td>\n"+
								"</tr>\n"+
								"<tr>\n"+
									"<td>所属部门：</td>\n"+
									"<td><select name=\"user.department.id\" style=\"width: 150px;\">\n"+
											
												"<option value=\"1\">技术部</option>\n"+
											
												"<option value=\"2\">呼叫部</option>\n"+
											
												"<option value=\"3\">总裁部</option>\n"+
											
												"<option value=\"4\">财务部</option>\n"+
											
									"</select></td>\n"+
									"<td></td>\n"+
								"</tr>\n"+
								"<tr id=\"last\">\n"+
									"<td >\n"+
									  "<input type=\"button\" onclick=\"show22()\" value=\"注册\" />\n"+
									"</td>\n"+
									"<td >\n"+
									  " <input  type=\"reset\" value=\"取消\" />\n"+
									"</td>\n"+
									"<td >\n"+
									   "<input onclick='go2PageOf(\"/ceetop_v1/index.jsp\")' type=\"button\" value=\"回到首页\" />\n"+
									"</td>\n"+
								"</tr>\n"+
							"</table>\n"+
						
					"</form>\n"+
					
				"</body>\n"+
				"</html>";

        
		 
		 out.println(html);
		 System.out.println("aaaa");
		
		}
		 out.flush();
	     out.close();
		
		
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
		doGet( request,  response);
		
	}

}
