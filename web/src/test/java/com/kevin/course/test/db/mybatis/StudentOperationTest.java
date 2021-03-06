package com.kevin.course.test.db.mybatis;

import com.kevin.course.object.Student;
import com.kevin.course.operation.db.mybatis.MyBatisStudentOperation;
import junit.framework.TestCase;

import java.sql.Date;
import java.util.List;

public class StudentOperationTest extends TestCase {
	public void testGet() {
		MyBatisStudentOperation operation = new MyBatisStudentOperation();
		Student student = operation.get(1);
	}

	
	public void testGetByName() {
        MyBatisStudentOperation operation = new MyBatisStudentOperation();
		Student student = operation.getByName("test");
	}
	

	public void testGetByGrade() {
        MyBatisStudentOperation operation = new MyBatisStudentOperation();
		List<? extends Student> list = operation.getByGrade(1);

	}

	public void testGetAll() {
        MyBatisStudentOperation operation = new MyBatisStudentOperation();
		List<? extends Student> list = operation.getAll();
	}
	
	public void testGetAlive() {
        MyBatisStudentOperation operation = new MyBatisStudentOperation();
		List<? extends Student> list = operation.getAlive();
	}
	
	public void testGetNotAlive() {
        MyBatisStudentOperation operation = new MyBatisStudentOperation();
		List<? extends Student> list = operation.getNotAlive();
	}

	public void testGetByTeacherId() {
        MyBatisStudentOperation operation = new MyBatisStudentOperation();
		List<? extends Student> list = operation.getByTeacherId(1);

	}

	public void testAdd(){
        MyBatisStudentOperation operation = new MyBatisStudentOperation();
		Student student = new Student();
		
		student.setName("test");
		student.setShortName("test");
		student.setGrade(1);
		student.setTestScore("25");
		student.setTargetScore("50");
		student.setTeacherId(1);
		student.setExaminePlace("SH");
		student.setExamineDate(new Date(1985,6,20));
		student.setDescription("this is the test case for student");
		operation.add(student);
		
	}

	public void testUpdate() {
        MyBatisStudentOperation operation = new MyBatisStudentOperation();
		List<? extends Student> list = operation.getAll();
		for(Student student: list){
			if(student.getName().equals("test")){
				student.setShortName("test 2");
				student.setDescription("change the test case for first course");
				operation.update(student);
			}
		}

	}

	public void testDelete() {
        MyBatisStudentOperation operation = new MyBatisStudentOperation();
		List<Student> list = operation.getAll();
		for(Student student: list){
			if(student.getName().equals("test")){
				student.setShortName("test 2");
				student.setDescription("change the test case for student");
				operation.delete(student.getId());;
			}
		}

	}
	
	public void testRetire() {
        MyBatisStudentOperation operation = new MyBatisStudentOperation();
	    List<Student> list = operation.getAll();
		for(Student student: list){
			if(student.getName().equals("test")){
				student.setShortName("test 2");
				student.setDescription("change the test case for student");
				operation.retire(student.getId());;
			}
		}
	}

}
