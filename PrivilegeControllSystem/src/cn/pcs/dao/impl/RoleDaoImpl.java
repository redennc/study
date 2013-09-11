package cn.pcs.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import cn.pcs.domain.Role;
import cn.pcs.utils.JdbcUtils;

public class RoleDaoImpl {
	
	public List<Role> getAll()
	{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from role";
		return null;
	}
}
