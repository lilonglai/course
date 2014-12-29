package com.kevin.aeas.struts;

import com.kevin.aeas.operation.v2.AeasOperationManager;

public class UserLogin {

	private String message;

	private String userName;

	private String userPassword;

	public UserLogin() {
	}

	public String execute() {
		if (validateLogin()) {
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

}
