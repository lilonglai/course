package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.Student;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisFirstCourse;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisStudent;
import org.apache.ibatis.session.SqlSession;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MyBatisStudentOperation extends MyBatisBaseOperation<Student> {
	public Student get(int key) {
		Student student = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisStudent myBatisStudent = session.getMapper(MyBatisStudent.class);
            student = myBatisStudent.get(key);
        }finally {
            session.close();
        }
		return student;
	}
	
	public Student getByName(String name) {
        Student student = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisStudent myBatisStudent = session.getMapper(MyBatisStudent.class);
            student = myBatisStudent.getByName(name);
        }finally {
            session.close();
        }
		return student;
	}
	

	public List<Student> getByGrade(int grade) {
		List<Student> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisStudent myBatisStudent = session.getMapper(MyBatisStudent.class);
            list = myBatisStudent.getByGrade(grade);
        }finally {
            session.close();
        }
		return list;
	}

	public List<Student> getAll() {
		List<Student> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisStudent myBatisStudent = session.getMapper(MyBatisStudent.class);
            list = myBatisStudent.getAll();
        }finally {
            session.close();
        }
		return list;
	}
	
	public List<Student> getAlive() {
		List<Student> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisStudent myBatisStudent = session.getMapper(MyBatisStudent.class);
            list = myBatisStudent.getAlive();
        }finally {
            session.close();
        }
		return list;
	}
	
	public List<Student> getNotAlive() {
		List<Student> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisStudent myBatisStudent = session.getMapper(MyBatisStudent.class);
            list = myBatisStudent.getNotAlive();
        }finally {
            session.close();
        }
		return list;
	}

	public List<Student> getByTeacherId(int teacherId) {
		List<Student> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisStudent myBatisStudent = session.getMapper(MyBatisStudent.class);
            list = myBatisStudent.getByTeacherId(teacherId);
        }finally {
            session.close();
        }
		return list;
	}

	public void add(Student student){
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisStudent myBatisStudent = session.getMapper(MyBatisStudent.class);
            myBatisStudent.add(student);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }
        finally {
            session.close();
        }
	}

	public void update(Student student) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisStudent myBatisStudent = session.getMapper(MyBatisStudent.class);
            myBatisStudent.update(student);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }
        finally {
            session.close();
        }
	}

	public void delete(int key) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisStudent myBatisStudent = session.getMapper(MyBatisStudent.class);
            myBatisStudent.delete(key);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }
        finally {
            session.close();
        }
	}
	
	public void retire(int key) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisStudent myBatisStudent = session.getMapper(MyBatisStudent.class);
            myBatisStudent.retire(key);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }
        finally {
            session.close();
        }
	}

	public static void main(String[] args) {
		MyBatisStudentOperation studentOperation = new MyBatisStudentOperation();
		System.out.println(studentOperation.getAll());
		
	}

}
