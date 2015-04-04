package com.kevin.aeas.service;

import com.kevin.aeas.object.Student;
import com.kevin.aeas.operation.business.StudentBusinessOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/student")
public class StudentService {
    StudentBusinessOperation businessOperation = new StudentBusinessOperation();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void add(Student student){
        businessOperation.add(student);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void update(Student student){
        businessOperation.update(student);
    }

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Student get(@QueryParam("id") int id){
		return businessOperation.get(id);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@QueryParam("id") int id){
        businessOperation.delete(id);
	}
	
	@GET
	@Path("/retire")
	@Produces(MediaType.APPLICATION_JSON)
	public void retire(@QueryParam("id") int id){
        businessOperation.retire(id);
	}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAll(){
        return businessOperation.getAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAlive(){
        return businessOperation.getAlive();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getNotAlive(){
        return businessOperation.getNotAlive();
    }
}
