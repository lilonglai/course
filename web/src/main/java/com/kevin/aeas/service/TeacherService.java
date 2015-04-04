package com.kevin.aeas.service;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.operation.business.TeacherBusinessOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/teacher")
public class TeacherService {
    TeacherBusinessOperation businessOperation = new TeacherBusinessOperation();
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void add(Teacher teacher){
        businessOperation.add(teacher);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void update(Teacher teacher){
        businessOperation.update(teacher);
    }

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Teacher get(@QueryParam("id") int teacherId){
		return businessOperation.get(teacherId);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@QueryParam("id") int teacherId){
        businessOperation.delete(teacherId);
	}
	
	@GET
	@Path("/retire")
	@Produces(MediaType.APPLICATION_JSON)
	public void retire(@QueryParam("id") int teacherId){
        businessOperation.retire(teacherId);
	}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Teacher> getAll(){
        return businessOperation.getAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Teacher> getAlive(){
        return businessOperation.getAlive();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Teacher> getNotAlive(){
        return businessOperation.getNotAlive();
    }
	
}
