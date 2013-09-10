package cn.pcs.service;

import java.util.List;

import cn.pcs.dao.impl.PrivilegeDaoImpl;
import cn.pcs.dao.impl.UserDaoImpl;
import cn.pcs.domain.Privilege;
import cn.pcs.domain.User;

public class BusinessService {
	private UserDaoImpl udao = new UserDaoImpl();
	private PrivilegeDaoImpl pdao = new PrivilegeDaoImpl();
	
	public User findUser(String username, String password)
	{
		return udao.find(username, password);
	}
	
	public void addPrivilege(Privilege p)
	{
		pdao.add(p);
	}
	
	public List<Privilege> getAllPrivilege()
	{
		return pdao.getAll();
	}
}
