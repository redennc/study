package cn.pro.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.pro.Dao.UserDao;
import cn.pro.Domain.PageBean;
import cn.pro.Domain.User;
import cn.pro.Utils.JdbcUtils;

public class UserDaoJdbcImpl implements UserDao {
	public void add(User user)
	{
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into users(name,password,hobby,nikename) values(?,?,?,?)";
			stm = conn.prepareStatement(sql);
			stm.setString(1, user.getUsername());
			stm.setString(2, user.getPassword());
			stm.setString(3, user.getHobby());
			stm.setString(4, user.getNikename());
			int num = stm.executeUpdate();
			if(num<1)
				throw new RuntimeException("ÓÃ»§×¢²áÊ§°Ü");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.releaseConnection(conn, stm, rs);
		}
	}
	
	public User find(String username, String password)
	{
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from users where name=? and password=?";
			stm = conn.prepareStatement(sql);
			stm.setString(1, username);
			stm.setString(2, password);
			rs = stm.executeQuery();
			if(rs.next())
			{
				User user = new User();
				user.setUsername(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setHobby(rs.getString("hobby"));
				user.setNikename(rs.getString("nikename"));
				return user;
			}
			return null;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.releaseConnection(conn, stm, rs);
		}		
	}
	
	public List<User> getAll()
	{
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from users";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next())
			{
				User user = new User();
				user.setUsername(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setHobby(rs.getString("hobby"));
				user.setNikename(rs.getString("nikename"));
				list.add(user);
			}
			return list;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public PageBean pageQuery(PageBean pb)
	{
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		//PageBean pb = new PageBean();
		List<User> list = new ArrayList<User>();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from users limit ?,?";
			stm = conn.prepareStatement(sql);
			stm.setInt(1, (pb.getStartIndex()-1)*pb.getPageSize());
			stm.setInt(2, pb.getPageSize());
			rs = stm.executeQuery();
			while(rs.next())
			{
				User user = new User();
				user.setUsername(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setHobby(rs.getString("hobby"));
				user.setNikename(rs.getString("nikename"));
				list.add(user);
			}
			pb.setList(list);
			sql = "select count(*) from users";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			if(rs.next())
				pb.setRecordCount(rs.getInt(1));
			
			return pb;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
}
