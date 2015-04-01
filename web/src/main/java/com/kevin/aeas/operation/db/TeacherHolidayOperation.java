package com.kevin.aeas.operation.db;

import com.kevin.aeas.object.TeacherHoliday;
import com.kevin.aeas.operation.db.basic.JdbcTeacherHolidayOperation;
import com.kevin.aeas.operation.db.jpa.JpaTeacherHolidayOperation;
import com.kevin.aeas.operation.db.mybatis.MyBatisTeacherHolidayOperation;
import com.kevin.aeas.utils.ConfigurationManager;

import java.util.List;

public class TeacherHolidayOperation {
    private ITeacherHolidayOperation teacherHolidayDao;
    public TeacherHolidayOperation(){
        if(ConfigurationManager.getInstance().isJpa()){
            teacherHolidayDao = new JpaTeacherHolidayOperation();
        }
        else if(ConfigurationManager.getInstance().isMyBatis()){
            teacherHolidayDao = new MyBatisTeacherHolidayOperation();
        }
        else{
            teacherHolidayDao = new JdbcTeacherHolidayOperation();
        }
    }

	public TeacherHoliday get(int key) {
        return teacherHolidayDao.get(key);
	}

	public List<TeacherHoliday> getByTeacherId(int teacherId) {
        return teacherHolidayDao.getByTeacherId(teacherId);
	}
	
	public TeacherHoliday getByTeacherAndDate(int teacherId,String date) {
        return teacherHolidayDao.getByTeacherAndDate(teacherId, date);
	}

	public List<TeacherHoliday> getAll() {
        return teacherHolidayDao.getAll();
	}

	public void add(TeacherHoliday teacherHoliday) {
        teacherHolidayDao.add(teacherHoliday);
	}

	public void update(TeacherHoliday teacherHoliday) {
        teacherHolidayDao.update(teacherHoliday);
	}

	public void delete(int key) {
        teacherHolidayDao.delete(key);
	}

}
