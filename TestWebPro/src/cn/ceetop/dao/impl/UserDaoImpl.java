package cn.ceetop.dao.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import cn.ceetop.dao.UserDao;
import cn.ceetop.domain.User;

public class UserDaoImpl implements UserDao {


	public void add(User user) {
		/*User user = new User();
		user.setHobby("aaaaahhhhh");
		user.setPassword("222222");
		user.setUserName("bbbb");*/
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest","root","root");
			String sql = "insert into user(name, password, hobby) values(?, ?, ?)";
			stm = conn.prepareStatement(sql);
			stm.setString(1, user.getUserName());
			stm.setString(2, user.getPassword());
			stm.setString(3, user.getHobby());
			int num = stm.executeUpdate();
			if(num < 1)
			{
				throw new RuntimeException("×¢²áÊ§°Ü");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			if(stm != null)
				try {
					stm.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
			

		
	}

	@Test
	public void find() { 
		String userName="aaa"; String Password="111";
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest","root","root");
			String sql = "select * from user where name=? and password=?";
			stm = conn.prepareStatement(sql);
			stm.setString(1, userName);
			stm.setString(2, Password);
			rs = stm.executeQuery();
			
			if(rs.next())
			{
				User user = new User();
				user.setUserName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setHobby(rs.getString("hobby"));
				System.out.println(rs.getString("name")+"  "+ rs.getString("password")+" "+rs.getString("hobby"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(stm != null)
				try {
					stm.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}

	
}
