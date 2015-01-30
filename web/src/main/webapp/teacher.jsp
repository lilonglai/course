<%@page import="com.kevin.aeas.operation.db.TeacherOperation"%>
<%@page import="com.kevin.aeas.operation.db.OperationManager"%>
<%@page import="com.kevin.aeas.object.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="com.kevin.aeas.operation.db.jpa.JpaOperationManager"%>
<%@page import="com.kevin.aeas.operation.db.jpa.JpaTeacherOperation"%>
<%@page import="com.kevin.aeas.object.oracle.OracleTeacher"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>老师</title>
<link href="css/bootstrap.css" rel="stylesheet">
<script type="text/javascript">
	function modifyTeacher(teacherId){
		var id= document.getElementById("id");
		id.value = teacherId;
		var form = document.getElementById("teacherForm");
		form.action="teacherUpdate.jsp";
		form.submit();	
	}
	
	function deleteTeacher(teacherId){
		var id= document.getElementById("id");
		id.value = teacherId;
		var action= document.getElementById("action");
		action.value = "delete";
		var form = document.getElementById("teacherForm");
		form.action="teacherServlet";
		form.submit();	
	}
	
	function retireTeacher(teacherId){
		var id= document.getElementById("id");
		id.value = teacherId;
		var action= document.getElementById("action");
		action.value = "retire";
		var form = document.getElementById("teacherForm");
		form.action="teacherServlet";
		form.submit();	
	}
	
	function addTeacher(){
		var form = document.getElementById("teacherForm");
		form.action="teacherAdd.jsp";
		form.submit();		
	}
	
	function modifyTeacherHoliday(teacherId){
		var id= document.getElementById("id");
		id.value = teacherId;
		var form = document.getElementById("teacherForm");
		form.action="teacherHolidayUpdate.jsp";
		form.submit();			
	}
	
	function modifyTeacherAbility(teacherId){
		var id= document.getElementById("id");
		id.value = teacherId;
		var form = document.getElementById("teacherForm");
		form.action="teacherAbility.jsp";
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
					<li><a href="./course.jsp">课程信息</a></li>
					<li><a href="./teacher.jsp">老师信息</a></li>
					<li><a href="./student.jsp">学生信息</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid -->
	</div>
   
   	<%
      		String statusString = request.getParameter("status");
      	      	      	    if(statusString ==null)
      	      	      	    	statusString = "2";
      	      	      	    int status = Integer.valueOf(statusString);
      	%>

    
   <div class="container">
   
   	<form action="teacher.jsp"  method="get" name="statusForm" id="statusForm">
	  <select name="status" onChange="document.getElementById('statusForm').submit()">
		<option value="1" <%=status==1?"selected":""%> >所有老师</option>
		<option value="2" <%=status==2?"selected":""%> >在职老师</option>
		<option value="3" <%=status==3?"selected":""%> >离职老师</option>
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
		<%
			List<Teacher> list = null;
				    TeacherOperation teacherOperation = OperationManager.getInstance().getTeacherOperation();
				    switch(status){
				    case 1:
				    	list = teacherOperation.getAll();
				    	break;
				    case 2:
				    	list = teacherOperation.getAlive();
				    	break;
				    case 3:
				    	list = teacherOperation.getNotAlive();
				    	break;
				    }
			
			int teacherCount = 1;
			for (Teacher teacher : list) {
		%>

		<tr>
		    <td><%= teacherCount++ %></td>
			<td><%=teacher.getName()%></td>
			<td><%=teacher.getShortName()%></td>
			<td><%=teacher.getPhone()%></td>			
			
		<%
		  if(teacher.getIsMaster()){
		%>
		  <td> <input type="checkbox" name="isMaster" checked disabled/> </td>
		<%
		  }
		  else{
		%>
		  <td> <input type="checkbox" name="isMaster" disabled /> </td>
		<%
		  }
		%>
			<td><input type="button" class="btn btn-default" value='修改' onclick="modifyTeacher(<%=teacher.getId()%>)"> 
			    <input type="button" class="btn btn-default" value='删除'  onclick="deleteTeacher(<%=teacher.getId()%>)">
			  <%  if(status == 2){
			  %>
			    <input type="button" class="btn btn-default" value='离职'  onclick="retireTeacher(<%=teacher.getId()%>)">
			    <input type="button" class="btn btn-default" value='修改假期'  onclick="modifyTeacherHoliday(<%=teacher.getId()%>)">
			    <input type="button" class="btn btn-default" value='修改能力'  onclick="modifyTeacherAbility(<%=teacher.getId()%>)">
			  <% }
			  %>
			    
		    </td>
		</tr>
		<%
			}
		%>
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