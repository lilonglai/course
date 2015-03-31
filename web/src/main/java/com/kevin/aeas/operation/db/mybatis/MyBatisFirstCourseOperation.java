package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.FirstCourse;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisFirstCourse;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MyBatisFirstCourseOperation extends MyBatisBaseOperation<FirstCourse> {

	public FirstCourse get(int key) {
        FirstCourse firstCourse = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisFirstCourse myBatisFirstCourse = session.getMapper(MyBatisFirstCourse.class);
            firstCourse = myBatisFirstCourse.get(key);
        }finally {
            session.close();
        }
        return firstCourse;
	}

	public List<FirstCourse> getByGrade(int grade) {
		List<FirstCourse> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisFirstCourse myBatisFirstCourse = session.getMapper(MyBatisFirstCourse.class);
            list = myBatisFirstCourse.getByGrade(grade);
        }finally {
            session.close();
        }

		return list;

	}

	public List<FirstCourse> getAll() {
        List<FirstCourse> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisFirstCourse myBatisFirstCourse = session.getMapper(MyBatisFirstCourse.class);
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
            MyBatisFirstCourse myBatisFirstCourse = session.getMapper(MyBatisFirstCourse.class);
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
            MyBatisFirstCourse myBatisFirstCourse = session.getMapper(MyBatisFirstCourse.class);
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
            MyBatisFirstCourse myBatisFirstCourse = session.getMapper(MyBatisFirstCourse.class);
            myBatisFirstCourse.delete(key);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }finally {
            session.close();
        }

	}

}
