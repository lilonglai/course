<%@page import="java.util.List"%>
<%@page import="com.kevin.aeas.object.oracle.OracleFirstCourse"%>
<%@page import="com.kevin.aeas.operation.jpa.JpaFirstCourseOperation"%>
<%@page import="com.kevin.aeas.object.oracle.OracleSecondCourse"%>
<%@page import="com.kevin.aeas.operation.jpa.JpaSecondCourseOperation"%>
<%@page import="com.kevin.aeas.operation.jpa.JpaOperationManager"%>
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
		OracleSecondCourse secondCourse = null;
			    JpaSecondCourseOperation secondCourseOperation = JpaOperationManager.getInstance().getSecondCourseOperation();
			    JpaFirstCourseOperation firstCourseOperation = JpaOperationManager.getInstance().getFirstCourseOperation();
		if (request.getParameter("submit") != null) {
			
			
			int courseId = Integer.valueOf(request.getParameter("id"));
			secondCourse = secondCourseOperation.get(courseId);
			
			String name = request.getParameter("name");
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
			secondCourse.setName(name);

			String shortName = request.getParameter("shortName");
			shortName = new String(shortName.getBytes("iso-8859-1"),
			"utf-8");
			secondCourse.setShortName(shortName);

			int firstCourseId = Integer.valueOf((request.getParameter("firstCourseId")));
			OracleFirstCourse firstCourse = firstCourseOperation.get(firstCourseId);
			secondCourse.setAeasFirstCourse(firstCourse);
			
			String description = request.getParameter("description");
			description = new String(description.getBytes("iso-8859-1"),
			"utf-8");
			secondCourse.setDescription(description);

			secondCourseOperation.update(secondCourse);

			response.sendRedirect("course.jsp" + "?grade=" + firstCourseOperation.get(firstCourseId).getGrade());
		}
		
		else{
		    String idStr = (String)request.getParameter("id");
			    	int id = Integer.valueOf(idStr);	    	
			    	secondCourse = secondCourseOperation.get(id);
			    	
			    	OracleFirstCourse firstCourse = secondCourse.getAeasFirstCourse();
			        int grade = firstCourse.getGrade();
			        List<OracleFirstCourse> firstCourseList = firstCourseOperation.getByGrade(grade);
	%>
  <div class="container">
	<form action="secondCourseUpdate.jsp" method="get" onSubmit="return checkForm();">
	    <input type="hidden" name="id" value="<%=secondCourse.getId()%>">
	    <div class="form-group">
		课程名称: <input type="text" name="name" value="<%=secondCourse.getName()%>"/>
		</div>
		<div class="form-group">
		课程简称: <input type="text" name="shortName" value="<%=secondCourse.getShortName()%>"/>
		</div>
		<div class="form-group">
		课程分类: <select name="firstCourseId">
		<%
			for(OracleFirstCourse course:firstCourseList){
		%>
				<option value="<%= course.getId() %>" <%= course.getId()==secondCourse.getAeasFirstCourse().getId()?"selected":"" %>><%= course.getName() %></option>
				
		<% 
		     }
		%>				
			</select>
		</div>
		<div class="form-group">
		课程描述: <textarea rows="4" cols="25" name="description"> <%= secondCourse.getDescription() %> </textarea>
		</div>
		<div class="form-group">
		  <input type="submit" class="btn btn-default" value="提交" name="submit"/>
		</div>
	</form>
	
	<%
	    }
	    
	%>
  </div>   
</body>
</html>