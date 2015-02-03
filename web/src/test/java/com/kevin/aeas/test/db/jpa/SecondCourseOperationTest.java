package com.kevin.aeas.test.db.jpa;


import java.util.ArrayList;

import com.kevin.aeas.object.SecondCourse;
import com.kevin.aeas.operation.db.jpa.JpaSecondCourseOperation;
import com.kevin.aeas.test.db.utils.DbUtils;

import junit.framework.TestCase;

public abstract class SecondCourseOperationTest extends TestCase{
	public void tetGet(){
		JpaSecondCourseOperation operation = new JpaSecondCourseOperation();
		SecondCourse secondCourse = (SecondCourse) operation.get(1);
	}
	
	public void testGetByFirstCourseId(){
		JpaSecondCourseOperation operation = new JpaSecondCourseOperation();
		ArrayList<SecondCourse> list = (ArrayList<SecondCourse>) operation.getByFirstCourseId(1);
	}
	
	public void testGetByGrade(){
		JpaSecondCourseOperation operation = new JpaSecondCourseOperation();
		ArrayList<SecondCourse> list = (ArrayList<SecondCourse>) operation.getByGrade(1);
		
		list = (ArrayList<SecondCourse>) operation.getByGrade(2);
		
		list = (ArrayList<SecondCourse>) operation.getByGrade(3);
	}
	
	public void testGetAll(){
		JpaSecondCourseOperation operation = new JpaSecondCourseOperation();
		ArrayList<SecondCourse> list = (ArrayList<SecondCourse>) operation.getAll();
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
		ArrayList<SecondCourse> list = (ArrayList<SecondCourse>) operation.getAll();
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
		ArrayList<SecondCourse> list = (ArrayList<SecondCourse>) operation.getAll();
		for(SecondCourse secondCourse: list){
			if(secondCourse.getName().equals("test")){
				secondCourse.setShortName("test 2");
				secondCourse.setDescription("change the test case for first course");
				operation.delete(secondCourse.getId());
			}
		}
	}
	
	protected void setUp() throws Exception{
		DbUtils.resetJpaManager();
	}
	
}
