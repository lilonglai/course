package com.kevin.course.test.db.basic;


import com.kevin.course.object.SecondCourse;
import com.kevin.course.operation.db.basic.JdbcSecondCourseOperation;
import junit.framework.TestCase;

import java.util.List;

public class SecondCourseOperationTest extends TestCase{
	public void tetGet(){
        JdbcSecondCourseOperation operation = new JdbcSecondCourseOperation();
		SecondCourse secondCourse = operation.get(1);
	}
	
	public void testGetByFirstCourseId(){
        JdbcSecondCourseOperation operation = new JdbcSecondCourseOperation();
		List<SecondCourse> list = operation.getByFirstCourseId(1);
	}
	
	public void testGetByGrade(){
        JdbcSecondCourseOperation operation = new JdbcSecondCourseOperation();
		List<SecondCourse> list = operation.getByGrade(1);
		
		list = operation.getByGrade(2);
		
		list = operation.getByGrade(3);
	}
	
	public void testGetAll(){
        JdbcSecondCourseOperation operation = new JdbcSecondCourseOperation();
		List<SecondCourse> list = operation.getAll();
	}
	
	
	public void testAdd(){
        JdbcSecondCourseOperation operation = new JdbcSecondCourseOperation();
		SecondCourse secondCourse = new SecondCourse();
		
		secondCourse.setName("test");
		secondCourse.setShortName("test");
		secondCourse.setDescription(" this is the test case for second course");
		secondCourse.setFirstCourseId(1);
		operation.add(secondCourse);
	}
	
	public void testUpdate(){
        JdbcSecondCourseOperation operation = new JdbcSecondCourseOperation();
		List<SecondCourse> list = operation.getAll();
		for(SecondCourse secondCourse: list){
			if(secondCourse.getName().equals("test")){
				secondCourse.setShortName("test 2");
				secondCourse.setDescription("change the test case for first course");
				operation.update(secondCourse);
			}
		}
	}
	
	
	public void testDelete(){
        JdbcSecondCourseOperation operation = new JdbcSecondCourseOperation();
		List<SecondCourse> list = operation.getAll();
		for(SecondCourse secondCourse: list){
			if(secondCourse.getName().equals("test")){
				secondCourse.setShortName("test 2");
				secondCourse.setDescription("change the test case for first course");
				operation.delete(secondCourse.getId());
			}
		}
	}
	
	protected void setUp() throws Exception{

	}
	
}
