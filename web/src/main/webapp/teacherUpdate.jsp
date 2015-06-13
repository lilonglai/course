<%@page import="com.kevin.course.object.TeacherDefaultHoliday"%>
<%@page import="com.kevin.course.object.Teacher"%>
<%@ page import="com.kevin.course.operation.business.TeacherBusinessOperation" %>
<%@ page import="com.kevin.course.operation.business.TeacherDefaultHolidayBusinessOperation" %>
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
		if(name.length ==0){
			alert("老师名字不能为空");
			return false;
		}
		
		return true;	
	}
</script>
</head>
<body>
<%
    Teacher teacher = null;
    TeacherDefaultHoliday teacherDefaultHoliday = null;

    String idStr = request.getParameter("id");
    if (idStr != null) {
        int id = Integer.valueOf(idStr);
        TeacherBusinessOperation teacherOperation = new TeacherBusinessOperation();
        TeacherDefaultHolidayBusinessOperation teacherDefaultHolidayOperation = new TeacherDefaultHolidayBusinessOperation();
        teacher = teacherOperation.get(id);
        teacherDefaultHoliday = teacherDefaultHolidayOperation.getByTeacherId(id);
%>
	<div class="container">
	<form action="teacherServlet" method="get" onSubmit="return checkForm();">
	    <input type="hidden" name="action" value="update">
	    <input type="hidden" name="id" value="<%= teacher.getId() %>">
	    <div class="form-group">
		名称: <input type="text" class="form-control" name="name"  value="<%= teacher.getName() %>"/>
		</div>
		<div class="form-group">
		简称: <input type="text" class="form-control" name="shortName" value="<%= teacher.getShortName() %>"/>
		</div>
		<div class="form-group">
		电话: <input type="text" class="form-control" name="phone" value="<%= teacher.getPhone() %>" />
		</div>
		<div class="form-group">
		<%
		  if(teacher.getIsMaster()){
		%>
		班主任: <input type="checkbox" name="isMaster" checked/> <br>
		<%
		  }
		  else{
		%>
		班主任: <input type="checkbox" name="isMaster" /> <br>
		<%
		  }
		%>
		</div>
		<div class="form-group">
		默认休假情况:<br> &nbsp;&nbsp; 
		
		<%
		  if(teacherDefaultHoliday !=null){
		%>
		<input type="hidden" name="id2" value="<%= teacherDefaultHoliday.getId() %>">
		<%
		  }
		%>
		
		<% 
		  if(teacherDefaultHoliday != null && teacherDefaultHoliday.getWeek1()){
		%>
		周一 <input type="checkbox" name="weeks" value="week1" checked> &nbsp;
		<% 
		  }
		  else{
		%>
		周一 <input type="checkbox" name="weeks" value="week1"> &nbsp;
		<%
		  }
		%>
		
		<% 
		  if(teacherDefaultHoliday != null && teacherDefaultHoliday.getWeek2()){
		%>
		周二 <input type="checkbox" name="weeks" value="week2" checked> &nbsp;
		<% 
		  }
		  else{
		%>
		周二 <input type="checkbox" name="weeks" value="week2"> &nbsp;
		<%
		  }
		%>
		
		<% 
		  if(teacherDefaultHoliday != null && teacherDefaultHoliday.getWeek3()){
		%>
		周三 <input type="checkbox" name="weeks" value="week3" checked> &nbsp;
		<% 
		  }
		  else{
		%>
		周三 <input type="checkbox" name="weeks" value="week3"> &nbsp;
		<%
		  }
		%>
		
		
		<% 
		  if(teacherDefaultHoliday != null && teacherDefaultHoliday.getWeek4()){
		%>
		周四 <input type="checkbox" name="weeks" value="week4" checked> &nbsp;
		<% 
		  }
		  else{
		%>
		周四 <input type="checkbox" name="weeks" value="week4"> &nbsp;
		<%
		  }
		%>
		
		<% 
		  if(teacherDefaultHoliday != null && teacherDefaultHoliday.getWeek5()){
		%>
		周五 <input type="checkbox" name="weeks" value="week5" checked> &nbsp;
		<% 
		  }
		  else{
		%>
		周五 <input type="checkbox" name="weeks" value="week5"> &nbsp;
		<%
		  }
		%>
		
		<% 
		  if(teacherDefaultHoliday != null && teacherDefaultHoliday.getWeek6()){
		%>
		周六 <input type="checkbox" name="weeks" value="week6" checked> &nbsp;
		<% 
		  }
		  else{
		%>
		周六 <input type="checkbox" name="weeks" value="week6"> &nbsp;
		<%
		  }
		%>
		
		<% 
		  if(teacherDefaultHoliday != null && teacherDefaultHoliday.getWeek7()){
		%>
		周日 <input type="checkbox" name="weeks" value="week7" checked>
		<% 
		  }
		  else{
		%>
		周日 <input type="checkbox" name="weeks" value="week7">
		<%
		  }
		%>
       </div>
       <div class="form-group">
		 <input type="submit" class="btn btn-default" value="提交"/>
	   </div>
	</form>
	
	<%
	    }
	    
	%>
  </div>   
</body>
</html>