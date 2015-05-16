package com.kevin.aeas.service;

import com.kevin.aeas.object.Schedule;
import com.kevin.aeas.object.SecondCourse;
import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.operation.business.ScheduleBusinessOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/schedule")
public class ScheduleService {
    ScheduleBusinessOperation bussinessOperation = new ScheduleBusinessOperation();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void add(Schedule schedule){
        bussinessOperation.add(schedule);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void update(Schedule schedule){
        bussinessOperation.update(schedule);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Schedule get(@QueryParam("id") int id){
        return  bussinessOperation.get(id);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@QueryParam("id") int id){
        bussinessOperation.delete(id);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public List<Schedule> getAll(){
        return bussinessOperation.getAll();
    }

    @GET
    @Path("getSecondCourseList")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SecondCourse> getSecondCourseList(@QueryParam("studentId") int studentId, @QueryParam("firstCourseId") int firstCourseId){
        List<SecondCourse> secondCourseList = bussinessOperation.getSecondCourseList(studentId, firstCourseId);
        return secondCourseList;
    }

    @GET
    @Path("getTeacherList")
    @Produces(MediaType.APPLICATION_JSON)
    public  List<Teacher> getTeacherListByGet(@QueryParam("onDate") Date onDate, @QueryParam("onTime") int onTime, @QueryParam("firstCourseId") int firstCourseId){
        List<Teacher> teacherList = bussinessOperation.getTeacherList(onDate, onTime, firstCourseId);
        return teacherList;
    }

    @GET
    @Path("getAvailableTeacherList")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Teacher> getAvailableTeacherListByGet(@QueryParam("onDate") Date onDate, @QueryParam("onTime") int onTime){
        return bussinessOperation.getAvailableTeacherList(onDate, onTime);
    }

    @GET
    @Path("getSecondCourseAndTeacherList")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getSecondCourseAndTeacherListByGet(@QueryParam("onDate") Date onDate, @QueryParam("onTime") int onTime,
                                                                      @QueryParam("studentId") int studentId, @QueryParam("firstCourseId") int firstCourseId){
        List<SecondCourse> secondCourseList = bussinessOperation.getSecondCourseList(studentId, firstCourseId);
        List<Teacher> teacherList = bussinessOperation.getTeacherList(onDate, onTime, firstCourseId);
        HashMap<String, Object> map = new HashMap<>();
        map.put("secondCourseList", secondCourseList);
        map.put("teacherList", teacherList);
        return map;
    }

}
