package com.kevin.course.test.db.basic;

import com.kevin.course.object.FirstCourse;
import com.kevin.course.operation.db.basic.JdbcFirstCourseOperation;
import com.kevin.course.test.db.utils.DbUtils;
import junit.framework.TestCase;

import java.util.List;


public abstract class  FirstCourseOperationTest extends TestCase{
	public void  testGet(){
		JdbcFirstCourseOperation operation = new JdbcFirstCourseOperation();
		FirstCourse firstCourse = operation.get(1);
	}
	
	
	public void testGetByGrade(){
		JdbcFirstCourseOperation operation = new JdbcFirstCourseOperation();
		List<FirstCourse> list = operation.getByGrade(1);
	}
	
	public void testGetAll(){
		JdbcFirstCourseOperation operation = new JdbcFirstCourseOperation();
		List<FirstCourse> list = operation.getAll();
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
		firstCourse.setGrade(3);
		firstCourse.setDescription("this is the test case for first course");		
		operation.add(firstCourse);
	}
	
	public void testUpdate(){
		JdbcFirstCourseOperation operation = new JdbcFirstCourseOperation();
		List<FirstCourse> list = operation.getAll();
		for(FirstCourse firstCourse: list){
			if("test".equals(firstCourse.getName())){
				firstCourse.setShortName("test 2");
				firstCourse.setDescription("change the test case for first course");
				operation.update(firstCourse);
			}
		}
	}
		
	public void testDelete(){
		JdbcFirstCourseOperation operation = new JdbcFirstCourseOperation();
		List<FirstCourse> list = operation.getAll();
		for(FirstCourse firstCourse: list){
			if("test".equals(firstCourse.getName())){
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
