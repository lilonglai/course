package com.kevin.aeas.operation.db;

import com.kevin.aeas.object.TeacherDefaultHoliday;
import com.kevin.aeas.operation.db.basic.JdbcTeacherDefaultHolidayOperation;
import com.kevin.aeas.operation.db.jpa.JpaTeacherDefaultHolidayOperation;
import com.kevin.aeas.operation.db.mybatis.MyBatisTeacherDefaultHolidayOperation;
import com.kevin.aeas.utils.ConfigurationManager;

import java.util.List;

public class TeacherDefaultHolidayOperation {
    private ITeacherDefaultHolidayOperation teacherDefaultHolidayDao;
    public TeacherDefaultHolidayOperation(){
        if(ConfigurationManager.getInstance().isJpa()){
            teacherDefaultHolidayDao = new JpaTeacherDefaultHolidayOperation();
        }
        else if(ConfigurationManager.getInstance().isMyBatis()){
            teacherDefaultHolidayDao = new MyBatisTeacherDefaultHolidayOperation();
        }
        else{
            teacherDefaultHolidayDao = new JdbcTeacherDefaultHolidayOperation();
        }
    }

	public TeacherDefaultHoliday get(int key){
        return teacherDefaultHolidayDao.get(key);
	}
	
	public TeacherDefaultHoliday getByTeacherId(int teacherId){
        return teacherDefaultHolidayDao.getByTeacherId(teacherId);
	}
	
	public List<TeacherDefaultHoliday> getAll(){
        return teacherDefaultHolidayDao.getAll();
	}

	public void add(TeacherDefaultHoliday teacherDefaultHoliday){
        teacherDefaultHolidayDao.add(teacherDefaultHoliday);
	}
	
	public void update(TeacherDefaultHoliday teacherDefaultHoliday){
        teacherDefaultHolidayDao.update(teacherDefaultHoliday);
	}

	public void delete(int key){
        teacherDefaultHolidayDao.delete(key);
	}
	
	public void deleteByTeacherId(int teacherId){
        teacherDefaultHolidayDao.deleteByTeacherId(teacherId);
	}
}
