package cn.pro.Utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	public static <T> T request2Bean(HttpServletRequest request, Class<T> clazz)
	{
		try {
			T bean = clazz.newInstance();
			Enumeration e = request.getParameterNames();
			while(e.hasMoreElements())
			{
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		} 
		
	}
}
