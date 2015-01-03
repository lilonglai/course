package com.kevin.aeas.struts;

import org.apache.struts2.ServletActionContext;

import com.kevin.aeas.operation.v2.AeasOperationManager;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Object action = invocation.getAction();
		String userName = CookieUtils.getCookie("userName");
		String userPassword = CookieUtils.getCookie("userPassword");
		 if(action instanceof UserLogin || action instanceof UserRegister){
			 return invocation.invoke();
		 }
		 
		 if(UserUtils.validateLogin(userName, userPassword)){
			 return invocation.invoke();
		 }
		 else{
			 
		 }
		 
		return null;
	}
	

}
