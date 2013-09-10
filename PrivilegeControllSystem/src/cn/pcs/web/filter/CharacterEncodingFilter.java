package cn.pcs.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class CharacterEncodingFilter implements Filter {

	private FilterConfig config;
	private String defaultCharset = "utf-8";
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String charset = config.getInitParameter("charset");
		if(charset == null)
		{
			charset = defaultCharset;
		}
		request.setCharacterEncoding(charset);
		MyRequest my = new MyRequest(request);
		chain.doFilter(new MyRequest(request), response);
	}

	class MyRequest extends HttpServletRequestWrapper
	{
		HttpServletRequest request;
		public MyRequest(HttpServletRequest request) 
		{
			super(request);
			this.request = request;
		}
		
		@Override
		public String getParameter(String name) 
		{
			String value = super.getParameter(name);
			if(request.getMethod().equalsIgnoreCase("get"))
			{
				return value;
			}
			if(value == null)
			{
				return null;
			}
			
			try {
				return new String(value.getBytes("ISO-8859-1"),request.getCharacterEncoding());
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}
		
		
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
