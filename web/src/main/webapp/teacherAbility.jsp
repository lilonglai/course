<%@page import="com.kevin.aeas.operation.db.OperationManager"%>
<%@page import="com.kevin.aeas.object.oracle.OracleTeacher"%>
<%@page import="com.kevin.aeas.operation.db.jpa.JpaOperationManager"%>
<%@page import="com.kevin.aeas.operation.db.jpa.JpaTeacherOperation"%>
<%@page import="com.kevin.aeas.object.FirstCourse"%>
<%@page import="com.kevin.aeas.operation.db.FirstCourseOperation"%>
<%@page import="com.kevin.aeas.utils.GradeHelp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kevin.aeas.operation.db.TeacherAbilityOperation"%>
<%@page import="com.kevin.aeas.object.TeacherAbility"%>
<%@page import="com.kevin.aeas.object.Teacher"%>
<%@page import="com.kevin.aeas.operation.db.TeacherOperation"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>老师能力信息</title>
<link href="css/bootstrap.css" rel="stylesheet">

<script language="JavaScript">
	function copyToList(from, to) {
		fromList = eval('document.abilityForm.' + from);
		toList = eval('document.abilityForm.' + to);
		if (toList.options.length > 0 && toList.options[0].value == 'temp') {
			toList.options.length = 0;
		}
		var sel = false;
		for (i = 0; i < fromList.options.length; i++) {
			var current = fromList.options[i];
			if (current.selected) {
				sel = true;
				txt = current.text;
				val = current.value;
				toList.options[toList.length] = new Option(txt, val);
				fromList.options[i] = null;
				i--;
			}
		}
		if (!sel)
			alert('你还没有选择任何项目');
	}
	
	function allSelect() {
		List = document.abilityForm.chosen;
		for (i = 0; i < List.length; i++) {
			List.options[i].selected = true;
		}
	}
	
	function gradeChanged(){
		//alert(document.abilityForm);
		//document.abilityForm.submit();
		var form = document.getElementById("abilityForm");
		form.submit();
	}
</script>

</head>
<body>
	<%
		TeacherOperation teacherOperation = OperationManager.getInstance().getTeacherOperation();
			TeacherAbilityOperation teacherAbilityOperation = OperationManager.getInstance().getTeacherAbilityOperation();
			FirstCourseOperation firstCourseOperation = OperationManager.getInstance().getFirstCourseOperation();
			
			int teacherId = Integer.valueOf(request.getParameter("id"));
			int grade = 3;
			if(request.getParameter("grade") != null){
		grade = Integer.valueOf(request.getParameter("grade"));
			}
			
			if(request.getParameter("abilitySubmit") != null){
		int oldGrade = Integer.valueOf(request.getParameter("oldGrade"));
		if(grade == oldGrade){
			String[] chosenCourses = request.getParameterValues("chosen");
			//teacherAbilityOperation.deleteByTeacherId(teacherId);
			teacherAbilityOperation.deleteByTeacherAndGrade(teacherId, grade);
			TeacherAbility teacherAbility = new TeacherAbility();
			teacherAbility.setTeacherId(teacherId);
			if(chosenCourses != null){
		for(String chosenCourse:chosenCourses){
			teacherAbility.setCourseId(Integer.valueOf(chosenCourse));
			teacherAbilityOperation.add(teacherAbility);
		}
			}
		}
		

			}
		
		
		Teacher teacher = teacherOperation.get(teacherId);

		
		ArrayList<TeacherAbility> teacherAbilityList = teacherAbilityOperation.getByTeacherId(teacherId);
		
		

		
		ArrayList<FirstCourse> firstCourseList = firstCourseOperation.getByGrade(grade);
		ArrayList<FirstCourse> selectedFirstCourseList =new ArrayList<FirstCourse>();
		for(int i = 0; i < teacherAbilityList.size(); i++){
			TeacherAbility teacherAbility = teacherAbilityList.get(i);
			for(int j = 0; j<firstCourseList.size(); j++){
		if(teacherAbilityList.get(i).getCourseId() == firstCourseList.get(j).getId()){
			selectedFirstCourseList.add(firstCourseList.get(j));
			firstCourseList.remove(j);
		}
			}
		}
	%>
	
		<div class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">排课系统</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="./teacher.jsp">老师信息</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid -->
	</div>
	
  <div class="container">
	老师:<%=teacher.getName()%><br>
	<h2>目前能力情况</h2>
	<br>

	<div class="table-responsive"> 
	   <table class="table table-striped table-bordered">
	   <thead>
		<tr>
			<th>年级</th>
			<th>课程名称</th>
			<th>课程简称</th>
		</tr>
      </thead>
      <tbody>
		<%
		    for(TeacherAbility teacherAbility : teacherAbilityList){
		    	FirstCourse firstCourse = firstCourseOperation.get(teacherAbility.getCourseId());
		    
		%>

		<tr>
			<td><%=GradeHelp.getStringByNumber(firstCourse.getGrade()) %></td>
			<td><%=firstCourse.getName()%></td>
			<td><%=firstCourse.getShortName()%></td>

		</tr>
		<%
			}
		%>
	  </tbody>
	  </table>
	</div>

	<br>
	 <h2> 修改能力</h2>	 
	<form action="teacherAbility.jsp" method="get" name="abilityForm" id="abilityForm" onSubmit="allSelect();"">
		<input type="hidden" name="id" value="<%=teacher.getId()%>">
		<div class="form-group">
		选择年级: <select name="grade" onChange="gradeChanged();">
			<option value="1" <%= grade==1?"selected":"" %>>4-6</option>
			<option value="2" <%= grade==2?"selected":"" %>>7-9</option>
			<option value="3" <%= grade==3?"selected":"" %>>10-12</option>
		</select>
		</div>
		
		<input type="hidden" name="oldGrade" value="<%=grade%>">
		
		<div class="form-group">
		<table border="0">
			<tr>
				<td><select name="possible" size="25" MULTIPLE width=200
					style="width: 200px">
						<%
						  for(FirstCourse firstCourse: firstCourseList){
						%>
						    <option value="<%=firstCourse.getId()%>"> <%= firstCourse.getName() %>
						<%
						  }
						%>
				</select></td>

				<td><input type="button" value='>>'
					onclick="copyToList('possible','chosen')"> <br>
				<br> <input type="button" value='<<' onclick="copyToList('chosen','possible')">
				</td>

				<td><select name="chosen" size="25" MULTIPLE width=200
					style="width: 200px;">
						<%
						  for(FirstCourse firstCourse: selectedFirstCourseList){
						%>
						    <option value="<%=firstCourse.getId()%>"> <%= firstCourse.getName() %>
						<%
						  }
						%>
				</select></td>
			</tr>
		</table>
		</div>
		<div class="form-group">
		<input type="submit" class="btn btn-default" value="提交" name="abilitySubmit">
		</div>
	</form>

	<br>
	<br>
  </div>

</body>
</html>