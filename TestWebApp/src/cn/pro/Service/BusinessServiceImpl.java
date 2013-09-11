package cn.pro.Service;

import java.util.List;

import cn.pro.Dao.UserDao;
import cn.pro.Dao.Impl.UserDaoJdbcImpl;
import cn.pro.Domain.PageBean;
import cn.pro.Domain.User;

public class BusinessServiceImpl {
	private UserDao dao = new UserDaoJdbcImpl();
	public static void register(User user)
	{
		UserDao dao = new UserDaoJdbcImpl();

		if(dao.find(user.getUsername(), user.getPassword()) != null)
			throw new RuntimeException("用户名已存在");
		else
			dao.add(user);
	}
	
	public static User login(String username, String password)
	{
		UserDao dao = new UserDaoJdbcImpl();
		return dao.find(username, password);
	}
	
	public List<User> getAll()
	{
		return dao.getAll();
	}
	
	public PageBean pageQuery(PageBean pb)
	{
		return dao.pageQuery(pb);
	}
}
