package com.kevin.aeas.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.object.TeacherDefaultHoliday;
import com.kevin.aeas.object.oracle.OracleTeacher;
import com.kevin.aeas.object.oracle.OracleTeacherDefaultHoliday;
import com.kevin.aeas.operation.db.OperationManager;
import com.kevin.aeas.operation.db.TeacherDefaultHolidayOperation;
import com.kevin.aeas.operation.db.TeacherOperation;
import com.kevin.aeas.operation.db.jpa.JpaOperationManager;
import com.kevin.aeas.operation.db.jpa.JpaTeacherOperation;

/**
 * this servlet is used to operate teacher user can add/delete/retire teacher
 * 
 * @author loli
 *
 */
public class TeacherServlet extends HttpServlet {

	private void delete(int id) {		
		JpaTeacherOperation teacherOperation = JpaOperationManager.getInstance().getTeacherOperation();
		teacherOperation.delete(id);
	}

	private void retire(int id) {
		JpaTeacherOperation teacherOperation = JpaOperationManager.getInstance().getTeacherOperation();
		teacherOperation.retire(id);
	}

	private void add(HttpServletRequest request)
			throws UnsupportedEncodingException {
		OracleTeacher teacher = new OracleTeacher();
		TeacherOperation teacherOperation = OperationManager.getInstance().getTeacherOperation();
		TeacherDefaultHolidayOperation teacherDefaultHolidayOperation = OperationManager.getInstance().getTeacherDefaultHolidayOperation();
		String name = request.getParameter("name");
		name = new String(name.getBytes("iso-8859-1"), "utf-8");
		teacher.setName(name);

		String shortName = request.getParameter("shortName");
		shortName = new String(shortName.getBytes("iso-8859-1"), "utf-8");
		teacher.setShortName(shortName);

		teacher.setPhone(request.getParameter("phone"));
		if (request.getParameter("isMaster") != null)
			teacher.setIsMaster(true);
		else
			teacher.setIsMaster(false);

		OracleTeacherDefaultHoliday teacherDefaultHoliday = new OracleTeacherDefaultHoliday();


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
		
		teacher.setIsAlive(true);
		teacherOperation.add(teacher);
		teacherDefaultHolidayOperation.add(teacherDefaultHoliday);
	}

	private void update(HttpServletRequest request)
			throws UnsupportedEncodingException {

		Teacher teacher = null;
		TeacherOperation teacherOperation = OperationManager.getInstance().getTeacherOperation();
		TeacherDefaultHolidayOperation teacherDefaultHolidayOperation = OperationManager.getInstance().getTeacherDefaultHolidayOperation();
		
		int teacherId = Integer.valueOf(request.getParameter("id"));
		teacher = teacherOperation.get(teacherId);
		TeacherDefaultHoliday teacherDefaultHoliday = teacherDefaultHolidayOperation.getByTeacherId(teacherId);
		
		String name = request.getParameter("name");
		name = new String(name.getBytes("iso-8859-1"), "utf-8");
		teacher.setName(name);

		String shortName = request.getParameter("shortName");
		shortName = new String(shortName.getBytes("iso-8859-1"), "utf-8");
		teacher.setShortName(shortName);

		teacher.setPhone(request.getParameter("phone"));
		if (request.getParameter("isMaster") != null)
			teacher.setIsMaster(true);
		else
			teacher.setIsMaster(false);


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
		
		teacherOperation.update(teacher);
		
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
