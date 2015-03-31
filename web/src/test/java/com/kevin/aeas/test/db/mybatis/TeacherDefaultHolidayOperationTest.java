package com.kevin.aeas.test.db.mybatis;

import com.kevin.aeas.object.TeacherDefaultHoliday;
import com.kevin.aeas.operation.db.basic.DbTeacherDefaultHolidayOperation;
import com.kevin.aeas.operation.db.mybatis.MyBatisTeacherDefaultHolidayOperation;
import com.kevin.aeas.test.db.utils.DbUtils;
import junit.framework.TestCase;

import java.util.List;

public class TeacherDefaultHolidayOperationTest extends TestCase{
	public void testGet(){
		MyBatisTeacherDefaultHolidayOperation operation = new MyBatisTeacherDefaultHolidayOperation();
		TeacherDefaultHoliday teacherDefaultHoliday = operation.get(1);
	}
	
	public void testGetByTeacherId(){
        MyBatisTeacherDefaultHolidayOperation operation = new MyBatisTeacherDefaultHolidayOperation();
		TeacherDefaultHoliday teacherDefaultHoliday = operation.getByTeacherId(1);
	}
	
	public void testGetAll(){
        MyBatisTeacherDefaultHolidayOperation operation = new MyBatisTeacherDefaultHolidayOperation();
		List<TeacherDefaultHoliday> teacherDefaultHoliday = operation.getAll();
	}

	public void testAdd(){
        MyBatisTeacherDefaultHolidayOperation operation = new MyBatisTeacherDefaultHolidayOperation();
		TeacherDefaultHoliday teacherDefaultHoliday = new TeacherDefaultHoliday();
		teacherDefaultHoliday.setTeacherId(2);
		teacherDefaultHoliday.setWeek1(true);
		teacherDefaultHoliday.setWeek4(true);
		operation.add(teacherDefaultHoliday);
	}
	
	public void testUpdate(){
        MyBatisTeacherDefaultHolidayOperation operation = new MyBatisTeacherDefaultHolidayOperation();
		List<TeacherDefaultHoliday> list = operation.getAll();
		for(TeacherDefaultHoliday teacherDefaultHoliday: list){
			if(teacherDefaultHoliday.getTeacherId() == 2){
				teacherDefaultHoliday.setWeek3(true);
				teacherDefaultHoliday.setWeek6(true);
				operation.update(teacherDefaultHoliday);
			}
		}
	}
	
	
	public void testDelete(){
        MyBatisTeacherDefaultHolidayOperation operation = new MyBatisTeacherDefaultHolidayOperation();
		List<TeacherDefaultHoliday> list = operation.getAll();
		for(TeacherDefaultHoliday teacherDefaultHoliday: list){
			if(teacherDefaultHoliday.getTeacherId() == 2){
				operation.delete(teacherDefaultHoliday.getId());
			}
		}
		
	}
	
	public void testDeleteByTeacherId(){
        MyBatisTeacherDefaultHolidayOperation operation = new MyBatisTeacherDefaultHolidayOperation();
		operation.deleteByTeacherId(1);
	}
}
