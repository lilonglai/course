<%@page import="com.kevin.aeas.utils.ContextUtils"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>v2登陆系统</title>
</head>
<body>
  <%
    String basePath = ContextUtils.getBasePath(request);
    String path =basePath + "/v2/userLogin!login.action";
    //request.getRequestDispatcher(path).forward(request, response);
    response.sendRedirect(path);
  %>
</body>
</html>