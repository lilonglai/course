package com.kevin.course.test.db.basic;

import com.kevin.course.object.Student;
import com.kevin.course.operation.db.basic.JdbcStudentOperation;
import com.kevin.course.test.db.utils.DbUtils;
import junit.framework.TestCase;

import java.sql.Date;
import java.util.List;

public abstract class StudentOperationTest extends TestCase {
	public void testGet() {
		JdbcStudentOperation operation = new JdbcStudentOperation();
		Student student = operation.get(1);
	}

	
	public void testGetByName() {
		JdbcStudentOperation operation = new JdbcStudentOperation();
		Student student = operation.getByName("test");
	}
	

	public void testGetByGrade() {
		JdbcStudentOperation operation = new JdbcStudentOperation();
		List<? extends Student> list = operation.getByGrade(1);

	}

	public void testGetAll() {
		JdbcStudentOperation operation = new JdbcStudentOperation();
		List<? extends Student> list = operation.getAll();
	}
	
	public void testGetAlive() {
		JdbcStudentOperation operation = new JdbcStudentOperation();
		List<? extends Student> list = operation.getAlive();
	}
	
	public void testGetNotAlive() {
		JdbcStudentOperation operation = new JdbcStudentOperation();
		List<? extends Student> list = operation.getNotAlive();
	}

	public void testGetByTeacherId() {
		JdbcStudentOperation operation = new JdbcStudentOperation();
		List<? extends Student> list = operation.getByTeacherId(1);

	}

	/**
	 * 
	 */
	public void testAdd(){
		JdbcStudentOperation operation = new JdbcStudentOperation();
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
		JdbcStudentOperation operation = new JdbcStudentOperation();
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
		JdbcStudentOperation operation = new JdbcStudentOperation();
		List<? extends Student> list = operation.getAll();
		for(Student student: list){
			if(student.getName().equals("test")){
				student.setShortName("test 2");
				student.setDescription("change the test case for student");
				operation.delete(student.getId());;
			}
		}

	}
	
	public void testRetire() {
		JdbcStudentOperation operation = new JdbcStudentOperation();
	    List<? extends Student> list = operation.getAll();
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
