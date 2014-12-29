<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<%@taglib uri="/struts-tags" prefix="s" %>

<html>
<head>
<title>Hello World</title>
</head>
<body>
    <s:form action="userRegister" >
        <s:textfield name="userName" label="用户名" />
        <s:password name="userPassword" label="设置密码" />
        <s:password name="userPasswordRepeat" label="确认密码" />
        <s:submit />
    </s:form>
</body>
</html>