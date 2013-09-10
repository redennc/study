package cn.pcs.domain;

import java.util.HashSet;
import java.util.Set;

public class Role {
	private int id;
	private String name;
	private String description;
	private Set<Privilege> privilege = new HashSet<Privilege>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Privilege> getPrivilege() {
		return privilege;
	}
	public void setPrivilege(Set<Privilege> privilege) {
		this.privilege = privilege;
	}
}
