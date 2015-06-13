package com.kevin.course.test.db.jpa;

import com.kevin.course.object.TeacherHoliday;
import com.kevin.course.operation.db.jpa.JpaTeacherHolidayOperation;
import junit.framework.TestCase;

import java.sql.Date;
import java.util.List;

public abstract class TeacherHolidayOperationTest extends TestCase {
	public void testGet() {
		JpaTeacherHolidayOperation operation = new JpaTeacherHolidayOperation();
		TeacherHoliday teacherHoliday = (TeacherHoliday) operation.get(1);
	}

	public void testGetByTeacherId() {
		JpaTeacherHolidayOperation operation = new JpaTeacherHolidayOperation();
		List<TeacherHoliday> list = operation.getByTeacherId(1);

	}

	public void testGetByTeacherAndDate() {
		JpaTeacherHolidayOperation operation = new JpaTeacherHolidayOperation();
		TeacherHoliday teacherHoliday = operation.getByTeacherAndDate(1,
				"1989-07-21");
	}

	public void testGetAll() {
		JpaTeacherHolidayOperation operation = new JpaTeacherHolidayOperation();
		List<TeacherHoliday> list = operation.getAll();

	}

	public void testAdd() {
		JpaTeacherHolidayOperation operation = new JpaTeacherHolidayOperation();
		TeacherHoliday teacherHoliday = new TeacherHoliday();
		teacherHoliday.setTeacherId(2);
		teacherHoliday.setAdjustDate(new Date(1989, 07, 23));
		teacherHoliday.setIsHoliday(true);
		operation.add(teacherHoliday);
	}

	public void testUpdate() {
		JpaTeacherHolidayOperation operation = new JpaTeacherHolidayOperation();
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
		JpaTeacherHolidayOperation operation = new JpaTeacherHolidayOperation();
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
