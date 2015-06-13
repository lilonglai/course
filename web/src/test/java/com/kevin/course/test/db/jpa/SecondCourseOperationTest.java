package com.kevin.course.test.db.jpa;


import com.kevin.course.object.SecondCourse;
import com.kevin.course.operation.db.jpa.JpaSecondCourseOperation;
import junit.framework.TestCase;

import java.util.List;

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
