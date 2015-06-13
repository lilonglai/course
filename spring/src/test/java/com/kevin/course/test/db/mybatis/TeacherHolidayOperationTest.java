package com.kevin.course.test.db.mybatis;

import com.kevin.course.object.TeacherHoliday;
import com.kevin.course.operation.db.ITeacherHolidayOperation;
import com.kevin.course.test.db.utils.ApplicationContextUtils;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;

import java.sql.Date;
import java.util.List;

public class TeacherHolidayOperationTest extends TestCase {
	ITeacherHolidayOperation operation;
	public TeacherHolidayOperationTest(){
		ApplicationContext context = ApplicationContextUtils.getMybatisInstance();
		operation = (ITeacherHolidayOperation)context.getBean("myBatisTeacherHolidayDao");
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
		teacherHoliday.setTeacherId(2);
		teacherHoliday.setAdjustDate(new Date(1989, 07, 23));
		teacherHoliday.setIsHoliday(true);
		operation.add(teacherHoliday);
	}

	public void testUpdate() {
		List<TeacherHoliday> list = operation.getAll();
		for (TeacherHoliday teacherHoliday : list) {
			if (teacherHoliday.getTeacherId() == 2) {
				teacherHoliday.setAdjustDate(new Date(1989, 07, 23));
				teacherHoliday.setIsHoliday(false);
				operation.update(teacherHoliday);
			}
		}
	}

	public void testDelete() {
		List<TeacherHoliday> list = operation.getAll();
		for (TeacherHoliday teacherHoliday : list) {
			if (teacherHoliday.getTeacherId() == 2) {
				teacherHoliday.setAdjustDate(new Date(1989, 07, 23));
				teacherHoliday.setIsHoliday(false);
				operation.delete(teacherHoliday.getId());
			}
		}
	}
}
