package com.kevin.aeas.utils;

import javax.servlet.http.HttpServletRequest;

public class ContextUtils {
	public static String getBasePath(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + contextPath;
		return basePath;
	}
}
