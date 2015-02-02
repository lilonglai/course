package com.kevin.aeas.test.db.basic;

import java.util.ArrayList;

import com.kevin.aeas.object.TeacherDefaultHoliday;
import com.kevin.aeas.operation.db.basic.DbTeacherDefaultHolidayOperation;

import junit.framework.TestCase;

public abstract class TeacherDefaultHolidayOperationTest extends TestCase{
	public void testGet(){
		DbTeacherDefaultHolidayOperation operation = new DbTeacherDefaultHolidayOperation();
		TeacherDefaultHoliday teacherDefaultHoliday = operation.get(1);
	}
	
	public void testGetByTeacherId(){
		DbTeacherDefaultHolidayOperation operation = new DbTeacherDefaultHolidayOperation();
		TeacherDefaultHoliday teacherDefaultHoliday = operation.getByTeacherId(1);
	}
	
	public void testGetAll(){
		DbTeacherDefaultHolidayOperation operation = new DbTeacherDefaultHolidayOperation();
		ArrayList<TeacherDefaultHoliday> teacherDefaultHoliday = operation.getAll();
	}

	public void testAdd(){
		DbTeacherDefaultHolidayOperation operation = new DbTeacherDefaultHolidayOperation();
		TeacherDefaultHoliday teacherDefaultHoliday = new TeacherDefaultHoliday();
		teacherDefaultHoliday.setTeacherId(1);
		teacherDefaultHoliday.setWeek1(true);
		teacherDefaultHoliday.setWeek4(true);
		operation.add(teacherDefaultHoliday);
	}
	
	public void testUpdate(){

		DbTeacherDefaultHolidayOperation operation = new DbTeacherDefaultHolidayOperation();
		ArrayList<TeacherDefaultHoliday> list = operation.getAll();
		for(TeacherDefaultHoliday teacherDefaultHoliday: list){
			if(teacherDefaultHoliday.getTeacherId() == 1){
				teacherDefaultHoliday.setWeek3(true);
				teacherDefaultHoliday.setWeek6(true);
				operation.update(teacherDefaultHoliday);
			}
		}
	}
	
	
	public void testDelete(){
		DbTeacherDefaultHolidayOperation operation = new DbTeacherDefaultHolidayOperation();
		ArrayList<TeacherDefaultHoliday> list = operation.getAll();
		for(TeacherDefaultHoliday teacherDefaultHoliday: list){
			if(teacherDefaultHoliday.getTeacherId() == 1){
				operation.delete(teacherDefaultHoliday.getId());
			}
		}
		
	}
	
	public void testDeleteByTeacherId(){
		DbTeacherDefaultHolidayOperation operation = new DbTeacherDefaultHolidayOperation();
		operation.deleteByTeacherId(1);
	}
}
