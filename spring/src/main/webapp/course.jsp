<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>课程</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-2.1.1.js"></script>
    <script type="text/javascript">
        function modifyFirstCourse(courseId) {
            $("#firstCourseForm [name='id']").val(courseId);
            $("#firstCourseForm").attr("action","firstCourseUpdate.html" );
            $("#firstCourseForm").submit();
        }

        function deleteFirstCourse(courseId) {
            $("#firstCourseForm [name='id']").val(courseId);
            $("#firstCourseForm").attr("action","firstCourseDelete.html" );
            $("#firstCourseForm").submit();
        }

        function addFirstCourse(grade) {
            $("#firstCourseForm").attr("action","firstCourseAdd.html" );
            $("#firstCourseForm").submit();
        }


        function modifySecondCourse(courseId) {
            $("#secondCourseForm [name='id']").val(courseId);
            $("#secondCourseForm").attr("action","secondCourseUpdate.html" );
            $("#secondCourseForm").submit();
        }

        function deleteSecondCourse(courseId) {
            $("#secondCourseForm [name='id']").val(courseId);
            $("#secondCourseForm").attr("action","secondCourseDelete.html" );
            $("#secondCourseForm").submit();
        }

        function addSecondCourse(firstCourseId) {
            $("#secondCourseForm [name='id']").val(firstCourseId);
            $("#secondCourseForm").attr("action","secondCourseAdd.html" );
            $("#secondCourseForm").submit();
        }

        function gradeChanged() {
            $("#gradeForm").submit();
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
    </div>
</div>

<div class="container">
    <form method="get" action="course.html" name="gradeForm" id="gradeForm">
        选择年级:
        <select name="grade" onChange="gradeChanged();">
        <c:if test="${grade==1}">
            <option value="1" selected>4-6</option>
        </c:if>
        <c:if test="${grade!=1}">
            <option value="1">4-6</option>
        </c:if>
        <c:if test="${grade==2}">
            <option value="2" selected>7-9</option>
        </c:if>
        <c:if test="${grade!=2}">
            <option value="2">7-9</option>
        </c:if>
        <c:if test="${grade==3}">
            <option value="3" selected>10-12</option>
        </c:if>
        <c:if test="${grade!=3}">
            <option value="3">10-12</option>
        </c:if>
        </select>
    </form>
    <br>
    课程分类:<br>

    <div class="table-responsive">
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>编号</th>
                <th>课程名称</th>
                <th>课程简称</th>
                <th>课程描述</th>
                <th>操作</th>
            </tr>
            <thead>
            <tbody>

            <c:forEach var="firstCourse" items="${firstCourseList}" varStatus="status">
                <tr>
                    <td>${status.index}</td>
                    <td>${firstCourse.name}</td>
                    <td>${firstCourse.shortName}</td>
                    <td>${firstCourse.description}</td>

                    <td><input type="button" class="btn btn-default" value='修改'
                               onclick="modifyFirstCourse(${firstCourse.id})">
                        <input type="button" class="btn btn-default" value='删除'
                               onclick="deleteFirstCourse(${firstCourse.id})">
                        <input type="button" class="btn btn-default" value='增加具体课程'
                               onclick="addSecondCourse(${firstCourse.id})">
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>

    <input type="button" class="btn btn-default" value='增加课程' onclick="addFirstCourse(${grade})">

    <br> <br>
    课程详细信息:<br>

    <div class="table-responsive">
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>编号</th>
                <th>课程名称</th>
                <th>课程简称</th>
                <th>课程分类</th>
                <th>课程描述</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="secondCourse" items="${secondCourseList}" varStatus="status">
                <tr>
                    <td>${status.index}</td>
                    <td>${secondCourse.name}</td>
                    <td>${secondCourse.shortName}</td>
                    <td>${firstCourseOperation.get(secondCourse.id).name}
                    </td>
                    <td>${secondCourse.description}</td>

                    <td><input type="button" class="btn btn-default" value='修改'
                               onclick="modifySecondCourse(${secondCourse.id})">
                        <input type="button" class="btn btn-default" value='删除'
                               onclick="deleteSecondCourse(${secondCourse.id})">
                    </td>
                </tr>

            </c:forEach>

            </tbody>
        </table>
    </div>


    <form method="get" action="course.jsp" name="firstCourseForm" id="firstCourseForm">
        <input type="hidden" name="id">
        <input type="hidden" name="grade" value="${grade}">
    </form>

    <form method="get" action="course.jsp" name="secondCourseForm" id="secondCourseForm">
        <input type="hidden" name="id">
        <input type="hidden" name="grade" value="${grade}">
    </form>

</div>
</body>
</html>