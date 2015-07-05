package com.kevin.course.service;

import com.kevin.course.object.SecondCourse;
import com.kevin.course.operation.business.ISecondCourseBusinessOperation;
import com.kevin.course.operation.business.SecondCourseBusinessOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/secondcourse")
public class SecondCourseService {
    ISecondCourseBusinessOperation businessOperation = new SecondCourseBusinessOperation();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void add(SecondCourse secondCourse){
        businessOperation.add(secondCourse);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void update(SecondCourse secondCourse){
        businessOperation.update(secondCourse);
    }

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SecondCourse get(@QueryParam("id") int secondCourseId){
		return businessOperation.get(secondCourseId);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@QueryParam("id") int secondCourseId){
        businessOperation.delete(secondCourseId);
	}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SecondCourse> getAll(){
        return businessOperation.getAll();
    }
	
}
