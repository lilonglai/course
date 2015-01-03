package com.kevin.aeas.struts;

import com.kevin.aeas.object.v2.AeasUser;
import com.kevin.aeas.operation.v2.AeasOperationManager;

public class UserRegister {

	private String message;

	private String userName;

	private String userPassword;

	private String userPasswordRepeat;

	public UserRegister() {
	}

	public String execute() {
		if (validateRegister()) {
			registerUser();
			return "SUCCESS";
		}
		return "FAILURE";
	}

	private boolean validateRegister() {

		if (userPassword.equals(userPasswordRepeat) == false)
			return false;

		userName = userName.trim();
		userPassword = userPassword.trim();

		if (userName.equals("") || userPassword.equals(""))
			return false;

		if (isExistUser())
			return false;

		return true;
	}

	private boolean isExistUser() {
		return AeasOperationManager.getInstance().getUserOperation().isExistUser(userName, userPassword);
	}
	
	private void registerUser(){
		AeasUser user = new AeasUser();
		user.setName(userName);
		user.setPassword(userPassword);
		AeasOperationManager.getInstance().getUserOperation().add(user);
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

	public String getUserPasswordRepeat() {
		return userPasswordRepeat;
	}

	public void setUserPasswordRepeat(String userPasswordRepeat) {
		this.userPasswordRepeat = userPasswordRepeat;
	}

}
