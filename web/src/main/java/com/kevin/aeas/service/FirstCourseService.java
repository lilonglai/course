package com.kevin.aeas.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.kevin.aeas.object.FirstCourse;
import com.kevin.aeas.operation.db.FirstCourseOperation;
import com.kevin.aeas.operation.db.OperationManager;

@Path("/firstcourse")
public class FirstCourseService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public FirstCourse get(@QueryParam("id") int firstCourseId){
		FirstCourseOperation firstCourseService = OperationManager.getInstance().getFirstCourseOperation();
		FirstCourse firstCourse = firstCourseService.get(firstCourseId);
		return firstCourse;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public boolean delete(@QueryParam("id") int firstCourseId){
		FirstCourseOperation firstCourseService = OperationManager.getInstance().getFirstCourseOperation();
		firstCourseService.delete(firstCourseId);
		return true;
	}
	
}
