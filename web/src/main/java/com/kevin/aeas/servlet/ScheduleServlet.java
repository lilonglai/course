package com.kevin.aeas.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kevin.aeas.object.Schedule;
import com.kevin.aeas.operation.db.ScheduleOperation;

/**
 * Servlet implementation class ScheduleServlet
 */
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleServlet() {
        super();
    }

    private void delete(int scheduleId){
		ScheduleOperation scheduleOperation = new ScheduleOperation();
		scheduleOperation.delete(scheduleId);
    }
    
    private void add(HttpServletRequest request){
		ScheduleOperation scheduleOperation = new ScheduleOperation();
		Schedule schedule = new Schedule();
		String tempStr =null;
		
		tempStr = request.getParameter("onDate");
		if(tempStr != null){
			schedule.setOnDate(Date.valueOf(tempStr));			
		}
		tempStr = request.getParameter("onTime");
		if(tempStr != null){
			schedule.setOnTime(Integer.valueOf(tempStr));			
		}
		tempStr = request.getParameter("id");
		if(tempStr != null){
			schedule.setStudentId(Integer.valueOf(tempStr));			
		}
		tempStr = request.getParameter("secondCourseId");
		if(tempStr != null){
			schedule.setCourseId(Integer.valueOf(tempStr));			
		}
		
		tempStr = request.getParameter("teacherId");
		if(tempStr != null){
			schedule.setTeacherId(Integer.valueOf(tempStr));			
		}

		tempStr = request.getParameter("description");
		if(tempStr != null){
			schedule.setDescription(tempStr);		
		}
		
		scheduleOperation.add(schedule);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action == null){
			String scheduleId = request.getParameter("scheduleId");
			if(scheduleId ==null || scheduleId.equals("")){
				action="add";
			}
			else{
				action="update";
			}
		}
		
		if(action.equals("delete")){
			int scheduleId = Integer.valueOf(request.getParameter("scheduleId"));
			delete(scheduleId);
			int studentId = Integer.valueOf(request.getParameter("id"));
			response.sendRedirect("schedule.jsp?id=" + studentId);
		}
		else if(action.equals("add")){
			add(request);
			int studentId = Integer.valueOf(request.getParameter("id"));
			response.sendRedirect("schedule.jsp?id=" + studentId);
		}
		else if(action.equals("update")){
			
		}
	}

}
