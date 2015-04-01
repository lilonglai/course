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
		TeacherDefaultHoliday teacherDefaultHoliday = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherDefaultHoliday myBatisTeacherDefaultHoliday = session.getMapper(mybatisMapper);
            teacherDefaultHoliday = myBatisTeacherDefaultHoliday.get(key);
        }finally {
            session.close();
        }
		return teacherDefaultHoliday;		
	}
	
	public TeacherDefaultHoliday getByTeacherId(int teacherId){
		TeacherDefaultHoliday teacherDefaultHoliday = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherDefaultHoliday myBatisTeacherDefaultHoliday = session.getMapper(mybatisMapper);
            teacherDefaultHoliday = myBatisTeacherDefaultHoliday.getByTeacherId(teacherId);
        }finally {
            session.close();
        }
		return teacherDefaultHoliday;		
	}
	
	public List<TeacherDefaultHoliday> getAll(){
		List<TeacherDefaultHoliday> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherDefaultHoliday myBatisTeacherDefaultHoliday = session.getMapper(mybatisMapper);
            list = myBatisTeacherDefaultHoliday.getAll();
        }finally {
            session.close();
        }
		return list;		
	}

	public void add(TeacherDefaultHoliday teacherDefaultHoliday){
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherDefaultHoliday myBatisTeacherDefaultHoliday = session.getMapper(mybatisMapper);
            myBatisTeacherDefaultHoliday.add(teacherDefaultHoliday);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
	}
	
	public void update(TeacherDefaultHoliday teacherDefaultHoliday){
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherDefaultHoliday myBatisTeacherDefaultHoliday = session.getMapper(mybatisMapper);
            myBatisTeacherDefaultHoliday.update(teacherDefaultHoliday);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
	}
	
	
	public void delete(int key){
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherDefaultHoliday myBatisTeacherDefaultHoliday = session.getMapper(mybatisMapper);
            myBatisTeacherDefaultHoliday.delete(key);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
	}
	
	public void deleteByTeacherId(int teacherId){
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherDefaultHoliday myBatisTeacherDefaultHoliday = session.getMapper(mybatisMapper);
            myBatisTeacherDefaultHoliday.deleteByTeacherId(teacherId);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
	}
	
}
