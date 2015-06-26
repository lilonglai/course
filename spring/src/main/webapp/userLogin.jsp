<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>排课系统</title>
    <link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="user.html" role="form" method="get" onSubmit="return checkForm();">
        <input type="hidden" name="action" value="add">

        <div class="form-group">
            用户名: <input type="text" class="form-control" name="name"/>
        </div>
        <div class="form-group">
            密码: <input type="text" class="form-control" name="shortName"/>
        </div>
        <div class="form-group">
            验证码: <input type="text" class="form-control" name="phone"/>
        </div>

        <div class="form-group">
            <input type="submit" class="btn btn-default" value="登陆"/>
            <a class="btn btn-primary" href="userFindPassword.jsp">忘记密码?</a>
        </div>

        <div class="form-group">
            <a class="btn btn-primary" href="userRegister.jsp">没有账户请注册 </a>
        </div>

        <div class="form-group">
            第三方登入
            <a class="btn btn-primary" href="userRegister.jsp">新浪账号登陆 </a>
            <a class="btn btn-primary" href="userRegister.jsp">QQ账号登陆 </a>
        </div>
    </form>
</div>
</body>
</html>