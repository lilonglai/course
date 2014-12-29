<%@page import="com.kevin.aeas.excel.GenerateStudentCourse"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
  <% 
     String studentIdStr = request.getParameter("studentId");
     if(studentIdStr == null || studentIdStr.equals("")){    	 
    	 out.println("没有指定学生");
     }else{
    	 int studentId = Integer.valueOf(studentIdStr);
    	 GenerateStudentCourse generateStudentCourse = new GenerateStudentCourse(studentId);
    	 response.setContentType("application/vnd.ms-excel");
    	 generateStudentCourse.exportCourse(response.getOutputStream());

     }
     
     
  
  %>
</body>
</html>