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
import com.kevin.aeas.operation.TeacherDefaultHolidayOperation;
import com.kevin.aeas.operation.TeacherOperation;
import com.kevin.aeas.operation.v2.AeasOperationManager;
import com.kevin.aeas.operation.v2.AeasTeacherDefaultHolidayOperation;
import com.kevin.aeas.operation.v2.AeasTeacherOperation;

/**
 * this servlet is used to operate teacher user can add/delete/retire teacher
 * 
 * @author loli
 *
 */
public class TeacherServlet extends HttpServlet {

	private void delete(int id) {		
		AeasTeacherOperation teacherOperation = AeasOperationManager.getInstance().getTeacherOperation();
		teacherOperation.delete(id);
	}

	private void retire(int id) {
		AeasTeacherOperation teacherOperation = AeasOperationManager.getInstance().getTeacherOperation();
		teacherOperation.retire(id);
	}

	private void add(HttpServletRequest request)
			throws UnsupportedEncodingException {
		OracleTeacher teacher = new OracleTeacher();
		AeasTeacherOperation teacherOperation = AeasOperationManager.getInstance().getTeacherOperation();
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
					teacherDefaultHoliday.setWeak1(true);
				else if ("week2".equals(week))
					teacherDefaultHoliday.setWeak2(true);
				else if ("week3".equals(week))
					teacherDefaultHoliday.setWeak3(true);
				else if ("week4".equals(week))
					teacherDefaultHoliday.setWeak4(true);
				else if ("week5".equals(week))
					teacherDefaultHoliday.setWeak5(true);
				else if ("week6".equals(week))
					teacherDefaultHoliday.setWeak6(true);
				else if ("week7".equals(week))
					teacherDefaultHoliday.setWeak7(true);
				else {
					throw new IllegalArgumentException("week must between 1-7");
				}
			}
		}
		
		teacher.setIsAlive(true);

		teacher.setAeasTeacherDefaultHoliday(teacherDefaultHoliday);
		teacherDefaultHoliday.setAeasTeacher(teacher);
		teacherOperation.add(teacher);
	}

	private void update(HttpServletRequest request)
			throws UnsupportedEncodingException {

		OracleTeacher teacher = null;
		AeasTeacherOperation teacherOperation = AeasOperationManager.getInstance().getTeacherOperation();
		
		int teacherId = Integer.valueOf(request.getParameter("id"));
		teacher = teacherOperation.get(teacherId);
		OracleTeacherDefaultHoliday teacherDefaultHoliday = teacher.getAeasTeacherDefaultHoliday();
		
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
					teacherDefaultHoliday.setWeak1(true);
				else if ("week2".equals(week))
					teacherDefaultHoliday.setWeak2(true);
				else if ("week3".equals(week))
					teacherDefaultHoliday.setWeak3(true);
				else if ("week4".equals(week))
					teacherDefaultHoliday.setWeak4(true);
				else if ("week5".equals(week))
					teacherDefaultHoliday.setWeak5(true);
				else if ("week6".equals(week))
					teacherDefaultHoliday.setWeak6(true);
				else if ("week7".equals(week))
					teacherDefaultHoliday.setWeak7(true);
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
