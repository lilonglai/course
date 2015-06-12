package com.kevin.aeas.operation.business;

import com.kevin.aeas.object.TeacherHoliday;
import com.kevin.aeas.operation.db.OperationManager;
import com.kevin.aeas.operation.db.TeacherHolidayOperation;

import java.util.List;

public class TeacherHolidayBusinessOperation {
    TeacherHolidayOperation teacherHolidayOperation = OperationManager.getInstance().getTeacherHolidayOperation();

    public void add(TeacherHoliday teacherHoliday){
        teacherHolidayOperation.add(teacherHoliday);
    }

    public void update(TeacherHoliday teacherHoliday){
        teacherHolidayOperation.update(teacherHoliday);
    }

	public TeacherHoliday get(int id){
		return teacherHolidayOperation.get(id);
	}
	
	public void delete(int id){
        teacherHolidayOperation.delete(id);
	}

    public List<TeacherHoliday> getAll(){
        return teacherHolidayOperation.getAll();
    }

    public TeacherHoliday getByTeacherAndDate(int teacherId,String date) {
        return teacherHolidayOperation.getByTeacherAndDate(teacherId, date);
    }

    public List<TeacherHoliday> getByTeacherId(int teacherId) {
        return teacherHolidayOperation.getByTeacherId(teacherId);
    }
}