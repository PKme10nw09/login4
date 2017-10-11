package com.internousdev.login4.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.login4.dao.LoginDAO;
import com.internousdev.login4.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private String username;
	private String password;
	private Map<String,Object> session;
	public String execute(){
		String ret = ERROR;
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = dao.select(username,password);

		if(username.equals(dto.getUsername())){
			if(password.equals(dto.getPassword())){
				session.put("username","taro");
				System.out.println((String)session.get("username"));

				session.put("password","123");
				System.out.println((String)session.get("password"));

				ret = SUCCESS;
			}
		}
		return ret;
	}
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
	public Map<String, Object> getSession() {
		return this.session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
