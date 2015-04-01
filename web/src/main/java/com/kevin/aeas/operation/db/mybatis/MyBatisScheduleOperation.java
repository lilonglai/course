package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.Schedule;
import com.kevin.aeas.operation.db.IScheduleOperation;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisSchedule;
import org.apache.ibatis.session.SqlSession;

import java.sql.Date;
import java.util.List;

public class MyBatisScheduleOperation extends MyBatisBaseOperation<MyBatisSchedule> implements IScheduleOperation{

    public MyBatisScheduleOperation(){
        super(MyBatisSchedule.class);
    }

	public Schedule get(int key){
		Schedule schedule = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisSchedule myBatisSchedule = session.getMapper(mybatisMapper);
            schedule = myBatisSchedule.get(key);
        }finally {
            session.close();
        }
		return schedule;		
	}
	
	public Schedule getByStudentIdOnDateAndTime(int studentId, Date onDate, int onTime){
		Schedule schedule = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisSchedule myBatisSchedule = session.getMapper(mybatisMapper);
            schedule = myBatisSchedule.getByStudentIdOnDateAndTime(studentId, onDate, onTime);
        }finally {
            session.close();
        }
		return schedule;	
	}
	
	public List<Schedule> getByStudentId(int studentId){ ;
		List<Schedule> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisSchedule myBatisSchedule = session.getMapper(mybatisMapper);
            list = myBatisSchedule.getByStudentId(studentId);
        }finally {
            session.close();
        }
		return list;
	}
	
	public List<Schedule> getByTeacherId(int teacherId){
		List<Schedule> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisSchedule myBatisSchedule = session.getMapper(mybatisMapper);
            list = myBatisSchedule.getByTeacherId(teacherId);
        }finally {
            session.close();
        }
		return list;
	}
		
	public List<Schedule> getByDateAndTime(Date onDate, int onTime){
		List<Schedule> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisSchedule myBatisSchedule = session.getMapper(mybatisMapper);
            list = myBatisSchedule.getByDateAndTime(onDate, onTime);
        }finally {
            session.close();
        }
		return list;
	}
	
	public List<Schedule> getAll(){
		List<Schedule> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisSchedule myBatisSchedule = session.getMapper(mybatisMapper);
            list = myBatisSchedule.getAll();
        }finally {
            session.close();
        }
		return list;
	}
	
	
	public void add(Schedule schedule){
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisSchedule myBatisSchedule = session.getMapper(mybatisMapper);
            myBatisSchedule.add(schedule);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }
        finally {
            session.close();
        }
	}
	
	public void update(Schedule schedule){
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisSchedule myBatisSchedule = session.getMapper(mybatisMapper);
            myBatisSchedule.update(schedule);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }
        finally {
            session.close();
        }
	}

	public void delete(int key){
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisSchedule myBatisSchedule = session.getMapper(mybatisMapper);
            myBatisSchedule.delete(key);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }
        finally {
            session.close();
        }
	}

}
