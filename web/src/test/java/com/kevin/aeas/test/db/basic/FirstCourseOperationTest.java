package com.kevin.aeas.test.db.basic;

import java.util.List;

import com.kevin.aeas.operation.db.basic.JdbcFirstCourseOperation;
import junit.framework.TestCase;

import com.kevin.aeas.object.FirstCourse;
import com.kevin.aeas.test.db.utils.DbUtils;


public abstract class  FirstCourseOperationTest extends TestCase{
	public void  testGet(){
		JdbcFirstCourseOperation operation = new JdbcFirstCourseOperation();
		FirstCourse firstCourse = operation.get(1);
	}
	
	
	public void testGetByGrade(){
		JdbcFirstCourseOperation operation = new JdbcFirstCourseOperation();
		List<? extends FirstCourse> list = operation.getByGrade(1);
	}
	
	public void testGetAll(){
		JdbcFirstCourseOperation operation = new JdbcFirstCourseOperation();
		List<? extends FirstCourse> list = operation.getAll();
	}
	
	
	public void  testAdd(){
		JdbcFirstCourseOperation operation = new JdbcFirstCourseOperation();
		FirstCourse firstCourse = new FirstCourse();
		
		//* add grade 1 first course
		firstCourse.setName("test");
		firstCourse.setShortName("test");
		firstCourse.setGrade(1);
		firstCourse.setDescription("this is the test case for first course");		
		operation.add(firstCourse);
		
		// add grade 2 first course
		firstCourse.setName("test");
		firstCourse.setShortName("test");
		firstCourse.setGrade(2);
		firstCourse.setDescription("this is the test case for first course");		
		operation.add(firstCourse);
		
		// add grade 3 first course
		firstCourse.setName("test");
		firstCourse.setShortName("test");
		firstCourse.setGrade(2);
		firstCourse.setDescription("this is the test case for first course");		
		operation.add(firstCourse);
	}
	
	public void testUpdate(){
		JdbcFirstCourseOperation operation = new JdbcFirstCourseOperation();
		List<? extends FirstCourse> list = operation.getAll();
		for(FirstCourse firstCourse: list){
			if(firstCourse.getName().equals("test")){
				firstCourse.setShortName("test 2");
				firstCourse.setDescription("change the test case for first course");
				operation.update(firstCourse);
			}
		}
	}
		
	public void testDelete(){
		JdbcFirstCourseOperation operation = new JdbcFirstCourseOperation();
		List<? extends FirstCourse> list = operation.getAll();
		for(FirstCourse firstCourse: list){
			if(firstCourse.getName().equals("test")){
				firstCourse.setShortName("test 2");
				firstCourse.setDescription("change the test case for first course");
				operation.delete(firstCourse.getId());
			}
		}
	}
	
	protected void setUp() throws Exception{
		DbUtils.resetDbInstance();
	}
}
