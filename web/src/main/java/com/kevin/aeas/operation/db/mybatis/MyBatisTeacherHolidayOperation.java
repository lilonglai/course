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
		TeacherHoliday teacherHoliday = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherHoliday myBatisTeacherHoliday = session.getMapper(mybatisMapper);
            teacherHoliday = myBatisTeacherHoliday.get(key);
        }finally {
            session.close();
        }
		return teacherHoliday;
	}
	
	public List<TeacherHoliday> getByTeacherId(int teacherId) {
		List<TeacherHoliday> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherHoliday myBatisTeacherHoliday = session.getMapper(mybatisMapper);
            list = myBatisTeacherHoliday.getByTeacherId(teacherId);
        }finally {
            session.close();
        }
		return list;
	}
	
	public TeacherHoliday getByTeacherAndDate(int teacherId,String date) {
		TeacherHoliday teacherHoliday = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherHoliday myBatisTeacherHoliday = session.getMapper(mybatisMapper);
            teacherHoliday = myBatisTeacherHoliday.getByTeacherAndDate(teacherId, Date.valueOf(date));
        }finally {
            session.close();
        }
		return teacherHoliday;
	}

	public List<TeacherHoliday> getAll() {
		List<TeacherHoliday> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherHoliday myBatisTeacherHoliday = session.getMapper(mybatisMapper);
            list = myBatisTeacherHoliday.getAll();
        }finally {
            session.close();
        }
		return list;
	}

	public void add(TeacherHoliday teacherHoliday) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherHoliday myBatisTeacherHoliday = session.getMapper(mybatisMapper);
            myBatisTeacherHoliday.add(teacherHoliday);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
	}

	public void update(TeacherHoliday teacherHoliday) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherHoliday myBatisTeacherHoliday = session.getMapper(mybatisMapper);
            myBatisTeacherHoliday.update(teacherHoliday);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
	}

	public void delete(int key) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherHoliday myBatisTeacherHoliday = session.getMapper(mybatisMapper);
            myBatisTeacherHoliday.delete(key);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
	}

}
