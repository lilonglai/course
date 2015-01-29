<%@page import="com.kevin.aeas.operation.jpa.JpaTeacherOperation"%>
<%@page import="com.kevin.aeas.utils.GradeHelp"%>
<%@page import="java.util.List"%>
<%@page import="com.kevin.aeas.object.oracle.OracleStudent"%>
<%@page import="com.kevin.aeas.operation.jpa.JpaStudentOperation"%>
<%@page import="com.kevin.aeas.operation.jpa.JpaOperationManager"%>
<%@page import="com.kevin.aeas.utils.TeacherHelp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>学生</title>
<link href="css/bootstrap.css" rel="stylesheet">
<script  src="js/Calendar3.js" >
</script>

<script type="text/javascript">
	function modifyStudent(studentId){
		var id= document.getElementById("id");
		id.value = studentId;
		var form = document.getElementById("studentForm");
		form.action="studentUpdate.jsp";
		form.submit();	
	}
	
	function deleteStudent(studentId){
		var id= document.getElementById("id");
		id.value = studentId;
		var action= document.getElementById("action");
		action.value = "delete";
		var form = document.getElementById("studentForm");
		form.action="studentServlet";
		form.submit();	
	}
	
	function retireStudent(studentId){
		var id= document.getElementById("id");
		id.value = studentId;
		var action= document.getElementById("action");
		action.value = "retire";
		var form = document.getElementById("studentForm");
		form.action="studentServlet";
		form.submit();	
	}
	
	function addStudent(){
		var form = document.getElementById("studentForm");
		form.action="studentAdd.jsp";
		form.submit();		
	}
	
	function scheduleCourse(studentId){
		var id= document.getElementById("id");
		id.value = studentId;
		var form = document.getElementById("studentForm");
		form.action="schedule.jsp";
		form.submit();	
	}
	
	function importCourse(){
		var form = document.getElementById("importForm");
    	if(form.excelFile.value.length == 0){
    		alert("文件不能为空")
    		return false;
    		}
    	var index = form.excelFile.value.indexOf('.xls');
    	if(form.excelFile.value.length - index != 4){
    		alert("文件必须是excel")
    		return false;
    	}
		form.submit();		
	}
	
	function exportReport(){
		var form = document.getElementById("exportReportForm");
    	if(form.start_date.value.length == 0){
    		alert("开始时间不能为空")
    		return false;
    		}
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
       	JpaStudentOperation studentOperation = JpaOperationManager.getInstance().getStudentOperation();
                               JpaTeacherOperation teacherOperation = JpaOperationManager.getInstance().getTeacherOperation();
       %>
   
   <div class="container">
   	<form action="importCourse.jsp" enctype="multipart/form-data" method="post" name="importForm" id="importForm">
		<input type="file" name="excelFile">
		<input type="button" class="btn btn-default" value="导入课表" id="importData" onclick="importCourse()">
	</form>
	<br>
	
	<form action="exportReport.jsp"  method="get" name="exportReportForm" id="exportReportForm">
	     <span>选择开始日期：</span> 
	     <span>
	        <input name="start_date" type="text" id="start_date" size="10"
	            maxlength="10" onclick="new Calendar().show(this);" readonly="readonly" />
	     </span>
     
	     <span>选择结束日期：</span> 
	     <span>
	        <input name="end_date" type="text" id="end_date" size="10"
	            maxlength="10" onclick="new Calendar().show(this);" readonly="readonly" />
	     </span>
	     
	     <input type="button" class="btn btn-default" value="生成总表"  onclick="exportReport()">
     </form>
     
	<br>
	
	<%
			String statusString = request.getParameter("status");
		    if(statusString ==null)
		    	statusString = "2";
		    int status = Integer.valueOf(statusString);
		%>
	<form action="student.jsp"  method="get" name="statusForm" id="statusForm">
		<select name="status" onChange="document.getElementById('statusForm').submit()">
			<option value="1" <%=status==1?"selected":""%> >所有学生</option>
			<option value="2" <%=status==2?"selected":""%> >在职学生</option>
			<option value="3" <%=status==3?"selected":""%> >毕业学生</option>
		</select>
	</form>
	
  <div class="table-responsive"> 
	<table class="table table-striped table-bordered">
	  <thead>
		<tr>			
			<th>学生姓名</th>
			<th>学生简称</th>
			<th>年级</th>
			<th>测试成绩</th>
			<th>目标分数</th>
			<th>考试时间</th>
			<th>考试地点</th>
			<th>班主任</th>
			<th>学生描述</th>
			<th>操作</th>
		</tr>
	 </thead>
	 
	 <tbody>

		<%
			List<OracleStudent> list = null;
				    switch(status){
				    case 1:
				    	list = studentOperation.getAll();
				    	break;
				    case 2:
				    	list = studentOperation.getAlive();
				    	break;
				    case 3:
				    	list = studentOperation.getNotAlive();
				    	break;
				    }
			for (OracleStudent student : list) {
		%>

		<tr>
		    
			<td><%=student.getName()%></td>
			<td><%=student.getShortName()%></td>
			<td><%=GradeHelp.getStringByNumber(student.getGrade()) %></td>
			<td><%=student.getTestScore()%></td>
			<td><%=student.getTargetScore()%></td>
			<td><%=student.getExamineDate()%></td>
			<td><%=student.getExaminePlace()%></td>
			<td><%=TeacherHelp.getTeacherName(teacherOperation, student.getTeacherId())%></td>
			<td><%=student.getDescription()%></td>							
			
			<td><input type="button" class="btn btn-default" value='修改' onclick="modifyStudent(<%=student.getId()%>)"> 
			    <input type="button" class="btn btn-default" value='删除'  onclick="deleteStudent(<%=student.getId()%>)">			    
			    <%  if(status == 2){
			    %>
			      <input type="button" class="btn btn-default" value='毕业'  onclick="retireStudent(<%=student.getId()%>)">
			      <input type="button" class="btn btn-default" value='排课'  onclick="scheduleCourse(<%=student.getId()%>)">
			    <%} 
			    %>
		    </td>
		</tr>
		<%
			}
		%>		
	  </tbody>
	</table>
	
  </div>

	<input type="button" class="btn btn-default" value='增加' onclick="addStudent()">
	
	<form method="get" action="student.jsp" name="studentForm" id="studentForm">
	  <input type="hidden" name="id" id="id">
	  <input type="hidden" name="action" id="action">
	</form>
	
  </div>
</body>
</html>