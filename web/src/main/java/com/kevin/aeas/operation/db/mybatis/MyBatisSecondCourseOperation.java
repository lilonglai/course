package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.SecondCourse;
import com.kevin.aeas.operation.db.ISecondCourseOperation;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisSecondCourse;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MyBatisSecondCourseOperation extends MyBatisBaseOperation<MyBatisSecondCourse> implements ISecondCourseOperation{
    public MyBatisSecondCourseOperation(){
        super(MyBatisSecondCourse.class);
    }

	public SecondCourse get(int key){
        SqlSession session = null;
        SecondCourse secondCourse;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisSecondCourse myBatisSecondCourse = session.getMapper(mybatisMapper);
            secondCourse = myBatisSecondCourse.get(key);
        }finally {
            session.close();
        }
		
		return secondCourse;		
	}

	
	public List<? extends SecondCourse> getByFirstCourseId(int firstCourseId){
		List<SecondCourse> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisSecondCourse myBatisSecondCourse = session.getMapper(mybatisMapper);
            list = myBatisSecondCourse.getByFirstCourseId(firstCourseId);
        }finally {
            session.close();
        }
		return list;
	}
	
	public List<? extends SecondCourse> getByGrade(int grade){
        List<SecondCourse> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisSecondCourse myBatisSecondCourse = session.getMapper(mybatisMapper);
            list = myBatisSecondCourse.getByGrade(grade);
        }finally {
            session.close();
        }
		return list;	
	}
	
	public List<? extends SecondCourse> getAll(){
        List<SecondCourse> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisSecondCourse myBatisSecondCourse = session.getMapper(mybatisMapper);
            list = myBatisSecondCourse.getAll();
        }finally {
            session.close();
        }
        return list;
    }
	
	
	public void add(SecondCourse secondCourse){
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisSecondCourse myBatisSecondCourse = session.getMapper(mybatisMapper);
            myBatisSecondCourse.add(secondCourse);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }
        finally {
            session.close();
        }
	}
	
	public void update(SecondCourse secondCourse){
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisSecondCourse myBatisSecondCourse = session.getMapper(mybatisMapper);
            myBatisSecondCourse.update(secondCourse);
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
            MyBatisSecondCourse myBatisSecondCourse = session.getMapper(mybatisMapper);
            myBatisSecondCourse.delete(key);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }
        finally {
            session.close();
        }
	}

}
