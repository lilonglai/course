package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.TeacherHoliday;
import com.kevin.aeas.operation.db.ITeacherHolidayOperation;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisTeacherHoliday;
import org.apache.ibatis.session.SqlSession;

import java.sql.Date;
import java.util.List;

public class MyBatisTeacherHolidayOperation extends MyBatisBaseOperation<MyBatisTeacherHoliday> implements ITeacherHolidayOperation{
    public MyBatisTeacherHolidayOperation(){
        super(MyBatisTeacherHoliday.class);
    }

	public TeacherHoliday get(int key) {
        return proxy.get(key);
	}
	
	public List<TeacherHoliday> getByTeacherId(int teacherId) {
        return proxy.getByTeacherId(teacherId);
	}
	
	public TeacherHoliday getByTeacherAndDate(int teacherId,String date) {
        return proxy.getByTeacherAndDate(teacherId,Date.valueOf(date));
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
