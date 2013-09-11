import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import org.junit.Test;


public class webTree {
//id parentid name
//	1  xx       xx


	@Test
	public void mkTree() throws SQLException, ClassNotFoundException
	{
		Class.forName("org.gjt.mm.mysql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");	
		PreparedStatement stm = null;
		ResultSet rs = null;
		LinkedHashMap<Integer,LinkedHashMap> linkMap = new LinkedHashMap<Integer, LinkedHashMap>();
		
		String sql = "select id from tree where pid is null";  //找到 根节点
		stm = conn.prepareStatement(sql);
		rs = stm.executeQuery();
		int rootid=0;
		if(rs.next())
			rootid = rs.getInt("id");

		linkMap.put(rootid, null);
		
		Iterator<Entry<Integer, LinkedHashMap>> it = linkMap.entrySet().iterator();
		
		LinkedList<Iterator> stackTrace = new LinkedList<Iterator>();
		stackTrace.add(it);
		for(LinkedHashMap lm=linkMap;it.hasNext(); )
		{
			Entry<Integer, LinkedHashMap> entry = it.next();
			if(entry.getValue() != null)
				continue;
			
			rootid = entry.getKey();
			
			sql = "select id from tree where pid=?";  //找到 根节点
			stm = conn.prepareStatement(sql);
			stm.setInt(1, rootid);
			rs = stm.executeQuery();
			
			LinkedHashMap<Integer,LinkedHashMap> linkMap2 = new LinkedHashMap<Integer, LinkedHashMap>();
			boolean flag = false;
			while(rs.next())
			{
				linkMap2.put(rs.getInt("id"), null);
				flag = true;
			}
			if(flag)
			{
				lm.put(rootid, linkMap2);
				lm = linkMap2;
				it = linkMap2.entrySet().iterator();
				stackTrace.add(it);
			}else{//叶子 节点
				it = stackTrace.pollLast();
			}
		}
		System.out.println(linkMap);
		try{
			int a=1/0;
		}finally{
			System.out.println(222222222);
		}
		System.out.println(44442);
	}
}
