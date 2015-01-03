<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<%@taglib uri="/struts-tags" prefix="s" %>

<html>
<head>
<title>Hello World</title>
</head>
<body>
    <s:form action="userLogin" >
        <s:textfield name="userName" label="用户名" />
        <s:password name="userPassword" label="密码" />
        <s:checkbox name="rememberUser" label="自动登陆" />
        <s:submit />
    </s:form>
</body>
</html>