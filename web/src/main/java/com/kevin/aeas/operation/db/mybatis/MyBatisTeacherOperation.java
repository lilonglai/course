package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.operation.db.ITeacherOperation;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisTeacher;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MyBatisTeacherOperation extends MyBatisBaseOperation<MyBatisTeacher> implements ITeacherOperation{
    public MyBatisTeacherOperation(){
        super(MyBatisTeacher.class);
    }

	public Teacher get(int key){
		Teacher teacher = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacher myBatisTeacher = session.getMapper(mybatisMapper);
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
            MyBatisTeacher myBatisTeacher = session.getMapper(mybatisMapper);
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
            MyBatisTeacher myBatisTeacher = session.getMapper(mybatisMapper);
            teacher = myBatisTeacher.getByShortName(shortName);
        }finally {
            session.close();
        }
		return teacher;		
	}
	
	public List<? extends Teacher> getAll(){
		List<Teacher> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacher myBatisTeacher = session.getMapper(mybatisMapper);
            list = myBatisTeacher.getAll();
        }finally {
            session.close();
        }
		return list;		
	}
	
	public List<? extends Teacher> getAlive(){
        List<Teacher> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacher myBatisTeacher = session.getMapper(mybatisMapper);
            list = myBatisTeacher.getAlive();
        }finally {
            session.close();
        }
        return list;
	}

	public List<? extends Teacher> getNotAlive(){
        List<Teacher> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacher myBatisTeacher = session.getMapper(mybatisMapper);
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
            MyBatisTeacher myBatisTeacher = session.getMapper(mybatisMapper);
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
            MyBatisTeacher myBatisTeacher = session.getMapper(mybatisMapper);
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
            MyBatisTeacher myBatisTeacher = session.getMapper(mybatisMapper);
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
            MyBatisTeacher myBatisTeacher = session.getMapper(mybatisMapper);
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
            MyBatisTeacher myBatisTeacher = session.getMapper(mybatisMapper);
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
