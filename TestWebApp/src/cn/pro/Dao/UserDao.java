package cn.pro.Dao;

import java.util.List;

import cn.pro.Domain.PageBean;
import cn.pro.Domain.User;

public interface UserDao {
	public void add(User user);
	public User find(String username, String password);
	public List<User> getAll();
	public PageBean pageQuery(PageBean pb);
}
