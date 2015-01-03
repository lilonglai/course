<%@page import="com.kevin.aeas.excel.GenerateReport"%>
<%@page import="java.sql.Date"%>
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
		String tempString = request.getParameter("start_date");
	   
		Date start_date = null;
		if(tempString !=null && !tempString.equals("")){
			start_date = Date.valueOf(tempString);
		}
		
		Date end_date = null;
		tempString = request.getParameter("end_date");
		if(tempString !=null && !tempString.equals("")){
			end_date = Date.valueOf(tempString);
		}
		
		
   	   GenerateReport generateReport = new GenerateReport(start_date, end_date);
   	   response.setContentType("application/vnd.ms-excel");
   	   generateReport.generate(response.getOutputStream()); 
	%>
</body>
</html>