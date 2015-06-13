package com.kevin.course.operation.db;

import com.kevin.course.object.Schedule;
import com.kevin.course.operation.db.basic.JdbcScheduleOperation;
import com.kevin.course.operation.db.jpa.JpaScheduleOperation;
import com.kevin.course.operation.db.mybatis.MyBatisScheduleOperation;
import com.kevin.course.utils.ConfigurationManager;

import java.sql.Date;
import java.util.List;

public class ScheduleOperation {

    private IScheduleOperation scheduleDao;
    public ScheduleOperation(){
        if(ConfigurationManager.getInstance().isJpa()){
            scheduleDao = new JpaScheduleOperation();
        }
        else if(ConfigurationManager.getInstance().isMyBatis()){
            scheduleDao = new MyBatisScheduleOperation();
        }
        else{
            scheduleDao = new JdbcScheduleOperation();
        }
    }

	public Schedule get(int key){
        return scheduleDao.get(key);
	}
	
	public Schedule getByStudentIdOnDateAndTime(int studentId, Date onDate, int onTime){
		return scheduleDao.getByStudentIdOnDateAndTime(studentId, onDate, onTime);
	}
	
	public List<Schedule> getByStudentId(int studentId){
        return scheduleDao.getByStudentId(studentId);
	}
	
	public List<Schedule> getByTeacherId(int teacherId){
        return scheduleDao.getByTeacherId(teacherId);
	}
	
	
	public List<Schedule> getByDateAndTime(Date onDate, int onTime){
        return scheduleDao.getByDateAndTime(onDate, onTime);
	}
	
	public List<Schedule> getAll(){
        return scheduleDao.getAll();
	}
	
	
	public void add(Schedule schedule){
        scheduleDao.add(schedule);
	}
	
	public void update(Schedule schedule){
        scheduleDao.update(schedule);
	}
	
	
	public void delete(int key){
        scheduleDao.delete(key);
	}

}
