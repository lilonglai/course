package com.kevin.course.service;

import com.kevin.course.object.TeacherDefaultHoliday;
import com.kevin.course.operation.business.ITeacherDefaultHolidayBusinessOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/teacher")
public class TeacherDefaultHolidayService {
    ITeacherDefaultHolidayBusinessOperation businessOperation = new ITeacherDefaultHolidayBusinessOperation();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void add(TeacherDefaultHoliday teacherDefaultHoliday){
        businessOperation.add(teacherDefaultHoliday);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void update(TeacherDefaultHoliday teacherDefaultHoliday){
        businessOperation.update(teacherDefaultHoliday);
    }

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TeacherDefaultHoliday get(@QueryParam("id") int id){
		return businessOperation.get(id);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@QueryParam("id") int id){
        businessOperation.delete(id);
	}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TeacherDefaultHoliday> getAll(){
        return businessOperation.getAll();
    }
}
