package cn.pcs.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.pcs.domain.User;
import cn.pcs.utils.JdbcUtils;

public class UserDaoImpl {

	
	public User find(String username, String password)
	{
		
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where username=?";
			User user = (User) qr.query(sql, username, new BeanHandler(User.class));
						
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
