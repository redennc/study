package cn.pro.Utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {

	private static Properties config = new Properties();
	static{
		try {
			config.load(JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties"));
			Class.forName(config.getProperty("driver")).newInstance();
		} catch (Exception e) {
			throw new ExceptionInInitializerError("≈‰÷√Œƒº˛ ‘ÿ»Î¥ÌŒÛ");
		}
	}
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(config.getProperty("url"), config.getProperty("username"), config.getProperty("password"));
	}
	
	public static void releaseConnection(Connection conn, Statement stm, ResultSet rs)
	{
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		
		if(stm != null)
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		
		if(rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
	}
}
