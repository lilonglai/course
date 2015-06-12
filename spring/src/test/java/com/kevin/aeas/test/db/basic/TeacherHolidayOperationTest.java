package com.kevin.aeas.test.db.basic;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.object.TeacherHoliday;
import com.kevin.aeas.operation.db.IStudentOperation;
import com.kevin.aeas.operation.db.ITeacherHolidayOperation;
import com.kevin.aeas.operation.db.ITeacherOperation;
import com.kevin.aeas.test.db.utils.ApplicationContextUtils;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;

import java.sql.Date;
import java.util.List;

public  class TeacherHolidayOperationTest extends TestCase {
	Teacher teacher;
	ITeacherHolidayOperation operation;
	public TeacherHolidayOperationTest(){
		ApplicationContext context = ApplicationContextUtils.getInstance();
		operation = (ITeacherHolidayOperation)context.getBean("jdbcTeacherHolidayDao");
	}

	public void testGet() {
		TeacherHoliday teacherHoliday = operation.get(2);
	}

	public void testGetByTeacherId() {
		List<? extends TeacherHoliday> list = operation.getByTeacherId(2);

	}

	public void testGetByTeacherAndDate() {
		TeacherHoliday teacherHoliday = operation.getByTeacherAndDate(2,
				"1989-7-21");
	}

	public void testGetAll() {
		List<? extends TeacherHoliday> list = operation.getAll();

	}

	public void testAdd() {
		TeacherHoliday teacherHoliday = new TeacherHoliday();
		teacherHoliday.setTeacherId(teacher.getId());
		teacherHoliday.setAdjustDate(new Date(1989, 07, 23));
		teacherHoliday.setIsHoliday(true);
		operation.add(teacherHoliday);
	}

	public void testUpdate() {
		List<? extends TeacherHoliday> list = operation.getAll();
		for (TeacherHoliday teacherHoliday : list) {
			if (teacherHoliday.getTeacherId() == 2) {
				teacherHoliday.setAdjustDate(new Date(1989, 07, 23));
				teacherHoliday.setIsHoliday(false);
				operation.update(teacherHoliday);
			}
		}
	}

	public void testDelete() {
		List<? extends TeacherHoliday> list = operation.getAll();
		for (TeacherHoliday teacherHoliday : list) {
			if (teacherHoliday.getTeacherId() == 2) {
				teacherHoliday.setAdjustDate(new Date(1989, 07, 23));
				teacherHoliday.setIsHoliday(false);
				operation.delete(teacherHoliday.getId());
			}
		}
	}

	protected  void setUp(){
		ApplicationContext context = ApplicationContextUtils.getInstance();

		ITeacherOperation teacherOperation = (ITeacherOperation) context.getBean("jdbcTeacherDao");
		teacher = new Teacher();
		teacher.setName("test");
		teacher.setShortName("test");
		teacher.setIsMaster(true);
		teacher.setPhone("123456789");
		teacherOperation.add(teacher);

	}

	protected void tearDown(){
		ApplicationContext context = ApplicationContextUtils.getInstance();
		ITeacherOperation teacherOperation = (ITeacherOperation) context.getBean("jdbcTeacherDao");
		teacherOperation.delete(teacher.getId());
	}

}
