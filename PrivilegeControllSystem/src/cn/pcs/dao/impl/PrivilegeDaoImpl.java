package cn.pcs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.pcs.domain.Privilege;
import cn.pcs.utils.JdbcUtils;


public class PrivilegeDaoImpl {
	
	public void add(Privilege p)
	{
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into privilege (name,description) values(?,?)";
			Object[] params = {p.getName(), p.getDescription()};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Privilege> getAll()
	{
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from privilege";
			List<Privilege> p = (List<Privilege>) qr.query(sql, new BeanListHandler(Privilege.class));
			return p;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


}








