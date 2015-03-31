<%@page import="com.kevin.aeas.operation.db.FirstCourseOperation"%>
<%@page import="com.kevin.aeas.object.FirstCourse"%>
<%@page import="com.kevin.aeas.operation.db.OperationManager"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改老师信息</title>
<link href="css/bootstrap.css" rel="stylesheet">
<script type="text/javascript">
    function checkForm(){
    	var name = document.forms[0].name.value;
    	if(name.length == 0){
    		alert("学生名字不能为空")
    		return false;
    		}
    	var grade =document.forms[0].grade.value;
    	if(grade.length ==0){
    		alert("请选择一个年级")
    		return false;
    	}
    	
    	return true;
    }
</script>
</head>
<body>
	<%
        FirstCourse firstCourse = null;
        FirstCourseOperation firstCourseOperation = OperationManager.getInstance().getFirstCourseOperation();
        String idStr = request.getParameter("id");
        if (idStr != null) {
            int id = Integer.valueOf(idStr);
            firstCourse = firstCourseOperation.get(id);
	%>
	
  <div class="container">
	<form action="firstCourseServlet?action=add" method="get" onSubmit="return checkForm();">
	    <input type="hidden" name="id" value="<%= firstCourse.getId() %>">
		<div class="form-group">
		年级: 
		     <input type="radio" name="grade" value = "1" <%=firstCourse.getGrade()==1?"checked":"" %>> 4-6
             <input type="radio" name="grade" value = "2" <%=firstCourse.getGrade()==2?"checked":"" %>> 7-9
             <input type="radio" name="grade" value = "3" <%=firstCourse.getGrade()==3?"checked":"" %>> 10-12
        </div>
        <div class="form-group">
		课程名称: <input type="text" name="name" value="<%= firstCourse.getName() %>"/>
		</div>
		<div class="form-group">
		课程简称: <input type="text" name="shortName" value="<%= firstCourse.getShortName() %>"/>
		</div>
		<div class="form-group">
		课程描述: 
		        <textarea rows="4" cols="25" name="description"> <%= firstCourse.getDescription() %> </textarea>
		</div>
		<div class="form-group">
		<input type="submit" class="btn btn-default" value="提交" />
		</div>
	</form>
  </div>
    <%
        }
    %>
</body>
</html>