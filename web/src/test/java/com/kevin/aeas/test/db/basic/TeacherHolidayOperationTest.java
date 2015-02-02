package com.kevin.aeas.test.db.basic;

import java.sql.Date;
import java.util.List;

import com.kevin.aeas.object.TeacherHoliday;
import com.kevin.aeas.operation.db.basic.DbTeacherHolidayOperation;

import junit.framework.TestCase;

public abstract class TeacherHolidayOperationTest extends TestCase {
	public void testGet() {
		DbTeacherHolidayOperation operation = new DbTeacherHolidayOperation();
		TeacherHoliday teacherHoliday = operation.get(1);
	}

	public void testGetByTeacherId() {
		DbTeacherHolidayOperation operation = new DbTeacherHolidayOperation();
		List<TeacherHoliday> list = operation.getByTeacherId(1);

	}

	public void testGetByTeacherAndDate() {
		DbTeacherHolidayOperation operation = new DbTeacherHolidayOperation();
		TeacherHoliday teacherHoliday = operation.getByTeacherAndDate(1,
				"1989-7-21");
	}

	public void testGetAll() {
		DbTeacherHolidayOperation operation = new DbTeacherHolidayOperation();
		List<TeacherHoliday> list = operation.getAll();

	}

	public void testAdd() {
		DbTeacherHolidayOperation operation = new DbTeacherHolidayOperation();
		TeacherHoliday teacherHoliday = new TeacherHoliday();
		teacherHoliday.setTeacherId(1);
		teacherHoliday.setAdjustDate(new Date(1989, 07, 23));
		teacherHoliday.setIsHoliday(true);
		operation.add(teacherHoliday);
	}

	public void testUpdate() {
		DbTeacherHolidayOperation operation = new DbTeacherHolidayOperation();
		List<TeacherHoliday> list = operation.getAll();
		for (TeacherHoliday teacherHoliday : list) {
			if (teacherHoliday.getTeacherId() == 1) {
				teacherHoliday.setAdjustDate(new Date(1989, 07, 23));
				teacherHoliday.setIsHoliday(false);
				operation.update(teacherHoliday);
			}
		}
	}

	public void testDelete() {
		DbTeacherHolidayOperation operation = new DbTeacherHolidayOperation();
		List<TeacherHoliday> list = operation.getAll();
		for (TeacherHoliday teacherHoliday : list) {
			if (teacherHoliday.getTeacherId() == 1) {
				teacherHoliday.setAdjustDate(new Date(1989, 07, 23));
				teacherHoliday.setIsHoliday(false);
				operation.delete(teacherHoliday.getId());
			}
		}
	}
}