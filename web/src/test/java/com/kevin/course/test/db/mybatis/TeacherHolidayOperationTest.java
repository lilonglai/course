package com.kevin.course.test.db.mybatis;

import com.kevin.course.object.TeacherHoliday;
import com.kevin.course.operation.db.mybatis.MyBatisTeacherHolidayOperation;
import junit.framework.TestCase;

import java.sql.Date;
import java.util.List;

public class TeacherHolidayOperationTest extends TestCase {
	public void testGet() {
		MyBatisTeacherHolidayOperation operation = new MyBatisTeacherHolidayOperation();
		TeacherHoliday teacherHoliday = operation.get(2);
	}

	public void testGetByTeacherId() {
        MyBatisTeacherHolidayOperation operation = new MyBatisTeacherHolidayOperation();
		List<? extends TeacherHoliday> list = operation.getByTeacherId(2);

	}

	public void testGetByTeacherAndDate() {
        MyBatisTeacherHolidayOperation operation = new MyBatisTeacherHolidayOperation();
		TeacherHoliday teacherHoliday = operation.getByTeacherAndDate(2,
				"1989-7-21");
	}

	public void testGetAll() {
        MyBatisTeacherHolidayOperation operation = new MyBatisTeacherHolidayOperation();
		List<? extends TeacherHoliday> list = operation.getAll();

	}

	public void testAdd() {
        MyBatisTeacherHolidayOperation operation = new MyBatisTeacherHolidayOperation();
		TeacherHoliday teacherHoliday = new TeacherHoliday();
		teacherHoliday.setTeacherId(2);
		teacherHoliday.setAdjustDate(new Date(1989, 07, 23));
		teacherHoliday.setIsHoliday(true);
		operation.add(teacherHoliday);
	}

	public void testUpdate() {
        MyBatisTeacherHolidayOperation operation = new MyBatisTeacherHolidayOperation();
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
        MyBatisTeacherHolidayOperation operation = new MyBatisTeacherHolidayOperation();
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
