package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.TeacherDefaultHoliday;
import com.kevin.aeas.operation.db.ITeacherDefaultHolidayOperation;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisTeacherDefaultHoliday;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MyBatisTeacherDefaultHolidayOperation extends MyBatisBaseOperation<MyBatisTeacherDefaultHoliday> implements ITeacherDefaultHolidayOperation{
    public MyBatisTeacherDefaultHolidayOperation(){
        super(MyBatisTeacherDefaultHoliday.class);
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
