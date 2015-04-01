package com.kevin.aeas.service;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.operation.db.OperationManager;
import com.kevin.aeas.operation.db.TeacherOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/teacher")
public class TeacherService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Teacher get(@QueryParam("id") int teacherId){
		TeacherOperation teacherOperation = OperationManager.getInstance().getTeacherOperation();
		Teacher teacher = teacherOperation.get(teacherId);
		return teacher;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public boolean delete(@QueryParam("id") int teacherId){
		TeacherOperation teacherOperation = OperationManager.getInstance().getTeacherOperation();
		teacherOperation.delete(teacherId);
		return true;
	}
	
	@GET
	@Path("/retire")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean retire(@QueryParam("id") int teacherId){
		TeacherOperation teacherOperation = OperationManager.getInstance().getTeacherOperation();
		teacherOperation.retire(teacherId);
		return true;
	}
	
}
