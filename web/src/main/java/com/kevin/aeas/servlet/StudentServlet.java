package com.kevin.aeas.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kevin.aeas.object.Student;
import com.kevin.aeas.object.oracle.OracleStudent;
import com.kevin.aeas.operation.db.OperationManager;
import com.kevin.aeas.operation.db.StudentOperation;

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
	    
	    OracleStudent student = new OracleStudent();		
		String tempStr;
		
		String name = request.getParameter("name");
		name = new String(name.getBytes("iso-8859-1"), "utf-8");
		student.setName(name);

		String shortName = request.getParameter("shortName");
		shortName = new String(shortName.getBytes("iso-8859-1"),
				"utf-8");
		student.setShortName(shortName);
		
		tempStr = request.getParameter("grade");
		if(tempStr != null && !tempStr.equals(""))
			student.setGrade(Integer.valueOf(tempStr));
		
		String testScore = request.getParameter("testScore");
		if(testScore != null){
			testScore =  new String(testScore.getBytes("iso-8859-1"),"utf-8");
			student.setTestScore(testScore);
		}
		
		String targetScore = request.getParameter("targetScore");
		if(targetScore != null){
			targetScore =  new String(targetScore.getBytes("iso-8859-1"),"utf-8");
			student.setTargetScore(targetScore);
		}
		
		tempStr = request.getParameter("examineDate");
		if(tempStr != null && !tempStr.equals("")){
			String examineDate = tempStr;
			student.setExamineDate(Date.valueOf(examineDate));
		}
		
		String examinePlace = request.getParameter("examinePlace");
		examinePlace = new String(examinePlace.getBytes("iso-8859-1"),
				"utf-8");
		student.setExaminePlace(examinePlace);
		
		
		tempStr = request.getParameter("teacherId");
		if(tempStr != null && !tempStr.equals("")){
			student.setTeacherId(Integer.valueOf(tempStr));
		}
		

		String description = request.getParameter("description");
		description = new String(description.getBytes("iso-8859-1"),
				"utf-8");
		student.setDescription(description);
		student.setIsAlive(true);
		studentOperation.add(student);
	}

	private void update(HttpServletRequest request)
			throws UnsupportedEncodingException {
		StudentOperation studentOperation = OperationManager.getInstance().getStudentOperation();
		Student student;
		
		String tempStr;
		
		int studentId = Integer.valueOf(request.getParameter("id"));
		student = studentOperation.get(studentId);
		
		String name = request.getParameter("name");
		name = new String(name.getBytes("iso-8859-1"), "utf-8");
		student.setName(name);

		String shortName = request.getParameter("shortName");
		shortName = new String(shortName.getBytes("iso-8859-1"),
				"utf-8");
		student.setShortName(shortName);
		
		tempStr = request.getParameter("grade");
		if(tempStr != null && !tempStr.equals(""))
			student.setGrade(Integer.valueOf(tempStr));
		
		String testScore = request.getParameter("testScore");
		if(testScore != null){
			testScore =  new String(testScore.getBytes("iso-8859-1"),"utf-8");
			student.setTestScore(testScore);
		}
		
		String targetScore = request.getParameter("targetScore");
		if(targetScore != null){
			targetScore =  new String(targetScore.getBytes("iso-8859-1"),"utf-8");
			student.setTargetScore(targetScore);
		}
		
		tempStr = request.getParameter("examineDate");
		if(tempStr != null && !tempStr.equals("")){
			String examineDate = tempStr;
			student.setExamineDate(Date.valueOf(examineDate));
		}
		
		String examinePlace = request.getParameter("examinePlace");
		examinePlace = new String(examinePlace.getBytes("iso-8859-1"),
				"utf-8");
		student.setExaminePlace(examinePlace);		
		
		tempStr = request.getParameter("teacherId");
		if(tempStr != null && !tempStr.equals("")){
			student.setTeacherId(Integer.valueOf(tempStr));
		}
		
		String description = request.getParameter("description");
		description = new String(description.getBytes("iso-8859-1"),
				"utf-8");
		student.setDescription(description);

		studentOperation.update(student);
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
