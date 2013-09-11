package cn.pcs.dao.impl;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.pcs.domain.Privilege;
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
						
			return user;
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
}
