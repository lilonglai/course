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

            if ($("[name='userPassword2']").val().length == 0) {
                alert("密码不能为空")
                return false;
            }

            if ($("[name='userPassword2']").val() != $("[name='userPassword']").val()) {
                alert("密码不等于确认密码")
                return false;
            }

            if ($("[name='userEmail']").val().length == 0) {
                alert("验证码不能为空")
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
<div class="container">
    <form action="userRegisterSubmit.html" role="form" method="get" onSubmit="return checkForm();">
        <input type="hidden" name="action" value="add">

        <div class="form-group">
            用户名: <input type="text" class="form-control" name="userName"/>
        </div>
        <div class="form-group">
            密码: <input type="text" class="form-control" name="userPassword"/>
        </div>
        <div class="form-group">
            确认密码: <input type="text" class="form-control" name="userPassword2"/>
        </div>

        <div class="form-group">
            邮箱: <input type="text" class="form-control" name="userEmail"/>
        </div>

        <div class="form-group">
            QQ号: <input type="text" class="form-control" name="userQQ"/>
        </div>


        <div class="form-group">
            手机号: <input type="text" class="form-control" name="userTelephone"/>
        </div>

        <div class="form-group">
            描述: <textarea rows="4" cols="25" name="userDescription"> </textarea>
        </div>

        <div class="form-group">
            <input type="submit" class="btn btn-default" value="注册" />
        </div>
    </form>
</div>
</body>
</html>