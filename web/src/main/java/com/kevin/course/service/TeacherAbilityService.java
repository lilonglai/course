package com.kevin.course.service;

import com.kevin.course.object.TeacherAbility;
import com.kevin.course.operation.business.ITeacherAbilityBusinessOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/teacher")
public class TeacherAbilityService {
    ITeacherAbilityBusinessOperation businessOperation = new ITeacherAbilityBusinessOperation();
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void add(TeacherAbility teacherAbility){
        businessOperation.add(teacherAbility);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void update(TeacherAbility teacherAbility){
        businessOperation.update(teacherAbility);
    }

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TeacherAbility get(@QueryParam("id") int id){
		return businessOperation.get(id);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@QueryParam("id") int id){
        businessOperation.delete(id);
	}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TeacherAbility> getAll(){
        return businessOperation.getAll();
    }
	
}
