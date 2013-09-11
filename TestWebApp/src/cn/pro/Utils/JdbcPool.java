package cn.pro.Utils;


import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

public class JdbcPool implements DataSource {

	private static LinkedList<Connection> list = new LinkedList<Connection>();
	static{
		Properties ps = new Properties();
		InputStream in = JdbcPool.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			ps.load(in);
			for(int i=0; i<10; i++)
			{//在连接池中放入 10个连接
				Connection conn = DriverManager.getConnection(ps.getProperty("url"), ps.getProperty("username"), ps.getProperty("password"));
				list.add(conn);
			}

		} catch (Exception e) {
			throw new ExceptionInInitializerError("连接池初始化错误");
		}
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		
		return new MyConnection(list.pollFirst());
	}
	class MyConnection implements Connection{
		private Connection conn = null;
		public MyConnection(Connection conn)
		{
			this.conn = conn;
		}
		@Override
		public void close() throws SQLException {
			list.add(conn);
		}
		@Override
		public <T> T unwrap(Class<T> iface) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public boolean isWrapperFor(Class<?> iface) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public Statement createStatement() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public PreparedStatement prepareStatement(String sql)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public CallableStatement prepareCall(String sql) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String nativeSQL(String sql) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void setAutoCommit(boolean autoCommit) throws SQLException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean getAutoCommit() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public void commit() throws SQLException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void rollback() throws SQLException {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean isClosed() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public DatabaseMetaData getMetaData() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void setReadOnly(boolean readOnly) throws SQLException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean isReadOnly() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public void setCatalog(String catalog) throws SQLException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public String getCatalog() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void setTransactionIsolation(int level) throws SQLException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public int getTransactionIsolation() throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public SQLWarning getWarnings() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void clearWarnings() throws SQLException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public Statement createStatement(int resultSetType,
				int resultSetConcurrency) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public PreparedStatement prepareStatement(String sql,
				int resultSetType, int resultSetConcurrency)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public CallableStatement prepareCall(String sql, int resultSetType,
				int resultSetConcurrency) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Map<String, Class<?>> getTypeMap() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void setHoldability(int holdability) throws SQLException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public int getHoldability() throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public Savepoint setSavepoint() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Savepoint setSavepoint(String name) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void rollback(Savepoint savepoint) throws SQLException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void releaseSavepoint(Savepoint savepoint) throws SQLException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public Statement createStatement(int resultSetType,
				int resultSetConcurrency, int resultSetHoldability)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public PreparedStatement prepareStatement(String sql,
				int resultSetType, int resultSetConcurrency,
				int resultSetHoldability) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public CallableStatement prepareCall(String sql, int resultSetType,
				int resultSetConcurrency, int resultSetHoldability)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public PreparedStatement prepareStatement(String sql,
				int autoGeneratedKeys) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public PreparedStatement prepareStatement(String sql,
				int[] columnIndexes) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public PreparedStatement prepareStatement(String sql,
				String[] columnNames) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Clob createClob() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Blob createBlob() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public NClob createNClob() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public SQLXML createSQLXML() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public boolean isValid(int timeout) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public void setClientInfo(String name, String value)
				throws SQLClientInfoException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void setClientInfo(Properties properties)
				throws SQLClientInfoException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public String getClientInfo(String name) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Properties getClientInfo() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Array createArrayOf(String typeName, Object[] elements)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Struct createStruct(String typeName, Object[] attributes)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
	}
	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
