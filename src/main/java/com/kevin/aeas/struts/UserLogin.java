package com.kevin.aeas.struts;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.kevin.aeas.operation.v2.AeasOperationManager;

public class UserLogin {

	private String message;

	private String userName;

	private String userPassword;
	
	private boolean rememberUser; 

	public UserLogin() {
	}

	public String execute() {
		if (validateLogin()) {
			if(rememberUser == true){
				addCookie("userName", userName);
				addCookie("userPassword", userPassword);
			}
			return "SUCCESS";
		}
		return "FAILURE";
	}

	private boolean validateLogin() {
		userName = userName.trim();
		userPassword = userPassword.trim();

		if (userName.equals("") || userPassword.equals(""))
			return false;

		if (isExistUser())
			return true;

		return false;

	}
	
	private boolean isExistUser() {
		return AeasOperationManager.getInstance().getUserOperation().isExistUser(userName, userPassword);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public boolean getRememberUser() {
		return rememberUser;
	}

	public void setRememberUser(boolean rememberUser) {
		this.rememberUser = rememberUser;
	}
	
	private void addCookie(String name, String value){
		Cookie cookie = new Cookie(name, value);
		ServletActionContext.getResponse().addCookie(cookie);
	}
	
	private String getCookie(String name){
		HttpServletRequest request = ServletActionContext.getRequest();
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if(cookie.getDomain().equals(name))
				return cookie.getValue();
		}
		
		return null;
	}
	
	private void removeCookie(String name){
		Cookie cookie = new Cookie(name, null);
		cookie.setMaxAge(0);
		ServletActionContext.getResponse().addCookie(cookie);
	}
	

}
