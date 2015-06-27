package com.kevin.course.operation.business;

import com.kevin.course.object.TeacherDefaultHoliday;
import com.kevin.course.operation.db.ITeacherDefaultHolidayOperation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherDefaultHolidayBusinessOperation implements ITeacherDefaultHolidayBusinessOperation{
    @Autowired
    private ITeacherDefaultHolidayOperation teacherDefaultHolidayOperation;

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

    public void deleteByTeacherId(int teacherId){
        teacherDefaultHolidayOperation.deleteByTeacherId(teacherId);
    }
}
