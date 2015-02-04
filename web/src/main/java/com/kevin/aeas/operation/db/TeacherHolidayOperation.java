package com.kevin.aeas.operation.db;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import com.kevin.aeas.object.TeacherHoliday;
import com.kevin.aeas.operation.db.basic.DbOperationManager;
import com.kevin.aeas.operation.db.jpa.JpaOperationManager;
import com.kevin.aeas.utils.ConfigurationManager;

public class TeacherHolidayOperation {
	public TeacherHoliday get(int key) {
		if(ConfigurationManager.getInstance().isJpa()){
			return (TeacherHoliday)JpaOperationManager.getInstance().getTeacherHolidayOperation().get(key);
		}
		else{
			return DbOperationManager.getInstance().getTeacherHolidayOperation().get(key);
		}

	}

	public List<TeacherHoliday> getByTeacherId(int teacherId) {
		if(ConfigurationManager.getInstance().isJpa()){
			return (List<TeacherHoliday>)JpaOperationManager.getInstance().getTeacherHolidayOperation().getByTeacherId(teacherId);
		}
		else{
			return DbOperationManager.getInstance().getTeacherHolidayOperation().getByTeacherId(teacherId);
		}

	}
	
	public TeacherHoliday getByTeacherAndDate(int teacherId,String date) {
		if(ConfigurationManager.getInstance().isJpa()){
			return (TeacherHoliday)JpaOperationManager.getInstance().getTeacherHolidayOperation().getByTeacherAndDate(teacherId, date);
		}
		else{
			return DbOperationManager.getInstance().getTeacherHolidayOperation().getByTeacherAndDate(teacherId, date);
		}

	}

	public List<TeacherHoliday> getAll() {
		if(ConfigurationManager.getInstance().isJpa()){
			return (List<TeacherHoliday>)JpaOperationManager.getInstance().getTeacherHolidayOperation().getAll();
		}
		else{
			return DbOperationManager.getInstance().getTeacherHolidayOperation().getAll();
		}

	}

	public void add(TeacherHoliday teacherHoliday) {
		if(ConfigurationManager.getInstance().isJpa()){
			JpaOperationManager.getInstance().getTeacherHolidayOperation().add(teacherHoliday);
		}
		else{
			DbOperationManager.getInstance().getTeacherHolidayOperation().add(teacherHoliday);
		}


	}

	public void update(TeacherHoliday teacherHoliday) {
		if(ConfigurationManager.getInstance().isJpa()){
			JpaOperationManager.getInstance().getTeacherHolidayOperation().update(teacherHoliday);
		}
		else{
			DbOperationManager.getInstance().getTeacherHolidayOperation().update(teacherHoliday);
		}
	}

	public void delete(int key) {
		if(ConfigurationManager.getInstance().isJpa()){
			JpaOperationManager.getInstance().getTeacherHolidayOperation().delete(key);
		}
		else{
			DbOperationManager.getInstance().getTeacherHolidayOperation().delete(key);
		}
	}

	public static void main(String[] args) {
		TeacherHolidayOperation operation = new TeacherHolidayOperation();
		// System.out.println(operation.getAll());
		TeacherHoliday teacherHoliday = new TeacherHoliday();
		teacherHoliday.setTeacherId(1);
		teacherHoliday.setAdjustDate(new Date(new java.util.Date().getTime()));
		teacherHoliday.setIsHoliday(true);
		// operation.add(teacherHoliday);

		Calendar cal = Calendar.getInstance();
		cal.setTime(teacherHoliday.getAdjustDate());
		for (int i = 1; i <= 30; i++) {
			int weekno = cal.get(Calendar.DAY_OF_WEEK);
			System.out.println(cal.getTime() +":" + weekno);
			cal.add(Calendar.DAY_OF_MONTH, 1);
		}

	}

}
