package com.kevin.aeas.test.db.jpa;


import java.util.ArrayList;
import java.util.List;

import com.kevin.aeas.object.SecondCourse;
import com.kevin.aeas.operation.db.jpa.JpaSecondCourseOperation;
import com.kevin.aeas.test.db.utils.DbUtils;

import junit.framework.TestCase;

public abstract class SecondCourseOperationTest extends TestCase{
	public void tetGet(){
		JpaSecondCourseOperation operation = new JpaSecondCourseOperation();
		SecondCourse secondCourse = operation.get(1);
	}
	
	public void testGetByFirstCourseId(){
		JpaSecondCourseOperation operation = new JpaSecondCourseOperation();
		List<SecondCourse> list = operation.getByFirstCourseId(1);
	}
	
	public void testGetByGrade(){
		JpaSecondCourseOperation operation = new JpaSecondCourseOperation();
		List<SecondCourse> list = operation.getByGrade(1);
		
		list = operation.getByGrade(2);
		
		list = operation.getByGrade(3);
	}
	
	public void testGetAll(){
		JpaSecondCourseOperation operation = new JpaSecondCourseOperation();
		List<SecondCourse> list =  operation.getAll();
	}
	
	
	public void testAdd(){
		JpaSecondCourseOperation operation = new JpaSecondCourseOperation();
		SecondCourse secondCourse = new SecondCourse();
		
		secondCourse.setName("test");
		secondCourse.setShortName("test");
		secondCourse.setDescription(" this is the test case for second course");
		secondCourse.setFirstCourseId(1);
		operation.add(secondCourse);
	}
	
	public void testUpdate(){
		JpaSecondCourseOperation operation = new JpaSecondCourseOperation();
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
		JpaSecondCourseOperation operation = new JpaSecondCourseOperation();
		List<SecondCourse> list = operation.getAll();
		for(SecondCourse secondCourse: list){
			if(secondCourse.getName().equals("test")){
				secondCourse.setShortName("test 2");
				secondCourse.setDescription("change the test case for first course");
				operation.delete(secondCourse.getId());
			}
		}
	}

	
}
