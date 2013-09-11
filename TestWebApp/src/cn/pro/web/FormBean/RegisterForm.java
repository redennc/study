package cn.pro.web.FormBean;

import java.util.HashMap;
import java.util.Map;

public class RegisterForm {
	private String username;
	private String password;
	private String hobby;
	private String nikename;
	private HashMap<String, String> errors = new HashMap<String, String>(); 
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getNikename() {
		return nikename;
	}
	public void setNikename(String nikename) {
		this.nikename = nikename;
	}
	
	public HashMap<String, String> getErrors() {
		return errors;
	}

	public boolean validata()
	{
		boolean isOk = true;
		if(this.username == null || this.username.trim().equals(""))
		{
			isOk = false;
			errors.put("username", "�û�������Ϊ��");
		}
		if(this.password == null || this.password.trim().equals(""))
		{
			isOk = false;
			errors.put("password", "���벻��Ϊ��");
		}
		if(this.hobby == null || this.hobby.trim().equals(""))
		{
			isOk = false;
			errors.put("hobby", "���ò���Ϊ��");
		}
			
		return isOk;
	}
}





