package com.kevin.aeas.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.kevin.aeas.object.FirstCourse;
import com.kevin.aeas.operation.FirstCourseOperation;

@Path("/firstcourse")
public class FirstCourseService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public FirstCourse getbyId(@QueryParam("id") int firstCourseId){
		FirstCourseOperation firstCourseService = new FirstCourseOperation();
		FirstCourse firstCourse = firstCourseService.get(firstCourseId);
		return firstCourse;
	}
	
}
