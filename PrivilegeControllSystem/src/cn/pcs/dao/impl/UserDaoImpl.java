package cn.pcs.dao.impl;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.pcs.domain.PageBean;
import cn.pcs.domain.Role;
import cn.pcs.domain.User;
import cn.pcs.utils.JdbcUtils;

public class UserDaoImpl {

	
	public User find(int id)
	{
		
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where id=?";
			User user = (User) qr.query(sql, id, new BeanHandler(User.class));
						
			sql = "select r.* from role as r inner join role_user as ru on ru.user_id=? and ru.role_id=r.id";
			List<Role> rlist = (List<Role>) qr.query(sql, id, new BeanListHandler(Role.class));
			user.setRole(new HashSet<Role>(rlist));
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public User find(String username, String password)
	{
		
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where username=? and password=?";
			Object[] params = {username, password};
			User user = (User) qr.query(sql, params, new BeanHandler(User.class));
						
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void update(User user)
	{
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "delete from role_user where user_id=?";
			int uid =  user.getId();
			qr.update(sql, uid);
			
			Object[][] params = new Object[user.getRole().size()][2];
			int i=0;
			for(Role r : user.getRole())
			{
				params[i][0]=r.getId();
				params[i][1]=uid;
			}
			sql = "insert into role_user set role_id=?,user_id=?";
			qr.batch(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<User> getAll()
	{
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user";
			List<User> list = (List<User>) qr.query(sql, new BeanListHandler(User.class));
			for(User u : list)
			{
				sql = "select r.* from role as r inner join role_user as ru on ru.role_id=r.id and ru.user_id=?";
				List<Role> r =  (List<Role>) qr.query(sql, u.getId(), new BeanListHandler(Role.class));
				Set<Role> set = new HashSet<Role>();
				set.addAll(r);
				u.setRole(set);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public PageBean getPage(PageBean pageBean)
	{
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user limit ?,?";
			int start = (pageBean.getCurrentPageIndex()-1)*pageBean.getPageSize();
			Object[] params = {start, pageBean.getPageSize()};
			List<User> list = (List<User>) qr.query(sql, params, new BeanListHandler(User.class));
			for(User u : list)
			{
				sql = "select r.* from role as r inner join role_user as ru on ru.role_id=r.id and ru.user_id=?";
				List<Role> r =  (List<Role>) qr.query(sql, u.getId(), new BeanListHandler(Role.class));
				Set<Role> set = new HashSet<Role>();
				set.addAll(r);
				u.setRole(set);
			}
			pageBean.setItems(list);
			return pageBean;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	
}



