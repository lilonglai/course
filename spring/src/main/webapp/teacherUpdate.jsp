<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>修改老师信息</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript">
        function checkForm() {
            var name = document.forms[0].name.value;
            if (name.length == 0) {
                alert("老师名字不能为空");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>

<div class="container">
    <form action="teacherUpdateSubmit.html" method="get" onSubmit="return checkForm();">
        <input type="hidden" name="id" value="${teacher.id}">

        <div class="form-group">
            名称: <input type="text" class="form-control" name="name" value="${teacher.name}"/>
        </div>
        <div class="form-group">
            简称: <input type="text" class="form-control" name="shortName" value="${teacher.shortName}"/>
        </div>
        <div class="form-group">
            电话: <input type="text" class="form-control" name="phone" value="${teacher.phone}"/>
        </div>
        < class="form-group">
        <c:if test="${teacher.isMaster == true}">
        班主任: <input type="checkbox" name="isMaster" checked/> <br>
        </c:if>
        <c:if test="${teacher.isMaster == false}">
        班主任: <input type="checkbox" name="isMaster"/> <br>
        </c:if>
</div>
<div class="form-group">
    默认休假情况:<br> &nbsp;&nbsp;

    <c:if test="${teacherDefaultHoliday != null}">
        <input type="hidden" name="id2" value="${teacherDefaultHoliday.id}">
        <c:if test="teacherDefaultHoliday.getWeek1() == true}">
            周一 <input type="checkbox" name="weeks" value="week1" checked> &nbsp;
        </c:if>
        <c:if test="teacherDefaultHoliday.getWeek1() == false}">
            周一 <input type="checkbox" name="weeks" value="week1"> &nbsp;
        </c:if>

        <c:if test="teacherDefaultHoliday.getWeek2() == true}">
            周二 <input type="checkbox" name="weeks" value="week2" checked> &nbsp;
        </c:if>
        <c:if test="teacherDefaultHoliday.getWeek2() == false}">
            周二 <input type="checkbox" name="weeks" value="week2"> &nbsp;
        </c:if>

        <c:if test="teacherDefaultHoliday.getWeek3() == true}">
            周三 <input type="checkbox" name="weeks" value="week3" checked> &nbsp;
        </c:if>
        <c:if test="teacherDefaultHoliday.getWeek3() == false}">
            周三 <input type="checkbox" name="weeks" value="week3"> &nbsp;
        </c:if>

        <c:if test="teacherDefaultHoliday.getWeek4() == true}">
            周四 <input type="checkbox" name="weeks" value="week4" checked> &nbsp;
        </c:if>
        <c:if test="teacherDefaultHoliday.getWeek4() == false}">
            周四 <input type="checkbox" name="weeks" value="week4"> &nbsp;
        </c:if>

        <c:if test="teacherDefaultHoliday.getWeek5() == true}">
            周五 <input type="checkbox" name="weeks" value="week5" checked> &nbsp;
        </c:if>
        <c:if test="teacherDefaultHoliday.getWeek5() == false}">
            周五 <input type="checkbox" name="weeks" value="week5"> &nbsp;
        </c:if>

        <c:if test="teacherDefaultHoliday.getWeek6() == true}">
            周六 <input type="checkbox" name="weeks" value="week6" checked> &nbsp;
        </c:if>
        <c:if test="teacherDefaultHoliday.getWeek6() == false}">
            周六 <input type="checkbox" name="weeks" value="week6"> &nbsp;
        </c:if>

        <c:if test="teacherDefaultHoliday.getWeek7() == true}">
            周日 <input type="checkbox" name="weeks" value="week7" checked>
        </c:if>
        <c:if test="teacherDefaultHoliday.getWeek7() == false}">
            周日 <input type="checkbox" name="weeks" value="week7">
        </c:if>

    </c:if>

</div>
<div class="form-group">
    <input type="submit" class="btn btn-default" value="提交"/>
</div>
</form>

</div>
</body>
</html>