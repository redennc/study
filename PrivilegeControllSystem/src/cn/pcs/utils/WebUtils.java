package cn.pcs.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;


public class WebUtils {

	public static <T> T request2Bean(HttpServletRequest request, Class<T> clazz)
	{
		/*//×¢²áÈÕÆÚ×ª»»Æ÷
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
				}, Date.class);*/
		try {
			T bean = clazz.newInstance();
			Map map = request.getParameterMap();
			
			BeanUtils.populate(bean, map);
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		

		
	}
}
