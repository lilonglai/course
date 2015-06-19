<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>增加新课程</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript">
        function checkForm() {
            var name = document.forms[0].name.value;
            if (name.length == 0) {
                alert("学生名字不能为空")
                return false;
            }
            var grade = document.forms[0].grade.value;
            if (grade.length == 0) {
                alert("请选择一个年级")
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
<div class="container">
    <form action="secondCourseAddSubmit.html" method="get" onSubmit="return checkForm();">
        <div class="form-group">
            课程名称: <input type="text" name="name"/>
        </div>
        <div class="form-group">
            课程简称: <input type="text" name="shortName"/>
        </div>
        <div class="form-group">
            课程分类: <select name="firstCourseId">
            <c:forEach var="firstCourse2" items="firstCourseList">
                <c:if test="firstCourse2.id == firstCourse.id">
                    <option value="{firstCourse2.id}" selected> ${firstCourse2.name}</option>
                </c:if>
                <c:if test="firstCourse2.id != firstCourse.id">
                    <option value="{firstCourse2.id}"> ${firstCourse2.name}</option>
                </c:if>
            </c:forEach>
        </select>
        </div>
        <div class="form-group">
            课程描述: <textarea rows="4" cols="25" name="description"> </textarea>
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-default" value="提交" name="submit"/>
        </div>
    </form>

</div>
</body>
</html>