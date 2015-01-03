package com.kevin.aeas.struts;

public class UserLogin {

	private String message;

	private String userName;

	private String userPassword;

	private boolean rememberUser;

	public UserLogin() {
	}

	public String execute() {
		if (UserUtils.validateLogin(userName, userPassword)) {
			if (rememberUser == true) {
				CookieUtils.addCookie("userName", userName);
				CookieUtils.addCookie("userPassword", userPassword);
			}
			return "SUCCESS";
		} else {
			// can not login succefully
			//TODO some code are needed to finish the module
			return "FAILURE";
		}
	}

	public String logout() {
		CookieUtils.removeCookie("userName");
		CookieUtils.removeCookie("userPassword");
		return "LOGIN";
	}

	public String login() {
		String userName = CookieUtils.getCookie("userName");
		String userPassword = CookieUtils.getCookie("userPassword");
		if (UserUtils.validateLogin(userName, userPassword)) {
			return "SUCCESS";
		} else {
			return "LOGIN";
		}

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

}
