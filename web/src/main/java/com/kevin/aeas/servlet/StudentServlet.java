package com.kevin.aeas.servlet;

import com.kevin.aeas.object.Student;
import com.kevin.aeas.operation.db.OperationManager;
import com.kevin.aeas.operation.db.StudentOperation;
import com.kevin.aeas.utils.HttpRequestUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class StudentServlet extends HttpServlet {
	private void delete(int id) {
		StudentOperation studentOperation = OperationManager.getInstance().getStudentOperation();
		studentOperation.delete(id);
	}

	private void retire(int id) {
		StudentOperation studentOperation = OperationManager.getInstance().getStudentOperation();
		studentOperation.retire(id);
	}

	private void add(HttpServletRequest request)
			throws UnsupportedEncodingException {
		StudentOperation studentOperation = OperationManager.getInstance().getStudentOperation();
	    Student student = new Student();
		setObject(request, student);
		student.setIsAlive(true);
		studentOperation.add(student);
	}

	private void setObject(HttpServletRequest request, Student student) throws UnsupportedEncodingException{
		student.setName(HttpRequestUtil.getString(request, "name"));
		student.setShortName(HttpRequestUtil.getString(request, "shortName"));
		student.setGrade(HttpRequestUtil.getInt(request, "grade"));
		student.setTestScore(HttpRequestUtil.getString(request, "testScore"));
		student.setTargetScore(HttpRequestUtil.getString(request, "targetScore"));
		student.setExamineDate(HttpRequestUtil.getDate(request, "examineDate"));
		student.setExaminePlace(HttpRequestUtil.getString(request, "examinePlace"));
		student.setTeacherId(HttpRequestUtil.getInt(request, "teacherId"));
		student.setDescription(HttpRequestUtil.getString(request, "description"));
	}

	private void update(HttpServletRequest request)
			throws UnsupportedEncodingException {
		StudentOperation studentOperation = OperationManager.getInstance().getStudentOperation();
		Student student;
		int studentId = HttpRequestUtil.getInt(request, "id");
		student = studentOperation.get(studentId);
		setObject(request, student);
		studentOperation.update(student);
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
			int studentId = Integer.valueOf(request.getParameter("id"));
			delete(studentId);
		} else if (action.equals("retire")) {
			int studentId = Integer.valueOf(request.getParameter("id"));
			retire(studentId);
		} else if (action.equals("add")) {
			add(request);
		} else if (action.equals("update")) {
			update(request);
		}
		
		response.sendRedirect("student.jsp");

	}
}
