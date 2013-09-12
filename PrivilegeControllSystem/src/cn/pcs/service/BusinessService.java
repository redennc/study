package cn.pcs.service;

import java.util.List;
import java.util.Set;

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
	
	public User findUser(User user)
	{
		return udao.find(user.getId());
	}
	public User findUser(String username, String password)
	{
		return udao.find(username, password);
	}
	public void updateUser(User user) 
	{	
		udao.update(user);
	}
	public List<User> getAllUser()
	{
		return udao.getAll();
	}

	
	public void addPrivilege(Privilege p)
	{
		pdao.add(p);
	}
	//获得 所有的权限 
	public List<Privilege> getAllPrivilege()
	{
		return pdao.getAll();
	}
	
	
	public void addResource(Resource r)
	{
		rdao.add(r);
	}
	public Resource findResource(String uri)
	{
		return rdao.find(uri);
	}
	public List<Resource> getAllResource()
	{
		return rdao.getAll();
	}
	
	
	public List<Role> getAllRole()
	{
		return rodao.getAll();
	}
	public void addRole(Role role) 
	{
		rodao.add(role);
	}
	
	
	public boolean isFindUserPrivilege(User user, String uri) {
		Resource resource = rdao.find(uri);
		
		if(resource == null)
			return false;
		
		Set<Role> roles = rodao.getRolesByPrivilegeId(resource.getPrivilege().getId());
		User u = udao.find(user.getUsername(), user.getPassword());

		for(Role r : u.getRole())
		{
			for(Role r2 : roles)
			{
				if(r.getId() == r2.getId())
				{
					return true;
				}
			}
		}
		return false;
	}
		
	
	
}





