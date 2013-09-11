package cn.pcs.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import cn.pcs.domain.Privilege;
import cn.pcs.domain.Resource;
import cn.pcs.utils.JdbcUtils;

public class ResourceDaoImpl {
	
	public List<Resource> getAll()
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
			return rList;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void add(Resource resource) {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into resource(uri,privilege_id,description) values(?,?,?)";
			Object[] params = {resource.getUri(), resource.getPrivilege().getId(), resource.getDescription()};		
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	
	public Resource find(String uri) {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from resource where uri=?";
			Map<String,String> map = (Map<String,String>) qr.query(sql, uri, new MapHandler());

			if(map != null)
			{
				Resource r = new Resource();
				r.setDescription(map.get("description"));
				r.setId(Integer.parseInt(map.get("id")));
				r.setUri(map.get("uri"));
				Privilege p =new Privilege();
				p.setId(Integer.parseInt(map.get("privilege_id")));
				r.setPrivilege(p);
				return r;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
