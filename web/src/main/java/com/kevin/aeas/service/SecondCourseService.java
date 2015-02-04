package com.kevin.aeas.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.kevin.aeas.object.SecondCourse;
import com.kevin.aeas.operation.db.OperationManager;
import com.kevin.aeas.operation.db.SecondCourseOperation;

@Path("/secondcourse")
public class SecondCourseService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SecondCourse get(@QueryParam("id") int secondCourseId){
		SecondCourseOperation secondCourseOperation = OperationManager.getInstance().getSecondCourseOperation();
		SecondCourse secondCourse = secondCourseOperation.get(secondCourseId);
		return secondCourse;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public boolean delete(@QueryParam("id") int secondCourseId){
		SecondCourseOperation secondCourseOperation = OperationManager.getInstance().getSecondCourseOperation();
		secondCourseOperation.delete(secondCourseId);
		return true;
	}
	
}
