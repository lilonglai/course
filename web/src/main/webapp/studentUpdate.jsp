<%@page import="java.util.List"%>
<%@page import="com.kevin.aeas.object.oracle.OracleTeacher"%>
<%@page import="com.kevin.aeas.operation.db.jpa.JpaTeacherOperation"%>
<%@page import="com.kevin.aeas.operation.db.jpa.JpaOperationManager"%>
<%@page import="com.kevin.aeas.operation.db.jpa.JpaStudentOperation"%>
<%@page import="com.kevin.aeas.object.oracle.OracleStudent"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改老师信息</title>
<link href="css/bootstrap.css" rel="stylesheet">
<script  src="js/Calendar3.js" >
</script>
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
		OracleStudent student = null;
		JpaStudentOperation studentOperation = JpaOperationManager.getInstance().getStudentOperation();
			    JpaTeacherOperation teacherOperation = JpaOperationManager.getInstance().getTeacherOperation();	
			    String idStr = (String)request.getParameter("id");
			    if(idStr != null){
			    	int id = Integer.valueOf(idStr);	    	
			    	student = studentOperation.get(id);	    	
			    	List<OracleTeacher> teacherList = teacherOperation.getAll();
	%>	
	  <div class="container">
		<form action="studentServlet" method="get" onSubmit="return checkForm();">
		  <input type="hidden" name="action" value="update">
		  <input type="hidden" name="id" value="<%=student.getId()%>">
		<div class="form-group">      
		学生姓名: <input type="text" name="name" value="<%=student.getName()%>" />
		</div>
		<div class="form-group">
		学生简称: <input type="text" name="shortName" value="<%=student.getShortName()%>" />
		</div>
		<div class="form-group">
		 年级:
		     <input type="radio" name="grade" value = "1" <%=student.getGrade()==1?"checked":""%>> 4-6
             <input type="radio" name="grade" value = "2" <%=student.getGrade()==2?"checked":""%>> 7-9
             <input type="radio" name="grade" value = "3" <%=student.getGrade()==3?"checked":""%>> 10-12
        </div>
        <div class="form-group">        
		测试成绩: <input type="text" name="testScore" value="<%=student.getTestScore()%>" />
		</div>
		<div class="form-group">
		目标分数: <input type="text" name="targetScore" value="<%=student.getTargetScore()%>" />
		</div>
		<div class="form-group">
		考试时间: 
		    <span> <input name="examineDate" type="text" id="examineDate" size="10"
                        maxlength="10" onclick="new Calendar().show(this);" readonly="readonly" value="<%=student.getExamineDate()%>"/>
            </span><br>
		考试地点: <input type="text" name="examinePlace" value="<%=student.getExaminePlace()%>" />
		</div>
		<div class="form-group">
		班主任: 		
		<select name="teacherId" >
			<%
				for(OracleTeacher teacher:teacherList){
			%>
			  <option value="<%= teacher.getId() %>" <%= student.getTeacherId()==teacher.getId()?"selected":"" %>> <%= teacher.getName() %> </option>
			<% 
			}%>
			
		</select>
		</div>
		<div class="form-group">		
		学生描述: 
		<textarea rows="4" cols="25" name="description"> <%= student.getDescription() %> </textarea>
		</div>
		<div class="form-group">
		<input type="submit" class="btn btn-default" value="提交" name="submit" />
		</div>
	</form>
	
	<%
	    }
	    
	%>
  </div>  
</body>
</html>