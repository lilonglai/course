package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.Schedule;
import com.kevin.aeas.operation.db.IScheduleOperation;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisSchedule;

import java.sql.Date;
import java.util.List;

public class MyBatisScheduleOperation extends MyBatisBaseOperation<MyBatisSchedule> implements IScheduleOperation{

    public MyBatisScheduleOperation(){
        super(MyBatisSchedule.class);
    }

	public Schedule get(int key){
        return proxy.get(key);
	}
	
	public Schedule getByStudentIdOnDateAndTime(int studentId, Date onDate, int onTime){
        return proxy.getByStudentIdOnDateAndTime(studentId, onDate, onTime);
	}
	
	public List<Schedule> getByStudentId(int studentId){
        return proxy.getByStudentId(studentId);
	}
	
	public List<Schedule> getByTeacherId(int teacherId){
        return proxy.getByTeacherId(teacherId);
	}
		
	public List<Schedule> getByDateAndTime(Date onDate, int onTime){
        return proxy.getByDateAndTime(onDate, onTime);
	}
	
	public List<Schedule> getAll(){
        return proxy.getAll();
	}
	
	
	public void add(Schedule schedule){
        proxy.add(schedule);
	}
	
	public void update(Schedule schedule){
        proxy.update(schedule);
	}

	public void delete(int key){
        proxy.delete(key);
	}

}
