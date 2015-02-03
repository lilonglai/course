package com.kevin.aeas.test.db.jpa;

import java.util.ArrayList;

import com.kevin.aeas.object.FirstCourse;
import com.kevin.aeas.operation.db.jpa.JpaFirstCourseOperation;
import com.kevin.aeas.test.db.utils.DbUtils;

import junit.framework.TestCase;


public abstract class  FirstCourseOperationTest extends TestCase{
	public void  testGet(){
		JpaFirstCourseOperation operation = new JpaFirstCourseOperation();
		FirstCourse firstCourse = (FirstCourse)operation.get(1);
	}
	
	
	public void testGetByGrade(){
		JpaFirstCourseOperation operation = new JpaFirstCourseOperation();
		ArrayList<FirstCourse> list = (ArrayList<FirstCourse>)operation.getByGrade(1);
	}
	
	public void testGetAll(){
		JpaFirstCourseOperation operation = new JpaFirstCourseOperation();
		ArrayList<FirstCourse> list = (ArrayList<FirstCourse>) operation.getAll();
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
		ArrayList<FirstCourse> list = (ArrayList<FirstCourse>)operation.getAll();
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
		ArrayList<FirstCourse> list = (ArrayList<FirstCourse>)operation.getAll();
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
