package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.SecondCourse;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisSecondCourse;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MyBatisSecondCourseOperation extends MyBatisBaseOperation<SecondCourse> {
	public SecondCourse get(int key){
        SqlSession session = null;
        SecondCourse secondCourse;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisSecondCourse myBatisSecondCourse = session.getMapper(MyBatisSecondCourse.class);
            secondCourse = myBatisSecondCourse.get(key);
        }finally {
            session.close();
        }
		
		return secondCourse;		
	}

	
	public List<SecondCourse> getByFirstCourseId(int firstCourseId){
		List<SecondCourse> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisSecondCourse myBatisSecondCourse = session.getMapper(MyBatisSecondCourse.class);
            list = myBatisSecondCourse.getByFirstCourseId(firstCourseId);
        }finally {
            session.close();
        }
		return list;
	}
	
	public List<SecondCourse> getByGrade(int grade){
        List<SecondCourse> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisSecondCourse myBatisSecondCourse = session.getMapper(MyBatisSecondCourse.class);
            list = myBatisSecondCourse.getByGrade(grade);
        }finally {
            session.close();
        }
		return list;	
	}
	
	public List<SecondCourse> getAll(){
        List<SecondCourse> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisSecondCourse myBatisSecondCourse = session.getMapper(MyBatisSecondCourse.class);
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
            MyBatisSecondCourse myBatisSecondCourse = session.getMapper(MyBatisSecondCourse.class);
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
            MyBatisSecondCourse myBatisSecondCourse = session.getMapper(MyBatisSecondCourse.class);
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
            MyBatisSecondCourse myBatisSecondCourse = session.getMapper(MyBatisSecondCourse.class);
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
