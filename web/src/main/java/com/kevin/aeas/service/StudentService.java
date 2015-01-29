package com.kevin.aeas.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.kevin.aeas.object.Student;
import com.kevin.aeas.operation.db.StudentOperation;

@Path("/student")
public class StudentService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Student getbyId(@QueryParam("id") int studentId){
		StudentOperation studentOperation = new StudentOperation();
		Student student = studentOperation.get(studentId);
		return student;
	}
	
}
