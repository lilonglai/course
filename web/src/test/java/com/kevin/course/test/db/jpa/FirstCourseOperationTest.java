package com.kevin.course.test.db.jpa;

import com.kevin.course.object.FirstCourse;
import com.kevin.course.operation.db.jpa.JpaFirstCourseOperation;
import junit.framework.TestCase;

import java.util.List;


public abstract class  FirstCourseOperationTest extends TestCase{
	public void  testGet(){
		JpaFirstCourseOperation operation = new JpaFirstCourseOperation();
		FirstCourse firstCourse = operation.get(1);
	}
	
	
	public void testGetByGrade(){
		JpaFirstCourseOperation operation = new JpaFirstCourseOperation();
		List<FirstCourse> list = operation.getByGrade(1);
	}
	
	public void testGetAll(){
		JpaFirstCourseOperation operation = new JpaFirstCourseOperation();
		List<FirstCourse> list = operation.getAll();
	}
	
	
	public void  testAdd(){
		JpaFirstCourseOperation operation = new JpaFirstCourseOperation();
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
		JpaFirstCourseOperation operation = new JpaFirstCourseOperation();
		List<FirstCourse> list = operation.getAll();
		for(FirstCourse firstCourse: list){
			if(firstCourse.getName().equals("test")){
				firstCourse.setShortName("test 2");
				firstCourse.setDescription("change the test case for first course");
				operation.update(firstCourse);
			}
		}
	}
		
	public void testDelete(){
		JpaFirstCourseOperation operation = new JpaFirstCourseOperation();
		List<FirstCourse> list = operation.getAll();
		for(FirstCourse firstCourse: list){
			if(firstCourse.getName().equals("test")){
				firstCourse.setShortName("test 2");
				firstCourse.setDescription("change the test case for first course");
				operation.delete(firstCourse.getId());
			}
		}
	}

}
