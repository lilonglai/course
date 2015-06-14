package com.kevin.course.test.db.jpa;


import com.kevin.course.object.SecondCourse;
import com.kevin.course.operation.db.ISecondCourseOperation;
import com.kevin.course.test.db.utils.ApplicationContextUtils;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;

import java.util.List;

public  class SecondCourseOperationTest extends TestCase{
	ISecondCourseOperation operation;
	public SecondCourseOperationTest(){
		ApplicationContext context = ApplicationContextUtils.getJpaInstance();
		operation = (ISecondCourseOperation)context.getBean("jpaSecondCourseDao");
	}
	public void tetGet(){
		SecondCourse secondCourse = operation.get(1);
	}
	
	public void testGetByFirstCourseId(){
		List<SecondCourse> list = operation.getByFirstCourseId(1);
	}
	
	public void testGetByGrade(){
		List<SecondCourse> list = operation.getByGrade(1);
		
		list = operation.getByGrade(2);
		
		list = operation.getByGrade(3);
	}
	
	public void testGetAll(){
		List<SecondCourse> list =  operation.getAll();
	}
	
	
	public void testAdd(){
		SecondCourse secondCourse = new SecondCourse();
		
		secondCourse.setName("test");
		secondCourse.setShortName("test");
		secondCourse.setDescription(" this is the test case for second course");
		secondCourse.setFirstCourseId(1);
		operation.add(secondCourse);
	}
	
	public void testUpdate(){
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
