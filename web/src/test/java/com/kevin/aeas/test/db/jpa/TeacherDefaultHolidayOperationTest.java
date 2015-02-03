package com.kevin.aeas.test.db.jpa;

import java.util.ArrayList;

import com.kevin.aeas.object.TeacherDefaultHoliday;
import com.kevin.aeas.operation.db.jpa.JpaTeacherDefaultHolidayOperation;
import com.kevin.aeas.test.db.utils.DbUtils;

import junit.framework.TestCase;

public abstract class TeacherDefaultHolidayOperationTest extends TestCase{
	public void testGet(){
		JpaTeacherDefaultHolidayOperation operation = new JpaTeacherDefaultHolidayOperation();
		TeacherDefaultHoliday teacherDefaultHoliday = (TeacherDefaultHoliday) operation.get(1);
	}
	
	public void testGetByTeacherId(){
		JpaTeacherDefaultHolidayOperation operation = new JpaTeacherDefaultHolidayOperation();
		TeacherDefaultHoliday teacherDefaultHoliday = (TeacherDefaultHoliday) operation.getByTeacherId(1);
	}
	
	public void testGetAll(){
		JpaTeacherDefaultHolidayOperation operation = new JpaTeacherDefaultHolidayOperation();
		ArrayList<TeacherDefaultHoliday> teacherDefaultHoliday = (ArrayList<TeacherDefaultHoliday>) operation.getAll();
	}

	public void testAdd(){
		JpaTeacherDefaultHolidayOperation operation = new JpaTeacherDefaultHolidayOperation();
		TeacherDefaultHoliday teacherDefaultHoliday = new TeacherDefaultHoliday();
		teacherDefaultHoliday.setTeacherId(1);
		teacherDefaultHoliday.setWeek1(true);
		teacherDefaultHoliday.setWeek4(true);
		operation.add(teacherDefaultHoliday);
	}
	
	public void testUpdate(){

		JpaTeacherDefaultHolidayOperation operation = new JpaTeacherDefaultHolidayOperation();
		ArrayList<TeacherDefaultHoliday> list = (ArrayList<TeacherDefaultHoliday>) operation.getAll();
		for(TeacherDefaultHoliday teacherDefaultHoliday: list){
			if(teacherDefaultHoliday.getTeacherId() == 1){
				teacherDefaultHoliday.setWeek3(true);
				teacherDefaultHoliday.setWeek6(true);
				operation.update(teacherDefaultHoliday);
			}
		}
	}
	
	
	public void testDelete(){
		JpaTeacherDefaultHolidayOperation operation = new JpaTeacherDefaultHolidayOperation();
		ArrayList<TeacherDefaultHoliday> list = (ArrayList<TeacherDefaultHoliday>) operation.getAll();
		for(TeacherDefaultHoliday teacherDefaultHoliday: list){
			if(teacherDefaultHoliday.getTeacherId() == 1){
				operation.delete(teacherDefaultHoliday.getId());
			}
		}
		
	}
	
	public void testDeleteByTeacherId(){
		JpaTeacherDefaultHolidayOperation operation = new JpaTeacherDefaultHolidayOperation();
		operation.deleteByTeacherId(1);
	}
	
	protected void setUp() throws Exception{
		DbUtils.resetJpaManager();
	}
}
