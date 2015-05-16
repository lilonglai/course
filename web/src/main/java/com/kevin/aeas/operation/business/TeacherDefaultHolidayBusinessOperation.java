package com.kevin.aeas.operation.business;

import com.kevin.aeas.object.TeacherDefaultHoliday;
import com.kevin.aeas.operation.db.OperationManager;
import com.kevin.aeas.operation.db.TeacherDefaultHolidayOperation;

import java.util.List;

public class TeacherDefaultHolidayBusinessOperation {
    TeacherDefaultHolidayOperation teacherDefaultHolidayOperation = OperationManager.getInstance().getTeacherDefaultHolidayOperation();

    public void add(TeacherDefaultHoliday teacherDefaultHoliday){
        teacherDefaultHolidayOperation.add(teacherDefaultHoliday);
    }

    public void update(TeacherDefaultHoliday teacherDefaultHoliday){
        teacherDefaultHolidayOperation.update(teacherDefaultHoliday);
    }

	public TeacherDefaultHoliday get(int id){
		return teacherDefaultHolidayOperation.get(id);
	}

	public void delete(int id){
        teacherDefaultHolidayOperation.delete(id);
	}

    public List<TeacherDefaultHoliday> getAll(){
        return teacherDefaultHolidayOperation.getAll();
    }

    public TeacherDefaultHoliday getByTeacherId(int teacherId){
        return teacherDefaultHolidayOperation.getByTeacherId(teacherId);
    }
}
