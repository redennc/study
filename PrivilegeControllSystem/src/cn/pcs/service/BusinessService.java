package cn.pcs.service;

import java.util.List;

import cn.pcs.dao.impl.PrivilegeDaoImpl;
import cn.pcs.dao.impl.ResourceDaoImpl;
import cn.pcs.dao.impl.RoleDaoImpl;
import cn.pcs.dao.impl.UserDaoImpl;
import cn.pcs.domain.Privilege;
import cn.pcs.domain.Resource;
import cn.pcs.domain.Role;
import cn.pcs.domain.User;

public class BusinessService {
	private UserDaoImpl udao = new UserDaoImpl();
	private PrivilegeDaoImpl pdao = new PrivilegeDaoImpl();
	private ResourceDaoImpl rdao = new ResourceDaoImpl();
	private RoleDaoImpl rodao = new RoleDaoImpl();
	
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
	
	
	public void addResource(Resource r)
	{
		rdao.add(r);
	}
	public List<Resource> getAllResource()
	{
		return rdao.getAll();
	}
	
	
	public List<Role> getAllRole()
	{
		return rodao.getAll();
	}
}
