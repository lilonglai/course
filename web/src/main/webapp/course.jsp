<%@page import="com.kevin.aeas.object.SecondCourse"%>
<%@page import="com.kevin.aeas.object.FirstCourse"%>
<%@page import="com.kevin.aeas.operation.db.OperationManager"%>
<%@page import="com.kevin.aeas.operation.db.SecondCourseOperation"%>
<%@page import="com.kevin.aeas.operation.db.FirstCourseOperation"%>
<%@page import="java.util.List"%>
<%@page import="com.kevin.aeas.object.oracle.OracleSecondCourse"%>
<%@page import="com.kevin.aeas.object.oracle.OracleFirstCourse"%>
<%@page import="com.kevin.aeas.operation.db.jpa.JpaSecondCourseOperation"%>
<%@page import="com.kevin.aeas.operation.db.jpa.JpaFirstCourseOperation"%>
<%@page import="com.kevin.aeas.operation.db.jpa.JpaOperationManager"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>课程</title>
<link href="css/bootstrap.css" rel="stylesheet">
<script type="text/javascript">
	function modifyFirstCourse(courseId){
		var form = document.firstCourseForm;
		var id= form.id;
		id.value = courseId;
		form.action="firstCourseUpdate.jsp";
		form.submit();	
	}
	
	function deleteFirstCourse(courseId){
		var form = document.firstCourseForm;
		var id= form.id;
		id.value = courseId;
		form.action="course.jsp";
		form.submit();	
	}
	
	function addFirstCourse(grade){
		var form = document.firstCourseForm;
		var id= form.id;
		id.value = grade;
		form.action="firstCourseAdd.jsp";
		form.submit();		
	}
	
	
	function modifySecondCourse(courseId){
		var form = document.secondCourseForm;
		var id= form.id;
		id.value = courseId;
		form.action="secondCourseUpdate.jsp";
		form.submit();	
	}
	
	function deleteSecondCourse(courseId){
		var form = document.secondCourseForm;
		var id= form.id;
		id.value = courseId;
		form.action="course.jsp";
		form.submit();	
	}
	
	function addSecondCourse(firstCourseId){
		var form = document.secondCourseForm;
		var id= form.id;
		id.value = firstCourseId;
		form.action="secondCourseAdd.jsp";
		form.submit();		
	}
	
	function gradeChanged(){
		//alert(document.abilityForm);
		//document.abilityForm.submit();
		var form = document.getElementById("gradeForm");
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
		</div>
	</div>
    
   <%
       	int grade =3;
                                   	if(request.getParameter("grade") != null){
                                   		grade = Integer.valueOf(request.getParameter("grade"));
                                   	}
                                      
                                   	FirstCourseOperation firstCourseOperation = OperationManager.getInstance().getFirstCourseOperation();
                                   	SecondCourseOperation secondCourseOperation = OperationManager.getInstance().getSecondCourseOperation();
                                   	
                                      if(request.getParameter("id") != null){
                                   	   int id = (Integer.valueOf(request.getParameter("id")));
                                   	   int flag = (Integer.valueOf(request.getParameter("flag")));
                                   	   if(flag==1){
                                   		   firstCourseOperation.delete(id);
                                   		   
                                   	   }
                                   	   else if(flag==2){
                                   		   secondCourseOperation.delete(id);
                                   	   }
                                   	   //courseOperation.delete(id);	   	   
                                      }
       %>
   
   <div class="container">
   	<form method="get" action="course.jsp" name="gradeForm" id="gradeForm">	  	
	                选择年级: <select name="grade" onChange="gradeChanged();">
				<option value="1" <%=grade==1?"selected":""%>>4-6</option>
				<option value="2" <%=grade==2?"selected":""%>>7-9</option>
				<option value="3" <%=grade==3?"selected":""%>>10-12</option>
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
					<%
						int firstCourseCount = 1;
												List<FirstCourse> FirstCourseList = firstCourseOperation.getByGrade(grade);
												for (FirstCourse firstCourse : FirstCourseList) {
					%>
			
					<tr>
					    <td><%=firstCourseCount++%></td>
						<td><%=firstCourse.getName()%></td>
						<td><%=firstCourse.getShortName()%></td>
						<td><%=firstCourse.getDescription()%></td>							
						
						<td><input type="button" class="btn btn-default" value='修改' onclick="modifyFirstCourse(<%=firstCourse.getId()%>)"> 
						    <input type="button" class="btn btn-default" value='删除'  onclick="deleteFirstCourse(<%=firstCourse.getId()%>)">
						    <input type="button" class="btn btn-default" value='增加具体课程'  onclick="addSecondCourse(<%=firstCourse.getId()%>)">
					    </td>
					</tr>
					<%
						}
					%>
				</tbody>
	     </table>	
	</div>
	
	<input type="button" class="btn btn-default" value='增加课程' onclick="addFirstCourse(<%=grade%>)">
	
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
		<%
			int secondCourseCount = 1;
				int firstCourseId = 0;
			List<SecondCourse> secondCourseList = secondCourseOperation.getByGrade(grade);
			for (SecondCourse secondCourse : secondCourseList) {
				if(firstCourseId == secondCourse.getFirstCourseId()){
					secondCourseCount++;
				}else{
					secondCourseCount = 1;
					firstCourseId= secondCourse.getFirstCourseId();
				}
				
				FirstCourse firstCourse = firstCourseOperation.get(firstCourseId);
		%>

		<tr>
		    <td><%=secondCourseCount%></td>
			<td><%=secondCourse.getName()%></td>
			<td><%=secondCourse.getShortName()%></td>
			<td><%=firstCourse.getName() %></td>
			<td><%=secondCourse.getDescription()%></td>							
			
			<td><input type="button" class="btn btn-default" value='修改' onclick="modifySecondCourse(<%=secondCourse.getId()%>)"> 
			    <input type="button" class="btn btn-default" value='删除'  onclick="deleteSecondCourse(<%=secondCourse.getId()%>)">
		    </td>
		</tr>
		<%
			}
		%>
	  </tbody>
	</table>
	</div>
	
	
	<form method="get" action="course.jsp" name="firstCourseForm" id="firstCourseForm">
	  <input type="hidden" name="id" >
	  <input type="hidden" name="flag" value="1" >	 
	  <input type="hidden" name="grade" value="<%=grade %>" >
	</form>
	
    <form method="get" action="course.jsp" name="secondCourseForm" id="secondCourseForm">
	  <input type="hidden" name="id" >
	   <input type="hidden" name="flag" value="2" >
	  <input type="hidden" name="grade" value="<%=grade %>" >

	</form>
	
  </div>
</body>
</html>