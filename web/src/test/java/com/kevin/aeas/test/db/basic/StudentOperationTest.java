package com.kevin.aeas.test.db.basic;

import java.sql.Date;
import java.util.ArrayList;

import com.kevin.aeas.object.Student;
import com.kevin.aeas.operation.db.basic.DbStudentOperation;
import com.kevin.aeas.test.db.utils.DbUtils;

import junit.framework.TestCase;

public abstract class StudentOperationTest extends TestCase {
	public void testGet() {
		DbStudentOperation operation = new DbStudentOperation();
		Student student = operation.get(1);
	}

	
	public void testGetByName() {
		DbStudentOperation operation = new DbStudentOperation();
		Student student = operation.getByName("test");
	}
	

	public void testGetByGrade() {
		DbStudentOperation operation = new DbStudentOperation();
		ArrayList<Student> list = operation.getByGrade(1);

	}

	public void testGetAll() {
		DbStudentOperation operation = new DbStudentOperation();
		ArrayList<Student> list = operation.getAll();
	}
	
	public void testGetAlive() {
		DbStudentOperation operation = new DbStudentOperation();
		ArrayList<Student> list = operation.getAlive();
	}
	
	public void testGetNotAlive() {
		DbStudentOperation operation = new DbStudentOperation();
		ArrayList<Student> list = operation.getNotAlive();
	}

	public void testGetByTeacherId() {
		DbStudentOperation operation = new DbStudentOperation();
		ArrayList<Student> list = operation.getByTeacherId(1);

	}

	/**
	 * 
	 */
	public void testAdd(){
		DbStudentOperation operation = new DbStudentOperation();
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
		DbStudentOperation operation = new DbStudentOperation();
		ArrayList<Student> list = operation.getAll();
		for(Student student: list){
			if(student.getName().equals("test")){
				student.setShortName("test 2");
				student.setDescription("change the test case for first course");
				operation.update(student);
			}
		}

	}

	public void testDelete() {		
		DbStudentOperation operation = new DbStudentOperation();
		ArrayList<Student> list = operation.getAll();
		for(Student student: list){
			if(student.getName().equals("test")){
				student.setShortName("test 2");
				student.setDescription("change the test case for student");
				operation.delete(student.getId());;
			}
		}

	}
	
	public void testRetire() {
		DbStudentOperation operation = new DbStudentOperation();
		ArrayList<Student> list = operation.getAll();
		for(Student student: list){
			if(student.getName().equals("test")){
				student.setShortName("test 2");
				student.setDescription("change the test case for student");
				operation.retire(student.getId());;
			}
		}
	}
	
	protected void setUp() throws Exception{
		DbUtils.resetDbInstance();
	}
}
