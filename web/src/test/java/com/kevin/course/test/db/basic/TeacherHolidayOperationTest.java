package com.kevin.course.test.db.basic;

import com.kevin.course.object.TeacherHoliday;
import com.kevin.course.operation.db.basic.JdbcTeacherHolidayOperation;
import com.kevin.course.test.db.utils.DbUtils;
import junit.framework.TestCase;

import java.sql.Date;
import java.util.List;

public abstract class TeacherHolidayOperationTest extends TestCase {
	public void testGet() {
		JdbcTeacherHolidayOperation operation = new JdbcTeacherHolidayOperation();
		TeacherHoliday teacherHoliday = operation.get(2);
	}

	public void testGetByTeacherId() {
		JdbcTeacherHolidayOperation operation = new JdbcTeacherHolidayOperation();
		List<? extends TeacherHoliday> list = operation.getByTeacherId(2);

	}

	public void testGetByTeacherAndDate() {
		JdbcTeacherHolidayOperation operation = new JdbcTeacherHolidayOperation();
		TeacherHoliday teacherHoliday = operation.getByTeacherAndDate(2,
				"1989-7-21");
	}

	public void testGetAll() {
		JdbcTeacherHolidayOperation operation = new JdbcTeacherHolidayOperation();
		List<? extends TeacherHoliday> list = operation.getAll();

	}

	public void testAdd() {
		JdbcTeacherHolidayOperation operation = new JdbcTeacherHolidayOperation();
		TeacherHoliday teacherHoliday = new TeacherHoliday();
		teacherHoliday.setTeacherId(2);
		teacherHoliday.setAdjustDate(new Date(1989, 07, 23));
		teacherHoliday.setIsHoliday(true);
		operation.add(teacherHoliday);
	}

	public void testUpdate() {
		JdbcTeacherHolidayOperation operation = new JdbcTeacherHolidayOperation();
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
		JdbcTeacherHolidayOperation operation = new JdbcTeacherHolidayOperation();
		List<? extends TeacherHoliday> list = operation.getAll();
		for (TeacherHoliday teacherHoliday : list) {
			if (teacherHoliday.getTeacherId() == 2) {
				teacherHoliday.setAdjustDate(new Date(1989, 07, 23));
				teacherHoliday.setIsHoliday(false);
				operation.delete(teacherHoliday.getId());
			}
		}
	}
	
	protected void setUp() throws Exception{
		DbUtils.resetDbInstance();
	}
}
