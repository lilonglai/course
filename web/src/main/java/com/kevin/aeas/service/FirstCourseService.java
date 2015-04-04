package com.kevin.aeas.service;

import com.kevin.aeas.object.FirstCourse;
import com.kevin.aeas.operation.business.FirstCourseBusinessOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/firstcourse")
public class FirstCourseService {
    FirstCourseBusinessOperation bussinessOperation = new FirstCourseBusinessOperation();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void add(FirstCourse firstCourse){
        bussinessOperation.add(firstCourse);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void update(FirstCourse firstCourse){
        bussinessOperation.update(firstCourse);
    }

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public FirstCourse get(@QueryParam("id") int firstCourseId){
		return bussinessOperation.get(firstCourseId);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@QueryParam("id") int firstCourseId){
        bussinessOperation.delete(firstCourseId);
	}

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public List<FirstCourse> getAll(){
        return bussinessOperation.getAll();
    }

}
