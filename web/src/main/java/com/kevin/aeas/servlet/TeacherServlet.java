package com.kevin.aeas.servlet;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.object.TeacherDefaultHoliday;
import com.kevin.aeas.object.oracle.OracleTeacher;
import com.kevin.aeas.object.oracle.OracleTeacherDefaultHoliday;
import com.kevin.aeas.operation.db.OperationManager;
import com.kevin.aeas.operation.db.TeacherDefaultHolidayOperation;
import com.kevin.aeas.operation.db.TeacherOperation;
import com.kevin.aeas.utils.HttpRequestUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * this servlet is used to operate teacher user can add/delete/retire teacher
 * 
 * @author loli
 *
 */
public class TeacherServlet extends HttpServlet {

	private void delete(int id) {		
		TeacherOperation teacherOperation = OperationManager.getInstance().getTeacherOperation();
		teacherOperation.delete(id);
	}

	private void retire(int id) {
		TeacherOperation teacherOperation = OperationManager.getInstance().getTeacherOperation();
		teacherOperation.retire(id);
	}

	private void setObject(HttpServletRequest request, Teacher teacher) throws UnsupportedEncodingException{
		teacher.setName(HttpRequestUtil.getString(request, "name"));
		teacher.setShortName(HttpRequestUtil.getString(request, "shortName"));
		teacher.setPhone(request.getParameter("phone"));
		if (request.getParameter("isMaster") != null)
			teacher.setIsMaster(true);
		else
			teacher.setIsMaster(false);
	}

	private void setObject(HttpServletRequest request, TeacherDefaultHoliday teacherDefaultHoliday) throws UnsupportedEncodingException{
		String[] weeks = request.getParameterValues("weeks");
		if (weeks != null) {
			for (String week : weeks) {
				if ("week1".equals(week))
					teacherDefaultHoliday.setWeek1(true);
				else if ("week2".equals(week))
					teacherDefaultHoliday.setWeek2(true);
				else if ("week3".equals(week))
					teacherDefaultHoliday.setWeek3(true);
				else if ("week4".equals(week))
					teacherDefaultHoliday.setWeek4(true);
				else if ("week5".equals(week))
					teacherDefaultHoliday.setWeek5(true);
				else if ("week6".equals(week))
					teacherDefaultHoliday.setWeek6(true);
				else if ("week7".equals(week))
					teacherDefaultHoliday.setWeek7(true);
				else {
					throw new IllegalArgumentException("week must between 1-7");
				}

			}
		}
	}

	private void add(HttpServletRequest request)
			throws UnsupportedEncodingException {
		Teacher teacher = new Teacher();
		TeacherOperation teacherOperation = OperationManager.getInstance().getTeacherOperation();
		TeacherDefaultHolidayOperation teacherDefaultHolidayOperation = OperationManager.getInstance().getTeacherDefaultHolidayOperation();
		setObject(request, teacher);
		teacher.setIsAlive(true);
		teacherOperation.add(teacher);

		teacher = teacherOperation.getByName(teacher.getName());
		TeacherDefaultHoliday teacherDefaultHoliday = new TeacherDefaultHoliday();
		teacherDefaultHoliday.setTeacherId(teacher.getId());
		setObject(request, teacherDefaultHoliday);
		teacherDefaultHolidayOperation.add(teacherDefaultHoliday);
	}

	private void update(HttpServletRequest request)
			throws UnsupportedEncodingException {

		Teacher teacher = null;
		TeacherOperation teacherOperation = OperationManager.getInstance().getTeacherOperation();
		TeacherDefaultHolidayOperation teacherDefaultHolidayOperation = OperationManager.getInstance().getTeacherDefaultHolidayOperation();
		
		int teacherId = Integer.valueOf(request.getParameter("id"));
		teacher = teacherOperation.get(teacherId);
		setObject(request, teacher);
		teacherOperation.update(teacher);

		TeacherDefaultHoliday teacherDefaultHoliday = teacherDefaultHolidayOperation.getByTeacherId(teacherId);
		if(teacherDefaultHoliday == null){
			teacherDefaultHoliday = new TeacherDefaultHoliday();
		}
		setObject(request, teacherDefaultHoliday);
		teacherDefaultHolidayOperation.update(teacherDefaultHoliday);
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("delete")) {
			int teacherId = Integer.valueOf(request.getParameter("id"));
			delete(teacherId);
			response.sendRedirect("teacher.jsp");
		} else if (action.equals("retire")) {
			int teacherId = Integer.valueOf(request.getParameter("id"));
			retire(teacherId);
			response.sendRedirect("teacher.jsp");
		} else if (action.equals("add")) {
			add(request);
			response.sendRedirect("teacher.jsp");
		} else if (action.equals("update")) {
			update(request);
			response.sendRedirect("teacher.jsp");
		}

	}

}
