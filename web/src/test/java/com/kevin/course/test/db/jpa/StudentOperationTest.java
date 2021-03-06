package com.kevin.course.test.db.jpa;

import com.kevin.course.object.Student;
import com.kevin.course.operation.db.jpa.JpaStudentOperation;
import junit.framework.TestCase;

import java.sql.Date;
import java.util.List;

public abstract class StudentOperationTest extends TestCase {
	public void testGet() {
		JpaStudentOperation operation = new JpaStudentOperation();
		Student student = operation.get(1);
	}

	
	public void testGetByName() {
		JpaStudentOperation operation = new JpaStudentOperation();
		Student student = operation.getByName("test");
	}
	

	public void testGetByGrade() {
		JpaStudentOperation operation = new JpaStudentOperation();
		List<Student> list =  operation.getByGrade(1);

	}

	public void testGetAll() {
		JpaStudentOperation operation = new JpaStudentOperation();
		List<Student> list = operation.getAll();
	}
	
	public void testGetAlive() {
		JpaStudentOperation operation = new JpaStudentOperation();
		List<Student> list = operation.getAlive();
	}
	
	public void testGetNotAlive() {
		JpaStudentOperation operation = new JpaStudentOperation();
		List<Student> list = operation.getNotAlive();
	}

	public void testGetByTeacherId() {
		JpaStudentOperation operation = new JpaStudentOperation();
		List<Student> list = operation.getByTeacherId(1);

	}

	/**
	 * 
	 */
	public void testAdd(){
		JpaStudentOperation operation = new JpaStudentOperation();
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
		JpaStudentOperation operation = new JpaStudentOperation();
		List<Student> list =  operation.getAll();
		for(Student student: list){
			if(student.getName().equals("test")){
				student.setShortName("test 2");
				student.setDescription("change the test case for first course");
				operation.update(student);
			}
		}

	}

	public void testDelete() {		
		JpaStudentOperation operation = new JpaStudentOperation();
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
		JpaStudentOperation operation = new JpaStudentOperation();
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
