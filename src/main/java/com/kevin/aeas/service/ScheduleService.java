package com.kevin.aeas.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.kevin.aeas.object.Schedule;
import com.kevin.aeas.object.SecondCourse;
import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.object.TeacherAbility;
import com.kevin.aeas.object.TeacherDefaultHoliday;
import com.kevin.aeas.object.TeacherHoliday;
import com.kevin.aeas.operation.ScheduleOperation;
import com.kevin.aeas.operation.SecondCourseOperation;
import com.kevin.aeas.operation.TeacherAbilityOperation;
import com.kevin.aeas.operation.TeacherDefaultHolidayOperation;
import com.kevin.aeas.operation.TeacherHolidayOperation;
import com.kevin.aeas.operation.TeacherOperation;
import com.kevin.aeas.utils.DateHelp;

@Path("/schedule")
public class ScheduleService {
	public ScheduleService() {
		super();
	}
	
	private ArrayList<SecondCourse> getSecondCourseList(Date onDate, int onTime, int studentId, int firstCourseId){
		SecondCourseOperation secondCourseOperation = new SecondCourseOperation();
		ScheduleOperation scheduleOperation = new ScheduleOperation();
		ArrayList<SecondCourse> secondCourseList = secondCourseOperation.getByFirstCourseId(firstCourseId);
		ArrayList<Schedule> scheduleList = scheduleOperation.getByStudentId(studentId);
		for(Schedule schedule : scheduleList){
			for(int i = 0; i< secondCourseList.size(); i++){
				if(secondCourseList.get(i).getId() == schedule.getCourseId()){
					secondCourseList.remove(i);
					break;
				}
			}
			
		}
		
		return secondCourseList;
		
	}
	
	private ArrayList<Teacher> getTeacherList(Date onDate, int onTime, int studentId, int firstCourseId){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(onDate);
		TeacherAbilityOperation teacherAbilityOperation = new TeacherAbilityOperation();
		TeacherDefaultHolidayOperation teacherDefaultHolidayOperation = new TeacherDefaultHolidayOperation();
		TeacherHolidayOperation teacherHolidayOperation = new TeacherHolidayOperation();
		TeacherOperation teacherOperation = new TeacherOperation();
		ScheduleOperation scheduleOperation = new ScheduleOperation();
		ArrayList<TeacherAbility> teacherAbilityList = teacherAbilityOperation.getByCourseId(firstCourseId);
		
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		
	outer:	
		for(TeacherAbility teacherAbility:teacherAbilityList){
			int teacherId = teacherAbility.getTeacherId();

		    TeacherDefaultHoliday teacherDefaultHoliday = teacherDefaultHolidayOperation.getByTeacherId(teacherId);
		    ArrayList<TeacherHoliday> holidayList = teacherHolidayOperation.getByTeacherId(teacherId);
		    if(DateHelp.isHoliday(calendar, teacherDefaultHoliday, holidayList)){
		    	continue;
		    }
		    
		    ArrayList<Schedule> scheduleList = scheduleOperation.getByDateAndTime(onDate, onTime);
		    
			for(Schedule schedule : scheduleList){
				if(schedule.getTeacherId() == teacherId){
					continue outer;
				}					
			}
		    teacherList.add(teacherOperation.get(teacherId));
		    			    
		}
		return teacherList;
	}
	
	
	private ArrayList<Teacher> getAvailableTeacherList(Date onDate, int onTime){
		ScheduleOperation scheduleOperation = new ScheduleOperation();
		TeacherOperation teacherOperation = new TeacherOperation();
		TeacherDefaultHolidayOperation teacherDefaultHolidayOperation = new TeacherDefaultHolidayOperation();
		TeacherHolidayOperation teacherHolidayOperation = new TeacherHolidayOperation();
		ArrayList<Schedule> scheduleList = scheduleOperation.getByDateAndTime(onDate, onTime);
		ArrayList<Teacher> teacherList = teacherOperation.getAll();
		
		for(Schedule schedule:scheduleList){
			for(Teacher teacher:teacherList)
			if(schedule.getTeacherId() == teacher.getId()){
				teacherList.remove(teacher);
				break;
			}	
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(onDate);
		
 
	    for(int i= teacherList.size()-1; i >=0; i--){
	    	int teacherId = teacherList.get(i).getId();
		    TeacherDefaultHoliday teacherDefaultHoliday = teacherDefaultHolidayOperation.getByTeacherId(teacherId);
		    ArrayList<TeacherHoliday> holidayList = teacherHolidayOperation.getByTeacherId(teacherId);
		    if(DateHelp.isHoliday(calendar, teacherDefaultHoliday, holidayList)){
		    	teacherList.remove(i);
		    	continue;
		    }
	    	
	    	for(Schedule schedule:scheduleList){
	    		if(schedule.getTeacherId() == teacherId){
					teacherList.remove(i);
					break;
				}	    		
	    	}
	    	

	    }
	    
		return teacherList;
	}
			
	@GET
	@Path("getSecondCourseList")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<SecondCourse> getSecondCourseList2(@QueryParam("onDate") Date onDate, @QueryParam("onTime") int onTime,
			@QueryParam("studentId") int studentId, @QueryParam("firstCourseId") int firstCourseId){
		ArrayList<SecondCourse> secondCourseList = getSecondCourseList(onDate, onTime, studentId, firstCourseId);
		return secondCourseList;
	}
	
	@POST
	@Path("getSecondCourseList")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<SecondCourse> getSecondCourseList3(@FormParam("onDate") Date onDate, @FormParam("onTime") int onTime,
			@FormParam("studentId") int studentId, @FormParam("firstCourseId") int firstCourseId){
		ArrayList<SecondCourse> secondCourseList = getSecondCourseList(onDate, onTime, studentId, firstCourseId);
		return secondCourseList;
	}
	
	@GET
	@Path("getTeacherList")
	@Produces(MediaType.APPLICATION_JSON)
	public  ArrayList<Teacher> getTeacherList2(@QueryParam("onDate") Date onDate, @QueryParam("onTime") int onTime, 
			@QueryParam("studentId") int studentId, @QueryParam("firstCourseId") int firstCourseId){
		ArrayList<Teacher> teacherList = getTeacherList(onDate, onTime, studentId, firstCourseId);
		return teacherList;
	}
	
	@POST
	@Path("getTeacherList")
	@Produces(MediaType.APPLICATION_JSON)
	public  ArrayList<Teacher> getTeacherList3(@FormParam("onDate") Date onDate, @FormParam("onTime") int onTime, 
			@FormParam("studentId") int studentId, @FormParam("firstCourseId") int firstCourseId){
		ArrayList<Teacher> teacherList = getTeacherList(onDate, onTime, studentId, firstCourseId);
		return teacherList;
	}
	
	@GET
	@Path("getAvailableTeacherList")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Teacher> getAvailableTeacherList2(@QueryParam("onDate") Date onDate, @QueryParam("onTime") int onTime){
		ArrayList<Teacher> teacherList = getAvailableTeacherList(onDate, onTime);
		return teacherList;
	}
	
	@POST
	@Path("getAvailableTeacherList")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Teacher> getAvailableTeacherList3(@FormParam("onDate") Date onDate, @FormParam("onTime") int onTime){
		ArrayList<Teacher> teacherList = getAvailableTeacherList(onDate, onTime);
		return teacherList;
	}
	
	@GET
	@Path("getSecondCourseAndTeacherList")
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> getSecondCourseAndTeacherList2(@QueryParam("onDate") Date onDate, @QueryParam("onTime") int onTime,
			@QueryParam("studentId") int studentId, @QueryParam("firstCourseId") int firstCourseId){
		ArrayList<SecondCourse> secondCourseList = getSecondCourseList(onDate, onTime, studentId, firstCourseId);
		ArrayList<Teacher> teacherList = getTeacherList(onDate, onTime, studentId, firstCourseId);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("secondCourseList", secondCourseList);
		map.put("teacherList", teacherList);
		return map;
	}

	@POST
	@Path("getSecondCourseAndTeacherList")
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> getSecondCourseAndTeacherList3(@FormParam("onDate") Date onDate, @FormParam("onTime") int onTime,
			@FormParam("studentId") int studentId, @FormParam("firstCourseId") int firstCourseId){
		ArrayList<SecondCourse> secondCourseList = getSecondCourseList(onDate, onTime, studentId, firstCourseId);
		ArrayList<Teacher> teacherList = getTeacherList(onDate, onTime, studentId, firstCourseId);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("secondCourseList", secondCourseList);
		map.put("teacherList", teacherList);
		return map;
	}
}
