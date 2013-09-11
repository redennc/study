package cn.pcs.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import cn.pcs.domain.Privilege;


public class WebUtils {

	public static <T> T request2Bean(HttpServletRequest request, Class<T> clazz)
	{
		//注册转换 类  addresource.jsp页面
				ConvertUtils.register(new Converter(){
					public Object convert(Class type, Object value) {
						if(value==null){
							return null;
						}
						String str = (String) value;
						if(str.trim().equals("")){
							return null;
						}

						JSONObject json = JSONObject.fromObject(str);
						//System.out.println(((Privilege)JSONObject.toBean(json, Privilege.class)).getName());
						return JSONObject.toBean(json, Privilege.class);
					}
				}, Privilege.class);
		try {
			T bean = clazz.newInstance();
			Map map = request.getParameterMap();
			
			BeanUtils.populate(bean, map);
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 

	}
	
	
	/*public static void copyBean(Object src,Object dest){
		//注册日期转换器
		ConvertUtils.register(new Converter(){
			public Object convert(Class type, Object value) {
				if(value==null){
					return null;
				}
				String str = (String) value;
				if(str.trim().equals("")){
					return null;
				}
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return df.parse(str);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}
		}, Date.class);
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}*/
}
