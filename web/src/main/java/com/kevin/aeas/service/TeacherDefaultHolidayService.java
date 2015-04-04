package com.kevin.aeas.service;

import com.kevin.aeas.object.TeacherDefaultHoliday;
import com.kevin.aeas.operation.business.TeacherDefaultHolidayBusinessOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/teacher")
public class TeacherDefaultHolidayService {
    TeacherDefaultHolidayBusinessOperation businessOperation = new TeacherDefaultHolidayBusinessOperation();

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
