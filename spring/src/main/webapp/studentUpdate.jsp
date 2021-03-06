<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>修改老师信息</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <script src="js/Calendar3.js">
    </script>
    <script type="text/javascript">
        function checkForm() {
            if ($("[name='name']").val().length == 0) {
                alert("学生名字不能为空")
                return false;
            }

            if ($("[name='grade']").val().length == 0) {
                alert("请选择一个年级")
                return false;
            }

            return true;
        }
    </script>
</head>
<body>

<div class="container">
    <form action="studentUpdateSubmit.html" method="get" onSubmit="return checkForm();">
        <input type="hidden" name="id" value="${student.id}">

        <div class="form-group">
            学生姓名: <input type="text" name="name" value="${student.name}"/>
        </div>
        <div class="form-group">
            学生简称: <input type="text" name="shortName" value="${student.shortName}"/>
        </div>
        <div class="form-group">
            年级:
            <c:if test="${student.grade==1}">
                <input type="radio" name="grade" value="1" checked> 4-6
            </c:if>
            <c:if test="${student.grade!=1}">
                <input type="radio" name="grade" value="1"> 4-6
            </c:if>
            <c:if test="${student.grade==2}">
                <input type="radio" name="grade" value="2" checked> 7-9
            </c:if>
            <c:if test="${student.grade!=2}">
                <input type="radio" name="grade" value="2"> 7-9
            </c:if>
            <c:if test="${student.grade==3}">
                <input type="radio" name="grade" value="3" checked> 10-12
            </c:if>
            <c:if test="${student.grade!=3}">
                <input type="radio" name="grade" value="3"> 10-12
            </c:if>

        </div>
        <div class="form-group">
            测试成绩: <input type="text" name="testScore" value="${student.testScore}"/>
        </div>
        <div class="form-group">
            目标分数: <input type="text" name="targetScore" value="${student.targetScore}"/>
        </div>
        <div class="form-group">
            考试时间:
		    <span> <input name="examineDate" type="text" id="examineDate" size="10"
                          maxlength="10" onclick="new Calendar().show(this);" readonly="readonly"
                          value="${student.examineDate}"/>
            </span><br>
            考试地点: <input type="text" name="examinePlace" value="${student.examinePlace}"/>
        </div>
        <div class="form-group">
            班主任:
            <select name="teacherId">
                <c:forEach var="teacher" items="${teacherList}">
                    <c:if test="${student.teacherId==teacher.id}">
                        <option value="${teacher.id}" selected> ${teacher.name} </option>
                    </c:if>
                    <c:if test="${student.teacherId!=teacher.id}">
                        <option value="${teacher.id}"> ${teacher.name} </option>
                    </c:if>
                </c:forEach>

            </select>
        </div>
        <div class="form-group">
            学生描述:
            <textarea rows="4" cols="25" name="description"> ${student.description} </textarea>
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-default" value="提交" name="submit"/>
        </div>
    </form>
</div>
</body>
</html>