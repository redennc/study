package cn.pcs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.pcs.domain.Privilege;
import cn.pcs.domain.Resource;
import cn.pcs.utils.JdbcUtils;

public class ResourceDaoImpl {
	@Test
	public void getAll()
	{
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			//String sql = "select r.*,p.* from resource as r left join privilege as p on p.id=r.privilege_id";
			String sql = "select * from resource";
			List<Resource> rList =  (List<Resource>) qr.query(sql, new BeanListHandler(Resource.class));
			for(Resource r : rList)
			{
				sql = "select * from privilege where id=?";
				Privilege p =  (Privilege) qr.query(sql, r.getId(), new BeanHandler(Privilege.class));
				r.setPrivilege(p);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
