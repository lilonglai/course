package com.kevin.course.operation.db.mybatis;

import com.kevin.course.object.TeacherHoliday;
import com.kevin.course.operation.db.ITeacherHolidayOperation;

import java.util.List;

public class MyBatisTeacherHolidayOperation extends MyBatisBaseOperation<ITeacherHolidayOperation> implements ITeacherHolidayOperation{
    public MyBatisTeacherHolidayOperation(){
        super(ITeacherHolidayOperation.class);
    }

	public TeacherHoliday get(int key) {
        return proxy.get(key);
	}
	
	public List<TeacherHoliday> getByTeacherId(int teacherId) {
        return proxy.getByTeacherId(teacherId);
	}
	
	public TeacherHoliday getByTeacherAndDate(int teacherId,String date) {
        return proxy.getByTeacherAndDate(teacherId,date);
	}

	public List<TeacherHoliday> getAll() {
        return proxy.getAll();
	}

	public void add(TeacherHoliday teacherHoliday) {
        proxy.add(teacherHoliday);
	}

	public void update(TeacherHoliday teacherHoliday) {
        proxy.update(teacherHoliday);
	}

	public void delete(int key) {
        proxy.delete(key);
	}

}
