<%@page import="com.kevin.aeas.utils.ContextUtils"%>
<%@page import="com.kevin.aeas.struts.UserUtils"%>
<%@page import="com.kevin.aeas.struts.CookieUtils"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>Hello World</title>
</head>
<body>
	<%
		String userName = CookieUtils.getCookie("userName");
		String userPassword = CookieUtils.getCookie("userPassword");
		if (!UserUtils.validateLogin(userName, userPassword)) {
			//request.getRequestDispatcher("/v2/userLogin.jsp").forward(request, response);
			String basePath = ContextUtils.getBasePath(request);
			String path =basePath + "/v2/userLogin.jsp";
			response.sendRedirect(path);
		}
	%>
	<h1>
		<s:property value="userName" />
		成功
	</h1>
	<h2>
		<s:a action="userLogin!logout.action"> 注销 </s:a>
	</h2>
</body>
</html>