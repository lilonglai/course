package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.FirstCourse;
import com.kevin.aeas.operation.db.IFirstCourseOperation;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisFirstCourse;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MyBatisFirstCourseOperation extends MyBatisBaseOperation<MyBatisFirstCourse> implements IFirstCourseOperation{

    public MyBatisFirstCourseOperation(){
        super(MyBatisFirstCourse.class);
    }

	public FirstCourse get(int key) {
        FirstCourse firstCourse = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisFirstCourse myBatisFirstCourse = session.getMapper(mybatisMapper);
            firstCourse = myBatisFirstCourse.get(key);
        }finally {
            session.close();
        }
        return firstCourse;
	}

	public List<? extends FirstCourse> getByGrade(int grade) {
		List<FirstCourse> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisFirstCourse myBatisFirstCourse = session.getMapper(mybatisMapper);
            list = myBatisFirstCourse.getByGrade(grade);
        }finally {
            session.close();
        }

		return list;

	}

	public List<? extends FirstCourse> getAll() {
        List<FirstCourse> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisFirstCourse myBatisFirstCourse = session.getMapper(mybatisMapper);
            list = myBatisFirstCourse.getAll();
        }finally {
            session.close();
        }

        return list;
	}

	public void add(FirstCourse firstCourse) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisFirstCourse myBatisFirstCourse = session.getMapper(mybatisMapper);
            myBatisFirstCourse.add(firstCourse);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }
        finally {
            session.close();
        }
	}

	public void update(FirstCourse firstCourse) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisFirstCourse myBatisFirstCourse = session.getMapper(mybatisMapper);
            myBatisFirstCourse.update(firstCourse);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }finally {
            session.close();
        }

	}

	public void delete(int key) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisFirstCourse myBatisFirstCourse = session.getMapper(mybatisMapper);
            myBatisFirstCourse.delete(key);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }finally {
            session.close();
        }

	}

}
