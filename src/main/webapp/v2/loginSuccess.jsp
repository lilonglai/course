<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<title>Hello World</title>
</head>
<body>
    <h1><s:property value="userName" /> 成功</h1>
    <h2><s:a action="userLogin" > 注销 </s:a></a> </h2>
</body>
</html>