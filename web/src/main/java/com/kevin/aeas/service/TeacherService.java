package com.kevin.aeas.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.operation.TeacherOperation;

@Path("/teacher")
public class TeacherService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Teacher getbyId(@QueryParam("id") int teacherId){
		TeacherOperation teacherOperation = new TeacherOperation();
		Teacher teacher = teacherOperation.get(teacherId);
		return teacher;
	}
	
}
