package com.kevin.aeas.operation.db;

import java.util.ArrayList;
import java.util.List;

import com.kevin.aeas.object.TeacherDefaultHoliday;
import com.kevin.aeas.operation.db.basic.DbOperationManager;
import com.kevin.aeas.operation.db.jpa.JpaOperationManager;
import com.kevin.aeas.utils.ConfigurationManager;

public class TeacherDefaultHolidayOperation {
	public TeacherDefaultHoliday get(int key){
		if(ConfigurationManager.getInstance().isJpa()){
			return (TeacherDefaultHoliday)JpaOperationManager.getInstance().getTeacherDefaultHolidayOperation().get(key);
		}
		else{
			return DbOperationManager.getInstance().getTeacherDefaultHolidayOperation().get(key);
		}
		
	}
	
	public TeacherDefaultHoliday getByTeacherId(int teacherId){
		if(ConfigurationManager.getInstance().isJpa()){
			return (TeacherDefaultHoliday)JpaOperationManager.getInstance().getTeacherDefaultHolidayOperation().getByTeacherId(teacherId);
		}
		else{
			return DbOperationManager.getInstance().getTeacherDefaultHolidayOperation().getByTeacherId(teacherId);
		}
		
	}
	
	public List<TeacherDefaultHoliday> getAll(){
		if(ConfigurationManager.getInstance().isJpa()){
			return (List<TeacherDefaultHoliday>)JpaOperationManager.getInstance().getTeacherDefaultHolidayOperation().getAll();
		}
		else{
			return DbOperationManager.getInstance().getTeacherDefaultHolidayOperation().getAll();
		}
		
	}

	public void add(TeacherDefaultHoliday teacherDefaultHoliday){
		if(ConfigurationManager.getInstance().isJpa()){
			 JpaOperationManager.getInstance().getTeacherDefaultHolidayOperation().add(teacherDefaultHoliday);
		}
		else{
			DbOperationManager.getInstance().getTeacherDefaultHolidayOperation().add(teacherDefaultHoliday);
		}
		
	}
	
	public void update(TeacherDefaultHoliday teacherDefaultHoliday){
		if(ConfigurationManager.getInstance().isJpa()){
			 JpaOperationManager.getInstance().getTeacherDefaultHolidayOperation().update(teacherDefaultHoliday);
		}
		else{
			DbOperationManager.getInstance().getTeacherDefaultHolidayOperation().update(teacherDefaultHoliday);
		}
	}
	
	
	public void delete(int key){
		if(ConfigurationManager.getInstance().isJpa()){
			 JpaOperationManager.getInstance().getTeacherDefaultHolidayOperation().delete(key);
		}
		else{
			DbOperationManager.getInstance().getTeacherDefaultHolidayOperation().delete(key);
		}
	}
	
	public void deleteByTeacherId(int teacherId){
		if(ConfigurationManager.getInstance().isJpa()){
			 JpaOperationManager.getInstance().getTeacherDefaultHolidayOperation().deleteByTeacherId(teacherId);
		}
		else{
			DbOperationManager.getInstance().getTeacherDefaultHolidayOperation().deleteByTeacherId(teacherId);
		}
	}
	
	public static void main(String[] args) {
		TeacherDefaultHolidayOperation operation = new TeacherDefaultHolidayOperation();
		System.out.println(operation.getAll());
		
		TeacherDefaultHoliday object= new TeacherDefaultHoliday();
		object.setId(3);
		object.setTeacherId(1);
		object.setWeek1(true);
		object.setWeek2(true);
		
		operation.update(object);
		
		
		
		
	}
}
