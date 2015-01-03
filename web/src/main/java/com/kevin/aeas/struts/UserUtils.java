package com.kevin.aeas.struts;

import com.kevin.aeas.operation.v2.AeasOperationManager;

public class UserUtils {
	public static boolean validateLogin(String userName, String userPassword) {
		if(userName == null || userPassword == null)
			return false;
		
		userName = userName.trim();
		userPassword = userPassword.trim();

		if (userName.equals("") || userPassword.equals(""))
			return false;

		if (isExistUser(userName, userPassword))
			return true;

		return false;

	}

	public static boolean isExistUser(String userName, String userPassword) {
		return AeasOperationManager.getInstance().getUserOperation()
				.isExistUser(userName, userPassword);
	}
}
