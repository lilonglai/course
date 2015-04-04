package com.kevin.aeas.service;

import com.kevin.aeas.object.TeacherAbility;
import com.kevin.aeas.operation.business.TeacherAbilityBusinessOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/teacher")
public class TeacherAbilityService {
    TeacherAbilityBusinessOperation businessOperation = new TeacherAbilityBusinessOperation();
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
