<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>老师</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript">
        function modifyTeacher(teacherId) {
            var id = document.getElementById("id");
            id.value = teacherId;
            var form = document.getElementById("teacherForm");
            form.action = "teacherUpdate.html";
            form.submit();
        }

        function deleteTeacher(teacherId) {
            var id = document.getElementById("id");
            id.value = teacherId;
            var action = document.getElementById("action");
            action.value = "delete";
            var form = document.getElementById("teacherForm");
            form.action = "teacherDelete.html";
            form.submit();
        }

        function retireTeacher(teacherId) {
            var id = document.getElementById("id");
            id.value = teacherId;
            var action = document.getElementById("action");
            action.value = "retire";
            var form = document.getElementById("teacherForm");
            form.action = "teacherRetire.html";
            form.submit();
        }

        function addTeacher() {
            var form = document.getElementById("teacherForm");
            form.action = "teacherAdd.html";
            form.submit();
        }

        function modifyTeacherHoliday(teacherId) {
            var id = document.getElementById("id");
            id.value = teacherId;
            var form = document.getElementById("teacherForm");
            form.action = "teacherHolidayUpdate.html";
            form.submit();
        }

        function modifyTeacherAbility(teacherId) {
            var id = document.getElementById("id");
            id.value = teacherId;
            var form = document.getElementById("teacherForm");
            form.action = "teacherAbility.html";
            form.submit();

        }
    </script>
</head>

<body>

<div class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">排课系统</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="./course.html">课程信息</a></li>
                <li><a href="./teacher.html">老师信息</a></li>
                <li><a href="./student.html">学生信息</a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
    <!--/.container-fluid -->
</div>

<div class="container">

    <form action="teacher.html" method="get" name="statusForm" id="statusForm">
        <select name="status" onChange="document.getElementById('statusForm').submit()">
            <c:if test="${status == 1}"> <option value="1" selected> 所有老师</option></c:if>
            <c:if test="${status != 1}"><option value="1"> 所有老师</option></c:if>
            <c:if test="${status == 2}"> <option value="2" selected> 在职老师</option></c:if>
            <c:if test="${status != 2}"><option value="2"> 在职老师</option></c:if>
            <c:if test="${status == 3}"> <option value="3" selected>离职老师</option></c:if>
            <c:if test="${status != 3}"><option value="3"> 离职老师</option></c:if>
        </select>
    </form>
    <div class="table-responsive">
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>编号</th>
                <th>名称</th>
                <th>简称</th>
                <th>电话</th>
                <th>是否为班主任</th>
                <th>操作</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="teacher" items="${teacherList}" varStatus="status">
                <tr>
                    <td>${status.index}</td>
                    <td>${teacher.name}</td>
                    <td>${teacher.shortName}</td>
                    <td>${teacher.phone}</td>
                    <c:if test="${teacher.isMaster == true}">
                        <td><input type="checkbox" name="isMaster" checked disabled/></td>
                    </c:if>
                    <c:if test="${teacher.isMaster == false}">
                        <td><input type="checkbox" name="isMaster" disabled/></td>
                    </c:if>

                    <td><input type="button" class="btn btn-default" value='修改' onclick="modifyTeacher(${teacher.id})">
                        <input type="button" class="btn btn-default" value='删除' onclick="deleteTeacher(${teacher.id})">
                        <c:if test="${teacher.isAlive == true}">
                            <input type="button" class="btn btn-default" value='离职'
                                   onclick="retireTeacher(${teacher.id})">
                            <input type="button" class="btn btn-default" value='修改假期'
                                   onclick="modifyTeacherHoliday(${teacher.id})">
                            <input type="button" class="btn btn-default" value='修改能力'
                                   onclick="modifyTeacherAbility(${teacher.id})">
                        </c:if>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>

    <input type="button" class="btn btn-default" value='增加' onclick="addTeacher()">

    <form method="get" action="teacher.jsp" name="teacherForm" id="teacherForm">
        <input type="hidden" name="id" id="id">
        <input type="hidden" name="action" id="action">
    </form>
</div>
</body>
</html>