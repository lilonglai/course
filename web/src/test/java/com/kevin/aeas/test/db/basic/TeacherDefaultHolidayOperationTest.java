package com.kevin.aeas.test.db.basic;

import java.util.List;

import com.kevin.aeas.operation.db.basic.JdbcTeacherDefaultHolidayOperation;
import junit.framework.TestCase;

import com.kevin.aeas.object.TeacherDefaultHoliday;
import com.kevin.aeas.test.db.utils.DbUtils;

public abstract class TeacherDefaultHolidayOperationTest extends TestCase{
	public void testGet(){
		JdbcTeacherDefaultHolidayOperation operation = new JdbcTeacherDefaultHolidayOperation();
		TeacherDefaultHoliday teacherDefaultHoliday = operation.get(1);
	}
	
	public void testGetByTeacherId(){
		JdbcTeacherDefaultHolidayOperation operation = new JdbcTeacherDefaultHolidayOperation();
		TeacherDefaultHoliday teacherDefaultHoliday = operation.getByTeacherId(1);
	}
	
	public void testGetAll(){
		JdbcTeacherDefaultHolidayOperation operation = new JdbcTeacherDefaultHolidayOperation();
		List<? extends TeacherDefaultHoliday> teacherDefaultHoliday = operation.getAll();
	}

	public void testAdd(){
		JdbcTeacherDefaultHolidayOperation operation = new JdbcTeacherDefaultHolidayOperation();
		TeacherDefaultHoliday teacherDefaultHoliday = new TeacherDefaultHoliday();
		teacherDefaultHoliday.setTeacherId(2);
		teacherDefaultHoliday.setWeek1(true);
		teacherDefaultHoliday.setWeek4(true);
		operation.add(teacherDefaultHoliday);
	}
	
	public void testUpdate(){

		JdbcTeacherDefaultHolidayOperation operation = new JdbcTeacherDefaultHolidayOperation();
		List<? extends TeacherDefaultHoliday> list = operation.getAll();
		for(TeacherDefaultHoliday teacherDefaultHoliday: list){
			if(teacherDefaultHoliday.getTeacherId() == 2){
				teacherDefaultHoliday.setWeek3(true);
				teacherDefaultHoliday.setWeek6(true);
				operation.update(teacherDefaultHoliday);
			}
		}
	}
	
	
	public void testDelete(){
		JdbcTeacherDefaultHolidayOperation operation = new JdbcTeacherDefaultHolidayOperation();
		List<? extends TeacherDefaultHoliday> list = operation.getAll();
		for(TeacherDefaultHoliday teacherDefaultHoliday: list){
			if(teacherDefaultHoliday.getTeacherId() == 2){
				operation.delete(teacherDefaultHoliday.getId());
			}
		}
		
	}
	
	public void testDeleteByTeacherId(){
		JdbcTeacherDefaultHolidayOperation operation = new JdbcTeacherDefaultHolidayOperation();
		operation.deleteByTeacherId(1);
	}
	
	protected void setUp() throws Exception{
		DbUtils.resetDbInstance();
	}
}
