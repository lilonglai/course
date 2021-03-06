package com.kevin.course.test.db.basic;

import com.kevin.course.object.Teacher;
import com.kevin.course.object.TeacherDefaultHoliday;
import com.kevin.course.operation.db.ITeacherDefaultHolidayOperation;
import com.kevin.course.operation.db.ITeacherOperation;
import com.kevin.course.test.db.utils.ApplicationContextUtils;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;

import java.util.List;

public  class TeacherDefaultHolidayOperationTest extends TestCase{
    Teacher teacher;
	ITeacherDefaultHolidayOperation operation;
	public TeacherDefaultHolidayOperationTest(){
		ApplicationContext context = ApplicationContextUtils.getJdbcInstance();
		operation = (ITeacherDefaultHolidayOperation)context.getBean("jdbcTeacherDefaultHolidayDao");
	}

	public void testGet(){
		TeacherDefaultHoliday teacherDefaultHoliday = operation.get(1);
	}
	
	public void testGetByTeacherId(){
		TeacherDefaultHoliday teacherDefaultHoliday = operation.getByTeacherId(1);
	}
	
	public void testGetAll(){
		List<? extends TeacherDefaultHoliday> teacherDefaultHoliday = operation.getAll();
	}

	public void testAdd(){
		TeacherDefaultHoliday teacherDefaultHoliday = new TeacherDefaultHoliday();
		teacherDefaultHoliday.setTeacherId(teacher.getId());
		teacherDefaultHoliday.setWeek1(true);
		teacherDefaultHoliday.setWeek4(true);
		operation.add(teacherDefaultHoliday);
	}
	
	public void testUpdate(){

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
		List<? extends TeacherDefaultHoliday> list = operation.getAll();
		for(TeacherDefaultHoliday teacherDefaultHoliday: list){
			if(teacherDefaultHoliday.getTeacherId() == 2){
				operation.delete(teacherDefaultHoliday.getId());
			}
		}
		
	}
	
	public void testDeleteByTeacherId(){
		operation.deleteByTeacherId(1);
	}

	protected  void setUp(){
		ApplicationContext context = ApplicationContextUtils.getJdbcInstance();

		ITeacherOperation teacherOperation = (ITeacherOperation) context.getBean("jdbcTeacherDao");
		teacher = new Teacher();
		teacher.setName("test");
		teacher.setShortName("test");
		teacher.setIsMaster(true);
		teacher.setPhone("123456789");
		teacherOperation.add(teacher);

	}

	protected void tearDown(){
		ApplicationContext context = ApplicationContextUtils.getJdbcInstance();
		ITeacherOperation teacherOperation = (ITeacherOperation) context.getBean("jdbcTeacherDao");
		teacherOperation.delete(teacher.getId());
	}
}
