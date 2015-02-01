package com.kevin.aeas.test.db.basic;


import java.util.ArrayList;

import com.kevin.aeas.object.SecondCourse;
import com.kevin.aeas.operation.db.basic.DbSecondCourseOperation;
import com.kevin.aeas.test.db.utils.DbUtils;

import junit.framework.TestCase;

public abstract class SecondCourseOperationTest extends TestCase{
	public void tetGet(){
		DbSecondCourseOperation operation = new DbSecondCourseOperation();
		SecondCourse secondCourse = operation.get(1);
	}
	
	public void testGetByFirstCourseId(){
		DbSecondCourseOperation operation = new DbSecondCourseOperation();
		ArrayList<SecondCourse> list = operation.getByFirstCourseId(1);
	}
	
	public void testGetByGrade(){
		DbSecondCourseOperation operation = new DbSecondCourseOperation();
		ArrayList<SecondCourse> list = operation.getByGrade(1);
		
		list = operation.getByGrade(2);
		
		list = operation.getByGrade(3);
	}
	
	public void testGetAll(){
		DbSecondCourseOperation operation = new DbSecondCourseOperation();
		ArrayList<SecondCourse> list = operation.getAll();
	}
	
	
	public void testAdd(){
		DbSecondCourseOperation operation = new DbSecondCourseOperation();
		SecondCourse secondCourse = new SecondCourse();
		
		secondCourse.setName("test");
		secondCourse.setShortName("test");
		secondCourse.setDescription(" this is the test case for second course");
		secondCourse.setFirstCourseId(1);
		operation.add(secondCourse);
	}
	
	public void testUpdate(){
		DbSecondCourseOperation operation = new DbSecondCourseOperation();
		ArrayList<SecondCourse> list = operation.getAll();
		for(SecondCourse secondCourse: list){
			if(secondCourse.getName().equals("test")){
				secondCourse.setShortName("test 2");
				secondCourse.setDescription("change the test case for first course");
				operation.update(secondCourse);
			}
		}
	}
	
	
	public void testDelete(){
		DbSecondCourseOperation operation = new DbSecondCourseOperation();
		ArrayList<SecondCourse> list = operation.getAll();
		for(SecondCourse secondCourse: list){
			if(secondCourse.getName().equals("test")){
				secondCourse.setShortName("test 2");
				secondCourse.setDescription("change the test case for first course");
				operation.delete(secondCourse.getId());
			}
		}
	}
	
	protected void setUp() throws Exception{
		DbUtils.resetDbInstance();
	}
	
}
