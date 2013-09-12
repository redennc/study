package cn.pcs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mysql.jdbc.Statement;

import cn.pcs.domain.Privilege;
import cn.pcs.domain.Role;
import cn.pcs.utils.JdbcUtils;

public class RoleDaoImpl {
	
	public List<Role> getAll()
	{
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from role";
			List<Role> list = (List<Role>) qr.query(sql, new BeanListHandler(Role.class));
			for(Role r : list)
			{
				sql = "select p.* from privilege as p inner join role_privilege as rp on rp.role_id=? and rp.privilege_id=p.id";
				List<Privilege> p =  (List<Privilege>) qr.query(sql, r.getId(), new BeanListHandler(Privilege.class));
				Set<Privilege> set = new HashSet<Privilege>();
				set.addAll(p);
				r.setPrivilege(set);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void add(Role role)
	{
		/*try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into role(name,description) values(?,?) ";
			Object[] params = {role.getName(), role.getDescription()};
			qr.update(sql, params);
			//long nowtype= (Long)qr.query( "SELECT LAST_INSERT_ID()", new ScalarHandler());//===========================
			long nowtype= (Long)qr.query( "SELECT LAST_INSERT_ID()", new ScalarHandler());
			Object[][] params2 = new Object[role.getPrivilege().size()][2];
			int i=0;
			for(Privilege p : role.getPrivilege())
			{
				params2[i][0] = nowtype;
				params2[i][1] = p.getId();
				i++;
			}
			sql = "insert into role_privilege(role_id,privilege_id) values(?,?)";
			qr.batch(sql, params2);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}*/
		try {
		Connection conn = JdbcUtils.getConnection();
		String sql = "insert into role(name,description) values(?,?) ";
		PreparedStatement stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, role.getName());
		stm.setString(2, role.getDescription());
		stm.executeUpdate();
		ResultSet rs = stm.getGeneratedKeys();
		int lastKey=0;
		if(rs.next())
			lastKey = rs.getInt(1);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}





