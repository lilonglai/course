package com.kevin.course.service;

import com.kevin.course.object.TeacherHoliday;
import com.kevin.course.operation.business.ITeacherHolidayBusinessOperation;
import com.kevin.course.operation.business.TeacherHolidayBusinessOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/teacher")
public class TeacherHolidayService {
    ITeacherHolidayBusinessOperation businessOperation = new TeacherHolidayBusinessOperation();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void add(TeacherHoliday teacherHoliday){
        businessOperation.add(teacherHoliday);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void update(TeacherHoliday teacherHoliday){
        businessOperation.update(teacherHoliday);
    }

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TeacherHoliday get(@QueryParam("id") int id){
		return businessOperation.get(id);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@QueryParam("id") int id){
        businessOperation.delete(id);
	}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TeacherHoliday> getAll(){
        return businessOperation.getAll();
    }
}
