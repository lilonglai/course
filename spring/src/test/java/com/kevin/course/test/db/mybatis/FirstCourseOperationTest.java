package com.kevin.course.test.db.mybatis;

import com.kevin.course.object.FirstCourse;
import com.kevin.course.operation.db.IFirstCourseOperation;
import com.kevin.course.test.db.utils.ApplicationContextUtils;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;

import java.util.List;


public class FirstCourseOperationTest extends TestCase{
	IFirstCourseOperation operation;
	public FirstCourseOperationTest(){
		ApplicationContext context = ApplicationContextUtils.getMybatisInstance();
		operation = (IFirstCourseOperation)context.getBean("myBatisFirstCourseDao");
	}
	public void  testGet(){
		FirstCourse firstCourse = operation.get(1);
	}
	
	
	public void testGetByGrade(){
		List<FirstCourse> list = operation.getByGrade(1);
	}
	
	public void testGetAll(){
		List<FirstCourse> list = operation.getAll();
	}
	
	
	public void  testAdd(){
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
		List<FirstCourse> list = operation.getAll();
		for(FirstCourse firstCourse: list){
			if(firstCourse.getName().equals("test")){
				firstCourse.setShortName("test 2");
				firstCourse.setDescription("change the test case for first course");
				operation.delete(firstCourse.getId());
			}
		}
	}

    protected void setUp() throws Exception{
        super.setUp();
    }
}
