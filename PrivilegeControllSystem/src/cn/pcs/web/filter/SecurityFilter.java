package cn.pcs.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.pcs.domain.User;
import cn.pcs.service.BusinessService;

public class SecurityFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession(false);
		if(session == null)
		{
			request.setAttribute("message", "请先登录");
			request.getRequestDispatcher("/message").forward(request, res);
			chain.doFilter(request, res);
			return;
		}		
		
		User user = (User) session.getAttribute("user");
		BusinessService service = new BusinessService();
		String uri = request.getRequestURI();
		
		if(service.findResource(uri) == null)
		{
			chain.doFilter(request, res);
			return;
		}
		
		if(!service.isFindUserPrivilege(user, uri))
		{
			request.setAttribute("message", "您不具有 该权限");
			request.getRequestDispatcher("/message").forward(request, res);
			chain.doFilter(request, res);
			return;
		}
		
		chain.doFilter(request, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
