package com.kevin.aeas.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

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
import com.kevin.aeas.operation.db.ScheduleOperation;
import com.kevin.aeas.operation.db.SecondCourseOperation;
import com.kevin.aeas.operation.db.TeacherAbilityOperation;
import com.kevin.aeas.operation.db.TeacherDefaultHolidayOperation;
import com.kevin.aeas.operation.db.TeacherHolidayOperation;
import com.kevin.aeas.operation.db.TeacherOperation;
import com.kevin.aeas.utils.DateHelp;

@Path("/schedule")
public class ScheduleService {
	public ScheduleService() {
		super();
	}
	
	private List<SecondCourse> getSecondCourseList(int studentId, int firstCourseId){
		SecondCourseOperation secondCourseOperation = new SecondCourseOperation();
		ScheduleOperation scheduleOperation = new ScheduleOperation();
		List<SecondCourse> secondCourseList = secondCourseOperation.getByFirstCourseId(firstCourseId);
		List<Schedule> scheduleList = scheduleOperation.getByStudentId(studentId);
		List<SecondCourse> resultList = new ArrayList<SecondCourse>();
		for(SecondCourse secondCourse : secondCourseList){
			if(isScheduled(secondCourse, scheduleList)){
				continue;
			}
			resultList.add(secondCourse);
		}
		
		return secondCourseList;		
	}
	
	private boolean isScheduled(SecondCourse secondCourse, List<Schedule> scheduleList){
		for(Schedule schedule : scheduleList){
			if(secondCourse.getId() == schedule.getCourseId()){
				return true;
			}		
		}
		return false;
	}
	
	private List<Teacher> getTeacherList(Date onDate, int onTime, int firstCourseId){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(onDate);
		TeacherAbilityOperation teacherAbilityOperation = new TeacherAbilityOperation();

		TeacherOperation teacherOperation = new TeacherOperation();
		ScheduleOperation scheduleOperation = new ScheduleOperation();
		List<TeacherAbility> teacherAbilityList = teacherAbilityOperation.getByCourseId(firstCourseId);
		
		List<Teacher> teacherList = new ArrayList<Teacher>();
	    List<Schedule> scheduleList = scheduleOperation.getByDateAndTime(onDate, onTime);
		
		for(TeacherAbility teacherAbility:teacherAbilityList){
			int teacherId = teacherAbility.getTeacherId();

		    if(isTeacherInHoliday(teacherId, calendar)){
		    	continue;
		    }
		    		    		    
		    if(isScheduled(teacherId, scheduleList)){
		    	continue;
		    }
		    teacherList.add(teacherOperation.get(teacherId));
		    			    
		}
		return teacherList;
	}
	
	/*
	 *  decide teacher has been in a holiday
	 *  @param teacherId the teacher identification.
	 *  @param calendar represent a day
	 */
	private boolean isTeacherInHoliday(int teacherId, Calendar calendar){
		TeacherDefaultHolidayOperation teacherDefaultHolidayOperation = new TeacherDefaultHolidayOperation();
		TeacherHolidayOperation teacherHolidayOperation = new TeacherHolidayOperation();
		TeacherDefaultHoliday teacherDefaultHoliday = teacherDefaultHolidayOperation.getByTeacherId(teacherId);
		List<TeacherHoliday> holidayList = teacherHolidayOperation.getByTeacherId(teacherId);
	    if(DateHelp.isHoliday(calendar, teacherDefaultHoliday, holidayList)){
	    	return true;
	    }
	    return false;
	}
	
	
	/*
	 * decide teacher has been arranged a class. 
	 * @param teacherId the teacher identification.
	 * @param Schedule the arranged list
	 */
	private boolean isScheduled(int teacherId, List<Schedule> scheduleList){
		for(Schedule schedule : scheduleList){
			if(schedule.getTeacherId() == teacherId){
				return true;
			}			
		}
		return false;
	}
	
	
	private ArrayList<Teacher> getAvailableTeacherList(Date onDate, int onTime){
		ScheduleOperation scheduleOperation = new ScheduleOperation();
		TeacherOperation teacherOperation = new TeacherOperation();
		List<Schedule> scheduleList = scheduleOperation.getByDateAndTime(onDate, onTime);
		List<Teacher> teacherList = teacherOperation.getAll();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(onDate);
		
		ArrayList<Teacher> resultList = new ArrayList<Teacher>();
	    for(Teacher teacher:teacherList){
	    	int teacherId = teacher.getId();
	    	
		    if(isTeacherInHoliday(teacherId, calendar)){
		    	continue;
		    }
		    
		    // decide the teacher's scheduling time
			if(isScheduled(teacher.getId(), scheduleList)){
				continue;
			}
			
			resultList.add(teacher);
	    	
	    }
	    
		return resultList;
	}
			
	@GET
	@Path("getSecondCourseList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SecondCourse> getSecondCourseListByGet(@QueryParam("studentId") int studentId, @QueryParam("firstCourseId") int firstCourseId){
		List<SecondCourse> secondCourseList = getSecondCourseList(studentId, firstCourseId);
		return secondCourseList;
	}
	
	@POST
	@Path("getSecondCourseList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SecondCourse> getSecondCourseListByPost(@FormParam("studentId") int studentId, @FormParam("firstCourseId") int firstCourseId){
		List<SecondCourse> secondCourseList = getSecondCourseList(studentId, firstCourseId);
		return secondCourseList;
	}
	
	@GET
	@Path("getTeacherList")
	@Produces(MediaType.APPLICATION_JSON)
	public  List<Teacher> getTeacherListByGet(@QueryParam("onDate") Date onDate, @QueryParam("onTime") int onTime, @QueryParam("firstCourseId") int firstCourseId){
		List<Teacher> teacherList = getTeacherList(onDate, onTime, firstCourseId);
		return teacherList;
	}
	
	@POST
	@Path("getTeacherList")
	@Produces(MediaType.APPLICATION_JSON)
	public  List<Teacher> getTeacherListByPost(@FormParam("onDate") Date onDate, @FormParam("onTime") int onTime, 
			 @FormParam("firstCourseId") int firstCourseId){
		List<Teacher> teacherList = getTeacherList(onDate, onTime, firstCourseId);
		return teacherList;
	}
	
	@GET
	@Path("getAvailableTeacherList")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Teacher> getAvailableTeacherListByGet(@QueryParam("onDate") Date onDate, @QueryParam("onTime") int onTime){
		ArrayList<Teacher> teacherList = getAvailableTeacherList(onDate, onTime);
		return teacherList;
	}
	
	@POST
	@Path("getAvailableTeacherList")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Teacher> getAvailableTeacherListByPost(@FormParam("onDate") Date onDate, @FormParam("onTime") int onTime){
		ArrayList<Teacher> teacherList = getAvailableTeacherList(onDate, onTime);
		return teacherList;
	}
	
	@GET
	@Path("getSecondCourseAndTeacherList")
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> getSecondCourseAndTeacherListByGet(@QueryParam("onDate") Date onDate, @QueryParam("onTime") int onTime,
			@QueryParam("studentId") int studentId, @QueryParam("firstCourseId") int firstCourseId){
		List<SecondCourse> secondCourseList = getSecondCourseList(studentId, firstCourseId);
		List<Teacher> teacherList = getTeacherList(onDate, onTime, firstCourseId);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("secondCourseList", secondCourseList);
		map.put("teacherList", teacherList);
		return map;
	}

	@POST
	@Path("getSecondCourseAndTeacherList")
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> getSecondCourseAndTeacherListByPost(@FormParam("onDate") Date onDate, @FormParam("onTime") int onTime,
			@FormParam("studentId") int studentId, @FormParam("firstCourseId") int firstCourseId){
		List<SecondCourse> secondCourseList = getSecondCourseList(studentId, firstCourseId);
		List<Teacher> teacherList = getTeacherList(onDate, onTime, firstCourseId);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("secondCourseList", secondCourseList);
		map.put("teacherList", teacherList);
		return map;
	}
}
