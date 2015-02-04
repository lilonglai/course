package com.kevin.aeas.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.kevin.aeas.object.Student;
import com.kevin.aeas.operation.db.OperationManager;
import com.kevin.aeas.operation.db.StudentOperation;

@Path("/student")
public class StudentService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Student get(@QueryParam("id") int studentId){
		StudentOperation studentOperation = OperationManager.getInstance().getStudentOperation();
		Student student = studentOperation.get(studentId);
		return student;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public boolean delete(@QueryParam("id") int studentId){
		StudentOperation studentOperation = OperationManager.getInstance().getStudentOperation();
		studentOperation.delete(studentId);
		return true;
	}
	
	@GET
	@Path("/retire")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean retire(@QueryParam("id") int studentId){
		StudentOperation studentOperation = OperationManager.getInstance().getStudentOperation();
		studentOperation.retire(studentId);
		return true;
	}
}
