package com.kevin.aeas.operation.db;

import com.kevin.aeas.object.Schedule;
import com.kevin.aeas.operation.db.basic.JdbcScheduleOperation;
import com.kevin.aeas.operation.db.jpa.JpaScheduleOperation;
import com.kevin.aeas.operation.db.mybatis.MyBatisScheduleOperation;
import com.kevin.aeas.utils.ConfigurationManager;

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
	
	public List<? extends Schedule> getByStudentId(int studentId){
        return scheduleDao.getByStudentId(studentId);
	}
	
	public List<? extends Schedule> getByTeacherId(int teacherId){
        return scheduleDao.getByTeacherId(teacherId);
	}
	
	
	public List<? extends Schedule> getByDateAndTime(Date onDate, int onTime){
        return scheduleDao.getByDateAndTime(onDate, onTime);
	}
	
	public List<? extends Schedule> getAll(){
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
