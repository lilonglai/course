package com.kevin.aeas.operation.db;

import java.sql.Date;
import java.util.ArrayList;

import com.kevin.aeas.object.Schedule;
import com.kevin.aeas.operation.db.basic.DbOperationManager;
import com.kevin.aeas.operation.db.jpa.JpaOperationManager;
import com.kevin.aeas.utils.ConfigurationManager;

public class ScheduleOperation {
	public Schedule get(int key){
		if(ConfigurationManager.getInstance().isJpa()){
			return (Schedule)JpaOperationManager.getInstance().getScheduleOperation().get(key);
		}
		else{
			return DbOperationManager.getInstance().getScheduleOperation().get(key);
		}
		
	}
	
	public Schedule getByStudentIdOnDateAndTime(int studentId, Date onDate, int onTime){
		if(ConfigurationManager.getInstance().isJpa()){
			return (Schedule)JpaOperationManager.getInstance().getScheduleOperation().getByStudentIdOnDateAndTime(studentId, onDate, onTime);
		}
		else{
			return DbOperationManager.getInstance().getScheduleOperation().getByStudentIdOnDateAndTime(studentId, onDate, onTime);
		}
		
	}
	
	public ArrayList<Schedule> getByStudentId(int studentId){
		if(ConfigurationManager.getInstance().isJpa()){
			return (ArrayList<Schedule>)JpaOperationManager.getInstance().getScheduleOperation().getByStudentId(studentId);
		}
		else{
			return DbOperationManager.getInstance().getScheduleOperation().getByStudentId(studentId);
		}
		
	}
	
	public ArrayList<Schedule> getByTeacherId(int teacherId){
		if(ConfigurationManager.getInstance().isJpa()){
			return (ArrayList<Schedule>)JpaOperationManager.getInstance().getScheduleOperation().getByTeacherId(teacherId);
		}
		else{
			return DbOperationManager.getInstance().getScheduleOperation().getByTeacherId(teacherId);
		}
		
	}
	
	
	public ArrayList<Schedule> getByDateAndTime(Date onDate, int onTime){
		if(ConfigurationManager.getInstance().isJpa()){
			return (ArrayList<Schedule>)JpaOperationManager.getInstance().getScheduleOperation().getByDateAndTime(onDate, onTime);
		}
		else{
			return DbOperationManager.getInstance().getScheduleOperation().getByDateAndTime(onDate, onTime);
		}
		
	}
	
	public ArrayList<Schedule> getAll(){
		if(ConfigurationManager.getInstance().isJpa()){
			return (ArrayList<Schedule>)JpaOperationManager.getInstance().getScheduleOperation().getAll();
		}
		else{
			return DbOperationManager.getInstance().getScheduleOperation().getAll();
		}
		
	}
	
	
	public void add(Schedule schedule){
		if(ConfigurationManager.getInstance().isJpa()){
			 JpaOperationManager.getInstance().getScheduleOperation().add(schedule);
		}
		else{
			 DbOperationManager.getInstance().getScheduleOperation().add(schedule);
		}
	}
	
	public void update(Schedule schedule){
		if(ConfigurationManager.getInstance().isJpa()){
			 JpaOperationManager.getInstance().getScheduleOperation().update(schedule);
		}
		else{
			 DbOperationManager.getInstance().getScheduleOperation().update(schedule);
		}
	}
	
	
	public void delete(int key){
		if(ConfigurationManager.getInstance().isJpa()){
			 JpaOperationManager.getInstance().getScheduleOperation().delete(key);
		}
		else{
			 DbOperationManager.getInstance().getScheduleOperation().delete(key);
		}
	}
	
	public static void main(String[] args) {
		ScheduleOperation operation = new ScheduleOperation();
		Schedule schedule = new Schedule();
		schedule.setOnDate(Date.valueOf("2014-10-2"));
		schedule.setId(10);
		schedule.setOnTime(2);
		schedule.setStudentId(3);
		schedule.setTeacherId(3);
		schedule.setAddition("5-1");
		operation.update(schedule);
				
	}

}
