package com.kevin.course.test.db.mybatis;

import com.kevin.course.object.Student;
import com.kevin.course.operation.db.IStudentOperation;
import com.kevin.course.test.db.utils.ApplicationContextUtils;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;

import java.sql.Date;
import java.util.List;

public class StudentOperationTest extends TestCase {
	IStudentOperation operation;
	public StudentOperationTest(){
		ApplicationContext context = ApplicationContextUtils.getMybatisInstance();
		operation = (IStudentOperation)context.getBean("myBatisStudentDao");
	}
	public void testGet() {
		Student student = operation.get(1);
	}

	
	public void testGetByName() {
		Student student = operation.getByName("test");
	}
	

	public void testGetByGrade() {
		List<? extends Student> list = operation.getByGrade(1);

	}

	public void testGetAll() {
		List<? extends Student> list = operation.getAll();
	}
	
	public void testGetAlive() {
		List<? extends Student> list = operation.getAlive();
	}
	
	public void testGetNotAlive() {
		List<? extends Student> list = operation.getNotAlive();
	}

	public void testGetByTeacherId() {
		List<? extends Student> list = operation.getByTeacherId(1);

	}

	public void testAdd(){
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
