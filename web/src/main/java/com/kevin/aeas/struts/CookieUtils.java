package com.kevin.aeas.struts;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class CookieUtils {
	public static void addCookie(String name, String value){
		Cookie cookie = new Cookie(name, value);
		ServletActionContext.getResponse().addCookie(cookie);
	}
	
	public static void addCookie(HttpServletResponse response, String name, String value){
		Cookie cookie = new Cookie(name, value);
		response.addCookie(cookie);
	}
	
	public static void removeCookie(String name){
		Cookie cookie = new Cookie(name, null);
		cookie.setMaxAge(0);
		ServletActionContext.getResponse().addCookie(cookie);
	}
	
	public static void removeCookie(HttpServletResponse response, String name){
		Cookie cookie = new Cookie(name, null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	
	public static String getCookie(String name){
		HttpServletRequest request = ServletActionContext.getRequest();
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if(cookie.getName().equals(name))
				return cookie.getValue();
		}
		
		return null;
	}
	
	public static String getCookie(HttpServletRequest request, String name){
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if(cookie.getName().equals(name))
				return cookie.getValue();
		}
		
		return null;
	}
	

}
