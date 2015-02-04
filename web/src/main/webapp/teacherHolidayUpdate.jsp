<%@page import="java.util.List"%>
<%@page import="com.kevin.aeas.operation.db.OperationManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Date"%>
<%@page import="com.kevin.aeas.object.TeacherHoliday"%>
<%@page import="com.kevin.aeas.operation.db.TeacherHolidayOperation"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.kevin.aeas.utils.DateHelp"%>
<%@page import="com.kevin.aeas.object.TeacherDefaultHoliday"%>
<%@page import="com.kevin.aeas.operation.db.TeacherDefaultHolidayOperation"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.kevin.aeas.object.Teacher"%>
<%@page import="com.kevin.aeas.operation.db.TeacherOperation"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>调整修改</title>
<link href="css/bootstrap.css" rel="stylesheet">
<script  src="js/Calendar3.js" >
</script>

</head>
<body>
  <div class="container">
	<%
	    //PrintWriter out = response.getWriter();
		int teacherId = Integer.valueOf(request.getParameter("id"));
		
		TeacherOperation teacherOperation = OperationManager.getInstance().getTeacherOperation();
		TeacherDefaultHolidayOperation teacherDefaultHolidayOperation = OperationManager.getInstance().getTeacherDefaultHolidayOperation();
		TeacherHolidayOperation teacherHolidayOperation =  OperationManager.getInstance().getTeacherHolidayOperation();
		
		if (request.getParameter("submit") != null) {
			String control_date  = request.getParameter("control_date");
			if(control_date != null && !control_date.equals("")){
			    boolean setHoliday = Boolean.parseBoolean(request.getParameter("setHoliday"));
			    TeacherHoliday teacherHoliday = teacherHolidayOperation.getByTeacherAndDate(teacherId, control_date);
		        if(teacherHoliday == null){
		        	teacherHoliday = new TeacherHoliday();
		        	teacherHoliday.setTeacherId(teacherId);
		        	teacherHoliday.setAdjustDate(Date.valueOf(control_date));
		        	teacherHoliday.setIsHoliday(setHoliday);
		        	teacherHolidayOperation.add(teacherHoliday);
		        }else{
		        	teacherHoliday.setIsHoliday(setHoliday);
		        	teacherHolidayOperation.update(teacherHoliday);
		        }
			}
		}
		
	    
	    
	    
	    
	    Teacher teacher = teacherOperation.get(teacherId);
	    TeacherDefaultHoliday teacherDefaultHoliday = teacherDefaultHolidayOperation.getByTeacherId(teacherId);
	    List<TeacherHoliday> holidayList = teacherHolidayOperation.getByTeacherId(teacherId);
	    
	    //Date date = new Date();
	    Calendar calendar = Calendar.getInstance();
	    //calendar.setTime(date);
	    //calendar.add(Calendar.MONTH, 1);
	%>
	老师:<%= teacher.getName()%> &nbsp;休假情况<br>
	
	 <br>
	 <%
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
	 %>
	日期:<%= calendar.get(Calendar.YEAR) %>.<%=calendar.get(Calendar.MONTH)+1 %><br>
	  <div class="table-responsive"> 
	   <table class="table table-striped table-bordered">
	     <thead>
		<tr>
			<th>周一</th>
			<th>周二</th>
			<th>周三</th>
			<th>周四</th>
			<th>周五</th>
			<th>周六</th>
			<th>周日</th>
		</tr>
		</thead>
		<tbody>
		<% 		
		int i=1;
		int days = DateHelp.getDaysInMonth(calendar);
		int week = DateHelp.getWeek(calendar);
		for(i =1; i< week; i++){
			if(i==1)
				out.print("<tr>\r\n");
			out.print("<td></td>\r\n");
		}
		
		for(i=1; i <= days; i++){
			week = DateHelp.getWeek(calendar);
			if(week % 7 == 1)
				out.print("<tr>\r\n");
			if(DateHelp.isHoliday(calendar, teacherDefaultHoliday, holidayList)){
				out.print("<td>" + i + "休息" + "</td>");
			}
			else{
			out.print("<td>" + i + "</td>");
			}
			
			if(week % 7 ==0)
				out.print("</tr>\r\n");
			
						
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			
		}
		
		for(; week <7 ;week++){
			out.print("<td></td>\r\n");
			if(week+1 == 7)
				out.print("</tr>\r\n");
		}
				
		%>
		</tbody>
	</table>	
	</div>
	
	
		 <br>
		 	 <%
		//calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
	 %>
	日期:<%= calendar.get(Calendar.YEAR) %>.<%=calendar.get(Calendar.MONTH)+1 %><br>
	<div class="table-responsive"> 
	   <table class="table table-striped table-bordered">
	   <thead>
		<tr>
			<th>周一</th>
			<th>周二</th>
			<th>周三</th>
			<th>周四</th>
			<th>周五</th>
			<th>周六</th>
			<th>周日</th>
		</tr>
		</thead>
		<tbody>
		<% 
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		
		i=1;
		days = DateHelp.getDaysInMonth(calendar);
		week = DateHelp.getWeek(calendar);
		for(i =1; i< week; i++){
			if(i==1)
				out.print("<tr>\r\n");
			out.print("<td></td>\r\n");
		}
		
		for(i=1; i <= days; i++){
			week = DateHelp.getWeek(calendar);
			if(week % 7 == 1)
				out.print("<tr>\r\n");
			if(DateHelp.isHoliday(calendar, teacherDefaultHoliday, holidayList)){
				out.print("<td>" + i + "休息" + "</td>");
			}
			else{
			out.print("<td>" + i + "</td>");
			}
			
			if(week % 7 ==0)
				out.print("</tr>\r\n");
			
						
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			
		}
		
		for(; week <7 ;week++){
			out.print("<td></td>\r\n");
			if(week+1 == 7)
				out.print("</tr>\r\n");
		}
				
		%>
	  </tbody>
	</table>
	</div>
	
	
	<br>
	<%
		//calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
	 %>
	日期:<%= calendar.get(Calendar.YEAR) %>.<%=calendar.get(Calendar.MONTH)+1 %><br>
	<div class="table-responsive"> 
	   <table class="table table-striped table-bordered">
	   <thead>
		<tr>
			<th>周一</th>
			<th>周二</th>
			<th>周三</th>
			<th>周四</th>
			<th>周五</th>
			<th>周六</th>
			<th>周日</th>
		</tr>
		</thead>
		<tbody>
		<% 
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		
		i=1;
		days = DateHelp.getDaysInMonth(calendar);
		week = DateHelp.getWeek(calendar);
		for(i =1; i< week; i++){
			if(i==1)
				out.print("<tr>\r\n");
			out.print("<td></td>\r\n");
		}
		
		for(i=1; i <= days; i++){
			week = DateHelp.getWeek(calendar);
			if(week % 7 == 1)
				out.print("<tr>\r\n");
			if(DateHelp.isHoliday(calendar, teacherDefaultHoliday, holidayList)){
				out.print("<td>" + i + "休息" + "</td>");
			}
			else{
			out.print("<td>" + i + "</td>");
			}
			
			if(week % 7 ==0)
				out.print("</tr>\r\n");
			
						
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			
		}
		
		for(; week <7 ;week++){
			out.print("<td></td>\r\n");
			if(week+1 == 7)
				out.print("</tr>\r\n");
		}
				
		%>
	  </tbody>
	</table>
	</div>
		
	<br>
	<br>
	修改休假时间:<br>
	<form action="teacherHolidayUpdate.jsp" method="get">
	        <input type="hidden" name="id" value="<%= teacherId %>">
                <span>选择日期：</span> <span>
                    <input name="control_date" type="text" id="control_date" size="10"
                        maxlength="10" onclick="new Calendar().show(this);" readonly="readonly" />
                    </span>
                 <br>
                                           选择类型:
                 <input type="radio" name="setHoliday" value = "true" > 休假
                 <input type="radio" name="setHoliday" value = "false" checked> 上班<br>
                 <input type="submit" class="btn btn-default" value="提交" name="submit">
     </form>
   </div>          
</body>
</html>