<%@page import="java.sql.Date"%>
<%@page import="com.kevin.aeas.object.SecondCourse"%>
<%@page import="com.kevin.aeas.operation.SecondCourseOperation"%>
<%@page import="com.kevin.aeas.object.FirstCourse"%>
<%@page import="com.kevin.aeas.operation.FirstCourseOperation"%>
<%@page import="com.kevin.aeas.utils.TimeHelp"%>
<%@page import="com.kevin.aeas.object.Schedule"%>
<%@page import="com.kevin.aeas.operation.ScheduleOperation"%>
<%@page import="com.kevin.aeas.object.Teacher"%>
<%@page import="com.kevin.aeas.operation.TeacherOperation"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kevin.aeas.object.Student"%>
<%@page import="com.kevin.aeas.operation.StudentOperation"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>课表信息</title>
<link href="css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="js/Calendar3.js" > </script>
<script type="text/javascript" src="js/jquery-2.1.1.js"></script>

<script type="text/javascript">

	function setData(selectObject, jsonData) {
		//clear data
		var length = selectObject.options.length;
		
		for(var i = length -1; i >=0; i--){
			selectObject.options.remove(i);
		}		
		
		
		for(var i = 0; i < jsonData.length; i++){
			var item = new Option(jsonData[i].name,jsonData[i].id);
			selectObject.options.add(item);
		}
		
		selectObject.selectedIndex =0;
	}

    function chooseSecondCourse(){
    	var onDate= document.scheduleForm.onDate.value;
    	var index = document.scheduleForm.onTime.selectedIndex;
    	var onTime = document.scheduleForm.onTime.options[index].value;
    	var studentId = document.scheduleForm.id.value;
    	index = document.scheduleForm.firstCourseId.selectedIndex;
    	var firstCourseId = document.scheduleForm.firstCourseId.options[index].value;
    	if(onDate.length==0){
    		alert("日期不能为空，请选择日期");
    		document.scheduleForm.onDate.focus();
    		return;
    	}    	

    	$.ajax({
            url: "service/schedule/getSecondCourseAndTeacherList",
            type: "POST",
            data: {onDate:onDate,onTime:onTime,studentId:studentId,firstCourseId:firstCourseId}
        }).done(function(data) {
        	var jsonData = eval(data);
        	setData(document.scheduleForm.secondCourseId,jsonData.secondCourseList);
        	setData(document.scheduleForm.teacherId,jsonData.teacherList);
        });

    }
    
    function chooseAvailableTeacher(){
    	var onDate= document.scheduleForm.onDate.value;
    	var index = document.scheduleForm.onTime.selectedIndex;
    	var onTime = document.scheduleForm.onTime.options[index].value;
    	$.ajax({
            url: "service/schedule/getAvailableTeacherList",
            type: "POST",
            data: {onDate:onDate,onTime:onTime}
        }).done(function(data) {
        	var jsonData = eval(data);
        	setData(document.scheduleForm.availableTeacher,jsonData);
        });
    }
    
    function changeOnDate(){
    	document.scheduleForm.onTime.selectedIndex=0;
    	var onDate= document.scheduleForm.onDate.value;
    	var index = document.scheduleForm.onTime.selectedIndex;
    	var onTime = document.scheduleForm.onTime.options[index].value;
    	    	
    	$.ajax({
            url: "service/schedule/getAvailableTeacherList",
            type: "POST",
            data: {onDate:onDate,onTime:onTime}
        }).done(function(data) {
        	var jsonData = eval(data);
        	setData(document.scheduleForm.availableTeacher,jsonData);
        });
    }
    
    
    function deleteSchedule(id){
    	var scheduleId = document.deleteScheduleForm.scheduleId;
    	scheduleId.value = id;
    	var action = document.deleteScheduleForm.action;
    	action.value = "delete";
    	document.deleteScheduleForm.submit();
    }
    
    
    function verifyForm(){
    	
    }
</script>


</head>
<body>
	<%
	
	    StudentOperation studentOperation = new StudentOperation();
	    FirstCourseOperation firstCourseOperation = new FirstCourseOperation();
	    SecondCourseOperation secondCourseOperation = new SecondCourseOperation();
	    TeacherOperation teacherOperation = new TeacherOperation();
	    ScheduleOperation scheduleOperation = new ScheduleOperation();
	    
		int studentId = (Integer.valueOf(request.getParameter("id")));
		Student student = studentOperation.get(studentId);
		ArrayList<FirstCourse> firstCourseList = firstCourseOperation.getByGrade(student.getGrade());
		ArrayList<Teacher> teacherList = teacherOperation.getAll();
		
		ArrayList<Schedule> scheduleList = scheduleOperation.getByStudentId(studentId);
		
		double totalHours = 0;
		
		
	%>
	
	<div class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">排课系统</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="./student.jsp">学生信息</a></li>
					<li><a href="./studentUpdate.jsp?id=<%=studentId %>">修改学生信息</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid -->
	</div>
	
  <div class="container">
	学生:<%=student.getName()%>
	<form action="exportCourse.jsp" enctype="multipart/form-data" method="get">
	    <input type="hidden", name ="studentId" value="<%= student.getId() %>">
		<input type="submit" value="生成课表" id="exportData">
	</form>
	<br>
	<br>
	
	课程表信息:<br>
	
	<div class="table-responsive"> 
	  <table class="table table-striped table-bordered">
	    <thead>
		  <tr>
			<th>日期</th>
			<th>时间</th>
			<th>课程</th>
			<th>老师</th>
			<th>描述</th>
			<th>操作</th>
		  </tr>
		 </thead>
		 <tbody>
		<%
		    for(Schedule schedule : scheduleList){
		    	SecondCourse secondCourse = secondCourseOperation.get(schedule.getCourseId());
		    	Teacher teacher = teacherOperation.get(schedule.getTeacherId());
		        if(schedule.getOnTime() == 1){
		        	totalHours += 2.5;
		        }
		        else{
		        	totalHours += 2;
		        }
		%>

		<tr>
			<td><%=schedule.getOnDate() %></td>
			<td><%=TimeHelp.getStringByNumber(schedule.getOnTime())%></td>
			<td><%=secondCourse !=null?secondCourse.getName():"" %></td>
			<td><%=teacher.getName()%></td>
			<td><%=schedule.getDescription()%></td>
			<td><input type="button" value='修改' onclick="modifyStudent(<%=schedule.getId()%>)"> 
			    <input type="button" value='删除'  onclick="deleteSchedule(<%=schedule.getId()%>)">
		    </td>
		</tr>
		<%
			}
		%>
	  </tbody>
	</table>
	</div>
	
	<p>总课时: <%=totalHours %> </p>
	<br>
	
	<h2>开始排课</h2>
	
<form method="get" action="scheduleServlet" name="scheduleForm" id="scheduleForm">
   <input type="hidden" name="id" value="<%=studentId%>">
   <input type="hidden" name="scheduleId">
<table>
  <tr>
    <td>  选择日期:
			<span> <input name="onDate" type="text" id="onDate" size="10"
		               maxlength="10" onclick="new Calendar().show(this);" readonly="readonly" 
		               value="<%=request.getParameter("onDate")==null?"":request.getParameter("onDate") %>" 
		               >
		    </span><br>
			选择时间: <select name="onTime" onChange="chooseAvailableTeacher()">
			        <option value="0" >请选择时间</option>
					<option value="1" >9:00-11:30</option>
					<option value="2" >12:30-14:30</option>
					<option value="3" >14:45-16:45</option>
				</select> <br>
				
			空闲老师:<br> 
			     <select name="availableTeacher" size="25"  
					style="width: 200px" >
				</select><br>
    </td>
    <td>
    	选择课程:<br>
	          <select name="firstCourseId" size="25"
					style="width: 200px" onChange="chooseSecondCourse()">
						<%
						  for(FirstCourse firstCourse: firstCourseList){
						%>
						    <option value="<%=firstCourse.getId()%>"> <%= firstCourse.getName() %>
						<%
						  }
						%>
				</select><br>
    </td>
    
        <td>
    	选择课程内容:<br>
	          <select name="secondCourseId" size="25"  
					style="width: 200px" >
				</select><br>
    </td>
    
    <td>
		    选择老师:<br>
	          <select name="teacherId" size="20" 
				style="width: 200px">
					<%
					  for(Teacher teacher: teacherList){
					%>
					    <option value="<%=teacher.getId()%>"> <%= teacher.getName() %>
					<%
					  }
					%>
			</select><br>
    </td>
    
    <td>
	              描述:<br>
	       <textarea rows="4" cols="25" name="description"> </textarea><br>
    </td>
  </tr>
</table>
<input type="submit" value="提交" name="scheduleSubmit"/>
</form>

<form method="get" action="scheduleServlet" name="deleteScheduleForm" id="deleteScheduleForm">
    <input type="hidden" name="id" value="<%=studentId%>">
	<input type="hidden" name="scheduleId" id="scheduleId">
	<input type="hidden" name="action" id="action">
</form>

  </div>
</body>
</html>