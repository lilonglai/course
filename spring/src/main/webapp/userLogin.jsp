<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>排课系统</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-2.1.1.js"></script>

    <script type="text/javascript">
        function checkForm() {
            if ($("[name='userName']").val().length == 0) {
                alert("用户名不能为空")
                return false;
            }

            if ($("[name='userPassword']").val().length == 0) {
                alert("密码不能为空")
                return false;
            }

            if ($("[name='userVerifyCode']").val().length == 0) {
                alert("验证码不能为空")
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
<div class="container">
    <form action="userLoginSubmit.html" role="form" method="get" onSubmit="return checkForm();">
        <input type="hidden" name="action" value="add">

        <div class="form-group">
            用户名: <input type="text" class="form-control" name="userName"/>
        </div>
        <div class="form-group">
            密码: <input type="text" class="form-control" name="userPassword"/>
        </div>
        <div class="form-group">
            验证码: <input type="text" class="form-control" name="userVerifyCode"/>
            <img id="userVerifyImage"  alt="" src="userVerifyCode.html"/>
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