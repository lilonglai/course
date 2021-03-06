package com.kevin.course.operation.db.mybatis;

import com.kevin.course.object.TeacherDefaultHoliday;
import com.kevin.course.operation.db.ITeacherDefaultHolidayOperation;

import java.util.List;

public class MyBatisTeacherDefaultHolidayOperation extends MyBatisBaseOperation<ITeacherDefaultHolidayOperation> implements ITeacherDefaultHolidayOperation{
    public MyBatisTeacherDefaultHolidayOperation(){
        super(ITeacherDefaultHolidayOperation.class);
    }

	public TeacherDefaultHoliday get(int key){
        return proxy.get(key);
	}
	
	public TeacherDefaultHoliday getByTeacherId(int teacherId){
        return proxy.getByTeacherId(teacherId);
	}
	
	public List<TeacherDefaultHoliday> getAll(){
        return proxy.getAll();
	}

	public void add(TeacherDefaultHoliday teacherDefaultHoliday){
        proxy.add(teacherDefaultHoliday);
	}
	
	public void update(TeacherDefaultHoliday teacherDefaultHoliday){
        proxy.update(teacherDefaultHoliday);
	}
	
	
	public void delete(int key){
        proxy.delete(key);
	}
	
	public void deleteByTeacherId(int teacherId){
        proxy.deleteByTeacherId(teacherId);
	}
	
}
