package com.kevin.aeas.test.db.mybatis;


import com.kevin.aeas.object.SecondCourse;
import com.kevin.aeas.operation.db.mybatis.MyBatisSecondCourseOperation;
import junit.framework.TestCase;

import java.util.List;

public class SecondCourseOperationTest extends TestCase{
	public void tetGet(){
        MyBatisSecondCourseOperation operation = new MyBatisSecondCourseOperation();
		SecondCourse secondCourse = operation.get(1);
	}
	
	public void testGetByFirstCourseId(){
        MyBatisSecondCourseOperation operation = new MyBatisSecondCourseOperation();
		List<SecondCourse> list = operation.getByFirstCourseId(1);
	}
	
	public void testGetByGrade(){
        MyBatisSecondCourseOperation operation = new MyBatisSecondCourseOperation();
		List<SecondCourse> list = operation.getByGrade(1);
		
		list = operation.getByGrade(2);
		
		list = operation.getByGrade(3);
	}
	
	public void testGetAll(){
        MyBatisSecondCourseOperation operation = new MyBatisSecondCourseOperation();
		List<SecondCourse> list = operation.getAll();
	}
	
	
	public void testAdd(){
        MyBatisSecondCourseOperation operation = new MyBatisSecondCourseOperation();
		SecondCourse secondCourse = new SecondCourse();
		
		secondCourse.setName("test");
		secondCourse.setShortName("test");
		secondCourse.setDescription(" this is the test case for second course");
		secondCourse.setFirstCourseId(1);
		operation.add(secondCourse);
	}
	
	public void testUpdate(){
        MyBatisSecondCourseOperation operation = new MyBatisSecondCourseOperation();
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
        MyBatisSecondCourseOperation operation = new MyBatisSecondCourseOperation();
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
