package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisStudent;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisTeacher;
import org.apache.ibatis.session.SqlSession;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MyBatisTeacherOperation extends MyBatisBaseOperation<Teacher> {
	public Teacher get(int key){
		Teacher teacher = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacher myBatisTeacher = session.getMapper(MyBatisTeacher.class);
            teacher = myBatisTeacher.get(key);
        }finally {
            session.close();
        }
		return teacher;
	}

	
	public Teacher getByName(String name){
        Teacher teacher = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacher myBatisTeacher = session.getMapper(MyBatisTeacher.class);
            teacher = myBatisTeacher.getByName(name);
        }finally {
            session.close();
        }
		return teacher;		
	}
	
	
	public Teacher getByShortName(String shortName){
        Teacher teacher = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacher myBatisTeacher = session.getMapper(MyBatisTeacher.class);
            teacher = myBatisTeacher.getByShortName(shortName);
        }finally {
            session.close();
        }
		return teacher;		
	}
	
	public List<Teacher> getAll(){
		List<Teacher> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacher myBatisTeacher = session.getMapper(MyBatisTeacher.class);
            list = myBatisTeacher.getAll();
        }finally {
            session.close();
        }
		return list;		
	}
	
	public List<Teacher> getAlive(){
        List<Teacher> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacher myBatisTeacher = session.getMapper(MyBatisTeacher.class);
            list = myBatisTeacher.getAlive();
        }finally {
            session.close();
        }
        return list;
	}

	public List<Teacher> getNotAlive(){
        List<Teacher> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacher myBatisTeacher = session.getMapper(MyBatisTeacher.class);
            list = myBatisTeacher.getNotAlive();
        }finally {
            session.close();
        }
        return list;
	}
	
	public Teacher getByCondition(Teacher condition){
        Teacher teacher = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacher myBatisTeacher = session.getMapper(MyBatisTeacher.class);
            teacher = myBatisTeacher.getByCondition(condition);
        }
        finally {
            session.close();
        }
		return teacher;
		
	}
	
	public void add(Teacher teacher){
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacher myBatisTeacher = session.getMapper(MyBatisTeacher.class);
            myBatisTeacher.add(teacher);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }
        finally {
            session.close();
        }
	}
	
	public void update(Teacher teacher){
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacher myBatisTeacher = session.getMapper(MyBatisTeacher.class);
            myBatisTeacher.update(teacher);
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
            MyBatisTeacher myBatisTeacher = session.getMapper(MyBatisTeacher.class);
            myBatisTeacher.delete(key);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }
        finally {
            session.close();
        }
	}
	
	public void retire(int key){
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacher myBatisTeacher = session.getMapper(MyBatisTeacher.class);
            myBatisTeacher.retire(key);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }
        finally {
            session.close();
        }
	}
}
